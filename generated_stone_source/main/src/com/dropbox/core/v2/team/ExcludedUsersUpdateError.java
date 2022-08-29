/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

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
 * Excluded users update error.
 */
public enum ExcludedUsersUpdateError {
    // union team.ExcludedUsersUpdateError (team_member_space_limits.stone)
    /**
     * At least one of the users is not part of your team.
     */
    USERS_NOT_IN_TEAM,
    /**
     * A maximum of 1000 users for each of addition/removal can be supplied.
     */
    TOO_MANY_USERS,
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
    static class Serializer extends UnionSerializer<ExcludedUsersUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExcludedUsersUpdateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case USERS_NOT_IN_TEAM: {
                    g.writeString("users_not_in_team");
                    break;
                }
                case TOO_MANY_USERS: {
                    g.writeString("too_many_users");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ExcludedUsersUpdateError deserialize(JsonParser p) throws IOException, JsonParseException {
            ExcludedUsersUpdateError value;
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
            else if ("users_not_in_team".equals(tag)) {
                value = ExcludedUsersUpdateError.USERS_NOT_IN_TEAM;
            }
            else if ("too_many_users".equals(tag)) {
                value = ExcludedUsersUpdateError.TOO_MANY_USERS;
            }
            else {
                value = ExcludedUsersUpdateError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
