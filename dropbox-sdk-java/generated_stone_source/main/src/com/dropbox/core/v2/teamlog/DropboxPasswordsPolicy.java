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
 * Policy for deciding whether team users can use Dropbox Passwords
 */
public enum DropboxPasswordsPolicy {
    // union team_log.DropboxPasswordsPolicy (team_log_generated.stone)
    DEFAULT,
    DISABLED,
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
    static class Serializer extends UnionSerializer<DropboxPasswordsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DropboxPasswordsPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DEFAULT: {
                    g.writeString("default");
                    break;
                }
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
        public DropboxPasswordsPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            DropboxPasswordsPolicy value;
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
            else if ("default".equals(tag)) {
                value = DropboxPasswordsPolicy.DEFAULT;
            }
            else if ("disabled".equals(tag)) {
                value = DropboxPasswordsPolicy.DISABLED;
            }
            else if ("enabled".equals(tag)) {
                value = DropboxPasswordsPolicy.ENABLED;
            }
            else {
                value = DropboxPasswordsPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
