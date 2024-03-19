/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.common.RootInfo;
import com.dropbox.core.v2.userscommon.AccountType;

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
 * Detailed information about the current user's account.
 */
public class FullAccount extends Account {
    // struct users.FullAccount (users.stone)

    @Nullable
    protected final String country;
    @Nonnull
    protected final String locale;
    @Nonnull
    protected final String referralLink;
    @Nullable
    protected final FullTeam team;
    @Nullable
    protected final String teamMemberId;
    protected final boolean isPaired;
    @Nonnull
    protected final AccountType accountType;
    @Nonnull
    protected final RootInfo rootInfo;

    /**
     * Detailed information about the current user's account.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param email  The user's email address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their email. Must not
     *     be {@code null}.
     * @param emailVerified  Whether the user has verified their email address.
     * @param disabled  Whether the user has been disabled.
     * @param locale  The language that the user specified. Locale tags will be
     *     <a href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF
     *     language tags</a>. Must have length of at least 2 and not be {@code
     *     null}.
     * @param referralLink  The user's <a
     *     href="https://www.dropbox.com/referrals">referral link</a>. Must not
     *     be {@code null}.
     * @param isPaired  Whether the user has a personal and work account. If the
     *     current account is personal, then {@link FullAccount#getTeam} will
     *     always be {@code null}, but {@link FullAccount#getIsPaired} will
     *     indicate if a work account is linked.
     * @param accountType  What type of account this user has. Must not be
     *     {@code null}.
     * @param rootInfo  The root info for this account. Must not be {@code
     *     null}.
     * @param profilePhotoUrl  URL for the photo representing the user, if one
     *     is set.
     * @param country  The user's two-letter country code, if available. Country
     *     codes are based on <a
     *     href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>. Must
     *     have length of at least 2 and have length of at most 2.
     * @param team  If this account is a member of a team, information about
     *     that team.
     * @param teamMemberId  This account's unique team member id. This field
     *     will only be present if {@link FullAccount#getTeam} is present.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FullAccount(@Nonnull String accountId, @Nonnull Name name, @Nonnull String email, boolean emailVerified, boolean disabled, @Nonnull String locale, @Nonnull String referralLink, boolean isPaired, @Nonnull AccountType accountType, @Nonnull RootInfo rootInfo, @Nullable String profilePhotoUrl, @Nullable String country, @Nullable FullTeam team, @Nullable String teamMemberId) {
        super(accountId, name, email, emailVerified, disabled, profilePhotoUrl);
        if (country != null) {
            if (country.length() < 2) {
                throw new IllegalArgumentException("String 'country' is shorter than 2");
            }
            if (country.length() > 2) {
                throw new IllegalArgumentException("String 'country' is longer than 2");
            }
        }
        this.country = country;
        if (locale == null) {
            throw new IllegalArgumentException("Required value for 'locale' is null");
        }
        if (locale.length() < 2) {
            throw new IllegalArgumentException("String 'locale' is shorter than 2");
        }
        this.locale = locale;
        if (referralLink == null) {
            throw new IllegalArgumentException("Required value for 'referralLink' is null");
        }
        this.referralLink = referralLink;
        this.team = team;
        this.teamMemberId = teamMemberId;
        this.isPaired = isPaired;
        if (accountType == null) {
            throw new IllegalArgumentException("Required value for 'accountType' is null");
        }
        this.accountType = accountType;
        if (rootInfo == null) {
            throw new IllegalArgumentException("Required value for 'rootInfo' is null");
        }
        this.rootInfo = rootInfo;
    }

    /**
     * Detailed information about the current user's account.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param email  The user's email address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their email. Must not
     *     be {@code null}.
     * @param emailVerified  Whether the user has verified their email address.
     * @param disabled  Whether the user has been disabled.
     * @param locale  The language that the user specified. Locale tags will be
     *     <a href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF
     *     language tags</a>. Must have length of at least 2 and not be {@code
     *     null}.
     * @param referralLink  The user's <a
     *     href="https://www.dropbox.com/referrals">referral link</a>. Must not
     *     be {@code null}.
     * @param isPaired  Whether the user has a personal and work account. If the
     *     current account is personal, then {@link FullAccount#getTeam} will
     *     always be {@code null}, but {@link FullAccount#getIsPaired} will
     *     indicate if a work account is linked.
     * @param accountType  What type of account this user has. Must not be
     *     {@code null}.
     * @param rootInfo  The root info for this account. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FullAccount(@Nonnull String accountId, @Nonnull Name name, @Nonnull String email, boolean emailVerified, boolean disabled, @Nonnull String locale, @Nonnull String referralLink, boolean isPaired, @Nonnull AccountType accountType, @Nonnull RootInfo rootInfo) {
        this(accountId, name, email, emailVerified, disabled, locale, referralLink, isPaired, accountType, rootInfo, null, null, null, null);
    }

    /**
     * The user's unique Dropbox ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAccountId() {
        return accountId;
    }

    /**
     * Details of a user's name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Name getName() {
        return name;
    }

    /**
     * The user's email address. Do not rely on this without checking the {@link
     * Account#getEmailVerified} field. Even then, it's possible that the user
     * has since lost access to their email.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getEmail() {
        return email;
    }

    /**
     * Whether the user has verified their email address.
     *
     * @return value for this field.
     */
    public boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     * Whether the user has been disabled.
     *
     * @return value for this field.
     */
    public boolean getDisabled() {
        return disabled;
    }

    /**
     * The language that the user specified. Locale tags will be <a
     * href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF language
     * tags</a>.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getLocale() {
        return locale;
    }

    /**
     * The user's <a href="https://www.dropbox.com/referrals">referral link</a>.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getReferralLink() {
        return referralLink;
    }

    /**
     * Whether the user has a personal and work account. If the current account
     * is personal, then {@link FullAccount#getTeam} will always be {@code
     * null}, but {@link FullAccount#getIsPaired} will indicate if a work
     * account is linked.
     *
     * @return value for this field.
     */
    public boolean getIsPaired() {
        return isPaired;
    }

    /**
     * What type of account this user has.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * The root info for this account.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public RootInfo getRootInfo() {
        return rootInfo;
    }

    /**
     * URL for the photo representing the user, if one is set.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    /**
     * The user's two-letter country code, if available. Country codes are based
     * on <a href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCountry() {
        return country;
    }

    /**
     * If this account is a member of a team, information about that team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FullTeam getTeam() {
        return team;
    }

    /**
     * This account's unique team member id. This field will only be present if
     * {@link FullAccount#getTeam} is present.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param email  The user's email address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their email. Must not
     *     be {@code null}.
     * @param emailVerified  Whether the user has verified their email address.
     * @param disabled  Whether the user has been disabled.
     * @param locale  The language that the user specified. Locale tags will be
     *     <a href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF
     *     language tags</a>. Must have length of at least 2 and not be {@code
     *     null}.
     * @param referralLink  The user's <a
     *     href="https://www.dropbox.com/referrals">referral link</a>. Must not
     *     be {@code null}.
     * @param isPaired  Whether the user has a personal and work account. If the
     *     current account is personal, then {@link FullAccount#getTeam} will
     *     always be {@code null}, but {@link FullAccount#getIsPaired} will
     *     indicate if a work account is linked.
     * @param accountType  What type of account this user has. Must not be
     *     {@code null}.
     * @param rootInfo  The root info for this account. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String accountId, Name name, String email, boolean emailVerified, boolean disabled, String locale, String referralLink, boolean isPaired, AccountType accountType, RootInfo rootInfo) {
        return new Builder(accountId, name, email, emailVerified, disabled, locale, referralLink, isPaired, accountType, rootInfo);
    }

    /**
     * Builder for {@link FullAccount}.
     */
    public static class Builder {
        protected final String accountId;
        protected final Name name;
        protected final String email;
        protected final boolean emailVerified;
        protected final boolean disabled;
        protected final String locale;
        protected final String referralLink;
        protected final boolean isPaired;
        protected final AccountType accountType;
        protected final RootInfo rootInfo;

        protected String profilePhotoUrl;
        protected String country;
        protected FullTeam team;
        protected String teamMemberId;

        protected Builder(String accountId, Name name, String email, boolean emailVerified, boolean disabled, String locale, String referralLink, boolean isPaired, AccountType accountType, RootInfo rootInfo) {
            if (accountId == null) {
                throw new IllegalArgumentException("Required value for 'accountId' is null");
            }
            if (accountId.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
            this.accountId = accountId;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (email == null) {
                throw new IllegalArgumentException("Required value for 'email' is null");
            }
            this.email = email;
            this.emailVerified = emailVerified;
            this.disabled = disabled;
            if (locale == null) {
                throw new IllegalArgumentException("Required value for 'locale' is null");
            }
            if (locale.length() < 2) {
                throw new IllegalArgumentException("String 'locale' is shorter than 2");
            }
            this.locale = locale;
            if (referralLink == null) {
                throw new IllegalArgumentException("Required value for 'referralLink' is null");
            }
            this.referralLink = referralLink;
            this.isPaired = isPaired;
            if (accountType == null) {
                throw new IllegalArgumentException("Required value for 'accountType' is null");
            }
            this.accountType = accountType;
            if (rootInfo == null) {
                throw new IllegalArgumentException("Required value for 'rootInfo' is null");
            }
            this.rootInfo = rootInfo;
            this.profilePhotoUrl = null;
            this.country = null;
            this.team = null;
            this.teamMemberId = null;
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
            this.profilePhotoUrl = profilePhotoUrl;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param country  The user's two-letter country code, if available.
         *     Country codes are based on <a
         *     href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>.
         *     Must have length of at least 2 and have length of at most 2.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withCountry(String country) {
            if (country != null) {
                if (country.length() < 2) {
                    throw new IllegalArgumentException("String 'country' is shorter than 2");
                }
                if (country.length() > 2) {
                    throw new IllegalArgumentException("String 'country' is longer than 2");
                }
            }
            this.country = country;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param team  If this account is a member of a team, information about
         *     that team.
         *
         * @return this builder
         */
        public Builder withTeam(FullTeam team) {
            this.team = team;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param teamMemberId  This account's unique team member id. This field
         *     will only be present if {@link FullAccount#getTeam} is present.
         *
         * @return this builder
         */
        public Builder withTeamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Builds an instance of {@link FullAccount} configured with this
         * builder's values
         *
         * @return new instance of {@link FullAccount}
         */
        public FullAccount build() {
            return new FullAccount(accountId, name, email, emailVerified, disabled, locale, referralLink, isPaired, accountType, rootInfo, profilePhotoUrl, country, team, teamMemberId);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            country,
            locale,
            referralLink,
            team,
            teamMemberId,
            isPaired,
            accountType,
            rootInfo
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
            FullAccount other = (FullAccount) obj;
            return ((this.accountId == other.accountId) || (this.accountId.equals(other.accountId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && (this.disabled == other.disabled)
                && ((this.locale == other.locale) || (this.locale.equals(other.locale)))
                && ((this.referralLink == other.referralLink) || (this.referralLink.equals(other.referralLink)))
                && (this.isPaired == other.isPaired)
                && ((this.accountType == other.accountType) || (this.accountType.equals(other.accountType)))
                && ((this.rootInfo == other.rootInfo) || (this.rootInfo.equals(other.rootInfo)))
                && ((this.profilePhotoUrl == other.profilePhotoUrl) || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(other.profilePhotoUrl)))
                && ((this.country == other.country) || (this.country != null && this.country.equals(other.country)))
                && ((this.team == other.team) || (this.team != null && this.team.equals(other.team)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId != null && this.teamMemberId.equals(other.teamMemberId)))
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
    static class Serializer extends StructSerializer<FullAccount> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FullAccount value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("account_id");
            StoneSerializers.string().serialize(value.accountId, g);
            g.writeFieldName("name");
            Name.Serializer.INSTANCE.serialize(value.name, g);
            g.writeFieldName("email");
            StoneSerializers.string().serialize(value.email, g);
            g.writeFieldName("email_verified");
            StoneSerializers.boolean_().serialize(value.emailVerified, g);
            g.writeFieldName("disabled");
            StoneSerializers.boolean_().serialize(value.disabled, g);
            g.writeFieldName("locale");
            StoneSerializers.string().serialize(value.locale, g);
            g.writeFieldName("referral_link");
            StoneSerializers.string().serialize(value.referralLink, g);
            g.writeFieldName("is_paired");
            StoneSerializers.boolean_().serialize(value.isPaired, g);
            g.writeFieldName("account_type");
            AccountType.Serializer.INSTANCE.serialize(value.accountType, g);
            g.writeFieldName("root_info");
            RootInfo.Serializer.INSTANCE.serialize(value.rootInfo, g);
            if (value.profilePhotoUrl != null) {
                g.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.profilePhotoUrl, g);
            }
            if (value.country != null) {
                g.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.country, g);
            }
            if (value.team != null) {
                g.writeFieldName("team");
                StoneSerializers.nullableStruct(FullTeam.Serializer.INSTANCE).serialize(value.team, g);
            }
            if (value.teamMemberId != null) {
                g.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.teamMemberId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FullAccount deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FullAccount value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_accountId = null;
                Name f_name = null;
                String f_email = null;
                Boolean f_emailVerified = null;
                Boolean f_disabled = null;
                String f_locale = null;
                String f_referralLink = null;
                Boolean f_isPaired = null;
                AccountType f_accountType = null;
                RootInfo f_rootInfo = null;
                String f_profilePhotoUrl = null;
                String f_country = null;
                FullTeam f_team = null;
                String f_teamMemberId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = Name.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("email".equals(field)) {
                        f_email = StoneSerializers.string().deserialize(p);
                    }
                    else if ("email_verified".equals(field)) {
                        f_emailVerified = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("disabled".equals(field)) {
                        f_disabled = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("locale".equals(field)) {
                        f_locale = StoneSerializers.string().deserialize(p);
                    }
                    else if ("referral_link".equals(field)) {
                        f_referralLink = StoneSerializers.string().deserialize(p);
                    }
                    else if ("is_paired".equals(field)) {
                        f_isPaired = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("account_type".equals(field)) {
                        f_accountType = AccountType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("root_info".equals(field)) {
                        f_rootInfo = RootInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("profile_photo_url".equals(field)) {
                        f_profilePhotoUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("country".equals(field)) {
                        f_country = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("team".equals(field)) {
                        f_team = StoneSerializers.nullableStruct(FullTeam.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accountId == null) {
                    throw new JsonParseException(p, "Required field \"account_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_email == null) {
                    throw new JsonParseException(p, "Required field \"email\" missing.");
                }
                if (f_emailVerified == null) {
                    throw new JsonParseException(p, "Required field \"email_verified\" missing.");
                }
                if (f_disabled == null) {
                    throw new JsonParseException(p, "Required field \"disabled\" missing.");
                }
                if (f_locale == null) {
                    throw new JsonParseException(p, "Required field \"locale\" missing.");
                }
                if (f_referralLink == null) {
                    throw new JsonParseException(p, "Required field \"referral_link\" missing.");
                }
                if (f_isPaired == null) {
                    throw new JsonParseException(p, "Required field \"is_paired\" missing.");
                }
                if (f_accountType == null) {
                    throw new JsonParseException(p, "Required field \"account_type\" missing.");
                }
                if (f_rootInfo == null) {
                    throw new JsonParseException(p, "Required field \"root_info\" missing.");
                }
                value = new FullAccount(f_accountId, f_name, f_email, f_emailVerified, f_disabled, f_locale, f_referralLink, f_isPaired, f_accountType, f_rootInfo, f_profilePhotoUrl, f_country, f_team, f_teamMemberId);
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
