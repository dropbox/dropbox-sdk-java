package com.dropbox.core.examples.android

import android.content.Context
import com.dropbox.core.v2.DbxClientV2
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

/**
 * Singleton instance of Picasso pre-configured
 */
class SamplePicassoClient(context: Context, dbxClient: DbxClientV2) {
    val picasso: Picasso =
        // Configure picasso to know about special thumbnail requests
        Picasso.Builder(context)
            .downloader(OkHttp3Downloader(context))
            .addRequestHandler(FileThumbnailRequestHandler(dbxClient))
            .build()
}
