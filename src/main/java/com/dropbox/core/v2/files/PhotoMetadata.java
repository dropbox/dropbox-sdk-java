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
    static final class Serializer extends StructSerializer<PhotoMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PhotoMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("photo", g);
            if (value.dimensions != null) {
                g.writeFieldName("dimensions");
                StoneSerializers.nullable(Dimensions.Serializer.INSTANCE).serialize(value.dimensions, g);
            }
            if (value.location != null) {
                g.writeFieldName("location");
                StoneSerializers.nullable(GpsCoordinates.Serializer.INSTANCE).serialize(value.location, g);
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
        public PhotoMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PhotoMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("photo".equals(tag)) {
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
                        f_dimensions = StoneSerializers.nullable(Dimensions.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("location".equals(field)) {
                        f_location = StoneSerializers.nullable(GpsCoordinates.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("time_taken".equals(field)) {
                        f_timeTaken = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new PhotoMetadata(f_dimensions, f_location, f_timeTaken);
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
