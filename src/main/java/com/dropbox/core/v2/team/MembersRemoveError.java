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

public enum MembersRemoveError {
    // union MembersRemoveError
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
     * An unspecified error.
     */
    OTHER,
    /**
     * The user is the last admin of the team, so it cannot be removed from it.
     */
    REMOVE_LAST_ADMIN,
    /**
     * Expected removed user and transfer_dest user to be different
     */
    REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER,
    /**
     * Expected removed user and transfer_admin user to be different.
     */
    REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER,
    /**
     * No matching user found for the argument transfer_dest_id.
     */
    TRANSFER_DEST_USER_NOT_FOUND,
    /**
     * The provided transfer_dest_id does not exist on this team.
     */
    TRANSFER_DEST_USER_NOT_IN_TEAM,
    /**
     * No matching user found for the argument transfer_admin_id.
     */
    TRANSFER_ADMIN_USER_NOT_FOUND,
    /**
     * The provided transfer_admin_id does not exist on this team.
     */
    TRANSFER_ADMIN_USER_NOT_IN_TEAM,
    /**
     * The transfer_admin_id argument must be provided when file transfer is
     * requested.
     */
    UNSPECIFIED_TRANSFER_ADMIN_ID,
    /**
     * Specified transfer_admin user is not a team admin.
     */
    TRANSFER_ADMIN_IS_NOT_ADMIN,
    /**
     * Cannot keep account and transfer the data to another user at the same
     * time.
     */
    CANNOT_KEEP_ACCOUNT_AND_TRANSFER,
    /**
     * Cannot keep account and delete the data at the same time.
     */
    CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<MembersRemoveError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersRemoveError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case REMOVE_LAST_ADMIN: {
                    g.writeString("remove_last_admin");
                    break;
                }
                case REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER: {
                    g.writeString("removed_and_transfer_dest_should_differ");
                    break;
                }
                case REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER: {
                    g.writeString("removed_and_transfer_admin_should_differ");
                    break;
                }
                case TRANSFER_DEST_USER_NOT_FOUND: {
                    g.writeString("transfer_dest_user_not_found");
                    break;
                }
                case TRANSFER_DEST_USER_NOT_IN_TEAM: {
                    g.writeString("transfer_dest_user_not_in_team");
                    break;
                }
                case TRANSFER_ADMIN_USER_NOT_FOUND: {
                    g.writeString("transfer_admin_user_not_found");
                    break;
                }
                case TRANSFER_ADMIN_USER_NOT_IN_TEAM: {
                    g.writeString("transfer_admin_user_not_in_team");
                    break;
                }
                case UNSPECIFIED_TRANSFER_ADMIN_ID: {
                    g.writeString("unspecified_transfer_admin_id");
                    break;
                }
                case TRANSFER_ADMIN_IS_NOT_ADMIN: {
                    g.writeString("transfer_admin_is_not_admin");
                    break;
                }
                case CANNOT_KEEP_ACCOUNT_AND_TRANSFER: {
                    g.writeString("cannot_keep_account_and_transfer");
                    break;
                }
                case CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA: {
                    g.writeString("cannot_keep_account_and_delete_data");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public MembersRemoveError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersRemoveError value;
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
                value = MembersRemoveError.USER_NOT_FOUND;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersRemoveError.USER_NOT_IN_TEAM;
            }
            else if ("other".equals(tag)) {
                value = MembersRemoveError.OTHER;
            }
            else if ("remove_last_admin".equals(tag)) {
                value = MembersRemoveError.REMOVE_LAST_ADMIN;
            }
            else if ("removed_and_transfer_dest_should_differ".equals(tag)) {
                value = MembersRemoveError.REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER;
            }
            else if ("removed_and_transfer_admin_should_differ".equals(tag)) {
                value = MembersRemoveError.REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER;
            }
            else if ("transfer_dest_user_not_found".equals(tag)) {
                value = MembersRemoveError.TRANSFER_DEST_USER_NOT_FOUND;
            }
            else if ("transfer_dest_user_not_in_team".equals(tag)) {
                value = MembersRemoveError.TRANSFER_DEST_USER_NOT_IN_TEAM;
            }
            else if ("transfer_admin_user_not_found".equals(tag)) {
                value = MembersRemoveError.TRANSFER_ADMIN_USER_NOT_FOUND;
            }
            else if ("transfer_admin_user_not_in_team".equals(tag)) {
                value = MembersRemoveError.TRANSFER_ADMIN_USER_NOT_IN_TEAM;
            }
            else if ("unspecified_transfer_admin_id".equals(tag)) {
                value = MembersRemoveError.UNSPECIFIED_TRANSFER_ADMIN_ID;
            }
            else if ("transfer_admin_is_not_admin".equals(tag)) {
                value = MembersRemoveError.TRANSFER_ADMIN_IS_NOT_ADMIN;
            }
            else if ("cannot_keep_account_and_transfer".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_TRANSFER;
            }
            else if ("cannot_keep_account_and_delete_data".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
