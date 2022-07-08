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

public enum TrustedTeamsRequestState {
    // union team_log.TrustedTeamsRequestState (team_log_generated.stone)
    INVITED,
    LINKED,
    UNLINKED,
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
    static class Serializer extends UnionSerializer<TrustedTeamsRequestState> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TrustedTeamsRequestState value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVITED: {
                    g.writeString("invited");
                    break;
                }
                case LINKED: {
                    g.writeString("linked");
                    break;
                }
                case UNLINKED: {
                    g.writeString("unlinked");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TrustedTeamsRequestState deserialize(JsonParser p) throws IOException, JsonParseException {
            TrustedTeamsRequestState value;
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
                value = TrustedTeamsRequestState.INVITED;
            }
            else if ("linked".equals(tag)) {
                value = TrustedTeamsRequestState.LINKED;
            }
            else if ("unlinked".equals(tag)) {
                value = TrustedTeamsRequestState.UNLINKED;
            }
            else {
                value = TrustedTeamsRequestState.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
