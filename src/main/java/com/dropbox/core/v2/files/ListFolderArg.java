/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

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

@JsonSerialize(using=ListFolderArg.Serializer.class)
@JsonDeserialize(using=ListFolderArg.Deserializer.class)
public class ListFolderArg {
    // struct ListFolderArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
     *     match pattern "{@code (/.*)?}" and not be {@code null}.
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
        if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
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
     *     match pattern "{@code (/.*)?}" and not be {@code null}.
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
     *     match pattern "{@code (/.*)?}" and not be {@code null}.
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
            if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
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

    static final class Serializer extends StructJsonSerializer<ListFolderArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFolderArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFolderArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFolderArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFolderArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("recursive", value.recursive);
            g.writeObjectField("include_media_info", value.includeMediaInfo);
            g.writeObjectField("include_deleted", value.includeDeleted);
            g.writeObjectField("include_has_explicit_shared_members", value.includeHasExplicitSharedMembers);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFolderArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFolderArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFolderArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFolderArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFolderArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            boolean recursive = false;
            boolean includeMediaInfo = false;
            boolean includeDeleted = false;
            boolean includeHasExplicitSharedMembers = false;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("recursive".equals(_field)) {
                    recursive = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("include_media_info".equals(_field)) {
                    includeMediaInfo = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("include_deleted".equals(_field)) {
                    includeDeleted = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("include_has_explicit_shared_members".equals(_field)) {
                    includeHasExplicitSharedMembers = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted, includeHasExplicitSharedMembers);
        }
    }
}
