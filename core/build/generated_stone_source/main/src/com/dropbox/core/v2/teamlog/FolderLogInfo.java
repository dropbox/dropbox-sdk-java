/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Folder's logged information.
 */
public class FolderLogInfo extends FileOrFolderLogInfo {
    // struct team_log.FolderLogInfo (team_log_generated.stone)

    protected final Long fileCount;

    /**
     * Folder's logged information.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param path  Path relative to event context. Must not be {@code null}.
     * @param displayName  Display name.
     * @param fileId  Unique ID.
     * @param fileSize  File or folder size in bytes.
     * @param fileCount  Number of files within the folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderLogInfo(@javax.annotation.Nonnull PathLogInfo path, @javax.annotation.Nullable String displayName, @javax.annotation.Nullable String fileId, @javax.annotation.Nullable Long fileSize, @javax.annotation.Nullable Long fileCount) {
        super(path, displayName, fileId, fileSize);
        this.fileCount = fileCount;
    }

    /**
     * Folder's logged information.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  Path relative to event context. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderLogInfo(PathLogInfo path) {
        this(path, null, null, null, null);
    }

    /**
     * Path relative to event context.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public PathLogInfo getPath() {
        return path;
    }

    /**
     * Display name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Unique ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getFileId() {
        return fileId;
    }

    /**
     * File or folder size in bytes.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * Number of files within the folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Long getFileCount() {
        return fileCount;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  Path relative to event context. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(PathLogInfo path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link FolderLogInfo}.
     */
    public static class Builder extends FileOrFolderLogInfo.Builder {

        protected Long fileCount;

        protected Builder(PathLogInfo path) {
            super(path);
            this.fileCount = null;
        }

        /**
         * Set value for optional field.
         *
         * @param fileCount  Number of files within the folder.
         *
         * @return this builder
         */
        public Builder withFileCount(Long fileCount) {
            this.fileCount = fileCount;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param displayName  Display name.
         *
         * @return this builder
         */
        public Builder withDisplayName(String displayName) {
            super.withDisplayName(displayName);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fileId  Unique ID.
         *
         * @return this builder
         */
        public Builder withFileId(String fileId) {
            super.withFileId(fileId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fileSize  File or folder size in bytes.
         *
         * @return this builder
         */
        public Builder withFileSize(Long fileSize) {
            super.withFileSize(fileSize);
            return this;
        }

        /**
         * Builds an instance of {@link FolderLogInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderLogInfo}
         */
        public FolderLogInfo build() {
            return new FolderLogInfo(path, displayName, fileId, fileSize, fileCount);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            fileCount
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
            FolderLogInfo other = (FolderLogInfo) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.displayName == other.displayName) || (this.displayName != null && this.displayName.equals(other.displayName)))
                && ((this.fileId == other.fileId) || (this.fileId != null && this.fileId.equals(other.fileId)))
                && ((this.fileSize == other.fileSize) || (this.fileSize != null && this.fileSize.equals(other.fileSize)))
                && ((this.fileCount == other.fileCount) || (this.fileCount != null && this.fileCount.equals(other.fileCount)))
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
    static class Serializer extends StructSerializer<FolderLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            PathLogInfo.Serializer.INSTANCE.serialize(value.path, g);
            if (value.displayName != null) {
                g.writeFieldName("display_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.displayName, g);
            }
            if (value.fileId != null) {
                g.writeFieldName("file_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.fileId, g);
            }
            if (value.fileSize != null) {
                g.writeFieldName("file_size");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.fileSize, g);
            }
            if (value.fileCount != null) {
                g.writeFieldName("file_count");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.fileCount, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FolderLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                PathLogInfo f_path = null;
                String f_displayName = null;
                String f_fileId = null;
                Long f_fileSize = null;
                Long f_fileCount = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = PathLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("file_id".equals(field)) {
                        f_fileId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("file_size".equals(field)) {
                        f_fileSize = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else if ("file_count".equals(field)) {
                        f_fileCount = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new FolderLogInfo(f_path, f_displayName, f_fileId, f_fileSize, f_fileCount);
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
