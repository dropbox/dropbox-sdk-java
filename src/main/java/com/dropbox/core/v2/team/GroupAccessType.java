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

/**
 * Role of a user in group.
 */
@JsonSerialize(using=GroupAccessType.Serializer.class)
@JsonDeserialize(using=GroupAccessType.Deserializer.class)
public enum GroupAccessType {
    // union GroupAccessType
    /**
     * User is a member of the group, but has no special permissions.
     */
    MEMBER,
    /**
     * A group owner can rename the group, and add/remove members.
     */
    OWNER;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupAccessType> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupAccessType.class);
        }

        @Override
        public void serialize(GroupAccessType value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case MEMBER:
                    g.writeString("member");
                    break;
                case OWNER:
                    g.writeString("owner");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupAccessType, GroupAccessType> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupAccessType.class, getTagMapping(), null);
        }

        @Override
        public GroupAccessType deserialize(GroupAccessType _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupAccessType> getTagMapping() {
            Map<String, GroupAccessType> values = new HashMap<String, GroupAccessType>();
            values.put("member", GroupAccessType.MEMBER);
            values.put("owner", GroupAccessType.OWNER);
            return Collections.unmodifiableMap(values);
        }
    }
}
