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
 * Information about a team member.
 */
@JsonSerialize(using=TeamMemberInfo.Serializer.class)
@JsonDeserialize(using=TeamMemberInfo.Deserializer.class)
public class TeamMemberInfo {
    // struct TeamMemberInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final TeamMemberProfile profile;
    protected final AdminTier role;

    /**
     * Information about a team member.
     *
     * @param profile  Profile of a user as a member of a team. Must not be
     *     {@code null}.
     * @param role  The user's role in the team. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo(TeamMemberProfile profile, AdminTier role) {
        if (profile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = profile;
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
    }

    /**
     * Profile of a user as a member of a team.
     *
     * @return value for this field, never {@code null}.
     */
    public TeamMemberProfile getProfile() {
        return profile;
    }

    /**
     * The user's role in the team.
     *
     * @return value for this field, never {@code null}.
     */
    public AdminTier getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            profile,
            role
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
            TeamMemberInfo other = (TeamMemberInfo) obj;
            return ((this.profile == other.profile) || (this.profile.equals(other.profile)))
                && ((this.role == other.role) || (this.role.equals(other.role)))
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

    static final class Serializer extends StructJsonSerializer<TeamMemberInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamMemberInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(TeamMemberInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TeamMemberInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TeamMemberInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("profile", value.profile);
            g.writeObjectField("role", value.role);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TeamMemberInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamMemberInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TeamMemberInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TeamMemberInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TeamMemberInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            TeamMemberProfile profile = null;
            AdminTier role = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("profile".equals(_field)) {
                    profile = _p.readValueAs(TeamMemberProfile.class);
                    _p.nextToken();
                }
                else if ("role".equals(_field)) {
                    role = _p.readValueAs(AdminTier.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (profile == null) {
                throw new JsonParseException(_p, "Required field \"profile\" is missing.");
            }
            if (role == null) {
                throw new JsonParseException(_p, "Required field \"role\" is missing.");
            }

            return new TeamMemberInfo(profile, role);
        }
    }
}
