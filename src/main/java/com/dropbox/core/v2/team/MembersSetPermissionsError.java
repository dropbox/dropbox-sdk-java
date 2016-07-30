/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum MembersSetPermissionsError {
    // union MembersSetPermissionsError
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
     * Cannot remove/grant permissions.
     */
    CANNOT_SET_PERMISSIONS,
    /**
     * Team is full. The organization has no available licenses.
     */
    TEAM_LICENSE_LIMIT,
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
    static final class Serializer extends UnionSerializer<MembersSetPermissionsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetPermissionsError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case TEAM_LICENSE_LIMIT: {
                    g.writeString("team_license_limit");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MembersSetPermissionsError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersSetPermissionsError value;
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
                value = MembersSetPermissionsError.USER_NOT_FOUND;
            }
            else if ("last_admin".equals(tag)) {
                value = MembersSetPermissionsError.LAST_ADMIN;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersSetPermissionsError.USER_NOT_IN_TEAM;
            }
            else if ("cannot_set_permissions".equals(tag)) {
                value = MembersSetPermissionsError.CANNOT_SET_PERMISSIONS;
            }
            else if ("team_license_limit".equals(tag)) {
                value = MembersSetPermissionsError.TEAM_LICENSE_LIMIT;
            }
            else {
                value = MembersSetPermissionsError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
