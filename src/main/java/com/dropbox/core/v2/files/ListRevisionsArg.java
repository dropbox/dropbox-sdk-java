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

@JsonSerialize(using=ListRevisionsArg.Serializer.class)
@JsonDeserialize(using=ListRevisionsArg.Deserializer.class)
class ListRevisionsArg {
    // struct ListRevisionsArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final long limit;

    /**
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param limit  The maximum number of revision entries returned. Must be
     *     greater than or equal to 1 and be less than or equal to 100.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(String path, long limit) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 100L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 100L");
        }
        this.limit = limit;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(String path) {
        this(path, 10L);
    }

    /**
     * The path to the file you want to see the revisions of.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * The maximum number of revision entries returned.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     10L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            limit
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
            ListRevisionsArg other = (ListRevisionsArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.limit == other.limit)
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

    static final class Serializer extends StructJsonSerializer<ListRevisionsArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListRevisionsArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListRevisionsArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListRevisionsArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListRevisionsArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("limit", value.limit);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListRevisionsArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListRevisionsArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListRevisionsArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListRevisionsArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListRevisionsArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            Long limit = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("limit".equals(_field)) {
                    limit = _p.getLongValue();
                    assertUnsigned(_p, limit);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new ListRevisionsArg(path, limit);
        }
    }
}
