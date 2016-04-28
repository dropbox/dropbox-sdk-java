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

@JsonSerialize(using=GroupMemberSetAccessTypeError.Serializer.class)
@JsonDeserialize(using=GroupMemberSetAccessTypeError.Deserializer.class)
public enum GroupMemberSetAccessTypeError {
    // union GroupMemberSetAccessTypeError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * The specified user is not a member of this group.
     */
    MEMBER_NOT_IN_GROUP,
    /**
     * A company managed group cannot be managed by a user.
     */
    USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupMemberSetAccessTypeError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMemberSetAccessTypeError.class);
        }

        @Override
        public void serialize(GroupMemberSetAccessTypeError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP:
                    g.writeString("user_cannot_be_manager_of_company_managed_group");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupMemberSetAccessTypeError, GroupMemberSetAccessTypeError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMemberSetAccessTypeError.class, getTagMapping(), null);
        }

        @Override
        public GroupMemberSetAccessTypeError deserialize(GroupMemberSetAccessTypeError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupMemberSetAccessTypeError> getTagMapping() {
            Map<String, GroupMemberSetAccessTypeError> values = new HashMap<String, GroupMemberSetAccessTypeError>();
            values.put("user_cannot_be_manager_of_company_managed_group", GroupMemberSetAccessTypeError.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP);
            return Collections.unmodifiableMap(values);
        }
    }
}
