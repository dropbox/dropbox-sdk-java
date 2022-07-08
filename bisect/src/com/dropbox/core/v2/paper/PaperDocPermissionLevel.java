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

public enum PaperDocPermissionLevel {
    // union paper.PaperDocPermissionLevel (paper.stone)
    /**
     * User will be granted edit permissions.
     */
    EDIT,
    /**
     * User will be granted view and comment permissions.
     */
    VIEW_AND_COMMENT,
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
    static class Serializer extends UnionSerializer<PaperDocPermissionLevel> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocPermissionLevel value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EDIT: {
                    g.writeString("edit");
                    break;
                }
                case VIEW_AND_COMMENT: {
                    g.writeString("view_and_comment");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperDocPermissionLevel deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperDocPermissionLevel value;
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
            else if ("edit".equals(tag)) {
                value = PaperDocPermissionLevel.EDIT;
            }
            else if ("view_and_comment".equals(tag)) {
                value = PaperDocPermissionLevel.VIEW_AND_COMMENT;
            }
            else {
                value = PaperDocPermissionLevel.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
