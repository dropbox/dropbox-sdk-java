package com.dropbox.core.http;

import java.io.Closeable;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import okio.BufferedSink;
import okio.Okio;


final class OkHttpUtil {

    public static void assertNotSameThreadExecutor(ExecutorService executor) {
        Thread current = Thread.currentThread();

        Thread executed;
        try {
            executed = executor.submit(new Callable<Thread>() {
                @Override
                public Thread call() {
                    return Thread.currentThread();
                }
            }).get(2, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            // preserve interrupt
            current.interrupt();
            throw new IllegalArgumentException("Unable to verify OkHttp dispatcher executor.", ex);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unable to verify OkHttp dispatcher executor.", ex);
        }

        if (current.equals(executed)) {
            throw new IllegalArgumentException(
                "OkHttp dispatcher uses same-thread executor. " +
                "This is not supported by the SDK and may result in dead-locks. Please configure " +
                "your Dispatcher to use an ExecutorService that runs tasks on separate threads.");
        }
    }

    public static final class PipedStream implements Closeable {
        private static final int BUFFER_SIZE = 5 << 20; // 5MiB, the max size for JSON requests on server

        private final PipedInputStream in;
        private final PipedOutputStream out;

        public PipedStream() {
            this.in = new PipedInputStream(BUFFER_SIZE);
            try {
                this.out = new PipedOutputStream(in);
            } catch (IOException ex) {
                throw new IllegalStateException("Unable to create piped stream for async upload request.");
            }
        }

        public OutputStream getOutputStream() {
            return out;
        }

        @Override
        public void close() {
            try {
                out.close();
            } catch (IOException ex) {
                // ignore
            }
            try {
                in.close();
            } catch (IOException ex) {
                //ignore
            }
        }

        public void writeTo(BufferedSink sink) throws IOException {
            sink.writeAll(Okio.source(in));
        }
    }
}
