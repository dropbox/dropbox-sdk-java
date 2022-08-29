/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

public enum UploadSessionStartError {
    // union files.UploadSessionStartError (files.stone)
    /**
     * Uploading data not allowed when starting concurrent upload session.
     */
    CONCURRENT_SESSION_DATA_NOT_ALLOWED,
    /**
     * Can not start a closed concurrent upload session.
     */
    CONCURRENT_SESSION_CLOSE_NOT_ALLOWED,
    /**
     * The request payload must be at most 150 MB.
     */
    PAYLOAD_TOO_LARGE,
    /**
     * The content received by the Dropbox server in this call does not match
     * the provided content hash.
     */
    CONTENT_HASH_MISMATCH,
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
    static class Serializer extends UnionSerializer<UploadSessionStartError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionStartError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case CONCURRENT_SESSION_DATA_NOT_ALLOWED: {
                    g.writeString("concurrent_session_data_not_allowed");
                    break;
                }
                case CONCURRENT_SESSION_CLOSE_NOT_ALLOWED: {
                    g.writeString("concurrent_session_close_not_allowed");
                    break;
                }
                case PAYLOAD_TOO_LARGE: {
                    g.writeString("payload_too_large");
                    break;
                }
                case CONTENT_HASH_MISMATCH: {
                    g.writeString("content_hash_mismatch");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UploadSessionStartError deserialize(JsonParser p) throws IOException, JsonParseException {
            UploadSessionStartError value;
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
            else if ("concurrent_session_data_not_allowed".equals(tag)) {
                value = UploadSessionStartError.CONCURRENT_SESSION_DATA_NOT_ALLOWED;
            }
            else if ("concurrent_session_close_not_allowed".equals(tag)) {
                value = UploadSessionStartError.CONCURRENT_SESSION_CLOSE_NOT_ALLOWED;
            }
            else if ("payload_too_large".equals(tag)) {
                value = UploadSessionStartError.PAYLOAD_TOO_LARGE;
            }
            else if ("content_hash_mismatch".equals(tag)) {
                value = UploadSessionStartError.CONTENT_HASH_MISMATCH;
            }
            else {
                value = UploadSessionStartError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
