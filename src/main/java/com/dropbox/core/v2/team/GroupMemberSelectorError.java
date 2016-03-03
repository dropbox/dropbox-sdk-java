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
 * Error that can be raised when {@link GroupMemberSelector} is used, and the
 * user is required to be a member of the specified group.
 */
@JsonSerialize(using=GroupMemberSelectorError.Serializer.class)
@JsonDeserialize(using=GroupMemberSelectorError.Deserializer.class)
public enum GroupMemberSelectorError {
    // union GroupMemberSelectorError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * The specified user is not a member of this group.
     */
    MEMBER_NOT_IN_GROUP;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupMemberSelectorError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMemberSelectorError.class);
        }

        @Override
        public void serialize(GroupMemberSelectorError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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

    static final class Deserializer extends UnionJsonDeserializer<GroupMemberSelectorError, GroupMemberSelectorError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMemberSelectorError.class, getTagMapping(), null);
        }

        @Override
        public GroupMemberSelectorError deserialize(GroupMemberSelectorError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupMemberSelectorError> getTagMapping() {
            Map<String, GroupMemberSelectorError> values = new HashMap<String, GroupMemberSelectorError>();
            values.put("member_not_in_group", GroupMemberSelectorError.MEMBER_NOT_IN_GROUP);
            return Collections.unmodifiableMap(values);
        }
    }
}
