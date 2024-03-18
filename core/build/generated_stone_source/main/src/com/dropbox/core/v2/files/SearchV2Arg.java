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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class SearchV2Arg {
    // struct files.SearchV2Arg (files.stone)

    @Nonnull
    protected final String query;
    @Nullable
    protected final SearchOptions options;
    @Nullable
    protected final SearchMatchFieldOptions matchFieldOptions;
    @Nullable
    protected final Boolean includeHighlights;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must have length of at most 1000 and
     *     not be {@code null}.
     * @param options  Options for more targeted search results.
     * @param matchFieldOptions  Options for search results match fields.
     * @param includeHighlights  Deprecated and moved this option to
     *     SearchMatchFieldOptions.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Arg(@Nonnull String query, @Nullable SearchOptions options, @Nullable SearchMatchFieldOptions matchFieldOptions, @Nullable Boolean includeHighlights) {
        if (query == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        if (query.length() > 1000) {
            throw new IllegalArgumentException("String 'query' is longer than 1000");
        }
        this.query = query;
        this.options = options;
        this.matchFieldOptions = matchFieldOptions;
        this.includeHighlights = includeHighlights;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must have length of at most 1000 and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Arg(@Nonnull String query) {
        this(query, null, null, null);
    }

    /**
     * The string to search for. May match across multiple fields based on the
     * request arguments.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getQuery() {
        return query;
    }

    /**
     * Options for more targeted search results.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SearchOptions getOptions() {
        return options;
    }

    /**
     * Options for search results match fields.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SearchMatchFieldOptions getMatchFieldOptions() {
        return matchFieldOptions;
    }

    /**
     * Deprecated and moved this option to SearchMatchFieldOptions.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIncludeHighlights() {
        return includeHighlights;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must have length of at most 1000 and
     *     not be {@code null}.
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
        protected SearchMatchFieldOptions matchFieldOptions;
        protected Boolean includeHighlights;

        protected Builder(String query) {
            if (query == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
            }
            if (query.length() > 1000) {
                throw new IllegalArgumentException("String 'query' is longer than 1000");
            }
            this.query = query;
            this.options = null;
            this.matchFieldOptions = null;
            this.includeHighlights = null;
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
         * @param matchFieldOptions  Options for search results match fields.
         *
         * @return this builder
         */
        public Builder withMatchFieldOptions(SearchMatchFieldOptions matchFieldOptions) {
            this.matchFieldOptions = matchFieldOptions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param includeHighlights  Deprecated and moved this option to
         *     SearchMatchFieldOptions.
         *
         * @return this builder
         */
        public Builder withIncludeHighlights(Boolean includeHighlights) {
            this.includeHighlights = includeHighlights;
            return this;
        }

        /**
         * Builds an instance of {@link SearchV2Arg} configured with this
         * builder's values
         *
         * @return new instance of {@link SearchV2Arg}
         */
        public SearchV2Arg build() {
            return new SearchV2Arg(query, options, matchFieldOptions, includeHighlights);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            query,
            options,
            matchFieldOptions,
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
                && ((this.matchFieldOptions == other.matchFieldOptions) || (this.matchFieldOptions != null && this.matchFieldOptions.equals(other.matchFieldOptions)))
                && ((this.includeHighlights == other.includeHighlights) || (this.includeHighlights != null && this.includeHighlights.equals(other.includeHighlights)))
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
            if (value.matchFieldOptions != null) {
                g.writeFieldName("match_field_options");
                StoneSerializers.nullableStruct(SearchMatchFieldOptions.Serializer.INSTANCE).serialize(value.matchFieldOptions, g);
            }
            if (value.includeHighlights != null) {
                g.writeFieldName("include_highlights");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.includeHighlights, g);
            }
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
                SearchMatchFieldOptions f_matchFieldOptions = null;
                Boolean f_includeHighlights = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("query".equals(field)) {
                        f_query = StoneSerializers.string().deserialize(p);
                    }
                    else if ("options".equals(field)) {
                        f_options = StoneSerializers.nullableStruct(SearchOptions.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("match_field_options".equals(field)) {
                        f_matchFieldOptions = StoneSerializers.nullableStruct(SearchMatchFieldOptions.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("include_highlights".equals(field)) {
                        f_includeHighlights = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_query == null) {
                    throw new JsonParseException(p, "Required field \"query\" missing.");
                }
                value = new SearchV2Arg(f_query, f_options, f_matchFieldOptions, f_includeHighlights);
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
