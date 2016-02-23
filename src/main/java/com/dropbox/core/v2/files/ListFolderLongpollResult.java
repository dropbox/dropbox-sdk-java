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

public class ListFolderLongpollResult {
    // struct ListFolderLongpollResult

    private final boolean changes;
    private final Long backoff;

    /**
     *
     * @param changes  Indicates whether new changes are available. If true,
     *     call {@link DbxFiles#listFolder(String)} to retrieve the changes.
     * @param backoff  If present, backoff for at least this many seconds before
     *     calling {@link DbxFiles#listFolderLongpoll(String)} again.
     */
    public ListFolderLongpollResult(boolean changes, Long backoff) {
        this.changes = changes;
        this.backoff = backoff;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param changes  Indicates whether new changes are available. If true,
     *     call {@link DbxFiles#listFolder(String)} to retrieve the changes.
     */
    public ListFolderLongpollResult(boolean changes) {
        this(changes, null);
    }

    /**
     * Indicates whether new changes are available. If true, call {@link
     * DbxFiles#listFolder(String)} to retrieve the changes.
     *
     * @return value for this field.
     */
    public boolean getChanges() {
        return changes;
    }

    /**
     * If present, backoff for at least this many seconds before calling {@link
     * DbxFiles#listFolderLongpoll(String)} again.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Long getBackoff() {
        return backoff;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            changes,
            backoff
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
            ListFolderLongpollResult other = (ListFolderLongpollResult) obj;
            return (this.changes == other.changes)
                && ((this.backoff == other.backoff) || (this.backoff != null && this.backoff.equals(other.backoff)))
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

    public static ListFolderLongpollResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderLongpollResult> _JSON_WRITER = new JsonWriter<ListFolderLongpollResult>() {
        public final void write(ListFolderLongpollResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFolderLongpollResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFolderLongpollResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("changes");
            g.writeBoolean(x.changes);
            if (x.backoff != null) {
                g.writeFieldName("backoff");
                g.writeNumber(x.backoff);
            }
        }
    };

    public static final JsonReader<ListFolderLongpollResult> _JSON_READER = new JsonReader<ListFolderLongpollResult>() {
        public final ListFolderLongpollResult read(JsonParser parser) throws IOException, JsonReadException {
            ListFolderLongpollResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFolderLongpollResult readFields(JsonParser parser) throws IOException, JsonReadException {
            Boolean changes = null;
            Long backoff = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("changes".equals(fieldName)) {
                    changes = JsonReader.BooleanReader
                        .readField(parser, "changes", changes);
                }
                else if ("backoff".equals(fieldName)) {
                    backoff = JsonReader.UInt64Reader
                        .readField(parser, "backoff", backoff);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (changes == null) {
                throw new JsonReadException("Required field \"changes\" is missing.", parser.getTokenLocation());
            }
            return new ListFolderLongpollResult(changes, backoff);
        }
    };
}
