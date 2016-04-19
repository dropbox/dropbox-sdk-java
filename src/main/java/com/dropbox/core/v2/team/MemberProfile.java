/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.users.Name;

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
 * Basic member profile.
 */
@JsonSerialize(using=MemberProfile.Serializer.class)
@JsonDeserialize(using=MemberProfile.Deserializer.class)
public class MemberProfile {
    // struct MemberProfile

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String teamMemberId;
    protected final String externalId;
    protected final String email;
    protected final boolean emailVerified;
    protected final TeamMemberStatus status;
    protected final Name name;

    /**
     * Basic member profile.
     *
     * @param teamMemberId  ID of user as a member of a team. Must not be {@code
     *     null}.
     * @param email  Email address of user. Must not be {@code null}.
     * @param emailVerified  Is true if the user's email is verified to be owned
     *     by the user.
     * @param status  The user's status as a member of a specific team. Must not
     *     be {@code null}.
     * @param name  Representations for a person's name. Must not be {@code
     *     null}.
     * @param externalId  External ID that a team can attach to the user. An
     *     application using the API may find it easier to use their own IDs
     *     instead of Dropbox IDs like account_id or team_member_id.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, String externalId) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        this.externalId = externalId;
        if (email == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        this.email = email;
        this.emailVerified = emailVerified;
        if (status == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = status;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
    }

    /**
     * Basic member profile.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamMemberId  ID of user as a member of a team. Must not be {@code
     *     null}.
     * @param email  Email address of user. Must not be {@code null}.
     * @param emailVerified  Is true if the user's email is verified to be owned
     *     by the user.
     * @param status  The user's status as a member of a specific team. Must not
     *     be {@code null}.
     * @param name  Representations for a person's name. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name) {
        this(teamMemberId, email, emailVerified, status, name, null);
    }

    /**
     * ID of user as a member of a team.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * External ID that a team can attach to the user. An application using the
     * API may find it easier to use their own IDs instead of Dropbox IDs like
     * account_id or team_member_id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Email address of user.
     *
     * @return value for this field, never {@code null}.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Is true if the user's email is verified to be owned by the user.
     *
     * @return value for this field.
     */
    public boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     * The user's status as a member of a specific team.
     *
     * @return value for this field, never {@code null}.
     */
    public TeamMemberStatus getStatus() {
        return status;
    }

    /**
     * Representations for a person's name.
     *
     * @return value for this field, never {@code null}.
     */
    public Name getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamMemberId,
            externalId,
            email,
            emailVerified,
            status,
            name
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
            MemberProfile other = (MemberProfile) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && ((this.status == other.status) || (this.status.equals(other.status)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.externalId == other.externalId) || (this.externalId != null && this.externalId.equals(other.externalId)))
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

    static final class Serializer extends StructJsonSerializer<MemberProfile> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberProfile.class);
        }

        public Serializer(boolean unwrapping) {
            super(MemberProfile.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MemberProfile> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MemberProfile value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("team_member_id", value.teamMemberId);
            g.writeObjectField("email", value.email);
            g.writeObjectField("email_verified", value.emailVerified);
            g.writeObjectField("status", value.status);
            g.writeObjectField("name", value.name);
            if (value.externalId != null) {
                g.writeObjectField("external_id", value.externalId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MemberProfile> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberProfile.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MemberProfile.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MemberProfile> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MemberProfile deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String teamMemberId = null;
            String email = null;
            Boolean emailVerified = null;
            TeamMemberStatus status = null;
            Name name = null;
            String externalId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("email".equals(_field)) {
                    email = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("email_verified".equals(_field)) {
                    emailVerified = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("status".equals(_field)) {
                    status = _p.readValueAs(TeamMemberStatus.class);
                    _p.nextToken();
                }
                else if ("name".equals(_field)) {
                    name = _p.readValueAs(Name.class);
                    _p.nextToken();
                }
                else if ("external_id".equals(_field)) {
                    externalId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (teamMemberId == null) {
                throw new JsonParseException(_p, "Required field \"team_member_id\" is missing.");
            }
            if (email == null) {
                throw new JsonParseException(_p, "Required field \"email\" is missing.");
            }
            if (emailVerified == null) {
                throw new JsonParseException(_p, "Required field \"email_verified\" is missing.");
            }
            if (status == null) {
                throw new JsonParseException(_p, "Required field \"status\" is missing.");
            }
            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }

            return new MemberProfile(teamMemberId, email, emailVerified, status, name, externalId);
        }
    }
}
