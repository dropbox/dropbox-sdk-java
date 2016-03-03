/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

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
 * Error that can be returned whenever a struct derived from {@link
 * UserSelectorArg} is used.
 */
@JsonSerialize(using=UserSelectorError.Serializer.class)
@JsonDeserialize(using=UserSelectorError.Deserializer.class)
public enum UserSelectorError {
    // union UserSelectorError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<UserSelectorError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UserSelectorError.class);
        }

        @Override
        public void serialize(UserSelectorError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case USER_NOT_FOUND:
                    g.writeString("user_not_found");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<UserSelectorError, UserSelectorError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UserSelectorError.class, getTagMapping(), null);
        }

        @Override
        public UserSelectorError deserialize(UserSelectorError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, UserSelectorError> getTagMapping() {
            Map<String, UserSelectorError> values = new HashMap<String, UserSelectorError>();
            values.put("user_not_found", UserSelectorError.USER_NOT_FOUND);
            return Collections.unmodifiableMap(values);
        }
    }
}
