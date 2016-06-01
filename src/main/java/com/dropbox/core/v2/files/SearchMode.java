/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum SearchMode {
    // union SearchMode
    /**
     * Search file and folder names.
     */
    FILENAME,
    /**
     * Search file and folder names as well as file contents.
     */
    FILENAME_AND_CONTENT,
    /**
     * Search for deleted file and folder names.
     */
    DELETED_FILENAME;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<SearchMode> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchMode value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FILENAME: {
                    g.writeString("filename");
                    break;
                }
                case FILENAME_AND_CONTENT: {
                    g.writeString("filename_and_content");
                    break;
                }
                case DELETED_FILENAME: {
                    g.writeString("deleted_filename");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public SearchMode deserialize(JsonParser p) throws IOException, JsonParseException {
            SearchMode value;
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
            else if ("filename".equals(tag)) {
                value = SearchMode.FILENAME;
            }
            else if ("filename_and_content".equals(tag)) {
                value = SearchMode.FILENAME_AND_CONTENT;
            }
            else if ("deleted_filename".equals(tag)) {
                value = SearchMode.DELETED_FILENAME;
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
