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

public enum PaperDeploymentPolicy {
    // union team_policies.PaperDeploymentPolicy (team_policies.stone)
    /**
     * All team members have access to Paper.
     */
    FULL,
    /**
     * Only whitelisted team members can access Paper. To see which user is
     * whitelisted, check 'is_paper_whitelisted' on 'account/info'.
     */
    PARTIAL,
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
    public static class Serializer extends UnionSerializer<PaperDeploymentPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDeploymentPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FULL: {
                    g.writeString("full");
                    break;
                }
                case PARTIAL: {
                    g.writeString("partial");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperDeploymentPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperDeploymentPolicy value;
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
            else if ("full".equals(tag)) {
                value = PaperDeploymentPolicy.FULL;
            }
            else if ("partial".equals(tag)) {
                value = PaperDeploymentPolicy.PARTIAL;
            }
            else {
                value = PaperDeploymentPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
