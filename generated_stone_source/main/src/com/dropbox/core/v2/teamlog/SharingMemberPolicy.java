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
 * External sharing policy
 */
public enum SharingMemberPolicy {
    // union team_log.SharingMemberPolicy (team_log_generated.stone)
    ALLOW,
    FORBID,
    FORBID_WITH_EXCLUSIONS,
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
    static class Serializer extends UnionSerializer<SharingMemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingMemberPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ALLOW: {
                    g.writeString("allow");
                    break;
                }
                case FORBID: {
                    g.writeString("forbid");
                    break;
                }
                case FORBID_WITH_EXCLUSIONS: {
                    g.writeString("forbid_with_exclusions");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharingMemberPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SharingMemberPolicy value;
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
            else if ("allow".equals(tag)) {
                value = SharingMemberPolicy.ALLOW;
            }
            else if ("forbid".equals(tag)) {
                value = SharingMemberPolicy.FORBID;
            }
            else if ("forbid_with_exclusions".equals(tag)) {
                value = SharingMemberPolicy.FORBID_WITH_EXCLUSIONS;
            }
            else {
                value = SharingMemberPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
