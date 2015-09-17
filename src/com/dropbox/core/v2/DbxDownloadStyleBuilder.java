package com.dropbox.core.v2;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxStreamReader;
import com.dropbox.core.NoThrowInputStream;
import com.dropbox.core.util.IOUtil;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The common interface for all builders associated with upload style
 * methods. Use the {@link #start} method to get a {@link DbxDownloader}
 * object, use {@link #run(DbxStreamReader)} for a callback style or
 * use {@link #run(OutputStream)} to directly copy the downloaded data
 * to an output stream.
 *
 * @param <R> The return type of the {@link DbxDownloader}
 */
public abstract class DbxDownloadStyleBuilder<R>
{

    public abstract DbxDownloader<R> start() throws DbxException;

    public R run(OutputStream out) throws DbxException, IOException
    {
        DbxDownloader<R> downloader = null;
        try {
            downloader = start();
            IOUtil.copyStreamToStream(downloader.body, out);
            return downloader.result;
        } finally {
            if (downloader != null) {
                downloader.close();
            }
        }
    }

    public<X extends Throwable> R run(DbxStreamReader<X> handler) throws DbxException, X, IOException
    {
        DbxDownloader<R> downloader = null;
        try {
            downloader = start();
            NoThrowInputStream noThrow = new NoThrowInputStream(downloader.body);
            handler.read(noThrow);
            return downloader.result;
        } catch (NoThrowInputStream.HiddenException ex) {
            throw new DbxException.NetworkIO(ex.underlying);
        } finally {
            if (downloader != null) {
                downloader.close();
            }
        }
    }

}
