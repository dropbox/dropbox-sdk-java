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

@JsonSerialize(using=UploadWriteFailed.Serializer.class)
@JsonDeserialize(using=UploadWriteFailed.Deserializer.class)
public class UploadWriteFailed {
    // struct UploadWriteFailed

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final WriteError reason;
    protected final String uploadSessionId;

    /**
     *
     * @param reason  The reason why the file couldn't be saved. Must not be
     *     {@code null}.
     * @param uploadSessionId  The upload session ID; this may be used to retry
     *     the commit. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadWriteFailed(WriteError reason, String uploadSessionId) {
        if (reason == null) {
            throw new IllegalArgumentException("Required value for 'reason' is null");
        }
        this.reason = reason;
        if (uploadSessionId == null) {
            throw new IllegalArgumentException("Required value for 'uploadSessionId' is null");
        }
        this.uploadSessionId = uploadSessionId;
    }

    /**
     * The reason why the file couldn't be saved.
     *
     * @return value for this field, never {@code null}.
     */
    public WriteError getReason() {
        return reason;
    }

    /**
     * The upload session ID; this may be used to retry the commit.
     *
     * @return value for this field, never {@code null}.
     */
    public String getUploadSessionId() {
        return uploadSessionId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            reason,
            uploadSessionId
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
            UploadWriteFailed other = (UploadWriteFailed) obj;
            return ((this.reason == other.reason) || (this.reason.equals(other.reason)))
                && ((this.uploadSessionId == other.uploadSessionId) || (this.uploadSessionId.equals(other.uploadSessionId)))
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

    static final class Serializer extends StructJsonSerializer<UploadWriteFailed> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadWriteFailed.class);
        }

        public Serializer(boolean unwrapping) {
            super(UploadWriteFailed.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UploadWriteFailed> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UploadWriteFailed value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("reason", value.reason);
            g.writeObjectField("upload_session_id", value.uploadSessionId);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UploadWriteFailed> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadWriteFailed.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UploadWriteFailed.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UploadWriteFailed> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UploadWriteFailed deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            WriteError reason = null;
            String uploadSessionId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("reason".equals(_field)) {
                    reason = _p.readValueAs(WriteError.class);
                    _p.nextToken();
                }
                else if ("upload_session_id".equals(_field)) {
                    uploadSessionId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (reason == null) {
                throw new JsonParseException(_p, "Required field \"reason\" is missing.");
            }
            if (uploadSessionId == null) {
                throw new JsonParseException(_p, "Required field \"upload_session_id\" is missing.");
            }

            return new UploadWriteFailed(reason, uploadSessionId);
        }
    }
}
