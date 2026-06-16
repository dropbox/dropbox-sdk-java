/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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
    // union files.PaperDocUpdatePolicy (files.stone)
    /**
     * Sets the doc content to the provided content if the provided
     * paper_revision matches the latest doc revision. Otherwise, returns an
     * error.
     */
    UPDATE,
    /**
     * Sets the doc content to the provided content without checking
     * paper_revision.
     */
    OVERWRITE,
    /**
     * Adds the provided content to the beginning of the doc without checking
     * paper_revision.
     */
    PREPEND,
    /**
     * Adds the provided content to the end of the doc without checking
     * paper_revision.
     */
    APPEND,
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
                case UPDATE: {
                    g.writeString("update");
                    break;
                }
                case OVERWRITE: {
                    g.writeString("overwrite");
                    break;
                }
                case PREPEND: {
                    g.writeString("prepend");
                    break;
                }
                case APPEND: {
                    g.writeString("append");
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
            else if ("update".equals(tag)) {
                value = PaperDocUpdatePolicy.UPDATE;
            }
            else if ("overwrite".equals(tag)) {
                value = PaperDocUpdatePolicy.OVERWRITE;
            }
            else if ("prepend".equals(tag)) {
                value = PaperDocUpdatePolicy.PREPEND;
            }
            else if ("append".equals(tag)) {
                value = PaperDocUpdatePolicy.APPEND;
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
