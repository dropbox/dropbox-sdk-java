/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

class ListSharedLinksArg {
    // struct ListSharedLinksArg

    protected final String path;
    protected final String cursor;
    protected final Boolean directOnly;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  See {@link DbxUserSharingRequests#listSharedLinks()}
     *     description. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})}".
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
            if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})", path)) {
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
         *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPath(String path) {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})", path)) {
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
    static final class Serializer extends StructSerializer<ListSharedLinksArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListSharedLinksArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.path != null) {
                g.writeFieldName("path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.path, g);
            }
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (value.directOnly != null) {
                g.writeFieldName("direct_only");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.directOnly, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListSharedLinksArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListSharedLinksArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                String f_cursor = null;
                Boolean f_directOnly = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("direct_only".equals(field)) {
                        f_directOnly = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ListSharedLinksArg(f_path, f_cursor, f_directOnly);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
