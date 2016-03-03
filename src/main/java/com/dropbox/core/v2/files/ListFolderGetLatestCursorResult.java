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

@JsonSerialize(using=ListFolderGetLatestCursorResult.Serializer.class)
@JsonDeserialize(using=ListFolderGetLatestCursorResult.Deserializer.class)
public class ListFolderGetLatestCursorResult {
    // struct ListFolderGetLatestCursorResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String cursor;

    /**
     *
     * @param cursor  Pass the cursor into {@link
     *     DbxUserFilesRequests#listFolderContinue(String)} to see what's
     *     changed in the folder since your previous query. Must have length of
     *     at least 1 and not be {@code null}.
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
     * Pass the cursor into {@link
     * DbxUserFilesRequests#listFolderContinue(String)} to see what's changed in
     * the folder since your previous query.
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

    static final class Serializer extends StructJsonSerializer<ListFolderGetLatestCursorResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFolderGetLatestCursorResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFolderGetLatestCursorResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFolderGetLatestCursorResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFolderGetLatestCursorResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("cursor", value.cursor);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFolderGetLatestCursorResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFolderGetLatestCursorResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFolderGetLatestCursorResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFolderGetLatestCursorResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFolderGetLatestCursorResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String cursor = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (cursor == null) {
                throw new JsonParseException(_p, "Required field \"cursor\" is missing.");
            }

            return new ListFolderGetLatestCursorResult(cursor);
        }
    }
}
