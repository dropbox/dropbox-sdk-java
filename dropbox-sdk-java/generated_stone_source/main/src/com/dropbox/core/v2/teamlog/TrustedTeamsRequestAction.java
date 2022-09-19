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

public enum TrustedTeamsRequestAction {
    // union team_log.TrustedTeamsRequestAction (team_log_generated.stone)
    ACCEPTED,
    DECLINED,
    EXPIRED,
    INVITED,
    REVOKED,
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
    static class Serializer extends UnionSerializer<TrustedTeamsRequestAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TrustedTeamsRequestAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACCEPTED: {
                    g.writeString("accepted");
                    break;
                }
                case DECLINED: {
                    g.writeString("declined");
                    break;
                }
                case EXPIRED: {
                    g.writeString("expired");
                    break;
                }
                case INVITED: {
                    g.writeString("invited");
                    break;
                }
                case REVOKED: {
                    g.writeString("revoked");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TrustedTeamsRequestAction deserialize(JsonParser p) throws IOException, JsonParseException {
            TrustedTeamsRequestAction value;
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
            else if ("accepted".equals(tag)) {
                value = TrustedTeamsRequestAction.ACCEPTED;
            }
            else if ("declined".equals(tag)) {
                value = TrustedTeamsRequestAction.DECLINED;
            }
            else if ("expired".equals(tag)) {
                value = TrustedTeamsRequestAction.EXPIRED;
            }
            else if ("invited".equals(tag)) {
                value = TrustedTeamsRequestAction.INVITED;
            }
            else if ("revoked".equals(tag)) {
                value = TrustedTeamsRequestAction.REVOKED;
            }
            else {
                value = TrustedTeamsRequestAction.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
