/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

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
 * Flag to indicate pending upload default (for linking to not-yet-existing
 * paths).
 */
@JsonSerialize(using=PendingUploadMode.Serializer.class)
@JsonDeserialize(using=PendingUploadMode.Deserializer.class)
public enum PendingUploadMode {
    // union PendingUploadMode
    /**
     * Assume pending uploads are files.
     */
    FILE,
    /**
     * Assume pending uploads are folders.
     */
    FOLDER;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<PendingUploadMode> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PendingUploadMode.class);
        }

        @Override
        public void serialize(PendingUploadMode value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case FILE:
                    g.writeString("file");
                    break;
                case FOLDER:
                    g.writeString("folder");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PendingUploadMode, PendingUploadMode> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PendingUploadMode.class, getTagMapping(), null);
        }

        @Override
        public PendingUploadMode deserialize(PendingUploadMode _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, PendingUploadMode> getTagMapping() {
            Map<String, PendingUploadMode> values = new HashMap<String, PendingUploadMode>();
            values.put("file", PendingUploadMode.FILE);
            values.put("folder", PendingUploadMode.FOLDER);
            return Collections.unmodifiableMap(values);
        }
    }
}
