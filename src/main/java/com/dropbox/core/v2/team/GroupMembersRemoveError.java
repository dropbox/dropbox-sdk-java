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

@JsonSerialize(using=GroupMembersRemoveError.Serializer.class)
@JsonDeserialize(using=GroupMembersRemoveError.Deserializer.class)
public enum GroupMembersRemoveError {
    // union GroupMembersRemoveError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * At least one of the specified users is not a member of the group.
     */
    MEMBER_NOT_IN_GROUP,
    /**
     * Group is not in this team. You cannot remove members from a group that is
     * outside of your team.
     */
    GROUP_NOT_IN_TEAM;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupMembersRemoveError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMembersRemoveError.class);
        }

        @Override
        public void serialize(GroupMembersRemoveError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case GROUP_NOT_IN_TEAM:
                    g.writeString("group_not_in_team");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupMembersRemoveError, GroupMembersRemoveError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMembersRemoveError.class, getTagMapping(), null);
        }

        @Override
        public GroupMembersRemoveError deserialize(GroupMembersRemoveError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupMembersRemoveError> getTagMapping() {
            Map<String, GroupMembersRemoveError> values = new HashMap<String, GroupMembersRemoveError>();
            values.put("group_not_in_team", GroupMembersRemoveError.GROUP_NOT_IN_TEAM);
            return Collections.unmodifiableMap(values);
        }
    }
}
