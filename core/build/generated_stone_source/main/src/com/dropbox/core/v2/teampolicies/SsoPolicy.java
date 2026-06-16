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

public enum SsoPolicy {
    // union team_policies.SsoPolicy (team_policies.stone)
    /**
     * Users will be able to sign in with their Dropbox credentials.
     */
    DISABLED,
    /**
     * Users will be able to sign in with either their Dropbox or single sign-on
     * credentials.
     */
    OPTIONAL,
    /**
     * Users will be required to sign in with their single sign-on credentials.
     */
    REQUIRED,
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
    public static class Serializer extends UnionSerializer<SsoPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SsoPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DISABLED: {
                    g.writeString("disabled");
                    break;
                }
                case OPTIONAL: {
                    g.writeString("optional");
                    break;
                }
                case REQUIRED: {
                    g.writeString("required");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SsoPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SsoPolicy value;
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
                value = SsoPolicy.DISABLED;
            }
            else if ("optional".equals(tag)) {
                value = SsoPolicy.OPTIONAL;
            }
            else if ("required".equals(tag)) {
                value = SsoPolicy.REQUIRED;
            }
            else {
                value = SsoPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
