/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Dimensions for a photo or video.
 */
public class Dimensions {
    // struct files.Dimensions (files.stone)

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
        int hash = Arrays.hashCode(new Object [] {
            this.height,
            this.width
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<Dimensions> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Dimensions value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("height");
            StoneSerializers.uInt64().serialize(value.height, g);
            g.writeFieldName("width");
            StoneSerializers.uInt64().serialize(value.width, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Dimensions deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Dimensions value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_height = null;
                Long f_width = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("height".equals(field)) {
                        f_height = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("width".equals(field)) {
                        f_width = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_height == null) {
                    throw new JsonParseException(p, "Required field \"height\" missing.");
                }
                if (f_width == null) {
                    throw new JsonParseException(p, "Required field \"width\" missing.");
                }
                value = new Dimensions(f_height, f_width);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
