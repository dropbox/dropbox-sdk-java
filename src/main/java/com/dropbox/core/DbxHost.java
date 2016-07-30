package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * This is for mocking things out during testing.  Most of the time you won't have to deal with
 * this class; just use the default value: {@link DbxHost#DEFAULT}.
 */
public final class DbxHost {
    /**
     * The standard Dropbox hosts: "api.dropbox.com", "api-content.dropbox.com",
     * and "www.dropbox.com"
     */
    public static final DbxHost DEFAULT = new DbxHost(
        "api.dropboxapi.com",
        "content.dropboxapi.com",
        "www.dropbox.com",
        "notify.dropboxapi.com"
    );

    private final String api;
    private final String content;
    private final String web;
    private final String notify;

    /**
     * @param api main Dropbox API server host name
     * @param content Dropbox API content server host name
     * @param web Dropbox web server host name
     * @param notify Dropbox notification server host name
     */
    public DbxHost(String api, String content, String web, String notify) {
        this.api = api;
        this.content = content;
        this.web = web;
        this.notify = notify;
    }

    /**
     * Returns the host name of the main Dropbox API server.
     * The default is {@code "api.dropbox.com"}.
     *
     * @return host name of main Dropbox API server
     */
    public String getApi() {
        return api;
    }

    /**
     * Returns the host name of the Dropbox API content server.
     * The default is {@code "api-content.dropbox.com"}.
     *
     * @return host name of Dropbox API content server
     */
    public String getContent() {
        return content;
    }

    /**
     * Returns the host name of the Dropbox web server.  Used during user authorization.
     * The default is {@code "www.dropbox.com"}.
     *
     * @return host name of Dropbox API web server used during user authorization
     */
    public String getWeb() {
        return web;
    }

    /**
     * Returns the host name of the Dropbox notification server.  Used by longpoll endpoints.
     * The default is {@code "api-notify.dropbox.com"}.
     *
     * @return host name of Dropbox notification server used for longpolling
     */
    public String getNotify() {
        return notify;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new String [] {api, content, web, notify});
    }

    @Override
    public boolean equals(/*@Nullable*/Object obj) {
        if (obj == this) {
            return true;
        } else if(obj instanceof DbxHost) {
            DbxHost other = (DbxHost) obj;
            return other.api.equals(this.api)
                && other.content.equals(this.content)
                && other.web.equals(this.web)
                && other.notify.equals(this.notify);
        } else {
            return false;
        }
    }

    private static DbxHost fromBaseHost(String s) {
        return new DbxHost("api-" + s, "api-content-" + s, "meta-" + s, "api-notify-" + s);
    }

    public static final JsonReader<DbxHost> Reader = new JsonReader<DbxHost>() {
        @Override
        public DbxHost read(JsonParser parser) throws IOException, JsonReadException {
            JsonToken t = parser.getCurrentToken();
            if (t == JsonToken.VALUE_STRING) {
                String s = parser.getText();
                JsonReader.nextToken(parser);
                return DbxHost.fromBaseHost(s);
            } else if (t == JsonToken.START_OBJECT) {
                JsonLocation top = parser.getTokenLocation();
                nextToken(parser);

                String api = null;
                String content = null;
                String web = null;
                String notify = null;

                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();

                    try {
                        if (fieldName.equals("api")) {
                            api = JsonReader.StringReader.readField(parser, fieldName, api);
                        }
                        else if (fieldName.equals("content")) {
                            content = JsonReader.StringReader.readField(parser, fieldName, content);
                        }
                        else if (fieldName.equals("web")) {
                            web = JsonReader.StringReader.readField(parser, fieldName, web);
                        }
                        else if (fieldName.equals("notify")) {
                            notify = JsonReader.StringReader.readField(parser, fieldName, notify);
                        }
                        else {
                            throw new JsonReadException("unknown field", parser.getCurrentLocation());
                        }
                    }
                    catch (JsonReadException ex) {
                        throw ex.addFieldContext(fieldName);
                    }
                }

                JsonReader.expectObjectEnd(parser);

                if (api == null) throw new JsonReadException("missing field \"api\"", top);
                if (content == null) throw new JsonReadException("missing field \"content\"", top);
                if (web == null) throw new JsonReadException("missing field \"web\"", top);
                if (notify == null) throw new JsonReadException("missing field \"notify\"", top);

                return new DbxHost(api, content, web, notify);
            } else {
                throw new JsonReadException("expecting a string or an object", parser.getTokenLocation());
            }
        }
    };

    private /*@Nullable*/String inferBaseHost() {
        if (web.startsWith("meta-") && api.startsWith("api-") && content.startsWith("api-content-") && notify.startsWith("api-notify-")) {
            String webBase = web.substring("meta-".length());
            String apiBase = api.substring("api-".length());
            String contentBase = content.substring("api-content-".length());
            String notifyBase = notify.substring("api-notify-".length());
            if (webBase.equals(apiBase) && webBase.equals(contentBase) && webBase.equals(notifyBase)) {
                return webBase;
            }
        }
        return null;
    }

    public static final JsonWriter<DbxHost> Writer = new JsonWriter<DbxHost>() {
        @Override
        public void write(DbxHost host, JsonGenerator g) throws IOException {
            String base = host.inferBaseHost();
            if (base != null) {
                g.writeString(base);
            } else {
                g.writeStartObject();
                g.writeStringField("api", host.api);
                g.writeStringField("content", host.content);
                g.writeStringField("web", host.web);
                g.writeStringField("notify", host.notify);
                g.writeEndObject();
            }
        }
    };
}
