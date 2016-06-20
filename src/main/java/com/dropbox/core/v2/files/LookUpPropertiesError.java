/* DO NOT EDIT */
/* This file was generated from files_properties.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum LookUpPropertiesError {
    // union LookUpPropertiesError
    /**
     * This property group does not exist for this file.
     */
    PROPERTY_GROUP_NOT_FOUND;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<LookUpPropertiesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LookUpPropertiesError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PROPERTY_GROUP_NOT_FOUND: {
                    g.writeString("property_group_not_found");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public LookUpPropertiesError deserialize(JsonParser p) throws IOException, JsonParseException {
            LookUpPropertiesError value;
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
            else if ("property_group_not_found".equals(tag)) {
                value = LookUpPropertiesError.PROPERTY_GROUP_NOT_FOUND;
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
