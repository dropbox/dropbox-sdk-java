/* DO NOT EDIT */
/* This file was generated from team_secondary_mails.stone */

package com.dropbox.core.v2.team;

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
 * Error returned when adding secondary emails fails.
 */
public enum AddSecondaryEmailsError {
    // union team.AddSecondaryEmailsError (team_secondary_mails.stone)
    /**
     * Secondary emails are disabled for the team.
     */
    SECONDARY_EMAILS_DISABLED,
    /**
     * A maximum of 20 secondary emails can be added in a single call.
     */
    TOO_MANY_EMAILS,
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
    static class Serializer extends UnionSerializer<AddSecondaryEmailsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddSecondaryEmailsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case SECONDARY_EMAILS_DISABLED: {
                    g.writeString("secondary_emails_disabled");
                    break;
                }
                case TOO_MANY_EMAILS: {
                    g.writeString("too_many_emails");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AddSecondaryEmailsError deserialize(JsonParser p) throws IOException, JsonParseException {
            AddSecondaryEmailsError value;
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
            else if ("secondary_emails_disabled".equals(tag)) {
                value = AddSecondaryEmailsError.SECONDARY_EMAILS_DISABLED;
            }
            else if ("too_many_emails".equals(tag)) {
                value = AddSecondaryEmailsError.TOO_MANY_EMAILS;
            }
            else {
                value = AddSecondaryEmailsError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
