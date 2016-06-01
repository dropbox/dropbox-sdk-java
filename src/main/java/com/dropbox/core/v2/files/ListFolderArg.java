/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ListFolderArg {
    // struct ListFolderArg

    protected final String path;
    protected final boolean recursive;
    protected final boolean includeMediaInfo;
    protected final boolean includeDeleted;
    protected final boolean includeHasExplicitSharedMembers;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
     * @param recursive  If true, the list folder operation will be applied
     *     recursively to all subfolders and the response will contain contents
     *     of all subfolders.
     * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo} is
     *     set for photo and video.
     * @param includeDeleted  If true, the results will include entries for
     *     files and folders that used to exist but were deleted.
     * @param includeHasExplicitSharedMembers  If true, the results will include
     *     a flag for each file indicating whether or not  that file has any
     *     explicit members.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderArg(String path, boolean recursive, boolean includeMediaInfo, boolean includeDeleted, boolean includeHasExplicitSharedMembers) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)?", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.recursive = recursive;
        this.includeMediaInfo = includeMediaInfo;
        this.includeDeleted = includeDeleted;
        this.includeHasExplicitSharedMembers = includeHasExplicitSharedMembers;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderArg(String path) {
        this(path, false, false, false, false);
    }

    /**
     * The path to the folder you want to see the contents of.
     *
     * @return value for this field, never {@code null}.
     */
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
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
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

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)?", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.recursive = false;
            this.includeMediaInfo = false;
            this.includeDeleted = false;
            this.includeHasExplicitSharedMembers = false;
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
         *     is set for photo and video. Defaults to {@code false} when set to
         *     {@code null}.
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
         * Builds an instance of {@link ListFolderArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListFolderArg}
         */
        public ListFolderArg build() {
            return new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted, includeHasExplicitSharedMembers);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            recursive,
            includeMediaInfo,
            includeDeleted,
            includeHasExplicitSharedMembers
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
            ListFolderArg other = (ListFolderArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.recursive == other.recursive)
                && (this.includeMediaInfo == other.includeMediaInfo)
                && (this.includeDeleted == other.includeDeleted)
                && (this.includeHasExplicitSharedMembers == other.includeHasExplicitSharedMembers)
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
    static final class Serializer extends StructSerializer<ListFolderArg> {
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
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ListFolderArg(f_path, f_recursive, f_includeMediaInfo, f_includeDeleted, f_includeHasExplicitSharedMembers);
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
