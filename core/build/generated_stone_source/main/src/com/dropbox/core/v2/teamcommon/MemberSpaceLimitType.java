/* DO NOT EDIT */
/* This file was generated from team_common.stone */

package com.dropbox.core.v2.teamcommon;

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
 * The type of the space limit imposed on a team member.
 */
public enum MemberSpaceLimitType {
    // union team_common.MemberSpaceLimitType (team_common.stone)
    /**
     * The team member does not have imposed space limit.
     */
    OFF,
    /**
     * The team member has soft imposed space limit - the limit is used for
     * display and for notifications.
     */
    ALERT_ONLY,
    /**
     * The team member has hard imposed space limit - Dropbox file sync will
     * stop after the limit is reached.
     */
    STOP_SYNC,
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
    public static class Serializer extends UnionSerializer<MemberSpaceLimitType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberSpaceLimitType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case OFF: {
                    g.writeString("off");
                    break;
                }
                case ALERT_ONLY: {
                    g.writeString("alert_only");
                    break;
                }
                case STOP_SYNC: {
                    g.writeString("stop_sync");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MemberSpaceLimitType deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberSpaceLimitType value;
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
            else if ("off".equals(tag)) {
                value = MemberSpaceLimitType.OFF;
            }
            else if ("alert_only".equals(tag)) {
                value = MemberSpaceLimitType.ALERT_ONLY;
            }
            else if ("stop_sync".equals(tag)) {
                value = MemberSpaceLimitType.STOP_SYNC;
            }
            else {
                value = MemberSpaceLimitType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
