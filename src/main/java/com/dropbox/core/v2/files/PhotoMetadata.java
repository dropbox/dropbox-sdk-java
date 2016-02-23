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
 * Metadata for a photo.
 */
public class PhotoMetadata extends MediaMetadata {
    // struct PhotoMetadata


    /**
     * Metadata for a photo.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param dimensions  Dimension of the photo/video.
     * @param location  The GPS coordinate of the photo/video.
     * @param timeTaken  The timestamp when the photo/video is taken.
     */
    public PhotoMetadata(Dimensions dimensions, GpsCoordinates location, Date timeTaken) {
        super(dimensions, location, timeTaken);
    }

    /**
     * Metadata for a photo.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public PhotoMetadata() {
        this(null, null, null);
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
     * Builder for {@link PhotoMetadata}.
     */
    public static class Builder extends MediaMetadata.Builder {

        protected Builder() {
        }

        /**
         * Builds an instance of {@link PhotoMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link PhotoMetadata}
         */
        public PhotoMetadata build() {
            return new PhotoMetadata(dimensions, location, timeTaken);
        }
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            PhotoMetadata other = (PhotoMetadata) obj;
            return ((this.getDimensions() == other.getDimensions()) || (this.getDimensions() != null && this.getDimensions().equals(other.getDimensions())))
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

    public static PhotoMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PhotoMetadata> _JSON_WRITER = new JsonWriter<PhotoMetadata>() {
        public final void write(PhotoMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "photo");
            MediaMetadata._JSON_WRITER.writeFields(x, g);
            PhotoMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(PhotoMetadata x, JsonGenerator g) throws IOException {
        }
    };

    public static final JsonReader<PhotoMetadata> _JSON_READER = new JsonReader<PhotoMetadata>() {
        public final PhotoMetadata read(JsonParser parser) throws IOException, JsonReadException {
            PhotoMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final PhotoMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "photo".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final PhotoMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
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
            return new PhotoMetadata(dimensions, location, timeTaken);
        }
    };
}
