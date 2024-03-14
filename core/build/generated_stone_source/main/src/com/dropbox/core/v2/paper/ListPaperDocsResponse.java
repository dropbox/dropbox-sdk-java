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
import java.util.List;

import javax.annotation.Nonnull;

public class ListPaperDocsResponse {
    // struct paper.ListPaperDocsResponse (paper.stone)

    protected final List<String> docIds;
    protected final Cursor cursor;
    protected final boolean hasMore;

    /**
     *
     * @param docIds  The list of Paper doc IDs that can be used to access the
     *     given Paper docs or supplied to other API methods. The list is sorted
     *     in the order specified by the initial call to {@link
     *     DbxUserPaperRequests#docsList}. Must not contain a {@code null} item
     *     and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserPaperRequests#docsListContinue(String)} to paginate through
     *     all files. The cursor preserves all properties as specified in the
     *     original call to {@link DbxUserPaperRequests#docsList}. Must not be
     *     {@code null}.
     * @param hasMore  Will be set to True if a subsequent call with the
     *     provided cursor to {@link
     *     DbxUserPaperRequests#docsListContinue(String)} returns immediately
     *     with some results. If set to False please allow some delay before
     *     making another call to {@link
     *     DbxUserPaperRequests#docsListContinue(String)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListPaperDocsResponse(@Nonnull List<String> docIds, @Nonnull Cursor cursor, boolean hasMore) {
        if (docIds == null) {
            throw new IllegalArgumentException("Required value for 'docIds' is null");
        }
        for (String x : docIds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'docIds' is null");
            }
        }
        this.docIds = docIds;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * The list of Paper doc IDs that can be used to access the given Paper docs
     * or supplied to other API methods. The list is sorted in the order
     * specified by the initial call to {@link DbxUserPaperRequests#docsList}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getDocIds() {
        return docIds;
    }

    /**
     * Pass the cursor into {@link
     * DbxUserPaperRequests#docsListContinue(String)} to paginate through all
     * files. The cursor preserves all properties as specified in the original
     * call to {@link DbxUserPaperRequests#docsList}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Cursor getCursor() {
        return cursor;
    }

    /**
     * Will be set to True if a subsequent call with the provided cursor to
     * {@link DbxUserPaperRequests#docsListContinue(String)} returns immediately
     * with some results. If set to False please allow some delay before making
     * another call to {@link DbxUserPaperRequests#docsListContinue(String)}.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            docIds,
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
            ListPaperDocsResponse other = (ListPaperDocsResponse) obj;
            return ((this.docIds == other.docIds) || (this.docIds.equals(other.docIds)))
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
    static class Serializer extends StructSerializer<ListPaperDocsResponse> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListPaperDocsResponse value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.docIds, g);
            g.writeFieldName("cursor");
            Cursor.Serializer.INSTANCE.serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListPaperDocsResponse deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListPaperDocsResponse value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_docIds = null;
                Cursor f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_ids".equals(field)) {
                        f_docIds = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = Cursor.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docIds == null) {
                    throw new JsonParseException(p, "Required field \"doc_ids\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ListPaperDocsResponse(f_docIds, f_cursor, f_hasMore);
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
