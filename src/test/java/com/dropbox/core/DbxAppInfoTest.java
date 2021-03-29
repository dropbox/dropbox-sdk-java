package com.dropbox.core;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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
        assertEquals(appInfo.getKey(), "aaaaa");
        assertEquals(appInfo.getSecret(), "aaaaa");
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
        assertEquals(appInfo.getKey(), "aaaaa");
        assertFalse(appInfo.hasSecret());
    }
}
