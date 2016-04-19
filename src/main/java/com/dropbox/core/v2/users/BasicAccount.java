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
 * Basic information about any account.
 */
@JsonSerialize(using=BasicAccount.Serializer.class)
@JsonDeserialize(using=BasicAccount.Deserializer.class)
public class BasicAccount extends Account {
    // struct BasicAccount

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
            return ((this.accountId == other.accountId) || (this.accountId.equals(other.accountId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
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

    static final class Serializer extends StructJsonSerializer<BasicAccount> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(BasicAccount.class);
        }

        public Serializer(boolean unwrapping) {
            super(BasicAccount.class, unwrapping);
        }

        @Override
        protected JsonSerializer<BasicAccount> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(BasicAccount value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("account_id", value.accountId);
            g.writeObjectField("name", value.name);
            g.writeObjectField("email", value.email);
            g.writeObjectField("email_verified", value.emailVerified);
            g.writeObjectField("is_teammate", value.isTeammate);
            if (value.profilePhotoUrl != null) {
                g.writeObjectField("profile_photo_url", value.profilePhotoUrl);
            }
            if (value.teamMemberId != null) {
                g.writeObjectField("team_member_id", value.teamMemberId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<BasicAccount> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(BasicAccount.class);
        }

        public Deserializer(boolean unwrapping) {
            super(BasicAccount.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<BasicAccount> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public BasicAccount deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String accountId = null;
            Name name = null;
            String email = null;
            Boolean emailVerified = null;
            Boolean isTeammate = null;
            String profilePhotoUrl = null;
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
                else if ("is_teammate".equals(_field)) {
                    isTeammate = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("profile_photo_url".equals(_field)) {
                    profilePhotoUrl = getStringValue(_p);
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
            if (isTeammate == null) {
                throw new JsonParseException(_p, "Required field \"is_teammate\" is missing.");
            }

            return new BasicAccount(accountId, name, email, emailVerified, isTeammate, profilePhotoUrl, teamMemberId);
        }
    }
}
