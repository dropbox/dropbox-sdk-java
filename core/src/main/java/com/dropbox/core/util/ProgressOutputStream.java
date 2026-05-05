package com.dropbox.core.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ProgressOutputStream extends OutputStream {
    private long completed;
    private @Nonnull OutputStream underlying;
    private @Nullable IOUtil.ProgressListener listener;

    public ProgressOutputStream(@Nonnull OutputStream underlying) {
        this.underlying = underlying;
        this.completed = 0;
    }

    public ProgressOutputStream(@Nonnull OutputStream underlying, @Nullable IOUtil.ProgressListener listener) {
        this(underlying);
        this.listener = listener;
    }

    public void setListener(@Nullable IOUtil.ProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public void write(@Nonnull byte[] data, int off, int len) throws IOException {
        this.underlying.write(data, off, len);
        track(len);
    }

    @Override
    public void write(@Nonnull byte[] data) throws IOException {
        this.underlying.write(data);
        track(data.length);
    }

    @Override
    public void write(int c) throws IOException {
        this.underlying.write(c);
        track(1);
    }

    @Override
    public void flush() throws IOException {
        this.underlying.flush();
    }

    public void close() throws IOException {
        this.underlying.close();
    }


    private void track(int len) {
        this.completed += len;
        if (listener != null) {
            listener.onProgress(completed);
        }
    }
}
