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

@JsonSerialize(using=ThumbnailSize.Serializer.class)
@JsonDeserialize(using=ThumbnailSize.Deserializer.class)
public enum ThumbnailSize {
    // union ThumbnailSize
    /**
     * 32 by 32 px.
     */
    W32H32,
    /**
     * 64 by 64 px.
     */
    W64H64,
    /**
     * 128 by 128 px.
     */
    W128H128,
    /**
     * 640 by 480 px.
     */
    W640H480,
    /**
     * 1024 by 768
     */
    W1024H768;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<ThumbnailSize> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ThumbnailSize.class);
        }

        @Override
        public void serialize(ThumbnailSize value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case W32H32:
                    g.writeString("w32h32");
                    break;
                case W64H64:
                    g.writeString("w64h64");
                    break;
                case W128H128:
                    g.writeString("w128h128");
                    break;
                case W640H480:
                    g.writeString("w640h480");
                    break;
                case W1024H768:
                    g.writeString("w1024h768");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ThumbnailSize, ThumbnailSize> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ThumbnailSize.class, getTagMapping(), null);
        }

        @Override
        public ThumbnailSize deserialize(ThumbnailSize _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, ThumbnailSize> getTagMapping() {
            Map<String, ThumbnailSize> values = new HashMap<String, ThumbnailSize>();
            values.put("w32h32", ThumbnailSize.W32H32);
            values.put("w64h64", ThumbnailSize.W64H64);
            values.put("w128h128", ThumbnailSize.W128H128);
            values.put("w640h480", ThumbnailSize.W640H480);
            values.put("w1024h768", ThumbnailSize.W1024H768);
            return Collections.unmodifiableMap(values);
        }
    }
}
