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

/**
 * GPS coordinates for a photo or video.
 */
@JsonSerialize(using=GpsCoordinates.Serializer.class)
@JsonDeserialize(using=GpsCoordinates.Deserializer.class)
public class GpsCoordinates {
    // struct GpsCoordinates

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final double latitude;
    protected final double longitude;

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

    static final class Serializer extends StructJsonSerializer<GpsCoordinates> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GpsCoordinates.class);
        }

        public Serializer(boolean unwrapping) {
            super(GpsCoordinates.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GpsCoordinates> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GpsCoordinates value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("latitude", value.latitude);
            g.writeObjectField("longitude", value.longitude);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GpsCoordinates> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GpsCoordinates.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GpsCoordinates.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GpsCoordinates> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GpsCoordinates deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Double latitude = null;
            Double longitude = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("latitude".equals(_field)) {
                    latitude = _p.getDoubleValue();
                    _p.nextToken();
                }
                else if ("longitude".equals(_field)) {
                    longitude = _p.getDoubleValue();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (latitude == null) {
                throw new JsonParseException(_p, "Required field \"latitude\" is missing.");
            }
            if (longitude == null) {
                throw new JsonParseException(_p, "Required field \"longitude\" is missing.");
            }

            return new GpsCoordinates(latitude, longitude);
        }
    }
}
