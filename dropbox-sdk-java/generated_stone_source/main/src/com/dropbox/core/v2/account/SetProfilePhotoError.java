/* DO NOT EDIT */
/* This file was generated from account.stone */

package com.dropbox.core.v2.account;

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

public enum SetProfilePhotoError {
    // union account.SetProfilePhotoError (account.stone)
    /**
     * File cannot be set as profile photo.
     */
    FILE_TYPE_ERROR,
    /**
     * File cannot exceed 10 MB.
     */
    FILE_SIZE_ERROR,
    /**
     * Image must be larger than 128 x 128.
     */
    DIMENSION_ERROR,
    /**
     * Image could not be thumbnailed.
     */
    THUMBNAIL_ERROR,
    /**
     * Temporary infrastructure failure, please retry.
     */
    TRANSIENT_ERROR,
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
    public static class Serializer extends UnionSerializer<SetProfilePhotoError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SetProfilePhotoError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FILE_TYPE_ERROR: {
                    g.writeString("file_type_error");
                    break;
                }
                case FILE_SIZE_ERROR: {
                    g.writeString("file_size_error");
                    break;
                }
                case DIMENSION_ERROR: {
                    g.writeString("dimension_error");
                    break;
                }
                case THUMBNAIL_ERROR: {
                    g.writeString("thumbnail_error");
                    break;
                }
                case TRANSIENT_ERROR: {
                    g.writeString("transient_error");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SetProfilePhotoError deserialize(JsonParser p) throws IOException, JsonParseException {
            SetProfilePhotoError value;
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
            else if ("file_type_error".equals(tag)) {
                value = SetProfilePhotoError.FILE_TYPE_ERROR;
            }
            else if ("file_size_error".equals(tag)) {
                value = SetProfilePhotoError.FILE_SIZE_ERROR;
            }
            else if ("dimension_error".equals(tag)) {
                value = SetProfilePhotoError.DIMENSION_ERROR;
            }
            else if ("thumbnail_error".equals(tag)) {
                value = SetProfilePhotoError.THUMBNAIL_ERROR;
            }
            else if ("transient_error".equals(tag)) {
                value = SetProfilePhotoError.TRANSIENT_ERROR;
            }
            else {
                value = SetProfilePhotoError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
