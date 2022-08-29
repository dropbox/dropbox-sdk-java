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

public enum PasswordStrengthPolicy {
    // union team_policies.PasswordStrengthPolicy (team_policies.stone)
    /**
     * User passwords will adhere to the minimal password strength policy.
     */
    MINIMAL_REQUIREMENTS,
    /**
     * User passwords will adhere to the moderate password strength policy.
     */
    MODERATE_PASSWORD,
    /**
     * User passwords will adhere to the very strong password strength policy.
     */
    STRONG_PASSWORD,
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
    public static class Serializer extends UnionSerializer<PasswordStrengthPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PasswordStrengthPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case MINIMAL_REQUIREMENTS: {
                    g.writeString("minimal_requirements");
                    break;
                }
                case MODERATE_PASSWORD: {
                    g.writeString("moderate_password");
                    break;
                }
                case STRONG_PASSWORD: {
                    g.writeString("strong_password");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PasswordStrengthPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            PasswordStrengthPolicy value;
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
            else if ("minimal_requirements".equals(tag)) {
                value = PasswordStrengthPolicy.MINIMAL_REQUIREMENTS;
            }
            else if ("moderate_password".equals(tag)) {
                value = PasswordStrengthPolicy.MODERATE_PASSWORD;
            }
            else if ("strong_password".equals(tag)) {
                value = PasswordStrengthPolicy.STRONG_PASSWORD;
            }
            else {
                value = PasswordStrengthPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
