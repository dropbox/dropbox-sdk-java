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
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Export information for a file.
 */
public class ExportInfo {
    // struct files.ExportInfo (files.stone)

    @Nullable
    protected final String exportAs;
    @Nullable
    protected final List<String> exportOptions;

    /**
     * Export information for a file.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param exportAs  Format to which the file can be exported to.
     * @param exportOptions  Additional formats to which the file can be
     *     exported. These values can be specified as the export_format in
     *     /files/export. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExportInfo(@Nullable String exportAs, @Nullable List<String> exportOptions) {
        this.exportAs = exportAs;
        if (exportOptions != null) {
            for (String x : exportOptions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'exportOptions' is null");
                }
            }
        }
        this.exportOptions = exportOptions;
    }

    /**
     * Export information for a file.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ExportInfo() {
        this(null, null);
    }

    /**
     * Format to which the file can be exported to.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getExportAs() {
        return exportAs;
    }

    /**
     * Additional formats to which the file can be exported. These values can be
     * specified as the export_format in /files/export.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getExportOptions() {
        return exportOptions;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link ExportInfo}.
     */
    public static class Builder {

        protected String exportAs;
        protected List<String> exportOptions;

        protected Builder() {
            this.exportAs = null;
            this.exportOptions = null;
        }

        /**
         * Set value for optional field.
         *
         * @param exportAs  Format to which the file can be exported to.
         *
         * @return this builder
         */
        public Builder withExportAs(String exportAs) {
            this.exportAs = exportAs;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param exportOptions  Additional formats to which the file can be
         *     exported. These values can be specified as the export_format in
         *     /files/export. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withExportOptions(List<String> exportOptions) {
            if (exportOptions != null) {
                for (String x : exportOptions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'exportOptions' is null");
                    }
                }
            }
            this.exportOptions = exportOptions;
            return this;
        }

        /**
         * Builds an instance of {@link ExportInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link ExportInfo}
         */
        public ExportInfo build() {
            return new ExportInfo(exportAs, exportOptions);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.exportAs,
            this.exportOptions
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
            ExportInfo other = (ExportInfo) obj;
            return ((this.exportAs == other.exportAs) || (this.exportAs != null && this.exportAs.equals(other.exportAs)))
                && ((this.exportOptions == other.exportOptions) || (this.exportOptions != null && this.exportOptions.equals(other.exportOptions)))
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
    static class Serializer extends StructSerializer<ExportInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExportInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.exportAs != null) {
                g.writeFieldName("export_as");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.exportAs, g);
            }
            if (value.exportOptions != null) {
                g.writeFieldName("export_options");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.exportOptions, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExportInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExportInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_exportAs = null;
                List<String> f_exportOptions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("export_as".equals(field)) {
                        f_exportAs = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("export_options".equals(field)) {
                        f_exportOptions = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ExportInfo(f_exportAs, f_exportOptions);
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
