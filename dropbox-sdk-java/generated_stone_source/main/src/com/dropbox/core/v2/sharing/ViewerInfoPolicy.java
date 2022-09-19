/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

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

public enum ViewerInfoPolicy {
    // union sharing.ViewerInfoPolicy (sharing_files.stone)
    /**
     * Viewer information is available on this file.
     */
    ENABLED,
    /**
     * Viewer information is disabled on this file.
     */
    DISABLED,
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
    public static class Serializer extends UnionSerializer<ViewerInfoPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ViewerInfoPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ENABLED: {
                    g.writeString("enabled");
                    break;
                }
                case DISABLED: {
                    g.writeString("disabled");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ViewerInfoPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            ViewerInfoPolicy value;
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
            else if ("enabled".equals(tag)) {
                value = ViewerInfoPolicy.ENABLED;
            }
            else if ("disabled".equals(tag)) {
                value = ViewerInfoPolicy.DISABLED;
            }
            else {
                value = ViewerInfoPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
