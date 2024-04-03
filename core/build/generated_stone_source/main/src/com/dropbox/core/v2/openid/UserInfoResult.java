/* DO NOT EDIT */
/* This file was generated from openid_openid_types.stone */

package com.dropbox.core.v2.openid;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UserInfoResult {
    // struct openid.UserInfoResult (openid_openid_types.stone)

    @Nullable
    protected final String familyName;
    @Nullable
    protected final String givenName;
    @Nullable
    protected final String email;
    @Nullable
    protected final Boolean emailVerified;
    @Nonnull
    protected final String iss;
    @Nonnull
    protected final String sub;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param familyName  Last name of user.
     * @param givenName  First name of user.
     * @param email  Email address of user.
     * @param emailVerified  If user is email verified.
     * @param iss  Issuer of token (in this case Dropbox). Must not be {@code
     *     null}.
     * @param sub  An identifier for the user. This is the Dropbox account_id, a
     *     string value such as dbid:AAH4f99T0taONIb-OurWxbNQ6ywGRopQngc. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserInfoResult(@Nullable String familyName, @Nullable String givenName, @Nullable String email, @Nullable Boolean emailVerified, @Nonnull String iss, @Nonnull String sub) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.email = email;
        this.emailVerified = emailVerified;
        if (iss == null) {
            throw new IllegalArgumentException("Required value for 'iss' is null");
        }
        this.iss = iss;
        if (sub == null) {
            throw new IllegalArgumentException("Required value for 'sub' is null");
        }
        this.sub = sub;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public UserInfoResult() {
        this(null, null, null, null, "", "");
    }

    /**
     * Last name of user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getFamilyName() {
        return familyName;
    }

    /**
     * First name of user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getGivenName() {
        return givenName;
    }

    /**
     * Email address of user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getEmail() {
        return email;
    }

    /**
     * If user is email verified.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     * Issuer of token (in this case Dropbox).
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     "".
     */
    @Nonnull
    public String getIss() {
        return iss;
    }

    /**
     * An identifier for the user. This is the Dropbox account_id, a string
     * value such as dbid:AAH4f99T0taONIb-OurWxbNQ6ywGRopQngc.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     "".
     */
    @Nonnull
    public String getSub() {
        return sub;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link UserInfoResult}.
     */
    public static class Builder {

        protected String familyName;
        protected String givenName;
        protected String email;
        protected Boolean emailVerified;
        protected String iss;
        protected String sub;

        protected Builder() {
            this.familyName = null;
            this.givenName = null;
            this.email = null;
            this.emailVerified = null;
            this.iss = "";
            this.sub = "";
        }

        /**
         * Set value for optional field.
         *
         * @param familyName  Last name of user.
         *
         * @return this builder
         */
        public Builder withFamilyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param givenName  First name of user.
         *
         * @return this builder
         */
        public Builder withGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param email  Email address of user.
         *
         * @return this builder
         */
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param emailVerified  If user is email verified.
         *
         * @return this builder
         */
        public Builder withEmailVerified(Boolean emailVerified) {
            this.emailVerified = emailVerified;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code ""}.
         * </p>
         *
         * @param iss  Issuer of token (in this case Dropbox). Must not be
         *     {@code null}. Defaults to {@code ""} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withIss(String iss) {
            if (iss != null) {
                this.iss = iss;
            }
            else {
                this.iss = "";
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code ""}.
         * </p>
         *
         * @param sub  An identifier for the user. This is the Dropbox
         *     account_id, a string value such as
         *     dbid:AAH4f99T0taONIb-OurWxbNQ6ywGRopQngc. Must not be {@code
         *     null}. Defaults to {@code ""} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSub(String sub) {
            if (sub != null) {
                this.sub = sub;
            }
            else {
                this.sub = "";
            }
            return this;
        }

        /**
         * Builds an instance of {@link UserInfoResult} configured with this
         * builder's values
         *
         * @return new instance of {@link UserInfoResult}
         */
        public UserInfoResult build() {
            return new UserInfoResult(familyName, givenName, email, emailVerified, iss, sub);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.familyName,
            this.givenName,
            this.email,
            this.emailVerified,
            this.iss,
            this.sub
        });
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
            UserInfoResult other = (UserInfoResult) obj;
            return ((this.familyName == other.familyName) || (this.familyName != null && this.familyName.equals(other.familyName)))
                && ((this.givenName == other.givenName) || (this.givenName != null && this.givenName.equals(other.givenName)))
                && ((this.email == other.email) || (this.email != null && this.email.equals(other.email)))
                && ((this.emailVerified == other.emailVerified) || (this.emailVerified != null && this.emailVerified.equals(other.emailVerified)))
                && ((this.iss == other.iss) || (this.iss.equals(other.iss)))
                && ((this.sub == other.sub) || (this.sub.equals(other.sub)))
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
    static class Serializer extends StructSerializer<UserInfoResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserInfoResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.familyName != null) {
                g.writeFieldName("family_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.familyName, g);
            }
            if (value.givenName != null) {
                g.writeFieldName("given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.givenName, g);
            }
            if (value.email != null) {
                g.writeFieldName("email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.email, g);
            }
            if (value.emailVerified != null) {
                g.writeFieldName("email_verified");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.emailVerified, g);
            }
            g.writeFieldName("iss");
            StoneSerializers.string().serialize(value.iss, g);
            g.writeFieldName("sub");
            StoneSerializers.string().serialize(value.sub, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserInfoResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserInfoResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_familyName = null;
                String f_givenName = null;
                String f_email = null;
                Boolean f_emailVerified = null;
                String f_iss = "";
                String f_sub = "";
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("family_name".equals(field)) {
                        f_familyName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("given_name".equals(field)) {
                        f_givenName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("email".equals(field)) {
                        f_email = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("email_verified".equals(field)) {
                        f_emailVerified = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("iss".equals(field)) {
                        f_iss = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sub".equals(field)) {
                        f_sub = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new UserInfoResult(f_familyName, f_givenName, f_email, f_emailVerified, f_iss, f_sub);
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
