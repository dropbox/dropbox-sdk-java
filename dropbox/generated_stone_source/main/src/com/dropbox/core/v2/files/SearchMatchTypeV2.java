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

/**
 * Indicates what type of match was found for a given item.
 */
public enum SearchMatchTypeV2 {
    // union files.SearchMatchTypeV2 (files.stone)
    /**
     * This item was matched on its file or folder name.
     */
    FILENAME,
    /**
     * This item was matched based on its file contents.
     */
    FILE_CONTENT,
    /**
     * This item was matched based on both its contents and its file name.
     */
    FILENAME_AND_CONTENT,
    /**
     * This item was matched on image content.
     */
    IMAGE_CONTENT,
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
    static class Serializer extends UnionSerializer<SearchMatchTypeV2> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchMatchTypeV2 value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FILENAME: {
                    g.writeString("filename");
                    break;
                }
                case FILE_CONTENT: {
                    g.writeString("file_content");
                    break;
                }
                case FILENAME_AND_CONTENT: {
                    g.writeString("filename_and_content");
                    break;
                }
                case IMAGE_CONTENT: {
                    g.writeString("image_content");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SearchMatchTypeV2 deserialize(JsonParser p) throws IOException, JsonParseException {
            SearchMatchTypeV2 value;
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
                value = SearchMatchTypeV2.FILENAME;
            }
            else if ("file_content".equals(tag)) {
                value = SearchMatchTypeV2.FILE_CONTENT;
            }
            else if ("filename_and_content".equals(tag)) {
                value = SearchMatchTypeV2.FILENAME_AND_CONTENT;
            }
            else if ("image_content".equals(tag)) {
                value = SearchMatchTypeV2.IMAGE_CONTENT;
            }
            else {
                value = SearchMatchTypeV2.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
