/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ListFolderArg {
    // struct ListFolderArg

    private final String path;
    private final boolean recursive;
    private final boolean includeMediaInfo;
    private final boolean includeDeleted;

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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderArg(String path, boolean recursive, boolean includeMediaInfo, boolean includeDeleted) {
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
        this(path, false, false, false);
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
         * Builds an instance of {@link ListFolderArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListFolderArg}
         */
        public ListFolderArg build() {
            return new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            recursive,
            includeMediaInfo,
            includeDeleted
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

    public static ListFolderArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderArg> _JSON_WRITER = new JsonWriter<ListFolderArg>() {
        public final void write(ListFolderArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFolderArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFolderArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("recursive");
            g.writeBoolean(x.recursive);
            g.writeFieldName("include_media_info");
            g.writeBoolean(x.includeMediaInfo);
            g.writeFieldName("include_deleted");
            g.writeBoolean(x.includeDeleted);
        }
    };

    public static final JsonReader<ListFolderArg> _JSON_READER = new JsonReader<ListFolderArg>() {
        public final ListFolderArg read(JsonParser parser) throws IOException, JsonReadException {
            ListFolderArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFolderArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            Boolean recursive = null;
            Boolean includeMediaInfo = null;
            Boolean includeDeleted = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("recursive".equals(fieldName)) {
                    recursive = JsonReader.BooleanReader
                        .readField(parser, "recursive", recursive);
                }
                else if ("include_media_info".equals(fieldName)) {
                    includeMediaInfo = JsonReader.BooleanReader
                        .readField(parser, "include_media_info", includeMediaInfo);
                }
                else if ("include_deleted".equals(fieldName)) {
                    includeDeleted = JsonReader.BooleanReader
                        .readField(parser, "include_deleted", includeDeleted);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted);
        }
    };
}
