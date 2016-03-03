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

@JsonSerialize(using=MembersRemoveError.Serializer.class)
@JsonDeserialize(using=MembersRemoveError.Deserializer.class)
public enum MembersRemoveError {
    // union MembersRemoveError
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
     * The user is the last admin of the team, so it cannot be removed from it.
     */
    REMOVE_LAST_ADMIN,
    /**
     * Expected removed user and transfer_dest user to be different
     */
    REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER,
    /**
     * Expected removed user and transfer_admin user to be different.
     */
    REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER,
    /**
     * No matching user found for the argument transfer_dest_id.
     */
    TRANSFER_DEST_USER_NOT_FOUND,
    /**
     * The provided transfer_dest_id does not exist on this team.
     */
    TRANSFER_DEST_USER_NOT_IN_TEAM,
    /**
     * No matching user found for the argument transfer_admin_id.
     */
    TRANSFER_ADMIN_USER_NOT_FOUND,
    /**
     * The provided transfer_admin_id does not exist on this team.
     */
    TRANSFER_ADMIN_USER_NOT_IN_TEAM,
    /**
     * The transfer_admin_id argument must be provided when file transfer is
     * requested.
     */
    UNSPECIFIED_TRANSFER_ADMIN_ID,
    /**
     * Specified transfer_admin user is not a team admin.
     */
    TRANSFER_ADMIN_IS_NOT_ADMIN;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MembersRemoveError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersRemoveError.class);
        }

        @Override
        public void serialize(MembersRemoveError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case REMOVE_LAST_ADMIN:
                    g.writeString("remove_last_admin");
                    break;
                case REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER:
                    g.writeString("removed_and_transfer_dest_should_differ");
                    break;
                case REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER:
                    g.writeString("removed_and_transfer_admin_should_differ");
                    break;
                case TRANSFER_DEST_USER_NOT_FOUND:
                    g.writeString("transfer_dest_user_not_found");
                    break;
                case TRANSFER_DEST_USER_NOT_IN_TEAM:
                    g.writeString("transfer_dest_user_not_in_team");
                    break;
                case TRANSFER_ADMIN_USER_NOT_FOUND:
                    g.writeString("transfer_admin_user_not_found");
                    break;
                case TRANSFER_ADMIN_USER_NOT_IN_TEAM:
                    g.writeString("transfer_admin_user_not_in_team");
                    break;
                case UNSPECIFIED_TRANSFER_ADMIN_ID:
                    g.writeString("unspecified_transfer_admin_id");
                    break;
                case TRANSFER_ADMIN_IS_NOT_ADMIN:
                    g.writeString("transfer_admin_is_not_admin");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersRemoveError, MembersRemoveError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersRemoveError.class, getTagMapping(), null);
        }

        @Override
        public MembersRemoveError deserialize(MembersRemoveError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MembersRemoveError> getTagMapping() {
            Map<String, MembersRemoveError> values = new HashMap<String, MembersRemoveError>();
            values.put("remove_last_admin", MembersRemoveError.REMOVE_LAST_ADMIN);
            values.put("removed_and_transfer_dest_should_differ", MembersRemoveError.REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER);
            values.put("removed_and_transfer_admin_should_differ", MembersRemoveError.REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER);
            values.put("transfer_dest_user_not_found", MembersRemoveError.TRANSFER_DEST_USER_NOT_FOUND);
            values.put("transfer_dest_user_not_in_team", MembersRemoveError.TRANSFER_DEST_USER_NOT_IN_TEAM);
            values.put("transfer_admin_user_not_found", MembersRemoveError.TRANSFER_ADMIN_USER_NOT_FOUND);
            values.put("transfer_admin_user_not_in_team", MembersRemoveError.TRANSFER_ADMIN_USER_NOT_IN_TEAM);
            values.put("unspecified_transfer_admin_id", MembersRemoveError.UNSPECIFIED_TRANSFER_ADMIN_ID);
            values.put("transfer_admin_is_not_admin", MembersRemoveError.TRANSFER_ADMIN_IS_NOT_ADMIN);
            return Collections.unmodifiableMap(values);
        }
    }
}
