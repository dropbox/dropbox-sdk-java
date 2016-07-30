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

public enum GetSharedLinkFileError {
    // union GetSharedLinkFileError
    /**
     * The shared link wasn't found
     */
    SHARED_LINK_NOT_FOUND,
    /**
     * The caller is not allowed to access this shared link
     */
    SHARED_LINK_ACCESS_DENIED,
    OTHER,
    /**
     * Directories cannot be retrieved by this endpoint.
     */
    SHARED_LINK_IS_DIRECTORY;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<GetSharedLinkFileError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetSharedLinkFileError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case SHARED_LINK_NOT_FOUND: {
                    g.writeString("shared_link_not_found");
                    break;
                }
                case SHARED_LINK_ACCESS_DENIED: {
                    g.writeString("shared_link_access_denied");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case SHARED_LINK_IS_DIRECTORY: {
                    g.writeString("shared_link_is_directory");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public GetSharedLinkFileError deserialize(JsonParser p) throws IOException, JsonParseException {
            GetSharedLinkFileError value;
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
            else if ("shared_link_not_found".equals(tag)) {
                value = GetSharedLinkFileError.SHARED_LINK_NOT_FOUND;
            }
            else if ("shared_link_access_denied".equals(tag)) {
                value = GetSharedLinkFileError.SHARED_LINK_ACCESS_DENIED;
            }
            else if ("other".equals(tag)) {
                value = GetSharedLinkFileError.OTHER;
            }
            else if ("shared_link_is_directory".equals(tag)) {
                value = GetSharedLinkFileError.SHARED_LINK_IS_DIRECTORY;
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
