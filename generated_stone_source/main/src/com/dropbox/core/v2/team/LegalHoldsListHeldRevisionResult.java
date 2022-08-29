/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

package com.dropbox.core.v2.team;

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

public class LegalHoldsListHeldRevisionResult {
    // struct team.LegalHoldsListHeldRevisionResult (team_legal_holds.stone)

    protected final List<LegalHoldHeldRevisionMetadata> entries;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     *
     * @param entries  List of file entries that under the hold. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  True if there are more file entries that haven't been
     *     returned. You can retrieve them with a call to
     *     /legal_holds/list_held_revisions_continue.
     * @param cursor  The cursor idicates where to continue reading file
     *     metadata entries for the next API call. When there are no more
     *     entries, the cursor will return none. Pass the cursor into
     *     /2/team/legal_holds/list_held_revisions/continue. Must have length of
     *     at least 1.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionResult(List<LegalHoldHeldRevisionMetadata> entries, boolean hasMore, String cursor) {
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (LegalHoldHeldRevisionMetadata x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
        if (cursor != null) {
            if (cursor.length() < 1) {
                throw new IllegalArgumentException("String 'cursor' is shorter than 1");
            }
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param entries  List of file entries that under the hold. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  True if there are more file entries that haven't been
     *     returned. You can retrieve them with a call to
     *     /legal_holds/list_held_revisions_continue.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionResult(List<LegalHoldHeldRevisionMetadata> entries, boolean hasMore) {
        this(entries, hasMore, null);
    }

    /**
     * List of file entries that under the hold.
     *
     * @return value for this field, never {@code null}.
     */
    public List<LegalHoldHeldRevisionMetadata> getEntries() {
        return entries;
    }

    /**
     * True if there are more file entries that haven't been returned. You can
     * retrieve them with a call to /legal_holds/list_held_revisions_continue.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * The cursor idicates where to continue reading file metadata entries for
     * the next API call. When there are no more entries, the cursor will return
     * none. Pass the cursor into
     * /2/team/legal_holds/list_held_revisions/continue.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            entries,
            cursor,
            hasMore
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
            LegalHoldsListHeldRevisionResult other = (LegalHoldsListHeldRevisionResult) obj;
            return ((this.entries == other.entries) || (this.entries.equals(other.entries)))
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
    static class Serializer extends StructSerializer<LegalHoldsListHeldRevisionResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsListHeldRevisionResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("entries");
            StoneSerializers.list(LegalHoldHeldRevisionMetadata.Serializer.INSTANCE).serialize(value.entries, g);
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
        public LegalHoldsListHeldRevisionResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsListHeldRevisionResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<LegalHoldHeldRevisionMetadata> f_entries = null;
                Boolean f_hasMore = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(LegalHoldHeldRevisionMetadata.Serializer.INSTANCE).deserialize(p);
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
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new LegalHoldsListHeldRevisionResult(f_entries, f_hasMore, f_cursor);
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
