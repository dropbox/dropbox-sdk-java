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

import javax.annotation.Nonnull;

class ListUsersOnFolderContinueArgs extends RefPaperDoc {
    // struct paper.ListUsersOnFolderContinueArgs (paper.stone)

    protected final String cursor;

    /**
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param cursor  The cursor obtained from {@link
     *     DbxUserPaperRequests#docsFolderUsersList(String,int)} or {@link
     *     DbxUserPaperRequests#docsFolderUsersListContinue(String,String)}.
     *     Allows for pagination. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListUsersOnFolderContinueArgs(@Nonnull String docId, @Nonnull String cursor) {
        super(docId);
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
    }

    /**
     * The Paper doc ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDocId() {
        return docId;
    }

    /**
     * The cursor obtained from {@link
     * DbxUserPaperRequests#docsFolderUsersList(String,int)} or {@link
     * DbxUserPaperRequests#docsFolderUsersListContinue(String,String)}. Allows
     * for pagination.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            cursor
        });
        hash = (31 * super.hashCode()) + hash;
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
            ListUsersOnFolderContinueArgs other = (ListUsersOnFolderContinueArgs) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
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
    static class Serializer extends StructSerializer<ListUsersOnFolderContinueArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListUsersOnFolderContinueArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListUsersOnFolderContinueArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListUsersOnFolderContinueArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                value = new ListUsersOnFolderContinueArgs(f_docId, f_cursor);
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
