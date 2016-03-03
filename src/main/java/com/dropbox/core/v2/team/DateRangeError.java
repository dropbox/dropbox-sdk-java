/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

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
 * Errors that can originate from problems in input arguments to reports.
 */
@JsonSerialize(using=DateRangeError.Serializer.class)
@JsonDeserialize(using=DateRangeError.Deserializer.class)
public enum DateRangeError {
    // union DateRangeError
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<DateRangeError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DateRangeError.class);
        }

        @Override
        public void serialize(DateRangeError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<DateRangeError, DateRangeError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DateRangeError.class, getTagMapping(), DateRangeError.OTHER);
        }

        @Override
        public DateRangeError deserialize(DateRangeError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, DateRangeError> getTagMapping() {
            Map<String, DateRangeError> values = new HashMap<String, DateRangeError>();
            values.put("other", DateRangeError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
