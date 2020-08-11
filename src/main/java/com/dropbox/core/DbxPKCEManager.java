package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.DbxRawClientV2;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import static com.dropbox.core.util.StringUtil.urlSafeBase64Encode;

/**
 * This class should be lib/jar private. We make it public so that Android related code can use it.
 *
 *
 * This class does code verifier and code challenge generation in Proof Key for Code Exchange(PKCE).
 * @see <a href="https://tools.ietf.org/html/rfc7636">https://tools.ietf.org/html/rfc7636</a>
 */
public class DbxPKCEManager {
    public static final String CODE_CHALLENGE_METHODS = "S256";
    public static final int CODE_VERIFIER_SIZE = 128;

    private static final SecureRandom RAND = new SecureRandom();
    private static final String CODE_VERIFIER_CHAR_SET =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._~";

    private String codeVerifier;
    private String codeChallenge;

    /**
     *  This class has state. Each instance has a randomly generated codeVerifier in it. Just
     *  like we shouldn't re-use the same code verifier in PKCE, we shouldn't re-use the same
     *  DbxPKCEManager instance in different OAuth flow.
     */
    public DbxPKCEManager() {
        this.codeVerifier = generateCodeVerifier();
        this.codeChallenge = generateCodeChallenge(this.codeVerifier);
    }

    public DbxPKCEManager(String codeVerifier) {
        this.codeVerifier = codeVerifier;
        this.codeChallenge = generateCodeChallenge(this.codeVerifier);
    }

    String generateCodeVerifier() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < CODE_VERIFIER_SIZE; i++) {
            sb.append(CODE_VERIFIER_CHAR_SET.charAt(RAND.nextInt(CODE_VERIFIER_CHAR_SET.length())));
        }

        return sb.toString();
    }

    static String generateCodeChallenge(String codeVerifier) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] signiture = digest.digest(codeVerifier.getBytes("US-ASCII"));
            return urlSafeBase64Encode(signiture).replaceAll("=+$", ""); // remove trailing equal
        } catch (NoSuchAlgorithmException e) {
            throw LangUtil.mkAssert("Impossible", e);
        } catch (UnsupportedEncodingException e) {
            throw LangUtil.mkAssert("Impossible", e);
        }
    }

    /**
     * @return The randomly generate code verifier in this instance.
     */
    public String getCodeVerifier() {
        return this.codeVerifier;
    }

    /**
     * @return The code challenge, which is a hashed code verifier.
     */
    public String getCodeChallenge() {
        return this.codeChallenge;
    }

    /**
     * Make oauth2/token request to exchange code for oauth2 access token. Client secret is not
     * required.
     * @param requestConfig Default attributes to use for each request.
     * @param oauth2Code OAuth2 code defined in OAuth2 code flow.
     * @param appKey Client Key
     * @param redirectUri The same redirect_uri that's used in preivous oauth2/authorize call.
     * @param host Only used for testing when you don't want to make request against production.
     * @return OAuth2 result, including oauth2 access token, and optionally expiration time and
     * refresh token.
     * @throws DbxException If reqeust is invalid, or code expired, or server error.
     */
    public DbxAuthFinish makeTokenRequest(DbxRequestConfig requestConfig,
                                   String oauth2Code,
                                   String appKey,
                                   String redirectUri,
                                   DbxHost host) throws DbxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "authorization_code");
        params.put("code", oauth2Code);
        params.put("locale", requestConfig.getUserLocale());
        params.put("client_id", appKey);
        params.put("code_verifier", this.codeVerifier);

        if (redirectUri != null) {
            params.put("redirect_uri", redirectUri);
        }

        return DbxRequestUtil.doPostNoAuth(
            requestConfig,
            DbxRawClientV2.USER_AGENT_ID,
            host.getApi(),
            "oauth2/token",
            DbxRequestUtil.toParamsArray(params),
            null,
            new DbxRequestUtil.ResponseHandler<DbxAuthFinish>() {
                @Override
                public DbxAuthFinish handle(HttpRequestor.Response response) throws DbxException {
                    if (response.getStatusCode() != 200) {
                        throw DbxRequestUtil.unexpectedStatus(response);
                    }
                    return DbxRequestUtil.readJsonFromResponse(DbxAuthFinish.Reader, response);
                }
            }
        );
    }
}
