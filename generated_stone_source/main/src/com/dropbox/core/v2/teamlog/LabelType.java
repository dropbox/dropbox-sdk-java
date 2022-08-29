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
 * Label type
 */
public enum LabelType {
    // union team_log.LabelType (team_log_generated.stone)
    PERSONAL_INFORMATION,
    TEST_ONLY,
    USER_DEFINED_TAG,
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
    static class Serializer extends UnionSerializer<LabelType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LabelType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PERSONAL_INFORMATION: {
                    g.writeString("personal_information");
                    break;
                }
                case TEST_ONLY: {
                    g.writeString("test_only");
                    break;
                }
                case USER_DEFINED_TAG: {
                    g.writeString("user_defined_tag");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LabelType deserialize(JsonParser p) throws IOException, JsonParseException {
            LabelType value;
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
            else if ("personal_information".equals(tag)) {
                value = LabelType.PERSONAL_INFORMATION;
            }
            else if ("test_only".equals(tag)) {
                value = LabelType.TEST_ONLY;
            }
            else if ("user_defined_tag".equals(tag)) {
                value = LabelType.USER_DEFINED_TAG;
            }
            else {
                value = LabelType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
