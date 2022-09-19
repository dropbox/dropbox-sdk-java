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

public enum PaperFolderCreateError {
    // union paper.PaperFolderCreateError (paper.stone)
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
     * The specified parent Paper folder cannot be found.
     */
    FOLDER_NOT_FOUND,
    /**
     * The folder id cannot be decrypted to valid folder id.
     */
    INVALID_FOLDER_ID;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<PaperFolderCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperFolderCreateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INSUFFICIENT_PERMISSIONS: {
                    g.writeString("insufficient_permissions");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case FOLDER_NOT_FOUND: {
                    g.writeString("folder_not_found");
                    break;
                }
                case INVALID_FOLDER_ID: {
                    g.writeString("invalid_folder_id");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public PaperFolderCreateError deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperFolderCreateError value;
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
                value = PaperFolderCreateError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("other".equals(tag)) {
                value = PaperFolderCreateError.OTHER;
            }
            else if ("folder_not_found".equals(tag)) {
                value = PaperFolderCreateError.FOLDER_NOT_FOUND;
            }
            else if ("invalid_folder_id".equals(tag)) {
                value = PaperFolderCreateError.INVALID_FOLDER_ID;
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
