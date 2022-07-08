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

public enum FedHandshakeAction {
    // union team_log.FedHandshakeAction (team_log_generated.stone)
    INVITED,
    ACCEPTED_INVITE,
    REJECTED_INVITE,
    CANCELED_INVITE,
    REMOVED_TEAM,
    INVITE_EXPIRED,
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
    static class Serializer extends UnionSerializer<FedHandshakeAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FedHandshakeAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVITED: {
                    g.writeString("invited");
                    break;
                }
                case ACCEPTED_INVITE: {
                    g.writeString("accepted_invite");
                    break;
                }
                case REJECTED_INVITE: {
                    g.writeString("rejected_invite");
                    break;
                }
                case CANCELED_INVITE: {
                    g.writeString("canceled_invite");
                    break;
                }
                case REMOVED_TEAM: {
                    g.writeString("removed_team");
                    break;
                }
                case INVITE_EXPIRED: {
                    g.writeString("invite_expired");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FedHandshakeAction deserialize(JsonParser p) throws IOException, JsonParseException {
            FedHandshakeAction value;
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
            else if ("invited".equals(tag)) {
                value = FedHandshakeAction.INVITED;
            }
            else if ("accepted_invite".equals(tag)) {
                value = FedHandshakeAction.ACCEPTED_INVITE;
            }
            else if ("rejected_invite".equals(tag)) {
                value = FedHandshakeAction.REJECTED_INVITE;
            }
            else if ("canceled_invite".equals(tag)) {
                value = FedHandshakeAction.CANCELED_INVITE;
            }
            else if ("removed_team".equals(tag)) {
                value = FedHandshakeAction.REMOVED_TEAM;
            }
            else if ("invite_expired".equals(tag)) {
                value = FedHandshakeAction.INVITE_EXPIRED;
            }
            else {
                value = FedHandshakeAction.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
