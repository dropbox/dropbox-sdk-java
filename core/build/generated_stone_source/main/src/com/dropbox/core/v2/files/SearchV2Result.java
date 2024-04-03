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
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SearchV2Result {
    // struct files.SearchV2Result (files.stone)

    @Nonnull
    protected final List<SearchMatchV2> matches;
    protected final boolean hasMore;
    @Nullable
    protected final String cursor;

    /**
     *
     * @param matches  A list (possibly empty) of matches for the query. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param hasMore  Used for paging. If true, indicates there is another page
     *     of results available that can be fetched by calling {@link
     *     DbxUserFilesRequests#searchContinueV2(String)} with the cursor.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserFilesRequests#searchContinueV2(String)} to fetch the next page
     *     of results. Must have length of at least 1.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Result(@Nonnull List<SearchMatchV2> matches, boolean hasMore, @Nullable String cursor) {
        if (matches == null) {
            throw new IllegalArgumentException("Required value for 'matches' is null");
        }
        for (SearchMatchV2 x : matches) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'matches' is null");
            }
        }
        this.matches = matches;
        this.hasMore = hasMore;
        if (cursor != null) {
            if (cursor.length() < 1) {
                throw new IllegalArgumentException("String 'cursor' is shorter than 1");
            }
        }
        this.cursor = cursor;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param matches  A list (possibly empty) of matches for the query. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param hasMore  Used for paging. If true, indicates there is another page
     *     of results available that can be fetched by calling {@link
     *     DbxUserFilesRequests#searchContinueV2(String)} with the cursor.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Result(@Nonnull List<SearchMatchV2> matches, boolean hasMore) {
        this(matches, hasMore, null);
    }

    /**
     * A list (possibly empty) of matches for the query.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<SearchMatchV2> getMatches() {
        return matches;
    }

    /**
     * Used for paging. If true, indicates there is another page of results
     * available that can be fetched by calling {@link
     * DbxUserFilesRequests#searchContinueV2(String)} with the cursor.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link
     * DbxUserFilesRequests#searchContinueV2(String)} to fetch the next page of
     * results.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.matches,
            this.hasMore,
            this.cursor
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
            SearchV2Result other = (SearchV2Result) obj;
            return ((this.matches == other.matches) || (this.matches.equals(other.matches)))
                && (this.hasMore == other.hasMore)
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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
    static class Serializer extends StructSerializer<SearchV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchV2Result value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("matches");
            StoneSerializers.list(SearchMatchV2.Serializer.INSTANCE).serialize(value.matches, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SearchV2Result deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SearchV2Result value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<SearchMatchV2> f_matches = null;
                Boolean f_hasMore = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("matches".equals(field)) {
                        f_matches = StoneSerializers.list(SearchMatchV2.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_matches == null) {
                    throw new JsonParseException(p, "Required field \"matches\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new SearchV2Result(f_matches, f_hasMore, f_cursor);
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
