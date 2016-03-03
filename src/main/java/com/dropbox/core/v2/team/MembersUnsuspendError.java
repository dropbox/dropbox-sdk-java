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

@JsonSerialize(using=MembersUnsuspendError.Serializer.class)
@JsonDeserialize(using=MembersUnsuspendError.Deserializer.class)
public enum MembersUnsuspendError {
    // union MembersUnsuspendError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM,
    /**
     * An unspecified error.
     */
    OTHER,
    /**
     * The user is unsuspended, so it cannot be unsuspended again.
     */
    UNSUSPEND_NON_SUSPENDED_MEMBER;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MembersUnsuspendError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersUnsuspendError.class);
        }

        @Override
        public void serialize(MembersUnsuspendError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case USER_NOT_FOUND:
                    g.writeString("user_not_found");
                    break;
                case USER_NOT_IN_TEAM:
                    g.writeString("user_not_in_team");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
                case UNSUSPEND_NON_SUSPENDED_MEMBER:
                    g.writeString("unsuspend_non_suspended_member");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersUnsuspendError, MembersUnsuspendError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersUnsuspendError.class, getTagMapping(), null);
        }

        @Override
        public MembersUnsuspendError deserialize(MembersUnsuspendError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MembersUnsuspendError> getTagMapping() {
            Map<String, MembersUnsuspendError> values = new HashMap<String, MembersUnsuspendError>();
            values.put("unsuspend_non_suspended_member", MembersUnsuspendError.UNSUSPEND_NON_SUSPENDED_MEMBER);
            return Collections.unmodifiableMap(values);
        }
    }
}
