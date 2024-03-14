/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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
 * Paper document's logged information.
 */
public class PaperDocumentLogInfo {
    // struct team_log.PaperDocumentLogInfo (team_log_generated.stone)

    protected final String docId;
    protected final String docTitle;

    /**
     * Paper document's logged information.
     *
     * @param docId  Papers document Id. Must not be {@code null}.
     * @param docTitle  Paper document title. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocumentLogInfo(String docId, String docTitle) {
        if (docId == null) {
            throw new IllegalArgumentException("Required value for 'docId' is null");
        }
        this.docId = docId;
        if (docTitle == null) {
            throw new IllegalArgumentException("Required value for 'docTitle' is null");
        }
        this.docTitle = docTitle;
    }

    /**
     * Papers document Id.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDocId() {
        return docId;
    }

    /**
     * Paper document title.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDocTitle() {
        return docTitle;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            docId,
            docTitle
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
            PaperDocumentLogInfo other = (PaperDocumentLogInfo) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && ((this.docTitle == other.docTitle) || (this.docTitle.equals(other.docTitle)))
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
    static class Serializer extends StructSerializer<PaperDocumentLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocumentLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("doc_title");
            StoneSerializers.string().serialize(value.docTitle, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocumentLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocumentLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                String f_docTitle = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("doc_title".equals(field)) {
                        f_docTitle = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                if (f_docTitle == null) {
                    throw new JsonParseException(p, "Required field \"doc_title\" missing.");
                }
                value = new PaperDocumentLogInfo(f_docId, f_docTitle);
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
