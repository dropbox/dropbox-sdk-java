/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

public enum PaperDownloadFormat {
    // union team_log.PaperDownloadFormat (team_log_generated.stone)
    DOCX,
    HTML,
    MARKDOWN,
    PDF,
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
    static class Serializer extends UnionSerializer<PaperDownloadFormat> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDownloadFormat value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DOCX: {
                    g.writeString("docx");
                    break;
                }
                case HTML: {
                    g.writeString("html");
                    break;
                }
                case MARKDOWN: {
                    g.writeString("markdown");
                    break;
                }
                case PDF: {
                    g.writeString("pdf");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperDownloadFormat deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperDownloadFormat value;
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
            else if ("docx".equals(tag)) {
                value = PaperDownloadFormat.DOCX;
            }
            else if ("html".equals(tag)) {
                value = PaperDownloadFormat.HTML;
            }
            else if ("markdown".equals(tag)) {
                value = PaperDownloadFormat.MARKDOWN;
            }
            else if ("pdf".equals(tag)) {
                value = PaperDownloadFormat.PDF;
            }
            else {
                value = PaperDownloadFormat.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
