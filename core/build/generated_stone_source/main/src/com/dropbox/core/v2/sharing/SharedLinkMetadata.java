/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * The metadata of a shared link.
 */
public class SharedLinkMetadata {
    // struct sharing.SharedLinkMetadata (shared_links.stone)

    protected final String url;
    protected final String id;
    protected final String name;
    protected final Date expires;
    protected final String pathLower;
    protected final LinkPermissions linkPermissions;
    protected final TeamMemberInfo teamMemberInfo;
    protected final Team contentOwnerTeamInfo;

    /**
     * The metadata of a shared link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     * @param id  A unique identifier for the linked file. Must have length of
     *     at least 1.
     * @param expires  Expiration time, if set. By default the link won't
     *     expire.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. This field will only be present only if
     *     the linked file is in the authenticated user's  dropbox.
     * @param teamMemberInfo  The team membership information of the link's
     *     owner.  This field will only be present  if the link's owner is a
     *     team member.
     * @param contentOwnerTeamInfo  The team information of the content's owner.
     *     This field will only be present if the content's owner is a team
     *     member and the content's owner team is different from the link's
     *     owner team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata(@javax.annotation.Nonnull String url, @javax.annotation.Nonnull String name, @javax.annotation.Nonnull LinkPermissions linkPermissions, @javax.annotation.Nullable String id, @javax.annotation.Nullable Date expires, @javax.annotation.Nullable String pathLower, @javax.annotation.Nullable TeamMemberInfo teamMemberInfo, @javax.annotation.Nullable Team contentOwnerTeamInfo) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (id != null) {
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
        }
        this.id = id;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.expires = LangUtil.truncateMillis(expires);
        this.pathLower = pathLower;
        if (linkPermissions == null) {
            throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
        }
        this.linkPermissions = linkPermissions;
        this.teamMemberInfo = teamMemberInfo;
        this.contentOwnerTeamInfo = contentOwnerTeamInfo;
    }

    /**
     * The metadata of a shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata(String url, String name, LinkPermissions linkPermissions) {
        this(url, name, linkPermissions, null, null, null, null, null);
    }

    /**
     * URL of the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * The linked file name (including extension). This never contains a slash.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    /**
     * The link's access permissions.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public LinkPermissions getLinkPermissions() {
        return linkPermissions;
    }

    /**
     * A unique identifier for the linked file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getId() {
        return id;
    }

    /**
     * Expiration time, if set. By default the link won't expire.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getExpires() {
        return expires;
    }

    /**
     * The lowercased full path in the user's Dropbox. This always starts with a
     * slash. This field will only be present only if the linked file is in the
     * authenticated user's  dropbox.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The team membership information of the link's owner.  This field will
     * only be present  if the link's owner is a team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public TeamMemberInfo getTeamMemberInfo() {
        return teamMemberInfo;
    }

    /**
     * The team information of the content's owner. This field will only be
     * present if the content's owner is a team member and the content's owner
     * team is different from the link's owner team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Team getContentOwnerTeamInfo() {
        return contentOwnerTeamInfo;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String url, String name, LinkPermissions linkPermissions) {
        return new Builder(url, name, linkPermissions);
    }

    /**
     * Builder for {@link SharedLinkMetadata}.
     */
    public static class Builder {
        protected final String url;
        protected final String name;
        protected final LinkPermissions linkPermissions;

        protected String id;
        protected Date expires;
        protected String pathLower;
        protected TeamMemberInfo teamMemberInfo;
        protected Team contentOwnerTeamInfo;

        protected Builder(String url, String name, LinkPermissions linkPermissions) {
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = url;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (linkPermissions == null) {
                throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
            }
            this.linkPermissions = linkPermissions;
            this.id = null;
            this.expires = null;
            this.pathLower = null;
            this.teamMemberInfo = null;
            this.contentOwnerTeamInfo = null;
        }

        /**
         * Set value for optional field.
         *
         * @param id  A unique identifier for the linked file. Must have length
         *     of at least 1.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withId(String id) {
            if (id != null) {
                if (id.length() < 1) {
                    throw new IllegalArgumentException("String 'id' is shorter than 1");
                }
            }
            this.id = id;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param expires  Expiration time, if set. By default the link won't
         *     expire.
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
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. This field will only be present
         *     only if the linked file is in the authenticated user's  dropbox.
         *
         * @return this builder
         */
        public Builder withPathLower(String pathLower) {
            this.pathLower = pathLower;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param teamMemberInfo  The team membership information of the link's
         *     owner.  This field will only be present  if the link's owner is a
         *     team member.
         *
         * @return this builder
         */
        public Builder withTeamMemberInfo(TeamMemberInfo teamMemberInfo) {
            this.teamMemberInfo = teamMemberInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param contentOwnerTeamInfo  The team information of the content's
         *     owner. This field will only be present if the content's owner is
         *     a team member and the content's owner team is different from the
         *     link's owner team.
         *
         * @return this builder
         */
        public Builder withContentOwnerTeamInfo(Team contentOwnerTeamInfo) {
            this.contentOwnerTeamInfo = contentOwnerTeamInfo;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link SharedLinkMetadata}
         */
        public SharedLinkMetadata build() {
            return new SharedLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            url,
            id,
            name,
            expires,
            pathLower,
            linkPermissions,
            teamMemberInfo,
            contentOwnerTeamInfo
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
            SharedLinkMetadata other = (SharedLinkMetadata) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.linkPermissions == other.linkPermissions) || (this.linkPermissions.equals(other.linkPermissions)))
                && ((this.id == other.id) || (this.id != null && this.id.equals(other.id)))
                && ((this.expires == other.expires) || (this.expires != null && this.expires.equals(other.expires)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.teamMemberInfo == other.teamMemberInfo) || (this.teamMemberInfo != null && this.teamMemberInfo.equals(other.teamMemberInfo)))
                && ((this.contentOwnerTeamInfo == other.contentOwnerTeamInfo) || (this.contentOwnerTeamInfo != null && this.contentOwnerTeamInfo.equals(other.contentOwnerTeamInfo)))
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
    static class Serializer extends StructSerializer<SharedLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (value instanceof FileLinkMetadata) {
                FileLinkMetadata.Serializer.INSTANCE.serialize((FileLinkMetadata) value, g, collapse);
                return;
            }
            if (value instanceof FolderLinkMetadata) {
                FolderLinkMetadata.Serializer.INSTANCE.serialize((FolderLinkMetadata) value, g, collapse);
                return;
            }
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("link_permissions");
            LinkPermissions.Serializer.INSTANCE.serialize(value.linkPermissions, g);
            if (value.id != null) {
                g.writeFieldName("id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.id, g);
            }
            if (value.expires != null) {
                g.writeFieldName("expires");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.expires, g);
            }
            if (value.pathLower != null) {
                g.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathLower, g);
            }
            if (value.teamMemberInfo != null) {
                g.writeFieldName("team_member_info");
                StoneSerializers.nullableStruct(TeamMemberInfo.Serializer.INSTANCE).serialize(value.teamMemberInfo, g);
            }
            if (value.contentOwnerTeamInfo != null) {
                g.writeFieldName("content_owner_team_info");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(value.contentOwnerTeamInfo, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_url = null;
                String f_name = null;
                LinkPermissions f_linkPermissions = null;
                String f_id = null;
                Date f_expires = null;
                String f_pathLower = null;
                TeamMemberInfo f_teamMemberInfo = null;
                Team f_contentOwnerTeamInfo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("link_permissions".equals(field)) {
                        f_linkPermissions = LinkPermissions.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("id".equals(field)) {
                        f_id = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("expires".equals(field)) {
                        f_expires = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("path_lower".equals(field)) {
                        f_pathLower = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("team_member_info".equals(field)) {
                        f_teamMemberInfo = StoneSerializers.nullableStruct(TeamMemberInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("content_owner_team_info".equals(field)) {
                        f_contentOwnerTeamInfo = StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_linkPermissions == null) {
                    throw new JsonParseException(p, "Required field \"link_permissions\" missing.");
                }
                value = new SharedLinkMetadata(f_url, f_name, f_linkPermissions, f_id, f_expires, f_pathLower, f_teamMemberInfo, f_contentOwnerTeamInfo);
            }
            else if ("".equals(tag)) {
                value = Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("file".equals(tag)) {
                value = FileLinkMetadata.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("folder".equals(tag)) {
                value = FolderLinkMetadata.Serializer.INSTANCE.deserialize(p, true);
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
