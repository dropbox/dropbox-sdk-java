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

public class PreviewResult {
    // struct files.PreviewResult (files.stone)

    protected final FileMetadata fileMetadata;
    protected final MinimalFileLinkMetadata linkMetadata;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param fileMetadata  Metadata corresponding to the file received as an
     *     argument. Will be populated if the endpoint is called with a path
     *     (ReadPath).
     * @param linkMetadata  Minimal metadata corresponding to the file received
     *     as an argument. Will be populated if the endpoint is called using a
     *     shared link (SharedLinkFileInfo).
     */
    public PreviewResult(@Nullable FileMetadata fileMetadata, @Nullable MinimalFileLinkMetadata linkMetadata) {
        this.fileMetadata = fileMetadata;
        this.linkMetadata = linkMetadata;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public PreviewResult() {
        this(null, null);
    }

    /**
     * Metadata corresponding to the file received as an argument. Will be
     * populated if the endpoint is called with a path (ReadPath).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FileMetadata getFileMetadata() {
        return fileMetadata;
    }

    /**
     * Minimal metadata corresponding to the file received as an argument. Will
     * be populated if the endpoint is called using a shared link
     * (SharedLinkFileInfo).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public MinimalFileLinkMetadata getLinkMetadata() {
        return linkMetadata;
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
     * Builder for {@link PreviewResult}.
     */
    public static class Builder {

        protected FileMetadata fileMetadata;
        protected MinimalFileLinkMetadata linkMetadata;

        protected Builder() {
            this.fileMetadata = null;
            this.linkMetadata = null;
        }

        /**
         * Set value for optional field.
         *
         * @param fileMetadata  Metadata corresponding to the file received as
         *     an argument. Will be populated if the endpoint is called with a
         *     path (ReadPath).
         *
         * @return this builder
         */
        public Builder withFileMetadata(FileMetadata fileMetadata) {
            this.fileMetadata = fileMetadata;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linkMetadata  Minimal metadata corresponding to the file
         *     received as an argument. Will be populated if the endpoint is
         *     called using a shared link (SharedLinkFileInfo).
         *
         * @return this builder
         */
        public Builder withLinkMetadata(MinimalFileLinkMetadata linkMetadata) {
            this.linkMetadata = linkMetadata;
            return this;
        }

        /**
         * Builds an instance of {@link PreviewResult} configured with this
         * builder's values
         *
         * @return new instance of {@link PreviewResult}
         */
        public PreviewResult build() {
            return new PreviewResult(fileMetadata, linkMetadata);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            fileMetadata,
            linkMetadata
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
            PreviewResult other = (PreviewResult) obj;
            return ((this.fileMetadata == other.fileMetadata) || (this.fileMetadata != null && this.fileMetadata.equals(other.fileMetadata)))
                && ((this.linkMetadata == other.linkMetadata) || (this.linkMetadata != null && this.linkMetadata.equals(other.linkMetadata)))
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
    static class Serializer extends StructSerializer<PreviewResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PreviewResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.fileMetadata != null) {
                g.writeFieldName("file_metadata");
                StoneSerializers.nullableStruct(FileMetadata.Serializer.INSTANCE).serialize(value.fileMetadata, g);
            }
            if (value.linkMetadata != null) {
                g.writeFieldName("link_metadata");
                StoneSerializers.nullableStruct(MinimalFileLinkMetadata.Serializer.INSTANCE).serialize(value.linkMetadata, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PreviewResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PreviewResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FileMetadata f_fileMetadata = null;
                MinimalFileLinkMetadata f_linkMetadata = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file_metadata".equals(field)) {
                        f_fileMetadata = StoneSerializers.nullableStruct(FileMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("link_metadata".equals(field)) {
                        f_linkMetadata = StoneSerializers.nullableStruct(MinimalFileLinkMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new PreviewResult(f_fileMetadata, f_linkMetadata);
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
