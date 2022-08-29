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
 * Policy for deciding whether the team's default expiration days policy must be
 * enforced when an externally shared link is updated
 */
public enum ChangeLinkExpirationPolicy {
    // union team_log.ChangeLinkExpirationPolicy (team_log_generated.stone)
    ALLOWED,
    NOT_ALLOWED,
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
    static class Serializer extends UnionSerializer<ChangeLinkExpirationPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ChangeLinkExpirationPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ALLOWED: {
                    g.writeString("allowed");
                    break;
                }
                case NOT_ALLOWED: {
                    g.writeString("not_allowed");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ChangeLinkExpirationPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            ChangeLinkExpirationPolicy value;
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
            else if ("allowed".equals(tag)) {
                value = ChangeLinkExpirationPolicy.ALLOWED;
            }
            else if ("not_allowed".equals(tag)) {
                value = ChangeLinkExpirationPolicy.NOT_ALLOWED;
            }
            else {
                value = ChangeLinkExpirationPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
