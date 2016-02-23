/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * Metadata for a video.
 */
public class VideoMetadata extends MediaMetadata {
    // struct VideoMetadata

    private final Long duration;

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
            return ((this.duration == other.duration) || (this.duration != null && this.duration.equals(other.duration)))
                && ((this.getDimensions() == other.getDimensions()) || (this.getDimensions() != null && this.getDimensions().equals(other.getDimensions())))
                && ((this.getLocation() == other.getLocation()) || (this.getLocation() != null && this.getLocation().equals(other.getLocation())))
                && ((this.getTimeTaken() == other.getTimeTaken()) || (this.getTimeTaken() != null && this.getTimeTaken().equals(other.getTimeTaken())))
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

    public static VideoMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<VideoMetadata> _JSON_WRITER = new JsonWriter<VideoMetadata>() {
        public final void write(VideoMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "video");
            MediaMetadata._JSON_WRITER.writeFields(x, g);
            VideoMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(VideoMetadata x, JsonGenerator g) throws IOException {
            if (x.duration != null) {
                g.writeFieldName("duration");
                g.writeNumber(x.duration);
            }
        }
    };

    public static final JsonReader<VideoMetadata> _JSON_READER = new JsonReader<VideoMetadata>() {
        public final VideoMetadata read(JsonParser parser) throws IOException, JsonReadException {
            VideoMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final VideoMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "video".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final VideoMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            Dimensions dimensions = null;
            GpsCoordinates location = null;
            Date timeTaken = null;
            Long duration = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("dimensions".equals(fieldName)) {
                    dimensions = Dimensions._JSON_READER
                        .readField(parser, "dimensions", dimensions);
                }
                else if ("location".equals(fieldName)) {
                    location = GpsCoordinates._JSON_READER
                        .readField(parser, "location", location);
                }
                else if ("time_taken".equals(fieldName)) {
                    timeTaken = JsonDateReader.DropboxV2
                        .readField(parser, "time_taken", timeTaken);
                }
                else if ("duration".equals(fieldName)) {
                    duration = JsonReader.UInt64Reader
                        .readField(parser, "duration", duration);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new VideoMetadata(dimensions, location, timeTaken, duration);
        }
    };
}
