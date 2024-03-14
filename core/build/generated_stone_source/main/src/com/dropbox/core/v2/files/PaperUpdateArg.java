/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

class PaperUpdateArg {
    // struct files.PaperUpdateArg (files.stone)

    protected final String path;
    protected final ImportFormat importFormat;
    protected final PaperDocUpdatePolicy docUpdatePolicy;
    protected final Long paperRevision;

    /**
     *
     * @param path  Path in the user's Dropbox to update. The path must
     *     correspond to a Paper doc or an error will be returned. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     * @param importFormat  The format of the provided data. Must not be {@code
     *     null}.
     * @param docUpdatePolicy  How the provided content should be applied to the
     *     doc. Must not be {@code null}.
     * @param paperRevision  The latest doc revision. Required when
     *     doc_update_policy is update. This value must match the current
     *     revision of the doc or error revision_mismatch will be returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperUpdateArg(@Nonnull String path, @Nonnull ImportFormat importFormat, @Nonnull PaperDocUpdatePolicy docUpdatePolicy, @Nullable Long paperRevision) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
        if (docUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'docUpdatePolicy' is null");
        }
        this.docUpdatePolicy = docUpdatePolicy;
        this.paperRevision = paperRevision;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  Path in the user's Dropbox to update. The path must
     *     correspond to a Paper doc or an error will be returned. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     * @param importFormat  The format of the provided data. Must not be {@code
     *     null}.
     * @param docUpdatePolicy  How the provided content should be applied to the
     *     doc. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperUpdateArg(String path, ImportFormat importFormat, PaperDocUpdatePolicy docUpdatePolicy) {
        this(path, importFormat, docUpdatePolicy, null);
    }

    /**
     * Path in the user's Dropbox to update. The path must correspond to a Paper
     * doc or an error will be returned.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * The format of the provided data.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public ImportFormat getImportFormat() {
        return importFormat;
    }

    /**
     * How the provided content should be applied to the doc.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public PaperDocUpdatePolicy getDocUpdatePolicy() {
        return docUpdatePolicy;
    }

    /**
     * The latest doc revision. Required when doc_update_policy is update. This
     * value must match the current revision of the doc or error
     * revision_mismatch will be returned.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Long getPaperRevision() {
        return paperRevision;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            importFormat,
            docUpdatePolicy,
            paperRevision
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
            PaperUpdateArg other = (PaperUpdateArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.importFormat == other.importFormat) || (this.importFormat.equals(other.importFormat)))
                && ((this.docUpdatePolicy == other.docUpdatePolicy) || (this.docUpdatePolicy.equals(other.docUpdatePolicy)))
                && ((this.paperRevision == other.paperRevision) || (this.paperRevision != null && this.paperRevision.equals(other.paperRevision)))
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
    static class Serializer extends StructSerializer<PaperUpdateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperUpdateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(value.importFormat, g);
            g.writeFieldName("doc_update_policy");
            PaperDocUpdatePolicy.Serializer.INSTANCE.serialize(value.docUpdatePolicy, g);
            if (value.paperRevision != null) {
                g.writeFieldName("paper_revision");
                StoneSerializers.nullable(StoneSerializers.int64()).serialize(value.paperRevision, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperUpdateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperUpdateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                ImportFormat f_importFormat = null;
                PaperDocUpdatePolicy f_docUpdatePolicy = null;
                Long f_paperRevision = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("import_format".equals(field)) {
                        f_importFormat = ImportFormat.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("doc_update_policy".equals(field)) {
                        f_docUpdatePolicy = PaperDocUpdatePolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("paper_revision".equals(field)) {
                        f_paperRevision = StoneSerializers.nullable(StoneSerializers.int64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_importFormat == null) {
                    throw new JsonParseException(p, "Required field \"import_format\" missing.");
                }
                if (f_docUpdatePolicy == null) {
                    throw new JsonParseException(p, "Required field \"doc_update_policy\" missing.");
                }
                value = new PaperUpdateArg(f_path, f_importFormat, f_docUpdatePolicy, f_paperRevision);
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
