/* DO NOT EDIT */
/* This file was generated from shared_content_links.stone */

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
import java.util.List;

/**
 * Metadata of a shared link for a file or folder.
 */
public class SharedContentLinkMetadata extends SharedContentLinkMetadataBase {
    // struct sharing.SharedContentLinkMetadata (shared_content_links.stone)

    protected final AudienceExceptions audienceExceptions;
    protected final String url;

    /**
     * Metadata of a shared link for a file or folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param audienceOptions  The audience options that are available for the
     *     content. Some audience options may be unavailable. For example,
     *     team_only may be unavailable if the content is not owned by a user on
     *     a team. The 'default' audience option is always available if the user
     *     can modify link settings. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param currentAudience  The current audience of the link. Must not be
     *     {@code null}.
     * @param linkPermissions  A list of permissions for actions you can perform
     *     on the link. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param passwordProtected  Whether the link is protected by a password.
     * @param url  The URL of the link. Must not be {@code null}.
     * @param accessLevel  The access level on the link for this file.
     * @param audienceRestrictingSharedFolder  The shared folder that prevents
     *     the link audience for this link from being more restrictive.
     * @param expiry  Whether the link has an expiry set on it. A link with an
     *     expiry will have its  audience changed to members when the expiry is
     *     reached.
     * @param audienceExceptions  The content inside this folder with link
     *     audience different than this folder's. This is only returned when an
     *     endpoint that returns metadata for a single shared folder is called,
     *     e.g. /get_folder_metadata.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedContentLinkMetadata(List<LinkAudience> audienceOptions, LinkAudience currentAudience, List<LinkPermission> linkPermissions, boolean passwordProtected, String url, AccessLevel accessLevel, AudienceRestrictingSharedFolder audienceRestrictingSharedFolder, Date expiry, AudienceExceptions audienceExceptions) {
        super(audienceOptions, currentAudience, linkPermissions, passwordProtected, accessLevel, audienceRestrictingSharedFolder, expiry);
        this.audienceExceptions = audienceExceptions;
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
    }

    /**
     * Metadata of a shared link for a file or folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param audienceOptions  The audience options that are available for the
     *     content. Some audience options may be unavailable. For example,
     *     team_only may be unavailable if the content is not owned by a user on
     *     a team. The 'default' audience option is always available if the user
     *     can modify link settings. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param currentAudience  The current audience of the link. Must not be
     *     {@code null}.
     * @param linkPermissions  A list of permissions for actions you can perform
     *     on the link. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param passwordProtected  Whether the link is protected by a password.
     * @param url  The URL of the link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedContentLinkMetadata(List<LinkAudience> audienceOptions, LinkAudience currentAudience, List<LinkPermission> linkPermissions, boolean passwordProtected, String url) {
        this(audienceOptions, currentAudience, linkPermissions, passwordProtected, url, null, null, null, null);
    }

    /**
     * The audience options that are available for the content. Some audience
     * options may be unavailable. For example, team_only may be unavailable if
     * the content is not owned by a user on a team. The 'default' audience
     * option is always available if the user can modify link settings.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<LinkAudience> getAudienceOptions() {
        return audienceOptions;
    }

    /**
     * The current audience of the link.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public LinkAudience getCurrentAudience() {
        return currentAudience;
    }

    /**
     * A list of permissions for actions you can perform on the link.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<LinkPermission> getLinkPermissions() {
        return linkPermissions;
    }

    /**
     * Whether the link is protected by a password.
     *
     * @return value for this field.
     */
    public boolean getPasswordProtected() {
        return passwordProtected;
    }

    /**
     * The URL of the link.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * The access level on the link for this file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * The shared folder that prevents the link audience for this link from
     * being more restrictive.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public AudienceRestrictingSharedFolder getAudienceRestrictingSharedFolder() {
        return audienceRestrictingSharedFolder;
    }

    /**
     * Whether the link has an expiry set on it. A link with an expiry will have
     * its  audience changed to members when the expiry is reached.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getExpiry() {
        return expiry;
    }

    /**
     * The content inside this folder with link audience different than this
     * folder's. This is only returned when an endpoint that returns metadata
     * for a single shared folder is called, e.g. /get_folder_metadata.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public AudienceExceptions getAudienceExceptions() {
        return audienceExceptions;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param audienceOptions  The audience options that are available for the
     *     content. Some audience options may be unavailable. For example,
     *     team_only may be unavailable if the content is not owned by a user on
     *     a team. The 'default' audience option is always available if the user
     *     can modify link settings. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param currentAudience  The current audience of the link. Must not be
     *     {@code null}.
     * @param linkPermissions  A list of permissions for actions you can perform
     *     on the link. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param passwordProtected  Whether the link is protected by a password.
     * @param url  The URL of the link. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(List<LinkAudience> audienceOptions, LinkAudience currentAudience, List<LinkPermission> linkPermissions, boolean passwordProtected, String url) {
        return new Builder(audienceOptions, currentAudience, linkPermissions, passwordProtected, url);
    }

    /**
     * Builder for {@link SharedContentLinkMetadata}.
     */
    public static class Builder extends SharedContentLinkMetadataBase.Builder {
        protected final String url;

        protected AudienceExceptions audienceExceptions;

        protected Builder(List<LinkAudience> audienceOptions, LinkAudience currentAudience, List<LinkPermission> linkPermissions, boolean passwordProtected, String url) {
            super(audienceOptions, currentAudience, linkPermissions, passwordProtected);
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = url;
            this.audienceExceptions = null;
        }

        /**
         * Set value for optional field.
         *
         * @param audienceExceptions  The content inside this folder with link
         *     audience different than this folder's. This is only returned when
         *     an endpoint that returns metadata for a single shared folder is
         *     called, e.g. /get_folder_metadata.
         *
         * @return this builder
         */
        public Builder withAudienceExceptions(AudienceExceptions audienceExceptions) {
            this.audienceExceptions = audienceExceptions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param accessLevel  The access level on the link for this file.
         *
         * @return this builder
         */
        public Builder withAccessLevel(AccessLevel accessLevel) {
            super.withAccessLevel(accessLevel);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param audienceRestrictingSharedFolder  The shared folder that
         *     prevents the link audience for this link from being more
         *     restrictive.
         *
         * @return this builder
         */
        public Builder withAudienceRestrictingSharedFolder(AudienceRestrictingSharedFolder audienceRestrictingSharedFolder) {
            super.withAudienceRestrictingSharedFolder(audienceRestrictingSharedFolder);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param expiry  Whether the link has an expiry set on it. A link with
         *     an expiry will have its  audience changed to members when the
         *     expiry is reached.
         *
         * @return this builder
         */
        public Builder withExpiry(Date expiry) {
            super.withExpiry(expiry);
            return this;
        }

        /**
         * Builds an instance of {@link SharedContentLinkMetadata} configured
         * with this builder's values
         *
         * @return new instance of {@link SharedContentLinkMetadata}
         */
        public SharedContentLinkMetadata build() {
            return new SharedContentLinkMetadata(audienceOptions, currentAudience, linkPermissions, passwordProtected, url, accessLevel, audienceRestrictingSharedFolder, expiry, audienceExceptions);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            audienceExceptions,
            url
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
            SharedContentLinkMetadata other = (SharedContentLinkMetadata) obj;
            return ((this.audienceOptions == other.audienceOptions) || (this.audienceOptions.equals(other.audienceOptions)))
                && ((this.currentAudience == other.currentAudience) || (this.currentAudience.equals(other.currentAudience)))
                && ((this.linkPermissions == other.linkPermissions) || (this.linkPermissions.equals(other.linkPermissions)))
                && (this.passwordProtected == other.passwordProtected)
                && ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.accessLevel == other.accessLevel) || (this.accessLevel != null && this.accessLevel.equals(other.accessLevel)))
                && ((this.audienceRestrictingSharedFolder == other.audienceRestrictingSharedFolder) || (this.audienceRestrictingSharedFolder != null && this.audienceRestrictingSharedFolder.equals(other.audienceRestrictingSharedFolder)))
                && ((this.expiry == other.expiry) || (this.expiry != null && this.expiry.equals(other.expiry)))
                && ((this.audienceExceptions == other.audienceExceptions) || (this.audienceExceptions != null && this.audienceExceptions.equals(other.audienceExceptions)))
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
    static class Serializer extends StructSerializer<SharedContentLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentLinkMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("audience_options");
            StoneSerializers.list(LinkAudience.Serializer.INSTANCE).serialize(value.audienceOptions, g);
            g.writeFieldName("current_audience");
            LinkAudience.Serializer.INSTANCE.serialize(value.currentAudience, g);
            g.writeFieldName("link_permissions");
            StoneSerializers.list(LinkPermission.Serializer.INSTANCE).serialize(value.linkPermissions, g);
            g.writeFieldName("password_protected");
            StoneSerializers.boolean_().serialize(value.passwordProtected, g);
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            if (value.accessLevel != null) {
                g.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(value.accessLevel, g);
            }
            if (value.audienceRestrictingSharedFolder != null) {
                g.writeFieldName("audience_restricting_shared_folder");
                StoneSerializers.nullableStruct(AudienceRestrictingSharedFolder.Serializer.INSTANCE).serialize(value.audienceRestrictingSharedFolder, g);
            }
            if (value.expiry != null) {
                g.writeFieldName("expiry");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.expiry, g);
            }
            if (value.audienceExceptions != null) {
                g.writeFieldName("audience_exceptions");
                StoneSerializers.nullableStruct(AudienceExceptions.Serializer.INSTANCE).serialize(value.audienceExceptions, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentLinkMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentLinkMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<LinkAudience> f_audienceOptions = null;
                LinkAudience f_currentAudience = null;
                List<LinkPermission> f_linkPermissions = null;
                Boolean f_passwordProtected = null;
                String f_url = null;
                AccessLevel f_accessLevel = null;
                AudienceRestrictingSharedFolder f_audienceRestrictingSharedFolder = null;
                Date f_expiry = null;
                AudienceExceptions f_audienceExceptions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("audience_options".equals(field)) {
                        f_audienceOptions = StoneSerializers.list(LinkAudience.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("current_audience".equals(field)) {
                        f_currentAudience = LinkAudience.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("link_permissions".equals(field)) {
                        f_linkPermissions = StoneSerializers.list(LinkPermission.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("password_protected".equals(field)) {
                        f_passwordProtected = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("access_level".equals(field)) {
                        f_accessLevel = StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("audience_restricting_shared_folder".equals(field)) {
                        f_audienceRestrictingSharedFolder = StoneSerializers.nullableStruct(AudienceRestrictingSharedFolder.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("expiry".equals(field)) {
                        f_expiry = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("audience_exceptions".equals(field)) {
                        f_audienceExceptions = StoneSerializers.nullableStruct(AudienceExceptions.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_audienceOptions == null) {
                    throw new JsonParseException(p, "Required field \"audience_options\" missing.");
                }
                if (f_currentAudience == null) {
                    throw new JsonParseException(p, "Required field \"current_audience\" missing.");
                }
                if (f_linkPermissions == null) {
                    throw new JsonParseException(p, "Required field \"link_permissions\" missing.");
                }
                if (f_passwordProtected == null) {
                    throw new JsonParseException(p, "Required field \"password_protected\" missing.");
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                value = new SharedContentLinkMetadata(f_audienceOptions, f_currentAudience, f_linkPermissions, f_passwordProtected, f_url, f_accessLevel, f_audienceRestrictingSharedFolder, f_expiry, f_audienceExceptions);
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
