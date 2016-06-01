/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Errors occurred during authentication.
 */
public enum AuthError {
    // union AuthError
    /**
     * The access token is invalid.
     */
    INVALID_ACCESS_TOKEN,
    /**
     * The user specified in 'Dropbox-API-Select-User' is no longer on the team.
     */
    INVALID_SELECT_USER,
    /**
     * The user specified in 'Dropbox-API-Select-Admin' is not a Dropbox
     * Business team admin.
     */
    INVALID_SELECT_ADMIN,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<AuthError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AuthError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_ACCESS_TOKEN: {
                    g.writeString("invalid_access_token");
                    break;
                }
                case INVALID_SELECT_USER: {
                    g.writeString("invalid_select_user");
                    break;
                }
                case INVALID_SELECT_ADMIN: {
                    g.writeString("invalid_select_admin");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AuthError deserialize(JsonParser p) throws IOException, JsonParseException {
            AuthError value;
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
            else if ("invalid_access_token".equals(tag)) {
                value = AuthError.INVALID_ACCESS_TOKEN;
            }
            else if ("invalid_select_user".equals(tag)) {
                value = AuthError.INVALID_SELECT_USER;
            }
            else if ("invalid_select_admin".equals(tag)) {
                value = AuthError.INVALID_SELECT_ADMIN;
            }
            else {
                value = AuthError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
