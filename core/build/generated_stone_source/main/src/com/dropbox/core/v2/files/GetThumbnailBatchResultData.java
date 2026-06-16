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

public class GetThumbnailBatchResultData {
    // struct files.GetThumbnailBatchResultData (files.stone)

    @Nonnull
    protected final FileMetadata metadata;
    @Nonnull
    protected final String thumbnail;

    /**
     *
     * @param metadata  Must not be {@code null}.
     * @param thumbnail  A string containing the base64-encoded thumbnail data
     *     for this file. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetThumbnailBatchResultData(@Nonnull FileMetadata metadata, @Nonnull String thumbnail) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        if (thumbnail == null) {
            throw new IllegalArgumentException("Required value for 'thumbnail' is null");
        }
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FileMetadata getMetadata() {
        return metadata;
    }

    /**
     * A string containing the base64-encoded thumbnail data for this file.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.metadata,
            this.thumbnail
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
            GetThumbnailBatchResultData other = (GetThumbnailBatchResultData) obj;
            return ((this.metadata == other.metadata) || (this.metadata.equals(other.metadata)))
                && ((this.thumbnail == other.thumbnail) || (this.thumbnail.equals(other.thumbnail)))
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
    static class Serializer extends StructSerializer<GetThumbnailBatchResultData> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetThumbnailBatchResultData value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("metadata");
            FileMetadata.Serializer.INSTANCE.serialize(value.metadata, g);
            g.writeFieldName("thumbnail");
            StoneSerializers.string().serialize(value.thumbnail, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetThumbnailBatchResultData deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetThumbnailBatchResultData value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FileMetadata f_metadata = null;
                String f_thumbnail = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("metadata".equals(field)) {
                        f_metadata = FileMetadata.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("thumbnail".equals(field)) {
                        f_thumbnail = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_metadata == null) {
                    throw new JsonParseException(p, "Required field \"metadata\" missing.");
                }
                if (f_thumbnail == null) {
                    throw new JsonParseException(p, "Required field \"thumbnail\" missing.");
                }
                value = new GetThumbnailBatchResultData(f_metadata, f_thumbnail);
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
