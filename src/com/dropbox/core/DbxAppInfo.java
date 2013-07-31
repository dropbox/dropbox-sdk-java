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

/**
 * Identifying information about your application.
 */
public class DbxAppInfo extends Dumpable implements java.io.Serializable
{
    public static final long serialVersionUID = 0;

    /**
     * Your Dropbox <em>app key</em> (OAuth calls this the <em>consumer key</em>).  You can
     * create an app key and secret on the <a href="http://dropbox.com/developers/apps">Dropbox developer website</a>.
     */
    public final String key;

    /**
     * Your Dropbox <em>app secret</em> (OAuth calls this the <em>consumer secret</em>).  You can
     * create an app key and secret on the <a href="http://dropbox.com/developers/apps">Dropbox developer website</a>.
     *
     * <p>
     * Make sure that this is kept a secret.  Someone with your app secret can impesonate your
     * application.  People sometimes ask for help on the Dropbox API forums and
     * copy/paste their code, which sometimes includes their app secret.  Do not do that.
     * </p>
     */
    public final String secret;

    /**
     * This is almost always {@link DbxHost#Default}.  This is only set differently for testing
     * purposes.
     */
    public final DbxHost host;

    /**
     * @param key {@link #key}
     * @param secret {@link #secret}
     */
    public DbxAppInfo(String key, String secret)
    {
        checkKeyArg(key);
        checkSecretArg(secret);

        this.key = key;
        this.secret = secret;
        this.host = DbxHost.Default;
    }

    /**
     * @param key {@link #key}
     * @param secret {@link #secret}
     * @param host {@link #host}
     */
    public DbxAppInfo(String key, String secret, DbxHost host)
    {
        checkKeyArg(key);
        checkSecretArg(secret);

        this.key = key;
        this.secret = secret;
        this.host = host;
    }

    @Override
    protected void dumpFields(DumpWriter out)
    {
        out.field("key", key);
        out.field("secret", secret);
    }

    /**
     * If they key's format looks correct, return {@code null}.  Otherwise return
     * a string that describes what the problem is.
     *
     * <p>
     * NOTE: This function only performs some cursory checks on the format of the key.
     * Even if it * returns {@code null} (which means "no problem"), it doesn't mean
     * that what you passed in is an actual valid Dropbox API app key.
     * </p>
     */
    public static String getKeyFormatError(String key) { return getTokenPartError(key); }

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
    public static String getSecretFormatError(String key) { return getTokenPartError(key); }

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
            if (secret == null) throw new JsonReadException("missing field \"secret\"", top);
            if (host == null) host = DbxHost.Default;

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

    public static String getTokenPartError(String s)
    {
        if (s == null) return "can't be null";
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
        String error = getTokenPartError(key);
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
