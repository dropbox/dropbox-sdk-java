/* DO NOT EDIT */
/* This file was generated from properties.babel */

package com.dropbox.core.v2.properties;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Data type of the given property added. This endpoint is in beta and  only
 * properties of type strings is supported.
 */
@JsonSerialize(using=PropertyType.Serializer.class)
@JsonDeserialize(using=PropertyType.Deserializer.class)
public enum PropertyType {
    // union PropertyType
    /**
     * The associated property will be of type string. Unicode is supported.
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

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<PropertyType> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PropertyType.class);
        }

        @Override
        public void serialize(PropertyType value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case STRING:
                    g.writeString("string");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PropertyType, PropertyType> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PropertyType.class, getTagMapping(), PropertyType.OTHER);
        }

        @Override
        public PropertyType deserialize(PropertyType _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, PropertyType> getTagMapping() {
            Map<String, PropertyType> values = new HashMap<String, PropertyType>();
            values.put("string", PropertyType.STRING);
            values.put("other", PropertyType.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
