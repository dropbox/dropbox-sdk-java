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

@JsonSerialize(using=UploadSessionCursor.Serializer.class)
@JsonDeserialize(using=UploadSessionCursor.Deserializer.class)
public class UploadSessionCursor {
    // struct UploadSessionCursor

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sessionId;
    protected final long offset;

    /**
     *
     * @param sessionId  The upload session ID (returned by {@link
     *     DbxUserFilesRequests#uploadSessionStart()}). Must not be {@code
     *     null}.
     * @param offset  The amount of data that has been uploaded so far. We use
     *     this to make sure upload data isn't lost or duplicated in the event
     *     of a network error.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionCursor(String sessionId, long offset) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
        this.offset = offset;
    }

    /**
     * The upload session ID (returned by {@link
     * DbxUserFilesRequests#uploadSessionStart()}).
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The amount of data that has been uploaded so far. We use this to make
     * sure upload data isn't lost or duplicated in the event of a network
     * error.
     *
     * @return value for this field.
     */
    public long getOffset() {
        return offset;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sessionId,
            offset
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
            UploadSessionCursor other = (UploadSessionCursor) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && (this.offset == other.offset)
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

    static final class Serializer extends StructJsonSerializer<UploadSessionCursor> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadSessionCursor.class);
        }

        public Serializer(boolean unwrapping) {
            super(UploadSessionCursor.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UploadSessionCursor> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UploadSessionCursor value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
            g.writeObjectField("offset", value.offset);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UploadSessionCursor> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadSessionCursor.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UploadSessionCursor.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UploadSessionCursor> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UploadSessionCursor deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;
            Long offset = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("session_id".equals(_field)) {
                    sessionId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("offset".equals(_field)) {
                    offset = _p.getLongValue();
                    assertUnsigned(_p, offset);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sessionId == null) {
                throw new JsonParseException(_p, "Required field \"session_id\" is missing.");
            }
            if (offset == null) {
                throw new JsonParseException(_p, "Required field \"offset\" is missing.");
            }

            return new UploadSessionCursor(sessionId, offset);
        }
    }
}
