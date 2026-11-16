package com.dropbox.core.v2;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.DropboxContentHasher;
import com.dropbox.core.util.IOUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    private boolean bodyRequested;

    AutoContentHashUploader(HttpRequestor requestor, String uri, List<HttpRequestor.Header> headers) {
        this.requestor = requestor;
        this.uri = uri;
        this.headers = new ArrayList<>(headers);
    }

    static boolean needsContentHash(String path, String json) throws IOException {
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
        if (closed) {
            throw new IOException("This uploader is already closed.");
        }
        if (delegate == null) {
            delegate = requestor.startPostInStreamingMode(uri, headers);
            delegate.setProgressListener(progressListener);
        }
        return delegate;
    }

    private void addContentHash(String hash) {
        for (int i = 0; i < headers.size(); i++) {
            HttpRequestor.Header header = headers.get(i);
            if ("Dropbox-API-Arg".equals(header.getKey())) {
                // Stone omits the null content_hash field. Preserve the rest of the serialized
                // argument, including header-safe escaping, without changing the caller's object.
                String json = header.getValue();
                String rest = json.substring(1);
                headers.set(i, new HttpRequestor.Header(header.getKey(),
                        "{\"content_hash\":\"" + hash + "\"" + ("}".equals(rest) ? "" : ",") + rest));
                return;
            }
        }
    }

    private void prepare(InputStream in, long limit) throws IOException {
        if (delegate != null || bodyRequested) {
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
            try {
                hash = DropboxContentHasher.hashHex(IOUtil.limit(in, limit));
            } finally {
                channel.position(position);
            }
            addContentHash(hash);
        } else if (in instanceof ByteArrayInputStream) {
            in.mark(0);
            String hash;
            try {
                hash = DropboxContentHasher.hashHex(IOUtil.limit(in, limit));
            } finally {
                in.reset();
            }
            addContentHash(hash);
        }
    }

    @Override
    public void upload(InputStream in) throws IOException {
        upload(in, Long.MAX_VALUE);
    }

    @Override
    public void upload(InputStream in, long limit) throws IOException {
        try {
            prepare(in, limit);
        } catch (IOException ex) {
            throw new IOUtil.ReadException("auto content_hash", ex);
        }
        start().upload(IOUtil.limit(in, limit));
    }

    @Override
    public void upload(byte[] body) throws IOException {
        upload(new ByteArrayInputStream(body));
    }

    @Override
    public OutputStream getBody() {
        bodyRequested = true;
        // getBody cannot throw IOException. Defer connection creation until a stream operation
        // (or finish), where connection failures can be reported through the normal I/O path.
        return new OutputStream() {
            @Override
            public void write(int value) throws IOException {
                start().getBody().write(value);
            }

            @Override
            public void write(byte[] bytes, int offset, int length) throws IOException {
                start().getBody().write(bytes, offset, length);
            }

            @Override
            public void flush() throws IOException {
                start().getBody().flush();
            }

            @Override
            public void close() throws IOException {
                start().getBody().close();
            }
        };
    }

    @Override
    public HttpRequestor.Response finish() throws IOException {
        return start().finish();
    }

    @Override
    public void close() {
        closed = true;
        if (delegate != null) {
            delegate.close();
        }
    }

    @Override
    public void abort() {
        closed = true;
        if (delegate != null) {
            delegate.abort();
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
