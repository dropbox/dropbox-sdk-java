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

public enum DogSize {
    // union DogSize
    LAP,
    SMALL,
    MEDIUM,
    LARGE;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<DogSize> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DogSize value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case LAP: {
                    g.writeString("lap");
                    break;
                }
                case SMALL: {
                    g.writeString("small");
                    break;
                }
                case MEDIUM: {
                    g.writeString("medium");
                    break;
                }
                case LARGE: {
                    g.writeString("large");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public DogSize deserialize(JsonParser p) throws IOException, JsonParseException {
            DogSize value;
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
            else if ("lap".equals(tag)) {
                value = DogSize.LAP;
            }
            else if ("small".equals(tag)) {
                value = DogSize.SMALL;
            }
            else if ("medium".equals(tag)) {
                value = DogSize.MEDIUM;
            }
            else if ("large".equals(tag)) {
                value = DogSize.LARGE;
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
