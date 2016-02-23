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

public class PreviewArg {
    // struct PreviewArg

    private final String path;
    private final String rev;

    /**
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param rev  Deprecated. Please specify revision in :field:'path' instead.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PreviewArg(String path, String rev) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (rev != null) {
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
        }
        this.rev = rev;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PreviewArg(String path) {
        this(path, null);
    }

    /**
     * The path of the file to preview.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Deprecated. Please specify revision in :field:'path' instead
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getRev() {
        return rev;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            rev
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
            PreviewArg other = (PreviewArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.rev == other.rev) || (this.rev != null && this.rev.equals(other.rev)))
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

    public static PreviewArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PreviewArg> _JSON_WRITER = new JsonWriter<PreviewArg>() {
        public final void write(PreviewArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            PreviewArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(PreviewArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            if (x.rev != null) {
                g.writeFieldName("rev");
                g.writeString(x.rev);
            }
        }
    };

    public static final JsonReader<PreviewArg> _JSON_READER = new JsonReader<PreviewArg>() {
        public final PreviewArg read(JsonParser parser) throws IOException, JsonReadException {
            PreviewArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final PreviewArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            String rev = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("rev".equals(fieldName)) {
                    rev = JsonReader.StringReader
                        .readField(parser, "rev", rev);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new PreviewArg(path, rev);
        }
    };
}
