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

@JsonSerialize(using=GetMetadataArg.Serializer.class)
@JsonDeserialize(using=GetMetadataArg.Deserializer.class)
class GetMetadataArg {
    // struct GetMetadataArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final boolean includeMediaInfo;

    /**
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo} is
     *     set for photo and video.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArg(String path, boolean includeMediaInfo) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.includeMediaInfo = includeMediaInfo;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArg(String path) {
        this(path, false);
    }

    /**
     * The path of a file or folder on Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * If true, {@link FileMetadata#getMediaInfo} is set for photo and video.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeMediaInfo() {
        return includeMediaInfo;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            includeMediaInfo
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
            GetMetadataArg other = (GetMetadataArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.includeMediaInfo == other.includeMediaInfo)
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

    static final class Serializer extends StructJsonSerializer<GetMetadataArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetMetadataArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetMetadataArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetMetadataArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetMetadataArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("include_media_info", value.includeMediaInfo);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetMetadataArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetMetadataArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetMetadataArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetMetadataArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetMetadataArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            Boolean includeMediaInfo = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("include_media_info".equals(_field)) {
                    includeMediaInfo = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new GetMetadataArg(path, includeMediaInfo);
        }
    }
}
