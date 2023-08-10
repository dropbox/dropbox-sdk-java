/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

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

public enum LinkAccessLevel {
    // union sharing.LinkAccessLevel (shared_links.stone)
    /**
     * Users who use the link can view and comment on the content.
     */
    VIEWER,
    /**
     * Users who use the link can edit, view and comment on the content.
     */
    EDITOR,
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
    static class Serializer extends UnionSerializer<LinkAccessLevel> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkAccessLevel value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case VIEWER: {
                    g.writeString("viewer");
                    break;
                }
                case EDITOR: {
                    g.writeString("editor");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LinkAccessLevel deserialize(JsonParser p) throws IOException, JsonParseException {
            LinkAccessLevel value;
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
            else if ("viewer".equals(tag)) {
                value = LinkAccessLevel.VIEWER;
            }
            else if ("editor".equals(tag)) {
                value = LinkAccessLevel.EDITOR;
            }
            else {
                value = LinkAccessLevel.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
