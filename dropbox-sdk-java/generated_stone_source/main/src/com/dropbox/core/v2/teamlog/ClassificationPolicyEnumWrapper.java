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
 * Policy for controlling team access to the classification feature
 */
public enum ClassificationPolicyEnumWrapper {
    // union team_log.ClassificationPolicyEnumWrapper (team_log_generated.stone)
    DISABLED,
    ENABLED,
    MEMBER_AND_TEAM_FOLDERS,
    TEAM_FOLDERS,
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
    static class Serializer extends UnionSerializer<ClassificationPolicyEnumWrapper> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ClassificationPolicyEnumWrapper value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DISABLED: {
                    g.writeString("disabled");
                    break;
                }
                case ENABLED: {
                    g.writeString("enabled");
                    break;
                }
                case MEMBER_AND_TEAM_FOLDERS: {
                    g.writeString("member_and_team_folders");
                    break;
                }
                case TEAM_FOLDERS: {
                    g.writeString("team_folders");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ClassificationPolicyEnumWrapper deserialize(JsonParser p) throws IOException, JsonParseException {
            ClassificationPolicyEnumWrapper value;
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
                value = ClassificationPolicyEnumWrapper.DISABLED;
            }
            else if ("enabled".equals(tag)) {
                value = ClassificationPolicyEnumWrapper.ENABLED;
            }
            else if ("member_and_team_folders".equals(tag)) {
                value = ClassificationPolicyEnumWrapper.MEMBER_AND_TEAM_FOLDERS;
            }
            else if ("team_folders".equals(tag)) {
                value = ClassificationPolicyEnumWrapper.TEAM_FOLDERS;
            }
            else {
                value = ClassificationPolicyEnumWrapper.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
