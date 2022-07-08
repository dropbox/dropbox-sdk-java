/* DO NOT EDIT */
/* This file was generated from shared_content_links.stone */

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

/**
 * Actions that can be performed on a link.
 */
public enum LinkAction {
    // union sharing.LinkAction (shared_content_links.stone)
    /**
     * Change the access level of the link.
     */
    CHANGE_ACCESS_LEVEL,
    /**
     * Change the audience of the link.
     */
    CHANGE_AUDIENCE,
    /**
     * Remove the expiry date of the link.
     */
    REMOVE_EXPIRY,
    /**
     * Remove the password of the link.
     */
    REMOVE_PASSWORD,
    /**
     * Create or modify the expiry date of the link.
     */
    SET_EXPIRY,
    /**
     * Create or modify the password of the link.
     */
    SET_PASSWORD,
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
    static class Serializer extends UnionSerializer<LinkAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case CHANGE_ACCESS_LEVEL: {
                    g.writeString("change_access_level");
                    break;
                }
                case CHANGE_AUDIENCE: {
                    g.writeString("change_audience");
                    break;
                }
                case REMOVE_EXPIRY: {
                    g.writeString("remove_expiry");
                    break;
                }
                case REMOVE_PASSWORD: {
                    g.writeString("remove_password");
                    break;
                }
                case SET_EXPIRY: {
                    g.writeString("set_expiry");
                    break;
                }
                case SET_PASSWORD: {
                    g.writeString("set_password");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LinkAction deserialize(JsonParser p) throws IOException, JsonParseException {
            LinkAction value;
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
            else if ("change_access_level".equals(tag)) {
                value = LinkAction.CHANGE_ACCESS_LEVEL;
            }
            else if ("change_audience".equals(tag)) {
                value = LinkAction.CHANGE_AUDIENCE;
            }
            else if ("remove_expiry".equals(tag)) {
                value = LinkAction.REMOVE_EXPIRY;
            }
            else if ("remove_password".equals(tag)) {
                value = LinkAction.REMOVE_PASSWORD;
            }
            else if ("set_expiry".equals(tag)) {
                value = LinkAction.SET_EXPIRY;
            }
            else if ("set_password".equals(tag)) {
                value = LinkAction.SET_PASSWORD;
            }
            else {
                value = LinkAction.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
