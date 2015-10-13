package com.dropbox.core.examples.android;

import android.net.Uri;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.Files;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.squareup.picasso.RequestHandler;

import java.io.IOException;

/**
 * Example Picasso request handler that gets the thumbnail url for a dropbox path
 * Only handles urls like dropbox://dropbox/[path_to_file]
 * See {@link FilesAdapter} for usage
 */
public class FileThumbnailRequestHandler extends RequestHandler {

    private static final String SCHEME =  "dropbox";
    private static final String HOST = "dropbox";
    private final Files mFilesClient;

    public FileThumbnailRequestHandler(Files filesClient) {
        mFilesClient = filesClient;
    }

    /**
     * Builds a {@link Uri} for a Dropbox file thumbnail suitable for handling by this handler
     */
    public static Uri buildPicassoUri(Files.FileMetadata file) {
        return new Uri.Builder()
                .scheme(SCHEME)
                .authority(HOST)
                .path(file.pathLower).build();
    }

    @Override
    public boolean canHandleRequest(Request data) {
        return SCHEME.equals(data.uri.getScheme()) && HOST.equals(data.uri.getHost());
    }

    @Override
    public Result load(Request request, int networkPolicy) throws IOException {

        try {
            DbxDownloader<Files.FileMetadata> downloader =
                    mFilesClient.getThumbnailBuilder(request.uri.getPath())
                            .format(Files.ThumbnailFormat.jpeg)
                            .size(Files.ThumbnailSize.m)
                            .start();

            return new Result(downloader.body, Picasso.LoadedFrom.NETWORK);
        } catch (Files.GetThumbnailException e) {
            throw new IOException(e);
        } catch (DbxException e) {
            throw new IOException(e);
        }
    }
}
