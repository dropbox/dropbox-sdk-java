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

/**
 * Sharing info for a folder which is contained in a shared folder or is a
 * shared folder mount point.
 */
public class FolderSharingInfo extends SharingInfo {
    // struct FolderSharingInfo

    private final String parentSharedFolderId;
    private final String sharedFolderId;

    /**
     * Sharing info for a folder which is contained in a shared folder or is a
     * shared folder mount point.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  Set if the folder is contained by a shared
     *     folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param sharedFolderId  If this folder is a shared folder mount point, the
     *     ID of the shared folder mounted at this location. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderSharingInfo(boolean readOnly, String parentSharedFolderId, String sharedFolderId) {
        super(readOnly);
        if (parentSharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
        }
        this.parentSharedFolderId = parentSharedFolderId;
        if (sharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
        }
        this.sharedFolderId = sharedFolderId;
    }

    /**
     * Sharing info for a folder which is contained in a shared folder or is a
     * shared folder mount point.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     */
    public FolderSharingInfo(boolean readOnly) {
        this(readOnly, null, null);
    }

    /**
     * Set if the folder is contained by a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * If this folder is a shared folder mount point, the ID of the shared
     * folder mounted at this location.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder(boolean readOnly) {
        return new Builder(readOnly);
    }

    /**
     * Builder for {@link FolderSharingInfo}.
     */
    public static class Builder {
        protected final boolean readOnly;

        protected String parentSharedFolderId;
        protected String sharedFolderId;

        protected Builder(boolean readOnly) {
            this.readOnly = readOnly;
            this.parentSharedFolderId = null;
            this.sharedFolderId = null;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Set if the folder is contained by a
         *     shared folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
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
         * @param sharedFolderId  If this folder is a shared folder mount point,
         *     the ID of the shared folder mounted at this location. Must match
         *     pattern "{@code [-_0-9a-zA-Z:]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSharedFolderId(String sharedFolderId) {
            if (sharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                    throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
                }
            }
            this.sharedFolderId = sharedFolderId;
            return this;
        }

        /**
         * Builds an instance of {@link FolderSharingInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderSharingInfo}
         */
        public FolderSharingInfo build() {
            return new FolderSharingInfo(readOnly, parentSharedFolderId, sharedFolderId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            parentSharedFolderId,
            sharedFolderId
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
            FolderSharingInfo other = (FolderSharingInfo) obj;
            return ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId != null && this.sharedFolderId.equals(other.sharedFolderId)))
                && (this.getReadOnly() == other.getReadOnly())
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

    public static FolderSharingInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FolderSharingInfo> _JSON_WRITER = new JsonWriter<FolderSharingInfo>() {
        public final void write(FolderSharingInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SharingInfo._JSON_WRITER.writeFields(x, g);
            FolderSharingInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FolderSharingInfo x, JsonGenerator g) throws IOException {
            if (x.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                g.writeString(x.parentSharedFolderId);
            }
            if (x.sharedFolderId != null) {
                g.writeFieldName("shared_folder_id");
                g.writeString(x.sharedFolderId);
            }
        }
    };

    public static final JsonReader<FolderSharingInfo> _JSON_READER = new JsonReader<FolderSharingInfo>() {
        public final FolderSharingInfo read(JsonParser parser) throws IOException, JsonReadException {
            FolderSharingInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FolderSharingInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            Boolean readOnly = null;
            String parentSharedFolderId = null;
            String sharedFolderId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("read_only".equals(fieldName)) {
                    readOnly = JsonReader.BooleanReader
                        .readField(parser, "read_only", readOnly);
                }
                else if ("parent_shared_folder_id".equals(fieldName)) {
                    parentSharedFolderId = JsonReader.StringReader
                        .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                }
                else if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (readOnly == null) {
                throw new JsonReadException("Required field \"read_only\" is missing.", parser.getTokenLocation());
            }
            return new FolderSharingInfo(readOnly, parentSharedFolderId, sharedFolderId);
        }
    };
}
