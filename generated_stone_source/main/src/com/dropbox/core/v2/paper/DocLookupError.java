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

public enum DocLookupError {
    // union paper.DocLookupError (paper.stone)
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
    DOC_NOT_FOUND;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<DocLookupError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DocLookupError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public DocLookupError deserialize(JsonParser p) throws IOException, JsonParseException {
            DocLookupError value;
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
                value = DocLookupError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("other".equals(tag)) {
                value = DocLookupError.OTHER;
            }
            else if ("doc_not_found".equals(tag)) {
                value = DocLookupError.DOC_NOT_FOUND;
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
