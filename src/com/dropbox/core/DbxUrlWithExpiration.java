package com.dropbox.core;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

public final class DbxUrlWithExpiration
{
    public final String url;
    public final Date expires;

    public DbxUrlWithExpiration(String url, Date expires)
    {
        this.url = url;
        this.expires = expires;
    }

    public static final JsonReader<DbxUrlWithExpiration> Reader = new JsonReader<DbxUrlWithExpiration>() {
        @Override
        public DbxUrlWithExpiration read(JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String url = null;
            Date expires = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("url")) {
                        url = JsonReader.StringReader.readField(parser, fieldName, url);
                    }
                    else if (fieldName.equals("expires")) {
                        expires = JsonDateReader.Dropbox.readField(parser, fieldName, expires);
                    }
                    else {
                        JsonReader.skipValue(parser);
                    }
                }
                catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);

            if (url == null) throw new JsonReadException("missing field \"url\"", top);
            if (expires == null) throw new JsonReadException("missing field \"expires\"", top);

            return new DbxUrlWithExpiration(url, expires);
        }
    };
}
