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

public enum CatchAllUnion {
    // union CatchAllUnion
    ALPHA,
    BETA,
    ONE,
    TWO,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<CatchAllUnion> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CatchAllUnion value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ALPHA: {
                    g.writeString("alpha");
                    break;
                }
                case BETA: {
                    g.writeString("beta");
                    break;
                }
                case ONE: {
                    g.writeString("one");
                    break;
                }
                case TWO: {
                    g.writeString("two");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public CatchAllUnion deserialize(JsonParser p) throws IOException, JsonParseException {
            CatchAllUnion value;
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
                value = CatchAllUnion.ALPHA;
            }
            else if ("beta".equals(tag)) {
                value = CatchAllUnion.BETA;
            }
            else if ("one".equals(tag)) {
                value = CatchAllUnion.ONE;
            }
            else if ("two".equals(tag)) {
                value = CatchAllUnion.TWO;
            }
            else {
                value = CatchAllUnion.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
