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

public enum AccountCaptureNotificationType {
    // union team_log.AccountCaptureNotificationType (team_log_generated.stone)
    ACTIONABLE_NOTIFICATION,
    PROACTIVE_WARNING_NOTIFICATION,
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
    static class Serializer extends UnionSerializer<AccountCaptureNotificationType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AccountCaptureNotificationType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACTIONABLE_NOTIFICATION: {
                    g.writeString("actionable_notification");
                    break;
                }
                case PROACTIVE_WARNING_NOTIFICATION: {
                    g.writeString("proactive_warning_notification");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AccountCaptureNotificationType deserialize(JsonParser p) throws IOException, JsonParseException {
            AccountCaptureNotificationType value;
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
            else if ("actionable_notification".equals(tag)) {
                value = AccountCaptureNotificationType.ACTIONABLE_NOTIFICATION;
            }
            else if ("proactive_warning_notification".equals(tag)) {
                value = AccountCaptureNotificationType.PROACTIVE_WARNING_NOTIFICATION;
            }
            else {
                value = AccountCaptureNotificationType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
