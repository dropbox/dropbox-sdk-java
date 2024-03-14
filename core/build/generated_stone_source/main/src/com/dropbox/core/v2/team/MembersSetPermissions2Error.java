/* DO NOT EDIT */
/* This file was generated from team_members.stone */

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

public enum MembersSetPermissions2Error {
    // union team.MembersSetPermissions2Error (team_members.stone)
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * Cannot remove the admin setting of the last admin.
     */
    LAST_ADMIN,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM,
    /**
     * Cannot remove/grant permissions. This can happen if the team member is
     * suspended.
     */
    CANNOT_SET_PERMISSIONS,
    /**
     * No matching role found. At least one of the provided new_roles does not
     * exist on this team.
     */
    ROLE_NOT_FOUND,
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
    static class Serializer extends UnionSerializer<MembersSetPermissions2Error> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetPermissions2Error value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case USER_NOT_FOUND: {
                    g.writeString("user_not_found");
                    break;
                }
                case LAST_ADMIN: {
                    g.writeString("last_admin");
                    break;
                }
                case USER_NOT_IN_TEAM: {
                    g.writeString("user_not_in_team");
                    break;
                }
                case CANNOT_SET_PERMISSIONS: {
                    g.writeString("cannot_set_permissions");
                    break;
                }
                case ROLE_NOT_FOUND: {
                    g.writeString("role_not_found");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MembersSetPermissions2Error deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersSetPermissions2Error value;
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
            else if ("user_not_found".equals(tag)) {
                value = MembersSetPermissions2Error.USER_NOT_FOUND;
            }
            else if ("last_admin".equals(tag)) {
                value = MembersSetPermissions2Error.LAST_ADMIN;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersSetPermissions2Error.USER_NOT_IN_TEAM;
            }
            else if ("cannot_set_permissions".equals(tag)) {
                value = MembersSetPermissions2Error.CANNOT_SET_PERMISSIONS;
            }
            else if ("role_not_found".equals(tag)) {
                value = MembersSetPermissions2Error.ROLE_NOT_FOUND;
            }
            else {
                value = MembersSetPermissions2Error.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
