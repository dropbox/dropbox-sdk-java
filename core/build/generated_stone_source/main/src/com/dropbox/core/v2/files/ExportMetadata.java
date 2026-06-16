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
import javax.annotation.Nullable;

public class ExportMetadata {
    // struct files.ExportMetadata (files.stone)

    @Nonnull
    protected final String name;
    protected final long size;
    @Nullable
    protected final String exportHash;
    @Nullable
    protected final Long paperRevision;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param size  The file size in bytes.
     * @param exportHash  A hash based on the exported file content. This field
     *     can be used to verify data integrity. Similar to content hash. For
     *     more information see our <a
     *     href="https://www.dropbox.com/developers/reference/content-hash">Content
     *     hash</a> page. Must have length of at least 64 and have length of at
     *     most 64.
     * @param paperRevision  If the file is a Paper doc, this gives the latest
     *     doc revision which can be used in {@link
     *     DbxUserFilesRequests#paperUpdate(String,ImportFormat,PaperDocUpdatePolicy,Long)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExportMetadata(@Nonnull String name, long size, @Nullable String exportHash, @Nullable Long paperRevision) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.size = size;
        if (exportHash != null) {
            if (exportHash.length() < 64) {
                throw new IllegalArgumentException("String 'exportHash' is shorter than 64");
            }
            if (exportHash.length() > 64) {
                throw new IllegalArgumentException("String 'exportHash' is longer than 64");
            }
        }
        this.exportHash = exportHash;
        this.paperRevision = paperRevision;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param size  The file size in bytes.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExportMetadata(@Nonnull String name, long size) {
        this(name, size, null, null);
    }

    /**
     * The last component of the path (including extension). This never contains
     * a slash.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * The file size in bytes.
     *
     * @return value for this field.
     */
    public long getSize() {
        return size;
    }

    /**
     * A hash based on the exported file content. This field can be used to
     * verify data integrity. Similar to content hash. For more information see
     * our <a
     * href="https://www.dropbox.com/developers/reference/content-hash">Content
     * hash</a> page.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getExportHash() {
        return exportHash;
    }

    /**
     * If the file is a Paper doc, this gives the latest doc revision which can
     * be used in {@link
     * DbxUserFilesRequests#paperUpdate(String,ImportFormat,PaperDocUpdatePolicy,Long)}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Long getPaperRevision() {
        return paperRevision;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param size  The file size in bytes.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, long size) {
        return new Builder(name, size);
    }

    /**
     * Builder for {@link ExportMetadata}.
     */
    public static class Builder {
        protected final String name;
        protected final long size;

        protected String exportHash;
        protected Long paperRevision;

        protected Builder(String name, long size) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            this.size = size;
            this.exportHash = null;
            this.paperRevision = null;
        }

        /**
         * Set value for optional field.
         *
         * @param exportHash  A hash based on the exported file content. This
         *     field can be used to verify data integrity. Similar to content
         *     hash. For more information see our <a
         *     href="https://www.dropbox.com/developers/reference/content-hash">Content
         *     hash</a> page. Must have length of at least 64 and have length of
         *     at most 64.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withExportHash(String exportHash) {
            if (exportHash != null) {
                if (exportHash.length() < 64) {
                    throw new IllegalArgumentException("String 'exportHash' is shorter than 64");
                }
                if (exportHash.length() > 64) {
                    throw new IllegalArgumentException("String 'exportHash' is longer than 64");
                }
            }
            this.exportHash = exportHash;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param paperRevision  If the file is a Paper doc, this gives the
         *     latest doc revision which can be used in {@link
         *     DbxUserFilesRequests#paperUpdate(String,ImportFormat,PaperDocUpdatePolicy,Long)}.
         *
         * @return this builder
         */
        public Builder withPaperRevision(Long paperRevision) {
            this.paperRevision = paperRevision;
            return this;
        }

        /**
         * Builds an instance of {@link ExportMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link ExportMetadata}
         */
        public ExportMetadata build() {
            return new ExportMetadata(name, size, exportHash, paperRevision);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.name,
            this.size,
            this.exportHash,
            this.paperRevision
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
            ExportMetadata other = (ExportMetadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && (this.size == other.size)
                && ((this.exportHash == other.exportHash) || (this.exportHash != null && this.exportHash.equals(other.exportHash)))
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
    static class Serializer extends StructSerializer<ExportMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExportMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("size");
            StoneSerializers.uInt64().serialize(value.size, g);
            if (value.exportHash != null) {
                g.writeFieldName("export_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.exportHash, g);
            }
            if (value.paperRevision != null) {
                g.writeFieldName("paper_revision");
                StoneSerializers.nullable(StoneSerializers.int64()).serialize(value.paperRevision, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExportMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExportMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                Long f_size = null;
                String f_exportHash = null;
                Long f_paperRevision = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("size".equals(field)) {
                        f_size = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("export_hash".equals(field)) {
                        f_exportHash = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("paper_revision".equals(field)) {
                        f_paperRevision = StoneSerializers.nullable(StoneSerializers.int64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_size == null) {
                    throw new JsonParseException(p, "Required field \"size\" missing.");
                }
                value = new ExportMetadata(f_name, f_size, f_exportHash, f_paperRevision);
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
