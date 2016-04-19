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

@JsonSerialize(using=ListFolderLongpollError.Serializer.class)
@JsonDeserialize(using=ListFolderLongpollError.Deserializer.class)
public enum ListFolderLongpollError {
    // union ListFolderLongpollError
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxUserFilesRequests#listFolder(String)} to obtain a new cursor.
     */
    RESET,
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

    static final class Serializer extends UnionJsonSerializer<ListFolderLongpollError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFolderLongpollError.class);
        }

        @Override
        public void serialize(ListFolderLongpollError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case RESET:
                    g.writeString("reset");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ListFolderLongpollError, ListFolderLongpollError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFolderLongpollError.class, getTagMapping(), ListFolderLongpollError.OTHER);
        }

        @Override
        public ListFolderLongpollError deserialize(ListFolderLongpollError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, ListFolderLongpollError> getTagMapping() {
            Map<String, ListFolderLongpollError> values = new HashMap<String, ListFolderLongpollError>();
            values.put("reset", ListFolderLongpollError.RESET);
            values.put("other", ListFolderLongpollError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
