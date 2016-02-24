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
 * The amount of detail revealed about an account depends on the user being
 * queried and the user making the query.
 */
public class Account {
    // struct Account

    private final String accountId;
    private final Name name;
    private final String email;
    private final boolean emailVerified;
    private final String profilePhotoUrl;

    /**
     * The amount of detail revealed about an account depends on the user being
     * queried and the user making the query.
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param email  The user's e-mail address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their e-mail. Must
     *     not be {@code null}.
     * @param emailVerified  Whether the user has verified their e-mail address.
     * @param profilePhotoUrl  URL for the photo representing the user, if one
     *     is set.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Account(String accountId, Name name, String email, boolean emailVerified, String profilePhotoUrl) {
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
        this.profilePhotoUrl = profilePhotoUrl;
    }

    /**
     * The amount of detail revealed about an account depends on the user being
     * queried and the user making the query.
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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Account(String accountId, Name name, String email, boolean emailVerified) {
        this(accountId, name, email, emailVerified, null);
    }

    /**
     * The user's unique Dropbox ID.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Details of a user's name.
     *
     * @return value for this field, never {@code null}.
     */
    public Name getName() {
        return name;
    }

    /**
     * The user's e-mail address. Do not rely on this without checking the
     * {@link Account#getEmailVerified} field. Even then, it's possible that the
     * user has since lost access to their e-mail.
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
     * URL for the photo representing the user, if one is set.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accountId,
            name,
            email,
            emailVerified,
            profilePhotoUrl
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            Account other = (Account) obj;
            return ((this.accountId == other.accountId) || (this.accountId.equals(other.accountId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && ((this.profilePhotoUrl == other.profilePhotoUrl) || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(other.profilePhotoUrl)))
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

    public static Account fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<Account> _JSON_WRITER = new JsonWriter<Account>() {
        public final void write(Account x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            Account._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(Account x, JsonGenerator g) throws IOException {
            g.writeFieldName("account_id");
            g.writeString(x.accountId);
            g.writeFieldName("name");
            Name._JSON_WRITER.write(x.name, g);
            g.writeFieldName("email");
            g.writeString(x.email);
            g.writeFieldName("email_verified");
            g.writeBoolean(x.emailVerified);
            if (x.profilePhotoUrl != null) {
                g.writeFieldName("profile_photo_url");
                g.writeString(x.profilePhotoUrl);
            }
        }
    };

    public static final JsonReader<Account> _JSON_READER = new JsonReader<Account>() {
        public final Account read(JsonParser parser) throws IOException, JsonReadException {
            Account result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final Account readFields(JsonParser parser) throws IOException, JsonReadException {
            String accountId = null;
            Name name = null;
            String email = null;
            Boolean emailVerified = null;
            String profilePhotoUrl = null;
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
                else if ("profile_photo_url".equals(fieldName)) {
                    profilePhotoUrl = JsonReader.StringReader
                        .readField(parser, "profile_photo_url", profilePhotoUrl);
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
            return new Account(accountId, name, email, emailVerified, profilePhotoUrl);
        }
    };
}
