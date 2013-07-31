package com.dropbox.core;

import com.dropbox.core.util.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A callback for streaming data to an {@link OutputStream}, usually
 * in the context of an API request being made by {@link DbxClient}.
 *
 * @param <E>
 *     The type of exception that your {@link #write} implementation might throw
 *     If your {@code write} implementation won't throw any checked exceptions,
 *     you should use {@link RuntimeException} for this parameter.
 */
public abstract class DbxStreamWriter<E extends Throwable>
{
    /**
     * Write all the data you plan to write to {@code out}.  Do not
     * call {@link OutputStream#close close()} on the stream (the stream will
     * be closed automatically).
     */
    public abstract void write(NoThrowOutputStream out) throws E;

    /**
     * A {@link DbxStreamWriter} that gets its source data from the given {@code InputStream}.
     * The {@code InputStream} will be closed automatically.
     */
    public static final class InputStreamCopier extends DbxStreamWriter<IOException>
    {
        private final InputStream source;

        public InputStreamCopier(InputStream source)
        {
            this.source = source;
        }

        public void write(NoThrowOutputStream out) throws IOException
        {
            IOUtil.copyStreamToStream(source, out);
        }
    }

    public static final class ByteArrayCopier extends DbxStreamWriter<RuntimeException>
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
        public void write(NoThrowOutputStream out)
        {
            out.write(this.data, this.offset, this.length);
        }
    }
}
