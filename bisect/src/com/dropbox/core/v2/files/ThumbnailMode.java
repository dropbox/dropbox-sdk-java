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

public enum ThumbnailMode {
    // union files.ThumbnailMode (files.stone)
    /**
     * Scale down the image to fit within the given size.
     */
    STRICT,
    /**
     * Scale down the image to fit within the given size or its transpose.
     */
    BESTFIT,
    /**
     * Scale down the image to completely cover the given size or its transpose.
     */
    FITONE_BESTFIT;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<ThumbnailMode> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ThumbnailMode value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case STRICT: {
                    g.writeString("strict");
                    break;
                }
                case BESTFIT: {
                    g.writeString("bestfit");
                    break;
                }
                case FITONE_BESTFIT: {
                    g.writeString("fitone_bestfit");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public ThumbnailMode deserialize(JsonParser p) throws IOException, JsonParseException {
            ThumbnailMode value;
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
            else if ("strict".equals(tag)) {
                value = ThumbnailMode.STRICT;
            }
            else if ("bestfit".equals(tag)) {
                value = ThumbnailMode.BESTFIT;
            }
            else if ("fitone_bestfit".equals(tag)) {
                value = ThumbnailMode.FITONE_BESTFIT;
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
