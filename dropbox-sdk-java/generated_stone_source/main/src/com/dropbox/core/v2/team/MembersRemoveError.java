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

public enum MembersRemoveError {
    // union team.MembersRemoveError (team_members.stone)
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
     * The user is the last admin of the team, so it cannot be removed from it.
     */
    REMOVE_LAST_ADMIN,
    /**
     * Cannot keep account and transfer the data to another user at the same
     * time.
     */
    CANNOT_KEEP_ACCOUNT_AND_TRANSFER,
    /**
     * Cannot keep account and delete the data at the same time. To keep the
     * account the argument wipe_data should be set to {@code false}.
     */
    CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA,
    /**
     * The email address of the user is too long to be disabled.
     */
    EMAIL_ADDRESS_TOO_LONG_TO_BE_DISABLED,
    /**
     * Cannot keep account of an invited user.
     */
    CANNOT_KEEP_INVITED_USER_ACCOUNT,
    /**
     * Cannot retain team shares when the user's data is marked for deletion on
     * their linked devices. The argument wipe_data should be set to {@code
     * false}.
     */
    CANNOT_RETAIN_SHARES_WHEN_DATA_WIPED,
    /**
     * The user's account must be kept in order to retain team shares. The
     * argument keep_account should be set to {@code true}.
     */
    CANNOT_RETAIN_SHARES_WHEN_NO_ACCOUNT_KEPT,
    /**
     * Externally sharing files, folders, and links must be enabled in team
     * settings in order to retain team shares for the user.
     */
    CANNOT_RETAIN_SHARES_WHEN_TEAM_EXTERNAL_SHARING_OFF,
    /**
     * Only a team admin, can convert this account to a Basic account.
     */
    CANNOT_KEEP_ACCOUNT,
    /**
     * This user content is currently being held. To convert this member's
     * account to a Basic account, you'll first need to remove them from the
     * hold.
     */
    CANNOT_KEEP_ACCOUNT_UNDER_LEGAL_HOLD,
    /**
     * To convert this member to a Basic account, they'll first need to sign in
     * to Dropbox and agree to the terms of service.
     */
    CANNOT_KEEP_ACCOUNT_REQUIRED_TO_SIGN_TOS;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<MembersRemoveError> {
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
                case REMOVE_LAST_ADMIN: {
                    g.writeString("remove_last_admin");
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
                case EMAIL_ADDRESS_TOO_LONG_TO_BE_DISABLED: {
                    g.writeString("email_address_too_long_to_be_disabled");
                    break;
                }
                case CANNOT_KEEP_INVITED_USER_ACCOUNT: {
                    g.writeString("cannot_keep_invited_user_account");
                    break;
                }
                case CANNOT_RETAIN_SHARES_WHEN_DATA_WIPED: {
                    g.writeString("cannot_retain_shares_when_data_wiped");
                    break;
                }
                case CANNOT_RETAIN_SHARES_WHEN_NO_ACCOUNT_KEPT: {
                    g.writeString("cannot_retain_shares_when_no_account_kept");
                    break;
                }
                case CANNOT_RETAIN_SHARES_WHEN_TEAM_EXTERNAL_SHARING_OFF: {
                    g.writeString("cannot_retain_shares_when_team_external_sharing_off");
                    break;
                }
                case CANNOT_KEEP_ACCOUNT: {
                    g.writeString("cannot_keep_account");
                    break;
                }
                case CANNOT_KEEP_ACCOUNT_UNDER_LEGAL_HOLD: {
                    g.writeString("cannot_keep_account_under_legal_hold");
                    break;
                }
                case CANNOT_KEEP_ACCOUNT_REQUIRED_TO_SIGN_TOS: {
                    g.writeString("cannot_keep_account_required_to_sign_tos");
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
            else if ("transfer_admin_user_not_in_team".equals(tag)) {
                value = MembersRemoveError.TRANSFER_ADMIN_USER_NOT_IN_TEAM;
            }
            else if ("transfer_admin_user_not_found".equals(tag)) {
                value = MembersRemoveError.TRANSFER_ADMIN_USER_NOT_FOUND;
            }
            else if ("unspecified_transfer_admin_id".equals(tag)) {
                value = MembersRemoveError.UNSPECIFIED_TRANSFER_ADMIN_ID;
            }
            else if ("transfer_admin_is_not_admin".equals(tag)) {
                value = MembersRemoveError.TRANSFER_ADMIN_IS_NOT_ADMIN;
            }
            else if ("recipient_not_verified".equals(tag)) {
                value = MembersRemoveError.RECIPIENT_NOT_VERIFIED;
            }
            else if ("remove_last_admin".equals(tag)) {
                value = MembersRemoveError.REMOVE_LAST_ADMIN;
            }
            else if ("cannot_keep_account_and_transfer".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_TRANSFER;
            }
            else if ("cannot_keep_account_and_delete_data".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA;
            }
            else if ("email_address_too_long_to_be_disabled".equals(tag)) {
                value = MembersRemoveError.EMAIL_ADDRESS_TOO_LONG_TO_BE_DISABLED;
            }
            else if ("cannot_keep_invited_user_account".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_INVITED_USER_ACCOUNT;
            }
            else if ("cannot_retain_shares_when_data_wiped".equals(tag)) {
                value = MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_DATA_WIPED;
            }
            else if ("cannot_retain_shares_when_no_account_kept".equals(tag)) {
                value = MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_NO_ACCOUNT_KEPT;
            }
            else if ("cannot_retain_shares_when_team_external_sharing_off".equals(tag)) {
                value = MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_TEAM_EXTERNAL_SHARING_OFF;
            }
            else if ("cannot_keep_account".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_ACCOUNT;
            }
            else if ("cannot_keep_account_under_legal_hold".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_ACCOUNT_UNDER_LEGAL_HOLD;
            }
            else if ("cannot_keep_account_required_to_sign_tos".equals(tag)) {
                value = MembersRemoveError.CANNOT_KEEP_ACCOUNT_REQUIRED_TO_SIGN_TOS;
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
