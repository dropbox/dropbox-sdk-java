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
 * Policy for controlling if team members can join shared folders owned by non
 * team members.
 */
public enum SharingFolderJoinPolicy {
    // union team_log.SharingFolderJoinPolicy (team_log_generated.stone)
    FROM_ANYONE,
    FROM_TEAM_ONLY,
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
    static class Serializer extends UnionSerializer<SharingFolderJoinPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingFolderJoinPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FROM_ANYONE: {
                    g.writeString("from_anyone");
                    break;
                }
                case FROM_TEAM_ONLY: {
                    g.writeString("from_team_only");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharingFolderJoinPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SharingFolderJoinPolicy value;
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
            else if ("from_anyone".equals(tag)) {
                value = SharingFolderJoinPolicy.FROM_ANYONE;
            }
            else if ("from_team_only".equals(tag)) {
                value = SharingFolderJoinPolicy.FROM_TEAM_ONLY;
            }
            else {
                value = SharingFolderJoinPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
