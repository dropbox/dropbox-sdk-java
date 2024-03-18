/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SharedLinkSettings {
    // struct sharing.SharedLinkSettings (shared_links.stone)

    @Nullable
    protected final Boolean requirePassword;
    @Nullable
    protected final String linkPassword;
    @Nullable
    protected final Date expires;
    @Nullable
    protected final LinkAudience audience;
    @Nullable
    protected final RequestedLinkAccessLevel access;
    @Nullable
    protected final RequestedVisibility requestedVisibility;
    @Nullable
    protected final Boolean allowDownload;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param requirePassword  Boolean flag to enable or disable password
     *     protection.
     * @param linkPassword  If {@link SharedLinkSettings#getRequirePassword} is
     *     true, this is needed to specify the password to access the link.
     * @param expires  Expiration time of the shared link. By default the link
     *     won't expire.
     * @param audience  The new audience who can benefit from the access level
     *     specified by the link's access level specified in the
     *     `link_access_level` field of `LinkPermissions`. This is used in
     *     conjunction with team policies and shared folder policies to
     *     determine the final effective audience type in the
     *     `effective_audience` field of `LinkPermissions.
     * @param access  Requested access level you want the audience to gain from
     *     this link. Note, modifying access level for an existing link is not
     *     supported.
     * @param requestedVisibility  Use {@link SharedLinkSettings#getAudience}
     *     instead.  The requested access for this shared link.
     * @param allowDownload  Boolean flag to allow or not download capabilities
     *     for shared links.
     */
    public SharedLinkSettings(@Nullable Boolean requirePassword, @Nullable String linkPassword, @Nullable Date expires, @Nullable LinkAudience audience, @Nullable RequestedLinkAccessLevel access, @Nullable RequestedVisibility requestedVisibility, @Nullable Boolean allowDownload) {
        this.requirePassword = requirePassword;
        this.linkPassword = linkPassword;
        this.expires = LangUtil.truncateMillis(expires);
        this.audience = audience;
        this.access = access;
        this.requestedVisibility = requestedVisibility;
        this.allowDownload = allowDownload;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedLinkSettings() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * Boolean flag to enable or disable password protection.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getRequirePassword() {
        return requirePassword;
    }

    /**
     * If {@link SharedLinkSettings#getRequirePassword} is true, this is needed
     * to specify the password to access the link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getLinkPassword() {
        return linkPassword;
    }

    /**
     * Expiration time of the shared link. By default the link won't expire.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getExpires() {
        return expires;
    }

    /**
     * The new audience who can benefit from the access level specified by the
     * link's access level specified in the `link_access_level` field of
     * `LinkPermissions`. This is used in conjunction with team policies and
     * shared folder policies to determine the final effective audience type in
     * the `effective_audience` field of `LinkPermissions.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public LinkAudience getAudience() {
        return audience;
    }

    /**
     * Requested access level you want the audience to gain from this link.
     * Note, modifying access level for an existing link is not supported.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public RequestedLinkAccessLevel getAccess() {
        return access;
    }

    /**
     * Use {@link SharedLinkSettings#getAudience} instead.  The requested access
     * for this shared link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public RequestedVisibility getRequestedVisibility() {
        return requestedVisibility;
    }

    /**
     * Boolean flag to allow or not download capabilities for shared links.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getAllowDownload() {
        return allowDownload;
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
     * Builder for {@link SharedLinkSettings}.
     */
    public static class Builder {

        protected Boolean requirePassword;
        protected String linkPassword;
        protected Date expires;
        protected LinkAudience audience;
        protected RequestedLinkAccessLevel access;
        protected RequestedVisibility requestedVisibility;
        protected Boolean allowDownload;

        protected Builder() {
            this.requirePassword = null;
            this.linkPassword = null;
            this.expires = null;
            this.audience = null;
            this.access = null;
            this.requestedVisibility = null;
            this.allowDownload = null;
        }

        /**
         * Set value for optional field.
         *
         * @param requirePassword  Boolean flag to enable or disable password
         *     protection.
         *
         * @return this builder
         */
        public Builder withRequirePassword(Boolean requirePassword) {
            this.requirePassword = requirePassword;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linkPassword  If {@link SharedLinkSettings#getRequirePassword}
         *     is true, this is needed to specify the password to access the
         *     link.
         *
         * @return this builder
         */
        public Builder withLinkPassword(String linkPassword) {
            this.linkPassword = linkPassword;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param expires  Expiration time of the shared link. By default the
         *     link won't expire.
         *
         * @return this builder
         */
        public Builder withExpires(Date expires) {
            this.expires = LangUtil.truncateMillis(expires);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param audience  The new audience who can benefit from the access
         *     level specified by the link's access level specified in the
         *     `link_access_level` field of `LinkPermissions`. This is used in
         *     conjunction with team policies and shared folder policies to
         *     determine the final effective audience type in the
         *     `effective_audience` field of `LinkPermissions.
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
         * @param access  Requested access level you want the audience to gain
         *     from this link. Note, modifying access level for an existing link
         *     is not supported.
         *
         * @return this builder
         */
        public Builder withAccess(RequestedLinkAccessLevel access) {
            this.access = access;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param requestedVisibility  Use {@link
         *     SharedLinkSettings#getAudience} instead.  The requested access
         *     for this shared link.
         *
         * @return this builder
         */
        public Builder withRequestedVisibility(RequestedVisibility requestedVisibility) {
            this.requestedVisibility = requestedVisibility;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param allowDownload  Boolean flag to allow or not download
         *     capabilities for shared links.
         *
         * @return this builder
         */
        public Builder withAllowDownload(Boolean allowDownload) {
            this.allowDownload = allowDownload;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkSettings} configured with this
         * builder's values
         *
         * @return new instance of {@link SharedLinkSettings}
         */
        public SharedLinkSettings build() {
            return new SharedLinkSettings(requirePassword, linkPassword, expires, audience, access, requestedVisibility, allowDownload);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            requirePassword,
            linkPassword,
            expires,
            audience,
            access,
            requestedVisibility,
            allowDownload
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
            SharedLinkSettings other = (SharedLinkSettings) obj;
            return ((this.requirePassword == other.requirePassword) || (this.requirePassword != null && this.requirePassword.equals(other.requirePassword)))
                && ((this.linkPassword == other.linkPassword) || (this.linkPassword != null && this.linkPassword.equals(other.linkPassword)))
                && ((this.expires == other.expires) || (this.expires != null && this.expires.equals(other.expires)))
                && ((this.audience == other.audience) || (this.audience != null && this.audience.equals(other.audience)))
                && ((this.access == other.access) || (this.access != null && this.access.equals(other.access)))
                && ((this.requestedVisibility == other.requestedVisibility) || (this.requestedVisibility != null && this.requestedVisibility.equals(other.requestedVisibility)))
                && ((this.allowDownload == other.allowDownload) || (this.allowDownload != null && this.allowDownload.equals(other.allowDownload)))
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
    static class Serializer extends StructSerializer<SharedLinkSettings> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkSettings value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.requirePassword != null) {
                g.writeFieldName("require_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.requirePassword, g);
            }
            if (value.linkPassword != null) {
                g.writeFieldName("link_password");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.linkPassword, g);
            }
            if (value.expires != null) {
                g.writeFieldName("expires");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.expires, g);
            }
            if (value.audience != null) {
                g.writeFieldName("audience");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(value.audience, g);
            }
            if (value.access != null) {
                g.writeFieldName("access");
                StoneSerializers.nullable(RequestedLinkAccessLevel.Serializer.INSTANCE).serialize(value.access, g);
            }
            if (value.requestedVisibility != null) {
                g.writeFieldName("requested_visibility");
                StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).serialize(value.requestedVisibility, g);
            }
            if (value.allowDownload != null) {
                g.writeFieldName("allow_download");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.allowDownload, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkSettings deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkSettings value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_requirePassword = null;
                String f_linkPassword = null;
                Date f_expires = null;
                LinkAudience f_audience = null;
                RequestedLinkAccessLevel f_access = null;
                RequestedVisibility f_requestedVisibility = null;
                Boolean f_allowDownload = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("require_password".equals(field)) {
                        f_requirePassword = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("link_password".equals(field)) {
                        f_linkPassword = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("expires".equals(field)) {
                        f_expires = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("audience".equals(field)) {
                        f_audience = StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("access".equals(field)) {
                        f_access = StoneSerializers.nullable(RequestedLinkAccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("requested_visibility".equals(field)) {
                        f_requestedVisibility = StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("allow_download".equals(field)) {
                        f_allowDownload = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedLinkSettings(f_requirePassword, f_linkPassword, f_expires, f_audience, f_access, f_requestedVisibility, f_allowDownload);
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
