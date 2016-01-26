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
import com.dropbox.core.LocalizedText;
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

        /**
         *
         * @param accountId  A user's account identifier. {@code accountId} must
         *     have length of at least 40, have length of at most 40, and not be
         *     {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetAccountArg(String accountId) {
            this.accountId = accountId;
            if (accountId == null) {
                throw new IllegalArgumentException("Required value for 'accountId' is null");
            }
            if (accountId.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
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


    public static final class GetAccountError {
        // union GetAccountError

        /**
         * The discriminating tag type for {@link GetAccountError}.
         */
        public enum Tag {
            /**
             * The specified {@link GetAccountArg#accountId} does not exist.
             */
            NO_ACCOUNT,
            UNKNOWN  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code GetAccountError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The specified {@link GetAccountArg#accountId} does not exist.
         */
        private static final GetAccountError NO_ACCOUNT_INSTANCE = new GetAccountError(Tag.NO_ACCOUNT);

        /**
         * Returns an instance of {@code GetAccountError} that has its tag set
         * to {@link Tag#NO_ACCOUNT}.
         *
         * <p> The specified {@link GetAccountArg#accountId} does not exist.
         * </p>
         *
         * @return Instance of {@code GetAccountError} with its tag set to
         *     {@link Tag#NO_ACCOUNT}.
         */
        public static GetAccountError noAccount() {
            return GetAccountError.NO_ACCOUNT_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NO_ACCOUNT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NO_ACCOUNT}, {@code false} otherwise.
         */
        public boolean isNoAccount() {
            return this.tag == Tag.NO_ACCOUNT;
        }

        private static final GetAccountError UNKNOWN_INSTANCE = new GetAccountError(Tag.UNKNOWN);

        /**
         * Returns an instance of {@code GetAccountError} that has its tag set
         * to {@link Tag#UNKNOWN}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code GetAccountError} with its tag set to
         *     {@link Tag#UNKNOWN}.
         */
        public static GetAccountError unknown() {
            return GetAccountError.UNKNOWN_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#UNKNOWN}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UNKNOWN}, {@code false} otherwise.
         */
        public boolean isUnknown() {
            return this.tag == Tag.UNKNOWN;
        }

        private GetAccountError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case NO_ACCOUNT:
                case UNKNOWN:
                    break;
            }
        }

        static final JsonWriter<GetAccountError> _writer = new JsonWriter<GetAccountError>()
        {
            public final void write(GetAccountError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case NO_ACCOUNT:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_account");
                        g.writeEndObject();
                        break;
                    case UNKNOWN:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return GetAccountError.unknown(); }
                    switch (tag) {
                        case NO_ACCOUNT: return GetAccountError.noAccount();
                        case UNKNOWN: return GetAccountError.unknown();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                GetAccountError value = null;
                if (tag != null) {
                    switch (tag) {
                        case NO_ACCOUNT: {
                            value = GetAccountError.noAccount();
                            break;
                        }
                        case UNKNOWN: {
                            value = GetAccountError.unknown();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return GetAccountError.unknown(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("no_account", Tag.NO_ACCOUNT);
            _values.put("unknown", Tag.UNKNOWN);
        }

        public String toString() {
            return "GetAccountError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetAccountError." +  _writer.writeToString(this, true);
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
    public static final class AccountType {
        // union AccountType

        /**
         * The discriminating tag type for {@link AccountType}.
         */
        public enum Tag {
            /**
             * The basic account type.
             */
            BASIC,
            /**
             * The Dropbox Pro account type.
             */
            PRO,
            /**
             * The Dropbox Business account type.
             */
            BUSINESS
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code AccountType}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The basic account type.
         */
        private static final AccountType BASIC_INSTANCE = new AccountType(Tag.BASIC);

        /**
         * Returns an instance of {@code AccountType} that has its tag set to
         * {@link Tag#BASIC}.
         *
         * <p> The basic account type. </p>
         *
         * @return Instance of {@code AccountType} with its tag set to {@link
         *     Tag#BASIC}.
         */
        public static AccountType basic() {
            return AccountType.BASIC_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#BASIC},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#BASIC},
         *     {@code false} otherwise.
         */
        public boolean isBasic() {
            return this.tag == Tag.BASIC;
        }

        /**
         * The Dropbox Pro account type.
         */
        private static final AccountType PRO_INSTANCE = new AccountType(Tag.PRO);

        /**
         * Returns an instance of {@code AccountType} that has its tag set to
         * {@link Tag#PRO}.
         *
         * <p> The Dropbox Pro account type. </p>
         *
         * @return Instance of {@code AccountType} with its tag set to {@link
         *     Tag#PRO}.
         */
        public static AccountType pro() {
            return AccountType.PRO_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PRO},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PRO},
         *     {@code false} otherwise.
         */
        public boolean isPro() {
            return this.tag == Tag.PRO;
        }

        /**
         * The Dropbox Business account type.
         */
        private static final AccountType BUSINESS_INSTANCE = new AccountType(Tag.BUSINESS);

        /**
         * Returns an instance of {@code AccountType} that has its tag set to
         * {@link Tag#BUSINESS}.
         *
         * <p> The Dropbox Business account type. </p>
         *
         * @return Instance of {@code AccountType} with its tag set to {@link
         *     Tag#BUSINESS}.
         */
        public static AccountType business() {
            return AccountType.BUSINESS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#BUSINESS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#BUSINESS}, {@code false} otherwise.
         */
        public boolean isBusiness() {
            return this.tag == Tag.BUSINESS;
        }

        private AccountType(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case BASIC:
                case PRO:
                case BUSINESS:
                    break;
            }
        }

        static final JsonWriter<AccountType> _writer = new JsonWriter<AccountType>()
        {
            public final void write(AccountType x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case BASIC:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("basic");
                        g.writeEndObject();
                        break;
                    case PRO:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("pro");
                        g.writeEndObject();
                        break;
                    case BUSINESS:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case BASIC: return AccountType.basic();
                        case PRO: return AccountType.pro();
                        case BUSINESS: return AccountType.business();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                AccountType value = null;
                if (tag != null) {
                    switch (tag) {
                        case BASIC: {
                            value = AccountType.basic();
                            break;
                        }
                        case PRO: {
                            value = AccountType.pro();
                            break;
                        }
                        case BUSINESS: {
                            value = AccountType.business();
                            break;
                        }
                    }
                }
                if (value == null) {
                    throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
                }
                JsonReader.expectObjectEnd(parser);
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("basic", Tag.BASIC);
            _values.put("pro", Tag.PRO);
            _values.put("business", Tag.BUSINESS);
        }

        public String toString() {
            return "AccountType." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "AccountType." +  _writer.writeToString(this, true);
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

        /**
         * The amount of detail revealed about an account depends on the user
         * being queried and the user making the query.
         *
         * @param name  Details of a user's name. {@code name} must not be
         *     {@code null}.
         * @param accountId  The user's unique Dropbox ID. {@code accountId}
         *     must have length of at least 40, have length of at most 40, and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public Account(String accountId, Name name) {
            this.accountId = accountId;
            if (accountId == null) {
                throw new IllegalArgumentException("Required value for 'accountId' is null");
            }
            if (accountId.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
            this.name = name;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
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
         * is the current user's account, then this will be {@code true}.
         */
        public final boolean isTeammate;

        /**
         * Basic information about any account.
         *
         * @param name  Details of a user's name. {@code name} must not be
         *     {@code null}.
         * @param isTeammate  Whether this user is a teammate of the current
         *     user. If this account is the current user's account, then this
         *     will be {@code true}.
         * @param accountId  The user's unique Dropbox ID. {@code accountId}
         *     must have length of at least 40, have length of at most 40, and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
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
         * The user's e-mail address. Do not rely on this without checking the
         * {@link FullAccount#emailVerified} field. Even then, it's possible
         * that the user has since lost access to their e-mail.
         */
        public final String email;
        /**
         * Whether the user has verified their e-mail address.
         */
        public final boolean emailVerified;
        /**
         * The user's two-letter country code, if available. Country codes are
         * based on &lt;a href="http://en.wikipedia.org/wiki/ISO_3166-1"&gt;ISO
         * 3166-1&lt;/a&gt;.
         */
        public final String country;
        /**
         * The language that the user specified. Locale tags will be &lt;a
         * href="http://en.wikipedia.org/wiki/IETF_language_tag"&gt;IETF
         * language tags&lt;/a&gt;.
         */
        public final String locale;
        /**
         * The user's &lt;a href="https://www.dropbox.com/referrals"&gt;referral
         * link&lt;/a&gt;.
         */
        public final String referralLink;
        /**
         * If this account is a member of a team, information about that team.
         */
        public final Team team;
        /**
         * Whether the user has a personal and work account. If the current
         * account is personal, then {@link FullAccount#team} will always be
         * {@code null}, but {@link FullAccount#isPaired} will indicate if a
         * work account is linked.
         */
        public final boolean isPaired;
        /**
         * What type of account this user has.
         */
        public final AccountType accountType;

        /**
         * Detailed information about the current user's account.
         *
         * @param name  Details of a user's name. {@code name} must not be
         *     {@code null}.
         * @param referralLink  The user's <a
         *     href="https://www.dropbox.com/referrals">referral link</a>.
         *     {@code referralLink} must not be {@code null}.
         * @param accountId  The user's unique Dropbox ID. {@code accountId}
         *     must have length of at least 40, have length of at most 40, and
         *     not be {@code null}.
         * @param email  The user's e-mail address. Do not rely on this without
         *     checking the {@code emailVerified} field. Even then, it's
         *     possible that the user has since lost access to their e-mail.
         *     {@code email} must not be {@code null}.
         * @param team  If this account is a member of a team, information about
         *     that team.
         * @param accountType  What type of account this user has. {@code
         *     accountType} must not be {@code null}.
         * @param isPaired  Whether the user has a personal and work account. If
         *     the current account is personal, then {@code team} will always be
         *     {@code null}, but {@code isPaired} will indicate if a work
         *     account is linked.
         * @param locale  The language that the user specified. Locale tags will
         *     be <a href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF
         *     language tags</a>. {@code locale} must have length of at least 2
         *     and not be {@code null}.
         * @param country  The user's two-letter country code, if available.
         *     Country codes are based on <a
         *     href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>.
         *     {@code country} must have length of at least 2 and have length of
         *     at most 2.
         * @param emailVerified  Whether the user has verified their e-mail
         *     address.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FullAccount(String accountId, Name name, String email, boolean emailVerified, String locale, String referralLink, boolean isPaired, AccountType accountType, String country, Team team) {
            super(accountId, name);
            this.email = email;
            if (email == null) {
                throw new IllegalArgumentException("Required value for 'email' is null");
            }
            this.emailVerified = emailVerified;
            this.country = country;
            if (country != null) {
                if (country.length() < 2) {
                    throw new IllegalArgumentException("String 'country' is shorter than 2");
                }
                if (country.length() > 2) {
                    throw new IllegalArgumentException("String 'country' is longer than 2");
                }
            }
            this.locale = locale;
            if (locale == null) {
                throw new IllegalArgumentException("Required value for 'locale' is null");
            }
            if (locale.length() < 2) {
                throw new IllegalArgumentException("String 'locale' is shorter than 2");
            }
            this.referralLink = referralLink;
            if (referralLink == null) {
                throw new IllegalArgumentException("Required value for 'referralLink' is null");
            }
            this.team = team;
            this.isPaired = isPaired;
            this.accountType = accountType;
            if (accountType == null) {
                throw new IllegalArgumentException("Required value for 'accountType' is null");
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
                g.writeBooleanField("email_verified", x.emailVerified);
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
                        name = Name._reader
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

        /**
         * Information about a team.
         *
         * @param name  The name of the team. {@code name} must not be {@code
         *     null}.
         * @param id  The team's unique ID. {@code id} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public Team(String id, String name) {
            this.id = id;
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            this.name = name;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
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
         * {@link Name#givenName}, but elsewhere, it could be any combination of
         * a person's {@link Name#givenName} and {@link Name#surname}.
         */
        public final String familiarName;
        /**
         * A name that can be used directly to represent the name of a user's
         * Dropbox account.
         */
        public final String displayName;

        /**
         * Representations for a person's name to assist with
         * internationalization.
         *
         * @param givenName  Also known as a first name. {@code givenName} must
         *     not be {@code null}.
         * @param familiarName  Locale-dependent name. In the US, a person's
         *     familiar name is their {@code givenName}, but elsewhere, it could
         *     be any combination of a person's {@code givenName} and {@code
         *     surname}. {@code familiarName} must not be {@code null}.
         * @param surname  Also known as a last name or family name. {@code
         *     surname} must not be {@code null}.
         * @param displayName  A name that can be used directly to represent the
         *     name of a user's Dropbox account. {@code displayName} must not be
         *     {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public Name(String givenName, String surname, String familiarName, String displayName) {
            this.givenName = givenName;
            if (givenName == null) {
                throw new IllegalArgumentException("Required value for 'givenName' is null");
            }
            this.surname = surname;
            if (surname == null) {
                throw new IllegalArgumentException("Required value for 'surname' is null");
            }
            this.familiarName = familiarName;
            if (familiarName == null) {
                throw new IllegalArgumentException("Required value for 'familiarName' is null");
            }
            this.displayName = displayName;
            if (displayName == null) {
                throw new IllegalArgumentException("Required value for 'displayName' is null");
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

        /**
         * Information about a user's space usage and quota.
         *
         * @param allocation  The user's space allocation. {@code allocation}
         *     must not be {@code null}.
         * @param used  The user's total space usage (bytes).
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SpaceUsage(long used, SpaceAllocation allocation) {
            this.used = used;
            this.allocation = allocation;
            if (allocation == null) {
                throw new IllegalArgumentException("Required value for 'allocation' is null");
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
            /**
             * The user's space allocation applies only to their individual
             * account.
             */
            INDIVIDUAL,  // IndividualSpaceAllocation
            /**
             * The user shares space with other members of their team.
             */
            TEAM,  // TeamSpaceAllocation
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code SpaceAllocation}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final IndividualSpaceAllocation individualValue;

        private SpaceAllocation(Tag tag, IndividualSpaceAllocation value) {
            this.tag = tag;
            this.individualValue = value;
            this.teamValue = null;
            validate();
        }

        /**
         * The user's space allocation applies only to their individual account.
         *
         * <p> This instance must be tagged as {@link Tag#INDIVIDUAL}. </p>
         *
         * @return The {@link IndividualSpaceAllocation} value associated with
         *     this instance if {@link #isIndividual} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isIndividual} is {@code
         *     false}.
         */
        public IndividualSpaceAllocation getIndividualValue() {
            if (this.tag != Tag.INDIVIDUAL) {
                throw new IllegalStateException("getIndividualValue() requires tag==INDIVIDUAL, actual tag==" + tag);
            }
            return individualValue;
        }

        /**
         * Returns an instance of {@code SpaceAllocation} that has its tag set
         * to {@link Tag#INDIVIDUAL}.
         *
         * <p> The user's space allocation applies only to their individual
         * account. </p>
         *
         * @param value  {@link IndividualSpaceAllocation} value to assign to
         *     this instance.
         *
         * @return Instance of {@code SpaceAllocation} with its tag set to
         *     {@link Tag#INDIVIDUAL}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static SpaceAllocation individual(IndividualSpaceAllocation value) {
            return new SpaceAllocation(Tag.INDIVIDUAL, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INDIVIDUAL}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INDIVIDUAL}, {@code false} otherwise.
         */
        public boolean isIndividual() {
            return this.tag == Tag.INDIVIDUAL;
        }

        private final TeamSpaceAllocation teamValue;

        private SpaceAllocation(Tag tag, TeamSpaceAllocation value) {
            this.tag = tag;
            this.individualValue = null;
            this.teamValue = value;
            validate();
        }

        /**
         * The user shares space with other members of their team.
         *
         * <p> This instance must be tagged as {@link Tag#TEAM}. </p>
         *
         * @return The {@link TeamSpaceAllocation} value associated with this
         *     instance if {@link #isTeam} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isTeam} is {@code false}.
         */
        public TeamSpaceAllocation getTeamValue() {
            if (this.tag != Tag.TEAM) {
                throw new IllegalStateException("getTeamValue() requires tag==TEAM, actual tag==" + tag);
            }
            return teamValue;
        }

        /**
         * Returns an instance of {@code SpaceAllocation} that has its tag set
         * to {@link Tag#TEAM}.
         *
         * <p> The user shares space with other members of their team. </p>
         *
         * @param value  {@link TeamSpaceAllocation} value to assign to this
         *     instance.
         *
         * @return Instance of {@code SpaceAllocation} with its tag set to
         *     {@link Tag#TEAM}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static SpaceAllocation team(TeamSpaceAllocation value) {
            return new SpaceAllocation(Tag.TEAM, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#TEAM},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#TEAM},
         *     {@code false} otherwise.
         */
        public boolean isTeam() {
            return this.tag == Tag.TEAM;
        }

        private static final SpaceAllocation OTHER_INSTANCE = new SpaceAllocation(Tag.OTHER);

        /**
         * Returns an instance of {@code SpaceAllocation} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code SpaceAllocation} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static SpaceAllocation other() {
            return SpaceAllocation.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private SpaceAllocation(Tag t) {
            tag = t;
            individualValue = null;
            teamValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case INDIVIDUAL:
                    if (this.individualValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case TEAM:
                    if (this.teamValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case INDIVIDUAL:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("individual");
                        IndividualSpaceAllocation._writer.writeFields(x.individualValue, g);
                        g.writeEndObject();
                        break;
                    case TEAM:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team");
                        TeamSpaceAllocation._writer.writeFields(x.teamValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return SpaceAllocation.other(); }
                    switch (tag) {
                        case OTHER: return SpaceAllocation.other();
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
                        case INDIVIDUAL: {
                            IndividualSpaceAllocation v = null;
                            v = IndividualSpaceAllocation._reader.readFields(parser);
                            value = SpaceAllocation.individual(v);
                            break;
                        }
                        case TEAM: {
                            TeamSpaceAllocation v = null;
                            v = TeamSpaceAllocation._reader.readFields(parser);
                            value = SpaceAllocation.team(v);
                            break;
                        }
                        case OTHER: {
                            value = SpaceAllocation.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SpaceAllocation.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("individual", Tag.INDIVIDUAL);
            _values.put("team", Tag.TEAM);
            _values.put("other", Tag.OTHER);
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

        /**
         *
         * @param allocated  The total space allocated to the user's account
         *     (bytes).
         */
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

        /**
         *
         * @param allocated  The total space allocated to the user's team
         *     (bytes).
         * @param used  The total space currently used by the user's team
         *     (bytes).
         */
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
        public final java.util.List<String> accountIds;

        /**
         *
         * @param accountIds  List of user account identifiers.  Should not
         *     contain any duplicate account IDs. {@code accountIds} must
         *     contain at least 1 items, not contain a {@code null} item, and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetAccountBatchArg(java.util.List<String> accountIds) {
            this.accountIds = accountIds;
            if (accountIds == null) {
                throw new IllegalArgumentException("Required value for 'accountIds' is null");
            }
            if (accountIds.size() < 1) {
                throw new IllegalArgumentException("List 'accountIds' has fewer than 1 items");
            }
            for (String x : accountIds) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'accountIds' is null");
                }
                if (x.length() < 40) {
                    throw new IllegalArgumentException("String 'an item in list 'accountIds'' is shorter than 40");
                }
                if (x.length() > 40) {
                    throw new IllegalArgumentException("String 'an item in list 'accountIds'' is longer than 40");
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
                java.util.List<String> accountIds = null;
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
            /**
             * The value is an account ID specified in {@link
             * GetAccountBatchArg#accountIds} that does not exist.
             */
            NO_ACCOUNT,  // String
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code GetAccountBatchError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String noAccountValue;

        private GetAccountBatchError(Tag tag, String value) {
            this.tag = tag;
            this.noAccountValue = value;
            validate();
        }

        /**
         * The value is an account ID specified in {@link
         * GetAccountBatchArg#accountIds} that does not exist.
         *
         * <p> This instance must be tagged as {@link Tag#NO_ACCOUNT}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isNoAccount} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isNoAccount} is {@code
         *     false}.
         */
        public String getNoAccountValue() {
            if (this.tag != Tag.NO_ACCOUNT) {
                throw new IllegalStateException("getNoAccountValue() requires tag==NO_ACCOUNT, actual tag==" + tag);
            }
            return noAccountValue;
        }

        /**
         * Returns an instance of {@code GetAccountBatchError} that has its tag
         * set to {@link Tag#NO_ACCOUNT}.
         *
         * <p> The value is an account ID specified in {@link
         * GetAccountBatchArg#accountIds} that does not exist. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code GetAccountBatchError} with its tag set to
         *     {@link Tag#NO_ACCOUNT}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than
         *     40, is longer than 40, or is {@code null}.
         */
        public static GetAccountBatchError noAccount(String value) {
            return new GetAccountBatchError(Tag.NO_ACCOUNT, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NO_ACCOUNT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NO_ACCOUNT}, {@code false} otherwise.
         */
        public boolean isNoAccount() {
            return this.tag == Tag.NO_ACCOUNT;
        }

        private static final GetAccountBatchError OTHER_INSTANCE = new GetAccountBatchError(Tag.OTHER);

        /**
         * Returns an instance of {@code GetAccountBatchError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code GetAccountBatchError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static GetAccountBatchError other() {
            return GetAccountBatchError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private GetAccountBatchError(Tag t) {
            tag = t;
            noAccountValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case NO_ACCOUNT:
                    if (this.noAccountValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (this.noAccountValue.length() < 40) {
                        throw new IllegalArgumentException("String is shorter than 40");
                    }
                    if (this.noAccountValue.length() > 40) {
                        throw new IllegalArgumentException("String is longer than 40");
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
                    case NO_ACCOUNT:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_account");
                        g.writeStringField("no_account", x.noAccountValue);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return GetAccountBatchError.other(); }
                    switch (tag) {
                        case OTHER: return GetAccountBatchError.other();
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
                        case NO_ACCOUNT: {
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
                        case OTHER: {
                            value = GetAccountBatchError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return GetAccountBatchError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("no_account", Tag.NO_ACCOUNT);
            _values.put("other", Tag.OTHER);
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
     * Exception thrown by {@link DbxUsers#getAccount(String)}.
     */
    public static class GetAccountException extends DbxApiException {
        /**
         * The error reported by getAccount.
         */
        public final GetAccountError errorValue;

        public GetAccountException(String requestId, LocalizedText userMessage, GetAccountError errorValue) {
            super(requestId, userMessage, buildMessage("get_account", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/users/get_account",
                                   arg,
                                   false,
                                   GetAccountArg._writer,
                                   BasicAccount._reader,
                                   GetAccountError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetAccountException(ew.requestId, ew.userMessage, (GetAccountError) (ew.errValue));
        }
    }
    /**
     * Get information about a user's account.
     *
     * @param accountId  A user's account identifier. {@code accountId} must
     *     have length of at least 40, have length of at most 40, and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public BasicAccount getAccount(String accountId)
          throws GetAccountException, DbxException
    {
        GetAccountArg arg = new GetAccountArg(accountId);
        return getAccount(arg);
    }

    /**
     * Exception thrown by {@link DbxUsers#getCurrentAccount}.
     */
    public static class GetCurrentAccountException extends DbxApiException {
        public GetCurrentAccountException(String requestId, LocalizedText userMessage) {
            super(requestId, userMessage, buildMessage("get_current_account", userMessage));
        }
    }
    /**
     * Get information about the current user's account.
     */
    public FullAccount getCurrentAccount()
            throws GetCurrentAccountException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/users/get_current_account",
                                   null,
                                   false,
                                   null,
                                   FullAccount._reader,
                                   JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetCurrentAccountException(ew.requestId, ew.userMessage);
        }
    }

    /**
     * Exception thrown by {@link DbxUsers#getSpaceUsage}.
     */
    public static class GetSpaceUsageException extends DbxApiException {
        public GetSpaceUsageException(String requestId, LocalizedText userMessage) {
            super(requestId, userMessage, buildMessage("get_space_usage", userMessage));
        }
    }
    /**
     * Get the space usage information for the current user's account.
     */
    public SpaceUsage getSpaceUsage()
            throws GetSpaceUsageException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/users/get_space_usage",
                                   null,
                                   false,
                                   null,
                                   SpaceUsage._reader,
                                   JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSpaceUsageException(ew.requestId, ew.userMessage);
        }
    }

    /**
     * Exception thrown by {@link DbxUsers#getAccountBatch(java.util.List)}.
     */
    public static class GetAccountBatchException extends DbxApiException {
        /**
         * The error reported by getAccountBatch.
         */
        public final GetAccountBatchError errorValue;

        public GetAccountBatchException(String requestId, LocalizedText userMessage, GetAccountBatchError errorValue) {
            super(requestId, userMessage, buildMessage("get_account_batch", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     */
    private java.util.List<BasicAccount> getAccountBatch(GetAccountBatchArg arg)
            throws GetAccountBatchException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/users/get_account_batch",
                                   arg,
                                   false,
                                   GetAccountBatchArg._writer,
                                   JsonArrayReader.mk(BasicAccount._reader),
                                   GetAccountBatchError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetAccountBatchException(ew.requestId, ew.userMessage, (GetAccountBatchError) (ew.errValue));
        }
    }
    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     *
     * @param accountIds  List of user account identifiers.  Should not contain
     *     any duplicate account IDs. {@code accountIds} must contain at least 1
     *     items, not contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public java.util.List<BasicAccount> getAccountBatch(java.util.List<String> accountIds)
          throws GetAccountBatchException, DbxException
    {
        GetAccountBatchArg arg = new GetAccountBatchArg(accountIds);
        return getAccountBatch(arg);
    }
}
