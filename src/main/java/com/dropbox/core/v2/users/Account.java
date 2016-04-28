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
 * The amount of detail revealed about an account depends on the user being
 * queried and the user making the query.
 */
@JsonSerialize(using=Account.Serializer.class)
@JsonDeserialize(using=Account.Deserializer.class)
public class Account {
    // struct Account

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String accountId;
    protected final Name name;
    protected final String email;
    protected final boolean emailVerified;
    protected final String profilePhotoUrl;
    protected final boolean disabled;

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
     * @param disabled  Whether the user has been disabled.
     * @param profilePhotoUrl  URL for the photo representing the user, if one
     *     is set.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Account(String accountId, Name name, String email, boolean emailVerified, boolean disabled, String profilePhotoUrl) {
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
        this.disabled = disabled;
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
     * @param disabled  Whether the user has been disabled.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Account(String accountId, Name name, String email, boolean emailVerified, boolean disabled) {
        this(accountId, name, email, emailVerified, disabled, null);
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

    /**
     * Whether the user has been disabled.
     *
     * @return value for this field.
     */
    public boolean getDisabled() {
        return disabled;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accountId,
            name,
            email,
            emailVerified,
            profilePhotoUrl,
            disabled
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
                && (this.disabled == other.disabled)
                && ((this.profilePhotoUrl == other.profilePhotoUrl) || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(other.profilePhotoUrl)))
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

    static final class Serializer extends StructJsonSerializer<Account> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(Account.class);
        }

        public Serializer(boolean unwrapping) {
            super(Account.class, unwrapping);
        }

        @Override
        protected JsonSerializer<Account> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(Account value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("account_id", value.accountId);
            g.writeObjectField("name", value.name);
            g.writeObjectField("email", value.email);
            g.writeObjectField("email_verified", value.emailVerified);
            g.writeObjectField("disabled", value.disabled);
            if (value.profilePhotoUrl != null) {
                g.writeObjectField("profile_photo_url", value.profilePhotoUrl);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<Account> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(Account.class);
        }

        public Deserializer(boolean unwrapping) {
            super(Account.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<Account> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public Account deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String accountId = null;
            Name name = null;
            String email = null;
            Boolean emailVerified = null;
            Boolean disabled = null;
            String profilePhotoUrl = null;

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
                else if ("disabled".equals(_field)) {
                    disabled = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("profile_photo_url".equals(_field)) {
                    profilePhotoUrl = getStringValue(_p);
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
            if (disabled == null) {
                throw new JsonParseException(_p, "Required field \"disabled\" is missing.");
            }

            return new Account(accountId, name, email, emailVerified, disabled, profilePhotoUrl);
        }
    }
}
