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

/**
 * The actual access permissions values of shared links after taking into
 * account user preferences and the team and shared folder settings. Check the
 * {@link RequestedVisibility} for more info on the possible visibility values
 * that can be set by the shared link's owner.
 */
public enum ResolvedVisibility {
    // union sharing.ResolvedVisibility (shared_links.stone)
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
    static class Serializer extends UnionSerializer<ResolvedVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ResolvedVisibility value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ResolvedVisibility deserialize(JsonParser p) throws IOException, JsonParseException {
            ResolvedVisibility value;
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
                value = ResolvedVisibility.PUBLIC;
            }
            else if ("team_only".equals(tag)) {
                value = ResolvedVisibility.TEAM_ONLY;
            }
            else if ("password".equals(tag)) {
                value = ResolvedVisibility.PASSWORD;
            }
            else if ("team_and_password".equals(tag)) {
                value = ResolvedVisibility.TEAM_AND_PASSWORD;
            }
            else if ("shared_folder_only".equals(tag)) {
                value = ResolvedVisibility.SHARED_FOLDER_ONLY;
            }
            else {
                value = ResolvedVisibility.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
