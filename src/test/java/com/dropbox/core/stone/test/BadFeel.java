/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum BadFeel {
    // union BadFeel
    MEH,
    BLAH;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<BadFeel> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(BadFeel value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case MEH: {
                    g.writeString("meh");
                    break;
                }
                case BLAH: {
                    g.writeString("blah");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public BadFeel deserialize(JsonParser p) throws IOException, JsonParseException {
            BadFeel value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("meh".equals(tag)) {
                value = BadFeel.MEH;
            }
            else if ("blah".equals(tag)) {
                value = BadFeel.BLAH;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
