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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class LegalHoldsListHeldRevisionsContinueArg {
    // struct team.LegalHoldsListHeldRevisionsContinueArg (team_legal_holds.stone)

    protected final String id;
    protected final String cursor;

    /**
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     * @param cursor  The cursor idicates where to continue reading file
     *     metadata entries for the next API call. When there are no more
     *     entries, the cursor will return none. Must have length of at least 1.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionsContinueArg(@Nonnull String id, @Nullable String cursor) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
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
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionsContinueArg(String id) {
        this(id, null);
    }

    /**
     * The legal hold Id.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getId() {
        return id;
    }

    /**
     * The cursor idicates where to continue reading file metadata entries for
     * the next API call. When there are no more entries, the cursor will return
     * none.
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
            id,
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
            LegalHoldsListHeldRevisionsContinueArg other = (LegalHoldsListHeldRevisionsContinueArg) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
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
    static class Serializer extends StructSerializer<LegalHoldsListHeldRevisionsContinueArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsListHeldRevisionsContinueArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsListHeldRevisionsContinueArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsListHeldRevisionsContinueArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                value = new LegalHoldsListHeldRevisionsContinueArg(f_id, f_cursor);
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
