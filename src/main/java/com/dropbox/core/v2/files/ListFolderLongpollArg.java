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

public class ListFolderLongpollArg {
    // struct ListFolderLongpollArg

    private final String cursor;
    private final long timeout;

    /**
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxFiles#listFolder(String)} or {@link
     *     DbxFiles#listFolderContinue(String)}. Must have length of at least 1
     *     and not be {@code null}.
     * @param timeout  A timeout in seconds. The request will block for at most
     *     this length of time, plus up to 90 seconds of random jitter added to
     *     avoid the thundering herd problem. Care should be taken when using
     *     this parameter, as some network infrastructure does not support long
     *     timeouts. Must be greater than or equal to 30 and be less than or
     *     equal to 480.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderLongpollArg(String cursor, long timeout) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        if (cursor.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        this.cursor = cursor;
        if (timeout < 30L) {
            throw new IllegalArgumentException("Number 'timeout' is smaller than 30L");
        }
        if (timeout > 480L) {
            throw new IllegalArgumentException("Number 'timeout' is larger than 480L");
        }
        this.timeout = timeout;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxFiles#listFolder(String)} or {@link
     *     DbxFiles#listFolderContinue(String)}. Must have length of at least 1
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderLongpollArg(String cursor) {
        this(cursor, 30L);
    }

    /**
     * A cursor as returned by {@link DbxFiles#listFolder(String)} or {@link
     * DbxFiles#listFolderContinue(String)}
     *
     * @return value for this field, never {@code null}.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * A timeout in seconds. The request will block for at most this length of
     * time, plus up to 90 seconds of random jitter added to avoid the
     * thundering herd problem. Care should be taken when using this parameter,
     * as some network infrastructure does not support long timeouts.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     30L.
     */
    public long getTimeout() {
        return timeout;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor,
            timeout
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
            ListFolderLongpollArg other = (ListFolderLongpollArg) obj;
            return ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.timeout == other.timeout)
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

    public static ListFolderLongpollArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderLongpollArg> _JSON_WRITER = new JsonWriter<ListFolderLongpollArg>() {
        public final void write(ListFolderLongpollArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFolderLongpollArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFolderLongpollArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("cursor");
            g.writeString(x.cursor);
            g.writeFieldName("timeout");
            g.writeNumber(x.timeout);
        }
    };

    public static final JsonReader<ListFolderLongpollArg> _JSON_READER = new JsonReader<ListFolderLongpollArg>() {
        public final ListFolderLongpollArg read(JsonParser parser) throws IOException, JsonReadException {
            ListFolderLongpollArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFolderLongpollArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String cursor = null;
            Long timeout = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else if ("timeout".equals(fieldName)) {
                    timeout = JsonReader.UInt64Reader
                        .readField(parser, "timeout", timeout);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (cursor == null) {
                throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
            }
            return new ListFolderLongpollArg(cursor, timeout);
        }
    };
}
