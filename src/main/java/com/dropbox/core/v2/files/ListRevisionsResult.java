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

public class ListRevisionsResult {
    // struct ListRevisionsResult

    private final boolean isDeleted;
    private final List<FileMetadata> entries;

    /**
     *
     * @param isDeleted  If the file is deleted.
     * @param entries  The revisions for the file. Only non-delete revisions
     *     will show up here. Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult(boolean isDeleted, List<FileMetadata> entries) {
        this.isDeleted = isDeleted;
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (FileMetadata x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
    }

    /**
     * If the file is deleted.
     *
     * @return value for this field.
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * The revisions for the file. Only non-delete revisions will show up here.
     *
     * @return value for this field, never {@code null}.
     */
    public List<FileMetadata> getEntries() {
        return entries;
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
            ListRevisionsResult other = (ListRevisionsResult) obj;
            return (this.isDeleted == other.isDeleted)
                && ((this.entries == other.entries) || (this.entries.equals(other.entries)))
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

    public static ListRevisionsResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListRevisionsResult> _JSON_WRITER = new JsonWriter<ListRevisionsResult>() {
        public final void write(ListRevisionsResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListRevisionsResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListRevisionsResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("is_deleted");
            g.writeBoolean(x.isDeleted);
            g.writeFieldName("entries");
            g.writeStartArray();
            for (FileMetadata item: x.entries) {
                if (item != null) {
                    FileMetadata._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<ListRevisionsResult> _JSON_READER = new JsonReader<ListRevisionsResult>() {
        public final ListRevisionsResult read(JsonParser parser) throws IOException, JsonReadException {
            ListRevisionsResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListRevisionsResult readFields(JsonParser parser) throws IOException, JsonReadException {
            Boolean isDeleted = null;
            List<FileMetadata> entries = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("is_deleted".equals(fieldName)) {
                    isDeleted = JsonReader.BooleanReader
                        .readField(parser, "is_deleted", isDeleted);
                }
                else if ("entries".equals(fieldName)) {
                    entries = JsonArrayReader.mk(FileMetadata._JSON_READER)
                        .readField(parser, "entries", entries);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (isDeleted == null) {
                throw new JsonReadException("Required field \"is_deleted\" is missing.", parser.getTokenLocation());
            }
            if (entries == null) {
                throw new JsonReadException("Required field \"entries\" is missing.", parser.getTokenLocation());
            }
            return new ListRevisionsResult(isDeleted, entries);
        }
    };
}
