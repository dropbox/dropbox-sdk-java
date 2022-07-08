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

class ListUsersOnFolderArgs extends RefPaperDoc {
    // struct paper.ListUsersOnFolderArgs (paper.stone)

    protected final int limit;

    /**
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param limit  Size limit per batch. The maximum number of users that can
     *     be retrieved per batch is 1000. Higher value results in invalid
     *     arguments error. Must be greater than or equal to 1 and be less than
     *     or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListUsersOnFolderArgs(String docId, int limit) {
        super(docId);
        if (limit < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1");
        }
        if (limit > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000");
        }
        this.limit = limit;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListUsersOnFolderArgs(String docId) {
        this(docId, 1000);
    }

    /**
     * The Paper doc ID.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDocId() {
        return docId;
    }

    /**
     * Size limit per batch. The maximum number of users that can be retrieved
     * per batch is 1000. Higher value results in invalid arguments error.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000.
     */
    public int getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            limit
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
            ListUsersOnFolderArgs other = (ListUsersOnFolderArgs) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && (this.limit == other.limit)
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
    static class Serializer extends StructSerializer<ListUsersOnFolderArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListUsersOnFolderArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("limit");
            StoneSerializers.int32().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListUsersOnFolderArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListUsersOnFolderArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                Integer f_limit = 1000;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.int32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                value = new ListUsersOnFolderArgs(f_docId, f_limit);
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
