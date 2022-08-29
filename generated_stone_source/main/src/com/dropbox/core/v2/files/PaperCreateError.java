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

public enum PaperCreateError {
    // union files.PaperCreateError (files.stone)
    /**
     * Your account does not have permissions to edit Paper docs.
     */
    INSUFFICIENT_PERMISSIONS,
    /**
     * The provided content was malformed and cannot be imported to Paper.
     */
    CONTENT_MALFORMED,
    /**
     * The Paper doc would be too large, split the content into multiple docs.
     */
    DOC_LENGTH_EXCEEDED,
    /**
     * The imported document contains an image that is too large. The current
     * limit is 1MB. This only applies to HTML with data URI.
     */
    IMAGE_SIZE_EXCEEDED,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER,
    /**
     * The file could not be saved to the specified location.
     */
    INVALID_PATH,
    /**
     * The user's email must be verified to create Paper docs.
     */
    EMAIL_UNVERIFIED,
    /**
     * The file path must end in .paper.
     */
    INVALID_FILE_EXTENSION,
    /**
     * Paper is disabled for your team.
     */
    PAPER_DISABLED;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<PaperCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperCreateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INSUFFICIENT_PERMISSIONS: {
                    g.writeString("insufficient_permissions");
                    break;
                }
                case CONTENT_MALFORMED: {
                    g.writeString("content_malformed");
                    break;
                }
                case DOC_LENGTH_EXCEEDED: {
                    g.writeString("doc_length_exceeded");
                    break;
                }
                case IMAGE_SIZE_EXCEEDED: {
                    g.writeString("image_size_exceeded");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case INVALID_PATH: {
                    g.writeString("invalid_path");
                    break;
                }
                case EMAIL_UNVERIFIED: {
                    g.writeString("email_unverified");
                    break;
                }
                case INVALID_FILE_EXTENSION: {
                    g.writeString("invalid_file_extension");
                    break;
                }
                case PAPER_DISABLED: {
                    g.writeString("paper_disabled");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public PaperCreateError deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperCreateError value;
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
            else if ("insufficient_permissions".equals(tag)) {
                value = PaperCreateError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("content_malformed".equals(tag)) {
                value = PaperCreateError.CONTENT_MALFORMED;
            }
            else if ("doc_length_exceeded".equals(tag)) {
                value = PaperCreateError.DOC_LENGTH_EXCEEDED;
            }
            else if ("image_size_exceeded".equals(tag)) {
                value = PaperCreateError.IMAGE_SIZE_EXCEEDED;
            }
            else if ("other".equals(tag)) {
                value = PaperCreateError.OTHER;
            }
            else if ("invalid_path".equals(tag)) {
                value = PaperCreateError.INVALID_PATH;
            }
            else if ("email_unverified".equals(tag)) {
                value = PaperCreateError.EMAIL_UNVERIFIED;
            }
            else if ("invalid_file_extension".equals(tag)) {
                value = PaperCreateError.INVALID_FILE_EXTENSION;
            }
            else if ("paper_disabled".equals(tag)) {
                value = PaperCreateError.PAPER_DISABLED;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
