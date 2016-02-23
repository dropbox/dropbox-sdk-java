/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Detailed information about the current user's account.
 */
public class FullAccount extends Account {
    // struct FullAccount

    private final String email;
    private final boolean emailVerified;
    private final String country;
    private final String locale;
    private final String referralLink;
    private final Team team;
    private final boolean isPaired;
    private final AccountType accountType;

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
     *     checking the {@link FullAccount#getEmailVerified} field. Even then,
     *     it's possible that the user has since lost access to their e-mail.
     *     Must not be {@code null}.
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
     * @param country  The user's two-letter country code, if available. Country
     *     codes are based on <a
     *     href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>. Must
     *     have length of at least 2 and have length of at most 2.
     * @param team  If this account is a member of a team, information about
     *     that team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FullAccount(String accountId, Name name, String email, boolean emailVerified, String locale, String referralLink, boolean isPaired, AccountType accountType, String country, Team team) {
        super(accountId, name);
        if (email == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        this.email = email;
        this.emailVerified = emailVerified;
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
     *     checking the {@link FullAccount#getEmailVerified} field. Even then,
     *     it's possible that the user has since lost access to their e-mail.
     *     Must not be {@code null}.
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
        this(accountId, name, email, emailVerified, locale, referralLink, isPaired, accountType, null, null);
    }

    /**
     * The user's e-mail address. Do not rely on this without checking the
     * {@link FullAccount#getEmailVerified} field. Even then, it's possible that
     * the user has since lost access to their e-mail.
     *
     * @return value for this field, never {@code null}.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Whether the user has verified their e-mail address.
     *
     * @return value for this field.
     */
    public boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     * The user's two-letter country code, if available. Country codes are based
     * on &lt;a href="http://en.wikipedia.org/wiki/ISO_3166-1"&gt;ISO
     * 3166-1&lt;/a&gt;.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCountry() {
        return country;
    }

    /**
     * The language that the user specified. Locale tags will be &lt;a
     * href="http://en.wikipedia.org/wiki/IETF_language_tag"&gt;IETF language
     * tags&lt;/a&gt;.
     *
     * @return value for this field, never {@code null}.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * The user's &lt;a href="https://www.dropbox.com/referrals"&gt;referral
     * link&lt;/a&gt;.
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
     *     checking the {@link FullAccount#getEmailVerified} field. Even then,
     *     it's possible that the user has since lost access to their e-mail.
     *     Must not be {@code null}.
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

        protected String country;
        protected Team team;

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
            this.country = null;
            this.team = null;
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
         * Builds an instance of {@link FullAccount} configured with this
         * builder's values
         *
         * @return new instance of {@link FullAccount}
         */
        public FullAccount build() {
            return new FullAccount(accountId, name, email, emailVerified, locale, referralLink, isPaired, accountType, country, team);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            email,
            emailVerified,
            country,
            locale,
            referralLink,
            team,
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
            return ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && ((this.country == other.country) || (this.country != null && this.country.equals(other.country)))
                && ((this.locale == other.locale) || (this.locale.equals(other.locale)))
                && ((this.referralLink == other.referralLink) || (this.referralLink.equals(other.referralLink)))
                && ((this.team == other.team) || (this.team != null && this.team.equals(other.team)))
                && (this.isPaired == other.isPaired)
                && ((this.accountType == other.accountType) || (this.accountType.equals(other.accountType)))
                && ((this.getAccountId() == other.getAccountId()) || (this.getAccountId().equals(other.getAccountId())))
                && ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static FullAccount fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FullAccount> _JSON_WRITER = new JsonWriter<FullAccount>() {
        public final void write(FullAccount x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            Account._JSON_WRITER.writeFields(x, g);
            FullAccount._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FullAccount x, JsonGenerator g) throws IOException {
            g.writeFieldName("email");
            g.writeString(x.email);
            g.writeFieldName("email_verified");
            g.writeBoolean(x.emailVerified);
            if (x.country != null) {
                g.writeFieldName("country");
                g.writeString(x.country);
            }
            g.writeFieldName("locale");
            g.writeString(x.locale);
            g.writeFieldName("referral_link");
            g.writeString(x.referralLink);
            if (x.team != null) {
                g.writeFieldName("team");
                Team._JSON_WRITER.write(x.team, g);
            }
            g.writeFieldName("is_paired");
            g.writeBoolean(x.isPaired);
            g.writeFieldName("account_type");
            AccountType._JSON_WRITER.write(x.accountType, g);
        }
    };

    public static final JsonReader<FullAccount> _JSON_READER = new JsonReader<FullAccount>() {
        public final FullAccount read(JsonParser parser) throws IOException, JsonReadException {
            FullAccount result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FullAccount readFields(JsonParser parser) throws IOException, JsonReadException {
            String accountId = null;
            Name name = null;
            String email = null;
            Boolean emailVerified = null;
            String locale = null;
            String referralLink = null;
            Boolean isPaired = null;
            AccountType accountType = null;
            String country = null;
            Team team = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("account_id".equals(fieldName)) {
                    accountId = JsonReader.StringReader
                        .readField(parser, "account_id", accountId);
                }
                else if ("name".equals(fieldName)) {
                    name = Name._JSON_READER
                        .readField(parser, "name", name);
                }
                else if ("email".equals(fieldName)) {
                    email = JsonReader.StringReader
                        .readField(parser, "email", email);
                }
                else if ("email_verified".equals(fieldName)) {
                    emailVerified = JsonReader.BooleanReader
                        .readField(parser, "email_verified", emailVerified);
                }
                else if ("locale".equals(fieldName)) {
                    locale = JsonReader.StringReader
                        .readField(parser, "locale", locale);
                }
                else if ("referral_link".equals(fieldName)) {
                    referralLink = JsonReader.StringReader
                        .readField(parser, "referral_link", referralLink);
                }
                else if ("is_paired".equals(fieldName)) {
                    isPaired = JsonReader.BooleanReader
                        .readField(parser, "is_paired", isPaired);
                }
                else if ("account_type".equals(fieldName)) {
                    accountType = AccountType._JSON_READER
                        .readField(parser, "account_type", accountType);
                }
                else if ("country".equals(fieldName)) {
                    country = JsonReader.StringReader
                        .readField(parser, "country", country);
                }
                else if ("team".equals(fieldName)) {
                    team = Team._JSON_READER
                        .readField(parser, "team", team);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (accountId == null) {
                throw new JsonReadException("Required field \"account_id\" is missing.", parser.getTokenLocation());
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (email == null) {
                throw new JsonReadException("Required field \"email\" is missing.", parser.getTokenLocation());
            }
            if (emailVerified == null) {
                throw new JsonReadException("Required field \"email_verified\" is missing.", parser.getTokenLocation());
            }
            if (locale == null) {
                throw new JsonReadException("Required field \"locale\" is missing.", parser.getTokenLocation());
            }
            if (referralLink == null) {
                throw new JsonReadException("Required field \"referral_link\" is missing.", parser.getTokenLocation());
            }
            if (isPaired == null) {
                throw new JsonReadException("Required field \"is_paired\" is missing.", parser.getTokenLocation());
            }
            if (accountType == null) {
                throw new JsonReadException("Required field \"account_type\" is missing.", parser.getTokenLocation());
            }
            return new FullAccount(accountId, name, email, emailVerified, locale, referralLink, isPaired, accountType, country, team);
        }
    };
}
