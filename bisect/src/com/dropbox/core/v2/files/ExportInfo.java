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

/**
 * Export information for a file.
 */
public class ExportInfo {
    // struct files.ExportInfo (files.stone)

    protected final String exportAs;

    /**
     * Export information for a file.
     *
     * @param exportAs  Format to which the file can be exported to.
     */
    public ExportInfo(String exportAs) {
        this.exportAs = exportAs;
    }

    /**
     * Export information for a file.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ExportInfo() {
        this(null);
    }

    /**
     * Format to which the file can be exported to.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getExportAs() {
        return exportAs;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            exportAs
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
            return (this.exportAs == other.exportAs) || (this.exportAs != null && this.exportAs.equals(other.exportAs));
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
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("export_as".equals(field)) {
                        f_exportAs = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ExportInfo(f_exportAs);
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
