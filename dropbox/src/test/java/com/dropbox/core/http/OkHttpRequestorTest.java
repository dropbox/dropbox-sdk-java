package com.dropbox.core.http;

import org.testng.annotations.Test;

import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.OkHttpClient;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OkHttpRequestorTest {

    @Test
    public void testCustomDispatcher() {
        OkHttpClient client = new OkHttpClient();

        // should be fine with default Dispatcher
        new OkHttpRequestor(client);

        // should also be fine with other common executors that run on separate threads
        client.setDispatcher(new Dispatcher(Executors.newSingleThreadExecutor()));
        new OkHttpRequestor(client);

        client.setDispatcher(new Dispatcher(Executors.newCachedThreadPool()));
        new OkHttpRequestor(client);

        client.setDispatcher(new Dispatcher(Executors.newFixedThreadPool(3)));
        new OkHttpRequestor(client);
    }

    @Test(expectedExceptions={ IllegalArgumentException.class })
    public void testSameThreadDispatcher() {
        OkHttpClient client = new OkHttpClient();

        // should fail for same-thread executors
        client.setDispatcher(new Dispatcher(MoreExecutors.newDirectExecutorService()));
        new OkHttpRequestor(client);
    }
}
