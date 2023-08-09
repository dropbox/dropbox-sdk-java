package com.dropbox.core;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static com.google.common.truth.Truth.assertThat;

public class DbxAppInfoTest {
    @Test
    public void testHappyCase() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
                (
                        "{" +
                                "\"key\": \"aaaaa\"," +
                                "\"secret\": \"aaaaa\""+
                                "}"
                ).getBytes("UTF-8")
        );

        DbxAppInfo appInfo = DbxAppInfo.Reader.readFully(responseStream);
        assertThat(appInfo.getKey()).isEqualTo("aaaaa");
        assertThat(appInfo.getSecret()).isEqualTo("aaaaa");
    }

    @Test
    public void testPKCEConstructor() {
        new DbxAppInfo("aaaaa");
    }

    @Test
    public void testAppKeyOnly() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
                (
                        "{" +
                                "\"key\": \"aaaaa\"" +
                                "}"
                ).getBytes("UTF-8")
        );

        DbxAppInfo appInfo = DbxAppInfo.Reader.readFully(responseStream);
        assertThat(appInfo.getKey()).isEqualTo("aaaaa");
        assertThat(appInfo.hasSecret()).isFalse();
    }
}
