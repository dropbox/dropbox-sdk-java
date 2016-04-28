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

@JsonSerialize(using=GetCopyReferenceArg.Serializer.class)
@JsonDeserialize(using=GetCopyReferenceArg.Deserializer.class)
class GetCopyReferenceArg {
    // struct GetCopyReferenceArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;

    /**
     *
     * @param path  The path to the file or folder you want to get a copy
     *     reference to. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetCopyReferenceArg(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
    }

    /**
     * The path to the file or folder you want to get a copy reference to.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path
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
            GetCopyReferenceArg other = (GetCopyReferenceArg) obj;
            return (this.path == other.path) || (this.path.equals(other.path));
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

    static final class Serializer extends StructJsonSerializer<GetCopyReferenceArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetCopyReferenceArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetCopyReferenceArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetCopyReferenceArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetCopyReferenceArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetCopyReferenceArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetCopyReferenceArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetCopyReferenceArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetCopyReferenceArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetCopyReferenceArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new GetCopyReferenceArg(path);
        }
    }
}
