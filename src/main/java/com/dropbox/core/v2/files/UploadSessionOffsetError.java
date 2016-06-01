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

public class UploadSessionOffsetError {
    // struct UploadSessionOffsetError

    protected final long correctOffset;

    /**
     *
     * @param correctOffset  The offset up to which data has been collected.
     */
    public UploadSessionOffsetError(long correctOffset) {
        this.correctOffset = correctOffset;
    }

    /**
     * The offset up to which data has been collected.
     *
     * @return value for this field.
     */
    public long getCorrectOffset() {
        return correctOffset;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            correctOffset
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
            UploadSessionOffsetError other = (UploadSessionOffsetError) obj;
            return this.correctOffset == other.correctOffset;
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
    static final class Serializer extends StructSerializer<UploadSessionOffsetError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionOffsetError value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("correct_offset");
            StoneSerializers.uInt64().serialize(value.correctOffset, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionOffsetError deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionOffsetError value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_correctOffset = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("correct_offset".equals(field)) {
                        f_correctOffset = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_correctOffset == null) {
                    throw new JsonParseException(p, "Required field \"correct_offset\" missing.");
                }
                value = new UploadSessionOffsetError(f_correctOffset);
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
