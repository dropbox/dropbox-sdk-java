/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum GetAccountError {
    // union GetAccountError
    /**
     * The specified the {@code accountId} argument to {@link
     * DbxUserUsersRequests#getAccount(String)} does not exist.
     */
    NO_ACCOUNT,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    UNKNOWN; // *catch_all

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<GetAccountError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetAccountError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case NO_ACCOUNT: {
                    g.writeString("no_account");
                    break;
                }
                default: {
                    g.writeString("unknown");
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
                value = GetAccountError.UNKNOWN;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
