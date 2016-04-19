/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account.
 */
@JsonSerialize(using=MembersSetPermissionsArg.Serializer.class)
@JsonDeserialize(using=MembersSetPermissionsArg.Deserializer.class)
class MembersSetPermissionsArg {
    // struct MembersSetPermissionsArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UserSelectorArg user;
    protected final AdminTier newRole;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     * @param newRole  The new role of the member. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissionsArg(UserSelectorArg user, AdminTier newRole) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (newRole == null) {
            throw new IllegalArgumentException("Required value for 'newRole' is null");
        }
        this.newRole = newRole;
    }

    /**
     * Identity of user whose role will be set.
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * The new role of the member.
     *
     * @return value for this field, never {@code null}.
     */
    public AdminTier getNewRole() {
        return newRole;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user,
            newRole
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            MembersSetPermissionsArg other = (MembersSetPermissionsArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.newRole == other.newRole) || (this.newRole.equals(other.newRole)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<MembersSetPermissionsArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersSetPermissionsArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersSetPermissionsArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersSetPermissionsArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersSetPermissionsArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("user", value.user);
            g.writeObjectField("new_role", value.newRole);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersSetPermissionsArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersSetPermissionsArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersSetPermissionsArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersSetPermissionsArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersSetPermissionsArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            UserSelectorArg user = null;
            AdminTier newRole = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("user".equals(_field)) {
                    user = _p.readValueAs(UserSelectorArg.class);
                    _p.nextToken();
                }
                else if ("new_role".equals(_field)) {
                    newRole = _p.readValueAs(AdminTier.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (user == null) {
                throw new JsonParseException(_p, "Required field \"user\" is missing.");
            }
            if (newRole == null) {
                throw new JsonParseException(_p, "Required field \"new_role\" is missing.");
            }

            return new MembersSetPermissionsArg(user, newRole);
        }
    }
}
