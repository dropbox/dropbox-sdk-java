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

@JsonSerialize(using=WriteConflictError.Serializer.class)
@JsonDeserialize(using=WriteConflictError.Deserializer.class)
public enum WriteConflictError {
    // union WriteConflictError
    /**
     * There's a file in the way.
     */
    FILE,
    /**
     * There's a folder in the way.
     */
    FOLDER,
    /**
     * There's a file at an ancestor path, so we couldn't create the required
     * parent folders.
     */
    FILE_ANCESTOR,
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

    static final class Serializer extends UnionJsonSerializer<WriteConflictError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(WriteConflictError.class);
        }

        @Override
        public void serialize(WriteConflictError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case FILE:
                    g.writeString("file");
                    break;
                case FOLDER:
                    g.writeString("folder");
                    break;
                case FILE_ANCESTOR:
                    g.writeString("file_ancestor");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<WriteConflictError, WriteConflictError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(WriteConflictError.class, getTagMapping(), WriteConflictError.OTHER);
        }

        @Override
        public WriteConflictError deserialize(WriteConflictError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, WriteConflictError> getTagMapping() {
            Map<String, WriteConflictError> values = new HashMap<String, WriteConflictError>();
            values.put("file", WriteConflictError.FILE);
            values.put("folder", WriteConflictError.FOLDER);
            values.put("file_ancestor", WriteConflictError.FILE_ANCESTOR);
            values.put("other", WriteConflictError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
