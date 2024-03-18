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

class PaperDocUpdateArgs extends RefPaperDoc {
    // struct paper.PaperDocUpdateArgs (paper.stone)

    @Nonnull
    protected final PaperDocUpdatePolicy docUpdatePolicy;
    protected final long revision;
    @Nonnull
    protected final ImportFormat importFormat;

    /**
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param docUpdatePolicy  The policy used for the current update call. Must
     *     not be {@code null}.
     * @param revision  The latest doc revision. This value must match the head
     *     revision or an error code will be returned. This is to prevent
     *     colliding writes.
     * @param importFormat  The format of provided data. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocUpdateArgs(@Nonnull String docId, @Nonnull PaperDocUpdatePolicy docUpdatePolicy, long revision, @Nonnull ImportFormat importFormat) {
        super(docId);
        if (docUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'docUpdatePolicy' is null");
        }
        this.docUpdatePolicy = docUpdatePolicy;
        this.revision = revision;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
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
     * The policy used for the current update call.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public PaperDocUpdatePolicy getDocUpdatePolicy() {
        return docUpdatePolicy;
    }

    /**
     * The latest doc revision. This value must match the head revision or an
     * error code will be returned. This is to prevent colliding writes.
     *
     * @return value for this field.
     */
    public long getRevision() {
        return revision;
    }

    /**
     * The format of provided data.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public ImportFormat getImportFormat() {
        return importFormat;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            docUpdatePolicy,
            revision,
            importFormat
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
            PaperDocUpdateArgs other = (PaperDocUpdateArgs) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && ((this.docUpdatePolicy == other.docUpdatePolicy) || (this.docUpdatePolicy.equals(other.docUpdatePolicy)))
                && (this.revision == other.revision)
                && ((this.importFormat == other.importFormat) || (this.importFormat.equals(other.importFormat)))
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
    static class Serializer extends StructSerializer<PaperDocUpdateArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocUpdateArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("doc_update_policy");
            PaperDocUpdatePolicy.Serializer.INSTANCE.serialize(value.docUpdatePolicy, g);
            g.writeFieldName("revision");
            StoneSerializers.int64().serialize(value.revision, g);
            g.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(value.importFormat, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocUpdateArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocUpdateArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                PaperDocUpdatePolicy f_docUpdatePolicy = null;
                Long f_revision = null;
                ImportFormat f_importFormat = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("doc_update_policy".equals(field)) {
                        f_docUpdatePolicy = PaperDocUpdatePolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("revision".equals(field)) {
                        f_revision = StoneSerializers.int64().deserialize(p);
                    }
                    else if ("import_format".equals(field)) {
                        f_importFormat = ImportFormat.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                if (f_docUpdatePolicy == null) {
                    throw new JsonParseException(p, "Required field \"doc_update_policy\" missing.");
                }
                if (f_revision == null) {
                    throw new JsonParseException(p, "Required field \"revision\" missing.");
                }
                if (f_importFormat == null) {
                    throw new JsonParseException(p, "Required field \"import_format\" missing.");
                }
                value = new PaperDocUpdateArgs(f_docId, f_docUpdatePolicy, f_revision, f_importFormat);
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
