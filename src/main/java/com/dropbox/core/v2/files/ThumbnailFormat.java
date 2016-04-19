/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

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

@JsonSerialize(using=ThumbnailFormat.Serializer.class)
@JsonDeserialize(using=ThumbnailFormat.Deserializer.class)
public enum ThumbnailFormat {
    // union ThumbnailFormat
    JPEG,
    PNG;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<ThumbnailFormat> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ThumbnailFormat.class);
        }

        @Override
        public void serialize(ThumbnailFormat value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case JPEG:
                    g.writeString("jpeg");
                    break;
                case PNG:
                    g.writeString("png");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ThumbnailFormat, ThumbnailFormat> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ThumbnailFormat.class, getTagMapping(), null);
        }

        @Override
        public ThumbnailFormat deserialize(ThumbnailFormat _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, ThumbnailFormat> getTagMapping() {
            Map<String, ThumbnailFormat> values = new HashMap<String, ThumbnailFormat>();
            values.put("jpeg", ThumbnailFormat.JPEG);
            values.put("png", ThumbnailFormat.PNG);
            return Collections.unmodifiableMap(values);
        }
    }
}
