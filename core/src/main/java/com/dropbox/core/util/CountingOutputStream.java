package com.dropbox.core.util;

import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends OutputStream
{
    private final OutputStream out;
    private long bytesWritten = 0;

    public CountingOutputStream(OutputStream out)
    {
        this.out = out;
    }

    public long getBytesWritten()
    {
        return bytesWritten;
    }

    @Override
    public void write(int b) throws IOException
    {
        bytesWritten++;
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        bytesWritten += b.length;
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        bytesWritten += len;
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException
    {
        out.flush();
    }

    @Override
    public void close() throws IOException
    {
        throw new UnsupportedOperationException("You aren't allowed to call close() on this object.");
    }
}
