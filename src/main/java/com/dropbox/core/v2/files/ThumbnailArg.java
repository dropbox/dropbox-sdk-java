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

@JsonSerialize(using=ThumbnailArg.Serializer.class)
@JsonDeserialize(using=ThumbnailArg.Deserializer.class)
class ThumbnailArg {
    // struct ThumbnailArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final ThumbnailFormat format;
    protected final ThumbnailSize size;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code
     *     null}.
     * @param format  The format for the thumbnail image, jpeg (default) or png.
     *     For  images that are photos, jpeg should be preferred, while png is
     *     better for screenshots and digital arts.
     * @param size  The size for the thumbnail image.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ThumbnailArg(String path, ThumbnailFormat format, ThumbnailSize size) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (format == null) {
            throw new IllegalArgumentException("Required value for 'format' is null");
        }
        this.format = format;
        if (size == null) {
            throw new IllegalArgumentException("Required value for 'size' is null");
        }
        this.size = size;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ThumbnailArg(String path) {
        this(path, ThumbnailFormat.JPEG, ThumbnailSize.W64H64);
    }

    /**
     * The path to the image file you want to thumbnail.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * The format for the thumbnail image, jpeg (default) or png. For  images
     * that are photos, jpeg should be preferred, while png is  better for
     * screenshots and digital arts.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ThumbnailFormat.JPEG.
     */
    public ThumbnailFormat getFormat() {
        return format;
    }

    /**
     * The size for the thumbnail image.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ThumbnailSize.W64H64.
     */
    public ThumbnailSize getSize() {
        return size;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link ThumbnailArg}.
     */
    public static class Builder {
        protected final String path;

        protected ThumbnailFormat format;
        protected ThumbnailSize size;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.format = ThumbnailFormat.JPEG;
            this.size = ThumbnailSize.W64H64;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ThumbnailFormat.JPEG}. </p>
         *
         * @param format  The format for the thumbnail image, jpeg (default) or
         *     png. For  images that are photos, jpeg should be preferred, while
         *     png is  better for screenshots and digital arts. Defaults to
         *     {@code ThumbnailFormat.JPEG} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withFormat(ThumbnailFormat format) {
            if (format != null) {
                this.format = format;
            }
            else {
                this.format = ThumbnailFormat.JPEG;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ThumbnailSize.W64H64}. </p>
         *
         * @param size  The size for the thumbnail image. Defaults to {@code
         *     ThumbnailSize.W64H64} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withSize(ThumbnailSize size) {
            if (size != null) {
                this.size = size;
            }
            else {
                this.size = ThumbnailSize.W64H64;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ThumbnailArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ThumbnailArg}
         */
        public ThumbnailArg build() {
            return new ThumbnailArg(path, format, size);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            format,
            size
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
            ThumbnailArg other = (ThumbnailArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.format == other.format) || (this.format.equals(other.format)))
                && ((this.size == other.size) || (this.size.equals(other.size)))
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

    static final class Serializer extends StructJsonSerializer<ThumbnailArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ThumbnailArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ThumbnailArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ThumbnailArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ThumbnailArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("format", value.format);
            g.writeObjectField("size", value.size);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ThumbnailArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ThumbnailArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ThumbnailArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ThumbnailArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ThumbnailArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            ThumbnailFormat format = ThumbnailFormat.JPEG;
            ThumbnailSize size = ThumbnailSize.W64H64;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("format".equals(_field)) {
                    format = _p.readValueAs(ThumbnailFormat.class);
                    _p.nextToken();
                }
                else if ("size".equals(_field)) {
                    size = _p.readValueAs(ThumbnailSize.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new ThumbnailArg(path, format, size);
        }
    }
}
