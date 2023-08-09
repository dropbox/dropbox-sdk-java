/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.secondaryemails.SecondaryEmail;
import com.dropbox.core.v2.users.Name;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Profile of a user as a member of a team.
 */
public class TeamMemberProfile extends MemberProfile {
    // struct team.TeamMemberProfile (team_members.stone)

    protected final List<String> groups;
    protected final String memberFolderId;

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
     * @param memberFolderId  The namespace id of the user's root folder. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param externalId  External ID that a team can attach to the user. An
     *     application using the API may find it easier to use their own IDs
     *     instead of Dropbox IDs like account_id or team_member_id.
     * @param accountId  A user's account identifier. Must have length of at
     *     least 40 and have length of at most 40.
     * @param secondaryEmails  Secondary emails of a user. Must not contain a
     *     {@code null} item.
     * @param invitedOn  The date and time the user was invited to the team
     *     (contains value only when the member's status matches {@link
     *     TeamMemberStatus#INVITED}).
     * @param joinedOn  The date and time the user joined as a member of a
     *     specific team.
     * @param suspendedOn  The date and time the user was suspended from the
     *     team (contains value only when the member's status matches {@link
     *     TeamMemberStatus#SUSPENDED}).
     * @param persistentId  Persistent ID that a team can attach to the user.
     *     The persistent ID is unique ID to be used for SAML authentication.
     * @param isDirectoryRestricted  Whether the user is a directory restricted
     *     user.
     * @param profilePhotoUrl  URL for the photo representing the user, if one
     *     is set.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups, String memberFolderId, String externalId, String accountId, List<SecondaryEmail> secondaryEmails, Date invitedOn, Date joinedOn, Date suspendedOn, String persistentId, Boolean isDirectoryRestricted, String profilePhotoUrl) {
        super(teamMemberId, email, emailVerified, status, name, membershipType, externalId, accountId, secondaryEmails, invitedOn, joinedOn, suspendedOn, persistentId, isDirectoryRestricted, profilePhotoUrl);
        if (groups == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        for (String x : groups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = groups;
        if (memberFolderId == null) {
            throw new IllegalArgumentException("Required value for 'memberFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", memberFolderId)) {
            throw new IllegalArgumentException("String 'memberFolderId' does not match pattern");
        }
        this.memberFolderId = memberFolderId;
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
     * @param memberFolderId  The namespace id of the user's root folder. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups, String memberFolderId) {
        this(teamMemberId, email, emailVerified, status, name, membershipType, groups, memberFolderId, null, null, null, null, null, null, null, null, null);
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

    /**
     * The user's membership type: full (normal team member) vs limited (does
     * not use a license; no access to the team's shared quota).
     *
     * @return value for this field, never {@code null}.
     */
    public TeamMembershipType getMembershipType() {
        return membershipType;
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
     * The namespace id of the user's root folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getMemberFolderId() {
        return memberFolderId;
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
     * A user's account identifier.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Secondary emails of a user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<SecondaryEmail> getSecondaryEmails() {
        return secondaryEmails;
    }

    /**
     * The date and time the user was invited to the team (contains value only
     * when the member's status matches {@link TeamMemberStatus#INVITED}).
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getInvitedOn() {
        return invitedOn;
    }

    /**
     * The date and time the user joined as a member of a specific team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getJoinedOn() {
        return joinedOn;
    }

    /**
     * The date and time the user was suspended from the team (contains value
     * only when the member's status matches {@link
     * TeamMemberStatus#SUSPENDED}).
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getSuspendedOn() {
        return suspendedOn;
    }

    /**
     * Persistent ID that a team can attach to the user. The persistent ID is
     * unique ID to be used for SAML authentication.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPersistentId() {
        return persistentId;
    }

    /**
     * Whether the user is a directory restricted user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getIsDirectoryRestricted() {
        return isDirectoryRestricted;
    }

    /**
     * URL for the photo representing the user, if one is set.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
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
     * @param memberFolderId  The namespace id of the user's root folder. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups, String memberFolderId) {
        return new Builder(teamMemberId, email, emailVerified, status, name, membershipType, groups, memberFolderId);
    }

    /**
     * Builder for {@link TeamMemberProfile}.
     */
    public static class Builder extends MemberProfile.Builder {
        protected final List<String> groups;
        protected final String memberFolderId;

        protected Builder(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, TeamMembershipType membershipType, List<String> groups, String memberFolderId) {
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
            if (memberFolderId == null) {
                throw new IllegalArgumentException("Required value for 'memberFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", memberFolderId)) {
                throw new IllegalArgumentException("String 'memberFolderId' does not match pattern");
            }
            this.memberFolderId = memberFolderId;
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
         * Set value for optional field.
         *
         * @param secondaryEmails  Secondary emails of a user. Must not contain
         *     a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSecondaryEmails(List<SecondaryEmail> secondaryEmails) {
            super.withSecondaryEmails(secondaryEmails);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param invitedOn  The date and time the user was invited to the team
         *     (contains value only when the member's status matches {@link
         *     TeamMemberStatus#INVITED}).
         *
         * @return this builder
         */
        public Builder withInvitedOn(Date invitedOn) {
            super.withInvitedOn(invitedOn);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param joinedOn  The date and time the user joined as a member of a
         *     specific team.
         *
         * @return this builder
         */
        public Builder withJoinedOn(Date joinedOn) {
            super.withJoinedOn(joinedOn);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param suspendedOn  The date and time the user was suspended from the
         *     team (contains value only when the member's status matches {@link
         *     TeamMemberStatus#SUSPENDED}).
         *
         * @return this builder
         */
        public Builder withSuspendedOn(Date suspendedOn) {
            super.withSuspendedOn(suspendedOn);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param persistentId  Persistent ID that a team can attach to the
         *     user. The persistent ID is unique ID to be used for SAML
         *     authentication.
         *
         * @return this builder
         */
        public Builder withPersistentId(String persistentId) {
            super.withPersistentId(persistentId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param isDirectoryRestricted  Whether the user is a directory
         *     restricted user.
         *
         * @return this builder
         */
        public Builder withIsDirectoryRestricted(Boolean isDirectoryRestricted) {
            super.withIsDirectoryRestricted(isDirectoryRestricted);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param profilePhotoUrl  URL for the photo representing the user, if
         *     one is set.
         *
         * @return this builder
         */
        public Builder withProfilePhotoUrl(String profilePhotoUrl) {
            super.withProfilePhotoUrl(profilePhotoUrl);
            return this;
        }

        /**
         * Builds an instance of {@link TeamMemberProfile} configured with this
         * builder's values
         *
         * @return new instance of {@link TeamMemberProfile}
         */
        public TeamMemberProfile build() {
            return new TeamMemberProfile(teamMemberId, email, emailVerified, status, name, membershipType, groups, memberFolderId, externalId, accountId, secondaryEmails, invitedOn, joinedOn, suspendedOn, persistentId, isDirectoryRestricted, profilePhotoUrl);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            groups,
            memberFolderId
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
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
                && ((this.memberFolderId == other.memberFolderId) || (this.memberFolderId.equals(other.memberFolderId)))
                && ((this.externalId == other.externalId) || (this.externalId != null && this.externalId.equals(other.externalId)))
                && ((this.accountId == other.accountId) || (this.accountId != null && this.accountId.equals(other.accountId)))
                && ((this.secondaryEmails == other.secondaryEmails) || (this.secondaryEmails != null && this.secondaryEmails.equals(other.secondaryEmails)))
                && ((this.invitedOn == other.invitedOn) || (this.invitedOn != null && this.invitedOn.equals(other.invitedOn)))
                && ((this.joinedOn == other.joinedOn) || (this.joinedOn != null && this.joinedOn.equals(other.joinedOn)))
                && ((this.suspendedOn == other.suspendedOn) || (this.suspendedOn != null && this.suspendedOn.equals(other.suspendedOn)))
                && ((this.persistentId == other.persistentId) || (this.persistentId != null && this.persistentId.equals(other.persistentId)))
                && ((this.isDirectoryRestricted == other.isDirectoryRestricted) || (this.isDirectoryRestricted != null && this.isDirectoryRestricted.equals(other.isDirectoryRestricted)))
                && ((this.profilePhotoUrl == other.profilePhotoUrl) || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(other.profilePhotoUrl)))
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
    static class Serializer extends StructSerializer<TeamMemberProfile> {
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
            g.writeFieldName("member_folder_id");
            StoneSerializers.string().serialize(value.memberFolderId, g);
            if (value.externalId != null) {
                g.writeFieldName("external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.externalId, g);
            }
            if (value.accountId != null) {
                g.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.accountId, g);
            }
            if (value.secondaryEmails != null) {
                g.writeFieldName("secondary_emails");
                StoneSerializers.nullable(StoneSerializers.list(SecondaryEmail.Serializer.INSTANCE)).serialize(value.secondaryEmails, g);
            }
            if (value.invitedOn != null) {
                g.writeFieldName("invited_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.invitedOn, g);
            }
            if (value.joinedOn != null) {
                g.writeFieldName("joined_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.joinedOn, g);
            }
            if (value.suspendedOn != null) {
                g.writeFieldName("suspended_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.suspendedOn, g);
            }
            if (value.persistentId != null) {
                g.writeFieldName("persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.persistentId, g);
            }
            if (value.isDirectoryRestricted != null) {
                g.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isDirectoryRestricted, g);
            }
            if (value.profilePhotoUrl != null) {
                g.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.profilePhotoUrl, g);
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
                String f_memberFolderId = null;
                String f_externalId = null;
                String f_accountId = null;
                List<SecondaryEmail> f_secondaryEmails = null;
                Date f_invitedOn = null;
                Date f_joinedOn = null;
                Date f_suspendedOn = null;
                String f_persistentId = null;
                Boolean f_isDirectoryRestricted = null;
                String f_profilePhotoUrl = null;
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
                    else if ("member_folder_id".equals(field)) {
                        f_memberFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("external_id".equals(field)) {
                        f_externalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("secondary_emails".equals(field)) {
                        f_secondaryEmails = StoneSerializers.nullable(StoneSerializers.list(SecondaryEmail.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("invited_on".equals(field)) {
                        f_invitedOn = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("joined_on".equals(field)) {
                        f_joinedOn = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("suspended_on".equals(field)) {
                        f_suspendedOn = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("persistent_id".equals(field)) {
                        f_persistentId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("is_directory_restricted".equals(field)) {
                        f_isDirectoryRestricted = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("profile_photo_url".equals(field)) {
                        f_profilePhotoUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                if (f_memberFolderId == null) {
                    throw new JsonParseException(p, "Required field \"member_folder_id\" missing.");
                }
                value = new TeamMemberProfile(f_teamMemberId, f_email, f_emailVerified, f_status, f_name, f_membershipType, f_groups, f_memberFolderId, f_externalId, f_accountId, f_secondaryEmails, f_invitedOn, f_joinedOn, f_suspendedOn, f_persistentId, f_isDirectoryRestricted, f_profilePhotoUrl);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
