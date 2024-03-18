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

class PaperCreateArg {
    // struct files.PaperCreateArg (files.stone)

    @Nonnull
    protected final String path;
    @Nonnull
    protected final ImportFormat importFormat;

    /**
     *
     * @param path  The fully qualified path to the location in the user's
     *     Dropbox where the Paper Doc should be created. This should include
     *     the document's title and end with .paper. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     * @param importFormat  The format of the provided data. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperCreateArg(@Nonnull String path, @Nonnull ImportFormat importFormat) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
    }

    /**
     * The fully qualified path to the location in the user's Dropbox where the
     * Paper Doc should be created. This should include the document's title and
     * end with .paper.
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

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            importFormat
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
            PaperCreateArg other = (PaperCreateArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
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
    static class Serializer extends StructSerializer<PaperCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperCreateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(value.importFormat, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperCreateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperCreateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                ImportFormat f_importFormat = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("import_format".equals(field)) {
                        f_importFormat = ImportFormat.Serializer.INSTANCE.deserialize(p);
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
                value = new PaperCreateArg(f_path, f_importFormat);
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
