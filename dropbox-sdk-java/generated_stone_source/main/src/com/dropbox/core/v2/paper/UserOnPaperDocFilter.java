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

public enum UserOnPaperDocFilter {
    // union paper.UserOnPaperDocFilter (paper.stone)
    /**
     * all users who have visited the Paper doc.
     */
    VISITED,
    /**
     * All uses who are shared on the Paper doc. This includes all users who
     * have visited the Paper doc as well as those who have not.
     */
    SHARED,
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
    static class Serializer extends UnionSerializer<UserOnPaperDocFilter> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserOnPaperDocFilter value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case VISITED: {
                    g.writeString("visited");
                    break;
                }
                case SHARED: {
                    g.writeString("shared");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UserOnPaperDocFilter deserialize(JsonParser p) throws IOException, JsonParseException {
            UserOnPaperDocFilter value;
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
            else if ("visited".equals(tag)) {
                value = UserOnPaperDocFilter.VISITED;
            }
            else if ("shared".equals(tag)) {
                value = UserOnPaperDocFilter.SHARED;
            }
            else {
                value = UserOnPaperDocFilter.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
