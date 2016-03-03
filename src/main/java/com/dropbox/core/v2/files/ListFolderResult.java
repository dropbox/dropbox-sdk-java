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
import java.util.List;

@JsonSerialize(using=ListFolderResult.Serializer.class)
@JsonDeserialize(using=ListFolderResult.Deserializer.class)
public class ListFolderResult {
    // struct ListFolderResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<Metadata> entries;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     *
     * @param entries  The files and (direct) subfolders in the folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserFilesRequests#listFolderContinue(String)} to see what's
     *     changed in the folder since your previous query. Must have length of
     *     at least 1 and not be {@code null}.
     * @param hasMore  If true, then there are more entries available. Pass the
     *     cursor to {@link DbxUserFilesRequests#listFolderContinue(String)} to
     *     retrieve the rest.
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
     * Pass the cursor into {@link
     * DbxUserFilesRequests#listFolderContinue(String)} to see what's changed in
     * the folder since your previous query.
     *
     * @return value for this field, never {@code null}.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * If true, then there are more entries available. Pass the cursor to {@link
     * DbxUserFilesRequests#listFolderContinue(String)} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            entries,
            cursor,
            hasMore
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

    static final class Serializer extends StructJsonSerializer<ListFolderResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFolderResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFolderResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFolderResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFolderResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("entries", value.entries);
            g.writeObjectField("cursor", value.cursor);
            g.writeObjectField("has_more", value.hasMore);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFolderResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFolderResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFolderResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFolderResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFolderResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<Metadata> entries = null;
            String cursor = null;
            Boolean hasMore = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("entries".equals(_field)) {
                    expectArrayStart(_p);
                    entries = new java.util.ArrayList<Metadata>();
                    while (!isArrayEnd(_p)) {
                        Metadata _x = null;
                        _x = _p.readValueAs(Metadata.class);
                        _p.nextToken();
                        entries.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("has_more".equals(_field)) {
                    hasMore = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (entries == null) {
                throw new JsonParseException(_p, "Required field \"entries\" is missing.");
            }
            if (cursor == null) {
                throw new JsonParseException(_p, "Required field \"cursor\" is missing.");
            }
            if (hasMore == null) {
                throw new JsonParseException(_p, "Required field \"has_more\" is missing.");
            }

            return new ListFolderResult(entries, cursor, hasMore);
        }
    }
}
