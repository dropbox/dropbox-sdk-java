/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Flag to indicate pending upload default (for linking to not-yet-existing
 * paths).
 */
public enum PendingUploadMode {
    // union PendingUploadMode
    /**
     * Assume pending uploads are files.
     */
    FILE,
    /**
     * Assume pending uploads are folders.
     */
    FOLDER;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<PendingUploadMode> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PendingUploadMode value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FILE: {
                    g.writeString("file");
                    break;
                }
                case FOLDER: {
                    g.writeString("folder");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public PendingUploadMode deserialize(JsonParser p) throws IOException, JsonParseException {
            PendingUploadMode value;
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
            else if ("file".equals(tag)) {
                value = PendingUploadMode.FILE;
            }
            else if ("folder".equals(tag)) {
                value = PendingUploadMode.FOLDER;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
