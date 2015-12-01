package com.dropbox.core;

import com.dropbox.core.util.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A callback for streaming data from an {@link InputStream}.
 *
 * @param <E>
 *     The type of exception that your {@link #read} implementation might throw
 *     If your {@code read} implementation won't throw any checked exceptions,
 *     you should use {@link RuntimeException} for this parameter.
 */
public abstract class DbxStreamReader<E extends Throwable>
{
    /**
     * Write all the data you plan to write to {@code in}.  Do not
     * call {@link InputStream#close close()} on the stream (the stream will
     * be closed automatically).
     */
    public abstract void read(NoThrowInputStream in) throws E;

    /**
     * A {@link DbxStreamReader} that gets its source data from the given {@code OutputStream}.
     * The {@code OutputStream} will be closed automatically.
     */
    public static final class OutputStreamCopier extends DbxStreamReader<IOException>
    {
        private final OutputStream dest;

        public OutputStreamCopier(OutputStream dest)
        {
            this.dest = dest;
        }

        public void read(NoThrowInputStream source) throws IOException
        {
            IOUtil.copyStreamToStream(source, dest);
        }
    }

    public static final class ByteArrayCopier extends DbxStreamReader<RuntimeException>
    {
        private final byte[] data;
        private final int offset;
        private final int length;

        public ByteArrayCopier(byte[] data, int offset, int length)
        {
            if (data == null) throw new IllegalArgumentException("'data' can't be null");
            if (offset < 0 || offset >= data.length) throw new IllegalArgumentException("'offset' is out of bounds");
            if ((offset + length) < offset || (offset + length) > data.length) throw new IllegalArgumentException("'offset+length' is out of bounds");
            this.data = data;
            this.offset = offset;
            this.length = length;
        }

        public ByteArrayCopier(byte[] data)
        {
            this(data, 0, data.length);
        }

        @Override
        public void read(NoThrowInputStream in)
        {
            in.read(this.data, this.offset, this.length);
        }
    }
}
