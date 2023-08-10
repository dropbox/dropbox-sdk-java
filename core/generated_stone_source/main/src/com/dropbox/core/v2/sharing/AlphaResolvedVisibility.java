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

/**
 * check documentation for ResolvedVisibility.
 */
public enum AlphaResolvedVisibility {
    // union sharing.AlphaResolvedVisibility (shared_links.stone)
    /**
     * Anyone who has received the link can access it. No login required.
     */
    PUBLIC,
    /**
     * Only members of the same team can access the link. Login is required.
     */
    TEAM_ONLY,
    /**
     * A link-specific password is required to access the link. Login is not
     * required.
     */
    PASSWORD,
    /**
     * Only members of the same team who have the link-specific password can
     * access the link. Login is required.
     */
    TEAM_AND_PASSWORD,
    /**
     * Only members of the shared folder containing the linked file can access
     * the link. Login is required.
     */
    SHARED_FOLDER_ONLY,
    /**
     * The link merely points the user to the content, and does not grant any
     * additional rights. Existing members of the content who use this link can
     * only access the content with their pre-existing access rights. Either on
     * the file directly, or inherited from a parent folder.
     */
    NO_ONE,
    /**
     * Only the current user can view this link.
     */
    ONLY_YOU,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<AlphaResolvedVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlphaResolvedVisibility value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PUBLIC: {
                    g.writeString("public");
                    break;
                }
                case TEAM_ONLY: {
                    g.writeString("team_only");
                    break;
                }
                case PASSWORD: {
                    g.writeString("password");
                    break;
                }
                case TEAM_AND_PASSWORD: {
                    g.writeString("team_and_password");
                    break;
                }
                case SHARED_FOLDER_ONLY: {
                    g.writeString("shared_folder_only");
                    break;
                }
                case NO_ONE: {
                    g.writeString("no_one");
                    break;
                }
                case ONLY_YOU: {
                    g.writeString("only_you");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public AlphaResolvedVisibility deserialize(JsonParser p) throws IOException, JsonParseException {
            AlphaResolvedVisibility value;
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
                value = AlphaResolvedVisibility.PUBLIC;
            }
            else if ("team_only".equals(tag)) {
                value = AlphaResolvedVisibility.TEAM_ONLY;
            }
            else if ("password".equals(tag)) {
                value = AlphaResolvedVisibility.PASSWORD;
            }
            else if ("team_and_password".equals(tag)) {
                value = AlphaResolvedVisibility.TEAM_AND_PASSWORD;
            }
            else if ("shared_folder_only".equals(tag)) {
                value = AlphaResolvedVisibility.SHARED_FOLDER_ONLY;
            }
            else if ("no_one".equals(tag)) {
                value = AlphaResolvedVisibility.NO_ONE;
            }
            else if ("only_you".equals(tag)) {
                value = AlphaResolvedVisibility.ONLY_YOU;
            }
            else if ("other".equals(tag)) {
                value = AlphaResolvedVisibility.OTHER;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
