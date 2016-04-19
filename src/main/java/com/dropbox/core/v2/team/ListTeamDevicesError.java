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

@JsonSerialize(using=ListTeamDevicesError.Serializer.class)
@JsonDeserialize(using=ListTeamDevicesError.Deserializer.class)
public enum ListTeamDevicesError {
    // union ListTeamDevicesError
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxTeamTeamRequests#devicesListTeamDevices()} again with an empty cursor
     * to obtain a new cursor.
     */
    RESET,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<ListTeamDevicesError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListTeamDevicesError.class);
        }

        @Override
        public void serialize(ListTeamDevicesError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case RESET:
                    g.writeString("reset");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ListTeamDevicesError, ListTeamDevicesError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListTeamDevicesError.class, getTagMapping(), ListTeamDevicesError.OTHER);
        }

        @Override
        public ListTeamDevicesError deserialize(ListTeamDevicesError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, ListTeamDevicesError> getTagMapping() {
            Map<String, ListTeamDevicesError> values = new HashMap<String, ListTeamDevicesError>();
            values.put("reset", ListTeamDevicesError.RESET);
            values.put("other", ListTeamDevicesError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
