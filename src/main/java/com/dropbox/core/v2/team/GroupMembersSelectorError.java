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
 * Error that can be raised when {@link GroupMembersSelector} is used, and the
 * users are required to be members of the specified group.
 */
@JsonSerialize(using=GroupMembersSelectorError.Serializer.class)
@JsonDeserialize(using=GroupMembersSelectorError.Deserializer.class)
public enum GroupMembersSelectorError {
    // union GroupMembersSelectorError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * At least one of the specified users is not a member of the group.
     */
    MEMBER_NOT_IN_GROUP;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupMembersSelectorError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMembersSelectorError.class);
        }

        @Override
        public void serialize(GroupMembersSelectorError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case GROUP_NOT_FOUND:
                    g.writeString("group_not_found");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
                case MEMBER_NOT_IN_GROUP:
                    g.writeString("member_not_in_group");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupMembersSelectorError, GroupMembersSelectorError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMembersSelectorError.class, getTagMapping(), null);
        }

        @Override
        public GroupMembersSelectorError deserialize(GroupMembersSelectorError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupMembersSelectorError> getTagMapping() {
            Map<String, GroupMembersSelectorError> values = new HashMap<String, GroupMembersSelectorError>();
            values.put("member_not_in_group", GroupMembersSelectorError.MEMBER_NOT_IN_GROUP);
            return Collections.unmodifiableMap(values);
        }
    }
}
