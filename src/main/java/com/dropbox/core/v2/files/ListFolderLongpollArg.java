/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=ListFolderLongpollArg.Serializer.class)
@JsonDeserialize(using=ListFolderLongpollArg.Deserializer.class)
class ListFolderLongpollArg {
    // struct ListFolderLongpollArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ListFolderLongpollArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFolderLongpollArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFolderLongpollArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFolderLongpollArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFolderLongpollArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("cursor", value.cursor);
            g.writeObjectField("timeout", value.timeout);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFolderLongpollArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFolderLongpollArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFolderLongpollArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFolderLongpollArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFolderLongpollArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String cursor = null;
            long timeout = 30L;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("timeout".equals(_field)) {
                    timeout = _p.getLongValue();
                    assertUnsigned(_p, timeout);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (cursor == null) {
                throw new JsonParseException(_p, "Required field \"cursor\" is missing.");
            }

            return new ListFolderLongpollArg(cursor, timeout);
        }
    }
}
