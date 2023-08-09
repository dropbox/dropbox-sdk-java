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

public enum ListRevisionsMode {
    // union files.ListRevisionsMode (files.stone)
    /**
     * Returns revisions with the same file path as identified by the latest
     * file entry at the given file path or id.
     */
    PATH,
    /**
     * Returns revisions with the same file id as identified by the latest file
     * entry at the given file path or id.
     */
    ID,
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
    static class Serializer extends UnionSerializer<ListRevisionsMode> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListRevisionsMode value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PATH: {
                    g.writeString("path");
                    break;
                }
                case ID: {
                    g.writeString("id");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListRevisionsMode deserialize(JsonParser p) throws IOException, JsonParseException {
            ListRevisionsMode value;
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
            else if ("path".equals(tag)) {
                value = ListRevisionsMode.PATH;
            }
            else if ("id".equals(tag)) {
                value = ListRevisionsMode.ID;
            }
            else {
                value = ListRevisionsMode.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
