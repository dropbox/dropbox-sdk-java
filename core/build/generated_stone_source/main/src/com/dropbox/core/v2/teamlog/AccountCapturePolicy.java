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

public enum AccountCapturePolicy {
    // union team_log.AccountCapturePolicy (team_log_generated.stone)
    ALL_USERS,
    DISABLED,
    INVITED_USERS,
    PREVENT_PERSONAL_CREATION,
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
    static class Serializer extends UnionSerializer<AccountCapturePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AccountCapturePolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ALL_USERS: {
                    g.writeString("all_users");
                    break;
                }
                case DISABLED: {
                    g.writeString("disabled");
                    break;
                }
                case INVITED_USERS: {
                    g.writeString("invited_users");
                    break;
                }
                case PREVENT_PERSONAL_CREATION: {
                    g.writeString("prevent_personal_creation");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AccountCapturePolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            AccountCapturePolicy value;
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
            else if ("all_users".equals(tag)) {
                value = AccountCapturePolicy.ALL_USERS;
            }
            else if ("disabled".equals(tag)) {
                value = AccountCapturePolicy.DISABLED;
            }
            else if ("invited_users".equals(tag)) {
                value = AccountCapturePolicy.INVITED_USERS;
            }
            else if ("prevent_personal_creation".equals(tag)) {
                value = AccountCapturePolicy.PREVENT_PERSONAL_CREATION;
            }
            else {
                value = AccountCapturePolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
