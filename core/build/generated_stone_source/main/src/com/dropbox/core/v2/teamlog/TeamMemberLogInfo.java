/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Team member's logged information.
 */
public class TeamMemberLogInfo extends UserLogInfo {
    // struct team_log.TeamMemberLogInfo (team_log_generated.stone)

    @Nullable
    protected final String teamMemberId;
    @Nullable
    protected final String memberExternalId;
    @Nullable
    protected final TeamLogInfo team;

    /**
     * Team member's logged information.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accountId  User unique ID. Must have length of at least 40 and
     *     have length of at most 40.
     * @param displayName  User display name.
     * @param email  User email address. Must have length of at most 255.
     * @param teamMemberId  Team member ID.
     * @param memberExternalId  Team member external ID. Must have length of at
     *     most 64.
     * @param team  Details about this user&amp;#x2019s team for enterprise
     *     event.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberLogInfo(@Nullable String accountId, @Nullable String displayName, @Nullable String email, @Nullable String teamMemberId, @Nullable String memberExternalId, @Nullable TeamLogInfo team) {
        super(accountId, displayName, email);
        this.teamMemberId = teamMemberId;
        if (memberExternalId != null) {
            if (memberExternalId.length() > 64) {
                throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
            }
        }
        this.memberExternalId = memberExternalId;
        this.team = team;
    }

    /**
     * Team member's logged information.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public TeamMemberLogInfo() {
        this(null, null, null, null, null, null);
    }

    /**
     * User unique ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getAccountId() {
        return accountId;
    }

    /**
     * User display name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    /**
     * User email address.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getEmail() {
        return email;
    }

    /**
     * Team member ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Team member external ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getMemberExternalId() {
        return memberExternalId;
    }

    /**
     * Details about this user&amp;#x2019s team for enterprise event.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public TeamLogInfo getTeam() {
        return team;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link TeamMemberLogInfo}.
     */
    public static class Builder extends UserLogInfo.Builder {

        protected String teamMemberId;
        protected String memberExternalId;
        protected TeamLogInfo team;

        protected Builder() {
            this.teamMemberId = null;
            this.memberExternalId = null;
            this.team = null;
        }

        /**
         * Set value for optional field.
         *
         * @param teamMemberId  Team member ID.
         *
         * @return this builder
         */
        public Builder withTeamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param memberExternalId  Team member external ID. Must have length of
         *     at most 64.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMemberExternalId(String memberExternalId) {
            if (memberExternalId != null) {
                if (memberExternalId.length() > 64) {
                    throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
                }
            }
            this.memberExternalId = memberExternalId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param team  Details about this user&amp;#x2019s team for enterprise
         *     event.
         *
         * @return this builder
         */
        public Builder withTeam(TeamLogInfo team) {
            this.team = team;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param accountId  User unique ID. Must have length of at least 40 and
         *     have length of at most 40.
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
         * @param displayName  User display name.
         *
         * @return this builder
         */
        public Builder withDisplayName(String displayName) {
            super.withDisplayName(displayName);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param email  User email address. Must have length of at most 255.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withEmail(String email) {
            super.withEmail(email);
            return this;
        }

        /**
         * Builds an instance of {@link TeamMemberLogInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link TeamMemberLogInfo}
         */
        public TeamMemberLogInfo build() {
            return new TeamMemberLogInfo(accountId, displayName, email, teamMemberId, memberExternalId, team);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamMemberId,
            memberExternalId,
            team
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
            TeamMemberLogInfo other = (TeamMemberLogInfo) obj;
            return ((this.accountId == other.accountId) || (this.accountId != null && this.accountId.equals(other.accountId)))
                && ((this.displayName == other.displayName) || (this.displayName != null && this.displayName.equals(other.displayName)))
                && ((this.email == other.email) || (this.email != null && this.email.equals(other.email)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId != null && this.teamMemberId.equals(other.teamMemberId)))
                && ((this.memberExternalId == other.memberExternalId) || (this.memberExternalId != null && this.memberExternalId.equals(other.memberExternalId)))
                && ((this.team == other.team) || (this.team != null && this.team.equals(other.team)))
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
    static class Serializer extends StructSerializer<TeamMemberLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("team_member", g);
            if (value.accountId != null) {
                g.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.accountId, g);
            }
            if (value.displayName != null) {
                g.writeFieldName("display_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.displayName, g);
            }
            if (value.email != null) {
                g.writeFieldName("email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.email, g);
            }
            if (value.teamMemberId != null) {
                g.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.teamMemberId, g);
            }
            if (value.memberExternalId != null) {
                g.writeFieldName("member_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.memberExternalId, g);
            }
            if (value.team != null) {
                g.writeFieldName("team");
                StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).serialize(value.team, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("team_member".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_accountId = null;
                String f_displayName = null;
                String f_email = null;
                String f_teamMemberId = null;
                String f_memberExternalId = null;
                TeamLogInfo f_team = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("email".equals(field)) {
                        f_email = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("member_external_id".equals(field)) {
                        f_memberExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("team".equals(field)) {
                        f_team = StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new TeamMemberLogInfo(f_accountId, f_displayName, f_email, f_teamMemberId, f_memberExternalId, f_team);
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
