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

@JsonSerialize(using=MembersSetProfileError.Serializer.class)
@JsonDeserialize(using=MembersSetProfileError.Deserializer.class)
public enum MembersSetProfileError {
    // union MembersSetProfileError
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
     * It is unsafe to use both external_id and new_external_id
     */
    EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE,
    /**
     * None of new_email, new_given_name, new_surname, or new_external_id are
     * specified
     */
    NO_NEW_DATA_SPECIFIED,
    /**
     * Email is already reserved for another user.
     */
    EMAIL_RESERVED_FOR_OTHER_USER,
    /**
     * The external ID is already in use by another team member.
     */
    EXTERNAL_ID_USED_BY_OTHER_USER,
    /**
     * Setting profile disallowed
     */
    SET_PROFILE_DISALLOWED,
    /**
     * Parameter new_email cannot be empty.
     */
    PARAM_CANNOT_BE_EMPTY,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MembersSetProfileError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersSetProfileError.class);
        }

        @Override
        public void serialize(MembersSetProfileError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case USER_NOT_FOUND:
                    g.writeString("user_not_found");
                    break;
                case USER_NOT_IN_TEAM:
                    g.writeString("user_not_in_team");
                    break;
                case EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE:
                    g.writeString("external_id_and_new_external_id_unsafe");
                    break;
                case NO_NEW_DATA_SPECIFIED:
                    g.writeString("no_new_data_specified");
                    break;
                case EMAIL_RESERVED_FOR_OTHER_USER:
                    g.writeString("email_reserved_for_other_user");
                    break;
                case EXTERNAL_ID_USED_BY_OTHER_USER:
                    g.writeString("external_id_used_by_other_user");
                    break;
                case SET_PROFILE_DISALLOWED:
                    g.writeString("set_profile_disallowed");
                    break;
                case PARAM_CANNOT_BE_EMPTY:
                    g.writeString("param_cannot_be_empty");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersSetProfileError, MembersSetProfileError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersSetProfileError.class, getTagMapping(), MembersSetProfileError.OTHER);
        }

        @Override
        public MembersSetProfileError deserialize(MembersSetProfileError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MembersSetProfileError> getTagMapping() {
            Map<String, MembersSetProfileError> values = new HashMap<String, MembersSetProfileError>();
            values.put("external_id_and_new_external_id_unsafe", MembersSetProfileError.EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE);
            values.put("no_new_data_specified", MembersSetProfileError.NO_NEW_DATA_SPECIFIED);
            values.put("email_reserved_for_other_user", MembersSetProfileError.EMAIL_RESERVED_FOR_OTHER_USER);
            values.put("external_id_used_by_other_user", MembersSetProfileError.EXTERNAL_ID_USED_BY_OTHER_USER);
            values.put("set_profile_disallowed", MembersSetProfileError.SET_PROFILE_DISALLOWED);
            values.put("param_cannot_be_empty", MembersSetProfileError.PARAM_CANNOT_BE_EMPTY);
            values.put("other", MembersSetProfileError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
