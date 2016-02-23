/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * The metadata of a shared link
 */
public class SharedLinkMetadata {
    // struct SharedLinkMetadata

    private final String url;
    private final String id;
    private final String name;
    private final Date expires;
    private final String pathLower;
    private final LinkPermissions linkPermissions;
    private final TeamMemberInfo teamMemberInfo;
    private final Team contentOwnerTeamInfo;

    /**
     * The metadata of a shared link
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
    public SharedLinkMetadata(String url, String name, LinkPermissions linkPermissions, String id, Date expires, String pathLower, TeamMemberInfo teamMemberInfo, Team contentOwnerTeamInfo) {
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
        this.expires = expires;
        this.pathLower = pathLower;
        if (linkPermissions == null) {
            throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
        }
        this.linkPermissions = linkPermissions;
        this.teamMemberInfo = teamMemberInfo;
        this.contentOwnerTeamInfo = contentOwnerTeamInfo;
    }

    /**
     * The metadata of a shared link
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
    public String getUrl() {
        return url;
    }

    /**
     * A unique identifier for the linked file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getId() {
        return id;
    }

    /**
     * The linked file name (including extension). This never contains a slash.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * Expiration time, if set. By default the link won't expire.
     *
     * @return value for this field, or {@code null} if not present.
     */
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
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The link's access permissions.
     *
     * @return value for this field, never {@code null}.
     */
    public LinkPermissions getLinkPermissions() {
        return linkPermissions;
    }

    /**
     * The team membership information of the link's owner.  This field will
     * only be present  if the link's owner is a team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
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
            this.expires = expires;
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
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            SharedLinkMetadata other = (SharedLinkMetadata) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.id == other.id) || (this.id != null && this.id.equals(other.id)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.expires == other.expires) || (this.expires != null && this.expires.equals(other.expires)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.linkPermissions == other.linkPermissions) || (this.linkPermissions.equals(other.linkPermissions)))
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedLinkMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedLinkMetadata> _JSON_WRITER = new JsonWriter<SharedLinkMetadata>() {
        public final void write(SharedLinkMetadata x, JsonGenerator g) throws IOException {
            if (x instanceof FileLinkMetadata) {
                FileLinkMetadata._JSON_WRITER.write((FileLinkMetadata) x, g);
                return;
            }
            if (x instanceof FolderLinkMetadata) {
                FolderLinkMetadata._JSON_WRITER.write((FolderLinkMetadata) x, g);
                return;
            }

            g.writeStartObject();
            SharedLinkMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SharedLinkMetadata x, JsonGenerator g) throws IOException {
            g.writeFieldName("url");
            g.writeString(x.url);
            if (x.id != null) {
                g.writeFieldName("id");
                g.writeString(x.id);
            }
            g.writeFieldName("name");
            g.writeString(x.name);
            if (x.expires != null) {
                g.writeFieldName("expires");
                writeDateIso(x.expires, g);
            }
            if (x.pathLower != null) {
                g.writeFieldName("path_lower");
                g.writeString(x.pathLower);
            }
            g.writeFieldName("link_permissions");
            LinkPermissions._JSON_WRITER.write(x.linkPermissions, g);
            if (x.teamMemberInfo != null) {
                g.writeFieldName("team_member_info");
                TeamMemberInfo._JSON_WRITER.write(x.teamMemberInfo, g);
            }
            if (x.contentOwnerTeamInfo != null) {
                g.writeFieldName("content_owner_team_info");
                Team._JSON_WRITER.write(x.contentOwnerTeamInfo, g);
            }
        }
    };

    public static final JsonReader<SharedLinkMetadata> _JSON_READER = new JsonReader<SharedLinkMetadata>() {
        public final SharedLinkMetadata read(JsonParser parser) throws IOException, JsonReadException {
            SharedLinkMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SharedLinkMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null && tags.length > 0) {
                if ("file".equals(tags[0])) {
                    return FileLinkMetadata._JSON_READER.readFromTags(tags, parser);
                }
                if ("folder".equals(tags[0])) {
                    return FolderLinkMetadata._JSON_READER.readFromTags(tags, parser);
                }
                // If no match, fall back to base class
            }
            return readFields(parser);
        }

        public final SharedLinkMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String url = null;
            String name = null;
            LinkPermissions linkPermissions = null;
            String id = null;
            Date expires = null;
            String pathLower = null;
            TeamMemberInfo teamMemberInfo = null;
            Team contentOwnerTeamInfo = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("url".equals(fieldName)) {
                    url = JsonReader.StringReader
                        .readField(parser, "url", url);
                }
                else if ("name".equals(fieldName)) {
                    name = JsonReader.StringReader
                        .readField(parser, "name", name);
                }
                else if ("link_permissions".equals(fieldName)) {
                    linkPermissions = LinkPermissions._JSON_READER
                        .readField(parser, "link_permissions", linkPermissions);
                }
                else if ("id".equals(fieldName)) {
                    id = JsonReader.StringReader
                        .readField(parser, "id", id);
                }
                else if ("expires".equals(fieldName)) {
                    expires = JsonDateReader.DropboxV2
                        .readField(parser, "expires", expires);
                }
                else if ("path_lower".equals(fieldName)) {
                    pathLower = JsonReader.StringReader
                        .readField(parser, "path_lower", pathLower);
                }
                else if ("team_member_info".equals(fieldName)) {
                    teamMemberInfo = TeamMemberInfo._JSON_READER
                        .readField(parser, "team_member_info", teamMemberInfo);
                }
                else if ("content_owner_team_info".equals(fieldName)) {
                    contentOwnerTeamInfo = Team._JSON_READER
                        .readField(parser, "content_owner_team_info", contentOwnerTeamInfo);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (url == null) {
                throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (linkPermissions == null) {
                throw new JsonReadException("Required field \"link_permissions\" is missing.", parser.getTokenLocation());
            }
            return new SharedLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    };
}
