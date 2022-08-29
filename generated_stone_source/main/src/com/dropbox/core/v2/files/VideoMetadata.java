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
 * Metadata for a video.
 */
public class VideoMetadata extends MediaMetadata {
    // struct files.VideoMetadata (files.stone)

    protected final Long duration;

    /**
     * Metadata for a video.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param dimensions  Dimension of the photo/video.
     * @param location  The GPS coordinate of the photo/video.
     * @param timeTaken  The timestamp when the photo/video is taken.
     * @param duration  The duration of the video in milliseconds.
     */
    public VideoMetadata(Dimensions dimensions, GpsCoordinates location, Date timeTaken, Long duration) {
        super(dimensions, location, timeTaken);
        this.duration = duration;
    }

    /**
     * Metadata for a video.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public VideoMetadata() {
        this(null, null, null, null);
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
     * The duration of the video in milliseconds.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Long getDuration() {
        return duration;
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
     * Builder for {@link VideoMetadata}.
     */
    public static class Builder extends MediaMetadata.Builder {

        protected Long duration;

        protected Builder() {
            this.duration = null;
        }

        /**
         * Set value for optional field.
         *
         * @param duration  The duration of the video in milliseconds.
         *
         * @return this builder
         */
        public Builder withDuration(Long duration) {
            this.duration = duration;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param dimensions  Dimension of the photo/video.
         *
         * @return this builder
         */
        public Builder withDimensions(Dimensions dimensions) {
            super.withDimensions(dimensions);
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
            super.withLocation(location);
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
            super.withTimeTaken(timeTaken);
            return this;
        }

        /**
         * Builds an instance of {@link VideoMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link VideoMetadata}
         */
        public VideoMetadata build() {
            return new VideoMetadata(dimensions, location, timeTaken, duration);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            duration
        });
        hash = (31 * super.hashCode()) + hash;
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
            VideoMetadata other = (VideoMetadata) obj;
            return ((this.dimensions == other.dimensions) || (this.dimensions != null && this.dimensions.equals(other.dimensions)))
                && ((this.location == other.location) || (this.location != null && this.location.equals(other.location)))
                && ((this.timeTaken == other.timeTaken) || (this.timeTaken != null && this.timeTaken.equals(other.timeTaken)))
                && ((this.duration == other.duration) || (this.duration != null && this.duration.equals(other.duration)))
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
    static class Serializer extends StructSerializer<VideoMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(VideoMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("video", g);
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
            if (value.duration != null) {
                g.writeFieldName("duration");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.duration, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public VideoMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            VideoMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("video".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                Dimensions f_dimensions = null;
                GpsCoordinates f_location = null;
                Date f_timeTaken = null;
                Long f_duration = null;
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
                    else if ("duration".equals(field)) {
                        f_duration = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new VideoMetadata(f_dimensions, f_location, f_timeTaken, f_duration);
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
