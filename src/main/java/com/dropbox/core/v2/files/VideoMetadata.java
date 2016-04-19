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
import java.util.Date;

/**
 * Metadata for a video.
 */
@JsonSerialize(using=VideoMetadata.Serializer.class)
@JsonDeserialize(using=VideoMetadata.Deserializer.class)
public class VideoMetadata extends MediaMetadata {
    // struct VideoMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
        int hash = java.util.Arrays.hashCode(new Object [] {
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

    static final class Serializer extends StructJsonSerializer<VideoMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(VideoMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(VideoMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(VideoMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeStringField(".tag", "video");
            if (value.dimensions != null) {
                g.writeObjectField("dimensions", value.dimensions);
            }
            if (value.location != null) {
                g.writeObjectField("location", value.location);
            }
            if (value.timeTaken != null) {
                g.writeObjectField("time_taken", value.timeTaken);
            }
            if (value.duration != null) {
                g.writeObjectField("duration", value.duration);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<VideoMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(VideoMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(VideoMetadata.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<VideoMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public VideoMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p, "video");

            Dimensions dimensions = null;
            GpsCoordinates location = null;
            Date timeTaken = null;
            Long duration = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("dimensions".equals(_field)) {
                    dimensions = _p.readValueAs(Dimensions.class);
                    _p.nextToken();
                }
                else if ("location".equals(_field)) {
                    location = _p.readValueAs(GpsCoordinates.class);
                    _p.nextToken();
                }
                else if ("time_taken".equals(_field)) {
                    timeTaken = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("duration".equals(_field)) {
                    duration = _p.getLongValue();
                    assertUnsigned(_p, duration);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new VideoMetadata(dimensions, location, timeTaken, duration);
        }
    }
}
