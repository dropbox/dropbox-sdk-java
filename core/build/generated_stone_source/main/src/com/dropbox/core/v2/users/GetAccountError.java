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

public enum GetAccountError {
    // union users.GetAccountError (users.stone)
    /**
     * The specified {@link GetAccountArg#getAccountId} does not exist.
     */
    NO_ACCOUNT,
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
    public static class Serializer extends UnionSerializer<GetAccountError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetAccountError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case NO_ACCOUNT: {
                    g.writeString("no_account");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GetAccountError deserialize(JsonParser p) throws IOException, JsonParseException {
            GetAccountError value;
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
            else if ("no_account".equals(tag)) {
                value = GetAccountError.NO_ACCOUNT;
            }
            else {
                value = GetAccountError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
