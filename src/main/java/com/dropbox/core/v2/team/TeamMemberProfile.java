/* DO NOT EDIT */
/* This file was generated from team_members.babel */

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
import java.util.List;

/**
 * Profile of a user as a member of a team.
 */
@JsonSerialize(using=TeamMemberProfile.Serializer.class)
@JsonDeserialize(using=TeamMemberProfile.Deserializer.class)
public class TeamMemberProfile extends MemberProfile {
    // struct TeamMemberProfile

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<String> groups;

    /**
     * Profile of a user as a member of a team.
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
     * @param groups  List of group IDs of groups that the user belongs to. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param externalId  External ID that a team can attach to the user. An
     *     application using the API may find it easier to use their own IDs
     *     instead of Dropbox IDs like account_id or team_member_id.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, List<String> groups, String externalId) {
        super(teamMemberId, email, emailVerified, status, name, externalId);
        if (groups == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        for (String x : groups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = groups;
    }

    /**
     * Profile of a user as a member of a team.
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
     * @param groups  List of group IDs of groups that the user belongs to. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, List<String> groups) {
        this(teamMemberId, email, emailVerified, status, name, groups, null);
    }

    /**
     * List of group IDs of groups that the user belongs to.
     *
     * @return value for this field, never {@code null}.
     */
    public List<String> getGroups() {
        return groups;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groups
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            TeamMemberProfile other = (TeamMemberProfile) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && ((this.status == other.status) || (this.status.equals(other.status)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.groups == other.groups) || (this.groups.equals(other.groups)))
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

    static final class Serializer extends StructJsonSerializer<TeamMemberProfile> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamMemberProfile.class);
        }

        public Serializer(boolean unwrapping) {
            super(TeamMemberProfile.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TeamMemberProfile> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TeamMemberProfile value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("team_member_id", value.teamMemberId);
            g.writeObjectField("email", value.email);
            g.writeObjectField("email_verified", value.emailVerified);
            g.writeObjectField("status", value.status);
            g.writeObjectField("name", value.name);
            g.writeObjectField("groups", value.groups);
            if (value.externalId != null) {
                g.writeObjectField("external_id", value.externalId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TeamMemberProfile> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamMemberProfile.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TeamMemberProfile.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TeamMemberProfile> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TeamMemberProfile deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String teamMemberId = null;
            String email = null;
            Boolean emailVerified = null;
            TeamMemberStatus status = null;
            Name name = null;
            List<String> groups = null;
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
                else if ("groups".equals(_field)) {
                    expectArrayStart(_p);
                    groups = new java.util.ArrayList<String>();
                    while (!isArrayEnd(_p)) {
                        String _x = null;
                        _x = getStringValue(_p);
                        _p.nextToken();
                        groups.add(_x);
                    }
                    expectArrayEnd(_p);
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
            if (groups == null) {
                throw new JsonParseException(_p, "Required field \"groups\" is missing.");
            }

            return new TeamMemberProfile(teamMemberId, email, emailVerified, status, name, groups, externalId);
        }
    }
}
