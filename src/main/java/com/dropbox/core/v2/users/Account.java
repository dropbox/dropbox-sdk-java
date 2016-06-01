/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * The amount of detail revealed about an account depends on the user being
 * queried and the user making the query.
 */
public class Account {
    // struct Account

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
    static final class Serializer extends StructSerializer<Account> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Account value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (value.profilePhotoUrl != null) {
                g.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.profilePhotoUrl, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Account deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Account value;
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
                String f_profilePhotoUrl = null;
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
                    else if ("profile_photo_url".equals(field)) {
                        f_profilePhotoUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new Account(f_accountId, f_name, f_email, f_emailVerified, f_disabled, f_profilePhotoUrl);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
