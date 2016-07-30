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

public enum ChildUnion {
    // union ChildUnion
    ALPHA,
    BETA,
    DELTA,
    GAMMA,
    OMEGA;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<ChildUnion> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ChildUnion value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ALPHA: {
                    g.writeString("alpha");
                    break;
                }
                case BETA: {
                    g.writeString("beta");
                    break;
                }
                case DELTA: {
                    g.writeString("delta");
                    break;
                }
                case GAMMA: {
                    g.writeString("gamma");
                    break;
                }
                case OMEGA: {
                    g.writeString("omega");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public ChildUnion deserialize(JsonParser p) throws IOException, JsonParseException {
            ChildUnion value;
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
                value = ChildUnion.ALPHA;
            }
            else if ("beta".equals(tag)) {
                value = ChildUnion.BETA;
            }
            else if ("delta".equals(tag)) {
                value = ChildUnion.DELTA;
            }
            else if ("gamma".equals(tag)) {
                value = ChildUnion.GAMMA;
            }
            else if ("omega".equals(tag)) {
                value = ChildUnion.OMEGA;
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
