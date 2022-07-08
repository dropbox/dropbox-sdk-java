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

public enum LinkAudience {
    // union sharing.LinkAudience (shared_content_links.stone)
    /**
     * Link is accessible by anyone.
     */
    PUBLIC,
    /**
     * Link is accessible only by team members.
     */
    TEAM,
    /**
     * The link can be used by no one. The link merely points the user to the
     * content, and does not grant additional rights to the user. Members of the
     * content who use this link can only access the content with their
     * pre-existing access rights.
     */
    NO_ONE,
    /**
     * A link-specific password is required to access the link. Login is not
     * required.
     */
    PASSWORD,
    /**
     * Link is accessible only by members of the content.
     */
    MEMBERS,
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
    public static class Serializer extends UnionSerializer<LinkAudience> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkAudience value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PUBLIC: {
                    g.writeString("public");
                    break;
                }
                case TEAM: {
                    g.writeString("team");
                    break;
                }
                case NO_ONE: {
                    g.writeString("no_one");
                    break;
                }
                case PASSWORD: {
                    g.writeString("password");
                    break;
                }
                case MEMBERS: {
                    g.writeString("members");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LinkAudience deserialize(JsonParser p) throws IOException, JsonParseException {
            LinkAudience value;
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
            else if ("public".equals(tag)) {
                value = LinkAudience.PUBLIC;
            }
            else if ("team".equals(tag)) {
                value = LinkAudience.TEAM;
            }
            else if ("no_one".equals(tag)) {
                value = LinkAudience.NO_ONE;
            }
            else if ("password".equals(tag)) {
                value = LinkAudience.PASSWORD;
            }
            else if ("members".equals(tag)) {
                value = LinkAudience.MEMBERS;
            }
            else {
                value = LinkAudience.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
