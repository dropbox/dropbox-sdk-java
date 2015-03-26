package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Created by jefflub on 3/26/15.
 */
public class DbxLongpollDelta
{
    public boolean changes;
    public long backoff;

    public DbxLongpollDelta(boolean changes, long backoff) {
        this.changes = changes;
        this.backoff = backoff;
    }

    public static final JsonReader<DbxLongpollDelta> Reader = new JsonReader<DbxLongpollDelta>() {
        @Override
        public DbxLongpollDelta read(JsonParser parser) throws IOException, JsonReadException {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            Boolean changes = null;
            long backoff = 0;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("changes")) {
                        changes = JsonReader.BooleanReader.readField(parser, fieldName, changes);
                    } else if (fieldName.equals("backoff")) {
                        backoff = JsonReader.readUnsignedLongField(parser, fieldName, backoff);
                    } else {
                        JsonReader.skipValue(parser);
                    }
                } catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);
            if (changes == null) throw new JsonReadException("missing field \"changes\"", top);

            return new DbxLongpollDelta(changes, backoff);
        }
    };}
