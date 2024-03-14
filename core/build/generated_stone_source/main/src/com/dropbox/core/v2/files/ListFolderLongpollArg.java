/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

class ListFolderLongpollArg {
    // struct files.ListFolderLongpollArg (files.stone)

    protected final String cursor;
    protected final long timeout;

    /**
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxUserFilesRequests#listFolder(String)} or {@link
     *     DbxUserFilesRequests#listFolderContinue(String)}. Cursors retrieved
     *     by setting {@link ListFolderArg#getIncludeMediaInfo} to {@code true}
     *     are not supported. Must have length of at least 1 and not be {@code
     *     null}.
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
    public ListFolderLongpollArg(@javax.annotation.Nonnull String cursor, long timeout) {
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
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxUserFilesRequests#listFolder(String)} or {@link
     *     DbxUserFilesRequests#listFolderContinue(String)}. Cursors retrieved
     *     by setting {@link ListFolderArg#getIncludeMediaInfo} to {@code true}
     *     are not supported. Must have length of at least 1 and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderLongpollArg(String cursor) {
        this(cursor, 30L);
    }

    /**
     * A cursor as returned by {@link DbxUserFilesRequests#listFolder(String)}
     * or {@link DbxUserFilesRequests#listFolderContinue(String)}. Cursors
     * retrieved by setting {@link ListFolderArg#getIncludeMediaInfo} to {@code
     * true} are not supported.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<ListFolderLongpollArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderLongpollArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("timeout");
            StoneSerializers.uInt64().serialize(value.timeout, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFolderLongpollArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFolderLongpollArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_cursor = null;
                Long f_timeout = 30L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("timeout".equals(field)) {
                        f_timeout = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                value = new ListFolderLongpollArg(f_cursor, f_timeout);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
