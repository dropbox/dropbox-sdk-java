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

public enum MemberStatus {
    // union team_log.MemberStatus (team_log_generated.stone)
    ACTIVE,
    INVITED,
    MOVED_TO_ANOTHER_TEAM,
    NOT_JOINED,
    REMOVED,
    SUSPENDED,
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
    static class Serializer extends UnionSerializer<MemberStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACTIVE: {
                    g.writeString("active");
                    break;
                }
                case INVITED: {
                    g.writeString("invited");
                    break;
                }
                case MOVED_TO_ANOTHER_TEAM: {
                    g.writeString("moved_to_another_team");
                    break;
                }
                case NOT_JOINED: {
                    g.writeString("not_joined");
                    break;
                }
                case REMOVED: {
                    g.writeString("removed");
                    break;
                }
                case SUSPENDED: {
                    g.writeString("suspended");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MemberStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberStatus value;
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
            else if ("active".equals(tag)) {
                value = MemberStatus.ACTIVE;
            }
            else if ("invited".equals(tag)) {
                value = MemberStatus.INVITED;
            }
            else if ("moved_to_another_team".equals(tag)) {
                value = MemberStatus.MOVED_TO_ANOTHER_TEAM;
            }
            else if ("not_joined".equals(tag)) {
                value = MemberStatus.NOT_JOINED;
            }
            else if ("removed".equals(tag)) {
                value = MemberStatus.REMOVED;
            }
            else if ("suspended".equals(tag)) {
                value = MemberStatus.SUSPENDED;
            }
            else {
                value = MemberStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
