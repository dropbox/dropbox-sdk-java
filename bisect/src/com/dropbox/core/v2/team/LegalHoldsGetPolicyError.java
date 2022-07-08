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

public enum LegalHoldsGetPolicyError {
    // union team.LegalHoldsGetPolicyError (team_legal_holds.stone)
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
     * Legal hold policy does not exist for {@link
     * LegalHoldsGetPolicyArg#getId}.
     */
    LEGAL_HOLD_POLICY_NOT_FOUND;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<LegalHoldsGetPolicyError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsGetPolicyError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
        public LegalHoldsGetPolicyError deserialize(JsonParser p) throws IOException, JsonParseException {
            LegalHoldsGetPolicyError value;
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
                value = LegalHoldsGetPolicyError.UNKNOWN_LEGAL_HOLD_ERROR;
            }
            else if ("insufficient_permissions".equals(tag)) {
                value = LegalHoldsGetPolicyError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("other".equals(tag)) {
                value = LegalHoldsGetPolicyError.OTHER;
            }
            else if ("legal_hold_policy_not_found".equals(tag)) {
                value = LegalHoldsGetPolicyError.LEGAL_HOLD_POLICY_NOT_FOUND;
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
