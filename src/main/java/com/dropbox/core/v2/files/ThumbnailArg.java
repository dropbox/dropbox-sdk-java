/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ThumbnailArg {
    // struct ThumbnailArg

    private final String path;
    private final ThumbnailFormat format;
    private final ThumbnailSize size;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ThumbnailArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ThumbnailArg> _JSON_WRITER = new JsonWriter<ThumbnailArg>() {
        public final void write(ThumbnailArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ThumbnailArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ThumbnailArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("format");
            ThumbnailFormat._JSON_WRITER.write(x.format, g);
            g.writeFieldName("size");
            ThumbnailSize._JSON_WRITER.write(x.size, g);
        }
    };

    public static final JsonReader<ThumbnailArg> _JSON_READER = new JsonReader<ThumbnailArg>() {
        public final ThumbnailArg read(JsonParser parser) throws IOException, JsonReadException {
            ThumbnailArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ThumbnailArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            ThumbnailFormat format = null;
            ThumbnailSize size = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("format".equals(fieldName)) {
                    format = ThumbnailFormat._JSON_READER
                        .readField(parser, "format", format);
                }
                else if ("size".equals(fieldName)) {
                    size = ThumbnailSize._JSON_READER
                        .readField(parser, "size", size);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new ThumbnailArg(path, format, size);
        }
    };
}
