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
 * Basic information about any account.
 */
public class BasicAccount extends Account {
    // struct BasicAccount

    private final boolean isTeammate;
    private final String teamMemberId;

    /**
     * Basic information about any account.
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
     * @param isTeammate  Whether this user is a teammate of the current user.
     *     If this account is the current user's account, then this will be
     *     {@code true}.
     * @param profilePhotoUrl  URL for the photo representing the user, if one
     *     is set.
     * @param teamMemberId  The user's unique team member id. This field will
     *     only be present if the user is part of a team and {@link
     *     BasicAccount#getIsTeammate} is {@code true}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BasicAccount(String accountId, Name name, String email, boolean emailVerified, boolean isTeammate, String profilePhotoUrl, String teamMemberId) {
        super(accountId, name, email, emailVerified, profilePhotoUrl);
        this.isTeammate = isTeammate;
        this.teamMemberId = teamMemberId;
    }

    /**
     * Basic information about any account.
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
     * @param isTeammate  Whether this user is a teammate of the current user.
     *     If this account is the current user's account, then this will be
     *     {@code true}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BasicAccount(String accountId, Name name, String email, boolean emailVerified, boolean isTeammate) {
        this(accountId, name, email, emailVerified, isTeammate, null, null);
    }

    /**
     * Whether this user is a teammate of the current user. If this account is
     * the current user's account, then this will be {@code true}.
     *
     * @return value for this field.
     */
    public boolean getIsTeammate() {
        return isTeammate;
    }

    /**
     * The user's unique team member id. This field will only be present if the
     * user is part of a team and {@link BasicAccount#getIsTeammate} is {@code
     * true}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getTeamMemberId() {
        return teamMemberId;
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
     * @param isTeammate  Whether this user is a teammate of the current user.
     *     If this account is the current user's account, then this will be
     *     {@code true}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String accountId, Name name, String email, boolean emailVerified, boolean isTeammate) {
        return new Builder(accountId, name, email, emailVerified, isTeammate);
    }

    /**
     * Builder for {@link BasicAccount}.
     */
    public static class Builder {
        protected final String accountId;
        protected final Name name;
        protected final String email;
        protected final boolean emailVerified;
        protected final boolean isTeammate;

        protected String profilePhotoUrl;
        protected String teamMemberId;

        protected Builder(String accountId, Name name, String email, boolean emailVerified, boolean isTeammate) {
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
            this.isTeammate = isTeammate;
            this.profilePhotoUrl = null;
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
         * @param teamMemberId  The user's unique team member id. This field
         *     will only be present if the user is part of a team and {@link
         *     BasicAccount#getIsTeammate} is {@code true}.
         *
         * @return this builder
         */
        public Builder withTeamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Builds an instance of {@link BasicAccount} configured with this
         * builder's values
         *
         * @return new instance of {@link BasicAccount}
         */
        public BasicAccount build() {
            return new BasicAccount(accountId, name, email, emailVerified, isTeammate, profilePhotoUrl, teamMemberId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            isTeammate,
            teamMemberId
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
            BasicAccount other = (BasicAccount) obj;
            return (this.isTeammate == other.isTeammate)
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId != null && this.teamMemberId.equals(other.teamMemberId)))
                && ((this.getAccountId() == other.getAccountId()) || (this.getAccountId().equals(other.getAccountId())))
                && ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
                && ((this.getEmail() == other.getEmail()) || (this.getEmail().equals(other.getEmail())))
                && (this.getEmailVerified() == other.getEmailVerified())
                && ((this.getProfilePhotoUrl() == other.getProfilePhotoUrl()) || (this.getProfilePhotoUrl() != null && this.getProfilePhotoUrl().equals(other.getProfilePhotoUrl())))
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

    public static BasicAccount fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<BasicAccount> _JSON_WRITER = new JsonWriter<BasicAccount>() {
        public final void write(BasicAccount x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            Account._JSON_WRITER.writeFields(x, g);
            BasicAccount._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(BasicAccount x, JsonGenerator g) throws IOException {
            g.writeFieldName("is_teammate");
            g.writeBoolean(x.isTeammate);
            if (x.teamMemberId != null) {
                g.writeFieldName("team_member_id");
                g.writeString(x.teamMemberId);
            }
        }
    };

    public static final JsonReader<BasicAccount> _JSON_READER = new JsonReader<BasicAccount>() {
        public final BasicAccount read(JsonParser parser) throws IOException, JsonReadException {
            BasicAccount result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final BasicAccount readFields(JsonParser parser) throws IOException, JsonReadException {
            String accountId = null;
            Name name = null;
            String email = null;
            Boolean emailVerified = null;
            Boolean isTeammate = null;
            String profilePhotoUrl = null;
            String teamMemberId = null;
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
                else if ("is_teammate".equals(fieldName)) {
                    isTeammate = JsonReader.BooleanReader
                        .readField(parser, "is_teammate", isTeammate);
                }
                else if ("profile_photo_url".equals(fieldName)) {
                    profilePhotoUrl = JsonReader.StringReader
                        .readField(parser, "profile_photo_url", profilePhotoUrl);
                }
                else if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
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
            if (isTeammate == null) {
                throw new JsonReadException("Required field \"is_teammate\" is missing.", parser.getTokenLocation());
            }
            return new BasicAccount(accountId, name, email, emailVerified, isTeammate, profilePhotoUrl, teamMemberId);
        }
    };
}
