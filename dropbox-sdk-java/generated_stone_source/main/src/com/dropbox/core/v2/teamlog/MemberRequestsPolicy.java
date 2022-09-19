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

public enum MemberRequestsPolicy {
    // union team_log.MemberRequestsPolicy (team_log_generated.stone)
    AUTO_ACCEPT,
    DISABLED,
    REQUIRE_APPROVAL,
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
    static class Serializer extends UnionSerializer<MemberRequestsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberRequestsPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case AUTO_ACCEPT: {
                    g.writeString("auto_accept");
                    break;
                }
                case DISABLED: {
                    g.writeString("disabled");
                    break;
                }
                case REQUIRE_APPROVAL: {
                    g.writeString("require_approval");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MemberRequestsPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberRequestsPolicy value;
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
            else if ("auto_accept".equals(tag)) {
                value = MemberRequestsPolicy.AUTO_ACCEPT;
            }
            else if ("disabled".equals(tag)) {
                value = MemberRequestsPolicy.DISABLED;
            }
            else if ("require_approval".equals(tag)) {
                value = MemberRequestsPolicy.REQUIRE_APPROVAL;
            }
            else {
                value = MemberRequestsPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
