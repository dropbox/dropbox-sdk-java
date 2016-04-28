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

@JsonSerialize(using=UploadSessionAppendArg.Serializer.class)
@JsonDeserialize(using=UploadSessionAppendArg.Deserializer.class)
class UploadSessionAppendArg {
    // struct UploadSessionAppendArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UploadSessionCursor cursor;
    protected final boolean close;

    /**
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     * @param close  If true, current session will be closed. You cannot do
     *     {@link DbxUserFilesRequests#uploadSessionAppend(String,long)} any
     *     more to current session.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendArg(UploadSessionCursor cursor, boolean close) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.close = close;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendArg(UploadSessionCursor cursor) {
        this(cursor, false);
    }

    /**
     * Contains the upload session ID and the offset.
     *
     * @return value for this field, never {@code null}.
     */
    public UploadSessionCursor getCursor() {
        return cursor;
    }

    /**
     * If true, current session will be closed. You cannot do {@link
     * DbxUserFilesRequests#uploadSessionAppend(String,long)} any more to
     * current session
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getClose() {
        return close;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor,
            close
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
            UploadSessionAppendArg other = (UploadSessionAppendArg) obj;
            return ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.close == other.close)
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

    static final class Serializer extends StructJsonSerializer<UploadSessionAppendArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadSessionAppendArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(UploadSessionAppendArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UploadSessionAppendArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UploadSessionAppendArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("cursor", value.cursor);
            g.writeObjectField("close", value.close);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UploadSessionAppendArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadSessionAppendArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UploadSessionAppendArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UploadSessionAppendArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UploadSessionAppendArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            UploadSessionCursor cursor = null;
            boolean close = false;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("cursor".equals(_field)) {
                    cursor = _p.readValueAs(UploadSessionCursor.class);
                    _p.nextToken();
                }
                else if ("close".equals(_field)) {
                    close = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (cursor == null) {
                throw new JsonParseException(_p, "Required field \"cursor\" is missing.");
            }

            return new UploadSessionAppendArg(cursor, close);
        }
    }
}
