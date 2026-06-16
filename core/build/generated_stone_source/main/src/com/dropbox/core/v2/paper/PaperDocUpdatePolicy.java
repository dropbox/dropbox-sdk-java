/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

public enum PaperDocUpdatePolicy {
    // union paper.PaperDocUpdatePolicy (paper.stone)
    /**
     * The content will be appended to the doc.
     */
    APPEND,
    /**
     * The content will be prepended to the doc. The doc title will not be
     * affected.
     */
    PREPEND,
    /**
     * The document will be overwitten at the head with the provided content.
     */
    OVERWRITE_ALL,
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
    static class Serializer extends UnionSerializer<PaperDocUpdatePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocUpdatePolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case APPEND: {
                    g.writeString("append");
                    break;
                }
                case PREPEND: {
                    g.writeString("prepend");
                    break;
                }
                case OVERWRITE_ALL: {
                    g.writeString("overwrite_all");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperDocUpdatePolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperDocUpdatePolicy value;
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
            else if ("append".equals(tag)) {
                value = PaperDocUpdatePolicy.APPEND;
            }
            else if ("prepend".equals(tag)) {
                value = PaperDocUpdatePolicy.PREPEND;
            }
            else if ("overwrite_all".equals(tag)) {
                value = PaperDocUpdatePolicy.OVERWRITE_ALL;
            }
            else {
                value = PaperDocUpdatePolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
