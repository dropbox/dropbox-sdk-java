/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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

@JsonSerialize(using=TransferFolderArg.Serializer.class)
@JsonDeserialize(using=TransferFolderArg.Deserializer.class)
class TransferFolderArg {
    // struct TransferFolderArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sharedFolderId;
    protected final String toDropboxId;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param toDropboxId  A account or team member ID to transfer ownership to.
     *     Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TransferFolderArg(String sharedFolderId, String toDropboxId) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (toDropboxId == null) {
            throw new IllegalArgumentException("Required value for 'toDropboxId' is null");
        }
        if (toDropboxId.length() < 1) {
            throw new IllegalArgumentException("String 'toDropboxId' is shorter than 1");
        }
        this.toDropboxId = toDropboxId;
    }

    /**
     * The ID for the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * A account or team member ID to transfer ownership to.
     *
     * @return value for this field, never {@code null}.
     */
    public String getToDropboxId() {
        return toDropboxId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            toDropboxId
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
            TransferFolderArg other = (TransferFolderArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.toDropboxId == other.toDropboxId) || (this.toDropboxId.equals(other.toDropboxId)))
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

    static final class Serializer extends StructJsonSerializer<TransferFolderArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TransferFolderArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(TransferFolderArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TransferFolderArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TransferFolderArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            g.writeObjectField("to_dropbox_id", value.toDropboxId);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TransferFolderArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TransferFolderArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TransferFolderArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TransferFolderArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TransferFolderArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sharedFolderId = null;
            String toDropboxId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("to_dropbox_id".equals(_field)) {
                    toDropboxId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_id\" is missing.");
            }
            if (toDropboxId == null) {
                throw new JsonParseException(_p, "Required field \"to_dropbox_id\" is missing.");
            }

            return new TransferFolderArg(sharedFolderId, toDropboxId);
        }
    }
}
