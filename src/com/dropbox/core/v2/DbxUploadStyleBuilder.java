package com.dropbox.core.v2;

import com.dropbox.core.*;
import com.dropbox.core.util.IOUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * The common interface for all builders associated with download style
 * methods. Use the {@link #start} method to get a {@link DbxUploader}
 * object, use {@link #run(DbxStreamWriter)} for a callback style or
 * use {@link #run(InputStream)} to directly copy data from an input
 * stream.
 *
 * @param <R> The return type of the {@link DbxUploader}
 * @param <E> The error type of the {@link DbxUploader}
 * @param <X> The exception type of the {@link DbxUploader}
 */
public abstract class DbxUploadStyleBuilder<R,E,X extends Throwable>
{

    public abstract DbxUploader<R,E,X> start() throws DbxException;

    public R run(InputStream in) throws DbxException, X, IOException
    {
        DbxUploader<R,E,X> uploader = null;
        try {
            uploader = start();
            IOUtil.copyStreamToStream(in, uploader.getBody());
            return uploader.finish();
        } finally {
            if (uploader != null) {
                // This currently does nothing!
                uploader.close();
            }
        }
    }

    public<X2 extends Throwable> R run(DbxStreamWriter<X2> writer) throws DbxException, X, X2, IOException
    {
        DbxUploader<R,E,X> uploader = null;
        try {
            uploader = start();
            NoThrowOutputStream noThrow = new NoThrowOutputStream(uploader.getBody());
            writer.write(noThrow);
            return uploader.finish();
        } catch (NoThrowOutputStream.HiddenException ex) {
            throw new DbxException.NetworkIO(ex.underlying);
        } finally {
            if (uploader != null) {
                // This currently does nothing!
                uploader.close();
            }
        }
    }

}
