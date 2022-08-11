package com.dropbox.core.examples.android

import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.http.OkHttp3Requestor

object DbxRequestConfigFactory {
    private var sDbxRequestConfig: DbxRequestConfig? = null

    val requestConfig: DbxRequestConfig
        get() {
            if (sDbxRequestConfig == null) {
                sDbxRequestConfig = DbxRequestConfig.newBuilder("examples-v2-demo")
                    .withHttpRequestor(OkHttp3Requestor(OkHttp3Requestor.defaultOkHttpClient()))
                    .build()
            }
            return sDbxRequestConfig!!
        }
}