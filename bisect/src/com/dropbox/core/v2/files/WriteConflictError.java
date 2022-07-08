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

public enum WriteConflictError {
    // union files.WriteConflictError (files.stone)
    /**
     * There's a file in the way.
     */
    FILE,
    /**
     * There's a folder in the way.
     */
    FOLDER,
    /**
     * There's a file at an ancestor path, so we couldn't create the required
     * parent folders.
     */
    FILE_ANCESTOR,
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
    static class Serializer extends UnionSerializer<WriteConflictError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(WriteConflictError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FILE: {
                    g.writeString("file");
                    break;
                }
                case FOLDER: {
                    g.writeString("folder");
                    break;
                }
                case FILE_ANCESTOR: {
                    g.writeString("file_ancestor");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public WriteConflictError deserialize(JsonParser p) throws IOException, JsonParseException {
            WriteConflictError value;
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
            else if ("file".equals(tag)) {
                value = WriteConflictError.FILE;
            }
            else if ("folder".equals(tag)) {
                value = WriteConflictError.FOLDER;
            }
            else if ("file_ancestor".equals(tag)) {
                value = WriteConflictError.FILE_ANCESTOR;
            }
            else {
                value = WriteConflictError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
