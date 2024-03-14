/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Metadata for a file, folder or other resource types.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class MetadataV2 {
    // union files.MetadataV2 (files.stone)

    /**
     * Discriminating tag type for {@link MetadataV2}.
     */
    public enum Tag {
        METADATA, // Metadata
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final MetadataV2 OTHER = new MetadataV2().withTag(Tag.OTHER);

    private Tag _tag;
    private Metadata metadataValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private MetadataV2() {
    }


    /**
     * Metadata for a file, folder or other resource types.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private MetadataV2 withTag(Tag _tag) {
        MetadataV2 result = new MetadataV2();
        result._tag = _tag;
        return result;
    }

    /**
     * Metadata for a file, folder or other resource types.
     *
     * @param metadataValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MetadataV2 withTagAndMetadata(Tag _tag, Metadata metadataValue) {
        MetadataV2 result = new MetadataV2();
        result._tag = _tag;
        result.metadataValue = metadataValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MetadataV2}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#METADATA},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#METADATA},
     *     {@code false} otherwise.
     */
    public boolean isMetadata() {
        return this._tag == Tag.METADATA;
    }

    /**
     * Returns an instance of {@code MetadataV2} that has its tag set to {@link
     * Tag#METADATA}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MetadataV2} with its tag set to {@link
     *     Tag#METADATA}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MetadataV2 metadata(Metadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MetadataV2().withTagAndMetadata(Tag.METADATA, value);
    }

    /**
     * This instance must be tagged as {@link Tag#METADATA}.
     *
     * @return The {@link Metadata} value associated with this instance if
     *     {@link #isMetadata} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMetadata} is {@code false}.
     */
    public Metadata getMetadataValue() {
        if (this._tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + this._tag.name());
        }
        return metadataValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            metadataValue
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
        else if (obj instanceof MetadataV2) {
            MetadataV2 other = (MetadataV2) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case METADATA:
                    return (this.metadataValue == other.metadataValue) || (this.metadataValue.equals(other.metadataValue));
                case OTHER:
                    return true;
                default:
                    return false;
            }
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
    static class Serializer extends UnionSerializer<MetadataV2> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MetadataV2 value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case METADATA: {
                    g.writeStartObject();
                    writeTag("metadata", g);
                    g.writeFieldName("metadata");
                    Metadata.Serializer.INSTANCE.serialize(value.metadataValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MetadataV2 deserialize(JsonParser p) throws IOException, JsonParseException {
            MetadataV2 value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("metadata".equals(tag)) {
                Metadata fieldValue = null;
                expectField("metadata", p);
                fieldValue = Metadata.Serializer.INSTANCE.deserialize(p);
                value = MetadataV2.metadata(fieldValue);
            }
            else {
                value = MetadataV2.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
