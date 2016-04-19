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

@JsonSerialize(using=UploadSessionOffsetError.Serializer.class)
@JsonDeserialize(using=UploadSessionOffsetError.Deserializer.class)
public class UploadSessionOffsetError {
    // struct UploadSessionOffsetError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final long correctOffset;

    /**
     *
     * @param correctOffset  The offset up to which data has been collected.
     */
    public UploadSessionOffsetError(long correctOffset) {
        this.correctOffset = correctOffset;
    }

    /**
     * The offset up to which data has been collected.
     *
     * @return value for this field.
     */
    public long getCorrectOffset() {
        return correctOffset;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            correctOffset
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
            UploadSessionOffsetError other = (UploadSessionOffsetError) obj;
            return this.correctOffset == other.correctOffset;
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

    static final class Serializer extends StructJsonSerializer<UploadSessionOffsetError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadSessionOffsetError.class);
        }

        public Serializer(boolean unwrapping) {
            super(UploadSessionOffsetError.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UploadSessionOffsetError> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UploadSessionOffsetError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("correct_offset", value.correctOffset);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UploadSessionOffsetError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadSessionOffsetError.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UploadSessionOffsetError.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UploadSessionOffsetError> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UploadSessionOffsetError deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Long correctOffset = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("correct_offset".equals(_field)) {
                    correctOffset = _p.getLongValue();
                    assertUnsigned(_p, correctOffset);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (correctOffset == null) {
                throw new JsonParseException(_p, "Required field \"correct_offset\" is missing.");
            }

            return new UploadSessionOffsetError(correctOffset);
        }
    }
}
