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

public enum PaperDocUpdateError {
    // union paper.PaperDocUpdateError (paper.stone)
    /**
     * Your account does not have permissions to perform this action. This may
     * be due to it only having access to Paper as files in the Dropbox
     * filesystem. For more information, refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a>.
     */
    INSUFFICIENT_PERMISSIONS,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER,
    /**
     * The required doc was not found.
     */
    DOC_NOT_FOUND,
    /**
     * The provided content was malformed and cannot be imported to Paper.
     */
    CONTENT_MALFORMED,
    /**
     * The provided revision does not match the document head.
     */
    REVISION_MISMATCH,
    /**
     * The newly created Paper doc would be too large, split the content into
     * multiple docs.
     */
    DOC_LENGTH_EXCEEDED,
    /**
     * The imported document contains an image that is too large. The current
     * limit is 1MB. This only applies to HTML with data URI.
     */
    IMAGE_SIZE_EXCEEDED,
    /**
     * This operation is not allowed on archived Paper docs.
     */
    DOC_ARCHIVED,
    /**
     * This operation is not allowed on deleted Paper docs.
     */
    DOC_DELETED;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<PaperDocUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocUpdateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INSUFFICIENT_PERMISSIONS: {
                    g.writeString("insufficient_permissions");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case DOC_NOT_FOUND: {
                    g.writeString("doc_not_found");
                    break;
                }
                case CONTENT_MALFORMED: {
                    g.writeString("content_malformed");
                    break;
                }
                case REVISION_MISMATCH: {
                    g.writeString("revision_mismatch");
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
                case DOC_ARCHIVED: {
                    g.writeString("doc_archived");
                    break;
                }
                case DOC_DELETED: {
                    g.writeString("doc_deleted");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public PaperDocUpdateError deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperDocUpdateError value;
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
                value = PaperDocUpdateError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("other".equals(tag)) {
                value = PaperDocUpdateError.OTHER;
            }
            else if ("doc_not_found".equals(tag)) {
                value = PaperDocUpdateError.DOC_NOT_FOUND;
            }
            else if ("content_malformed".equals(tag)) {
                value = PaperDocUpdateError.CONTENT_MALFORMED;
            }
            else if ("revision_mismatch".equals(tag)) {
                value = PaperDocUpdateError.REVISION_MISMATCH;
            }
            else if ("doc_length_exceeded".equals(tag)) {
                value = PaperDocUpdateError.DOC_LENGTH_EXCEEDED;
            }
            else if ("image_size_exceeded".equals(tag)) {
                value = PaperDocUpdateError.IMAGE_SIZE_EXCEEDED;
            }
            else if ("doc_archived".equals(tag)) {
                value = PaperDocUpdateError.DOC_ARCHIVED;
            }
            else if ("doc_deleted".equals(tag)) {
                value = PaperDocUpdateError.DOC_DELETED;
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
