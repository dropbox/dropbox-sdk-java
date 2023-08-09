package com.dropbox.core;

import java.io.IOException;

import static com.dropbox.core.util.StringUtil.jq;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * Identifying information about your application.
 */
public class DbxAppInfo extends Dumpable {
    private final String key;
    private final String secret;
    private final DbxHost host;

    /**
     *
     * DbxAppInfo without secret. Should only be used in PKCE flow.
     *
     * @param key Dropbox app key (see {@link #getKey})
     * @see com.dropbox.core.DbxPKCEWebAuth
     */
    public DbxAppInfo(String key) {
        this(key, null);
    }

    /**
     * @param key Dropbox app key (see {@link #getKey})
     * @param secret Dropbox app secret (see {@link #getSecret})
     */
    public DbxAppInfo(String key, String secret) {
        checkKeyArg(key);
        checkSecretArg(secret);

        this.key = key;
        this.secret = secret;
        this.host = DbxHost.DEFAULT;
    }

    /**
     * @param key Dropbox app key (see {@link #getKey})
     * @param secret Dropbox app secret (see {@link #getSecret})
     * @param host Dropbox host configuration (see {@link #getHost})
     */
    public DbxAppInfo(String key, String secret, DbxHost host) {
        checkKeyArg(key);
        checkSecretArg(secret);

        this.key = key;
        this.secret = secret;
        this.host = host;
    }

    /**
     * Returns the Dropbox <em>app key</em> (OAuth calls this the <em>consumer key</em>).  You can
     * create an app key and secret on the <a href="http://dropbox.com/developers/apps">Dropbox
     * developer website</a>.
     *
     * @return Dropbox app key
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the Dropbox <em>app secret</em> (OAuth calls this the <em>consumer secret</em>).  You
     * can create an app key and secret on the <a href="http://dropbox.com/developers/apps">Dropbox
     * developer website</a>.
     *
     * <p> Make sure that this is kept a secret.  Someone with your app secret can impesonate your
     * application.  People sometimes ask for help on the Dropbox API forums and copy/paste their
     * code, which sometimes includes their app secret.  Do not do that.  </p>
     *
     * @return Dropbox app secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Returns the Dropbox host configuration.
     *
     * <p> This is almost always {@link DbxHost#DEFAULT}.  Typically this value will only be
     * different for testing purposes.
     *
     * @return Dropbox host configuration
     */
    public DbxHost getHost() {
        return host;
    }

    /**
     * Return if this DbxAppInfo contains app secret. DbxAppInfo without secret should only be
     * used in {@link com.dropbox.core.DbxPKCEWebAuth}.
     *
     * @return If this DbxAppInfo contains app secret.
     */
    public boolean hasSecret() {
        return secret != null;
    }

    @Override
    protected void dumpFields(DumpWriter out) {
        out.f("key").v(key);
        out.f("secret").v(secret);
    }

    /**
     * If they key's format looks correct, return {@code null}.  Otherwise return
     * a string that describes what the problem is.
     *
     * <p>
     * NOTE: This function only performs some cursory checks on the format of the key.
     * Even if it returns {@code null} (which means "no problem"), it doesn't mean
     * that what you passed in is an actual valid Dropbox API app key.
     * </p>
     */
    public static /*@Nullable*/String getKeyFormatError(String key) {
        return getTokenPartError(key);
    }

    /**
     * If they secret's format looks correct, return {@code null}.  Otherwise return
     * a string that describes what the problem is.
     *
     * <p>
     * NOTE: This function only performs some cursory checks on the format.  Even if it
     * returns {@code null} (which means "no problem"), it doesn't mean that what
     * you passed in is an actual valid Dropbox API app key.
     * </p>
     */
    public static /*@Nullable*/String getSecretFormatError(String key) {
        return getTokenPartError(key);
    }

    // ------------------------------------------------------
    // JSON parsing

    public static final JsonReader<DbxAppInfo> Reader = new JsonReader<DbxAppInfo>()
    {
        @Override
        public final DbxAppInfo read(JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String key = null;
            String secret = null;
            DbxHost host = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("key")) {
                        key = KeyReader.readField(parser, fieldName, key);
                    }
                    else if (fieldName.equals("secret")) {
                        secret = SecretReader.readField(parser, fieldName, secret);
                    }
                    else if (fieldName.equals("host")) {
                        host = DbxHost.Reader.readField(parser, fieldName, host);
                    }
                    else {
                        // Unknown field.  Skip over it.
                        JsonReader.skipValue(parser);
                    }
                }
                catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);

            if (key == null) throw new JsonReadException("missing field \"key\"", top);
            if (host == null) host = DbxHost.DEFAULT;

            return new DbxAppInfo(key, secret, host);
        }
    };

    public static final JsonReader<String> KeyReader = new JsonReader<String>()
    {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException
        {
            try {
                String v = parser.getText();
                String error = getKeyFormatError(v);
                if (error != null) {
                    throw new JsonReadException("bad format for app key: " + error, parser.getTokenLocation());
                }
                parser.nextToken();
                return v;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }
    };

    public static final JsonReader<String> SecretReader = new JsonReader<String>()
    {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException
        {
            try {
                String v = parser.getText();
                String error = getKeyFormatError(v);
                if (error != null) {
                    throw new JsonReadException("bad format for app secret: " + error, parser.getTokenLocation());
                }
                parser.nextToken();
                return v;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }

    };

    public static /*@Nullable*/String getTokenPartError(String s)
    {
        if (s == null) return null;
        if (s.length() == 0) return "can't be empty";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 0x21 || c > 0x7e) {
                // Only allow normal visible ASCII characters.
                return "invalid character at index " + i + ": " + jq("" + c);
            }
        }
        return null;
    }

    public static void checkKeyArg(String key)
    {
        String error;

        if (key == null) {
            error = "can't be null";
        } else {
            error = getTokenPartError(key);
        }

        if (error == null) return;
        throw new IllegalArgumentException("Bad 'key': " + error);
    }

    public static void checkSecretArg(String secret)
    {
        String error = getTokenPartError(secret);
        if (error == null) return;
        throw new IllegalArgumentException("Bad 'secret': " + error);
    }
}
