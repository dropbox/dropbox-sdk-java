/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * External Drive Backup eligibility status
 */
public enum ExternalDriveBackupEligibilityStatus {
    // union team_log.ExternalDriveBackupEligibilityStatus (team_log_generated.stone)
    EXCEED_LICENSE_CAP,
    SUCCESS,
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
    static class Serializer extends UnionSerializer<ExternalDriveBackupEligibilityStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExternalDriveBackupEligibilityStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EXCEED_LICENSE_CAP: {
                    g.writeString("exceed_license_cap");
                    break;
                }
                case SUCCESS: {
                    g.writeString("success");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ExternalDriveBackupEligibilityStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            ExternalDriveBackupEligibilityStatus value;
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
            else if ("exceed_license_cap".equals(tag)) {
                value = ExternalDriveBackupEligibilityStatus.EXCEED_LICENSE_CAP;
            }
            else if ("success".equals(tag)) {
                value = ExternalDriveBackupEligibilityStatus.SUCCESS;
            }
            else {
                value = ExternalDriveBackupEligibilityStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
