/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

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

/**
 * Basic information about any account.
 */
public class BasicAccount extends Account {
    // struct users.BasicAccount (users.stone)

    protected final boolean isTeammate;
    protected final String teamMemberId;

    /**
     * Basic information about any account.
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
    public BasicAccount(String accountId, Name name, String email, boolean emailVerified, boolean disabled, boolean isTeammate, String profilePhotoUrl, String teamMemberId) {
        super(accountId, name, email, emailVerified, disabled, profilePhotoUrl);
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
     * @param email  The user's email address. Do not rely on this without
     *     checking the {@link Account#getEmailVerified} field. Even then, it's
     *     possible that the user has since lost access to their email. Must not
     *     be {@code null}.
     * @param emailVerified  Whether the user has verified their email address.
     * @param disabled  Whether the user has been disabled.
     * @param isTeammate  Whether this user is a teammate of the current user.
     *     If this account is the current user's account, then this will be
     *     {@code true}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BasicAccount(String accountId, Name name, String email, boolean emailVerified, boolean disabled, boolean isTeammate) {
        this(accountId, name, email, emailVerified, disabled, isTeammate, null, null);
    }

    /**
     * The user's unique Dropbox ID.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getAccountId() {
        return accountId;
    }

    /**
     * Details of a user's name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
    @javax.annotation.Nonnull
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
     * Whether this user is a teammate of the current user. If this account is
     * the current user's account, then this will be {@code true}.
     *
     * @return value for this field.
     */
    public boolean getIsTeammate() {
        return isTeammate;
    }

    /**
     * URL for the photo representing the user, if one is set.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    /**
     * The user's unique team member id. This field will only be present if the
     * user is part of a team and {@link BasicAccount#getIsTeammate} is {@code
     * true}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
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
     * @param isTeammate  Whether this user is a teammate of the current user.
     *     If this account is the current user's account, then this will be
     *     {@code true}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String accountId, Name name, String email, boolean emailVerified, boolean disabled, boolean isTeammate) {
        return new Builder(accountId, name, email, emailVerified, disabled, isTeammate);
    }

    /**
     * Builder for {@link BasicAccount}.
     */
    public static class Builder {
        protected final String accountId;
        protected final Name name;
        protected final String email;
        protected final boolean emailVerified;
        protected final boolean disabled;
        protected final boolean isTeammate;

        protected String profilePhotoUrl;
        protected String teamMemberId;

        protected Builder(String accountId, Name name, String email, boolean emailVerified, boolean disabled, boolean isTeammate) {
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
            return new BasicAccount(accountId, name, email, emailVerified, disabled, isTeammate, profilePhotoUrl, teamMemberId);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            BasicAccount other = (BasicAccount) obj;
            return ((this.accountId == other.accountId) || (this.accountId.equals(other.accountId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && (this.disabled == other.disabled)
                && (this.isTeammate == other.isTeammate)
                && ((this.profilePhotoUrl == other.profilePhotoUrl) || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(other.profilePhotoUrl)))
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
    public static class Serializer extends StructSerializer<BasicAccount> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(BasicAccount value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            g.writeFieldName("is_teammate");
            StoneSerializers.boolean_().serialize(value.isTeammate, g);
            if (value.profilePhotoUrl != null) {
                g.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.profilePhotoUrl, g);
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
        public BasicAccount deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            BasicAccount value;
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
                Boolean f_isTeammate = null;
                String f_profilePhotoUrl = null;
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
                    else if ("is_teammate".equals(field)) {
                        f_isTeammate = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("profile_photo_url".equals(field)) {
                        f_profilePhotoUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                if (f_isTeammate == null) {
                    throw new JsonParseException(p, "Required field \"is_teammate\" missing.");
                }
                value = new BasicAccount(f_accountId, f_name, f_email, f_emailVerified, f_disabled, f_isTeammate, f_profilePhotoUrl, f_teamMemberId);
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
