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
     * Called when we're done with this object.  This will be called even if
     * the overall action fails so you have an opportunity to clean up resources.
     *
     * <p>
     * For example, {@link DbxClient#uploadFile} will call {@code close()} whether
     * the upload succeeds or not.  {@link InputStreamCopier} uses
     * this method to close the underlying {@code InputStream}.
     * </p>
     */
    public abstract void close();

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

        public void close()
        {
            try {
                source.close();
            }
            catch (IOException ex) {
                // Ignore the I/O exception; we already got the data we wanted.
            }
        }
    }
}
