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

public class ListFolderGetLatestCursorResult {
    // struct ListFolderGetLatestCursorResult

    private final String cursor;

    /**
     *
     * @param cursor  Pass the cursor into {@link
     *     DbxFiles#listFolderContinue(String)} to see what's changed in the
     *     folder since your previous query. Must have length of at least 1 and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderGetLatestCursorResult(String cursor) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        if (cursor.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        this.cursor = cursor;
    }

    /**
     * Pass the cursor into {@link DbxFiles#listFolderContinue(String)} to see
     * what's changed in the folder since your previous query.
     *
     * @return value for this field, never {@code null}.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor
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
            ListFolderGetLatestCursorResult other = (ListFolderGetLatestCursorResult) obj;
            return (this.cursor == other.cursor) || (this.cursor.equals(other.cursor));
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

    public static ListFolderGetLatestCursorResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderGetLatestCursorResult> _JSON_WRITER = new JsonWriter<ListFolderGetLatestCursorResult>() {
        public final void write(ListFolderGetLatestCursorResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFolderGetLatestCursorResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFolderGetLatestCursorResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("cursor");
            g.writeString(x.cursor);
        }
    };

    public static final JsonReader<ListFolderGetLatestCursorResult> _JSON_READER = new JsonReader<ListFolderGetLatestCursorResult>() {
        public final ListFolderGetLatestCursorResult read(JsonParser parser) throws IOException, JsonReadException {
            ListFolderGetLatestCursorResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFolderGetLatestCursorResult readFields(JsonParser parser) throws IOException, JsonReadException {
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (cursor == null) {
                throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
            }
            return new ListFolderGetLatestCursorResult(cursor);
        }
    };
}
