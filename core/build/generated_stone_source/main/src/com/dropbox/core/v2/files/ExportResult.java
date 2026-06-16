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

import javax.annotation.Nonnull;

public class ExportResult {
    // struct files.ExportResult (files.stone)

    @Nonnull
    protected final ExportMetadata exportMetadata;
    @Nonnull
    protected final FileMetadata fileMetadata;

    /**
     *
     * @param exportMetadata  Metadata for the exported version of the file.
     *     Must not be {@code null}.
     * @param fileMetadata  Metadata for the original file. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExportResult(@Nonnull ExportMetadata exportMetadata, @Nonnull FileMetadata fileMetadata) {
        if (exportMetadata == null) {
            throw new IllegalArgumentException("Required value for 'exportMetadata' is null");
        }
        this.exportMetadata = exportMetadata;
        if (fileMetadata == null) {
            throw new IllegalArgumentException("Required value for 'fileMetadata' is null");
        }
        this.fileMetadata = fileMetadata;
    }

    /**
     * Metadata for the exported version of the file.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public ExportMetadata getExportMetadata() {
        return exportMetadata;
    }

    /**
     * Metadata for the original file.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FileMetadata getFileMetadata() {
        return fileMetadata;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.exportMetadata,
            this.fileMetadata
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
            ExportResult other = (ExportResult) obj;
            return ((this.exportMetadata == other.exportMetadata) || (this.exportMetadata.equals(other.exportMetadata)))
                && ((this.fileMetadata == other.fileMetadata) || (this.fileMetadata.equals(other.fileMetadata)))
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
    public static class Serializer extends StructSerializer<ExportResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExportResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("export_metadata");
            ExportMetadata.Serializer.INSTANCE.serialize(value.exportMetadata, g);
            g.writeFieldName("file_metadata");
            FileMetadata.Serializer.INSTANCE.serialize(value.fileMetadata, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExportResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExportResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                ExportMetadata f_exportMetadata = null;
                FileMetadata f_fileMetadata = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("export_metadata".equals(field)) {
                        f_exportMetadata = ExportMetadata.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("file_metadata".equals(field)) {
                        f_fileMetadata = FileMetadata.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_exportMetadata == null) {
                    throw new JsonParseException(p, "Required field \"export_metadata\" missing.");
                }
                if (f_fileMetadata == null) {
                    throw new JsonParseException(p, "Required field \"file_metadata\" missing.");
                }
                value = new ExportResult(f_exportMetadata, f_fileMetadata);
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
