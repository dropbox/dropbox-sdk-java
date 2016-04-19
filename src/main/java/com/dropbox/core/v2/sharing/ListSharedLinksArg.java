/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

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

@JsonSerialize(using=ListSharedLinksArg.Serializer.class)
@JsonDeserialize(using=ListSharedLinksArg.Deserializer.class)
class ListSharedLinksArg {
    // struct ListSharedLinksArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final String cursor;
    protected final Boolean directOnly;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  See {@link DbxUserSharingRequests#listSharedLinks()}
     *     description. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}".
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserSharingRequests#listSharedLinks()}.
     * @param directOnly  See {@link DbxUserSharingRequests#listSharedLinks()}
     *     description.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListSharedLinksArg(String path, String cursor, Boolean directOnly) {
        if (path != null) {
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
        }
        this.path = path;
        this.cursor = cursor;
        this.directOnly = directOnly;
    }

    /**
     * The default values for unset fields will be used.
     */
    public ListSharedLinksArg() {
        this(null, null, null);
    }

    /**
     * See {@link DbxUserSharingRequests#listSharedLinks()} description.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPath() {
        return path;
    }

    /**
     * The cursor returned by your last call to {@link
     * DbxUserSharingRequests#listSharedLinks()}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * See {@link DbxUserSharingRequests#listSharedLinks()} description.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getDirectOnly() {
        return directOnly;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link ListSharedLinksArg}.
     */
    public static class Builder {

        protected String path;
        protected String cursor;
        protected Boolean directOnly;

        protected Builder() {
            this.path = null;
            this.cursor = null;
            this.directOnly = null;
        }

        /**
         * Set value for optional field.
         *
         * @param path  See {@link DbxUserSharingRequests#listSharedLinks()}
         *     description. Must match pattern "{@code
         *     ((/|id:).*)|(rev:[0-9a-f]{9,})}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPath(String path) {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                    throw new IllegalArgumentException("String 'path' does not match pattern");
                }
            }
            this.path = path;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param cursor  The cursor returned by your last call to {@link
         *     DbxUserSharingRequests#listSharedLinks()}.
         *
         * @return this builder
         */
        public Builder withCursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param directOnly  See {@link
         *     DbxUserSharingRequests#listSharedLinks()} description.
         *
         * @return this builder
         */
        public Builder withDirectOnly(Boolean directOnly) {
            this.directOnly = directOnly;
            return this;
        }

        /**
         * Builds an instance of {@link ListSharedLinksArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListSharedLinksArg}
         */
        public ListSharedLinksArg build() {
            return new ListSharedLinksArg(path, cursor, directOnly);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            cursor,
            directOnly
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
            ListSharedLinksArg other = (ListSharedLinksArg) obj;
            return ((this.path == other.path) || (this.path != null && this.path.equals(other.path)))
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
                && ((this.directOnly == other.directOnly) || (this.directOnly != null && this.directOnly.equals(other.directOnly)))
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

    static final class Serializer extends StructJsonSerializer<ListSharedLinksArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListSharedLinksArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListSharedLinksArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListSharedLinksArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListSharedLinksArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value.path != null) {
                g.writeObjectField("path", value.path);
            }
            if (value.cursor != null) {
                g.writeObjectField("cursor", value.cursor);
            }
            if (value.directOnly != null) {
                g.writeObjectField("direct_only", value.directOnly);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListSharedLinksArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListSharedLinksArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListSharedLinksArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListSharedLinksArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListSharedLinksArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            String cursor = null;
            Boolean directOnly = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("direct_only".equals(_field)) {
                    directOnly = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new ListSharedLinksArg(path, cursor, directOnly);
        }
    }
}
