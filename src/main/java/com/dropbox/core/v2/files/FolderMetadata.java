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

public class FolderMetadata extends Metadata {
    // struct FolderMetadata

    private final String id;
    private final String sharedFolderId;
    private final FolderSharingInfo sharingInfo;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param parentSharedFolderId  Deprecated. Please use
     *     :field:'FileSharingInfo.parent_shared_folder_id' or
     *     :field:'FolderSharingInfo.parent_shared_folder_id' instead. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param id  A unique identifier for the folder. Must have length of at
     *     least 1.
     * @param sharedFolderId  Deprecated. Please use :field:'sharing_info'
     *     instead. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param sharingInfo  Set if the folder is contained in a shared folder or
     *     is a shared folder mount point.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata(String name, String pathLower, String parentSharedFolderId, String id, String sharedFolderId, FolderSharingInfo sharingInfo) {
        super(name, pathLower, parentSharedFolderId);
        if (id != null) {
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
        }
        this.id = id;
        if (sharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
        }
        this.sharedFolderId = sharedFolderId;
        this.sharingInfo = sharingInfo;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata(String name, String pathLower) {
        this(name, pathLower, null, null, null, null);
    }

    /**
     * A unique identifier for the folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getId() {
        return id;
    }

    /**
     * Deprecated. Please use :field:'sharing_info' instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Set if the folder is contained in a shared folder or is a shared folder
     * mount point.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public FolderSharingInfo getSharingInfo() {
        return sharingInfo;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, String pathLower) {
        return new Builder(name, pathLower);
    }

    /**
     * Builder for {@link FolderMetadata}.
     */
    public static class Builder {
        protected final String name;
        protected final String pathLower;

        protected String parentSharedFolderId;
        protected String id;
        protected String sharedFolderId;
        protected FolderSharingInfo sharingInfo;

        protected Builder(String name, String pathLower) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (pathLower == null) {
                throw new IllegalArgumentException("Required value for 'pathLower' is null");
            }
            this.pathLower = pathLower;
            this.parentSharedFolderId = null;
            this.id = null;
            this.sharedFolderId = null;
            this.sharingInfo = null;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Deprecated. Please use
         *     :field:'FileSharingInfo.parent_shared_folder_id' or
         *     :field:'FolderSharingInfo.parent_shared_folder_id' instead. Must
         *     match pattern "{@code [-_0-9a-zA-Z:]+}".
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
         * @param id  A unique identifier for the folder. Must have length of at
         *     least 1.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withId(String id) {
            if (id != null) {
                if (id.length() < 1) {
                    throw new IllegalArgumentException("String 'id' is shorter than 1");
                }
            }
            this.id = id;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedFolderId  Deprecated. Please use :field:'sharing_info'
         *     instead. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
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
         * Set value for optional field.
         *
         * @param sharingInfo  Set if the folder is contained in a shared folder
         *     or is a shared folder mount point.
         *
         * @return this builder
         */
        public Builder withSharingInfo(FolderSharingInfo sharingInfo) {
            this.sharingInfo = sharingInfo;
            return this;
        }

        /**
         * Builds an instance of {@link FolderMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderMetadata}
         */
        public FolderMetadata build() {
            return new FolderMetadata(name, pathLower, parentSharedFolderId, id, sharedFolderId, sharingInfo);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            id,
            sharedFolderId,
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
            FolderMetadata other = (FolderMetadata) obj;
            return ((this.id == other.id) || (this.id != null && this.id.equals(other.id)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId != null && this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.sharingInfo == other.sharingInfo) || (this.sharingInfo != null && this.sharingInfo.equals(other.sharingInfo)))
                && ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
                && ((this.getPathLower() == other.getPathLower()) || (this.getPathLower().equals(other.getPathLower())))
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

    public static FolderMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FolderMetadata> _JSON_WRITER = new JsonWriter<FolderMetadata>() {
        public final void write(FolderMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "folder");
            Metadata._JSON_WRITER.writeFields(x, g);
            FolderMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FolderMetadata x, JsonGenerator g) throws IOException {
            if (x.id != null) {
                g.writeFieldName("id");
                g.writeString(x.id);
            }
            if (x.sharedFolderId != null) {
                g.writeFieldName("shared_folder_id");
                g.writeString(x.sharedFolderId);
            }
            if (x.sharingInfo != null) {
                g.writeFieldName("sharing_info");
                FolderSharingInfo._JSON_WRITER.write(x.sharingInfo, g);
            }
        }
    };

    public static final JsonReader<FolderMetadata> _JSON_READER = new JsonReader<FolderMetadata>() {
        public final FolderMetadata read(JsonParser parser) throws IOException, JsonReadException {
            FolderMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FolderMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "folder".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final FolderMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String name = null;
            String pathLower = null;
            String parentSharedFolderId = null;
            String id = null;
            String sharedFolderId = null;
            FolderSharingInfo sharingInfo = null;
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
                else if ("parent_shared_folder_id".equals(fieldName)) {
                    parentSharedFolderId = JsonReader.StringReader
                        .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                }
                else if ("id".equals(fieldName)) {
                    id = JsonReader.StringReader
                        .readField(parser, "id", id);
                }
                else if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("sharing_info".equals(fieldName)) {
                    sharingInfo = FolderSharingInfo._JSON_READER
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
            return new FolderMetadata(name, pathLower, parentSharedFolderId, id, sharedFolderId, sharingInfo);
        }
    };
}
