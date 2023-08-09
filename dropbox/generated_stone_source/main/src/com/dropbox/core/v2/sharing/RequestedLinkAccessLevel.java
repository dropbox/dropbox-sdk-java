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

public enum RequestedLinkAccessLevel {
    // union sharing.RequestedLinkAccessLevel (shared_links.stone)
    /**
     * Users who use the link can view and comment on the content.
     */
    VIEWER,
    /**
     * Users who use the link can edit, view and comment on the content. Note
     * not all file types support edit links yet.
     */
    EDITOR,
    /**
     * Request for the maximum access level you can set the link to.
     */
    MAX,
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
    static class Serializer extends UnionSerializer<RequestedLinkAccessLevel> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RequestedLinkAccessLevel value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case VIEWER: {
                    g.writeString("viewer");
                    break;
                }
                case EDITOR: {
                    g.writeString("editor");
                    break;
                }
                case MAX: {
                    g.writeString("max");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public RequestedLinkAccessLevel deserialize(JsonParser p) throws IOException, JsonParseException {
            RequestedLinkAccessLevel value;
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
                value = RequestedLinkAccessLevel.VIEWER;
            }
            else if ("editor".equals(tag)) {
                value = RequestedLinkAccessLevel.EDITOR;
            }
            else if ("max".equals(tag)) {
                value = RequestedLinkAccessLevel.MAX;
            }
            else {
                value = RequestedLinkAccessLevel.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
