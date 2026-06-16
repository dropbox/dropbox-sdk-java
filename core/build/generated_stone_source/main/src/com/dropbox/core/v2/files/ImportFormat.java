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
 * The import format of the incoming Paper doc content.
 */
public enum ImportFormat {
    // union files.ImportFormat (files.stone)
    /**
     * The provided data is interpreted as standard HTML.
     */
    HTML,
    /**
     * The provided data is interpreted as markdown.
     */
    MARKDOWN,
    /**
     * The provided data is interpreted as plain text.
     */
    PLAIN_TEXT,
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
    static class Serializer extends UnionSerializer<ImportFormat> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ImportFormat value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case HTML: {
                    g.writeString("html");
                    break;
                }
                case MARKDOWN: {
                    g.writeString("markdown");
                    break;
                }
                case PLAIN_TEXT: {
                    g.writeString("plain_text");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ImportFormat deserialize(JsonParser p) throws IOException, JsonParseException {
            ImportFormat value;
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
            else if ("html".equals(tag)) {
                value = ImportFormat.HTML;
            }
            else if ("markdown".equals(tag)) {
                value = ImportFormat.MARKDOWN;
            }
            else if ("plain_text".equals(tag)) {
                value = ImportFormat.PLAIN_TEXT;
            }
            else {
                value = ImportFormat.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
