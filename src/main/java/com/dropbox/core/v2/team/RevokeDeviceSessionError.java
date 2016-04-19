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

@JsonSerialize(using=RevokeDeviceSessionError.Serializer.class)
@JsonDeserialize(using=RevokeDeviceSessionError.Deserializer.class)
public enum RevokeDeviceSessionError {
    // union RevokeDeviceSessionError
    /**
     * Device session not found.
     */
    DEVICE_SESSION_NOT_FOUND,
    /**
     * Member not found.
     */
    MEMBER_NOT_FOUND,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<RevokeDeviceSessionError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeDeviceSessionError.class);
        }

        @Override
        public void serialize(RevokeDeviceSessionError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case DEVICE_SESSION_NOT_FOUND:
                    g.writeString("device_session_not_found");
                    break;
                case MEMBER_NOT_FOUND:
                    g.writeString("member_not_found");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<RevokeDeviceSessionError, RevokeDeviceSessionError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeDeviceSessionError.class, getTagMapping(), RevokeDeviceSessionError.OTHER);
        }

        @Override
        public RevokeDeviceSessionError deserialize(RevokeDeviceSessionError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, RevokeDeviceSessionError> getTagMapping() {
            Map<String, RevokeDeviceSessionError> values = new HashMap<String, RevokeDeviceSessionError>();
            values.put("device_session_not_found", RevokeDeviceSessionError.DEVICE_SESSION_NOT_FOUND);
            values.put("member_not_found", RevokeDeviceSessionError.MEMBER_NOT_FOUND);
            values.put("other", RevokeDeviceSessionError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
