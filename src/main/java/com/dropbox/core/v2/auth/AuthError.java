/* DO NOT EDIT */
/* This file was generated from auth.babel */

package com.dropbox.core.v2.auth;

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
 * Errors occurred during authentication.
 */
@JsonSerialize(using=AuthError.Serializer.class)
@JsonDeserialize(using=AuthError.Deserializer.class)
public enum AuthError {
    // union AuthError
    /**
     * The access token is invalid.
     */
    INVALID_ACCESS_TOKEN,
    /**
     * The user specified in 'Dropbox-API-Select-User' is no longer on the team.
     */
    INVALID_SELECT_USER,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<AuthError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AuthError.class);
        }

        @Override
        public void serialize(AuthError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case INVALID_ACCESS_TOKEN:
                    g.writeString("invalid_access_token");
                    break;
                case INVALID_SELECT_USER:
                    g.writeString("invalid_select_user");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<AuthError, AuthError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AuthError.class, getTagMapping(), AuthError.OTHER);
        }

        @Override
        public AuthError deserialize(AuthError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, AuthError> getTagMapping() {
            Map<String, AuthError> values = new HashMap<String, AuthError>();
            values.put("invalid_access_token", AuthError.INVALID_ACCESS_TOKEN);
            values.put("invalid_select_user", AuthError.INVALID_SELECT_USER);
            values.put("other", AuthError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
