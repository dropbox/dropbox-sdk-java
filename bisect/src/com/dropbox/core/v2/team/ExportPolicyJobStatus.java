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

public enum ExportPolicyJobStatus {
    // union team.ExportPolicyJobStatus (team_legal_holds.stone)
    /**
     * The asynchronous job is still in progress.
     */
    IN_PROGRESS,
    /**
     * The asynchronous job has finished. Returning the metadata of the newly
     * created folder that includes the exported hold.
     */
    COMPLETE,
    /**
     * The asynchronous job returned an error.
     */
    FAILED,
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
    static class Serializer extends UnionSerializer<ExportPolicyJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExportPolicyJobStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case COMPLETE: {
                    g.writeString("complete");
                    break;
                }
                case FAILED: {
                    g.writeString("failed");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ExportPolicyJobStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            ExportPolicyJobStatus value;
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
            else if ("in_progress".equals(tag)) {
                value = ExportPolicyJobStatus.IN_PROGRESS;
            }
            else if ("complete".equals(tag)) {
                value = ExportPolicyJobStatus.COMPLETE;
            }
            else if ("failed".equals(tag)) {
                value = ExportPolicyJobStatus.FAILED;
            }
            else {
                value = ExportPolicyJobStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
