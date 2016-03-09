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

@JsonSerialize(using=MembersSetPermissionsError.Serializer.class)
@JsonDeserialize(using=MembersSetPermissionsError.Deserializer.class)
public enum MembersSetPermissionsError {
    // union MembersSetPermissionsError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * Cannot remove the admin setting of the last admin.
     */
    LAST_ADMIN,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM,
    /**
     * Cannot remove/grant permissions.
     */
    CANNOT_SET_PERMISSIONS,
    /**
     * Team is full. The organization has no available licenses.
     */
    TEAM_LICENSE_LIMIT,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MembersSetPermissionsError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersSetPermissionsError.class);
        }

        @Override
        public void serialize(MembersSetPermissionsError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case USER_NOT_FOUND:
                    g.writeString("user_not_found");
                    break;
                case LAST_ADMIN:
                    g.writeString("last_admin");
                    break;
                case USER_NOT_IN_TEAM:
                    g.writeString("user_not_in_team");
                    break;
                case CANNOT_SET_PERMISSIONS:
                    g.writeString("cannot_set_permissions");
                    break;
                case TEAM_LICENSE_LIMIT:
                    g.writeString("team_license_limit");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersSetPermissionsError, MembersSetPermissionsError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersSetPermissionsError.class, getTagMapping(), MembersSetPermissionsError.OTHER);
        }

        @Override
        public MembersSetPermissionsError deserialize(MembersSetPermissionsError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MembersSetPermissionsError> getTagMapping() {
            Map<String, MembersSetPermissionsError> values = new HashMap<String, MembersSetPermissionsError>();
            values.put("last_admin", MembersSetPermissionsError.LAST_ADMIN);
            values.put("user_not_in_team", MembersSetPermissionsError.USER_NOT_IN_TEAM);
            values.put("cannot_set_permissions", MembersSetPermissionsError.CANNOT_SET_PERMISSIONS);
            values.put("team_license_limit", MembersSetPermissionsError.TEAM_LICENSE_LIMIT);
            values.put("other", MembersSetPermissionsError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
