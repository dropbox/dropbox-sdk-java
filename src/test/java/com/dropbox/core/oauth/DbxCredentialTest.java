package com.dropbox.core.oauth;

import com.dropbox.core.json.JsonReadException;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static com.google.common.truth.Truth.assertThat;

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
        assertThat(credential.getAccessToken()).isEqualTo("aaaaa");
        assertThat(credential.aboutToExpire()).isFalse();
        assertThat(credential.getRefreshToken()).isNull();
        assertThat(credential.getExpiresAt()).isNull();
        assertThat(credential.getAppKey()).isNull();
        assertThat(credential.getAppSecret()).isNull();
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
        assertThat(credential.getAccessToken()).isEqualTo("aaaaa");
        assertThat(credential.getExpiresAt()).isEqualTo(new Long(10));
        assertThat(credential.getRefreshToken()).isEqualTo("bbbbb");
        assertThat(credential.getAppKey()).isEqualTo("ccccc");
        assertThat(credential.getAppSecret()).isEqualTo("ddddd");
        assertThat(credential.aboutToExpire()).isTrue();
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
        assertThat(afterRead.getAccessToken()).isEqualTo(credential.getAccessToken());
        assertThat(afterRead.getExpiresAt()).isEqualTo(credential.getExpiresAt());
        assertThat(afterRead.getRefreshToken()).isEqualTo(credential.getRefreshToken());
        assertThat(afterRead.getAppKey()).isEqualTo(credential.getAppKey());
        assertThat(afterRead.getAppSecret()).isEqualTo(credential.getAppSecret());
    }
}
