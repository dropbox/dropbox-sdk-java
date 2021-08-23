package com.dropbox.core.util;

import java.io.ByteArrayOutputStream;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.CharacterCodingException;

public class IOUtil {
    public static final int DEFAULT_COPY_BUFFER_SIZE = 16 << 10; // 16 KiB

    public static Reader utf8Reader(InputStream in) {
        // NOTE: Just passing StringUtil.UTF8 instead of StringUtil.UTF8.newDecoder() would be wrong.
        // The former will cause the InputStreamReader to ignore UTF-8 errors in the input.
        return new InputStreamReader(in, StringUtil.UTF8.newDecoder());
    }

    public static Writer utf8Writer(OutputStream out) {
        return new OutputStreamWriter(out, StringUtil.UTF8.newEncoder());
    }

    public static String toUtf8String(InputStream in) throws ReadException, CharacterCodingException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            copyStreamToStream(in, out);
        } catch (WriteException ex) {
            throw new RuntimeException("impossible", ex);
        }
        return StringUtil.utf8ToString(out.toByteArray());
    }

    public static void copyStreamToStream(InputStream in, OutputStream out) throws ReadException, WriteException {
        copyStreamToStream(in, out, DEFAULT_COPY_BUFFER_SIZE);
    }

    public static void copyStreamToStream(InputStream in, OutputStream out, byte[] copyBuffer)
        throws ReadException, WriteException {
        while (true) {
            int count;
            try {
                count = in.read(copyBuffer);
            } catch (IOException ex) {
                throw new ReadException(ex);
            }

            if (count == -1) break;

            try {
                out.write(copyBuffer, 0, count);
            } catch (IOException ex) {
                throw new WriteException(ex);
            }
        }
    }

    public static void copyStreamToStream(InputStream in, OutputStream out, int copyBufferSize)
        throws ReadException, WriteException {
        copyStreamToStream(in, out, new byte[copyBufferSize]);
    }

    public static byte[] slurp(InputStream in, int byteLimit) throws IOException {
        return slurp(in, byteLimit, new byte[DEFAULT_COPY_BUFFER_SIZE]);
    }

    public static byte[] slurp(InputStream in, int byteLimit, byte[] slurpBuffer) throws IOException {
        if (byteLimit < 0) throw new RuntimeException("'byteLimit' must be non-negative: " + byteLimit);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        copyStreamToStream(in, baos, slurpBuffer);
        return baos.toByteArray();
    }

    public void copyFileToStream(File fin, OutputStream out) throws ReadException, WriteException {
        copyFileToStream(fin, out, DEFAULT_COPY_BUFFER_SIZE);
    }

    public void copyFileToStream(File fin, OutputStream out, int copyBufferSize) throws ReadException, WriteException {
        FileInputStream in;
        try {
            in = new FileInputStream(fin);
        } catch (IOException ex) {
            throw new ReadException(ex);
        }

        try {
            copyStreamToStream(in, out, copyBufferSize);
        } finally {
            closeInput(in);
        }
    }

    public void copyStreamToFile(InputStream in, File fout) throws ReadException, WriteException {
        copyStreamToFile(in, fout, DEFAULT_COPY_BUFFER_SIZE);
    }

    public void copyStreamToFile(InputStream in, File fout, int copyBufferSize) throws ReadException, WriteException {
        FileOutputStream out;
        try {
            out = new FileOutputStream(fout);
        } catch (IOException ex) {
            throw new WriteException(ex);
        }

        try {
            copyStreamToStream(in, out, copyBufferSize);
        } finally {
            try { out.close(); } catch (IOException ex) {
                //noinspection ThrowFromFinallyBlock
                throw new WriteException(ex);
            }
        }
    }

    /**
     * Closes the given input stream and ignores the IOException.
     */
    public static void closeInput(InputStream in) {
        try {
            in.close();
        } catch (IOException ex) {
            // Ignore.  We're done reading from it so we don't care if there are input errors.
        }
    }

    /**
     * Closes the given Reader and ignores the IOException.
     */
    public static void closeInput(Reader in) {
        try {
            in.close();
        } catch (IOException ex) {
            // Ignore.  We're done reading from it so we don't care if there are input errors.
        }
    }

    public static void closeQuietly(Closeable obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (IOException ex) {
                // Ignore
            }
        }
    }

    public static InputStream limit(InputStream in, long limit) {
        return new LimitInputStream(in, limit);
    }

    public static abstract class WrappedException extends IOException {
        private static final long serialVersionUID = 0;

        public WrappedException(String message, IOException underlying) {
            super(message + ": " + underlying.getMessage(), underlying);
        }

        public WrappedException(IOException underlying) {
            super(underlying);
        }

        @Override
        public IOException getCause() {
            return (IOException) super.getCause();
        }

        @Override
        public String getMessage() {
            String m = super.getCause().getMessage();
            if (m == null) return "";
            else return m;
        }
    }

    public static final class ReadException extends WrappedException {
        private static final long serialVersionUID = 0;

        public ReadException(String message, IOException underlying) {
            super(message, underlying);
        }

        public ReadException(IOException underlying) {
            super(underlying);
        }
    }

    public static final class WriteException extends WrappedException {
        private static final long serialVersionUID = 0;

        public WriteException(String message, IOException underlying) {
            super(message, underlying);
        }

        public WriteException(IOException underlying) {
            super(underlying);
        }
    }

    public static final InputStream EmptyInputStream = new InputStream() {
        public int read() { return -1; }
        public int read(byte[] data) { return -1; }
        public int read(byte[] data, int off, int len) { return -1; }
    };

    public static final OutputStream BlackHoleOutputStream = new OutputStream() {
        public void write(int b) {}
        public void write(byte[] data) {}
        public void write(byte[] data, int off, int len) {}
    };

    /**
     * {@link InputStream} that limits the amount of bytes read from its underlying {@code
     * InputStream}.
     */
    private static final class LimitInputStream extends FilterInputStream {
        private long left;

        public LimitInputStream(InputStream in, long limit) {
            super(in);

            if (in == null) {
                throw new NullPointerException("in");
            }

            if (limit < 0) {
                throw new IllegalArgumentException("limit must be non-negative");
            }

            this.left = limit;
        }

        @Override
        public int available() throws IOException {
            return (int) Math.min(in.available(), left);
        }

        @Override
        public synchronized void reset() throws IOException {
            throw new IOException("mark not supported");
        }

        @Override
        public boolean markSupported() {
            return false;
        }

        @Override
        public int read() throws IOException {
            if (left == 0) {
                return -1;
            }

            int read = in.read();
            if (read != -1) {
                --left;
            }

            return read;
        }

        @Override
        public int read(byte [] b, int off, int len) throws IOException {
            if (left == 0) {
                return -1;
            }

            len = (int) Math.min(len, left);
            int read = in.read(b, off, len);

            if (read != -1) {
                left -= read;
            }

            return read;
        }

        @Override
        public long skip(long n) throws IOException {
            n = Math.min(n, left);
            long skipped = in.skip(n);
            left -= skipped;
            return skipped;
        }
    }

    public interface ProgressListener {
        void onProgress(long bytesWritten);
    }
}
