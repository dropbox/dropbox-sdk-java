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

public enum LegalHoldsListPoliciesError {
    // union team.LegalHoldsListPoliciesError (team_legal_holds.stone)
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
    TRANSIENT_ERROR;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<LegalHoldsListPoliciesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsListPoliciesError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public LegalHoldsListPoliciesError deserialize(JsonParser p) throws IOException, JsonParseException {
            LegalHoldsListPoliciesError value;
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
                value = LegalHoldsListPoliciesError.UNKNOWN_LEGAL_HOLD_ERROR;
            }
            else if ("insufficient_permissions".equals(tag)) {
                value = LegalHoldsListPoliciesError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("other".equals(tag)) {
                value = LegalHoldsListPoliciesError.OTHER;
            }
            else if ("transient_error".equals(tag)) {
                value = LegalHoldsListPoliciesError.TRANSIENT_ERROR;
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
