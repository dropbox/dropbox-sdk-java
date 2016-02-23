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

public class DeleteArg {
    // struct DeleteArg

    private final String path;

    /**
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteArg(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
    }

    /**
     * Path in the user's Dropbox to delete.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path
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
            DeleteArg other = (DeleteArg) obj;
            return (this.path == other.path) || (this.path.equals(other.path));
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

    public static DeleteArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DeleteArg> _JSON_WRITER = new JsonWriter<DeleteArg>() {
        public final void write(DeleteArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DeleteArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(DeleteArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
        }
    };

    public static final JsonReader<DeleteArg> _JSON_READER = new JsonReader<DeleteArg>() {
        public final DeleteArg read(JsonParser parser) throws IOException, JsonReadException {
            DeleteArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final DeleteArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new DeleteArg(path);
        }
    };
}
