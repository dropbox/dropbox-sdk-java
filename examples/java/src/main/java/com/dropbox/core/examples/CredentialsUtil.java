package com.dropbox.core.examples;

import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.oauth.DbxCredential;

import java.io.File;

public final class CredentialsUtil {
    /**
     * JSON file that is generated at auth_output when the ./generate-ci-auth-file script is run
     * with the required parameters.  This is read in CI during integration tests.
     */
    public static final File authOutputFile = new File("../../auth_output");

    public static DbxCredential getDbxCredential() {
        try {
            return DbxCredential.Reader.readFromFile(authOutputFile);
        } catch (JsonReader.FileLoadException e) {
            throw new RuntimeException(e);
        }
    }

    public final DbxAuthInfo getAuthInfo() {
        try {
            return DbxAuthInfo.Reader.readFromFile(authOutputFile);
        } catch (JsonReader.FileLoadException e) {
            throw new RuntimeException(e);
        }
    }

    public static final class OAuth2TokenInputs {
        public final String appKey;
        public final String appSecret;
        public final String refreshToken;

        public OAuth2TokenInputs(String appKey, String appSecret, String refreshToken) {
            this.appKey = appKey;
            this.appSecret = appSecret;
            this.refreshToken = refreshToken;
        }
    }
}
