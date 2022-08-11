package com.dropbox.core.examples.android

import android.content.Context
import com.dropbox.core.v2.DbxClientV2
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

/**
 * Singleton instance of Picasso pre-configured
 */
object PicassoClient {
    private var _picasso: Picasso? = null

    val picasso: Picasso = _picasso!!

    fun init(context: Context?, dbxClient: DbxClientV2) {

        // Configure picasso to know about special thumbnail requests
        _picasso = Picasso.Builder(context!!)
            .downloader(OkHttp3Downloader(context))
            .addRequestHandler(FileThumbnailRequestHandler(dbxClient))
            .build()
    }
}