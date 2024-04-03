/* DO NOT EDIT */
/* This file was generated from shared_content_links.stone */

package com.dropbox.core.v2.sharing;

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

/**
 * Settings that apply to a link.
 */
public class LinkSettings {
    // struct sharing.LinkSettings (shared_content_links.stone)

    @Nullable
    protected final AccessLevel accessLevel;
    @Nullable
    protected final LinkAudience audience;
    @Nullable
    protected final LinkExpiry expiry;
    @Nullable
    protected final LinkPassword password;

    /**
     * Settings that apply to a link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessLevel  The access level on the link for this file.
     *     Currently, it only accepts 'viewer' and 'viewer_no_comment'.
     * @param audience  The type of audience on the link for this file.
     * @param expiry  An expiry timestamp to set on a link.
     * @param password  The password for the link.
     */
    public LinkSettings(@Nullable AccessLevel accessLevel, @Nullable LinkAudience audience, @Nullable LinkExpiry expiry, @Nullable LinkPassword password) {
        this.accessLevel = accessLevel;
        this.audience = audience;
        this.expiry = expiry;
        this.password = password;
    }

    /**
     * Settings that apply to a link.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public LinkSettings() {
        this(null, null, null, null);
    }

    /**
     * The access level on the link for this file. Currently, it only accepts
     * 'viewer' and 'viewer_no_comment'.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * The type of audience on the link for this file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public LinkAudience getAudience() {
        return audience;
    }

    /**
     * An expiry timestamp to set on a link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public LinkExpiry getExpiry() {
        return expiry;
    }

    /**
     * The password for the link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public LinkPassword getPassword() {
        return password;
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
     * Builder for {@link LinkSettings}.
     */
    public static class Builder {

        protected AccessLevel accessLevel;
        protected LinkAudience audience;
        protected LinkExpiry expiry;
        protected LinkPassword password;

        protected Builder() {
            this.accessLevel = null;
            this.audience = null;
            this.expiry = null;
            this.password = null;
        }

        /**
         * Set value for optional field.
         *
         * @param accessLevel  The access level on the link for this file.
         *     Currently, it only accepts 'viewer' and 'viewer_no_comment'.
         *
         * @return this builder
         */
        public Builder withAccessLevel(AccessLevel accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param audience  The type of audience on the link for this file.
         *
         * @return this builder
         */
        public Builder withAudience(LinkAudience audience) {
            this.audience = audience;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param expiry  An expiry timestamp to set on a link.
         *
         * @return this builder
         */
        public Builder withExpiry(LinkExpiry expiry) {
            this.expiry = expiry;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param password  The password for the link.
         *
         * @return this builder
         */
        public Builder withPassword(LinkPassword password) {
            this.password = password;
            return this;
        }

        /**
         * Builds an instance of {@link LinkSettings} configured with this
         * builder's values
         *
         * @return new instance of {@link LinkSettings}
         */
        public LinkSettings build() {
            return new LinkSettings(accessLevel, audience, expiry, password);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.accessLevel,
            this.audience,
            this.expiry,
            this.password
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
            LinkSettings other = (LinkSettings) obj;
            return ((this.accessLevel == other.accessLevel) || (this.accessLevel != null && this.accessLevel.equals(other.accessLevel)))
                && ((this.audience == other.audience) || (this.audience != null && this.audience.equals(other.audience)))
                && ((this.expiry == other.expiry) || (this.expiry != null && this.expiry.equals(other.expiry)))
                && ((this.password == other.password) || (this.password != null && this.password.equals(other.password)))
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
    static class Serializer extends StructSerializer<LinkSettings> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkSettings value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.accessLevel != null) {
                g.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(value.accessLevel, g);
            }
            if (value.audience != null) {
                g.writeFieldName("audience");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(value.audience, g);
            }
            if (value.expiry != null) {
                g.writeFieldName("expiry");
                StoneSerializers.nullable(LinkExpiry.Serializer.INSTANCE).serialize(value.expiry, g);
            }
            if (value.password != null) {
                g.writeFieldName("password");
                StoneSerializers.nullable(LinkPassword.Serializer.INSTANCE).serialize(value.password, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LinkSettings deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LinkSettings value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_accessLevel = null;
                LinkAudience f_audience = null;
                LinkExpiry f_expiry = null;
                LinkPassword f_password = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_level".equals(field)) {
                        f_accessLevel = StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("audience".equals(field)) {
                        f_audience = StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("expiry".equals(field)) {
                        f_expiry = StoneSerializers.nullable(LinkExpiry.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("password".equals(field)) {
                        f_password = StoneSerializers.nullable(LinkPassword.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new LinkSettings(f_accessLevel, f_audience, f_expiry, f_password);
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
