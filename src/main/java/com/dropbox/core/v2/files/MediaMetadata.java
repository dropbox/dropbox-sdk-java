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
 * Metadata for a photo or video.
 */
public class MediaMetadata {
    // struct MediaMetadata

    private final Dimensions dimensions;
    private final GpsCoordinates location;
    private final Date timeTaken;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MediaMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MediaMetadata> _JSON_WRITER = new JsonWriter<MediaMetadata>() {
        public final void write(MediaMetadata x, JsonGenerator g) throws IOException {
            if (x instanceof PhotoMetadata) {
                PhotoMetadata._JSON_WRITER.write((PhotoMetadata) x, g);
                return;
            }
            if (x instanceof VideoMetadata) {
                VideoMetadata._JSON_WRITER.write((VideoMetadata) x, g);
                return;
            }

            g.writeStartObject();
            MediaMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MediaMetadata x, JsonGenerator g) throws IOException {
            if (x.dimensions != null) {
                g.writeFieldName("dimensions");
                Dimensions._JSON_WRITER.write(x.dimensions, g);
            }
            if (x.location != null) {
                g.writeFieldName("location");
                GpsCoordinates._JSON_WRITER.write(x.location, g);
            }
            if (x.timeTaken != null) {
                g.writeFieldName("time_taken");
                writeDateIso(x.timeTaken, g);
            }
        }
    };

    public static final JsonReader<MediaMetadata> _JSON_READER = new JsonReader<MediaMetadata>() {
        public final MediaMetadata read(JsonParser parser) throws IOException, JsonReadException {
            MediaMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MediaMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null && tags.length > 0) {
                if ("photo".equals(tags[0])) {
                    return PhotoMetadata._JSON_READER.readFromTags(tags, parser);
                }
                if ("video".equals(tags[0])) {
                    return VideoMetadata._JSON_READER.readFromTags(tags, parser);
                }
                // If no match, fall back to base class
            }
            return readFields(parser);
        }

        public final MediaMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            Dimensions dimensions = null;
            GpsCoordinates location = null;
            Date timeTaken = null;
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
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new MediaMetadata(dimensions, location, timeTaken);
        }
    };
}
