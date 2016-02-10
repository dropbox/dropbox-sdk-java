package com.dropbox.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Wraps an existing input stream, converting all the underlying stream's {@code IOException}s
 * to our own {@link HiddenException}, which is a subclass of {@code RuntimeException}.  This
 * means that the methods don't have {@code IOException} in their {@code throws} clauses.
 *
 * <p>
 * NOTE: The name is slightly misleading in that these methods still might throw an
 * {@code IOException} wrapped in a {@code HiddenException}, just not an
 * {@code IOException} directly.
 * </p>
 *
 * <p>
 * Also, it does have {@code IOException} in the {@code throws} clause of {@link #close},
 * but you're not supposed to call that method.
 * </p>
 */
public final class NoThrowInputStream extends InputStream
{
    private final InputStream underlying;
    private long bytesRead = 0;

    public NoThrowInputStream(InputStream underlying)
    {
        this.underlying = underlying;
    }

    @Override
    public void close()
    {
        throw new UnsupportedOperationException("don't call close()");
    }

    @Override
    public int read()
    {
        try {
            bytesRead += 1;
            return underlying.read();
        }
        catch (IOException ex) {
            throw new HiddenException(ex);
        }
    }

    @Override
    public int read(byte[] b, int off, int len)
    {
        try {
            int bytesReadNow = underlying.read(b, off, len);
            this.bytesRead += bytesReadNow;
            return bytesReadNow;
        }
        catch (IOException ex) {
            throw new HiddenException(ex);
        }
    }

    @Override
    public int read(byte[] b)
    {
        try {
            int bytesReadNow = underlying.read(b);
            this.bytesRead += bytesReadNow;
            return bytesReadNow;
        }
        catch (IOException ex) {
            throw new HiddenException(ex);
        }
    }

    public static final class HiddenException extends RuntimeException
    {
        public final IOException underlying;

        public HiddenException(IOException underlying)
        {
            super(underlying);
            this.underlying = underlying;
        }

        public static final long serialVersionUID = 0;
    }

    public long getBytesRead()
    {
        return bytesRead;
    }
}
