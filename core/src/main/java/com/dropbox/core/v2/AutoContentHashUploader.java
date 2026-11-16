package com.dropbox.core.v2;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.DropboxContentHasher;
import com.dropbox.core.util.IOUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Closeable;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/** Defers opening an upload until its input is available for hashing. */
final class AutoContentHashUploader extends HttpRequestor.Uploader {
    private final HttpRequestor requestor;
    private final String uri;
    private final List<HttpRequestor.Header> headers;
    private HttpRequestor.Uploader delegate;
    private boolean closed;
    private OutputStream body;
    private boolean finished;

    AutoContentHashUploader(HttpRequestor requestor, String uri, List<HttpRequestor.Header> headers) {
        this.requestor = requestor;
        this.uri = uri;
        this.headers = new ArrayList<>(headers);
    }

    static boolean needsContentHash(String path, String json) throws IOException {
        // files.stone defines these hashes over the bytes uploaded in this call. Append batch
        // uses one hash over the concatenated payload, not one hash per entry. Legacy append
        // has no content_hash argument. See https://github.com/dropbox/dropbox-api-spec/blob/main/files.stone.
        switch (path) {
            case "2/files/upload":
            case "2/files/upload_session/start":
            case "2/files/upload_session/append_v2":
            case "2/files/upload_session/append_batch":
            case "2/files/upload_session/finish":
                break;
            default:
                return false;
        }
        // Generated upload argument types are package-private. Inspect their serialized form
        // instead of using reflection or modifying generated code.
        try (JsonParser parser = new JsonFactory().createParser(json)) {
            if (parser.nextToken() != JsonToken.START_OBJECT) {
                return false;
            }
            while (parser.nextToken() == JsonToken.FIELD_NAME) {
                String field = parser.currentName();
                parser.nextToken();
                if ("content_hash".equals(field)) {
                    return false; // Preserve any explicit value.
                }
                parser.skipChildren();
            }
        }
        return true;
    }

    private HttpRequestor.Uploader start() throws IOException {
        if (closed || finished) {
            throw new IOException("This uploader is already closed or finished.");
        }
        if (delegate == null) {
            try {
                delegate = requestor.startPostInStreamingMode(uri, headers);
                delegate.setProgressListener(progressListener);
            } catch (IOException | RuntimeException ex) {
                // Never retry initialization implicitly on a later write, flush, or close.
                try {
                    close();
                } catch (RuntimeException cleanup) {
                    ex.addSuppressed(cleanup);
                }
                throw ex;
            }
        }
        return delegate;
    }

    private void addContentHash(String hash) throws IOException {
        for (int i = 0; i < headers.size(); i++) {
            HttpRequestor.Header header = headers.get(i);
            if ("Dropbox-API-Arg".equals(header.getKey())) {
                StringWriter json = new StringWriter();
                JsonFactory factory = new JsonFactory();
                try (JsonParser parser = factory.createParser(header.getValue());
                     JsonGenerator generator = factory.createGenerator(json)) {
                    // Keep non-ASCII and DEL escaped, just like DbxRawClientV2.headerSafeJson.
                    generator.setHighestNonEscapedChar(0x7e);
                    parser.nextToken(); // Object already validated by needsContentHash.
                    generator.writeStartObject();
                    while (parser.nextToken() == JsonToken.FIELD_NAME) {
                        generator.copyCurrentStructure(parser);
                    }
                    generator.writeStringField("content_hash", hash);
                    generator.writeEndObject();
                }
                headers.set(i, new HttpRequestor.Header(header.getKey(), json.toString()));
                return;
            }
        }
    }

    private void prepare(InputStream in, long limit) throws IOException {
        if (closed || finished) {
            throw new IOException("This uploader is already closed or finished.");
        }
        if (delegate != null || body != null) {
            return;
        }
        // markSupported alone is insufficient: buffered streams can invalidate a mark, or
        // retain an entire large upload in memory. Only use known rewindable inputs.
        if (in instanceof FileInputStream) {
            FileChannel channel = ((FileInputStream) in).getChannel();
            long position;
            try {
                position = channel.position();
            } catch (IOException ex) {
                return; // Not every file descriptor is seekable (e.g. a pipe).
            }
            String hash;
            // try-with-resources preserves the read failure if rewinding also fails.
            try (Closeable rewind = () -> channel.position(position)) {
                hash = DropboxContentHasher.hashHex(IOUtil.limit(in, limit));
            }
            addContentHash(hash);
        } else if (in instanceof ByteArrayInputStream) {
            int remaining = in.available();
            String hash;
            try {
                hash = DropboxContentHasher.hashHex(IOUtil.limit(in, limit));
            } finally {
                // Rewind relative to the caller's existing mark without overwriting it.
                in.reset();
                in.skip(in.available() - remaining);
            }
            addContentHash(hash);
        }
    }

    @Override
    public void upload(File file) throws IOException {
        try (FileInputStream input = new FileInputStream(file)) {
            try {
                upload(input);
            } catch (IOUtil.ReadException | IOUtil.WriteException ex) {
                // Unwrap before closing so any close failure is suppressed on the exposed cause.
                throw ex.getCause();
            }
        }
    }

    @Override
    public void upload(InputStream in) throws IOException {
        prepareForUpload(in, Long.MAX_VALUE);
        start().upload(in);
    }

    private void prepareForUpload(InputStream in, long limit) throws IOException {
        try {
            prepare(in, limit);
        } catch (IOException ex) {
            throw new IOUtil.ReadException("auto content_hash", ex);
        }
    }

    @Override
    public void upload(InputStream in, long limit) throws IOException {
        prepareForUpload(in, limit);
        start().upload(in, limit);
    }

    @Override
    public void upload(byte[] body) throws IOException {
        upload(new ByteArrayInputStream(body));
    }

    @Override
    public OutputStream getBody() {
        if (closed || finished) {
            throw new IllegalStateException("This uploader is already closed or finished.");
        }
        if (body != null) {
            return body;
        }
        // getBody cannot throw IOException. Open the connection on the first stream operation.
        body = new OutputStream() {
            private OutputStream output;
            private boolean streamClosed;

            private OutputStream output() throws IOException {
                if (streamClosed) {
                    throw new IOException("Upload body is already closed.");
                }
                HttpRequestor.Uploader uploader = start();
                if (output == null) {
                    try {
                        output = java.util.Objects.requireNonNull(uploader.getBody(), "upload body");
                    } catch (RuntimeException ex) {
                        try {
                            AutoContentHashUploader.this.close();
                        } catch (RuntimeException cleanup) {
                            ex.addSuppressed(cleanup);
                        }
                        throw ex;
                    }
                }
                return output;
            }

            @Override
            public void write(int value) throws IOException {
                output().write(value);
            }

            @Override
            public void write(byte[] bytes, int offset, int length) throws IOException {
                output().write(bytes, offset, length);
            }

            @Override
            public void flush() throws IOException {
                output().flush();
            }

            @Override
            public void close() throws IOException {
                if (streamClosed) {
                    return;
                }
                try {
                    // Do not open or retry a connection after abort/close/initialization failure.
                    if (!closed && output != null) {
                        output.close();
                    } else if (!closed && !finished) {
                        output().close();
                    }
                } catch (IOException | RuntimeException ex) {
                    try {
                        AutoContentHashUploader.this.close();
                    } catch (RuntimeException cleanup) {
                        ex.addSuppressed(cleanup);
                    }
                    throw ex;
                } finally {
                    streamClosed = true;
                }
            }
        };
        return body;
    }

    @Override
    public HttpRequestor.Response finish() throws IOException {
        HttpRequestor.Uploader uploader = start();
        try {
            // Keep a successful response alive until DbxUploader consumes it and the caller
            // closes this uploader. Custom requestors may close the response in close().
            return uploader.finish();
        } catch (IOException | RuntimeException ex) {
            try {
                close();
            } catch (RuntimeException cleanup) {
                ex.addSuppressed(cleanup);
            }
            throw ex;
        } finally {
            finished = true;
        }
    }

    @Override
    public void close() {
        if (!closed) {
            // Cleanup is terminal even when the custom requestor throws: never retry it.
            closed = true;
            finished = true;
            if (delegate != null) {
                delegate.close();
            }
        }
    }

    @Override
    public void abort() {
        if (!closed) {
            if (!finished && delegate != null) {
                finished = true;
                try {
                    delegate.abort();
                } catch (RuntimeException ex) {
                    try {
                        close();
                    } catch (RuntimeException cleanup) {
                        ex.addSuppressed(cleanup);
                    }
                    throw ex;
                }
            }
            close();
        }
    }

    @Override
    public void setProgressListener(IOUtil.ProgressListener listener) {
        super.setProgressListener(listener);
        if (delegate != null) {
            delegate.setProgressListener(listener);
        }
    }
}
