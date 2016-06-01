package com.dropbox.core.stone;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public abstract class CompositeSerializer<T> extends StoneSerializer<T> {
    protected static final String TAG_FIELD = ".tag";

    protected static boolean hasTag(JsonParser p) throws IOException, JsonParseException {
        return p.getCurrentToken() == JsonToken.FIELD_NAME && TAG_FIELD.equals(p.getCurrentName());
    }

    protected static String readTag(JsonParser p) throws IOException, JsonParseException {
        if (!hasTag(p)) {
            return null;
        }
        p.nextToken();
        String tag = getStringValue(p);
        p.nextToken();

        return tag;
    }

    protected void writeTag(String tag, JsonGenerator g) throws IOException, JsonGenerationException {
        if (tag != null) {
            g.writeStringField(TAG_FIELD, tag);
        }
    }
}

