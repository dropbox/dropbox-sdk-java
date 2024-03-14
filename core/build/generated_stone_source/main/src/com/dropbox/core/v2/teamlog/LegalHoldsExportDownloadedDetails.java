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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Downloaded export for a hold.
 */
public class LegalHoldsExportDownloadedDetails {
    // struct team_log.LegalHoldsExportDownloadedDetails (team_log_generated.stone)

    protected final String legalHoldId;
    protected final String name;
    protected final String exportName;
    protected final String part;
    protected final String fileName;

    /**
     * Downloaded export for a hold.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param legalHoldId  Hold ID. Must not be {@code null}.
     * @param name  Hold name. Must not be {@code null}.
     * @param exportName  Export name. Must not be {@code null}.
     * @param part  Part.
     * @param fileName  Filename.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsExportDownloadedDetails(@Nonnull String legalHoldId, @Nonnull String name, @Nonnull String exportName, @Nullable String part, @Nullable String fileName) {
        if (legalHoldId == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = legalHoldId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (exportName == null) {
            throw new IllegalArgumentException("Required value for 'exportName' is null");
        }
        this.exportName = exportName;
        this.part = part;
        this.fileName = fileName;
    }

    /**
     * Downloaded export for a hold.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param legalHoldId  Hold ID. Must not be {@code null}.
     * @param name  Hold name. Must not be {@code null}.
     * @param exportName  Export name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsExportDownloadedDetails(String legalHoldId, String name, String exportName) {
        this(legalHoldId, name, exportName, null, null);
    }

    /**
     * Hold ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getLegalHoldId() {
        return legalHoldId;
    }

    /**
     * Hold name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Export name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getExportName() {
        return exportName;
    }

    /**
     * Part.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPart() {
        return part;
    }

    /**
     * Filename.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param legalHoldId  Hold ID. Must not be {@code null}.
     * @param name  Hold name. Must not be {@code null}.
     * @param exportName  Export name. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String legalHoldId, String name, String exportName) {
        return new Builder(legalHoldId, name, exportName);
    }

    /**
     * Builder for {@link LegalHoldsExportDownloadedDetails}.
     */
    public static class Builder {
        protected final String legalHoldId;
        protected final String name;
        protected final String exportName;

        protected String part;
        protected String fileName;

        protected Builder(String legalHoldId, String name, String exportName) {
            if (legalHoldId == null) {
                throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
            }
            this.legalHoldId = legalHoldId;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (exportName == null) {
                throw new IllegalArgumentException("Required value for 'exportName' is null");
            }
            this.exportName = exportName;
            this.part = null;
            this.fileName = null;
        }

        /**
         * Set value for optional field.
         *
         * @param part  Part.
         *
         * @return this builder
         */
        public Builder withPart(String part) {
            this.part = part;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fileName  Filename.
         *
         * @return this builder
         */
        public Builder withFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * Builds an instance of {@link LegalHoldsExportDownloadedDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link LegalHoldsExportDownloadedDetails}
         */
        public LegalHoldsExportDownloadedDetails build() {
            return new LegalHoldsExportDownloadedDetails(legalHoldId, name, exportName, part, fileName);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            legalHoldId,
            name,
            exportName,
            part,
            fileName
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
            LegalHoldsExportDownloadedDetails other = (LegalHoldsExportDownloadedDetails) obj;
            return ((this.legalHoldId == other.legalHoldId) || (this.legalHoldId.equals(other.legalHoldId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.exportName == other.exportName) || (this.exportName.equals(other.exportName)))
                && ((this.part == other.part) || (this.part != null && this.part.equals(other.part)))
                && ((this.fileName == other.fileName) || (this.fileName != null && this.fileName.equals(other.fileName)))
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
    static class Serializer extends StructSerializer<LegalHoldsExportDownloadedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsExportDownloadedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(value.legalHoldId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("export_name");
            StoneSerializers.string().serialize(value.exportName, g);
            if (value.part != null) {
                g.writeFieldName("part");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.part, g);
            }
            if (value.fileName != null) {
                g.writeFieldName("file_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.fileName, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsExportDownloadedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsExportDownloadedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_legalHoldId = null;
                String f_name = null;
                String f_exportName = null;
                String f_part = null;
                String f_fileName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("legal_hold_id".equals(field)) {
                        f_legalHoldId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("export_name".equals(field)) {
                        f_exportName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("part".equals(field)) {
                        f_part = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("file_name".equals(field)) {
                        f_fileName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_legalHoldId == null) {
                    throw new JsonParseException(p, "Required field \"legal_hold_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_exportName == null) {
                    throw new JsonParseException(p, "Required field \"export_name\" missing.");
                }
                value = new LegalHoldsExportDownloadedDetails(f_legalHoldId, f_name, f_exportName, f_part, f_fileName);
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
