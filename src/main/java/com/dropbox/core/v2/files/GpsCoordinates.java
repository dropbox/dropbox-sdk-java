/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * GPS coordinates for a photo or video.
 */
public class GpsCoordinates {
    // struct GpsCoordinates

    private final double latitude;
    private final double longitude;

    /**
     * GPS coordinates for a photo or video.
     *
     * @param latitude  Latitude of the GPS coordinates.
     * @param longitude  Longitude of the GPS coordinates.
     */
    public GpsCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Latitude of the GPS coordinates.
     *
     * @return value for this field.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Longitude of the GPS coordinates.
     *
     * @return value for this field.
     */
    public double getLongitude() {
        return longitude;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            latitude,
            longitude
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
            GpsCoordinates other = (GpsCoordinates) obj;
            return (this.latitude == other.latitude)
                && (this.longitude == other.longitude)
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

    public static GpsCoordinates fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GpsCoordinates> _JSON_WRITER = new JsonWriter<GpsCoordinates>() {
        public final void write(GpsCoordinates x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GpsCoordinates._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GpsCoordinates x, JsonGenerator g) throws IOException {
            g.writeFieldName("latitude");
            g.writeNumber(x.latitude);
            g.writeFieldName("longitude");
            g.writeNumber(x.longitude);
        }
    };

    public static final JsonReader<GpsCoordinates> _JSON_READER = new JsonReader<GpsCoordinates>() {
        public final GpsCoordinates read(JsonParser parser) throws IOException, JsonReadException {
            GpsCoordinates result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GpsCoordinates readFields(JsonParser parser) throws IOException, JsonReadException {
            Double latitude = null;
            Double longitude = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("latitude".equals(fieldName)) {
                    latitude = JsonReader.Float64Reader
                        .readField(parser, "latitude", latitude);
                }
                else if ("longitude".equals(fieldName)) {
                    longitude = JsonReader.Float64Reader
                        .readField(parser, "longitude", longitude);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (latitude == null) {
                throw new JsonReadException("Required field \"latitude\" is missing.", parser.getTokenLocation());
            }
            if (longitude == null) {
                throw new JsonReadException("Required field \"longitude\" is missing.", parser.getTokenLocation());
            }
            return new GpsCoordinates(latitude, longitude);
        }
    };
}
