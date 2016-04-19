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

@JsonSerialize(using=UploadSessionStartResult.Serializer.class)
@JsonDeserialize(using=UploadSessionStartResult.Deserializer.class)
public class UploadSessionStartResult {
    // struct UploadSessionStartResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sessionId;

    /**
     *
     * @param sessionId  A unique identifier for the upload session. Pass this
     *     to {@link DbxUserFilesRequests#uploadSessionAppend(String,long)} and
     *     {@link
     *     DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo)}.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartResult(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
    }

    /**
     * A unique identifier for the upload session. Pass this to {@link
     * DbxUserFilesRequests#uploadSessionAppend(String,long)} and {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo)}.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sessionId
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
            UploadSessionStartResult other = (UploadSessionStartResult) obj;
            return (this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId));
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

    static final class Serializer extends StructJsonSerializer<UploadSessionStartResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadSessionStartResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(UploadSessionStartResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UploadSessionStartResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UploadSessionStartResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UploadSessionStartResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadSessionStartResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UploadSessionStartResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UploadSessionStartResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UploadSessionStartResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("session_id".equals(_field)) {
                    sessionId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sessionId == null) {
                throw new JsonParseException(_p, "Required field \"session_id\" is missing.");
            }

            return new UploadSessionStartResult(sessionId);
        }
    }
}
