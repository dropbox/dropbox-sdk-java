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

/**
 * Sharing info for a folder which is contained in a shared folder or is a
 * shared folder mount point.
 */
@JsonSerialize(using=FolderSharingInfo.Serializer.class)
@JsonDeserialize(using=FolderSharingInfo.Deserializer.class)
public class FolderSharingInfo extends SharingInfo {
    // struct FolderSharingInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String parentSharedFolderId;
    protected final String sharedFolderId;

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
            return (this.readOnly == other.readOnly)
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId != null && this.sharedFolderId.equals(other.sharedFolderId)))
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

    static final class Serializer extends StructJsonSerializer<FolderSharingInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FolderSharingInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(FolderSharingInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<FolderSharingInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(FolderSharingInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("read_only", value.readOnly);
            if (value.parentSharedFolderId != null) {
                g.writeObjectField("parent_shared_folder_id", value.parentSharedFolderId);
            }
            if (value.sharedFolderId != null) {
                g.writeObjectField("shared_folder_id", value.sharedFolderId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<FolderSharingInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FolderSharingInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(FolderSharingInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<FolderSharingInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public FolderSharingInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Boolean readOnly = null;
            String parentSharedFolderId = null;
            String sharedFolderId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("read_only".equals(_field)) {
                    readOnly = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("parent_shared_folder_id".equals(_field)) {
                    parentSharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (readOnly == null) {
                throw new JsonParseException(_p, "Required field \"read_only\" is missing.");
            }

            return new FolderSharingInfo(readOnly, parentSharedFolderId, sharedFolderId);
        }
    }
}
