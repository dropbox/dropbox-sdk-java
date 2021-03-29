package com.dropbox.core.oauth;

import com.dropbox.core.json.JsonReadException;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class DbxCredentialTest {
    @Test
    public void testOnline() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"access_token\": \"aaaaa\"" +
                "}"
            ).getBytes("UTF-8")
        );

        DbxCredential credential = DbxCredential.Reader.readFully(responseStream);
        assertEquals(credential.getAccessToken(), "aaaaa");
        assertFalse(credential.aboutToExpire());
        assertNull(credential.getRefreshToken());
        assertNull(credential.getExpiresAt());
        assertNull(credential.getAppKey());
        assertNull(credential.getAppSecret());
    }

    @Test
    public void testOffline() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"access_token\": \"aaaaa\"," +
                    "\"expires_at\": 10,"+
                    "\"refresh_token\": \"bbbbb\"," +
                    "\"app_key\": \"ccccc\"," +
                    "\"app_secret\": \"ddddd\"" +
                    "}"
            ).getBytes("UTF-8")
        );

        DbxCredential credential = DbxCredential.Reader.readFully(responseStream);
        assertEquals(credential.getAccessToken(), "aaaaa");
        assertEquals(credential.getExpiresAt(), new Long(10));
        assertEquals(credential.getRefreshToken(), "bbbbb");
        assertEquals(credential.getAppKey(), "ccccc");
        assertEquals(credential.getAppSecret(), "ddddd");
        assertTrue(credential.aboutToExpire());
    }

    @Test(expectedExceptions={JsonReadException.class})
    public void testInvalid() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"refresh_token\": \"aaaaa\"" +
                "}"
            ).getBytes("UTF-8")
        );
        DbxCredential.Reader.readFully(responseStream);
    }

    @Test
    public void testSerialization() throws Exception {
        DbxCredential credential = new DbxCredential("aaaa", 10L, "bbbbb", "ccccc", "ddddd");

        String data = DbxCredential.Writer.writeToString(credential);
        DbxCredential afterRead = DbxCredential.Reader.readFully(data);
        assertEquals(afterRead.getAccessToken(), credential.getAccessToken());
        assertEquals(afterRead.getExpiresAt(), credential.getExpiresAt());
        assertEquals(afterRead.getRefreshToken(), credential.getRefreshToken());
        assertEquals(afterRead.getAppKey(), credential.getAppKey());
        assertEquals(afterRead.getAppSecret(), credential.getAppSecret());
    }
}
