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

@JsonSerialize(using=GetSharedLinkFileError.Serializer.class)
@JsonDeserialize(using=GetSharedLinkFileError.Deserializer.class)
public enum GetSharedLinkFileError {
    // union GetSharedLinkFileError
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
     * Directories cannot be retrieved by this endpoint.
     */
    SHARED_LINK_IS_DIRECTORY;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GetSharedLinkFileError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetSharedLinkFileError.class);
        }

        @Override
        public void serialize(GetSharedLinkFileError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case SHARED_LINK_IS_DIRECTORY:
                    g.writeString("shared_link_is_directory");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GetSharedLinkFileError, GetSharedLinkFileError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetSharedLinkFileError.class, getTagMapping(), null);
        }

        @Override
        public GetSharedLinkFileError deserialize(GetSharedLinkFileError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GetSharedLinkFileError> getTagMapping() {
            Map<String, GetSharedLinkFileError> values = new HashMap<String, GetSharedLinkFileError>();
            values.put("shared_link_is_directory", GetSharedLinkFileError.SHARED_LINK_IS_DIRECTORY);
            return Collections.unmodifiableMap(values);
        }
    }
}
