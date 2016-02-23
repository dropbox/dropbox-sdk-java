/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class ListFolderResult {
    // struct ListFolderResult

    private final List<Metadata> entries;
    private final String cursor;
    private final boolean hasMore;

    /**
     *
     * @param entries  The files and (direct) subfolders in the folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxFiles#listFolderContinue(String)} to see what's changed in the
     *     folder since your previous query. Must have length of at least 1 and
     *     not be {@code null}.
     * @param hasMore  If true, then there are more entries available. Pass the
     *     cursor to {@link DbxFiles#listFolderContinue(String)} to retrieve the
     *     rest.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult(List<Metadata> entries, String cursor, boolean hasMore) {
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (Metadata x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        if (cursor.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * The files and (direct) subfolders in the folder.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Metadata> getEntries() {
        return entries;
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

    /**
     * If true, then there are more entries available. Pass the cursor to {@link
     * DbxFiles#listFolderContinue(String)} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ListFolderResult other = (ListFolderResult) obj;
            return ((this.entries == other.entries) || (this.entries.equals(other.entries)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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

    public static ListFolderResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderResult> _JSON_WRITER = new JsonWriter<ListFolderResult>() {
        public final void write(ListFolderResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFolderResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFolderResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("entries");
            g.writeStartArray();
            for (Metadata item: x.entries) {
                if (item != null) {
                    Metadata._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("cursor");
            g.writeString(x.cursor);
            g.writeFieldName("has_more");
            g.writeBoolean(x.hasMore);
        }
    };

    public static final JsonReader<ListFolderResult> _JSON_READER = new JsonReader<ListFolderResult>() {
        public final ListFolderResult read(JsonParser parser) throws IOException, JsonReadException {
            ListFolderResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFolderResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<Metadata> entries = null;
            String cursor = null;
            Boolean hasMore = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("entries".equals(fieldName)) {
                    entries = JsonArrayReader.mk(Metadata._JSON_READER)
                        .readField(parser, "entries", entries);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else if ("has_more".equals(fieldName)) {
                    hasMore = JsonReader.BooleanReader
                        .readField(parser, "has_more", hasMore);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (entries == null) {
                throw new JsonReadException("Required field \"entries\" is missing.", parser.getTokenLocation());
            }
            if (cursor == null) {
                throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
            }
            if (hasMore == null) {
                throw new JsonReadException("Required field \"has_more\" is missing.", parser.getTokenLocation());
            }
            return new ListFolderResult(entries, cursor, hasMore);
        }
    };
}
