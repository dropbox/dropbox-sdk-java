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
 * User that is not a member of the team but considered trusted.
 */
public class TrustedNonTeamMemberLogInfo extends UserLogInfo {
    // struct team_log.TrustedNonTeamMemberLogInfo (team_log_generated.stone)

    @Nonnull
    protected final TrustedNonTeamMemberType trustedNonTeamMemberType;
    @Nullable
    protected final TeamLogInfo team;

    /**
     * User that is not a member of the team but considered trusted.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param trustedNonTeamMemberType  Indicates the type of the member of a
     *     trusted team. Must not be {@code null}.
     * @param accountId  User unique ID. Must have length of at least 40 and
     *     have length of at most 40.
     * @param displayName  User display name.
     * @param email  User email address. Must have length of at most 255.
     * @param team  Details about this user's trusted team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TrustedNonTeamMemberLogInfo(@Nonnull TrustedNonTeamMemberType trustedNonTeamMemberType, @Nullable String accountId, @Nullable String displayName, @Nullable String email, @Nullable TeamLogInfo team) {
        super(accountId, displayName, email);
        if (trustedNonTeamMemberType == null) {
            throw new IllegalArgumentException("Required value for 'trustedNonTeamMemberType' is null");
        }
        this.trustedNonTeamMemberType = trustedNonTeamMemberType;
        this.team = team;
    }

    /**
     * User that is not a member of the team but considered trusted.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param trustedNonTeamMemberType  Indicates the type of the member of a
     *     trusted team. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TrustedNonTeamMemberLogInfo(@Nonnull TrustedNonTeamMemberType trustedNonTeamMemberType) {
        this(trustedNonTeamMemberType, null, null, null, null);
    }

    /**
     * Indicates the type of the member of a trusted team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TrustedNonTeamMemberType getTrustedNonTeamMemberType() {
        return trustedNonTeamMemberType;
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
     * Details about this user's trusted team.
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
     * @param trustedNonTeamMemberType  Indicates the type of the member of a
     *     trusted team. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(TrustedNonTeamMemberType trustedNonTeamMemberType) {
        return new Builder(trustedNonTeamMemberType);
    }

    /**
     * Builder for {@link TrustedNonTeamMemberLogInfo}.
     */
    public static class Builder extends UserLogInfo.Builder {
        protected final TrustedNonTeamMemberType trustedNonTeamMemberType;

        protected TeamLogInfo team;

        protected Builder(TrustedNonTeamMemberType trustedNonTeamMemberType) {
            if (trustedNonTeamMemberType == null) {
                throw new IllegalArgumentException("Required value for 'trustedNonTeamMemberType' is null");
            }
            this.trustedNonTeamMemberType = trustedNonTeamMemberType;
            this.team = null;
        }

        /**
         * Set value for optional field.
         *
         * @param team  Details about this user's trusted team.
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
         * Builds an instance of {@link TrustedNonTeamMemberLogInfo} configured
         * with this builder's values
         *
         * @return new instance of {@link TrustedNonTeamMemberLogInfo}
         */
        public TrustedNonTeamMemberLogInfo build() {
            return new TrustedNonTeamMemberLogInfo(trustedNonTeamMemberType, accountId, displayName, email, team);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.trustedNonTeamMemberType,
            this.team
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
            TrustedNonTeamMemberLogInfo other = (TrustedNonTeamMemberLogInfo) obj;
            return ((this.trustedNonTeamMemberType == other.trustedNonTeamMemberType) || (this.trustedNonTeamMemberType.equals(other.trustedNonTeamMemberType)))
                && ((this.accountId == other.accountId) || (this.accountId != null && this.accountId.equals(other.accountId)))
                && ((this.displayName == other.displayName) || (this.displayName != null && this.displayName.equals(other.displayName)))
                && ((this.email == other.email) || (this.email != null && this.email.equals(other.email)))
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
    static class Serializer extends StructSerializer<TrustedNonTeamMemberLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TrustedNonTeamMemberLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("trusted_non_team_member", g);
            g.writeFieldName("trusted_non_team_member_type");
            TrustedNonTeamMemberType.Serializer.INSTANCE.serialize(value.trustedNonTeamMemberType, g);
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
            if (value.team != null) {
                g.writeFieldName("team");
                StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).serialize(value.team, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TrustedNonTeamMemberLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TrustedNonTeamMemberLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("trusted_non_team_member".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                TrustedNonTeamMemberType f_trustedNonTeamMemberType = null;
                String f_accountId = null;
                String f_displayName = null;
                String f_email = null;
                TeamLogInfo f_team = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("trusted_non_team_member_type".equals(field)) {
                        f_trustedNonTeamMemberType = TrustedNonTeamMemberType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("email".equals(field)) {
                        f_email = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("team".equals(field)) {
                        f_team = StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_trustedNonTeamMemberType == null) {
                    throw new JsonParseException(p, "Required field \"trusted_non_team_member_type\" missing.");
                }
                value = new TrustedNonTeamMemberLogInfo(f_trustedNonTeamMemberType, f_accountId, f_displayName, f_email, f_team);
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
