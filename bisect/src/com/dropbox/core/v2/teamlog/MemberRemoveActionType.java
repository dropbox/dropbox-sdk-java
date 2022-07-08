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

public enum MemberRemoveActionType {
    // union team_log.MemberRemoveActionType (team_log_generated.stone)
    DELETE,
    OFFBOARD,
    LEAVE,
    OFFBOARD_AND_RETAIN_TEAM_FOLDERS,
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
    static class Serializer extends UnionSerializer<MemberRemoveActionType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberRemoveActionType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DELETE: {
                    g.writeString("delete");
                    break;
                }
                case OFFBOARD: {
                    g.writeString("offboard");
                    break;
                }
                case LEAVE: {
                    g.writeString("leave");
                    break;
                }
                case OFFBOARD_AND_RETAIN_TEAM_FOLDERS: {
                    g.writeString("offboard_and_retain_team_folders");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MemberRemoveActionType deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberRemoveActionType value;
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
            else if ("delete".equals(tag)) {
                value = MemberRemoveActionType.DELETE;
            }
            else if ("offboard".equals(tag)) {
                value = MemberRemoveActionType.OFFBOARD;
            }
            else if ("leave".equals(tag)) {
                value = MemberRemoveActionType.LEAVE;
            }
            else if ("offboard_and_retain_team_folders".equals(tag)) {
                value = MemberRemoveActionType.OFFBOARD_AND_RETAIN_TEAM_FOLDERS;
            }
            else {
                value = MemberRemoveActionType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
