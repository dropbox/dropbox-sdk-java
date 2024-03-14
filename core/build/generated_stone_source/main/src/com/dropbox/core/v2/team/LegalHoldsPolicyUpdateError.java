/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

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

public enum LegalHoldsPolicyUpdateError {
    // union team.LegalHoldsPolicyUpdateError (team_legal_holds.stone)
    /**
     * There has been an unknown legal hold error.
     */
    UNKNOWN_LEGAL_HOLD_ERROR,
    /**
     * You don't have permissions to perform this action.
     */
    INSUFFICIENT_PERMISSIONS,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER,
    /**
     * Temporary infrastructure failure, please retry.
     */
    TRANSIENT_ERROR,
    /**
     * Trying to release an inactive legal hold.
     */
    INACTIVE_LEGAL_HOLD,
    /**
     * Legal hold is currently performing another operation.
     */
    LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION,
    /**
     * Some members in the members list are not valid to be placed under legal
     * hold.
     */
    INVALID_MEMBERS,
    /**
     * You cannot add more than 5 users in a legal hold.
     */
    NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION,
    /**
     * The users list must have at least one user.
     */
    EMPTY_MEMBERS_LIST,
    /**
     * The name provided is already in use by another legal hold.
     */
    NAME_MUST_BE_UNIQUE,
    /**
     * Legal hold policy does not exist for {@link
     * LegalHoldsPolicyUpdateArg#getId}.
     */
    LEGAL_HOLD_POLICY_NOT_FOUND;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<LegalHoldsPolicyUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsPolicyUpdateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case UNKNOWN_LEGAL_HOLD_ERROR: {
                    g.writeString("unknown_legal_hold_error");
                    break;
                }
                case INSUFFICIENT_PERMISSIONS: {
                    g.writeString("insufficient_permissions");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case TRANSIENT_ERROR: {
                    g.writeString("transient_error");
                    break;
                }
                case INACTIVE_LEGAL_HOLD: {
                    g.writeString("inactive_legal_hold");
                    break;
                }
                case LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION: {
                    g.writeString("legal_hold_performing_another_operation");
                    break;
                }
                case INVALID_MEMBERS: {
                    g.writeString("invalid_members");
                    break;
                }
                case NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION: {
                    g.writeString("number_of_users_on_hold_is_greater_than_hold_limitation");
                    break;
                }
                case EMPTY_MEMBERS_LIST: {
                    g.writeString("empty_members_list");
                    break;
                }
                case NAME_MUST_BE_UNIQUE: {
                    g.writeString("name_must_be_unique");
                    break;
                }
                case LEGAL_HOLD_POLICY_NOT_FOUND: {
                    g.writeString("legal_hold_policy_not_found");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public LegalHoldsPolicyUpdateError deserialize(JsonParser p) throws IOException, JsonParseException {
            LegalHoldsPolicyUpdateError value;
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
            else if ("unknown_legal_hold_error".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.UNKNOWN_LEGAL_HOLD_ERROR;
            }
            else if ("insufficient_permissions".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("other".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.OTHER;
            }
            else if ("transient_error".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.TRANSIENT_ERROR;
            }
            else if ("inactive_legal_hold".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.INACTIVE_LEGAL_HOLD;
            }
            else if ("legal_hold_performing_another_operation".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION;
            }
            else if ("invalid_members".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.INVALID_MEMBERS;
            }
            else if ("number_of_users_on_hold_is_greater_than_hold_limitation".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION;
            }
            else if ("empty_members_list".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.EMPTY_MEMBERS_LIST;
            }
            else if ("name_must_be_unique".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.NAME_MUST_BE_UNIQUE;
            }
            else if ("legal_hold_policy_not_found".equals(tag)) {
                value = LegalHoldsPolicyUpdateError.LEGAL_HOLD_POLICY_NOT_FOUND;
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
