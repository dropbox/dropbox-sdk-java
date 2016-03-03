/* DO NOT EDIT */
/* This file was generated from team_members.babel */

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

@JsonSerialize(using=MembersGetInfoError.Serializer.class)
@JsonDeserialize(using=MembersGetInfoError.Deserializer.class)
public enum MembersGetInfoError {
    // union MembersGetInfoError
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MembersGetInfoError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersGetInfoError.class);
        }

        @Override
        public void serialize(MembersGetInfoError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersGetInfoError, MembersGetInfoError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersGetInfoError.class, getTagMapping(), MembersGetInfoError.OTHER);
        }

        @Override
        public MembersGetInfoError deserialize(MembersGetInfoError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MembersGetInfoError> getTagMapping() {
            Map<String, MembersGetInfoError> values = new HashMap<String, MembersGetInfoError>();
            values.put("other", MembersGetInfoError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
