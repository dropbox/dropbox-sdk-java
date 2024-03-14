/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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

/**
 * Information about the inheritance policy of a shared folder.
 */
public enum AccessInheritance {
    // union sharing.AccessInheritance (sharing_folders.stone)
    /**
     * The shared folder inherits its members from the parent folder.
     */
    INHERIT,
    /**
     * The shared folder does not inherit its members from the parent folder.
     */
    NO_INHERIT,
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
    static class Serializer extends UnionSerializer<AccessInheritance> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AccessInheritance value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INHERIT: {
                    g.writeString("inherit");
                    break;
                }
                case NO_INHERIT: {
                    g.writeString("no_inherit");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AccessInheritance deserialize(JsonParser p) throws IOException, JsonParseException {
            AccessInheritance value;
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
            else if ("inherit".equals(tag)) {
                value = AccessInheritance.INHERIT;
            }
            else if ("no_inherit".equals(tag)) {
                value = AccessInheritance.NO_INHERIT;
            }
            else {
                value = AccessInheritance.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
