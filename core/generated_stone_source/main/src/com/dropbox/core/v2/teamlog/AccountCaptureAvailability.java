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

public enum AccountCaptureAvailability {
    // union team_log.AccountCaptureAvailability (team_log_generated.stone)
    AVAILABLE,
    UNAVAILABLE,
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
    static class Serializer extends UnionSerializer<AccountCaptureAvailability> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AccountCaptureAvailability value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case AVAILABLE: {
                    g.writeString("available");
                    break;
                }
                case UNAVAILABLE: {
                    g.writeString("unavailable");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AccountCaptureAvailability deserialize(JsonParser p) throws IOException, JsonParseException {
            AccountCaptureAvailability value;
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
            else if ("available".equals(tag)) {
                value = AccountCaptureAvailability.AVAILABLE;
            }
            else if ("unavailable".equals(tag)) {
                value = AccountCaptureAvailability.UNAVAILABLE;
            }
            else {
                value = AccountCaptureAvailability.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
