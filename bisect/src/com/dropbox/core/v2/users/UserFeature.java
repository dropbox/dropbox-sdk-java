/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

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
 * A set of features that a Dropbox User account may have configured.
 */
public enum UserFeature {
    // union users.UserFeature (users.stone)
    /**
     * This feature contains information about how the user's Paper files are
     * stored.
     */
    PAPER_AS_FILES,
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
    static class Serializer extends UnionSerializer<UserFeature> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserFeature value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PAPER_AS_FILES: {
                    g.writeString("paper_as_files");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UserFeature deserialize(JsonParser p) throws IOException, JsonParseException {
            UserFeature value;
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
            else if ("paper_as_files".equals(tag)) {
                value = UserFeature.PAPER_AS_FILES;
            }
            else {
                value = UserFeature.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
