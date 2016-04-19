/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

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
 * Detailed information about the current user's account.
 */
@JsonSerialize(using=FullAccount.Serializer.class)
@JsonDeserialize(using=FullAccount.Deserializer.class)
public class FullAccount extends Account {
    // struct FullAccount

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String country;
    protected final String locale;
    protected final String referralLink;
    protected final Team team;
    protected final String teamMemberId;
    protected final boolean isPaired;
    protected final AccountType accountType;

    /**
     * Detailed information about the current user's account.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param email  The user's e-mail address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their e-mail. Must
     *     not be {@code null}.
     * @param emailVerified  Whether the user has verified their e-mail address.
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
    public FullAccount(String accountId, Name name, String email, boolean emailVerified, String locale, String referralLink, boolean isPaired, AccountType accountType, String profilePhotoUrl, String country, Team team, String teamMemberId) {
        super(accountId, name, email, emailVerified, profilePhotoUrl);
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
    }

    /**
     * Detailed information about the current user's account.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param email  The user's e-mail address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their e-mail. Must
     *     not be {@code null}.
     * @param emailVerified  Whether the user has verified their e-mail address.
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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FullAccount(String accountId, Name name, String email, boolean emailVerified, String locale, String referralLink, boolean isPaired, AccountType accountType) {
        this(accountId, name, email, emailVerified, locale, referralLink, isPaired, accountType, null, null, null, null);
    }

    /**
     * The user's two-letter country code, if available. Country codes are based
     * on <a href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCountry() {
        return country;
    }

    /**
     * The language that the user specified. Locale tags will be <a
     * href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF language
     * tags</a>.
     *
     * @return value for this field, never {@code null}.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * The user's <a href="https://www.dropbox.com/referrals">referral link</a>.
     *
     * @return value for this field, never {@code null}.
     */
    public String getReferralLink() {
        return referralLink;
    }

    /**
     * If this account is a member of a team, information about that team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * This account's unique team member id. This field will only be present if
     * {@link FullAccount#getTeam} is present.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getTeamMemberId() {
        return teamMemberId;
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
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param email  The user's e-mail address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their e-mail. Must
     *     not be {@code null}.
     * @param emailVerified  Whether the user has verified their e-mail address.
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
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String accountId, Name name, String email, boolean emailVerified, String locale, String referralLink, boolean isPaired, AccountType accountType) {
        return new Builder(accountId, name, email, emailVerified, locale, referralLink, isPaired, accountType);
    }

    /**
     * Builder for {@link FullAccount}.
     */
    public static class Builder {
        protected final String accountId;
        protected final Name name;
        protected final String email;
        protected final boolean emailVerified;
        protected final String locale;
        protected final String referralLink;
        protected final boolean isPaired;
        protected final AccountType accountType;

        protected String profilePhotoUrl;
        protected String country;
        protected Team team;
        protected String teamMemberId;

        protected Builder(String accountId, Name name, String email, boolean emailVerified, String locale, String referralLink, boolean isPaired, AccountType accountType) {
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
        public Builder withTeam(Team team) {
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
            return new FullAccount(accountId, name, email, emailVerified, locale, referralLink, isPaired, accountType, profilePhotoUrl, country, team, teamMemberId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            country,
            locale,
            referralLink,
            team,
            teamMemberId,
            isPaired,
            accountType
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
            FullAccount other = (FullAccount) obj;
            return ((this.accountId == other.accountId) || (this.accountId.equals(other.accountId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && ((this.locale == other.locale) || (this.locale.equals(other.locale)))
                && ((this.referralLink == other.referralLink) || (this.referralLink.equals(other.referralLink)))
                && (this.isPaired == other.isPaired)
                && ((this.accountType == other.accountType) || (this.accountType.equals(other.accountType)))
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

    static final class Serializer extends StructJsonSerializer<FullAccount> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FullAccount.class);
        }

        public Serializer(boolean unwrapping) {
            super(FullAccount.class, unwrapping);
        }

        @Override
        protected JsonSerializer<FullAccount> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(FullAccount value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("account_id", value.accountId);
            g.writeObjectField("name", value.name);
            g.writeObjectField("email", value.email);
            g.writeObjectField("email_verified", value.emailVerified);
            g.writeObjectField("locale", value.locale);
            g.writeObjectField("referral_link", value.referralLink);
            g.writeObjectField("is_paired", value.isPaired);
            g.writeObjectField("account_type", value.accountType);
            if (value.profilePhotoUrl != null) {
                g.writeObjectField("profile_photo_url", value.profilePhotoUrl);
            }
            if (value.country != null) {
                g.writeObjectField("country", value.country);
            }
            if (value.team != null) {
                g.writeObjectField("team", value.team);
            }
            if (value.teamMemberId != null) {
                g.writeObjectField("team_member_id", value.teamMemberId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<FullAccount> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FullAccount.class);
        }

        public Deserializer(boolean unwrapping) {
            super(FullAccount.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<FullAccount> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public FullAccount deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String accountId = null;
            Name name = null;
            String email = null;
            Boolean emailVerified = null;
            String locale = null;
            String referralLink = null;
            Boolean isPaired = null;
            AccountType accountType = null;
            String profilePhotoUrl = null;
            String country = null;
            Team team = null;
            String teamMemberId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("account_id".equals(_field)) {
                    accountId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("name".equals(_field)) {
                    name = _p.readValueAs(Name.class);
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
                else if ("locale".equals(_field)) {
                    locale = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("referral_link".equals(_field)) {
                    referralLink = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("is_paired".equals(_field)) {
                    isPaired = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("account_type".equals(_field)) {
                    accountType = _p.readValueAs(AccountType.class);
                    _p.nextToken();
                }
                else if ("profile_photo_url".equals(_field)) {
                    profilePhotoUrl = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("country".equals(_field)) {
                    country = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("team".equals(_field)) {
                    team = _p.readValueAs(Team.class);
                    _p.nextToken();
                }
                else if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (accountId == null) {
                throw new JsonParseException(_p, "Required field \"account_id\" is missing.");
            }
            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (email == null) {
                throw new JsonParseException(_p, "Required field \"email\" is missing.");
            }
            if (emailVerified == null) {
                throw new JsonParseException(_p, "Required field \"email_verified\" is missing.");
            }
            if (locale == null) {
                throw new JsonParseException(_p, "Required field \"locale\" is missing.");
            }
            if (referralLink == null) {
                throw new JsonParseException(_p, "Required field \"referral_link\" is missing.");
            }
            if (isPaired == null) {
                throw new JsonParseException(_p, "Required field \"is_paired\" is missing.");
            }
            if (accountType == null) {
                throw new JsonParseException(_p, "Required field \"account_type\" is missing.");
            }

            return new FullAccount(accountId, name, email, emailVerified, locale, referralLink, isPaired, accountType, profilePhotoUrl, country, team, teamMemberId);
        }
    }
}
