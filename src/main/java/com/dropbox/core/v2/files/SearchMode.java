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

@JsonSerialize(using=SearchMode.Serializer.class)
@JsonDeserialize(using=SearchMode.Deserializer.class)
public enum SearchMode {
    // union SearchMode
    /**
     * Search file and folder names.
     */
    FILENAME,
    /**
     * Search file and folder names as well as file contents.
     */
    FILENAME_AND_CONTENT,
    /**
     * Search for deleted file and folder names.
     */
    DELETED_FILENAME;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<SearchMode> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SearchMode.class);
        }

        @Override
        public void serialize(SearchMode value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case FILENAME:
                    g.writeString("filename");
                    break;
                case FILENAME_AND_CONTENT:
                    g.writeString("filename_and_content");
                    break;
                case DELETED_FILENAME:
                    g.writeString("deleted_filename");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SearchMode, SearchMode> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SearchMode.class, getTagMapping(), null);
        }

        @Override
        public SearchMode deserialize(SearchMode _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SearchMode> getTagMapping() {
            Map<String, SearchMode> values = new HashMap<String, SearchMode>();
            values.put("filename", SearchMode.FILENAME);
            values.put("filename_and_content", SearchMode.FILENAME_AND_CONTENT);
            values.put("deleted_filename", SearchMode.DELETED_FILENAME);
            return Collections.unmodifiableMap(values);
        }
    }
}
