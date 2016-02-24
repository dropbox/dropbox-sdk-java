/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

public class FileMetadata extends Metadata {
    // struct FileMetadata

    private final String id;
    private final Date clientModified;
    private final Date serverModified;
    private final String rev;
    private final long size;
    private final MediaInfo mediaInfo;
    private final FileSharingInfo sharingInfo;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxFiles#listFolderContinue(String)}. Must not be {@code
     *     null}.
     * @param id  A unique identifier for the file. Must have length of at least
     *     1 and not be {@code null}.
     * @param clientModified  For files, this is the modification time set by
     *     the desktop client when the file was added to Dropbox. Since this
     *     time is not verified (the Dropbox server stores whatever the desktop
     *     client sends up), this should only be used for display purposes (such
     *     as sorting) and not, for example, to determine if a file has changed
     *     or not. Must not be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param size  The file size in bytes.
     * @param parentSharedFolderId  Deprecated. Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param mediaInfo  Additional information if the file is a photo or video.
     * @param sharingInfo  Set if this file is contained in a shared folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMetadata(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size, String parentSharedFolderId, MediaInfo mediaInfo, FileSharingInfo sharingInfo) {
        super(name, pathLower, pathDisplay, parentSharedFolderId);
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.id = id;
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
        this.mediaInfo = mediaInfo;
        this.sharingInfo = sharingInfo;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxFiles#listFolderContinue(String)}. Must not be {@code
     *     null}.
     * @param id  A unique identifier for the file. Must have length of at least
     *     1 and not be {@code null}.
     * @param clientModified  For files, this is the modification time set by
     *     the desktop client when the file was added to Dropbox. Since this
     *     time is not verified (the Dropbox server stores whatever the desktop
     *     client sends up), this should only be used for display purposes (such
     *     as sorting) and not, for example, to determine if a file has changed
     *     or not. Must not be {@code null}.
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
    public FileMetadata(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size) {
        this(name, pathLower, pathDisplay, id, clientModified, serverModified, rev, size, null, null, null);
    }

    /**
     * A unique identifier for the file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * For files, this is the modification time set by the desktop client when
     * the file was added to Dropbox. Since this time is not verified (the
     * Dropbox server stores whatever the desktop client sends up), this should
     * only be used for display purposes (such as sorting) and not, for example,
     * to determine if a file has changed or not.
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
     * Additional information if the file is a photo or video.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public MediaInfo getMediaInfo() {
        return mediaInfo;
    }

    /**
     * Set if this file is contained in a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public FileSharingInfo getSharingInfo() {
        return sharingInfo;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxFiles#listFolderContinue(String)}. Must not be {@code
     *     null}.
     * @param id  A unique identifier for the file. Must have length of at least
     *     1 and not be {@code null}.
     * @param clientModified  For files, this is the modification time set by
     *     the desktop client when the file was added to Dropbox. Since this
     *     time is not verified (the Dropbox server stores whatever the desktop
     *     client sends up), this should only be used for display purposes (such
     *     as sorting) and not, for example, to determine if a file has changed
     *     or not. Must not be {@code null}.
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
    public static Builder newBuilder(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size) {
        return new Builder(name, pathLower, pathDisplay, id, clientModified, serverModified, rev, size);
    }

    /**
     * Builder for {@link FileMetadata}.
     */
    public static class Builder {
        protected final String name;
        protected final String pathLower;
        protected final String pathDisplay;
        protected final String id;
        protected final Date clientModified;
        protected final Date serverModified;
        protected final String rev;
        protected final long size;

        protected String parentSharedFolderId;
        protected MediaInfo mediaInfo;
        protected FileSharingInfo sharingInfo;

        protected Builder(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (pathLower == null) {
                throw new IllegalArgumentException("Required value for 'pathLower' is null");
            }
            this.pathLower = pathLower;
            if (pathDisplay == null) {
                throw new IllegalArgumentException("Required value for 'pathDisplay' is null");
            }
            this.pathDisplay = pathDisplay;
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            this.id = id;
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
            this.parentSharedFolderId = null;
            this.mediaInfo = null;
            this.sharingInfo = null;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Deprecated. Please use {@link
         *     FileSharingInfo#getParentSharedFolderId} or {@link
         *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
         *     pattern "{@code [-_0-9a-zA-Z:]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withParentSharedFolderId(String parentSharedFolderId) {
            if (parentSharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                    throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
                }
            }
            this.parentSharedFolderId = parentSharedFolderId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param mediaInfo  Additional information if the file is a photo or
         *     video.
         *
         * @return this builder
         */
        public Builder withMediaInfo(MediaInfo mediaInfo) {
            this.mediaInfo = mediaInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharingInfo  Set if this file is contained in a shared folder.
         *
         * @return this builder
         */
        public Builder withSharingInfo(FileSharingInfo sharingInfo) {
            this.sharingInfo = sharingInfo;
            return this;
        }

        /**
         * Builds an instance of {@link FileMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FileMetadata}
         */
        public FileMetadata build() {
            return new FileMetadata(name, pathLower, pathDisplay, id, clientModified, serverModified, rev, size, parentSharedFolderId, mediaInfo, sharingInfo);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            id,
            clientModified,
            serverModified,
            rev,
            size,
            mediaInfo,
            sharingInfo
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
            FileMetadata other = (FileMetadata) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.clientModified == other.clientModified) || (this.clientModified.equals(other.clientModified)))
                && ((this.serverModified == other.serverModified) || (this.serverModified.equals(other.serverModified)))
                && ((this.rev == other.rev) || (this.rev.equals(other.rev)))
                && (this.size == other.size)
                && ((this.mediaInfo == other.mediaInfo) || (this.mediaInfo != null && this.mediaInfo.equals(other.mediaInfo)))
                && ((this.sharingInfo == other.sharingInfo) || (this.sharingInfo != null && this.sharingInfo.equals(other.sharingInfo)))
                && ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
                && ((this.getPathLower() == other.getPathLower()) || (this.getPathLower().equals(other.getPathLower())))
                && ((this.getPathDisplay() == other.getPathDisplay()) || (this.getPathDisplay().equals(other.getPathDisplay())))
                && ((this.getParentSharedFolderId() == other.getParentSharedFolderId()) || (this.getParentSharedFolderId() != null && this.getParentSharedFolderId().equals(other.getParentSharedFolderId())))
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

    public static FileMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FileMetadata> _JSON_WRITER = new JsonWriter<FileMetadata>() {
        public final void write(FileMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "file");
            Metadata._JSON_WRITER.writeFields(x, g);
            FileMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FileMetadata x, JsonGenerator g) throws IOException {
            g.writeFieldName("id");
            g.writeString(x.id);
            g.writeFieldName("client_modified");
            writeDateIso(x.clientModified, g);
            g.writeFieldName("server_modified");
            writeDateIso(x.serverModified, g);
            g.writeFieldName("rev");
            g.writeString(x.rev);
            g.writeFieldName("size");
            g.writeNumber(x.size);
            if (x.mediaInfo != null) {
                g.writeFieldName("media_info");
                MediaInfo._JSON_WRITER.write(x.mediaInfo, g);
            }
            if (x.sharingInfo != null) {
                g.writeFieldName("sharing_info");
                FileSharingInfo._JSON_WRITER.write(x.sharingInfo, g);
            }
        }
    };

    public static final JsonReader<FileMetadata> _JSON_READER = new JsonReader<FileMetadata>() {
        public final FileMetadata read(JsonParser parser) throws IOException, JsonReadException {
            FileMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FileMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "file".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final FileMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String name = null;
            String pathLower = null;
            String pathDisplay = null;
            String id = null;
            Date clientModified = null;
            Date serverModified = null;
            String rev = null;
            Long size = null;
            String parentSharedFolderId = null;
            MediaInfo mediaInfo = null;
            FileSharingInfo sharingInfo = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("name".equals(fieldName)) {
                    name = JsonReader.StringReader
                        .readField(parser, "name", name);
                }
                else if ("path_lower".equals(fieldName)) {
                    pathLower = JsonReader.StringReader
                        .readField(parser, "path_lower", pathLower);
                }
                else if ("path_display".equals(fieldName)) {
                    pathDisplay = JsonReader.StringReader
                        .readField(parser, "path_display", pathDisplay);
                }
                else if ("id".equals(fieldName)) {
                    id = JsonReader.StringReader
                        .readField(parser, "id", id);
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
                else if ("parent_shared_folder_id".equals(fieldName)) {
                    parentSharedFolderId = JsonReader.StringReader
                        .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                }
                else if ("media_info".equals(fieldName)) {
                    mediaInfo = MediaInfo._JSON_READER
                        .readField(parser, "media_info", mediaInfo);
                }
                else if ("sharing_info".equals(fieldName)) {
                    sharingInfo = FileSharingInfo._JSON_READER
                        .readField(parser, "sharing_info", sharingInfo);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (pathLower == null) {
                throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
            }
            if (pathDisplay == null) {
                throw new JsonReadException("Required field \"path_display\" is missing.", parser.getTokenLocation());
            }
            if (id == null) {
                throw new JsonReadException("Required field \"id\" is missing.", parser.getTokenLocation());
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
            return new FileMetadata(name, pathLower, pathDisplay, id, clientModified, serverModified, rev, size, parentSharedFolderId, mediaInfo, sharingInfo);
        }
    };
}
