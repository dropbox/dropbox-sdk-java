/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

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
 * Data type of the given property field added.
 */
public enum PropertyType {
    // union file_properties.PropertyType (file_properties.stone)
    /**
     * The associated property field will be of type string. Unicode is
     * supported.
     */
    STRING,
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
    static class Serializer extends UnionSerializer<PropertyType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertyType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case STRING: {
                    g.writeString("string");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PropertyType deserialize(JsonParser p) throws IOException, JsonParseException {
            PropertyType value;
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
            else if ("string".equals(tag)) {
                value = PropertyType.STRING;
            }
            else {
                value = PropertyType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
