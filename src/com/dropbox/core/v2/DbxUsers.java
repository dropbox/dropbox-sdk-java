/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2;

import java.io.IOException;
import java.util.regex.Pattern;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.dropbox.core.DbxApiException;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonWriter;

/**
 * Classes and routes in namespace "users".
 */
public final class DbxUsers {
    // namespace users

    private final DbxRawClientV2 client;

    DbxUsers(DbxRawClientV2 client) {
        this.client = client;
    }

    public static class GetAccountArg {
        // struct GetAccountArg
        /**
         * A user's account identifier.
         */
        public final String accountId;

        public GetAccountArg(String accountId) {
            this.accountId = accountId;
            if (accountId == null) {
                throw new RuntimeException("Required value for 'accountId' is null");
            }
            if (accountId.length() < 40) {
                throw new RuntimeException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new RuntimeException("String 'accountId' is longer than 40");
            }
        }
        static final JsonWriter<GetAccountArg> _writer = new JsonWriter<GetAccountArg>()
        {
            public final void write(GetAccountArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GetAccountArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GetAccountArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("account_id", x.accountId);
            }
        };

        public static final JsonReader<GetAccountArg> _reader = new JsonReader<GetAccountArg>() {

            public final GetAccountArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GetAccountArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GetAccountArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String accountId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("account_id".equals(fieldName)) {
                        accountId = JsonReader.StringReader
                            .readField(parser, "account_id", accountId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accountId == null) {
                    throw new JsonReadException("Required field \"account_id\" is missing.", parser.getTokenLocation());
                }
                return new GetAccountArg(accountId);
            }
        };

        public String toString() {
            return "GetAccountArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetAccountArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetAccountArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum GetAccountError {
        // union GetAccountError
        /**
         * The specified {@code getAccountArg.accountId} does not exist.
         */
        noAccount,
        unknown;  // *catch_all

        static final JsonWriter<GetAccountError> _writer = new JsonWriter<GetAccountError>()
        {
            public void write(GetAccountError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case noAccount:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_account");
                        g.writeEndObject();
                        break;
                    case unknown:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unknown");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<GetAccountError> _reader = new JsonReader<GetAccountError>()
        {
            public final GetAccountError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, unknown);
            }
        };
        private static final java.util.HashMap<String,GetAccountError> _values;
        static {
            _values = new java.util.HashMap<String,GetAccountError>();
            _values.put("no_account", noAccount);
            _values.put("unknown", unknown);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetAccountError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * What type of account this user has.
     */
    public enum AccountType {
        // union AccountType
        /**
         * The basic account type.
         */
        basic,
        /**
         * The Dropbox Pro account type.
         */
        pro,
        /**
         * The Dropbox for Business account type.
         */
        business;

        static final JsonWriter<AccountType> _writer = new JsonWriter<AccountType>()
        {
            public void write(AccountType x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case basic:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("basic");
                        g.writeEndObject();
                        break;
                    case pro:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("pro");
                        g.writeEndObject();
                        break;
                    case business:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("business");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<AccountType> _reader = new JsonReader<AccountType>()
        {
            public final AccountType read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,AccountType> _values;
        static {
            _values = new java.util.HashMap<String,AccountType>();
            _values.put("basic", basic);
            _values.put("pro", pro);
            _values.put("business", business);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static AccountType fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The amount of detail revealed about an account depends on the user being
     * queried and the user making the query.
     */
    public static class Account {
        // struct Account
        /**
         * The user's unique Dropbox ID.
         */
        public final String accountId;
        /**
         * Details of a user's name.
         */
        public final Name name;

        public Account(String accountId, Name name) {
            this.accountId = accountId;
            if (accountId == null) {
                throw new RuntimeException("Required value for 'accountId' is null");
            }
            if (accountId.length() < 40) {
                throw new RuntimeException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new RuntimeException("String 'accountId' is longer than 40");
            }
            this.name = name;
            if (name == null) {
                throw new RuntimeException("Required value for 'name' is null");
            }
        }
        static final JsonWriter<Account> _writer = new JsonWriter<Account>()
        {
            public final void write(Account x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                Account._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(Account x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("account_id", x.accountId);
                g.writeFieldName("name");
                Name._writer.write(x.name, g);
            }
        };

        public static final JsonReader<Account> _reader = new JsonReader<Account>() {

            public final Account read(JsonParser parser)
                throws IOException, JsonReadException
            {
                Account result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final Account readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String accountId = null;
                Name name = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("account_id".equals(fieldName)) {
                        accountId = JsonReader.StringReader
                            .readField(parser, "account_id", accountId);
                    }
                    else if ("name".equals(fieldName)) {
                        name = Name._reader
                            .readField(parser, "name", name);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accountId == null) {
                    throw new JsonReadException("Required field \"account_id\" is missing.", parser.getTokenLocation());
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                return new Account(accountId, name);
            }
        };

        public String toString() {
            return "Account." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "Account." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static Account fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Basic information about any account.
     */
    public static class BasicAccount extends Account  {
        // struct BasicAccount
        /**
         * Whether this user is a teammate of the current user. If this account
         * is the current user's account, then this will be {@literal true}.
         */
        public final boolean isTeammate;

        public BasicAccount(String accountId, Name name, boolean isTeammate) {
            super(accountId, name);
            this.isTeammate = isTeammate;
        }
        static final JsonWriter<BasicAccount> _writer = new JsonWriter<BasicAccount>()
        {
            public final void write(BasicAccount x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                Account._writer.writeFields(x, g);
                BasicAccount._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(BasicAccount x, JsonGenerator g)
             throws IOException
            {
                g.writeBooleanField("is_teammate", x.isTeammate);
            }
        };

        public static final JsonReader<BasicAccount> _reader = new JsonReader<BasicAccount>() {

            public final BasicAccount read(JsonParser parser)
                throws IOException, JsonReadException
            {
                BasicAccount result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final BasicAccount readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String accountId = null;
                Name name = null;
                Boolean isTeammate = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("account_id".equals(fieldName)) {
                        accountId = JsonReader.StringReader
                            .readField(parser, "account_id", accountId);
                    }
                    else if ("name".equals(fieldName)) {
                        name = Name._reader
                            .readField(parser, "name", name);
                    }
                    else if ("is_teammate".equals(fieldName)) {
                        isTeammate = JsonReader.BooleanReader
                            .readField(parser, "is_teammate", isTeammate);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accountId == null) {
                    throw new JsonReadException("Required field \"account_id\" is missing.", parser.getTokenLocation());
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (isTeammate == null) {
                    throw new JsonReadException("Required field \"is_teammate\" is missing.", parser.getTokenLocation());
                }
                return new BasicAccount(accountId, name, isTeammate);
            }
        };

        public String toString() {
            return "BasicAccount." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "BasicAccount." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static BasicAccount fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Detailed information about the current user's account.
     */
    public static class FullAccount extends Account  {
        // struct FullAccount
        /**
         * The user's e-mail address.
         */
        public final String email;
        /**
         * The user's two-letter country code, if available. Country codes are
         * based on <a href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO
         * 3166-1</a>.
         */
        public final String country;
        /**
         * The language that the user specified. Locale tags will be <a
         * href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF language
         * tags</a>.
         */
        public final String locale;
        /**
         * The user's <a href="https://www.dropbox.com/referrals">referral
         * link</a>.
         */
        public final String referralLink;
        /**
         * If this account is a member of a team, information about that team.
         */
        public final Team team;
        /**
         * Whether the user has a personal and work account. If the current
         * account is personal, then {@code team} will always be {@literal
         * null}, but {@code isPaired} will indicate if a work account is
         * linked.
         */
        public final boolean isPaired;
        /**
         * What type of account this user has.
         */
        public final AccountType accountType;

        public FullAccount(String accountId, Name name, String email, String locale, String referralLink, boolean isPaired, AccountType accountType, String country, Team team) {
            super(accountId, name);
            this.email = email;
            if (email == null) {
                throw new RuntimeException("Required value for 'email' is null");
            }
            this.country = country;
            if (country != null) {
                if (country.length() < 2) {
                    throw new RuntimeException("String 'country' is shorter than 2");
                }
                if (country.length() > 2) {
                    throw new RuntimeException("String 'country' is longer than 2");
                }
            }
            this.locale = locale;
            if (locale == null) {
                throw new RuntimeException("Required value for 'locale' is null");
            }
            if (locale.length() < 2) {
                throw new RuntimeException("String 'locale' is shorter than 2");
            }
            this.referralLink = referralLink;
            if (referralLink == null) {
                throw new RuntimeException("Required value for 'referralLink' is null");
            }
            this.team = team;
            if (team != null) {
            }
            this.isPaired = isPaired;
            this.accountType = accountType;
            if (accountType == null) {
                throw new RuntimeException("Required value for 'accountType' is null");
            }
        }
        static final JsonWriter<FullAccount> _writer = new JsonWriter<FullAccount>()
        {
            public final void write(FullAccount x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                Account._writer.writeFields(x, g);
                FullAccount._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FullAccount x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("email", x.email);
                if (x.country != null) {
                    g.writeFieldName("country");
                    g.writeString(x.country);
                }
                g.writeStringField("locale", x.locale);
                g.writeStringField("referral_link", x.referralLink);
                if (x.team != null) {
                    g.writeFieldName("team");
                    Team._writer.write(x.team, g);
                }
                g.writeBooleanField("is_paired", x.isPaired);
                g.writeFieldName("account_type");
                AccountType._writer.write(x.accountType, g);
            }
        };

        public static final JsonReader<FullAccount> _reader = new JsonReader<FullAccount>() {

            public final FullAccount read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FullAccount result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FullAccount readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String accountId = null;
                Name name = null;
                String email = null;
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
                        name = Name._reader
                            .readField(parser, "name", name);
                    }
                    else if ("email".equals(fieldName)) {
                        email = JsonReader.StringReader
                            .readField(parser, "email", email);
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
                        accountType = AccountType._reader
                            .readField(parser, "account_type", accountType);
                    }
                    else if ("country".equals(fieldName)) {
                        country = JsonReader.StringReader
                            .readField(parser, "country", country);
                    }
                    else if ("team".equals(fieldName)) {
                        team = Team._reader
                            .readField(parser, "team", team);
                    }
                    else { JsonReader.skipValue(parser); }
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
                return new FullAccount(accountId, name, email, locale, referralLink, isPaired, accountType, country, team);
            }
        };

        public String toString() {
            return "FullAccount." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "FullAccount." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static FullAccount fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Information about a team.
     */
    public static class Team {
        // struct Team
        /**
         * The team's unique ID.
         */
        public final String id;
        /**
         * The name of the team.
         */
        public final String name;

        public Team(String id, String name) {
            this.id = id;
            if (id == null) {
                throw new RuntimeException("Required value for 'id' is null");
            }
            this.name = name;
            if (name == null) {
                throw new RuntimeException("Required value for 'name' is null");
            }
        }
        static final JsonWriter<Team> _writer = new JsonWriter<Team>()
        {
            public final void write(Team x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                Team._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(Team x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("id", x.id);
                g.writeStringField("name", x.name);
            }
        };

        public static final JsonReader<Team> _reader = new JsonReader<Team>() {

            public final Team read(JsonParser parser)
                throws IOException, JsonReadException
            {
                Team result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final Team readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String id = null;
                String name = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (id == null) {
                    throw new JsonReadException("Required field \"id\" is missing.", parser.getTokenLocation());
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                return new Team(id, name);
            }
        };

        public String toString() {
            return "Team." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "Team." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static Team fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Representations for a person's name to assist with internationalization.
     */
    public static class Name {
        // struct Name
        /**
         * Also known as a first name.
         */
        public final String givenName;
        /**
         * Also known as a last name or family name.
         */
        public final String surname;
        /**
         * Locale-dependent name. In the US, a person's familiar name is their
         * {@code givenName}, but elsewhere, it could be any combination of a
         * person's {@code givenName} and {@code surname}.
         */
        public final String familiarName;
        /**
         * A name that can be used directly to represent the name of a user's
         * Dropbox account.
         */
        public final String displayName;

        public Name(String givenName, String surname, String familiarName, String displayName) {
            this.givenName = givenName;
            if (givenName == null) {
                throw new RuntimeException("Required value for 'givenName' is null");
            }
            this.surname = surname;
            if (surname == null) {
                throw new RuntimeException("Required value for 'surname' is null");
            }
            this.familiarName = familiarName;
            if (familiarName == null) {
                throw new RuntimeException("Required value for 'familiarName' is null");
            }
            this.displayName = displayName;
            if (displayName == null) {
                throw new RuntimeException("Required value for 'displayName' is null");
            }
        }
        static final JsonWriter<Name> _writer = new JsonWriter<Name>()
        {
            public final void write(Name x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                Name._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(Name x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("given_name", x.givenName);
                g.writeStringField("surname", x.surname);
                g.writeStringField("familiar_name", x.familiarName);
                g.writeStringField("display_name", x.displayName);
            }
        };

        public static final JsonReader<Name> _reader = new JsonReader<Name>() {

            public final Name read(JsonParser parser)
                throws IOException, JsonReadException
            {
                Name result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final Name readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String givenName = null;
                String surname = null;
                String familiarName = null;
                String displayName = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("given_name".equals(fieldName)) {
                        givenName = JsonReader.StringReader
                            .readField(parser, "given_name", givenName);
                    }
                    else if ("surname".equals(fieldName)) {
                        surname = JsonReader.StringReader
                            .readField(parser, "surname", surname);
                    }
                    else if ("familiar_name".equals(fieldName)) {
                        familiarName = JsonReader.StringReader
                            .readField(parser, "familiar_name", familiarName);
                    }
                    else if ("display_name".equals(fieldName)) {
                        displayName = JsonReader.StringReader
                            .readField(parser, "display_name", displayName);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (givenName == null) {
                    throw new JsonReadException("Required field \"given_name\" is missing.", parser.getTokenLocation());
                }
                if (surname == null) {
                    throw new JsonReadException("Required field \"surname\" is missing.", parser.getTokenLocation());
                }
                if (familiarName == null) {
                    throw new JsonReadException("Required field \"familiar_name\" is missing.", parser.getTokenLocation());
                }
                if (displayName == null) {
                    throw new JsonReadException("Required field \"display_name\" is missing.", parser.getTokenLocation());
                }
                return new Name(givenName, surname, familiarName, displayName);
            }
        };

        public String toString() {
            return "Name." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "Name." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static Name fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Information about a user's space usage and quota.
     */
    public static class SpaceUsage {
        // struct SpaceUsage
        /**
         * The user's total space usage (bytes).
         */
        public final long used;
        /**
         * The user's space allocation.
         */
        public final SpaceAllocation allocation;

        public SpaceUsage(long used, SpaceAllocation allocation) {
            this.used = used;
            this.allocation = allocation;
            if (allocation == null) {
                throw new RuntimeException("Required value for 'allocation' is null");
            }
        }
        static final JsonWriter<SpaceUsage> _writer = new JsonWriter<SpaceUsage>()
        {
            public final void write(SpaceUsage x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SpaceUsage._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SpaceUsage x, JsonGenerator g)
             throws IOException
            {
                g.writeNumberField("used", x.used);
                g.writeFieldName("allocation");
                SpaceAllocation._writer.write(x.allocation, g);
            }
        };

        public static final JsonReader<SpaceUsage> _reader = new JsonReader<SpaceUsage>() {

            public final SpaceUsage read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SpaceUsage result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SpaceUsage readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Long used = null;
                SpaceAllocation allocation = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("used".equals(fieldName)) {
                        used = JsonReader.UInt64Reader
                            .readField(parser, "used", used);
                    }
                    else if ("allocation".equals(fieldName)) {
                        allocation = SpaceAllocation._reader
                            .readField(parser, "allocation", allocation);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (used == null) {
                    throw new JsonReadException("Required field \"used\" is missing.", parser.getTokenLocation());
                }
                if (allocation == null) {
                    throw new JsonReadException("Required field \"allocation\" is missing.", parser.getTokenLocation());
                }
                return new SpaceUsage(used, allocation);
            }
        };

        public String toString() {
            return "SpaceUsage." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SpaceUsage." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SpaceUsage fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Space is allocated differently based on the type of account.
     */

    public static final class SpaceAllocation {
        // union SpaceAllocation

        /**
         * The discriminating tag type for {@link SpaceAllocation}.
         */
        public enum Tag {
            individual,  // IndividualSpaceAllocation
            team,  // TeamSpaceAllocation
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final IndividualSpaceAllocation individualValue;
        private SpaceAllocation(Tag t, IndividualSpaceAllocation v) {
            tag = t;
            individualValue = v;
            teamValue = null;
            validate();
        }
        /**
         * The user's space allocation applies only to their individual account.
         */
        public static SpaceAllocation individual(IndividualSpaceAllocation v) {
            return new SpaceAllocation(Tag.individual, v);
        }
        public IndividualSpaceAllocation getIndividual() {
            if (tag != Tag.individual) {
                throw new RuntimeException("getIndividual() requires tag==individual, actual tag=="+tag);
            }
            return individualValue;
        }

        private final TeamSpaceAllocation teamValue;
        private SpaceAllocation(Tag t, TeamSpaceAllocation v) {
            tag = t;
            individualValue = null;
            teamValue = v;
            validate();
        }
        /**
         * The user shares space with other members of their team.
         */
        public static SpaceAllocation team(TeamSpaceAllocation v) {
            return new SpaceAllocation(Tag.team, v);
        }
        public TeamSpaceAllocation getTeam() {
            if (tag != Tag.team) {
                throw new RuntimeException("getTeam() requires tag==team, actual tag=="+tag);
            }
            return teamValue;
        }

        public static final SpaceAllocation other = new SpaceAllocation(Tag.other);

        private SpaceAllocation(Tag t) {
            tag = t;
            individualValue = null;
            teamValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case individual:
                    if (this.individualValue == null) {
                        throw new RuntimeException("Required value for 'individual' is null");
                    }
                    break;
                case team:
                    if (this.teamValue == null) {
                        throw new RuntimeException("Required value for 'team' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<SpaceAllocation> _writer = new JsonWriter<SpaceAllocation>()
        {
            public final void write(SpaceAllocation x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case individual:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("individual");
                        IndividualSpaceAllocation._writer.writeFields(x.individualValue, g);
                        g.writeEndObject();
                        break;
                    case team:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team");
                        TeamSpaceAllocation._writer.writeFields(x.teamValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<SpaceAllocation> _reader = new JsonReader<SpaceAllocation>()
        {
            public final SpaceAllocation read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SpaceAllocation.other; }
                    switch (tag) {
                        case other: return SpaceAllocation.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SpaceAllocation value = null;
                if (tag != null) {
                    switch (tag) {
                        case individual: {
                            IndividualSpaceAllocation v = null;
                            v = IndividualSpaceAllocation._reader.readFields(parser);
                            value = SpaceAllocation.individual(v);
                            break;
                        }
                        case team: {
                            TeamSpaceAllocation v = null;
                            v = TeamSpaceAllocation._reader.readFields(parser);
                            value = SpaceAllocation.team(v);
                            break;
                        }
                        case other: {
                            value = SpaceAllocation.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SpaceAllocation.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("individual", Tag.individual);
            _values.put("team", Tag.team);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "SpaceAllocation." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SpaceAllocation." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SpaceAllocation fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class IndividualSpaceAllocation {
        // struct IndividualSpaceAllocation
        /**
         * The total space allocated to the user's account (bytes).
         */
        public final long allocated;

        public IndividualSpaceAllocation(long allocated) {
            this.allocated = allocated;
        }
        static final JsonWriter<IndividualSpaceAllocation> _writer = new JsonWriter<IndividualSpaceAllocation>()
        {
            public final void write(IndividualSpaceAllocation x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                IndividualSpaceAllocation._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(IndividualSpaceAllocation x, JsonGenerator g)
             throws IOException
            {
                g.writeNumberField("allocated", x.allocated);
            }
        };

        public static final JsonReader<IndividualSpaceAllocation> _reader = new JsonReader<IndividualSpaceAllocation>() {

            public final IndividualSpaceAllocation read(JsonParser parser)
                throws IOException, JsonReadException
            {
                IndividualSpaceAllocation result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final IndividualSpaceAllocation readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Long allocated = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("allocated".equals(fieldName)) {
                        allocated = JsonReader.UInt64Reader
                            .readField(parser, "allocated", allocated);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (allocated == null) {
                    throw new JsonReadException("Required field \"allocated\" is missing.", parser.getTokenLocation());
                }
                return new IndividualSpaceAllocation(allocated);
            }
        };

        public String toString() {
            return "IndividualSpaceAllocation." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "IndividualSpaceAllocation." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static IndividualSpaceAllocation fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class TeamSpaceAllocation {
        // struct TeamSpaceAllocation
        /**
         * The total space currently used by the user's team (bytes).
         */
        public final long used;
        /**
         * The total space allocated to the user's team (bytes).
         */
        public final long allocated;

        public TeamSpaceAllocation(long used, long allocated) {
            this.used = used;
            this.allocated = allocated;
        }
        static final JsonWriter<TeamSpaceAllocation> _writer = new JsonWriter<TeamSpaceAllocation>()
        {
            public final void write(TeamSpaceAllocation x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                TeamSpaceAllocation._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(TeamSpaceAllocation x, JsonGenerator g)
             throws IOException
            {
                g.writeNumberField("used", x.used);
                g.writeNumberField("allocated", x.allocated);
            }
        };

        public static final JsonReader<TeamSpaceAllocation> _reader = new JsonReader<TeamSpaceAllocation>() {

            public final TeamSpaceAllocation read(JsonParser parser)
                throws IOException, JsonReadException
            {
                TeamSpaceAllocation result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final TeamSpaceAllocation readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Long used = null;
                Long allocated = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("used".equals(fieldName)) {
                        used = JsonReader.UInt64Reader
                            .readField(parser, "used", used);
                    }
                    else if ("allocated".equals(fieldName)) {
                        allocated = JsonReader.UInt64Reader
                            .readField(parser, "allocated", allocated);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (used == null) {
                    throw new JsonReadException("Required field \"used\" is missing.", parser.getTokenLocation());
                }
                if (allocated == null) {
                    throw new JsonReadException("Required field \"allocated\" is missing.", parser.getTokenLocation());
                }
                return new TeamSpaceAllocation(used, allocated);
            }
        };

        public String toString() {
            return "TeamSpaceAllocation." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "TeamSpaceAllocation." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static TeamSpaceAllocation fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class GetAccountBatchArg {
        // struct GetAccountBatchArg
        /**
         * List of user account identifiers.  Should not contain any duplicate
         * account IDs.
         */
        public final java.util.ArrayList<String> accountIds;

        public GetAccountBatchArg(java.util.ArrayList<String> accountIds) {
            this.accountIds = accountIds;
            if (accountIds == null) {
                throw new RuntimeException("Required value for 'accountIds' is null");
            }
            if (accountIds.size() < 1) {
                throw new RuntimeException("List 'accountIds' has fewer than 1 items");
            }
            for (String x : accountIds) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'accountIds' is null");
                }
                if (x.length() < 40) {
                    throw new RuntimeException("String 'an item in list field accountIds' is shorter than 40");
                }
                if (x.length() > 40) {
                    throw new RuntimeException("String 'an item in list field accountIds' is longer than 40");
                }
            }
        }
        static final JsonWriter<GetAccountBatchArg> _writer = new JsonWriter<GetAccountBatchArg>()
        {
            public final void write(GetAccountBatchArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GetAccountBatchArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GetAccountBatchArg x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("account_ids");
                g.writeStartArray();
                for (String item: x.accountIds) {
                    if (item != null) {
                        g.writeString(item);
                    }
                }
                g.writeEndArray();
            }
        };

        public static final JsonReader<GetAccountBatchArg> _reader = new JsonReader<GetAccountBatchArg>() {

            public final GetAccountBatchArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GetAccountBatchArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GetAccountBatchArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                java.util.ArrayList<String> accountIds = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("account_ids".equals(fieldName)) {
                        accountIds = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "account_ids", accountIds);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accountIds == null) {
                    throw new JsonReadException("Required field \"account_ids\" is missing.", parser.getTokenLocation());
                }
                return new GetAccountBatchArg(accountIds);
            }
        };

        public String toString() {
            return "GetAccountBatchArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetAccountBatchArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetAccountBatchArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class GetAccountBatchError {
        // union GetAccountBatchError

        /**
         * The discriminating tag type for {@link GetAccountBatchError}.
         */
        public enum Tag {
            noAccount,  // String
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String noAccountValue;
        private GetAccountBatchError(Tag t, String v) {
            tag = t;
            noAccountValue = v;
            validate();
        }
        /**
         * The value is an account ID specified in {@code
         * getAccountBatchArg.accountIds} that does not exist.
         */
        public static GetAccountBatchError noAccount(String v) {
            return new GetAccountBatchError(Tag.noAccount, v);
        }
        public String getNoAccount() {
            if (tag != Tag.noAccount) {
                throw new RuntimeException("getNoAccount() requires tag==noAccount, actual tag=="+tag);
            }
            return noAccountValue;
        }

        public static final GetAccountBatchError other = new GetAccountBatchError(Tag.other);

        private GetAccountBatchError(Tag t) {
            tag = t;
            noAccountValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case noAccount:
                    if (this.noAccountValue == null) {
                        throw new RuntimeException("Required value for 'noAccount' is null");
                    }
                    if (this.noAccountValue.length() < 40) {
                        throw new RuntimeException("String 'this.noAccountValue' is shorter than 40");
                    }
                    if (this.noAccountValue.length() > 40) {
                        throw new RuntimeException("String 'this.noAccountValue' is longer than 40");
                    }
                    break;
            }
        }
        static final JsonWriter<GetAccountBatchError> _writer = new JsonWriter<GetAccountBatchError>()
        {
            public final void write(GetAccountBatchError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case noAccount:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_account");
                        g.writeStringField("no_account", x.noAccountValue);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<GetAccountBatchError> _reader = new JsonReader<GetAccountBatchError>()
        {
            public final GetAccountBatchError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return GetAccountBatchError.other; }
                    switch (tag) {
                        case other: return GetAccountBatchError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                GetAccountBatchError value = null;
                if (tag != null) {
                    switch (tag) {
                        case noAccount: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "no_account", v);
                            value = GetAccountBatchError.noAccount(v);
                            break;
                        }
                        case other: {
                            value = GetAccountBatchError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return GetAccountBatchError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("no_account", Tag.noAccount);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "GetAccountBatchError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetAccountBatchError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetAccountBatchError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Exception thrown by {@link #getAccount}.
     */
    public static class GetAccountException extends DbxApiException {
        /**
         * The error reported by getAccount.
         */
        public final GetAccountError errorValue;

        public GetAccountException(GetAccountError errorValue) {
            super("Exception in get_account: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Get information about a user's account.
     */
    private BasicAccount getAccount(GetAccountArg arg)
            throws GetAccountException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/users/get_account",
                                           arg,
                                           GetAccountArg._writer,
                                           BasicAccount._reader,
                                           GetAccountError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetAccountException((GetAccountError) (ew.errValue));
        }
    }
    /**
     * Get information about a user's account.
     */
    public BasicAccount getAccount(String accountId)
          throws GetAccountException, DbxException
    {
        GetAccountArg arg = new GetAccountArg(accountId);
        return getAccount(arg);
    }

    /**
     * Exception thrown by {@link #getCurrentAccount}.
     */
    public static class GetCurrentAccountException extends DbxApiException {
        public GetCurrentAccountException() {
            super("Exception in get_current_account");
        }
    }
    /**
     * Get information about the current user's account.
     */
    public FullAccount getCurrentAccount()
            throws GetCurrentAccountException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/users/get_current_account",
                                           null,
                                           null,
                                           FullAccount._reader,
                                           JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetCurrentAccountException();
        }
    }

    /**
     * Exception thrown by {@link #getSpaceUsage}.
     */
    public static class GetSpaceUsageException extends DbxApiException {
        public GetSpaceUsageException() {
            super("Exception in get_space_usage");
        }
    }
    /**
     * Get the space usage information for the current user's account.
     */
    public SpaceUsage getSpaceUsage()
            throws GetSpaceUsageException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/users/get_space_usage",
                                           null,
                                           null,
                                           SpaceUsage._reader,
                                           JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSpaceUsageException();
        }
    }

    /**
     * Exception thrown by {@link #getAccountBatch}.
     */
    public static class GetAccountBatchException extends DbxApiException {
        /**
         * The error reported by getAccountBatch.
         */
        public final GetAccountBatchError errorValue;

        public GetAccountBatchException(GetAccountBatchError errorValue) {
            super("Exception in get_account_batch: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     */
    private java.util.ArrayList<BasicAccount> getAccountBatch(GetAccountBatchArg arg)
            throws GetAccountBatchException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/users/get_account_batch",
                                           arg,
                                           GetAccountBatchArg._writer,
                                           JsonArrayReader.mk(BasicAccount._reader),
                                           GetAccountBatchError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetAccountBatchException((GetAccountBatchError) (ew.errValue));
        }
    }
    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     */
    public java.util.ArrayList<BasicAccount> getAccountBatch(java.util.ArrayList<String> accountIds)
          throws GetAccountBatchException, DbxException
    {
        GetAccountBatchArg arg = new GetAccountBatchArg(accountIds);
        return getAccountBatch(arg);
    }
}
