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

public enum ListPaperDocsFilterBy {
    // union paper.ListPaperDocsFilterBy (paper.stone)
    /**
     * Fetches all Paper doc IDs that the user has ever accessed.
     */
    DOCS_ACCESSED,
    /**
     * Fetches only the Paper doc IDs that the user has created.
     */
    DOCS_CREATED,
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
    static class Serializer extends UnionSerializer<ListPaperDocsFilterBy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListPaperDocsFilterBy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DOCS_ACCESSED: {
                    g.writeString("docs_accessed");
                    break;
                }
                case DOCS_CREATED: {
                    g.writeString("docs_created");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListPaperDocsFilterBy deserialize(JsonParser p) throws IOException, JsonParseException {
            ListPaperDocsFilterBy value;
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
            else if ("docs_accessed".equals(tag)) {
                value = ListPaperDocsFilterBy.DOCS_ACCESSED;
            }
            else if ("docs_created".equals(tag)) {
                value = ListPaperDocsFilterBy.DOCS_CREATED;
            }
            else {
                value = ListPaperDocsFilterBy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
