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

public enum TwoStepVerificationPolicy {
    // union team_policies.TwoStepVerificationPolicy (team_policies.stone)
    /**
     * Enabled require two factor authorization.
     */
    REQUIRE_TFA_ENABLE,
    /**
     * Disabled require two factor authorization.
     */
    REQUIRE_TFA_DISABLE,
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
    public static class Serializer extends UnionSerializer<TwoStepVerificationPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TwoStepVerificationPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case REQUIRE_TFA_ENABLE: {
                    g.writeString("require_tfa_enable");
                    break;
                }
                case REQUIRE_TFA_DISABLE: {
                    g.writeString("require_tfa_disable");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TwoStepVerificationPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            TwoStepVerificationPolicy value;
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
            else if ("require_tfa_enable".equals(tag)) {
                value = TwoStepVerificationPolicy.REQUIRE_TFA_ENABLE;
            }
            else if ("require_tfa_disable".equals(tag)) {
                value = TwoStepVerificationPolicy.REQUIRE_TFA_DISABLE;
            }
            else {
                value = TwoStepVerificationPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
