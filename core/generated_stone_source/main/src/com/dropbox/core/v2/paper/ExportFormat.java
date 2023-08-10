/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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
 * The desired export format of the Paper doc.
 */
public enum ExportFormat {
    // union paper.ExportFormat (paper.stone)
    /**
     * The HTML export format.
     */
    HTML,
    /**
     * The markdown export format.
     */
    MARKDOWN,
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
    static class Serializer extends UnionSerializer<ExportFormat> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExportFormat value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case HTML: {
                    g.writeString("html");
                    break;
                }
                case MARKDOWN: {
                    g.writeString("markdown");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ExportFormat deserialize(JsonParser p) throws IOException, JsonParseException {
            ExportFormat value;
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
                value = ExportFormat.HTML;
            }
            else if ("markdown".equals(tag)) {
                value = ExportFormat.MARKDOWN;
            }
            else {
                value = ExportFormat.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
