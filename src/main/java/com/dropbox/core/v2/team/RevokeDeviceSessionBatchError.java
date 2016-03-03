/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

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

@JsonSerialize(using=RevokeDeviceSessionBatchError.Serializer.class)
@JsonDeserialize(using=RevokeDeviceSessionBatchError.Deserializer.class)
public enum RevokeDeviceSessionBatchError {
    // union RevokeDeviceSessionBatchError
    /**
     * An unspecified error.
     */
    UNSPECIFIED; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<RevokeDeviceSessionBatchError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeDeviceSessionBatchError.class);
        }

        @Override
        public void serialize(RevokeDeviceSessionBatchError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case UNSPECIFIED:
                    g.writeString("unspecified");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<RevokeDeviceSessionBatchError, RevokeDeviceSessionBatchError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeDeviceSessionBatchError.class, getTagMapping(), RevokeDeviceSessionBatchError.UNSPECIFIED);
        }

        @Override
        public RevokeDeviceSessionBatchError deserialize(RevokeDeviceSessionBatchError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, RevokeDeviceSessionBatchError> getTagMapping() {
            Map<String, RevokeDeviceSessionBatchError> values = new HashMap<String, RevokeDeviceSessionBatchError>();
            values.put("unspecified", RevokeDeviceSessionBatchError.UNSPECIFIED);
            return Collections.unmodifiableMap(values);
        }
    }
}
