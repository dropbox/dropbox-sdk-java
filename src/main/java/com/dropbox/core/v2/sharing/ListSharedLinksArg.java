/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ListSharedLinksArg {
    // struct ListSharedLinksArg

    private final String path;
    private final String cursor;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  See {@link DbxSharing#listSharedLinks()} description. Must
     *     match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}".
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxSharing#listSharedLinks()}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListSharedLinksArg(String path, String cursor) {
        if (path != null) {
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
        }
        this.path = path;
        this.cursor = cursor;
    }

    /**
     * The default values for unset fields will be used.
     */
    public ListSharedLinksArg() {
        this(null, null);
    }

    /**
     * See {@link DbxSharing#listSharedLinks()} description.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPath() {
        return path;
    }

    /**
     * The cursor returned by your last call to {@link
     * DbxSharing#listSharedLinks()}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
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

        protected Builder() {
            this.path = null;
            this.cursor = null;
        }

        /**
         * Set value for optional field.
         *
         * @param path  See {@link DbxSharing#listSharedLinks()} description.
         *     Must match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}".
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
         *     DbxSharing#listSharedLinks()}.
         *
         * @return this builder
         */
        public Builder withCursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds an instance of {@link ListSharedLinksArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListSharedLinksArg}
         */
        public ListSharedLinksArg build() {
            return new ListSharedLinksArg(path, cursor);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
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
            ListSharedLinksArg other = (ListSharedLinksArg) obj;
            return ((this.path == other.path) || (this.path != null && this.path.equals(other.path)))
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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

    public static ListSharedLinksArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListSharedLinksArg> _JSON_WRITER = new JsonWriter<ListSharedLinksArg>() {
        public final void write(ListSharedLinksArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListSharedLinksArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListSharedLinksArg x, JsonGenerator g) throws IOException {
            if (x.path != null) {
                g.writeFieldName("path");
                g.writeString(x.path);
            }
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
        }
    };

    public static final JsonReader<ListSharedLinksArg> _JSON_READER = new JsonReader<ListSharedLinksArg>() {
        public final ListSharedLinksArg read(JsonParser parser) throws IOException, JsonReadException {
            ListSharedLinksArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListSharedLinksArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new ListSharedLinksArg(path, cursor);
        }
    };
}
