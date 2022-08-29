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
 * External Drive Backup status
 */
public enum ExternalDriveBackupStatus {
    // union team_log.ExternalDriveBackupStatus (team_log_generated.stone)
    BROKEN,
    CREATED,
    CREATED_OR_BROKEN,
    DELETED,
    EMPTY,
    UNKNOWN,
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
    static class Serializer extends UnionSerializer<ExternalDriveBackupStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExternalDriveBackupStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case BROKEN: {
                    g.writeString("broken");
                    break;
                }
                case CREATED: {
                    g.writeString("created");
                    break;
                }
                case CREATED_OR_BROKEN: {
                    g.writeString("created_or_broken");
                    break;
                }
                case DELETED: {
                    g.writeString("deleted");
                    break;
                }
                case EMPTY: {
                    g.writeString("empty");
                    break;
                }
                case UNKNOWN: {
                    g.writeString("unknown");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ExternalDriveBackupStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            ExternalDriveBackupStatus value;
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
            else if ("broken".equals(tag)) {
                value = ExternalDriveBackupStatus.BROKEN;
            }
            else if ("created".equals(tag)) {
                value = ExternalDriveBackupStatus.CREATED;
            }
            else if ("created_or_broken".equals(tag)) {
                value = ExternalDriveBackupStatus.CREATED_OR_BROKEN;
            }
            else if ("deleted".equals(tag)) {
                value = ExternalDriveBackupStatus.DELETED;
            }
            else if ("empty".equals(tag)) {
                value = ExternalDriveBackupStatus.EMPTY;
            }
            else if ("unknown".equals(tag)) {
                value = ExternalDriveBackupStatus.UNKNOWN;
            }
            else {
                value = ExternalDriveBackupStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
