/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

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

public enum SharedLinkError {
    // union sharing.SharedLinkError (shared_links.stone)
    /**
     * The shared link wasn't found.
     */
    SHARED_LINK_NOT_FOUND,
    /**
     * The caller is not allowed to access this shared link.
     */
    SHARED_LINK_ACCESS_DENIED,
    /**
     * This type of link is not supported; use {@link
     * com.dropbox.core.v2.files.DbxUserFilesRequests#export(String,String)}
     * instead.
     */
    UNSUPPORTED_LINK_TYPE,
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
    static class Serializer extends UnionSerializer<SharedLinkError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case SHARED_LINK_NOT_FOUND: {
                    g.writeString("shared_link_not_found");
                    break;
                }
                case SHARED_LINK_ACCESS_DENIED: {
                    g.writeString("shared_link_access_denied");
                    break;
                }
                case UNSUPPORTED_LINK_TYPE: {
                    g.writeString("unsupported_link_type");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedLinkError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedLinkError value;
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
                value = SharedLinkError.SHARED_LINK_NOT_FOUND;
            }
            else if ("shared_link_access_denied".equals(tag)) {
                value = SharedLinkError.SHARED_LINK_ACCESS_DENIED;
            }
            else if ("unsupported_link_type".equals(tag)) {
                value = SharedLinkError.UNSUPPORTED_LINK_TYPE;
            }
            else {
                value = SharedLinkError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
