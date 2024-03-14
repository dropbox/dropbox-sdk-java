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

public enum GetThumbnailBatchError {
    // union files.GetThumbnailBatchError (files.stone)
    /**
     * The operation involves more than 25 files.
     */
    TOO_MANY_FILES,
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
    static class Serializer extends UnionSerializer<GetThumbnailBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetThumbnailBatchError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TOO_MANY_FILES: {
                    g.writeString("too_many_files");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GetThumbnailBatchError deserialize(JsonParser p) throws IOException, JsonParseException {
            GetThumbnailBatchError value;
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
            else if ("too_many_files".equals(tag)) {
                value = GetThumbnailBatchError.TOO_MANY_FILES;
            }
            else {
                value = GetThumbnailBatchError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
