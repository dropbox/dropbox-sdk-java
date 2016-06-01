/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ListFolderGetLatestCursorResult {
    // struct ListFolderGetLatestCursorResult

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
    static final class Serializer extends StructSerializer<ListFolderGetLatestCursorResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderGetLatestCursorResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFolderGetLatestCursorResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFolderGetLatestCursorResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                value = new ListFolderGetLatestCursorResult(f_cursor);
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
