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

@JsonSerialize(using=GroupDeleteError.Serializer.class)
@JsonDeserialize(using=GroupDeleteError.Deserializer.class)
public enum GroupDeleteError {
    // union GroupDeleteError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * This group has already been deleted.
     */
    GROUP_ALREADY_DELETED;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupDeleteError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupDeleteError.class);
        }

        @Override
        public void serialize(GroupDeleteError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case GROUP_NOT_FOUND:
                    g.writeString("group_not_found");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
                case GROUP_ALREADY_DELETED:
                    g.writeString("group_already_deleted");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupDeleteError, GroupDeleteError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupDeleteError.class, getTagMapping(), null);
        }

        @Override
        public GroupDeleteError deserialize(GroupDeleteError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupDeleteError> getTagMapping() {
            Map<String, GroupDeleteError> values = new HashMap<String, GroupDeleteError>();
            values.put("group_already_deleted", GroupDeleteError.GROUP_ALREADY_DELETED);
            return Collections.unmodifiableMap(values);
        }
    }
}
