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

public class UploadSessionOffsetError {
    // struct UploadSessionOffsetError

    private final long correctOffset;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UploadSessionOffsetError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UploadSessionOffsetError> _JSON_WRITER = new JsonWriter<UploadSessionOffsetError>() {
        public final void write(UploadSessionOffsetError x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UploadSessionOffsetError._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UploadSessionOffsetError x, JsonGenerator g) throws IOException {
            g.writeFieldName("correct_offset");
            g.writeNumber(x.correctOffset);
        }
    };

    public static final JsonReader<UploadSessionOffsetError> _JSON_READER = new JsonReader<UploadSessionOffsetError>() {
        public final UploadSessionOffsetError read(JsonParser parser) throws IOException, JsonReadException {
            UploadSessionOffsetError result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UploadSessionOffsetError readFields(JsonParser parser) throws IOException, JsonReadException {
            Long correctOffset = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("correct_offset".equals(fieldName)) {
                    correctOffset = JsonReader.UInt64Reader
                        .readField(parser, "correct_offset", correctOffset);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (correctOffset == null) {
                throw new JsonReadException("Required field \"correct_offset\" is missing.", parser.getTokenLocation());
            }
            return new UploadSessionOffsetError(correctOffset);
        }
    };
}
