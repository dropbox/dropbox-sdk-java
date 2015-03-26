package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * This is for mocking things out during testing.  Most of the time you won't have to deal with
 * this class; just use the default value: {@link DbxHost#Default}.
 */
public final class DbxHost implements java.io.Serializable
{
    public static final long serialVersionUID = 0;

    /**
     * The standard Dropbox hosts: "api.dropbox.com", "api-content.dropbox.com",
     * and "www.dropbox.com"
     */
	public static final DbxHost Default = new DbxHost("api.dropbox.com", "api-content.dropbox.com", "www.dropbox.com", "api-notify.dropbox.com");

    /**
     * The host name of the main Dropbox API server.
     * The default is "api.dropbox.com".
     */
	public final String api;

    /**
     * The host name of the Dropbox API content server.
     * The default is "api-content.dropbox.com".
     */
	public final String content;

    /**
     * The host name of the Dropbox web server.  Used during user authorization.
     * The default is "www.dropbox.com".
     */
	public final String web;

    /**
     * The host name of the Dropbox notification server. Used by the longpoll_notify API.
     * The default is "api-notify.dropbox.com".
     */
    public final String notify;

    /**
     * @param api {@link #api}
     * @param content {@link #content}
     * @param web {@link #web}
     */
	public DbxHost(String api, String content, String web, String notify)
	{
		this.api = api;
		this.content = content;
		this.web = web;
        this.notify = notify;
	}

    public boolean equals(/*@Nullable*/Object o)
    {
        return o != null && getClass().equals(o.getClass()) && equals((DbxHost)o);
    }

    public boolean equals(DbxHost o)
    {
        return api.equals(o.api) && content.equals(o.content) && web.equals(o.web);
    }

    public int hashCode()
    {
        return api.hashCode() + content.hashCode() + web.hashCode();
    }

    private static DbxHost fromBaseHost(String s)
    {
        return new DbxHost("api-" + s, "api-content-" + s, "meta-" + s, "api-notify" + s);
    }

    public static final JsonReader<DbxHost> Reader = new JsonReader<DbxHost>()
    {
        @Override
        public DbxHost read(JsonParser parser) throws IOException, JsonReadException
        {
            JsonToken t = parser.getCurrentToken();
            if (t == JsonToken.VALUE_STRING) {
                String s = parser.getText();
                JsonReader.nextToken(parser);
                return DbxHost.fromBaseHost(s);
            }
            else if (t == JsonToken.START_OBJECT) {
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
            }
            else {
                throw new JsonReadException("expecting a string or an object", parser.getTokenLocation());
            }
        }
    };

    private /*@Nullable*/String inferBaseHost()
    {
        if (web.startsWith("meta-") && api.startsWith("api-") && content.startsWith("api-content-")) {
            String webBase = web.substring("meta-".length());
            String apiBase = web.substring("api-".length());
            String contentBase = web.substring("api-content-".length());
            if (webBase.equals(apiBase) && webBase.equals(contentBase)) {
                return webBase;
            }
        }
        return null;
    }

    public static final JsonWriter<DbxHost> Writer = new JsonWriter<DbxHost>()
    {
        @Override
        public void write(DbxHost host, JsonGenerator g) throws IOException
        {
            String base = host.inferBaseHost();
            if (base != null) {
                g.writeString(base);
            }
            else {
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
