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

@JsonSerialize(using=MembersListContinueError.Serializer.class)
@JsonDeserialize(using=MembersListContinueError.Deserializer.class)
public enum MembersListContinueError {
    // union MembersListContinueError
    /**
     * The cursor is invalid.
     */
    INVALID_CURSOR,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MembersListContinueError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersListContinueError.class);
        }

        @Override
        public void serialize(MembersListContinueError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case INVALID_CURSOR:
                    g.writeString("invalid_cursor");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersListContinueError, MembersListContinueError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersListContinueError.class, getTagMapping(), MembersListContinueError.OTHER);
        }

        @Override
        public MembersListContinueError deserialize(MembersListContinueError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MembersListContinueError> getTagMapping() {
            Map<String, MembersListContinueError> values = new HashMap<String, MembersListContinueError>();
            values.put("invalid_cursor", MembersListContinueError.INVALID_CURSOR);
            values.put("other", MembersListContinueError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
