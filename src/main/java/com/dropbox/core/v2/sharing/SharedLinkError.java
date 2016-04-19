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

@JsonSerialize(using=SharedLinkError.Serializer.class)
@JsonDeserialize(using=SharedLinkError.Deserializer.class)
public enum SharedLinkError {
    // union SharedLinkError
    /**
     * The shared link wasn't found
     */
    SHARED_LINK_NOT_FOUND,
    /**
     * The caller is not allowed to access this shared link
     */
    SHARED_LINK_ACCESS_DENIED,
    /**
     * An unspecified error
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<SharedLinkError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedLinkError.class);
        }

        @Override
        public void serialize(SharedLinkError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case SHARED_LINK_NOT_FOUND:
                    g.writeString("shared_link_not_found");
                    break;
                case SHARED_LINK_ACCESS_DENIED:
                    g.writeString("shared_link_access_denied");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedLinkError, SharedLinkError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedLinkError.class, getTagMapping(), SharedLinkError.OTHER);
        }

        @Override
        public SharedLinkError deserialize(SharedLinkError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedLinkError> getTagMapping() {
            Map<String, SharedLinkError> values = new HashMap<String, SharedLinkError>();
            values.put("shared_link_not_found", SharedLinkError.SHARED_LINK_NOT_FOUND);
            values.put("shared_link_access_denied", SharedLinkError.SHARED_LINK_ACCESS_DENIED);
            values.put("other", SharedLinkError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
