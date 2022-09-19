/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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
 * User account had a problem preventing this action.
 */
public enum SharingUserError {
    // union sharing.SharingUserError (sharing_files.stone)
    /**
     * This user's email address is not verified. This functionality is only
     * available on accounts with a verified email address. Users can verify
     * their email address <a href="https://www.dropbox.com/help/317">here</a>.
     */
    EMAIL_UNVERIFIED,
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
    static class Serializer extends UnionSerializer<SharingUserError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingUserError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EMAIL_UNVERIFIED: {
                    g.writeString("email_unverified");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharingUserError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharingUserError value;
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
            else if ("email_unverified".equals(tag)) {
                value = SharingUserError.EMAIL_UNVERIFIED;
            }
            else {
                value = SharingUserError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
