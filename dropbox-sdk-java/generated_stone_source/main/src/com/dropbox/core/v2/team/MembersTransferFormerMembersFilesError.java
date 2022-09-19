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

public enum MembersTransferFormerMembersFilesError {
    // union team.MembersTransferFormerMembersFilesError (team_members.stone)
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
     * Expected removed user and transfer_dest user to be different.
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
     * The provided transfer_admin_id does not exist on this team.
     */
    TRANSFER_ADMIN_USER_NOT_IN_TEAM,
    /**
     * No matching user found for the argument transfer_admin_id.
     */
    TRANSFER_ADMIN_USER_NOT_FOUND,
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
     * The recipient user's email is not verified.
     */
    RECIPIENT_NOT_VERIFIED,
    /**
     * The user's data is being transferred. Please wait some time before
     * retrying.
     */
    USER_DATA_IS_BEING_TRANSFERRED,
    /**
     * No matching removed user found for the argument user.
     */
    USER_NOT_REMOVED,
    /**
     * User files aren't transferable anymore.
     */
    USER_DATA_CANNOT_BE_TRANSFERRED,
    /**
     * User's data has already been transferred to another user.
     */
    USER_DATA_ALREADY_TRANSFERRED;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<MembersTransferFormerMembersFilesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersTransferFormerMembersFilesError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case TRANSFER_ADMIN_USER_NOT_IN_TEAM: {
                    g.writeString("transfer_admin_user_not_in_team");
                    break;
                }
                case TRANSFER_ADMIN_USER_NOT_FOUND: {
                    g.writeString("transfer_admin_user_not_found");
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
                case RECIPIENT_NOT_VERIFIED: {
                    g.writeString("recipient_not_verified");
                    break;
                }
                case USER_DATA_IS_BEING_TRANSFERRED: {
                    g.writeString("user_data_is_being_transferred");
                    break;
                }
                case USER_NOT_REMOVED: {
                    g.writeString("user_not_removed");
                    break;
                }
                case USER_DATA_CANNOT_BE_TRANSFERRED: {
                    g.writeString("user_data_cannot_be_transferred");
                    break;
                }
                case USER_DATA_ALREADY_TRANSFERRED: {
                    g.writeString("user_data_already_transferred");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public MembersTransferFormerMembersFilesError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersTransferFormerMembersFilesError value;
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
                value = MembersTransferFormerMembersFilesError.USER_NOT_FOUND;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.USER_NOT_IN_TEAM;
            }
            else if ("other".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.OTHER;
            }
            else if ("removed_and_transfer_dest_should_differ".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER;
            }
            else if ("removed_and_transfer_admin_should_differ".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER;
            }
            else if ("transfer_dest_user_not_found".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.TRANSFER_DEST_USER_NOT_FOUND;
            }
            else if ("transfer_dest_user_not_in_team".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.TRANSFER_DEST_USER_NOT_IN_TEAM;
            }
            else if ("transfer_admin_user_not_in_team".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.TRANSFER_ADMIN_USER_NOT_IN_TEAM;
            }
            else if ("transfer_admin_user_not_found".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.TRANSFER_ADMIN_USER_NOT_FOUND;
            }
            else if ("unspecified_transfer_admin_id".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.UNSPECIFIED_TRANSFER_ADMIN_ID;
            }
            else if ("transfer_admin_is_not_admin".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.TRANSFER_ADMIN_IS_NOT_ADMIN;
            }
            else if ("recipient_not_verified".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.RECIPIENT_NOT_VERIFIED;
            }
            else if ("user_data_is_being_transferred".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.USER_DATA_IS_BEING_TRANSFERRED;
            }
            else if ("user_not_removed".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.USER_NOT_REMOVED;
            }
            else if ("user_data_cannot_be_transferred".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.USER_DATA_CANNOT_BE_TRANSFERRED;
            }
            else if ("user_data_already_transferred".equals(tag)) {
                value = MembersTransferFormerMembersFilesError.USER_DATA_ALREADY_TRANSFERRED;
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
