/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

class ListPaperDocsContinueArgs {
    // struct paper.ListPaperDocsContinueArgs (paper.stone)

    protected final String cursor;

    /**
     *
     * @param cursor  The cursor obtained from {@link
     *     DbxUserPaperRequests#docsList} or {@link
     *     DbxUserPaperRequests#docsListContinue(String)}. Allows for
     *     pagination. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListPaperDocsContinueArgs(String cursor) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
    }

    /**
     * The cursor obtained from {@link DbxUserPaperRequests#docsList} or {@link
     * DbxUserPaperRequests#docsListContinue(String)}. Allows for pagination.
     *
     * @return value for this field, never {@code null}.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
            ListPaperDocsContinueArgs other = (ListPaperDocsContinueArgs) obj;
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
    static class Serializer extends StructSerializer<ListPaperDocsContinueArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListPaperDocsContinueArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
        public ListPaperDocsContinueArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListPaperDocsContinueArgs value;
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
                value = new ListPaperDocsContinueArgs(f_cursor);
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
