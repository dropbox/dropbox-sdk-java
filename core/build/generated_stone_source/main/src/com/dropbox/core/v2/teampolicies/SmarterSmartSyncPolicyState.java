/* DO NOT EDIT */
/* This file was generated from team_policies.stone */

package com.dropbox.core.v2.teampolicies;

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

public enum SmarterSmartSyncPolicyState {
    // union team_policies.SmarterSmartSyncPolicyState (team_policies.stone)
    /**
     * Smarter Smart Sync feature is disabled.
     */
    DISABLED,
    /**
     * Smarter Smart Sync feature is enabled.
     */
    ENABLED,
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
    public static class Serializer extends UnionSerializer<SmarterSmartSyncPolicyState> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SmarterSmartSyncPolicyState value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DISABLED: {
                    g.writeString("disabled");
                    break;
                }
                case ENABLED: {
                    g.writeString("enabled");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SmarterSmartSyncPolicyState deserialize(JsonParser p) throws IOException, JsonParseException {
            SmarterSmartSyncPolicyState value;
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
                value = SmarterSmartSyncPolicyState.DISABLED;
            }
            else if ("enabled".equals(tag)) {
                value = SmarterSmartSyncPolicyState.ENABLED;
            }
            else {
                value = SmarterSmartSyncPolicyState.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
