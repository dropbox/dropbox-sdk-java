/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.users.Team;

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
import java.util.Date;

/**
 * The metadata of a shared link
 */
@JsonSerialize(using=SharedLinkMetadata.Serializer.class)
@JsonDeserialize(using=SharedLinkMetadata.Deserializer.class)
public class SharedLinkMetadata {
    // struct SharedLinkMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String url;
    protected final String id;
    protected final String name;
    protected final Date expires;
    protected final String pathLower;
    protected final LinkPermissions linkPermissions;
    protected final TeamMemberInfo teamMemberInfo;
    protected final Team contentOwnerTeamInfo;

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

    static final class Serializer extends StructJsonSerializer<SharedLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedLinkMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(SharedLinkMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(SharedLinkMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("url", value.url);
            g.writeObjectField("name", value.name);
            g.writeObjectField("link_permissions", value.linkPermissions);
            if (value.id != null) {
                g.writeObjectField("id", value.id);
            }
            if (value.expires != null) {
                g.writeObjectField("expires", value.expires);
            }
            if (value.pathLower != null) {
                g.writeObjectField("path_lower", value.pathLower);
            }
            if (value.teamMemberInfo != null) {
                g.writeObjectField("team_member_info", value.teamMemberInfo);
            }
            if (value.contentOwnerTeamInfo != null) {
                g.writeObjectField("content_owner_team_info", value.contentOwnerTeamInfo);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SharedLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedLinkMetadata.class, FileLinkMetadata.class, FolderLinkMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SharedLinkMetadata.class, unwrapping, FileLinkMetadata.class, FolderLinkMetadata.class);
        }

        @Override
        protected JsonDeserializer<SharedLinkMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SharedLinkMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p);
            if ("file".equals(_subtype_tag)) {
                return readCollapsedStructValue(FileLinkMetadata.class, _p, _ctx);
            }
            if ("folder".equals(_subtype_tag)) {
                return readCollapsedStructValue(FolderLinkMetadata.class, _p, _ctx);
            }

            String url = null;
            String name = null;
            LinkPermissions linkPermissions = null;
            String id = null;
            Date expires = null;
            String pathLower = null;
            TeamMemberInfo teamMemberInfo = null;
            Team contentOwnerTeamInfo = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("url".equals(_field)) {
                    url = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("link_permissions".equals(_field)) {
                    linkPermissions = _p.readValueAs(LinkPermissions.class);
                    _p.nextToken();
                }
                else if ("id".equals(_field)) {
                    id = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("expires".equals(_field)) {
                    expires = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("path_lower".equals(_field)) {
                    pathLower = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("team_member_info".equals(_field)) {
                    teamMemberInfo = _p.readValueAs(TeamMemberInfo.class);
                    _p.nextToken();
                }
                else if ("content_owner_team_info".equals(_field)) {
                    contentOwnerTeamInfo = _p.readValueAs(Team.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (url == null) {
                throw new JsonParseException(_p, "Required field \"url\" is missing.");
            }
            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (linkPermissions == null) {
                throw new JsonParseException(_p, "Required field \"link_permissions\" is missing.");
            }

            return new SharedLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    }
}
