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

public enum LegalHoldsPolicyReleaseError {
    // union team.LegalHoldsPolicyReleaseError (team_legal_holds.stone)
    /**
     * Legal hold is currently performing another operation.
     */
    LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION,
    /**
     * Legal hold is currently performing a release or is already released.
     */
    LEGAL_HOLD_ALREADY_RELEASING,
    /**
     * Legal hold policy does not exist for {@link
     * LegalHoldsPolicyReleaseArg#getId}.
     */
    LEGAL_HOLD_POLICY_NOT_FOUND,
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
    static class Serializer extends UnionSerializer<LegalHoldsPolicyReleaseError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsPolicyReleaseError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION: {
                    g.writeString("legal_hold_performing_another_operation");
                    break;
                }
                case LEGAL_HOLD_ALREADY_RELEASING: {
                    g.writeString("legal_hold_already_releasing");
                    break;
                }
                case LEGAL_HOLD_POLICY_NOT_FOUND: {
                    g.writeString("legal_hold_policy_not_found");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LegalHoldsPolicyReleaseError deserialize(JsonParser p) throws IOException, JsonParseException {
            LegalHoldsPolicyReleaseError value;
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
            else if ("legal_hold_performing_another_operation".equals(tag)) {
                value = LegalHoldsPolicyReleaseError.LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION;
            }
            else if ("legal_hold_already_releasing".equals(tag)) {
                value = LegalHoldsPolicyReleaseError.LEGAL_HOLD_ALREADY_RELEASING;
            }
            else if ("legal_hold_policy_not_found".equals(tag)) {
                value = LegalHoldsPolicyReleaseError.LEGAL_HOLD_POLICY_NOT_FOUND;
            }
            else {
                value = LegalHoldsPolicyReleaseError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
