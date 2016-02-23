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
 * Dimensions for a photo or video.
 */
public class Dimensions {
    // struct Dimensions

    private final long height;
    private final long width;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static Dimensions fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<Dimensions> _JSON_WRITER = new JsonWriter<Dimensions>() {
        public final void write(Dimensions x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            Dimensions._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(Dimensions x, JsonGenerator g) throws IOException {
            g.writeFieldName("height");
            g.writeNumber(x.height);
            g.writeFieldName("width");
            g.writeNumber(x.width);
        }
    };

    public static final JsonReader<Dimensions> _JSON_READER = new JsonReader<Dimensions>() {
        public final Dimensions read(JsonParser parser) throws IOException, JsonReadException {
            Dimensions result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final Dimensions readFields(JsonParser parser) throws IOException, JsonReadException {
            Long height = null;
            Long width = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("height".equals(fieldName)) {
                    height = JsonReader.UInt64Reader
                        .readField(parser, "height", height);
                }
                else if ("width".equals(fieldName)) {
                    width = JsonReader.UInt64Reader
                        .readField(parser, "width", width);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (height == null) {
                throw new JsonReadException("Required field \"height\" is missing.", parser.getTokenLocation());
            }
            if (width == null) {
                throw new JsonReadException("Required field \"width\" is missing.", parser.getTokenLocation());
            }
            return new Dimensions(height, width);
        }
    };
}
