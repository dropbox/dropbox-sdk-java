/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Metadata for a photo or video.
 */
public class MediaMetadata {
    // struct files.MediaMetadata (files.stone)

    protected final Dimensions dimensions;
    protected final GpsCoordinates location;
    protected final Date timeTaken;

    /**
     * Metadata for a photo or video.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param dimensions  Dimension of the photo/video.
     * @param location  The GPS coordinate of the photo/video.
     * @param timeTaken  The timestamp when the photo/video is taken.
     */
    public MediaMetadata(Dimensions dimensions, GpsCoordinates location, Date timeTaken) {
        this.dimensions = dimensions;
        this.location = location;
        this.timeTaken = LangUtil.truncateMillis(timeTaken);
    }

    /**
     * Metadata for a photo or video.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public MediaMetadata() {
        this(null, null, null);
    }

    /**
     * Dimension of the photo/video.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Dimensions getDimensions() {
        return dimensions;
    }

    /**
     * The GPS coordinate of the photo/video.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public GpsCoordinates getLocation() {
        return location;
    }

    /**
     * The timestamp when the photo/video is taken.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getTimeTaken() {
        return timeTaken;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link MediaMetadata}.
     */
    public static class Builder {

        protected Dimensions dimensions;
        protected GpsCoordinates location;
        protected Date timeTaken;

        protected Builder() {
            this.dimensions = null;
            this.location = null;
            this.timeTaken = null;
        }

        /**
         * Set value for optional field.
         *
         * @param dimensions  Dimension of the photo/video.
         *
         * @return this builder
         */
        public Builder withDimensions(Dimensions dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param location  The GPS coordinate of the photo/video.
         *
         * @return this builder
         */
        public Builder withLocation(GpsCoordinates location) {
            this.location = location;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param timeTaken  The timestamp when the photo/video is taken.
         *
         * @return this builder
         */
        public Builder withTimeTaken(Date timeTaken) {
            this.timeTaken = LangUtil.truncateMillis(timeTaken);
            return this;
        }

        /**
         * Builds an instance of {@link MediaMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link MediaMetadata}
         */
        public MediaMetadata build() {
            return new MediaMetadata(dimensions, location, timeTaken);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            dimensions,
            location,
            timeTaken
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
            MediaMetadata other = (MediaMetadata) obj;
            return ((this.dimensions == other.dimensions) || (this.dimensions != null && this.dimensions.equals(other.dimensions)))
                && ((this.location == other.location) || (this.location != null && this.location.equals(other.location)))
                && ((this.timeTaken == other.timeTaken) || (this.timeTaken != null && this.timeTaken.equals(other.timeTaken)))
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
    static class Serializer extends StructSerializer<MediaMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MediaMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (value instanceof PhotoMetadata) {
                PhotoMetadata.Serializer.INSTANCE.serialize((PhotoMetadata) value, g, collapse);
                return;
            }
            if (value instanceof VideoMetadata) {
                VideoMetadata.Serializer.INSTANCE.serialize((VideoMetadata) value, g, collapse);
                return;
            }
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.dimensions != null) {
                g.writeFieldName("dimensions");
                StoneSerializers.nullableStruct(Dimensions.Serializer.INSTANCE).serialize(value.dimensions, g);
            }
            if (value.location != null) {
                g.writeFieldName("location");
                StoneSerializers.nullableStruct(GpsCoordinates.Serializer.INSTANCE).serialize(value.location, g);
            }
            if (value.timeTaken != null) {
                g.writeFieldName("time_taken");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.timeTaken, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MediaMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MediaMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                Dimensions f_dimensions = null;
                GpsCoordinates f_location = null;
                Date f_timeTaken = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("dimensions".equals(field)) {
                        f_dimensions = StoneSerializers.nullableStruct(Dimensions.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("location".equals(field)) {
                        f_location = StoneSerializers.nullableStruct(GpsCoordinates.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("time_taken".equals(field)) {
                        f_timeTaken = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new MediaMetadata(f_dimensions, f_location, f_timeTaken);
            }
            else if ("".equals(tag)) {
                value = Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("photo".equals(tag)) {
                value = PhotoMetadata.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("video".equals(tag)) {
                value = VideoMetadata.Serializer.INSTANCE.deserialize(p, true);
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
