/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum SharedFolderMemberError {
    // union SharedFolderMemberError
    /**
     * The target dropbox_id is invalid.
     */
    INVALID_DROPBOX_ID,
    /**
     * The target dropbox_id is not a member of the shared folder.
     */
    NOT_A_MEMBER,
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
    static final class Serializer extends UnionSerializer<SharedFolderMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMemberError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_DROPBOX_ID: {
                    g.writeString("invalid_dropbox_id");
                    break;
                }
                case NOT_A_MEMBER: {
                    g.writeString("not_a_member");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedFolderMemberError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedFolderMemberError value;
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
            else if ("invalid_dropbox_id".equals(tag)) {
                value = SharedFolderMemberError.INVALID_DROPBOX_ID;
            }
            else if ("not_a_member".equals(tag)) {
                value = SharedFolderMemberError.NOT_A_MEMBER;
            }
            else {
                value = SharedFolderMemberError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
