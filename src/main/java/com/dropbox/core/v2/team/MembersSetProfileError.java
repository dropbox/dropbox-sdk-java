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

public enum MembersSetProfileError {
    // union MembersSetProfileError
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
     * It is unsafe to use both external_id and new_external_id
     */
    EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE,
    /**
     * None of new_email, new_given_name, new_surname, or new_external_id are
     * specified
     */
    NO_NEW_DATA_SPECIFIED,
    /**
     * Email is already reserved for another user.
     */
    EMAIL_RESERVED_FOR_OTHER_USER,
    /**
     * The external ID is already in use by another team member.
     */
    EXTERNAL_ID_USED_BY_OTHER_USER,
    /**
     * Setting profile disallowed
     */
    SET_PROFILE_DISALLOWED,
    /**
     * Parameter new_email cannot be empty.
     */
    PARAM_CANNOT_BE_EMPTY,
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
    static final class Serializer extends UnionSerializer<MembersSetProfileError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetProfileError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case USER_NOT_FOUND: {
                    g.writeString("user_not_found");
                    break;
                }
                case USER_NOT_IN_TEAM: {
                    g.writeString("user_not_in_team");
                    break;
                }
                case EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE: {
                    g.writeString("external_id_and_new_external_id_unsafe");
                    break;
                }
                case NO_NEW_DATA_SPECIFIED: {
                    g.writeString("no_new_data_specified");
                    break;
                }
                case EMAIL_RESERVED_FOR_OTHER_USER: {
                    g.writeString("email_reserved_for_other_user");
                    break;
                }
                case EXTERNAL_ID_USED_BY_OTHER_USER: {
                    g.writeString("external_id_used_by_other_user");
                    break;
                }
                case SET_PROFILE_DISALLOWED: {
                    g.writeString("set_profile_disallowed");
                    break;
                }
                case PARAM_CANNOT_BE_EMPTY: {
                    g.writeString("param_cannot_be_empty");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MembersSetProfileError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersSetProfileError value;
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
                value = MembersSetProfileError.USER_NOT_FOUND;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersSetProfileError.USER_NOT_IN_TEAM;
            }
            else if ("external_id_and_new_external_id_unsafe".equals(tag)) {
                value = MembersSetProfileError.EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE;
            }
            else if ("no_new_data_specified".equals(tag)) {
                value = MembersSetProfileError.NO_NEW_DATA_SPECIFIED;
            }
            else if ("email_reserved_for_other_user".equals(tag)) {
                value = MembersSetProfileError.EMAIL_RESERVED_FOR_OTHER_USER;
            }
            else if ("external_id_used_by_other_user".equals(tag)) {
                value = MembersSetProfileError.EXTERNAL_ID_USED_BY_OTHER_USER;
            }
            else if ("set_profile_disallowed".equals(tag)) {
                value = MembersSetProfileError.SET_PROFILE_DISALLOWED;
            }
            else if ("param_cannot_be_empty".equals(tag)) {
                value = MembersSetProfileError.PARAM_CANNOT_BE_EMPTY;
            }
            else {
                value = MembersSetProfileError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
