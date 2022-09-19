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

public enum FileStatus {
    // union files.FileStatus (files.stone)
    ACTIVE,
    DELETED,
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
    static class Serializer extends UnionSerializer<FileStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACTIVE: {
                    g.writeString("active");
                    break;
                }
                case DELETED: {
                    g.writeString("deleted");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            FileStatus value;
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
            else if ("active".equals(tag)) {
                value = FileStatus.ACTIVE;
            }
            else if ("deleted".equals(tag)) {
                value = FileStatus.DELETED;
            }
            else {
                value = FileStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
