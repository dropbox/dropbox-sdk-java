package com.dropbox.core.examples.android;

import android.content.Context;

import com.dropbox.core.v2.DbxFiles;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Singleton instance of Picasso pre-configured
 */
public class PicassoClient {
    private static Picasso sPicasso;

    public static void init(Context context, DbxFiles files) {

        // Configure picasso to know about special thumbnail requests
        sPicasso = new Picasso.Builder(context)
                .downloader(new OkHttpDownloader(context))
                .addRequestHandler(new FileThumbnailRequestHandler(files))
                .build();
    }


    public static Picasso getPicasso() {
        return sPicasso;
    }
}
