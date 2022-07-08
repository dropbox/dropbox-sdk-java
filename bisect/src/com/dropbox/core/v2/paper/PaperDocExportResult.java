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

public class PaperDocExportResult {
    // struct paper.PaperDocExportResult (paper.stone)

    protected final String owner;
    protected final String title;
    protected final long revision;
    protected final String mimeType;

    /**
     *
     * @param owner  The Paper doc owner's email address. Must not be {@code
     *     null}.
     * @param title  The Paper doc title. Must not be {@code null}.
     * @param revision  The Paper doc revision. Simply an ever increasing
     *     number.
     * @param mimeType  MIME type of the export. This corresponds to {@link
     *     ExportFormat} specified in the request. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocExportResult(String owner, String title, long revision, String mimeType) {
        if (owner == null) {
            throw new IllegalArgumentException("Required value for 'owner' is null");
        }
        this.owner = owner;
        if (title == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        this.title = title;
        this.revision = revision;
        if (mimeType == null) {
            throw new IllegalArgumentException("Required value for 'mimeType' is null");
        }
        this.mimeType = mimeType;
    }

    /**
     * The Paper doc owner's email address.
     *
     * @return value for this field, never {@code null}.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * The Paper doc title.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTitle() {
        return title;
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
     * MIME type of the export. This corresponds to {@link ExportFormat}
     * specified in the request.
     *
     * @return value for this field, never {@code null}.
     */
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            owner,
            title,
            revision,
            mimeType
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
            PaperDocExportResult other = (PaperDocExportResult) obj;
            return ((this.owner == other.owner) || (this.owner.equals(other.owner)))
                && ((this.title == other.title) || (this.title.equals(other.title)))
                && (this.revision == other.revision)
                && ((this.mimeType == other.mimeType) || (this.mimeType.equals(other.mimeType)))
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
    static class Serializer extends StructSerializer<PaperDocExportResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocExportResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("owner");
            StoneSerializers.string().serialize(value.owner, g);
            g.writeFieldName("title");
            StoneSerializers.string().serialize(value.title, g);
            g.writeFieldName("revision");
            StoneSerializers.int64().serialize(value.revision, g);
            g.writeFieldName("mime_type");
            StoneSerializers.string().serialize(value.mimeType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocExportResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocExportResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_owner = null;
                String f_title = null;
                Long f_revision = null;
                String f_mimeType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("owner".equals(field)) {
                        f_owner = StoneSerializers.string().deserialize(p);
                    }
                    else if ("title".equals(field)) {
                        f_title = StoneSerializers.string().deserialize(p);
                    }
                    else if ("revision".equals(field)) {
                        f_revision = StoneSerializers.int64().deserialize(p);
                    }
                    else if ("mime_type".equals(field)) {
                        f_mimeType = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_owner == null) {
                    throw new JsonParseException(p, "Required field \"owner\" missing.");
                }
                if (f_title == null) {
                    throw new JsonParseException(p, "Required field \"title\" missing.");
                }
                if (f_revision == null) {
                    throw new JsonParseException(p, "Required field \"revision\" missing.");
                }
                if (f_mimeType == null) {
                    throw new JsonParseException(p, "Required field \"mime_type\" missing.");
                }
                value = new PaperDocExportResult(f_owner, f_title, f_revision, f_mimeType);
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
