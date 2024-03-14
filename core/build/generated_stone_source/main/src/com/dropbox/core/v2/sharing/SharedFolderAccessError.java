/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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
 * There is an error accessing the shared folder.
 */
public enum SharedFolderAccessError {
    // union sharing.SharedFolderAccessError (sharing_folders.stone)
    /**
     * This shared folder ID is invalid.
     */
    INVALID_ID,
    /**
     * The user is not a member of the shared folder thus cannot access it.
     */
    NOT_A_MEMBER,
    /**
     * The user does not exist or their account is disabled.
     */
    INVALID_MEMBER,
    /**
     * Never set.
     */
    EMAIL_UNVERIFIED,
    /**
     * The shared folder is unmounted.
     */
    UNMOUNTED,
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
    static class Serializer extends UnionSerializer<SharedFolderAccessError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderAccessError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_ID: {
                    g.writeString("invalid_id");
                    break;
                }
                case NOT_A_MEMBER: {
                    g.writeString("not_a_member");
                    break;
                }
                case INVALID_MEMBER: {
                    g.writeString("invalid_member");
                    break;
                }
                case EMAIL_UNVERIFIED: {
                    g.writeString("email_unverified");
                    break;
                }
                case UNMOUNTED: {
                    g.writeString("unmounted");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedFolderAccessError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedFolderAccessError value;
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
            else if ("invalid_id".equals(tag)) {
                value = SharedFolderAccessError.INVALID_ID;
            }
            else if ("not_a_member".equals(tag)) {
                value = SharedFolderAccessError.NOT_A_MEMBER;
            }
            else if ("invalid_member".equals(tag)) {
                value = SharedFolderAccessError.INVALID_MEMBER;
            }
            else if ("email_unverified".equals(tag)) {
                value = SharedFolderAccessError.EMAIL_UNVERIFIED;
            }
            else if ("unmounted".equals(tag)) {
                value = SharedFolderAccessError.UNMOUNTED;
            }
            else {
                value = SharedFolderAccessError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
