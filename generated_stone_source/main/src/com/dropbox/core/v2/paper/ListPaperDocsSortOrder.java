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

public enum ListPaperDocsSortOrder {
    // union paper.ListPaperDocsSortOrder (paper.stone)
    /**
     * Sorts the search result in ascending order.
     */
    ASCENDING,
    /**
     * Sorts the search result in descending order.
     */
    DESCENDING,
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
    static class Serializer extends UnionSerializer<ListPaperDocsSortOrder> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListPaperDocsSortOrder value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ASCENDING: {
                    g.writeString("ascending");
                    break;
                }
                case DESCENDING: {
                    g.writeString("descending");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListPaperDocsSortOrder deserialize(JsonParser p) throws IOException, JsonParseException {
            ListPaperDocsSortOrder value;
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
            else if ("ascending".equals(tag)) {
                value = ListPaperDocsSortOrder.ASCENDING;
            }
            else if ("descending".equals(tag)) {
                value = ListPaperDocsSortOrder.DESCENDING;
            }
            else {
                value = ListPaperDocsSortOrder.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
