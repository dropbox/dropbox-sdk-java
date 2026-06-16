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

public enum UserFeaturesGetValuesBatchError {
    // union users.UserFeaturesGetValuesBatchError (users.stone)
    /**
     * At least one {@link UserFeature} must be included in the {@link
     * UserFeaturesGetValuesBatchArg}.features list.
     */
    EMPTY_FEATURES_LIST,
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
    static class Serializer extends UnionSerializer<UserFeaturesGetValuesBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserFeaturesGetValuesBatchError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EMPTY_FEATURES_LIST: {
                    g.writeString("empty_features_list");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UserFeaturesGetValuesBatchError deserialize(JsonParser p) throws IOException, JsonParseException {
            UserFeaturesGetValuesBatchError value;
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
            else if ("empty_features_list".equals(tag)) {
                value = UserFeaturesGetValuesBatchError.EMPTY_FEATURES_LIST;
            }
            else {
                value = UserFeaturesGetValuesBatchError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
