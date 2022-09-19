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
 * Policy for controlling whether team members can send team invites
 */
public enum MemberSendInvitePolicy {
    // union team_log.MemberSendInvitePolicy (team_log_generated.stone)
    DISABLED,
    EVERYONE,
    SPECIFIC_MEMBERS,
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
    static class Serializer extends UnionSerializer<MemberSendInvitePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberSendInvitePolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DISABLED: {
                    g.writeString("disabled");
                    break;
                }
                case EVERYONE: {
                    g.writeString("everyone");
                    break;
                }
                case SPECIFIC_MEMBERS: {
                    g.writeString("specific_members");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MemberSendInvitePolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberSendInvitePolicy value;
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
            else if ("disabled".equals(tag)) {
                value = MemberSendInvitePolicy.DISABLED;
            }
            else if ("everyone".equals(tag)) {
                value = MemberSendInvitePolicy.EVERYONE;
            }
            else if ("specific_members".equals(tag)) {
                value = MemberSendInvitePolicy.SPECIFIC_MEMBERS;
            }
            else {
                value = MemberSendInvitePolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
