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

class SearchV2Arg {
    // struct files.SearchV2Arg (files.stone)

    protected final String query;
    protected final SearchOptions options;
    protected final boolean includeHighlights;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must not be {@code null}.
     * @param options  Options for more targeted search results.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Arg(String query, SearchOptions options, boolean includeHighlights) {
        if (query == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        this.query = query;
        this.options = options;
        this.includeHighlights = includeHighlights;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Arg(String query) {
        this(query, null, false);
    }

    /**
     * The string to search for. May match across multiple fields based on the
     * request arguments.
     *
     * @return value for this field, never {@code null}.
     */
    public String getQuery() {
        return query;
    }

    /**
     * Options for more targeted search results.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public SearchOptions getOptions() {
        return options;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeHighlights() {
        return includeHighlights;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String query) {
        return new Builder(query);
    }

    /**
     * Builder for {@link SearchV2Arg}.
     */
    public static class Builder {
        protected final String query;

        protected SearchOptions options;
        protected boolean includeHighlights;

        protected Builder(String query) {
            if (query == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
            }
            this.query = query;
            this.options = null;
            this.includeHighlights = false;
        }

        /**
         * Set value for optional field.
         *
         * @param options  Options for more targeted search results.
         *
         * @return this builder
         */
        public Builder withOptions(SearchOptions options) {
            this.options = options;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param includeHighlights  Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeHighlights(Boolean includeHighlights) {
            if (includeHighlights != null) {
                this.includeHighlights = includeHighlights;
            }
            else {
                this.includeHighlights = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link SearchV2Arg} configured with this
         * builder's values
         *
         * @return new instance of {@link SearchV2Arg}
         */
        public SearchV2Arg build() {
            return new SearchV2Arg(query, options, includeHighlights);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            query,
            options,
            includeHighlights
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
            SearchV2Arg other = (SearchV2Arg) obj;
            return ((this.query == other.query) || (this.query.equals(other.query)))
                && ((this.options == other.options) || (this.options != null && this.options.equals(other.options)))
                && (this.includeHighlights == other.includeHighlights)
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
    static class Serializer extends StructSerializer<SearchV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchV2Arg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("query");
            StoneSerializers.string().serialize(value.query, g);
            if (value.options != null) {
                g.writeFieldName("options");
                StoneSerializers.nullableStruct(SearchOptions.Serializer.INSTANCE).serialize(value.options, g);
            }
            g.writeFieldName("include_highlights");
            StoneSerializers.boolean_().serialize(value.includeHighlights, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SearchV2Arg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SearchV2Arg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_query = null;
                SearchOptions f_options = null;
                Boolean f_includeHighlights = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("query".equals(field)) {
                        f_query = StoneSerializers.string().deserialize(p);
                    }
                    else if ("options".equals(field)) {
                        f_options = StoneSerializers.nullableStruct(SearchOptions.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("include_highlights".equals(field)) {
                        f_includeHighlights = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_query == null) {
                    throw new JsonParseException(p, "Required field \"query\" missing.");
                }
                value = new SearchV2Arg(f_query, f_options, f_includeHighlights);
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
