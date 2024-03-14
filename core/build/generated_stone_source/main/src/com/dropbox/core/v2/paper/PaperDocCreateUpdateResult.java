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

public class PaperDocCreateUpdateResult {
    // struct paper.PaperDocCreateUpdateResult (paper.stone)

    protected final String docId;
    protected final long revision;
    protected final String title;

    /**
     *
     * @param docId  Doc ID of the newly created doc. Must not be {@code null}.
     * @param revision  The Paper doc revision. Simply an ever increasing
     *     number.
     * @param title  The Paper doc title. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocCreateUpdateResult(String docId, long revision, String title) {
        if (docId == null) {
            throw new IllegalArgumentException("Required value for 'docId' is null");
        }
        this.docId = docId;
        this.revision = revision;
        if (title == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        this.title = title;
    }

    /**
     * Doc ID of the newly created doc.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getDocId() {
        return docId;
    }

    /**
     * The Paper doc revision. Simply an ever increasing number.
     *
     * @return value for this field.
     */
    public long getRevision() {
        return revision;
    }

    /**
     * The Paper doc title.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            docId,
            revision,
            title
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
            PaperDocCreateUpdateResult other = (PaperDocCreateUpdateResult) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && (this.revision == other.revision)
                && ((this.title == other.title) || (this.title.equals(other.title)))
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
    static class Serializer extends StructSerializer<PaperDocCreateUpdateResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocCreateUpdateResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("revision");
            StoneSerializers.int64().serialize(value.revision, g);
            g.writeFieldName("title");
            StoneSerializers.string().serialize(value.title, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocCreateUpdateResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocCreateUpdateResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                Long f_revision = null;
                String f_title = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("revision".equals(field)) {
                        f_revision = StoneSerializers.int64().deserialize(p);
                    }
                    else if ("title".equals(field)) {
                        f_title = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                if (f_revision == null) {
                    throw new JsonParseException(p, "Required field \"revision\" missing.");
                }
                if (f_title == null) {
                    throw new JsonParseException(p, "Required field \"title\" missing.");
                }
                value = new PaperDocCreateUpdateResult(f_docId, f_revision, f_title);
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
