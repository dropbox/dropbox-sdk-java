/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * The metadata of a file shared link
 */
public class FileLinkMetadata extends SharedLinkMetadata {
    // struct FileLinkMetadata

    protected final Date clientModified;
    protected final Date serverModified;
    protected final String rev;
    protected final long size;

    /**
     * The metadata of a file shared link
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     * @param clientModified  The modification time set by the desktop client
     *     when the file was added to Dropbox. Since this time is not verified
     *     (the Dropbox server stores whatever the desktop client sends up),
     *     this should only be used for display purposes (such as sorting) and
     *     not, for example, to determine if a file has changed or not. Must not
     *     be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param size  The file size in bytes.
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
    public FileLinkMetadata(String url, String name, LinkPermissions linkPermissions, Date clientModified, Date serverModified, String rev, long size, String id, Date expires, String pathLower, TeamMemberInfo teamMemberInfo, Team contentOwnerTeamInfo) {
        super(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        if (clientModified == null) {
            throw new IllegalArgumentException("Required value for 'clientModified' is null");
        }
        this.clientModified = com.dropbox.core.util.LangUtil.truncateMillis(clientModified);
        if (serverModified == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = com.dropbox.core.util.LangUtil.truncateMillis(serverModified);
        if (rev == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (rev.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = rev;
        this.size = size;
    }

    /**
     * The metadata of a file shared link
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     * @param clientModified  The modification time set by the desktop client
     *     when the file was added to Dropbox. Since this time is not verified
     *     (the Dropbox server stores whatever the desktop client sends up),
     *     this should only be used for display purposes (such as sorting) and
     *     not, for example, to determine if a file has changed or not. Must not
     *     be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param size  The file size in bytes.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileLinkMetadata(String url, String name, LinkPermissions linkPermissions, Date clientModified, Date serverModified, String rev, long size) {
        this(url, name, linkPermissions, clientModified, serverModified, rev, size, null, null, null, null, null);
    }

    /**
     * The modification time set by the desktop client when the file was added
     * to Dropbox. Since this time is not verified (the Dropbox server stores
     * whatever the desktop client sends up), this should only be used for
     * display purposes (such as sorting) and not, for example, to determine if
     * a file has changed or not.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getClientModified() {
        return clientModified;
    }

    /**
     * The last time the file was modified on Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getServerModified() {
        return serverModified;
    }

    /**
     * A unique identifier for the current revision of a file. This field is the
     * same rev as elsewhere in the API and can be used to detect changes and
     * avoid conflicts.
     *
     * @return value for this field, never {@code null}.
     */
    public String getRev() {
        return rev;
    }

    /**
     * The file size in bytes.
     *
     * @return value for this field.
     */
    public long getSize() {
        return size;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     * @param clientModified  The modification time set by the desktop client
     *     when the file was added to Dropbox. Since this time is not verified
     *     (the Dropbox server stores whatever the desktop client sends up),
     *     this should only be used for display purposes (such as sorting) and
     *     not, for example, to determine if a file has changed or not. Must not
     *     be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param size  The file size in bytes.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String url, String name, LinkPermissions linkPermissions, Date clientModified, Date serverModified, String rev, long size) {
        return new Builder(url, name, linkPermissions, clientModified, serverModified, rev, size);
    }

    /**
     * Builder for {@link FileLinkMetadata}.
     */
    public static class Builder extends SharedLinkMetadata.Builder {
        protected final Date clientModified;
        protected final Date serverModified;
        protected final String rev;
        protected final long size;

        protected Builder(String url, String name, LinkPermissions linkPermissions, Date clientModified, Date serverModified, String rev, long size) {
            super(url, name, linkPermissions);
            if (clientModified == null) {
                throw new IllegalArgumentException("Required value for 'clientModified' is null");
            }
            this.clientModified = com.dropbox.core.util.LangUtil.truncateMillis(clientModified);
            if (serverModified == null) {
                throw new IllegalArgumentException("Required value for 'serverModified' is null");
            }
            this.serverModified = com.dropbox.core.util.LangUtil.truncateMillis(serverModified);
            if (rev == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.rev = rev;
            this.size = size;
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
            super.withId(id);
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
            super.withExpires(expires);
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
            super.withPathLower(pathLower);
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
            super.withTeamMemberInfo(teamMemberInfo);
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
            super.withContentOwnerTeamInfo(contentOwnerTeamInfo);
            return this;
        }

        /**
         * Builds an instance of {@link FileLinkMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FileLinkMetadata}
         */
        public FileLinkMetadata build() {
            return new FileLinkMetadata(url, name, linkPermissions, clientModified, serverModified, rev, size, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            clientModified,
            serverModified,
            rev,
            size
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
            FileLinkMetadata other = (FileLinkMetadata) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.linkPermissions == other.linkPermissions) || (this.linkPermissions.equals(other.linkPermissions)))
                && ((this.clientModified == other.clientModified) || (this.clientModified.equals(other.clientModified)))
                && ((this.serverModified == other.serverModified) || (this.serverModified.equals(other.serverModified)))
                && ((this.rev == other.rev) || (this.rev.equals(other.rev)))
                && (this.size == other.size)
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
    static final class Serializer extends StructSerializer<FileLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileLinkMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("file", g);
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("link_permissions");
            LinkPermissions.Serializer.INSTANCE.serialize(value.linkPermissions, g);
            g.writeFieldName("client_modified");
            StoneSerializers.timestamp().serialize(value.clientModified, g);
            g.writeFieldName("server_modified");
            StoneSerializers.timestamp().serialize(value.serverModified, g);
            g.writeFieldName("rev");
            StoneSerializers.string().serialize(value.rev, g);
            g.writeFieldName("size");
            StoneSerializers.uInt64().serialize(value.size, g);
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
                StoneSerializers.nullable(TeamMemberInfo.Serializer.INSTANCE).serialize(value.teamMemberInfo, g);
            }
            if (value.contentOwnerTeamInfo != null) {
                g.writeFieldName("content_owner_team_info");
                StoneSerializers.nullable(Team.Serializer.INSTANCE).serialize(value.contentOwnerTeamInfo, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileLinkMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileLinkMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("file".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_url = null;
                String f_name = null;
                LinkPermissions f_linkPermissions = null;
                Date f_clientModified = null;
                Date f_serverModified = null;
                String f_rev = null;
                Long f_size = null;
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
                    else if ("client_modified".equals(field)) {
                        f_clientModified = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("server_modified".equals(field)) {
                        f_serverModified = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("rev".equals(field)) {
                        f_rev = StoneSerializers.string().deserialize(p);
                    }
                    else if ("size".equals(field)) {
                        f_size = StoneSerializers.uInt64().deserialize(p);
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
                        f_teamMemberInfo = StoneSerializers.nullable(TeamMemberInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("content_owner_team_info".equals(field)) {
                        f_contentOwnerTeamInfo = StoneSerializers.nullable(Team.Serializer.INSTANCE).deserialize(p);
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
                if (f_clientModified == null) {
                    throw new JsonParseException(p, "Required field \"client_modified\" missing.");
                }
                if (f_serverModified == null) {
                    throw new JsonParseException(p, "Required field \"server_modified\" missing.");
                }
                if (f_rev == null) {
                    throw new JsonParseException(p, "Required field \"rev\" missing.");
                }
                if (f_size == null) {
                    throw new JsonParseException(p, "Required field \"size\" missing.");
                }
                value = new FileLinkMetadata(f_url, f_name, f_linkPermissions, f_clientModified, f_serverModified, f_rev, f_size, f_id, f_expires, f_pathLower, f_teamMemberInfo, f_contentOwnerTeamInfo);
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
