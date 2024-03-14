/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.fileproperties.PropertyGroup;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class FileMetadata extends Metadata {
    // struct files.FileMetadata (files.stone)

    protected final String id;
    protected final Date clientModified;
    protected final Date serverModified;
    protected final String rev;
    protected final long size;
    protected final MediaInfo mediaInfo;
    protected final SymlinkInfo symlinkInfo;
    protected final FileSharingInfo sharingInfo;
    protected final boolean isDownloadable;
    protected final ExportInfo exportInfo;
    protected final List<PropertyGroup> propertyGroups;
    protected final Boolean hasExplicitSharedMembers;
    protected final String contentHash;
    protected final FileLockMetadata fileLockInfo;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
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
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. This field will be null if the file or
     *     folder is not mounted.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1, and at least the last path component will have the
     *     correct casing. Changes to only the casing of paths won't be returned
     *     by {@link DbxAppFilesRequests#listFolderContinue(String)}. This field
     *     will be null if the file or folder is not mounted.
     * @param parentSharedFolderId  Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param previewUrl  The preview URL of the file.
     * @param mediaInfo  Additional information if the file is a photo or video.
     *     This field will not be set on entries returned by {@link
     *     DbxAppFilesRequests#listFolder(String)}, {@link
     *     DbxAppFilesRequests#listFolderContinue(String)}, or {@link
     *     DbxUserFilesRequests#getThumbnailBatch(List)}, starting December 2,
     *     2019.
     * @param symlinkInfo  Set if this file is a symlink.
     * @param sharingInfo  Set if this file is contained in a shared folder.
     * @param isDownloadable  If true, file can be downloaded directly; else the
     *     file must be exported.
     * @param exportInfo  Information about format this file can be exported to.
     *     This filed must be set if {@link FileMetadata#getIsDownloadable} is
     *     set to false.
     * @param propertyGroups  Additional information if the file has custom
     *     properties with the property template specified. Must not contain a
     *     {@code null} item.
     * @param hasExplicitSharedMembers  This flag will only be present if
     *     include_has_explicit_shared_members  is true in {@link
     *     DbxAppFilesRequests#listFolder(String)} or {@link
     *     DbxUserFilesRequests#getMetadata(String)}. If this  flag is present,
     *     it will be true if this file has any explicit shared  members. This
     *     is different from sharing_info in that this could be true  in the
     *     case where a file has explicit members but is not contained within  a
     *     shared folder.
     * @param contentHash  A hash of the file content. This field can be used to
     *     verify data integrity. For more information see our <a
     *     href="https://www.dropbox.com/developers/reference/content-hash">Content
     *     hash</a> page. Must have length of at least 64 and have length of at
     *     most 64.
     * @param fileLockInfo  If present, the metadata associated with the file's
     *     current lock.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMetadata(String name, String id, Date clientModified, Date serverModified, String rev, long size, String pathLower, String pathDisplay, String parentSharedFolderId, String previewUrl, MediaInfo mediaInfo, SymlinkInfo symlinkInfo, FileSharingInfo sharingInfo, boolean isDownloadable, ExportInfo exportInfo, List<PropertyGroup> propertyGroups, Boolean hasExplicitSharedMembers, String contentHash, FileLockMetadata fileLockInfo) {
        super(name, pathLower, pathDisplay, parentSharedFolderId, previewUrl);
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
        this.clientModified = LangUtil.truncateMillis(clientModified);
        if (serverModified == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = LangUtil.truncateMillis(serverModified);
        if (rev == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (rev.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", rev)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = rev;
        this.size = size;
        this.mediaInfo = mediaInfo;
        this.symlinkInfo = symlinkInfo;
        this.sharingInfo = sharingInfo;
        this.isDownloadable = isDownloadable;
        this.exportInfo = exportInfo;
        if (propertyGroups != null) {
            for (PropertyGroup x : propertyGroups) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = propertyGroups;
        this.hasExplicitSharedMembers = hasExplicitSharedMembers;
        if (contentHash != null) {
            if (contentHash.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (contentHash.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        this.contentHash = contentHash;
        this.fileLockInfo = fileLockInfo;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
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
    public FileMetadata(String name, String id, Date clientModified, Date serverModified, String rev, long size) {
        this(name, id, clientModified, serverModified, rev, size, null, null, null, null, null, null, null, true, null, null, null, null, null);
    }

    /**
     * The last component of the path (including extension). This never contains
     * a slash.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    /**
     * A unique identifier for the file.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
    @javax.annotation.Nonnull
    public Date getClientModified() {
        return clientModified;
    }

    /**
     * The last time the file was modified on Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
    @javax.annotation.Nonnull
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
     * The lowercased full path in the user's Dropbox. This always starts with a
     * slash. This field will be null if the file or folder is not mounted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The cased path to be used for display purposes only. In rare instances
     * the casing will not correctly match the user's filesystem, but this
     * behavior will match the path provided in the Core API v1, and at least
     * the last path component will have the correct casing. Changes to only the
     * casing of paths won't be returned by {@link
     * DbxAppFilesRequests#listFolderContinue(String)}. This field will be null
     * if the file or folder is not mounted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * Please use {@link FileSharingInfo#getParentSharedFolderId} or {@link
     * FolderSharingInfo#getParentSharedFolderId} instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The preview URL of the file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * Additional information if the file is a photo or video. This field will
     * not be set on entries returned by {@link
     * DbxAppFilesRequests#listFolder(String)}, {@link
     * DbxAppFilesRequests#listFolderContinue(String)}, or {@link
     * DbxUserFilesRequests#getThumbnailBatch(List)}, starting December 2, 2019.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public MediaInfo getMediaInfo() {
        return mediaInfo;
    }

    /**
     * Set if this file is a symlink.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public SymlinkInfo getSymlinkInfo() {
        return symlinkInfo;
    }

    /**
     * Set if this file is contained in a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public FileSharingInfo getSharingInfo() {
        return sharingInfo;
    }

    /**
     * If true, file can be downloaded directly; else the file must be exported.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIsDownloadable() {
        return isDownloadable;
    }

    /**
     * Information about format this file can be exported to. This filed must be
     * set if {@link FileMetadata#getIsDownloadable} is set to false.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public ExportInfo getExportInfo() {
        return exportInfo;
    }

    /**
     * Additional information if the file has custom properties with the
     * property template specified.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    /**
     * This flag will only be present if include_has_explicit_shared_members  is
     * true in {@link DbxAppFilesRequests#listFolder(String)} or {@link
     * DbxUserFilesRequests#getMetadata(String)}. If this  flag is present, it
     * will be true if this file has any explicit shared  members. This is
     * different from sharing_info in that this could be true  in the case where
     * a file has explicit members but is not contained within  a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Boolean getHasExplicitSharedMembers() {
        return hasExplicitSharedMembers;
    }

    /**
     * A hash of the file content. This field can be used to verify data
     * integrity. For more information see our <a
     * href="https://www.dropbox.com/developers/reference/content-hash">Content
     * hash</a> page.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getContentHash() {
        return contentHash;
    }

    /**
     * If present, the metadata associated with the file's current lock.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public FileLockMetadata getFileLockInfo() {
        return fileLockInfo;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
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
    public static Builder newBuilder(String name, String id, Date clientModified, Date serverModified, String rev, long size) {
        return new Builder(name, id, clientModified, serverModified, rev, size);
    }

    /**
     * Builder for {@link FileMetadata}.
     */
    public static class Builder extends Metadata.Builder {
        protected final String id;
        protected final Date clientModified;
        protected final Date serverModified;
        protected final String rev;
        protected final long size;

        protected MediaInfo mediaInfo;
        protected SymlinkInfo symlinkInfo;
        protected FileSharingInfo sharingInfo;
        protected boolean isDownloadable;
        protected ExportInfo exportInfo;
        protected List<PropertyGroup> propertyGroups;
        protected Boolean hasExplicitSharedMembers;
        protected String contentHash;
        protected FileLockMetadata fileLockInfo;

        protected Builder(String name, String id, Date clientModified, Date serverModified, String rev, long size) {
            super(name);
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
            this.clientModified = LangUtil.truncateMillis(clientModified);
            if (serverModified == null) {
                throw new IllegalArgumentException("Required value for 'serverModified' is null");
            }
            this.serverModified = LangUtil.truncateMillis(serverModified);
            if (rev == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.rev = rev;
            this.size = size;
            this.mediaInfo = null;
            this.symlinkInfo = null;
            this.sharingInfo = null;
            this.isDownloadable = true;
            this.exportInfo = null;
            this.propertyGroups = null;
            this.hasExplicitSharedMembers = null;
            this.contentHash = null;
            this.fileLockInfo = null;
        }

        /**
         * Set value for optional field.
         *
         * @param mediaInfo  Additional information if the file is a photo or
         *     video. This field will not be set on entries returned by {@link
         *     DbxAppFilesRequests#listFolder(String)}, {@link
         *     DbxAppFilesRequests#listFolderContinue(String)}, or {@link
         *     DbxUserFilesRequests#getThumbnailBatch(List)}, starting December
         *     2, 2019.
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
         * @param symlinkInfo  Set if this file is a symlink.
         *
         * @return this builder
         */
        public Builder withSymlinkInfo(SymlinkInfo symlinkInfo) {
            this.symlinkInfo = symlinkInfo;
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
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param isDownloadable  If true, file can be downloaded directly; else
         *     the file must be exported. Defaults to {@code true} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withIsDownloadable(Boolean isDownloadable) {
            if (isDownloadable != null) {
                this.isDownloadable = isDownloadable;
            }
            else {
                this.isDownloadable = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param exportInfo  Information about format this file can be exported
         *     to. This filed must be set if {@link
         *     FileMetadata#getIsDownloadable} is set to false.
         *
         * @return this builder
         */
        public Builder withExportInfo(ExportInfo exportInfo) {
            this.exportInfo = exportInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param propertyGroups  Additional information if the file has custom
         *     properties with the property template specified. Must not contain
         *     a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPropertyGroups(List<PropertyGroup> propertyGroups) {
            if (propertyGroups != null) {
                for (PropertyGroup x : propertyGroups) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                    }
                }
            }
            this.propertyGroups = propertyGroups;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param hasExplicitSharedMembers  This flag will only be present if
         *     include_has_explicit_shared_members  is true in {@link
         *     DbxAppFilesRequests#listFolder(String)} or {@link
         *     DbxUserFilesRequests#getMetadata(String)}. If this  flag is
         *     present, it will be true if this file has any explicit shared
         *     members. This is different from sharing_info in that this could
         *     be true  in the case where a file has explicit members but is not
         *     contained within  a shared folder.
         *
         * @return this builder
         */
        public Builder withHasExplicitSharedMembers(Boolean hasExplicitSharedMembers) {
            this.hasExplicitSharedMembers = hasExplicitSharedMembers;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param contentHash  A hash of the file content. This field can be
         *     used to verify data integrity. For more information see our <a
         *     href="https://www.dropbox.com/developers/reference/content-hash">Content
         *     hash</a> page. Must have length of at least 64 and have length of
         *     at most 64.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withContentHash(String contentHash) {
            if (contentHash != null) {
                if (contentHash.length() < 64) {
                    throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
                }
                if (contentHash.length() > 64) {
                    throw new IllegalArgumentException("String 'contentHash' is longer than 64");
                }
            }
            this.contentHash = contentHash;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fileLockInfo  If present, the metadata associated with the
         *     file's current lock.
         *
         * @return this builder
         */
        public Builder withFileLockInfo(FileLockMetadata fileLockInfo) {
            this.fileLockInfo = fileLockInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. This field will be null if the
         *     file or folder is not mounted.
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
         * @param pathDisplay  The cased path to be used for display purposes
         *     only. In rare instances the casing will not correctly match the
         *     user's filesystem, but this behavior will match the path provided
         *     in the Core API v1, and at least the last path component will
         *     have the correct casing. Changes to only the casing of paths
         *     won't be returned by {@link
         *     DbxAppFilesRequests#listFolderContinue(String)}. This field will
         *     be null if the file or folder is not mounted.
         *
         * @return this builder
         */
        public Builder withPathDisplay(String pathDisplay) {
            super.withPathDisplay(pathDisplay);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Please use {@link
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
            super.withParentSharedFolderId(parentSharedFolderId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previewUrl  The preview URL of the file.
         *
         * @return this builder
         */
        public Builder withPreviewUrl(String previewUrl) {
            super.withPreviewUrl(previewUrl);
            return this;
        }

        /**
         * Builds an instance of {@link FileMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FileMetadata}
         */
        public FileMetadata build() {
            return new FileMetadata(name, id, clientModified, serverModified, rev, size, pathLower, pathDisplay, parentSharedFolderId, previewUrl, mediaInfo, symlinkInfo, sharingInfo, isDownloadable, exportInfo, propertyGroups, hasExplicitSharedMembers, contentHash, fileLockInfo);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id,
            clientModified,
            serverModified,
            rev,
            size,
            mediaInfo,
            symlinkInfo,
            sharingInfo,
            isDownloadable,
            exportInfo,
            propertyGroups,
            hasExplicitSharedMembers,
            contentHash,
            fileLockInfo
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
            FileMetadata other = (FileMetadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.clientModified == other.clientModified) || (this.clientModified.equals(other.clientModified)))
                && ((this.serverModified == other.serverModified) || (this.serverModified.equals(other.serverModified)))
                && ((this.rev == other.rev) || (this.rev.equals(other.rev)))
                && (this.size == other.size)
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay != null && this.pathDisplay.equals(other.pathDisplay)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.previewUrl == other.previewUrl) || (this.previewUrl != null && this.previewUrl.equals(other.previewUrl)))
                && ((this.mediaInfo == other.mediaInfo) || (this.mediaInfo != null && this.mediaInfo.equals(other.mediaInfo)))
                && ((this.symlinkInfo == other.symlinkInfo) || (this.symlinkInfo != null && this.symlinkInfo.equals(other.symlinkInfo)))
                && ((this.sharingInfo == other.sharingInfo) || (this.sharingInfo != null && this.sharingInfo.equals(other.sharingInfo)))
                && (this.isDownloadable == other.isDownloadable)
                && ((this.exportInfo == other.exportInfo) || (this.exportInfo != null && this.exportInfo.equals(other.exportInfo)))
                && ((this.propertyGroups == other.propertyGroups) || (this.propertyGroups != null && this.propertyGroups.equals(other.propertyGroups)))
                && ((this.hasExplicitSharedMembers == other.hasExplicitSharedMembers) || (this.hasExplicitSharedMembers != null && this.hasExplicitSharedMembers.equals(other.hasExplicitSharedMembers)))
                && ((this.contentHash == other.contentHash) || (this.contentHash != null && this.contentHash.equals(other.contentHash)))
                && ((this.fileLockInfo == other.fileLockInfo) || (this.fileLockInfo != null && this.fileLockInfo.equals(other.fileLockInfo)))
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
    static class Serializer extends StructSerializer<FileMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("file", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("client_modified");
            StoneSerializers.timestamp().serialize(value.clientModified, g);
            g.writeFieldName("server_modified");
            StoneSerializers.timestamp().serialize(value.serverModified, g);
            g.writeFieldName("rev");
            StoneSerializers.string().serialize(value.rev, g);
            g.writeFieldName("size");
            StoneSerializers.uInt64().serialize(value.size, g);
            if (value.pathLower != null) {
                g.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathLower, g);
            }
            if (value.pathDisplay != null) {
                g.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathDisplay, g);
            }
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.previewUrl != null) {
                g.writeFieldName("preview_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previewUrl, g);
            }
            if (value.mediaInfo != null) {
                g.writeFieldName("media_info");
                StoneSerializers.nullable(MediaInfo.Serializer.INSTANCE).serialize(value.mediaInfo, g);
            }
            if (value.symlinkInfo != null) {
                g.writeFieldName("symlink_info");
                StoneSerializers.nullableStruct(SymlinkInfo.Serializer.INSTANCE).serialize(value.symlinkInfo, g);
            }
            if (value.sharingInfo != null) {
                g.writeFieldName("sharing_info");
                StoneSerializers.nullableStruct(FileSharingInfo.Serializer.INSTANCE).serialize(value.sharingInfo, g);
            }
            g.writeFieldName("is_downloadable");
            StoneSerializers.boolean_().serialize(value.isDownloadable, g);
            if (value.exportInfo != null) {
                g.writeFieldName("export_info");
                StoneSerializers.nullableStruct(ExportInfo.Serializer.INSTANCE).serialize(value.exportInfo, g);
            }
            if (value.propertyGroups != null) {
                g.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(value.propertyGroups, g);
            }
            if (value.hasExplicitSharedMembers != null) {
                g.writeFieldName("has_explicit_shared_members");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.hasExplicitSharedMembers, g);
            }
            if (value.contentHash != null) {
                g.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.contentHash, g);
            }
            if (value.fileLockInfo != null) {
                g.writeFieldName("file_lock_info");
                StoneSerializers.nullableStruct(FileLockMetadata.Serializer.INSTANCE).serialize(value.fileLockInfo, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("file".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                String f_id = null;
                Date f_clientModified = null;
                Date f_serverModified = null;
                String f_rev = null;
                Long f_size = null;
                String f_pathLower = null;
                String f_pathDisplay = null;
                String f_parentSharedFolderId = null;
                String f_previewUrl = null;
                MediaInfo f_mediaInfo = null;
                SymlinkInfo f_symlinkInfo = null;
                FileSharingInfo f_sharingInfo = null;
                Boolean f_isDownloadable = true;
                ExportInfo f_exportInfo = null;
                List<PropertyGroup> f_propertyGroups = null;
                Boolean f_hasExplicitSharedMembers = null;
                String f_contentHash = null;
                FileLockMetadata f_fileLockInfo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
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
                    else if ("path_lower".equals(field)) {
                        f_pathLower = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path_display".equals(field)) {
                        f_pathDisplay = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("preview_url".equals(field)) {
                        f_previewUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("media_info".equals(field)) {
                        f_mediaInfo = StoneSerializers.nullable(MediaInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("symlink_info".equals(field)) {
                        f_symlinkInfo = StoneSerializers.nullableStruct(SymlinkInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("sharing_info".equals(field)) {
                        f_sharingInfo = StoneSerializers.nullableStruct(FileSharingInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("is_downloadable".equals(field)) {
                        f_isDownloadable = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("export_info".equals(field)) {
                        f_exportInfo = StoneSerializers.nullableStruct(ExportInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("property_groups".equals(field)) {
                        f_propertyGroups = StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("has_explicit_shared_members".equals(field)) {
                        f_hasExplicitSharedMembers = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("content_hash".equals(field)) {
                        f_contentHash = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("file_lock_info".equals(field)) {
                        f_fileLockInfo = StoneSerializers.nullableStruct(FileLockMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
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
                value = new FileMetadata(f_name, f_id, f_clientModified, f_serverModified, f_rev, f_size, f_pathLower, f_pathDisplay, f_parentSharedFolderId, f_previewUrl, f_mediaInfo, f_symlinkInfo, f_sharingInfo, f_isDownloadable, f_exportInfo, f_propertyGroups, f_hasExplicitSharedMembers, f_contentHash, f_fileLockInfo);
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
