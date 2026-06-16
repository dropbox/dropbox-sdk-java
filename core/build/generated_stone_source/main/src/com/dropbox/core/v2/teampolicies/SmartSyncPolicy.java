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

public enum SmartSyncPolicy {
    // union team_policies.SmartSyncPolicy (team_policies.stone)
    /**
     * The specified content will be synced as local files by default.
     */
    LOCAL,
    /**
     * The specified content will be synced as on-demand files by default.
     */
    ON_DEMAND,
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
    public static class Serializer extends UnionSerializer<SmartSyncPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SmartSyncPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case LOCAL: {
                    g.writeString("local");
                    break;
                }
                case ON_DEMAND: {
                    g.writeString("on_demand");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SmartSyncPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SmartSyncPolicy value;
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
            else if ("local".equals(tag)) {
                value = SmartSyncPolicy.LOCAL;
            }
            else if ("on_demand".equals(tag)) {
                value = SmartSyncPolicy.ON_DEMAND;
            }
            else {
                value = SmartSyncPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
