/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.fileproperties.TemplateFilterBase;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class ListFolderArg {
    // struct files.ListFolderArg (files.stone)

    @Nonnull
    protected final String path;
    protected final boolean recursive;
    protected final boolean includeMediaInfo;
    protected final boolean includeDeleted;
    protected final boolean includeHasExplicitSharedMembers;
    protected final boolean includeMountedFolders;
    @Nullable
    protected final Long limit;
    @Nullable
    protected final SharedLink sharedLink;
    @Nullable
    protected final TemplateFilterBase includePropertyGroups;
    protected final boolean includeNonDownloadableFiles;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  A unique identifier for the file. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param recursive  If true, the list folder operation will be applied
     *     recursively to all subfolders and the response will contain contents
     *     of all subfolders.
     * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo} is
     *     set for photo and video. This parameter will no longer have an effect
     *     starting December 2, 2019.
     * @param includeDeleted  If true, the results will include entries for
     *     files and folders that used to exist but were deleted.
     * @param includeHasExplicitSharedMembers  If true, the results will include
     *     a flag for each file indicating whether or not  that file has any
     *     explicit members.
     * @param includeMountedFolders  If true, the results will include entries
     *     under mounted folders which includes app folder, shared folder and
     *     team folder.
     * @param limit  The maximum number of results to return per request. Note:
     *     This is an approximate number and there can be slightly more entries
     *     returned in some cases. Must be greater than or equal to 1 and be
     *     less than or equal to 2000.
     * @param sharedLink  A shared link to list the contents of. If the link is
     *     password-protected, the password must be provided. If this field is
     *     present, {@link ListFolderArg#getPath} will be relative to root of
     *     the shared link. Only non-recursive mode is supported for shared
     *     link.
     * @param includePropertyGroups  If set to a valid list of template IDs,
     *     {@link FileMetadata#getPropertyGroups} is set if there exists
     *     property data associated with the file and each of the listed
     *     templates.
     * @param includeNonDownloadableFiles  If true, include files that are not
     *     downloadable, i.e. Google Docs.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderArg(@Nonnull String path, boolean recursive, boolean includeMediaInfo, boolean includeDeleted, boolean includeHasExplicitSharedMembers, boolean includeMountedFolders, @Nullable Long limit, @Nullable SharedLink sharedLink, @Nullable TemplateFilterBase includePropertyGroups, boolean includeNonDownloadableFiles) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.recursive = recursive;
        this.includeMediaInfo = includeMediaInfo;
        this.includeDeleted = includeDeleted;
        this.includeHasExplicitSharedMembers = includeHasExplicitSharedMembers;
        this.includeMountedFolders = includeMountedFolders;
        if (limit != null) {
            if (limit < 1L) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (limit > 2000L) {
                throw new IllegalArgumentException("Number 'limit' is larger than 2000L");
            }
        }
        this.limit = limit;
        this.sharedLink = sharedLink;
        this.includePropertyGroups = includePropertyGroups;
        this.includeNonDownloadableFiles = includeNonDownloadableFiles;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  A unique identifier for the file. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderArg(@Nonnull String path) {
        this(path, false, false, false, false, true, null, null, null, true);
    }

    /**
     * A unique identifier for the file.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * If true, the list folder operation will be applied recursively to all
     * subfolders and the response will contain contents of all subfolders.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getRecursive() {
        return recursive;
    }

    /**
     * If true, {@link FileMetadata#getMediaInfo} is set for photo and video.
     * This parameter will no longer have an effect starting December 2, 2019.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeMediaInfo() {
        return includeMediaInfo;
    }

    /**
     * If true, the results will include entries for files and folders that used
     * to exist but were deleted.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeDeleted() {
        return includeDeleted;
    }

    /**
     * If true, the results will include a flag for each file indicating whether
     * or not  that file has any explicit members.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeHasExplicitSharedMembers() {
        return includeHasExplicitSharedMembers;
    }

    /**
     * If true, the results will include entries under mounted folders which
     * includes app folder, shared folder and team folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeMountedFolders() {
        return includeMountedFolders;
    }

    /**
     * The maximum number of results to return per request. Note: This is an
     * approximate number and there can be slightly more entries returned in
     * some cases.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Long getLimit() {
        return limit;
    }

    /**
     * A shared link to list the contents of. If the link is password-protected,
     * the password must be provided. If this field is present, {@link
     * ListFolderArg#getPath} will be relative to root of the shared link. Only
     * non-recursive mode is supported for shared link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SharedLink getSharedLink() {
        return sharedLink;
    }

    /**
     * If set to a valid list of template IDs, {@link
     * FileMetadata#getPropertyGroups} is set if there exists property data
     * associated with the file and each of the listed templates.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public TemplateFilterBase getIncludePropertyGroups() {
        return includePropertyGroups;
    }

    /**
     * If true, include files that are not downloadable, i.e. Google Docs.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeNonDownloadableFiles() {
        return includeNonDownloadableFiles;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  A unique identifier for the file. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link ListFolderArg}.
     */
    public static class Builder {
        protected final String path;

        protected boolean recursive;
        protected boolean includeMediaInfo;
        protected boolean includeDeleted;
        protected boolean includeHasExplicitSharedMembers;
        protected boolean includeMountedFolders;
        protected Long limit;
        protected SharedLink sharedLink;
        protected TemplateFilterBase includePropertyGroups;
        protected boolean includeNonDownloadableFiles;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.recursive = false;
            this.includeMediaInfo = false;
            this.includeDeleted = false;
            this.includeHasExplicitSharedMembers = false;
            this.includeMountedFolders = true;
            this.limit = null;
            this.sharedLink = null;
            this.includePropertyGroups = null;
            this.includeNonDownloadableFiles = true;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param recursive  If true, the list folder operation will be applied
         *     recursively to all subfolders and the response will contain
         *     contents of all subfolders. Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withRecursive(Boolean recursive) {
            if (recursive != null) {
                this.recursive = recursive;
            }
            else {
                this.recursive = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo}
         *     is set for photo and video. This parameter will no longer have an
         *     effect starting December 2, 2019. Defaults to {@code false} when
         *     set to {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeMediaInfo(Boolean includeMediaInfo) {
            if (includeMediaInfo != null) {
                this.includeMediaInfo = includeMediaInfo;
            }
            else {
                this.includeMediaInfo = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param includeDeleted  If true, the results will include entries for
         *     files and folders that used to exist but were deleted. Defaults
         *     to {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeDeleted(Boolean includeDeleted) {
            if (includeDeleted != null) {
                this.includeDeleted = includeDeleted;
            }
            else {
                this.includeDeleted = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param includeHasExplicitSharedMembers  If true, the results will
         *     include a flag for each file indicating whether or not  that file
         *     has any explicit members. Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeHasExplicitSharedMembers(Boolean includeHasExplicitSharedMembers) {
            if (includeHasExplicitSharedMembers != null) {
                this.includeHasExplicitSharedMembers = includeHasExplicitSharedMembers;
            }
            else {
                this.includeHasExplicitSharedMembers = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param includeMountedFolders  If true, the results will include
         *     entries under mounted folders which includes app folder, shared
         *     folder and team folder. Defaults to {@code true} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeMountedFolders(Boolean includeMountedFolders) {
            if (includeMountedFolders != null) {
                this.includeMountedFolders = includeMountedFolders;
            }
            else {
                this.includeMountedFolders = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param limit  The maximum number of results to return per request.
         *     Note: This is an approximate number and there can be slightly
         *     more entries returned in some cases. Must be greater than or
         *     equal to 1 and be less than or equal to 2000.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withLimit(Long limit) {
            if (limit != null) {
                if (limit < 1L) {
                    throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
                }
                if (limit > 2000L) {
                    throw new IllegalArgumentException("Number 'limit' is larger than 2000L");
                }
            }
            this.limit = limit;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedLink  A shared link to list the contents of. If the link
         *     is password-protected, the password must be provided. If this
         *     field is present, {@link ListFolderArg#getPath} will be relative
         *     to root of the shared link. Only non-recursive mode is supported
         *     for shared link.
         *
         * @return this builder
         */
        public Builder withSharedLink(SharedLink sharedLink) {
            this.sharedLink = sharedLink;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param includePropertyGroups  If set to a valid list of template IDs,
         *     {@link FileMetadata#getPropertyGroups} is set if there exists
         *     property data associated with the file and each of the listed
         *     templates.
         *
         * @return this builder
         */
        public Builder withIncludePropertyGroups(TemplateFilterBase includePropertyGroups) {
            this.includePropertyGroups = includePropertyGroups;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param includeNonDownloadableFiles  If true, include files that are
         *     not downloadable, i.e. Google Docs. Defaults to {@code true} when
         *     set to {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeNonDownloadableFiles(Boolean includeNonDownloadableFiles) {
            if (includeNonDownloadableFiles != null) {
                this.includeNonDownloadableFiles = includeNonDownloadableFiles;
            }
            else {
                this.includeNonDownloadableFiles = true;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ListFolderArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListFolderArg}
         */
        public ListFolderArg build() {
            return new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted, includeHasExplicitSharedMembers, includeMountedFolders, limit, sharedLink, includePropertyGroups, includeNonDownloadableFiles);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.path,
            this.recursive,
            this.includeMediaInfo,
            this.includeDeleted,
            this.includeHasExplicitSharedMembers,
            this.includeMountedFolders,
            this.limit,
            this.sharedLink,
            this.includePropertyGroups,
            this.includeNonDownloadableFiles
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
            ListFolderArg other = (ListFolderArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.recursive == other.recursive)
                && (this.includeMediaInfo == other.includeMediaInfo)
                && (this.includeDeleted == other.includeDeleted)
                && (this.includeHasExplicitSharedMembers == other.includeHasExplicitSharedMembers)
                && (this.includeMountedFolders == other.includeMountedFolders)
                && ((this.limit == other.limit) || (this.limit != null && this.limit.equals(other.limit)))
                && ((this.sharedLink == other.sharedLink) || (this.sharedLink != null && this.sharedLink.equals(other.sharedLink)))
                && ((this.includePropertyGroups == other.includePropertyGroups) || (this.includePropertyGroups != null && this.includePropertyGroups.equals(other.includePropertyGroups)))
                && (this.includeNonDownloadableFiles == other.includeNonDownloadableFiles)
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
    static class Serializer extends StructSerializer<ListFolderArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("recursive");
            StoneSerializers.boolean_().serialize(value.recursive, g);
            g.writeFieldName("include_media_info");
            StoneSerializers.boolean_().serialize(value.includeMediaInfo, g);
            g.writeFieldName("include_deleted");
            StoneSerializers.boolean_().serialize(value.includeDeleted, g);
            g.writeFieldName("include_has_explicit_shared_members");
            StoneSerializers.boolean_().serialize(value.includeHasExplicitSharedMembers, g);
            g.writeFieldName("include_mounted_folders");
            StoneSerializers.boolean_().serialize(value.includeMountedFolders, g);
            if (value.limit != null) {
                g.writeFieldName("limit");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(value.limit, g);
            }
            if (value.sharedLink != null) {
                g.writeFieldName("shared_link");
                StoneSerializers.nullableStruct(SharedLink.Serializer.INSTANCE).serialize(value.sharedLink, g);
            }
            if (value.includePropertyGroups != null) {
                g.writeFieldName("include_property_groups");
                StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).serialize(value.includePropertyGroups, g);
            }
            g.writeFieldName("include_non_downloadable_files");
            StoneSerializers.boolean_().serialize(value.includeNonDownloadableFiles, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFolderArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFolderArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                Boolean f_recursive = false;
                Boolean f_includeMediaInfo = false;
                Boolean f_includeDeleted = false;
                Boolean f_includeHasExplicitSharedMembers = false;
                Boolean f_includeMountedFolders = true;
                Long f_limit = null;
                SharedLink f_sharedLink = null;
                TemplateFilterBase f_includePropertyGroups = null;
                Boolean f_includeNonDownloadableFiles = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("recursive".equals(field)) {
                        f_recursive = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_media_info".equals(field)) {
                        f_includeMediaInfo = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_deleted".equals(field)) {
                        f_includeDeleted = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_has_explicit_shared_members".equals(field)) {
                        f_includeHasExplicitSharedMembers = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_mounted_folders".equals(field)) {
                        f_includeMountedFolders = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(p);
                    }
                    else if ("shared_link".equals(field)) {
                        f_sharedLink = StoneSerializers.nullableStruct(SharedLink.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("include_property_groups".equals(field)) {
                        f_includePropertyGroups = StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("include_non_downloadable_files".equals(field)) {
                        f_includeNonDownloadableFiles = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ListFolderArg(f_path, f_recursive, f_includeMediaInfo, f_includeDeleted, f_includeHasExplicitSharedMembers, f_includeMountedFolders, f_limit, f_sharedLink, f_includePropertyGroups, f_includeNonDownloadableFiles);
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
