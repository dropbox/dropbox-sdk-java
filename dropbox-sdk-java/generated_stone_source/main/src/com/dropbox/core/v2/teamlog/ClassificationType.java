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
 * The type of classification (currently only personal information)
 */
public enum ClassificationType {
    // union team_log.ClassificationType (team_log_generated.stone)
    PERSONAL_INFORMATION,
    PII,
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
    static class Serializer extends UnionSerializer<ClassificationType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ClassificationType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PERSONAL_INFORMATION: {
                    g.writeString("personal_information");
                    break;
                }
                case PII: {
                    g.writeString("pii");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ClassificationType deserialize(JsonParser p) throws IOException, JsonParseException {
            ClassificationType value;
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
                value = ClassificationType.PERSONAL_INFORMATION;
            }
            else if ("pii".equals(tag)) {
                value = ClassificationType.PII;
            }
            else {
                value = ClassificationType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
