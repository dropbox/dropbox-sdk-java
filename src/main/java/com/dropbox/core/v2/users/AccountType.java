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

/**
 * What type of account this user has.
 */
@JsonSerialize(using=AccountType.Serializer.class)
@JsonDeserialize(using=AccountType.Deserializer.class)
public enum AccountType {
    // union AccountType
    /**
     * The basic account type.
     */
    BASIC,
    /**
     * The Dropbox Pro account type.
     */
    PRO,
    /**
     * The Dropbox Business account type.
     */
    BUSINESS;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<AccountType> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AccountType.class);
        }

        @Override
        public void serialize(AccountType value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case BASIC:
                    g.writeString("basic");
                    break;
                case PRO:
                    g.writeString("pro");
                    break;
                case BUSINESS:
                    g.writeString("business");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<AccountType, AccountType> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AccountType.class, getTagMapping(), null);
        }

        @Override
        public AccountType deserialize(AccountType _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, AccountType> getTagMapping() {
            Map<String, AccountType> values = new HashMap<String, AccountType>();
            values.put("basic", AccountType.BASIC);
            values.put("pro", AccountType.PRO);
            values.put("business", AccountType.BUSINESS);
            return Collections.unmodifiableMap(values);
        }
    }
}
