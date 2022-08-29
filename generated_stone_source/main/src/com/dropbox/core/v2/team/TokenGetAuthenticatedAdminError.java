/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

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
 * Error returned by {@link DbxTeamTeamRequests#tokenGetAuthenticatedAdmin}.
 */
public enum TokenGetAuthenticatedAdminError {
    // union team.TokenGetAuthenticatedAdminError (team.stone)
    /**
     * The current token is not associated with a team admin, because mappings
     * were not recorded when the token was created. Consider re-authorizing a
     * new access token to record its authenticating admin.
     */
    MAPPING_NOT_FOUND,
    /**
     * Either the team admin that authorized this token is no longer an active
     * member of the team or no longer a team admin.
     */
    ADMIN_NOT_ACTIVE,
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
    static class Serializer extends UnionSerializer<TokenGetAuthenticatedAdminError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TokenGetAuthenticatedAdminError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case MAPPING_NOT_FOUND: {
                    g.writeString("mapping_not_found");
                    break;
                }
                case ADMIN_NOT_ACTIVE: {
                    g.writeString("admin_not_active");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TokenGetAuthenticatedAdminError deserialize(JsonParser p) throws IOException, JsonParseException {
            TokenGetAuthenticatedAdminError value;
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
            else if ("mapping_not_found".equals(tag)) {
                value = TokenGetAuthenticatedAdminError.MAPPING_NOT_FOUND;
            }
            else if ("admin_not_active".equals(tag)) {
                value = TokenGetAuthenticatedAdminError.ADMIN_NOT_ACTIVE;
            }
            else {
                value = TokenGetAuthenticatedAdminError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
