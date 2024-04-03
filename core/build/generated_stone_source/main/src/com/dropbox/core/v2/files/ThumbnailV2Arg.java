/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

class ThumbnailV2Arg {
    // struct files.ThumbnailV2Arg (files.stone)

    @Nonnull
    protected final PathOrLink resource;
    @Nonnull
    protected final ThumbnailFormat format;
    @Nonnull
    protected final ThumbnailSize size;
    @Nonnull
    protected final ThumbnailMode mode;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param resource  Information specifying which file to preview. This could
     *     be a path to a file, a shared link pointing to a file, or a shared
     *     link pointing to a folder, with a relative path. Must not be {@code
     *     null}.
     * @param format  The format for the thumbnail image, jpeg (default) or png.
     *     For  images that are photos, jpeg should be preferred, while png is
     *     better for screenshots and digital arts. Must not be {@code null}.
     * @param size  The size for the thumbnail image. Must not be {@code null}.
     * @param mode  How to resize and crop the image to achieve the desired
     *     size. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ThumbnailV2Arg(@Nonnull PathOrLink resource, @Nonnull ThumbnailFormat format, @Nonnull ThumbnailSize size, @Nonnull ThumbnailMode mode) {
        if (resource == null) {
            throw new IllegalArgumentException("Required value for 'resource' is null");
        }
        this.resource = resource;
        if (format == null) {
            throw new IllegalArgumentException("Required value for 'format' is null");
        }
        this.format = format;
        if (size == null) {
            throw new IllegalArgumentException("Required value for 'size' is null");
        }
        this.size = size;
        if (mode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = mode;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param resource  Information specifying which file to preview. This could
     *     be a path to a file, a shared link pointing to a file, or a shared
     *     link pointing to a folder, with a relative path. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ThumbnailV2Arg(@Nonnull PathOrLink resource) {
        this(resource, ThumbnailFormat.JPEG, ThumbnailSize.W64H64, ThumbnailMode.STRICT);
    }

    /**
     * Information specifying which file to preview. This could be a path to a
     * file, a shared link pointing to a file, or a shared link pointing to a
     * folder, with a relative path.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public PathOrLink getResource() {
        return resource;
    }

    /**
     * The format for the thumbnail image, jpeg (default) or png. For  images
     * that are photos, jpeg should be preferred, while png is  better for
     * screenshots and digital arts.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ThumbnailFormat.JPEG.
     */
    @Nonnull
    public ThumbnailFormat getFormat() {
        return format;
    }

    /**
     * The size for the thumbnail image.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ThumbnailSize.W64H64.
     */
    @Nonnull
    public ThumbnailSize getSize() {
        return size;
    }

    /**
     * How to resize and crop the image to achieve the desired size.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ThumbnailMode.STRICT.
     */
    @Nonnull
    public ThumbnailMode getMode() {
        return mode;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param resource  Information specifying which file to preview. This could
     *     be a path to a file, a shared link pointing to a file, or a shared
     *     link pointing to a folder, with a relative path. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(PathOrLink resource) {
        return new Builder(resource);
    }

    /**
     * Builder for {@link ThumbnailV2Arg}.
     */
    public static class Builder {
        protected final PathOrLink resource;

        protected ThumbnailFormat format;
        protected ThumbnailSize size;
        protected ThumbnailMode mode;

        protected Builder(PathOrLink resource) {
            if (resource == null) {
                throw new IllegalArgumentException("Required value for 'resource' is null");
            }
            this.resource = resource;
            this.format = ThumbnailFormat.JPEG;
            this.size = ThumbnailSize.W64H64;
            this.mode = ThumbnailMode.STRICT;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ThumbnailFormat.JPEG}. </p>
         *
         * @param format  The format for the thumbnail image, jpeg (default) or
         *     png. For  images that are photos, jpeg should be preferred, while
         *     png is  better for screenshots and digital arts. Must not be
         *     {@code null}. Defaults to {@code ThumbnailFormat.JPEG} when set
         *     to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
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
         * @param size  The size for the thumbnail image. Must not be {@code
         *     null}. Defaults to {@code ThumbnailSize.W64H64} when set to
         *     {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
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
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ThumbnailMode.STRICT}. </p>
         *
         * @param mode  How to resize and crop the image to achieve the desired
         *     size. Must not be {@code null}. Defaults to {@code
         *     ThumbnailMode.STRICT} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMode(ThumbnailMode mode) {
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = ThumbnailMode.STRICT;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ThumbnailV2Arg} configured with this
         * builder's values
         *
         * @return new instance of {@link ThumbnailV2Arg}
         */
        public ThumbnailV2Arg build() {
            return new ThumbnailV2Arg(resource, format, size, mode);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.resource,
            this.format,
            this.size,
            this.mode
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ThumbnailV2Arg other = (ThumbnailV2Arg) obj;
            return ((this.resource == other.resource) || (this.resource.equals(other.resource)))
                && ((this.format == other.format) || (this.format.equals(other.format)))
                && ((this.size == other.size) || (this.size.equals(other.size)))
                && ((this.mode == other.mode) || (this.mode.equals(other.mode)))
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
    static class Serializer extends StructSerializer<ThumbnailV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ThumbnailV2Arg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("resource");
            PathOrLink.Serializer.INSTANCE.serialize(value.resource, g);
            g.writeFieldName("format");
            ThumbnailFormat.Serializer.INSTANCE.serialize(value.format, g);
            g.writeFieldName("size");
            ThumbnailSize.Serializer.INSTANCE.serialize(value.size, g);
            g.writeFieldName("mode");
            ThumbnailMode.Serializer.INSTANCE.serialize(value.mode, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ThumbnailV2Arg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ThumbnailV2Arg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                PathOrLink f_resource = null;
                ThumbnailFormat f_format = ThumbnailFormat.JPEG;
                ThumbnailSize f_size = ThumbnailSize.W64H64;
                ThumbnailMode f_mode = ThumbnailMode.STRICT;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("resource".equals(field)) {
                        f_resource = PathOrLink.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("format".equals(field)) {
                        f_format = ThumbnailFormat.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("size".equals(field)) {
                        f_size = ThumbnailSize.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("mode".equals(field)) {
                        f_mode = ThumbnailMode.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_resource == null) {
                    throw new JsonParseException(p, "Required field \"resource\" missing.");
                }
                value = new ThumbnailV2Arg(f_resource, f_format, f_size, f_mode);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
