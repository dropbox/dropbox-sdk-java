package com.dropbox.core;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Wraps an existing output stream, converting all the underlying stream's {@code IOException}s
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
public final class NoThrowOutputStream extends OutputStream
{
    private final OutputStream underlying;
    private long bytesWritten = 0;

    public NoThrowOutputStream(OutputStream underlying)
    {
        this.underlying = underlying;
    }

    @Override
    public void close()
    {
        throw new UnsupportedOperationException("don't call close()");
    }

    @Override
    public void flush()
    {
        try {
            underlying.flush();
        }
        catch (IOException ex) {
            throw new HiddenException(this, ex);
        }
    }

    @Override
    public void write(byte[] b, int off, int len)
    {
        try {
            bytesWritten += len;
            underlying.write(b, off, len);
        }
        catch (IOException ex) {
            throw new HiddenException(this, ex);
        }
    }

    @Override
    public void write(byte[] b)
    {
        try {
            bytesWritten += b.length;
            underlying.write(b);
        }
        catch (IOException ex) {
            throw new HiddenException(this, ex);
        }
    }

    @Override
    public void write(int b)
    {
        try {
            bytesWritten += 1;
            underlying.write(b);
        }
        catch (IOException ex) {
            throw new HiddenException(this, ex);
        }
    }

    public static final class HiddenException extends RuntimeException
    {
        public final NoThrowOutputStream owner;

        public HiddenException(NoThrowOutputStream owner, IOException underlying)
        {
            super(underlying);
            this.owner = owner;
        }

        @Override
        public IOException getCause()
        {
            return (IOException) super.getCause();
        }

        public static final long serialVersionUID = 0;
    }

    public long getBytesWritten()
    {
        return bytesWritten;
    }
}
