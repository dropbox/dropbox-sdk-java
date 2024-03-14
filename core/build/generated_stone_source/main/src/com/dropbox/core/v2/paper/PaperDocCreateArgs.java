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

class PaperDocCreateArgs {
    // struct paper.PaperDocCreateArgs (paper.stone)

    protected final String parentFolderId;
    protected final ImportFormat importFormat;

    /**
     *
     * @param importFormat  The format of provided data. Must not be {@code
     *     null}.
     * @param parentFolderId  The Paper folder ID where the Paper document
     *     should be created. The API user has to have write access to this
     *     folder or error is thrown.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocCreateArgs(ImportFormat importFormat, String parentFolderId) {
        this.parentFolderId = parentFolderId;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param importFormat  The format of provided data. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocCreateArgs(ImportFormat importFormat) {
        this(importFormat, null);
    }

    /**
     * The format of provided data.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public ImportFormat getImportFormat() {
        return importFormat;
    }

    /**
     * The Paper folder ID where the Paper document should be created. The API
     * user has to have write access to this folder or error is thrown.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getParentFolderId() {
        return parentFolderId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            parentFolderId,
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
            PaperDocCreateArgs other = (PaperDocCreateArgs) obj;
            return ((this.importFormat == other.importFormat) || (this.importFormat.equals(other.importFormat)))
                && ((this.parentFolderId == other.parentFolderId) || (this.parentFolderId != null && this.parentFolderId.equals(other.parentFolderId)))
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
    static class Serializer extends StructSerializer<PaperDocCreateArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocCreateArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(value.importFormat, g);
            if (value.parentFolderId != null) {
                g.writeFieldName("parent_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentFolderId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocCreateArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocCreateArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                ImportFormat f_importFormat = null;
                String f_parentFolderId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("import_format".equals(field)) {
                        f_importFormat = ImportFormat.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("parent_folder_id".equals(field)) {
                        f_parentFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_importFormat == null) {
                    throw new JsonParseException(p, "Required field \"import_format\" missing.");
                }
                value = new PaperDocCreateArgs(f_importFormat, f_parentFolderId);
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
