/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

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

public enum PaperAccessError {
    // union auth.PaperAccessError (auth.stone)
    /**
     * Paper is disabled.
     */
    PAPER_DISABLED,
    /**
     * The provided user has not used Paper yet.
     */
    NOT_PAPER_USER,
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
    public static class Serializer extends UnionSerializer<PaperAccessError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperAccessError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PAPER_DISABLED: {
                    g.writeString("paper_disabled");
                    break;
                }
                case NOT_PAPER_USER: {
                    g.writeString("not_paper_user");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperAccessError deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperAccessError value;
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
            else if ("paper_disabled".equals(tag)) {
                value = PaperAccessError.PAPER_DISABLED;
            }
            else if ("not_paper_user".equals(tag)) {
                value = PaperAccessError.NOT_PAPER_USER;
            }
            else {
                value = PaperAccessError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
