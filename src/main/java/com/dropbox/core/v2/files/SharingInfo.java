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
 * Sharing info for a file or folder.
 */
public class SharingInfo {
    // struct SharingInfo

    private final boolean readOnly;

    /**
     * Sharing info for a file or folder.
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     */
    public SharingInfo(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * True if the file or folder is inside a read-only shared folder.
     *
     * @return value for this field.
     */
    public boolean getReadOnly() {
        return readOnly;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            readOnly
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
            SharingInfo other = (SharingInfo) obj;
            return this.readOnly == other.readOnly;
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

    public static SharingInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharingInfo> _JSON_WRITER = new JsonWriter<SharingInfo>() {
        public final void write(SharingInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SharingInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SharingInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("read_only");
            g.writeBoolean(x.readOnly);
        }
    };

    public static final JsonReader<SharingInfo> _JSON_READER = new JsonReader<SharingInfo>() {
        public final SharingInfo read(JsonParser parser) throws IOException, JsonReadException {
            SharingInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SharingInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            Boolean readOnly = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("read_only".equals(fieldName)) {
                    readOnly = JsonReader.BooleanReader
                        .readField(parser, "read_only", readOnly);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (readOnly == null) {
                throw new JsonReadException("Required field \"read_only\" is missing.", parser.getTokenLocation());
            }
            return new SharingInfo(readOnly);
        }
    };
}
