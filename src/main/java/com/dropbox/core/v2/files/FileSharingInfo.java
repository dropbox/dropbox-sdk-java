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
 * Sharing info for a file which is contained by a shared folder.
 */
@JsonSerialize(using=FileSharingInfo.Serializer.class)
@JsonDeserialize(using=FileSharingInfo.Deserializer.class)
public class FileSharingInfo extends SharingInfo {
    // struct FileSharingInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String parentSharedFolderId;
    protected final String modifiedBy;

    /**
     * Sharing info for a file which is contained by a shared folder.
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  ID of shared folder that holds this file.
     *     Must match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param modifiedBy  The last user who modified the file. This field will
     *     be null if the user's account has been deleted. Must have length of
     *     at least 40 and have length of at most 40.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileSharingInfo(boolean readOnly, String parentSharedFolderId, String modifiedBy) {
        super(readOnly);
        if (parentSharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'parentSharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = parentSharedFolderId;
        if (modifiedBy != null) {
            if (modifiedBy.length() < 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is shorter than 40");
            }
            if (modifiedBy.length() > 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is longer than 40");
            }
        }
        this.modifiedBy = modifiedBy;
    }

    /**
     * Sharing info for a file which is contained by a shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  ID of shared folder that holds this file.
     *     Must match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileSharingInfo(boolean readOnly, String parentSharedFolderId) {
        this(readOnly, parentSharedFolderId, null);
    }

    /**
     * ID of shared folder that holds this file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The last user who modified the file. This field will be null if the
     * user's account has been deleted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            parentSharedFolderId,
            modifiedBy
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
            FileSharingInfo other = (FileSharingInfo) obj;
            return (this.readOnly == other.readOnly)
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.modifiedBy == other.modifiedBy) || (this.modifiedBy != null && this.modifiedBy.equals(other.modifiedBy)))
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

    static final class Serializer extends StructJsonSerializer<FileSharingInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FileSharingInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(FileSharingInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<FileSharingInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(FileSharingInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("read_only", value.readOnly);
            g.writeObjectField("parent_shared_folder_id", value.parentSharedFolderId);
            if (value.modifiedBy != null) {
                g.writeObjectField("modified_by", value.modifiedBy);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<FileSharingInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FileSharingInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(FileSharingInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<FileSharingInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public FileSharingInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Boolean readOnly = null;
            String parentSharedFolderId = null;
            String modifiedBy = null;

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
                else if ("modified_by".equals(_field)) {
                    modifiedBy = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (readOnly == null) {
                throw new JsonParseException(_p, "Required field \"read_only\" is missing.");
            }
            if (parentSharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"parent_shared_folder_id\" is missing.");
            }

            return new FileSharingInfo(readOnly, parentSharedFolderId, modifiedBy);
        }
    }
}
