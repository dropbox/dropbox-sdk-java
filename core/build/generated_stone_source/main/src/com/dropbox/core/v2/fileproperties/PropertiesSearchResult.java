/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

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

public class PropertiesSearchResult {
    // struct file_properties.PropertiesSearchResult (file_properties.stone)

    protected final List<PropertiesSearchMatch> matches;
    protected final String cursor;

    /**
     *
     * @param matches  A list (possibly empty) of matches for the query. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserFilePropertiesRequests#propertiesSearchContinue(String)} to
     *     continue to receive search results. Cursor will be null when there
     *     are no more results. Must have length of at least 1.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchResult(@Nonnull List<PropertiesSearchMatch> matches, @Nullable String cursor) {
        if (matches == null) {
            throw new IllegalArgumentException("Required value for 'matches' is null");
        }
        for (PropertiesSearchMatch x : matches) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'matches' is null");
            }
        }
        this.matches = matches;
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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchResult(@Nonnull List<PropertiesSearchMatch> matches) {
        this(matches, null);
    }

    /**
     * A list (possibly empty) of matches for the query.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<PropertiesSearchMatch> getMatches() {
        return matches;
    }

    /**
     * Pass the cursor into {@link
     * DbxUserFilePropertiesRequests#propertiesSearchContinue(String)} to
     * continue to receive search results. Cursor will be null when there are no
     * more results.
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
            matches,
            cursor
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
            PropertiesSearchResult other = (PropertiesSearchResult) obj;
            return ((this.matches == other.matches) || (this.matches.equals(other.matches)))
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
    static class Serializer extends StructSerializer<PropertiesSearchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertiesSearchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("matches");
            StoneSerializers.list(PropertiesSearchMatch.Serializer.INSTANCE).serialize(value.matches, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertiesSearchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertiesSearchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<PropertiesSearchMatch> f_matches = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("matches".equals(field)) {
                        f_matches = StoneSerializers.list(PropertiesSearchMatch.Serializer.INSTANCE).deserialize(p);
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
                value = new PropertiesSearchResult(f_matches, f_cursor);
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
