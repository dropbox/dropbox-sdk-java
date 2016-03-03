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
 * Dimensions for a photo or video.
 */
@JsonSerialize(using=Dimensions.Serializer.class)
@JsonDeserialize(using=Dimensions.Deserializer.class)
public class Dimensions {
    // struct Dimensions

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final long height;
    protected final long width;

    /**
     * Dimensions for a photo or video.
     *
     * @param height  Height of the photo/video.
     * @param width  Width of the photo/video.
     */
    public Dimensions(long height, long width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Height of the photo/video.
     *
     * @return value for this field.
     */
    public long getHeight() {
        return height;
    }

    /**
     * Width of the photo/video.
     *
     * @return value for this field.
     */
    public long getWidth() {
        return width;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            height,
            width
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
            Dimensions other = (Dimensions) obj;
            return (this.height == other.height)
                && (this.width == other.width)
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

    static final class Serializer extends StructJsonSerializer<Dimensions> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(Dimensions.class);
        }

        public Serializer(boolean unwrapping) {
            super(Dimensions.class, unwrapping);
        }

        @Override
        protected JsonSerializer<Dimensions> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(Dimensions value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("height", value.height);
            g.writeObjectField("width", value.width);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<Dimensions> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(Dimensions.class);
        }

        public Deserializer(boolean unwrapping) {
            super(Dimensions.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<Dimensions> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public Dimensions deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Long height = null;
            Long width = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("height".equals(_field)) {
                    height = _p.getLongValue();
                    assertUnsigned(_p, height);
                    _p.nextToken();
                }
                else if ("width".equals(_field)) {
                    width = _p.getLongValue();
                    assertUnsigned(_p, width);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (height == null) {
                throw new JsonParseException(_p, "Required field \"height\" is missing.");
            }
            if (width == null) {
                throw new JsonParseException(_p, "Required field \"width\" is missing.");
            }

            return new Dimensions(height, width);
        }
    }
}
