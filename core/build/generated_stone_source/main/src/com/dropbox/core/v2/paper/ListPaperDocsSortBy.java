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

public enum ListPaperDocsSortBy {
    // union paper.ListPaperDocsSortBy (paper.stone)
    /**
     * Sorts the Paper docs by the time they were last accessed.
     */
    ACCESSED,
    /**
     * Sorts the Paper docs by the time they were last modified.
     */
    MODIFIED,
    /**
     * Sorts the Paper docs by the creation time.
     */
    CREATED,
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
    static class Serializer extends UnionSerializer<ListPaperDocsSortBy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListPaperDocsSortBy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACCESSED: {
                    g.writeString("accessed");
                    break;
                }
                case MODIFIED: {
                    g.writeString("modified");
                    break;
                }
                case CREATED: {
                    g.writeString("created");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListPaperDocsSortBy deserialize(JsonParser p) throws IOException, JsonParseException {
            ListPaperDocsSortBy value;
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
            else if ("accessed".equals(tag)) {
                value = ListPaperDocsSortBy.ACCESSED;
            }
            else if ("modified".equals(tag)) {
                value = ListPaperDocsSortBy.MODIFIED;
            }
            else if ("created".equals(tag)) {
                value = ListPaperDocsSortBy.CREATED;
            }
            else {
                value = ListPaperDocsSortBy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
