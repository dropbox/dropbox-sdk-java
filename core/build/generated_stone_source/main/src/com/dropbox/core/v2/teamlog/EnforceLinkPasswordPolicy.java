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

/**
 * Policy for deciding whether password must be enforced when an externally
 * shared link is updated
 */
public enum EnforceLinkPasswordPolicy {
    // union team_log.EnforceLinkPasswordPolicy (team_log_generated.stone)
    OPTIONAL,
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
    static class Serializer extends UnionSerializer<EnforceLinkPasswordPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(EnforceLinkPasswordPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
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
        public EnforceLinkPasswordPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            EnforceLinkPasswordPolicy value;
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
            else if ("optional".equals(tag)) {
                value = EnforceLinkPasswordPolicy.OPTIONAL;
            }
            else if ("required".equals(tag)) {
                value = EnforceLinkPasswordPolicy.REQUIRED;
            }
            else {
                value = EnforceLinkPasswordPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
