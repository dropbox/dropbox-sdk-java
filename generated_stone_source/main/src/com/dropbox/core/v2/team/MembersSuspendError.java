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

public enum MembersSuspendError {
    // union team.MembersSuspendError (team_members.stone)
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER,
    /**
     * The user is not active, so it cannot be suspended.
     */
    SUSPEND_INACTIVE_USER,
    /**
     * The user is the last admin of the team, so it cannot be suspended.
     */
    SUSPEND_LAST_ADMIN,
    /**
     * Team is full. The organization has no available licenses.
     */
    TEAM_LICENSE_LIMIT;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<MembersSuspendError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSuspendError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case USER_NOT_FOUND: {
                    g.writeString("user_not_found");
                    break;
                }
                case USER_NOT_IN_TEAM: {
                    g.writeString("user_not_in_team");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case SUSPEND_INACTIVE_USER: {
                    g.writeString("suspend_inactive_user");
                    break;
                }
                case SUSPEND_LAST_ADMIN: {
                    g.writeString("suspend_last_admin");
                    break;
                }
                case TEAM_LICENSE_LIMIT: {
                    g.writeString("team_license_limit");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public MembersSuspendError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersSuspendError value;
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
                value = MembersSuspendError.USER_NOT_FOUND;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersSuspendError.USER_NOT_IN_TEAM;
            }
            else if ("other".equals(tag)) {
                value = MembersSuspendError.OTHER;
            }
            else if ("suspend_inactive_user".equals(tag)) {
                value = MembersSuspendError.SUSPEND_INACTIVE_USER;
            }
            else if ("suspend_last_admin".equals(tag)) {
                value = MembersSuspendError.SUSPEND_LAST_ADMIN;
            }
            else if ("team_license_limit".equals(tag)) {
                value = MembersSuspendError.TEAM_LICENSE_LIMIT;
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
