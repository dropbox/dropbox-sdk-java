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

@JsonSerialize(using=MembersSuspendError.Serializer.class)
@JsonDeserialize(using=MembersSuspendError.Deserializer.class)
public enum MembersSuspendError {
    // union MembersSuspendError
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
     * The user is not active, so it cannot be suspended.
     */
    SUSPEND_INACTIVE_USER,
    /**
     * The user is the last admin of the team, so it cannot be suspended.
     */
    SUSPEND_LAST_ADMIN,
    /**
     * Team is full. The organization has no available licenses.
     */
    TEAM_LICENSE_LIMIT;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MembersSuspendError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersSuspendError.class);
        }

        @Override
        public void serialize(MembersSuspendError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case SUSPEND_INACTIVE_USER:
                    g.writeString("suspend_inactive_user");
                    break;
                case SUSPEND_LAST_ADMIN:
                    g.writeString("suspend_last_admin");
                    break;
                case TEAM_LICENSE_LIMIT:
                    g.writeString("team_license_limit");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersSuspendError, MembersSuspendError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersSuspendError.class, getTagMapping(), null);
        }

        @Override
        public MembersSuspendError deserialize(MembersSuspendError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MembersSuspendError> getTagMapping() {
            Map<String, MembersSuspendError> values = new HashMap<String, MembersSuspendError>();
            values.put("suspend_inactive_user", MembersSuspendError.SUSPEND_INACTIVE_USER);
            values.put("suspend_last_admin", MembersSuspendError.SUSPEND_LAST_ADMIN);
            values.put("team_license_limit", MembersSuspendError.TEAM_LICENSE_LIMIT);
            return Collections.unmodifiableMap(values);
        }
    }
}
