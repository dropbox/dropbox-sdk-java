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

@JsonSerialize(using=RevokeSharedLinkError.Serializer.class)
@JsonDeserialize(using=RevokeSharedLinkError.Deserializer.class)
public enum RevokeSharedLinkError {
    // union RevokeSharedLinkError
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
    OTHER,
    /**
     * Shared link is malformed.
     */
    SHARED_LINK_MALFORMED;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<RevokeSharedLinkError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeSharedLinkError.class);
        }

        @Override
        public void serialize(RevokeSharedLinkError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case SHARED_LINK_MALFORMED:
                    g.writeString("shared_link_malformed");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<RevokeSharedLinkError, RevokeSharedLinkError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeSharedLinkError.class, getTagMapping(), null);
        }

        @Override
        public RevokeSharedLinkError deserialize(RevokeSharedLinkError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, RevokeSharedLinkError> getTagMapping() {
            Map<String, RevokeSharedLinkError> values = new HashMap<String, RevokeSharedLinkError>();
            values.put("shared_link_malformed", RevokeSharedLinkError.SHARED_LINK_MALFORMED);
            return Collections.unmodifiableMap(values);
        }
    }
}
