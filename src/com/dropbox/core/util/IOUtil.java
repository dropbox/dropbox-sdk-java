package com.dropbox.core.util;

import java.io.*;

public class IOUtil
{
    public static final int DefaultCopyBufferSize = 16 * 1024;

    public static void copyStreamToStream(InputStream in, OutputStream out)
        throws ReadException, WriteException
    {
        copyStreamToStream(in, out, DefaultCopyBufferSize);
    }

    public static void copyStreamToStream(InputStream in, OutputStream out, byte[] copyBuffer)
            throws ReadException, WriteException
    {
        while (true) {
            int count;
            try {
                count = in.read(copyBuffer);
            }
            catch (IOException ex) {
                throw new ReadException(ex);
            }

            if (count == -1) break;

            try {
                out.write(copyBuffer, 0, count);
            }
            catch (IOException ex) {
                throw new WriteException(ex);
            }
        }
    }

    public static void copyStreamToStream(InputStream in, OutputStream out, int copyBufferSize)
        throws ReadException, WriteException
    {
        copyStreamToStream(in, out, new byte[copyBufferSize]);
    }

    private static final ThreadLocal<byte[]> slurpBuffer = new ThreadLocal<byte[]>() {
        protected byte[] initialValue() { return new byte[4096]; }
    };

    public static byte[] slurp(InputStream in, int byteLimit)
        throws IOException
    {
        if (byteLimit < 0) throw new RuntimeException("'byteLimit' must be non-negative: " + byteLimit);

        byte[] copyBuffer = slurpBuffer.get();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        copyStreamToStream(in, baos, copyBuffer);
        return baos.toByteArray();
    }

    public void copyFileToStream(File fin, OutputStream out)
        throws ReadException, WriteException
    {
        copyFileToStream(fin, out, DefaultCopyBufferSize);
    }

    public void copyFileToStream(File fin, OutputStream out, int copyBufferSize)
        throws ReadException, WriteException
    {
        FileInputStream in;
        try {
            in = new FileInputStream(fin);
        }
        catch (IOException ex) {
            throw new ReadException(ex);
        }

        try {
            copyStreamToStream(in, out, copyBufferSize);
        }
        finally {
            closeInput(in);
        }
    }

    public void copyStreamToFile(InputStream in, File fout)
        throws ReadException, WriteException
    {
        copyStreamToFile(in, fout, DefaultCopyBufferSize);
    }

    public void copyStreamToFile(InputStream in, File fout, int copyBufferSize)
        throws ReadException, WriteException
    {
        FileOutputStream out;
        try {
            out = new FileOutputStream(fout);
        }
        catch (IOException ex) {
            throw new WriteException(ex);
        }

        try {
            copyStreamToStream(in, out, copyBufferSize);
        }
        finally {
            try { out.close(); } catch (IOException ex) {
                //noinspection ThrowFromFinallyBlock
                throw new WriteException(ex);
            }
        }
    }

    /**
     * Closes the given input stream and ignores the IOException.
     */
    public static void closeInput(InputStream in)
    {
        try {
            in.close();
        }
        catch (IOException ex) {
            // Ignore.  We're done reading from it so we don't care if there are input errors.
        }
    }

    /**
     * Closes the given Reader and ignores the IOException.
     */
    public static void closeInput(Reader in)
    {
        try {
            in.close();
        }
        catch (IOException ex) {
            // Ignore.  We're done reading from it so we don't care if there are input errors.
        }
    }

    public static abstract class WrappedException extends IOException
    {
		public static final long serialVersionUID = 0;

        public final IOException underlying;

        public WrappedException(String message, IOException underlying)
        {
            super(message + ": " + underlying.getMessage(), underlying);
            this.underlying = underlying;
        }

        public WrappedException(IOException underlying)
        {
            super(underlying);
            this.underlying = underlying;
        }

        @Override
        public String getMessage()
        {
            String m = underlying.getMessage();
            if (m == null) return "";
            else return m;
        }

        @Override
        public IOException getCause()
        {
            return underlying;
        }
    }

    public static final class ReadException extends WrappedException
    {
        public ReadException(String message, IOException underlying)
        {
            super(message, underlying);
        }

        public ReadException(IOException underlying)
        {
            super(underlying);
        }
        
		public static final long serialVersionUID = 0;
    }

    public static final class WriteException extends WrappedException
    {
        public WriteException(String message, IOException underlying)
        {
            super(message, underlying);
        }

        public WriteException(IOException underlying)
        {
            super(underlying);
        }
        
		public static final long serialVersionUID = 0;
    }

    public static final InputStream EmptyInputStream = new InputStream()
    {
        public int read() { return -1; }
        public int read(byte[] data) { return -1; }
        public int read(byte[] data, int off, int len) { return -1; }
    };

    public static final OutputStream BlackHoleOutputStream = new OutputStream()
    {
        public void write(int b) {}
        public void write(byte[] data) {}
        public void write(byte[] data, int off, int len) {}
    };
}
