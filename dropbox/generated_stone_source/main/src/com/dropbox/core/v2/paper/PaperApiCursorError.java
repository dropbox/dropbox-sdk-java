/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

public enum PaperApiCursorError {
    // union paper.PaperApiCursorError (paper.stone)
    /**
     * The provided cursor is expired.
     */
    EXPIRED_CURSOR,
    /**
     * The provided cursor is invalid.
     */
    INVALID_CURSOR,
    /**
     * The provided cursor contains invalid user.
     */
    WRONG_USER_IN_CURSOR,
    /**
     * Indicates that the cursor has been invalidated. Call the corresponding
     * non-continue endpoint to obtain a new cursor.
     */
    RESET,
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
    static class Serializer extends UnionSerializer<PaperApiCursorError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperApiCursorError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EXPIRED_CURSOR: {
                    g.writeString("expired_cursor");
                    break;
                }
                case INVALID_CURSOR: {
                    g.writeString("invalid_cursor");
                    break;
                }
                case WRONG_USER_IN_CURSOR: {
                    g.writeString("wrong_user_in_cursor");
                    break;
                }
                case RESET: {
                    g.writeString("reset");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperApiCursorError deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperApiCursorError value;
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
            else if ("expired_cursor".equals(tag)) {
                value = PaperApiCursorError.EXPIRED_CURSOR;
            }
            else if ("invalid_cursor".equals(tag)) {
                value = PaperApiCursorError.INVALID_CURSOR;
            }
            else if ("wrong_user_in_cursor".equals(tag)) {
                value = PaperApiCursorError.WRONG_USER_IN_CURSOR;
            }
            else if ("reset".equals(tag)) {
                value = PaperApiCursorError.RESET;
            }
            else {
                value = PaperApiCursorError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
