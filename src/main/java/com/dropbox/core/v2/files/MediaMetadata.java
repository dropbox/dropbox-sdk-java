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
 * Metadata for a photo or video.
 */
@JsonSerialize(using=MediaMetadata.Serializer.class)
@JsonDeserialize(using=MediaMetadata.Deserializer.class)
public class MediaMetadata {
    // struct MediaMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
        this.timeTaken = timeTaken;
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
            this.timeTaken = timeTaken;
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
        int hash = java.util.Arrays.hashCode(new Object [] {
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

    static final class Serializer extends StructJsonSerializer<MediaMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MediaMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(MediaMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(MediaMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value.dimensions != null) {
                g.writeObjectField("dimensions", value.dimensions);
            }
            if (value.location != null) {
                g.writeObjectField("location", value.location);
            }
            if (value.timeTaken != null) {
                g.writeObjectField("time_taken", value.timeTaken);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MediaMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MediaMetadata.class, PhotoMetadata.class, VideoMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MediaMetadata.class, unwrapping, PhotoMetadata.class, VideoMetadata.class);
        }

        @Override
        protected JsonDeserializer<MediaMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MediaMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p);
            if ("photo".equals(_subtype_tag)) {
                return readCollapsedStructValue(PhotoMetadata.class, _p, _ctx);
            }
            if ("video".equals(_subtype_tag)) {
                return readCollapsedStructValue(VideoMetadata.class, _p, _ctx);
            }

            Dimensions dimensions = null;
            GpsCoordinates location = null;
            Date timeTaken = null;

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
                else {
                    skipValue(_p);
                }
            }


            return new MediaMetadata(dimensions, location, timeTaken);
        }
    }
}
