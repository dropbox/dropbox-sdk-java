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

class PaperDocExport extends RefPaperDoc {
    // struct paper.PaperDocExport (paper.stone)

    protected final ExportFormat exportFormat;

    /**
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param exportFormat  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocExport(@Nonnull String docId, @Nonnull ExportFormat exportFormat) {
        super(docId);
        if (exportFormat == null) {
            throw new IllegalArgumentException("Required value for 'exportFormat' is null");
        }
        this.exportFormat = exportFormat;
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
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public ExportFormat getExportFormat() {
        return exportFormat;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            exportFormat
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
            PaperDocExport other = (PaperDocExport) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && ((this.exportFormat == other.exportFormat) || (this.exportFormat.equals(other.exportFormat)))
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
    static class Serializer extends StructSerializer<PaperDocExport> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocExport value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("export_format");
            ExportFormat.Serializer.INSTANCE.serialize(value.exportFormat, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocExport deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocExport value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                ExportFormat f_exportFormat = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("export_format".equals(field)) {
                        f_exportFormat = ExportFormat.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                if (f_exportFormat == null) {
                    throw new JsonParseException(p, "Required field \"export_format\" missing.");
                }
                value = new PaperDocExport(f_docId, f_exportFormat);
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
