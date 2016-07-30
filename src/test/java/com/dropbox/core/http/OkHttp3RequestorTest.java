package com.dropbox.core.http;

import org.testng.annotations.Test;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OkHttp3RequestorTest {

    @Test
    public void testCustomDispatcher() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        // should be fine with default Dispatcher
        new OkHttp3Requestor(client.build());

        // should also be fine with other common executors that run on separate threads
        client.dispatcher(new Dispatcher(Executors.newSingleThreadExecutor()));
        new OkHttp3Requestor(client.build());

        client.dispatcher(new Dispatcher(Executors.newCachedThreadPool()));
        new OkHttp3Requestor(client.build());

        client.dispatcher(new Dispatcher(Executors.newFixedThreadPool(3)));
        new OkHttp3Requestor(client.build());
    }

    @Test(expectedExceptions={ IllegalArgumentException.class })
    public void testSameThreadDispatcher() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        // should fail for same-thread executors
        client.dispatcher(new Dispatcher(MoreExecutors.newDirectExecutorService()));
        new OkHttp3Requestor(client.build());
    }
}
