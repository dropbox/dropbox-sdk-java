/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ListFoldersContinueArg {
    // struct ListFoldersContinueArg

    private final String cursor;

    /**
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxSharing#listFolders()} or {@link
     *     DbxSharing#listFoldersContinue(String)}. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersContinueArg(String cursor) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
    }

    /**
     * The cursor returned by your last call to {@link DbxSharing#listFolders()}
     * or {@link DbxSharing#listFoldersContinue(String)}.
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
            ListFoldersContinueArg other = (ListFoldersContinueArg) obj;
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

    public static ListFoldersContinueArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFoldersContinueArg> _JSON_WRITER = new JsonWriter<ListFoldersContinueArg>() {
        public final void write(ListFoldersContinueArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFoldersContinueArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFoldersContinueArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("cursor");
            g.writeString(x.cursor);
        }
    };

    public static final JsonReader<ListFoldersContinueArg> _JSON_READER = new JsonReader<ListFoldersContinueArg>() {
        public final ListFoldersContinueArg read(JsonParser parser) throws IOException, JsonReadException {
            ListFoldersContinueArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFoldersContinueArg readFields(JsonParser parser) throws IOException, JsonReadException {
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
            return new ListFoldersContinueArg(cursor);
        }
    };
}
