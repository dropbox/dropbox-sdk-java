/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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

/**
 * Arguments for {@link DbxUserSharingRequests#listFileMembersContinue(String)}.
 */
class ListFileMembersContinueArg {
    // struct sharing.ListFileMembersContinueArg (sharing_files.stone)

    protected final String cursor;

    /**
     * Arguments for {@link
     * DbxUserSharingRequests#listFileMembersContinue(String)}.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserSharingRequests#listFileMembers(String)}, {@link
     *     DbxUserSharingRequests#listFileMembersContinue(String)}, or {@link
     *     DbxUserSharingRequests#listFileMembersBatch(java.util.List,long)}.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersContinueArg(@javax.annotation.Nonnull String cursor) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
    }

    /**
     * The cursor returned by your last call to {@link
     * DbxUserSharingRequests#listFileMembers(String)}, {@link
     * DbxUserSharingRequests#listFileMembersContinue(String)}, or {@link
     * DbxUserSharingRequests#listFileMembersBatch(java.util.List,long)}.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
            ListFileMembersContinueArg other = (ListFileMembersContinueArg) obj;
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
    static class Serializer extends StructSerializer<ListFileMembersContinueArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileMembersContinueArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
        public ListFileMembersContinueArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileMembersContinueArg value;
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
                value = new ListFileMembersContinueArg(f_cursor);
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
