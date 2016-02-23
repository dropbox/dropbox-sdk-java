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

public class ListRevisionsArg {
    // struct ListRevisionsArg

    private final String path;
    private final long limit;

    /**
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param limit  The maximum number of revision entries returned. Must be
     *     greater than or equal to 1 and be less than or equal to 100.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(String path, long limit) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 100L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 100L");
        }
        this.limit = limit;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(String path) {
        this(path, 10L);
    }

    /**
     * The path to the file you want to see the revisions of.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * The maximum number of revision entries returned.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     10L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            limit
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
            ListRevisionsArg other = (ListRevisionsArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.limit == other.limit)
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

    public static ListRevisionsArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListRevisionsArg> _JSON_WRITER = new JsonWriter<ListRevisionsArg>() {
        public final void write(ListRevisionsArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListRevisionsArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListRevisionsArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("limit");
            g.writeNumber(x.limit);
        }
    };

    public static final JsonReader<ListRevisionsArg> _JSON_READER = new JsonReader<ListRevisionsArg>() {
        public final ListRevisionsArg read(JsonParser parser) throws IOException, JsonReadException {
            ListRevisionsArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListRevisionsArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            Long limit = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("limit".equals(fieldName)) {
                    limit = JsonReader.UInt64Reader
                        .readField(parser, "limit", limit);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new ListRevisionsArg(path, limit);
        }
    };
}
