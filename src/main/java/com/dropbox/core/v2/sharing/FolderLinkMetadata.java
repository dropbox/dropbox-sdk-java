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
 * The metadata of a folder shared link
 */
public class FolderLinkMetadata extends SharedLinkMetadata {
    // struct FolderLinkMetadata


    /**
     * The metadata of a folder shared link
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
    public FolderLinkMetadata(String url, String name, LinkPermissions linkPermissions, String id, Date expires, String pathLower, TeamMemberInfo teamMemberInfo, Team contentOwnerTeamInfo) {
        super(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
    }

    /**
     * The metadata of a folder shared link
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
    public FolderLinkMetadata(String url, String name, LinkPermissions linkPermissions) {
        this(url, name, linkPermissions, null, null, null, null, null);
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
     * Builder for {@link FolderLinkMetadata}.
     */
    public static class Builder extends SharedLinkMetadata.Builder {

        protected Builder(String url, String name, LinkPermissions linkPermissions) {
            super(url, name, linkPermissions);
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
         * Builds an instance of {@link FolderLinkMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderLinkMetadata}
         */
        public FolderLinkMetadata build() {
            return new FolderLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            FolderLinkMetadata other = (FolderLinkMetadata) obj;
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
    static final class Serializer extends StructSerializer<FolderLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderLinkMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("folder", g);
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
        public FolderLinkMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderLinkMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("folder".equals(tag)) {
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
                value = new FolderLinkMetadata(f_url, f_name, f_linkPermissions, f_id, f_expires, f_pathLower, f_teamMemberInfo, f_contentOwnerTeamInfo);
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
