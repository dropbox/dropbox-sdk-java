/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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

@JsonSerialize(using=GroupsListContinueError.Serializer.class)
@JsonDeserialize(using=GroupsListContinueError.Deserializer.class)
public enum GroupsListContinueError {
    // union GroupsListContinueError
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

    static final class Serializer extends UnionJsonSerializer<GroupsListContinueError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupsListContinueError.class);
        }

        @Override
        public void serialize(GroupsListContinueError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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

    static final class Deserializer extends UnionJsonDeserializer<GroupsListContinueError, GroupsListContinueError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupsListContinueError.class, getTagMapping(), GroupsListContinueError.OTHER);
        }

        @Override
        public GroupsListContinueError deserialize(GroupsListContinueError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupsListContinueError> getTagMapping() {
            Map<String, GroupsListContinueError> values = new HashMap<String, GroupsListContinueError>();
            values.put("invalid_cursor", GroupsListContinueError.INVALID_CURSOR);
            values.put("other", GroupsListContinueError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
