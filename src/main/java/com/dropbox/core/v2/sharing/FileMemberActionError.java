/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum FileMemberActionError {
    // union FileMemberActionError
    /**
     * Specified member was not found.
     */
    INVALID_MEMBER,
    /**
     * User does not have permission to perform this action on this member.
     */
    NO_PERMISSION,
    /**
     * Unknown error when applying action to member.
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<FileMemberActionError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileMemberActionError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_MEMBER: {
                    g.writeString("invalid_member");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileMemberActionError deserialize(JsonParser p) throws IOException, JsonParseException {
            FileMemberActionError value;
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
            else if ("invalid_member".equals(tag)) {
                value = FileMemberActionError.INVALID_MEMBER;
            }
            else if ("no_permission".equals(tag)) {
                value = FileMemberActionError.NO_PERMISSION;
            }
            else {
                value = FileMemberActionError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
