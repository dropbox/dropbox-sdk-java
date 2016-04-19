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

/**
 * Indicates what type of match was found for a given item.
 */
@JsonSerialize(using=SearchMatchType.Serializer.class)
@JsonDeserialize(using=SearchMatchType.Deserializer.class)
public enum SearchMatchType {
    // union SearchMatchType
    /**
     * This item was matched on its file or folder name.
     */
    FILENAME,
    /**
     * This item was matched based on its file contents.
     */
    CONTENT,
    /**
     * This item was matched based on both its contents and its file name.
     */
    BOTH;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<SearchMatchType> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SearchMatchType.class);
        }

        @Override
        public void serialize(SearchMatchType value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case FILENAME:
                    g.writeString("filename");
                    break;
                case CONTENT:
                    g.writeString("content");
                    break;
                case BOTH:
                    g.writeString("both");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SearchMatchType, SearchMatchType> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SearchMatchType.class, getTagMapping(), null);
        }

        @Override
        public SearchMatchType deserialize(SearchMatchType _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SearchMatchType> getTagMapping() {
            Map<String, SearchMatchType> values = new HashMap<String, SearchMatchType>();
            values.put("filename", SearchMatchType.FILENAME);
            values.put("content", SearchMatchType.CONTENT);
            values.put("both", SearchMatchType.BOTH);
            return Collections.unmodifiableMap(values);
        }
    }
}
