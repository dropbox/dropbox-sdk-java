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

public enum MembersUnsuspendError {
    // union team.MembersUnsuspendError (team_members.stone)
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
     * The user is unsuspended, so it cannot be unsuspended again.
     */
    UNSUSPEND_NON_SUSPENDED_MEMBER,
    /**
     * Team is full. The organization has no available licenses.
     */
    TEAM_LICENSE_LIMIT;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<MembersUnsuspendError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersUnsuspendError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case UNSUSPEND_NON_SUSPENDED_MEMBER: {
                    g.writeString("unsuspend_non_suspended_member");
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
        public MembersUnsuspendError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersUnsuspendError value;
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
                value = MembersUnsuspendError.USER_NOT_FOUND;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersUnsuspendError.USER_NOT_IN_TEAM;
            }
            else if ("other".equals(tag)) {
                value = MembersUnsuspendError.OTHER;
            }
            else if ("unsuspend_non_suspended_member".equals(tag)) {
                value = MembersUnsuspendError.UNSUSPEND_NON_SUSPENDED_MEMBER;
            }
            else if ("team_license_limit".equals(tag)) {
                value = MembersUnsuspendError.TEAM_LICENSE_LIMIT;
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
