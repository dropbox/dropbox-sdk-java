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

public enum SharedLinkAccessFailureReason {
    // union sharing.SharedLinkAccessFailureReason (shared_links.stone)
    /**
     * User is not logged in.
     */
    LOGIN_REQUIRED,
    /**
     * This user's email address is not verified. This functionality is only
     * available on accounts with a verified email address. Users can verify
     * their email address <a href="https://www.dropbox.com/help/317">here</a>.
     */
    EMAIL_VERIFY_REQUIRED,
    /**
     * The link is password protected.
     */
    PASSWORD_REQUIRED,
    /**
     * Access is allowed for team members only.
     */
    TEAM_ONLY,
    /**
     * Access is allowed for the shared link's owner only.
     */
    OWNER_ONLY,
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
    static class Serializer extends UnionSerializer<SharedLinkAccessFailureReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkAccessFailureReason value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case LOGIN_REQUIRED: {
                    g.writeString("login_required");
                    break;
                }
                case EMAIL_VERIFY_REQUIRED: {
                    g.writeString("email_verify_required");
                    break;
                }
                case PASSWORD_REQUIRED: {
                    g.writeString("password_required");
                    break;
                }
                case TEAM_ONLY: {
                    g.writeString("team_only");
                    break;
                }
                case OWNER_ONLY: {
                    g.writeString("owner_only");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedLinkAccessFailureReason deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedLinkAccessFailureReason value;
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
            else if ("login_required".equals(tag)) {
                value = SharedLinkAccessFailureReason.LOGIN_REQUIRED;
            }
            else if ("email_verify_required".equals(tag)) {
                value = SharedLinkAccessFailureReason.EMAIL_VERIFY_REQUIRED;
            }
            else if ("password_required".equals(tag)) {
                value = SharedLinkAccessFailureReason.PASSWORD_REQUIRED;
            }
            else if ("team_only".equals(tag)) {
                value = SharedLinkAccessFailureReason.TEAM_ONLY;
            }
            else if ("owner_only".equals(tag)) {
                value = SharedLinkAccessFailureReason.OWNER_ONLY;
            }
            else {
                value = SharedLinkAccessFailureReason.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
