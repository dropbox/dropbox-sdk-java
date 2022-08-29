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

public enum InviteMethod {
    // union team_log.InviteMethod (team_log_generated.stone)
    AUTO_APPROVE,
    INVITE_LINK,
    MEMBER_INVITE,
    MOVED_FROM_ANOTHER_TEAM,
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
    static class Serializer extends UnionSerializer<InviteMethod> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(InviteMethod value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case AUTO_APPROVE: {
                    g.writeString("auto_approve");
                    break;
                }
                case INVITE_LINK: {
                    g.writeString("invite_link");
                    break;
                }
                case MEMBER_INVITE: {
                    g.writeString("member_invite");
                    break;
                }
                case MOVED_FROM_ANOTHER_TEAM: {
                    g.writeString("moved_from_another_team");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public InviteMethod deserialize(JsonParser p) throws IOException, JsonParseException {
            InviteMethod value;
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
            else if ("auto_approve".equals(tag)) {
                value = InviteMethod.AUTO_APPROVE;
            }
            else if ("invite_link".equals(tag)) {
                value = InviteMethod.INVITE_LINK;
            }
            else if ("member_invite".equals(tag)) {
                value = InviteMethod.MEMBER_INVITE;
            }
            else if ("moved_from_another_team".equals(tag)) {
                value = InviteMethod.MOVED_FROM_ANOTHER_TEAM;
            }
            else {
                value = InviteMethod.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
