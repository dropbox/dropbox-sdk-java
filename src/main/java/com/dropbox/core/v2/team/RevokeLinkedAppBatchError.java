/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

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
 * Error returned by {@link
 * DbxTeamTeamRequests#linkedAppsRevokeLinkedAppBatch(java.util.List)}.
 */
@JsonSerialize(using=RevokeLinkedAppBatchError.Serializer.class)
@JsonDeserialize(using=RevokeLinkedAppBatchError.Deserializer.class)
public enum RevokeLinkedAppBatchError {
    // union RevokeLinkedAppBatchError
    /**
     * An unspecified error.
     */
    UNSPECIFIED; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<RevokeLinkedAppBatchError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeLinkedAppBatchError.class);
        }

        @Override
        public void serialize(RevokeLinkedAppBatchError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case UNSPECIFIED:
                    g.writeString("unspecified");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<RevokeLinkedAppBatchError, RevokeLinkedAppBatchError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeLinkedAppBatchError.class, getTagMapping(), RevokeLinkedAppBatchError.UNSPECIFIED);
        }

        @Override
        public RevokeLinkedAppBatchError deserialize(RevokeLinkedAppBatchError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, RevokeLinkedAppBatchError> getTagMapping() {
            Map<String, RevokeLinkedAppBatchError> values = new HashMap<String, RevokeLinkedAppBatchError>();
            values.put("unspecified", RevokeLinkedAppBatchError.UNSPECIFIED);
            return Collections.unmodifiableMap(values);
        }
    }
}
