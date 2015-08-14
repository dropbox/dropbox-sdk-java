package com.dropbox.core;

import com.dropbox.core.util.IOUtil;

import java.io.InputStream;

public class DbxDownloader<R> {
    public final R result;
    public final InputStream body;

    public DbxDownloader(R result, InputStream body) {
        this.result = result;
        this.body = body;
    }

    public void close()
    {
        IOUtil.closeInput(body);
    }
}
