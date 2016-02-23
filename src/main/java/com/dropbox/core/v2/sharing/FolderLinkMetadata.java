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
            return ((this.getUrl() == other.getUrl()) || (this.getUrl().equals(other.getUrl())))
                && ((this.getId() == other.getId()) || (this.getId() != null && this.getId().equals(other.getId())))
                && ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
                && ((this.getExpires() == other.getExpires()) || (this.getExpires() != null && this.getExpires().equals(other.getExpires())))
                && ((this.getPathLower() == other.getPathLower()) || (this.getPathLower() != null && this.getPathLower().equals(other.getPathLower())))
                && ((this.getLinkPermissions() == other.getLinkPermissions()) || (this.getLinkPermissions().equals(other.getLinkPermissions())))
                && ((this.getTeamMemberInfo() == other.getTeamMemberInfo()) || (this.getTeamMemberInfo() != null && this.getTeamMemberInfo().equals(other.getTeamMemberInfo())))
                && ((this.getContentOwnerTeamInfo() == other.getContentOwnerTeamInfo()) || (this.getContentOwnerTeamInfo() != null && this.getContentOwnerTeamInfo().equals(other.getContentOwnerTeamInfo())))
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

    public static FolderLinkMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FolderLinkMetadata> _JSON_WRITER = new JsonWriter<FolderLinkMetadata>() {
        public final void write(FolderLinkMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "folder");
            SharedLinkMetadata._JSON_WRITER.writeFields(x, g);
            FolderLinkMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FolderLinkMetadata x, JsonGenerator g) throws IOException {
        }
    };

    public static final JsonReader<FolderLinkMetadata> _JSON_READER = new JsonReader<FolderLinkMetadata>() {
        public final FolderLinkMetadata read(JsonParser parser) throws IOException, JsonReadException {
            FolderLinkMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FolderLinkMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "folder".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final FolderLinkMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
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
            return new FolderLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    };
}
