package com.dropbox.core.v1;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * The response from a longpoll_delta request.
 */
public class DbxLongpollDeltaResult
{
    /**
     * If true, then there might changes and one of the DbxClientV1 "delta" methods can be used to retrieve them.
     * If false, then the poll finished and you can poll again.
     */
    public boolean mightHaveChanges;

    /**
     * If non-negative, this is the number of seconds the Dropbox server wants you to wait before polling
     * again.
     */
    public long backoff;

    public DbxLongpollDeltaResult(boolean mightHaveChanges, long backoff)
    {
        this.mightHaveChanges = mightHaveChanges;
        this.backoff = backoff;
    }

    public static final JsonReader<DbxLongpollDeltaResult> Reader = new JsonReader<DbxLongpollDeltaResult>()
    {
        @Override
        public DbxLongpollDeltaResult read(JsonParser parser) throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            Boolean changes = null;
            long backoff = -1;

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

            return new DbxLongpollDeltaResult(changes, backoff);
        }
    };
}
