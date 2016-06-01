/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

class ThumbnailArg {
    // struct ThumbnailArg

    protected final String path;
    protected final ThumbnailFormat format;
    protected final ThumbnailSize size;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})}" and not
     *     be {@code null}.
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
        if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})", path)) {
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
     *     pattern "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})}" and not
     *     be {@code null}.
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
     *     pattern "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})}" and not
     *     be {@code null}.
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
            if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})", path)) {
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
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static final class Serializer extends StructSerializer<ThumbnailArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ThumbnailArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("format");
            ThumbnailFormat.Serializer.INSTANCE.serialize(value.format, g);
            g.writeFieldName("size");
            ThumbnailSize.Serializer.INSTANCE.serialize(value.size, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ThumbnailArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ThumbnailArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                ThumbnailFormat f_format = ThumbnailFormat.JPEG;
                ThumbnailSize f_size = ThumbnailSize.W64H64;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("format".equals(field)) {
                        f_format = ThumbnailFormat.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("size".equals(field)) {
                        f_size = ThumbnailSize.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ThumbnailArg(f_path, f_format, f_size);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
