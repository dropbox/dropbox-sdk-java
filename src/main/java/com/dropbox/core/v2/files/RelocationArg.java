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

public class RelocationArg {
    // struct RelocationArg

    private final String fromPath;
    private final String toPath;

    /**
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationArg(String fromPath, String toPath) {
        if (fromPath == null) {
            throw new IllegalArgumentException("Required value for 'fromPath' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", fromPath)) {
            throw new IllegalArgumentException("String 'fromPath' does not match pattern");
        }
        this.fromPath = fromPath;
        if (toPath == null) {
            throw new IllegalArgumentException("Required value for 'toPath' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", toPath)) {
            throw new IllegalArgumentException("String 'toPath' does not match pattern");
        }
        this.toPath = toPath;
    }

    /**
     * Path in the user's Dropbox to be copied or moved.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFromPath() {
        return fromPath;
    }

    /**
     * Path in the user's Dropbox that is the destination.
     *
     * @return value for this field, never {@code null}.
     */
    public String getToPath() {
        return toPath;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            fromPath,
            toPath
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
            RelocationArg other = (RelocationArg) obj;
            return ((this.fromPath == other.fromPath) || (this.fromPath.equals(other.fromPath)))
                && ((this.toPath == other.toPath) || (this.toPath.equals(other.toPath)))
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

    public static RelocationArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RelocationArg> _JSON_WRITER = new JsonWriter<RelocationArg>() {
        public final void write(RelocationArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RelocationArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RelocationArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("from_path");
            g.writeString(x.fromPath);
            g.writeFieldName("to_path");
            g.writeString(x.toPath);
        }
    };

    public static final JsonReader<RelocationArg> _JSON_READER = new JsonReader<RelocationArg>() {
        public final RelocationArg read(JsonParser parser) throws IOException, JsonReadException {
            RelocationArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RelocationArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String fromPath = null;
            String toPath = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("from_path".equals(fieldName)) {
                    fromPath = JsonReader.StringReader
                        .readField(parser, "from_path", fromPath);
                }
                else if ("to_path".equals(fieldName)) {
                    toPath = JsonReader.StringReader
                        .readField(parser, "to_path", toPath);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (fromPath == null) {
                throw new JsonReadException("Required field \"from_path\" is missing.", parser.getTokenLocation());
            }
            if (toPath == null) {
                throw new JsonReadException("Required field \"to_path\" is missing.", parser.getTokenLocation());
            }
            return new RelocationArg(fromPath, toPath);
        }
    };
}
