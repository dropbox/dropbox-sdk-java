/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

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

@JsonSerialize(using=GetAccountError.Serializer.class)
@JsonDeserialize(using=GetAccountError.Deserializer.class)
public enum GetAccountError {
    // union GetAccountError
    /**
     * The specified the {@code accountId} argument to {@link
     * DbxUserUsersRequests#getAccount(String)} does not exist.
     */
    NO_ACCOUNT,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    UNKNOWN; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GetAccountError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetAccountError.class);
        }

        @Override
        public void serialize(GetAccountError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case NO_ACCOUNT:
                    g.writeString("no_account");
                    break;
                case UNKNOWN:
                    g.writeString("unknown");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GetAccountError, GetAccountError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetAccountError.class, getTagMapping(), GetAccountError.UNKNOWN);
        }

        @Override
        public GetAccountError deserialize(GetAccountError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GetAccountError> getTagMapping() {
            Map<String, GetAccountError> values = new HashMap<String, GetAccountError>();
            values.put("no_account", GetAccountError.NO_ACCOUNT);
            values.put("unknown", GetAccountError.UNKNOWN);
            return Collections.unmodifiableMap(values);
        }
    }
}
