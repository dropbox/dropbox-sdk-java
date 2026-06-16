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

public enum MoveIntoFamilyError {
    // union files.MoveIntoFamilyError (files.stone)
    /**
     * Moving shared folder into Family Room folder is not allowed.
     */
    IS_SHARED_FOLDER,
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
    static class Serializer extends UnionSerializer<MoveIntoFamilyError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MoveIntoFamilyError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case IS_SHARED_FOLDER: {
                    g.writeString("is_shared_folder");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MoveIntoFamilyError deserialize(JsonParser p) throws IOException, JsonParseException {
            MoveIntoFamilyError value;
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
            else if ("is_shared_folder".equals(tag)) {
                value = MoveIntoFamilyError.IS_SHARED_FOLDER;
            }
            else {
                value = MoveIntoFamilyError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
