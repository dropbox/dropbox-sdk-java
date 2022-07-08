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

public enum LegalHoldsExportPolicyError {
    // union team.LegalHoldsExportPolicyError (team_legal_holds.stone)
    /**
     * The path provided is invalid.
     */
    INVALID_PATH,
    /**
     * Legal hold is currently performing another operation.
     */
    LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION,
    /**
     * There has been an unknown legal hold error.
     */
    UNKNOWN_LEGAL_HOLD_ERROR,
    /**
     * Temporary infrastructure failure, please retry.
     */
    TRANSIENT_ERROR,
    /**
     * The current team does not have enough space to export the legal hold
     * policy.
     */
    INSUFFICIENT_QUOTA,
    /**
     * The legal hold is not holding any revisions yet
     */
    LEGAL_HOLD_EXPORT_STILL_EMPTY,
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
    static class Serializer extends UnionSerializer<LegalHoldsExportPolicyError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsExportPolicyError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_PATH: {
                    g.writeString("invalid_path");
                    break;
                }
                case LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION: {
                    g.writeString("legal_hold_performing_another_operation");
                    break;
                }
                case UNKNOWN_LEGAL_HOLD_ERROR: {
                    g.writeString("unknown_legal_hold_error");
                    break;
                }
                case TRANSIENT_ERROR: {
                    g.writeString("transient_error");
                    break;
                }
                case INSUFFICIENT_QUOTA: {
                    g.writeString("insufficient_quota");
                    break;
                }
                case LEGAL_HOLD_EXPORT_STILL_EMPTY: {
                    g.writeString("legal_hold_export_still_empty");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LegalHoldsExportPolicyError deserialize(JsonParser p) throws IOException, JsonParseException {
            LegalHoldsExportPolicyError value;
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
            else if ("invalid_path".equals(tag)) {
                value = LegalHoldsExportPolicyError.INVALID_PATH;
            }
            else if ("legal_hold_performing_another_operation".equals(tag)) {
                value = LegalHoldsExportPolicyError.LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION;
            }
            else if ("unknown_legal_hold_error".equals(tag)) {
                value = LegalHoldsExportPolicyError.UNKNOWN_LEGAL_HOLD_ERROR;
            }
            else if ("transient_error".equals(tag)) {
                value = LegalHoldsExportPolicyError.TRANSIENT_ERROR;
            }
            else if ("insufficient_quota".equals(tag)) {
                value = LegalHoldsExportPolicyError.INSUFFICIENT_QUOTA;
            }
            else if ("legal_hold_export_still_empty".equals(tag)) {
                value = LegalHoldsExportPolicyError.LEGAL_HOLD_EXPORT_STILL_EMPTY;
            }
            else {
                value = LegalHoldsExportPolicyError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
