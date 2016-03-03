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

@JsonSerialize(using=UnshareFolderArg.Serializer.class)
@JsonDeserialize(using=UnshareFolderArg.Deserializer.class)
class UnshareFolderArg {
    // struct UnshareFolderArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sharedFolderId;
    protected final boolean leaveACopy;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param leaveACopy  If true, members of this shared folder will get a copy
     *     of this folder after it's unshared. Otherwise, it will be removed
     *     from their Dropbox. The current user, who is an owner, will always
     *     retain their copy.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UnshareFolderArg(String sharedFolderId, boolean leaveACopy) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        this.leaveACopy = leaveACopy;
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
     * If true, members of this shared folder will get a copy of this folder
     * after it's unshared. Otherwise, it will be removed from their Dropbox.
     * The current user, who is an owner, will always retain their copy.
     *
     * @return value for this field.
     */
    public boolean getLeaveACopy() {
        return leaveACopy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            leaveACopy
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
            UnshareFolderArg other = (UnshareFolderArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && (this.leaveACopy == other.leaveACopy)
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

    static final class Serializer extends StructJsonSerializer<UnshareFolderArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UnshareFolderArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(UnshareFolderArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UnshareFolderArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UnshareFolderArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            g.writeObjectField("leave_a_copy", value.leaveACopy);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UnshareFolderArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UnshareFolderArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UnshareFolderArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UnshareFolderArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UnshareFolderArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sharedFolderId = null;
            Boolean leaveACopy = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("leave_a_copy".equals(_field)) {
                    leaveACopy = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_id\" is missing.");
            }
            if (leaveACopy == null) {
                throw new JsonParseException(_p, "Required field \"leave_a_copy\" is missing.");
            }

            return new UnshareFolderArg(sharedFolderId, leaveACopy);
        }
    }
}
