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

public class ListFolderResult {
    // struct files.ListFolderResult (files.stone)

    @Nonnull
    protected final List<Metadata> entries;
    @Nonnull
    protected final String cursor;
    protected final boolean hasMore;

    /**
     *
     * @param entries  The files and (direct) subfolders in the folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxAppFilesRequests#listFolderContinue(String)} to see what's changed
     *     in the folder since your previous query. Must have length of at least
     *     1 and not be {@code null}.
     * @param hasMore  If true, then there are more entries available. Pass the
     *     cursor to {@link DbxAppFilesRequests#listFolderContinue(String)} to
     *     retrieve the rest.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult(@Nonnull List<Metadata> entries, @Nonnull String cursor, boolean hasMore) {
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (Metadata x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        if (cursor.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * The files and (direct) subfolders in the folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Metadata> getEntries() {
        return entries;
    }

    /**
     * Pass the cursor into {@link
     * DbxAppFilesRequests#listFolderContinue(String)} to see what's changed in
     * the folder since your previous query.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getCursor() {
        return cursor;
    }

    /**
     * If true, then there are more entries available. Pass the cursor to {@link
     * DbxAppFilesRequests#listFolderContinue(String)} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.entries,
            this.cursor,
            this.hasMore
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
            ListFolderResult other = (ListFolderResult) obj;
            return ((this.entries == other.entries) || (this.entries.equals(other.entries)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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
    static class Serializer extends StructSerializer<ListFolderResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("entries");
            StoneSerializers.list(Metadata.Serializer.INSTANCE).serialize(value.entries, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFolderResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFolderResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<Metadata> f_entries = null;
                String f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(Metadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ListFolderResult(f_entries, f_cursor, f_hasMore);
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
