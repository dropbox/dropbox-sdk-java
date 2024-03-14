/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

public enum ParentUnion {
    // union test.ParentUnion (test.stone)
    ALPHA,
    BETA;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<ParentUnion> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ParentUnion value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ALPHA: {
                    g.writeString("alpha");
                    break;
                }
                case BETA: {
                    g.writeString("beta");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public ParentUnion deserialize(JsonParser p) throws IOException, JsonParseException {
            ParentUnion value;
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
            else if ("alpha".equals(tag)) {
                value = ParentUnion.ALPHA;
            }
            else if ("beta".equals(tag)) {
                value = ParentUnion.BETA;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
