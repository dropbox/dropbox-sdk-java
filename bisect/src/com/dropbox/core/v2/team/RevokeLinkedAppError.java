/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

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
 * Error returned by {@link
 * DbxTeamTeamRequests#linkedAppsRevokeLinkedApp(String,String,boolean)}.
 */
public enum RevokeLinkedAppError {
    // union team.RevokeLinkedAppError (team_linked_apps.stone)
    /**
     * Application not found.
     */
    APP_NOT_FOUND,
    /**
     * Member not found.
     */
    MEMBER_NOT_FOUND,
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
    static class Serializer extends UnionSerializer<RevokeLinkedAppError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeLinkedAppError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case APP_NOT_FOUND: {
                    g.writeString("app_not_found");
                    break;
                }
                case MEMBER_NOT_FOUND: {
                    g.writeString("member_not_found");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public RevokeLinkedAppError deserialize(JsonParser p) throws IOException, JsonParseException {
            RevokeLinkedAppError value;
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
            else if ("app_not_found".equals(tag)) {
                value = RevokeLinkedAppError.APP_NOT_FOUND;
            }
            else if ("member_not_found".equals(tag)) {
                value = RevokeLinkedAppError.MEMBER_NOT_FOUND;
            }
            else {
                value = RevokeLinkedAppError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
