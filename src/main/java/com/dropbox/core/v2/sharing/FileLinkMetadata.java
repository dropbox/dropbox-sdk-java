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
 * The metadata of a file shared link
 */
public class FileLinkMetadata extends SharedLinkMetadata {
    // struct FileLinkMetadata

    private final Date clientModified;
    private final Date serverModified;
    private final String rev;
    private final long size;

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
        this.clientModified = new Date(clientModified.getTime() - (clientModified.getTime() % 1000));
        if (serverModified == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = new Date(serverModified.getTime() - (serverModified.getTime() % 1000));
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
            this.clientModified = new Date(clientModified.getTime() - (clientModified.getTime() % 1000));
            if (serverModified == null) {
                throw new IllegalArgumentException("Required value for 'serverModified' is null");
            }
            this.serverModified = new Date(serverModified.getTime() - (serverModified.getTime() % 1000));
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
            return ((this.clientModified == other.clientModified) || (this.clientModified.equals(other.clientModified)))
                && ((this.serverModified == other.serverModified) || (this.serverModified.equals(other.serverModified)))
                && ((this.rev == other.rev) || (this.rev.equals(other.rev)))
                && (this.size == other.size)
                && ((this.getUrl() == other.getUrl()) || (this.getUrl().equals(other.getUrl())))
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

    public static FileLinkMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FileLinkMetadata> _JSON_WRITER = new JsonWriter<FileLinkMetadata>() {
        public final void write(FileLinkMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "file");
            SharedLinkMetadata._JSON_WRITER.writeFields(x, g);
            FileLinkMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FileLinkMetadata x, JsonGenerator g) throws IOException {
            g.writeFieldName("client_modified");
            writeDateIso(x.clientModified, g);
            g.writeFieldName("server_modified");
            writeDateIso(x.serverModified, g);
            g.writeFieldName("rev");
            g.writeString(x.rev);
            g.writeFieldName("size");
            g.writeNumber(x.size);
        }
    };

    public static final JsonReader<FileLinkMetadata> _JSON_READER = new JsonReader<FileLinkMetadata>() {
        public final FileLinkMetadata read(JsonParser parser) throws IOException, JsonReadException {
            FileLinkMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FileLinkMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "file".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final FileLinkMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String url = null;
            String name = null;
            LinkPermissions linkPermissions = null;
            Date clientModified = null;
            Date serverModified = null;
            String rev = null;
            Long size = null;
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
                else if ("client_modified".equals(fieldName)) {
                    clientModified = JsonDateReader.DropboxV2
                        .readField(parser, "client_modified", clientModified);
                }
                else if ("server_modified".equals(fieldName)) {
                    serverModified = JsonDateReader.DropboxV2
                        .readField(parser, "server_modified", serverModified);
                }
                else if ("rev".equals(fieldName)) {
                    rev = JsonReader.StringReader
                        .readField(parser, "rev", rev);
                }
                else if ("size".equals(fieldName)) {
                    size = JsonReader.UInt64Reader
                        .readField(parser, "size", size);
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
            if (clientModified == null) {
                throw new JsonReadException("Required field \"client_modified\" is missing.", parser.getTokenLocation());
            }
            if (serverModified == null) {
                throw new JsonReadException("Required field \"server_modified\" is missing.", parser.getTokenLocation());
            }
            if (rev == null) {
                throw new JsonReadException("Required field \"rev\" is missing.", parser.getTokenLocation());
            }
            if (size == null) {
                throw new JsonReadException("Required field \"size\" is missing.", parser.getTokenLocation());
            }
            return new FileLinkMetadata(url, name, linkPermissions, clientModified, serverModified, rev, size, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    };
}
