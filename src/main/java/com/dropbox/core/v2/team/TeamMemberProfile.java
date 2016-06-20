/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.users.Name;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Profile of a user as a member of a team.
 */
public class TeamMemberProfile extends MemberProfile {
    // struct TeamMemberProfile

    protected final List<String> groups;

    /**
     * Profile of a user as a member of a team.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
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
     * @param membershipType  The user's membership type: full (normal team
     *     member) vs limited (does not use a license; no access to the team's
     *     shared quota). Must not be {@code null}.
     * @param groups  List of group IDs of groups that the user belongs to. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param externalId  External ID that a team can attach to the user. An
     *     application using the API may find it easier to use their own IDs
     *     instead of Dropbox IDs like account_id or team_member_id.
     * @param accountId  A user's account identifier. Must have length of at
     *     least 40 and have length of at most 40.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups, String externalId, String accountId) {
        super(teamMemberId, email, emailVerified, status, name, membershipType, externalId, accountId);
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
     * @param membershipType  The user's membership type: full (normal team
     *     member) vs limited (does not use a license; no access to the team's
     *     shared quota). Must not be {@code null}.
     * @param groups  List of group IDs of groups that the user belongs to. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups) {
        this(teamMemberId, email, emailVerified, status, name, membershipType, groups, null, null);
    }

    /**
     * List of group IDs of groups that the user belongs to.
     *
     * @return value for this field, never {@code null}.
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Returns a new builder for creating an instance of this class.
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
     * @param membershipType  The user's membership type: full (normal team
     *     member) vs limited (does not use a license; no access to the team's
     *     shared quota). Must not be {@code null}.
     * @param groups  List of group IDs of groups that the user belongs to. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups) {
        return new Builder(teamMemberId, email, emailVerified, status, name, membershipType, groups);
    }

    /**
     * Builder for {@link TeamMemberProfile}.
     */
    public static class Builder extends MemberProfile.Builder {
        protected final List<String> groups;

        protected Builder(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups) {
            super(teamMemberId, email, emailVerified, status, name, membershipType);
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
         * Set value for optional field.
         *
         * @param externalId  External ID that a team can attach to the user. An
         *     application using the API may find it easier to use their own IDs
         *     instead of Dropbox IDs like account_id or team_member_id.
         *
         * @return this builder
         */
        public Builder withExternalId(String externalId) {
            super.withExternalId(externalId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param accountId  A user's account identifier. Must have length of at
         *     least 40 and have length of at most 40.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAccountId(String accountId) {
            super.withAccountId(accountId);
            return this;
        }

        /**
         * Builds an instance of {@link TeamMemberProfile} configured with this
         * builder's values
         *
         * @return new instance of {@link TeamMemberProfile}
         */
        public TeamMemberProfile build() {
            return new TeamMemberProfile(teamMemberId, email, emailVerified, status, name, membershipType, groups, externalId, accountId);
        }
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
                && ((this.membershipType == other.membershipType) || (this.membershipType.equals(other.membershipType)))
                && ((this.groups == other.groups) || (this.groups.equals(other.groups)))
                && ((this.externalId == other.externalId) || (this.externalId != null && this.externalId.equals(other.externalId)))
                && ((this.accountId == other.accountId) || (this.accountId != null && this.accountId.equals(other.accountId)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static final class Serializer extends StructSerializer<TeamMemberProfile> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberProfile value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(value.teamMemberId, g);
            g.writeFieldName("email");
            StoneSerializers.string().serialize(value.email, g);
            g.writeFieldName("email_verified");
            StoneSerializers.boolean_().serialize(value.emailVerified, g);
            g.writeFieldName("status");
            TeamMemberStatus.Serializer.INSTANCE.serialize(value.status, g);
            g.writeFieldName("name");
            Name.Serializer.INSTANCE.serialize(value.name, g);
            g.writeFieldName("membership_type");
            TeamMembershipType.Serializer.INSTANCE.serialize(value.membershipType, g);
            g.writeFieldName("groups");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.groups, g);
            if (value.externalId != null) {
                g.writeFieldName("external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.externalId, g);
            }
            if (value.accountId != null) {
                g.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.accountId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberProfile deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberProfile value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamMemberId = null;
                String f_email = null;
                Boolean f_emailVerified = null;
                TeamMemberStatus f_status = null;
                Name f_name = null;
                TeamMembershipType f_membershipType = null;
                List<String> f_groups = null;
                String f_externalId = null;
                String f_accountId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("email".equals(field)) {
                        f_email = StoneSerializers.string().deserialize(p);
                    }
                    else if ("email_verified".equals(field)) {
                        f_emailVerified = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("status".equals(field)) {
                        f_status = TeamMemberStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = Name.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("membership_type".equals(field)) {
                        f_membershipType = TeamMembershipType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("groups".equals(field)) {
                        f_groups = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("external_id".equals(field)) {
                        f_externalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamMemberId == null) {
                    throw new JsonParseException(p, "Required field \"team_member_id\" missing.");
                }
                if (f_email == null) {
                    throw new JsonParseException(p, "Required field \"email\" missing.");
                }
                if (f_emailVerified == null) {
                    throw new JsonParseException(p, "Required field \"email_verified\" missing.");
                }
                if (f_status == null) {
                    throw new JsonParseException(p, "Required field \"status\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_membershipType == null) {
                    throw new JsonParseException(p, "Required field \"membership_type\" missing.");
                }
                if (f_groups == null) {
                    throw new JsonParseException(p, "Required field \"groups\" missing.");
                }
                value = new TeamMemberProfile(f_teamMemberId, f_email, f_emailVerified, f_status, f_name, f_membershipType, f_groups, f_externalId, f_accountId);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
