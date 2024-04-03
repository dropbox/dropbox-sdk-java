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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class MediaInfo {
    // union files.MediaInfo (files.stone)

    /**
     * Discriminating tag type for {@link MediaInfo}.
     */
    public enum Tag {
        /**
         * Indicate the photo/video is still under processing and metadata is
         * not available yet.
         */
        PENDING,
        /**
         * The metadata for the photo/video.
         */
        METADATA; // MediaMetadata
    }

    /**
     * Indicate the photo/video is still under processing and metadata is not
     * available yet.
     */
    public static final MediaInfo PENDING = new MediaInfo().withTag(Tag.PENDING);

    private Tag _tag;
    private MediaMetadata metadataValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private MediaInfo() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private MediaInfo withTag(Tag _tag) {
        MediaInfo result = new MediaInfo();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param metadataValue  The metadata for the photo/video. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MediaInfo withTagAndMetadata(Tag _tag, MediaMetadata metadataValue) {
        MediaInfo result = new MediaInfo();
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
     * values for this {@code MediaInfo}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PENDING},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PENDING},
     *     {@code false} otherwise.
     */
    public boolean isPending() {
        return this._tag == Tag.PENDING;
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
     * Returns an instance of {@code MediaInfo} that has its tag set to {@link
     * Tag#METADATA}.
     *
     * <p> The metadata for the photo/video. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MediaInfo} with its tag set to {@link
     *     Tag#METADATA}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MediaInfo metadata(MediaMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MediaInfo().withTagAndMetadata(Tag.METADATA, value);
    }

    /**
     * The metadata for the photo/video.
     *
     * <p> This instance must be tagged as {@link Tag#METADATA}. </p>
     *
     * @return The {@link MediaMetadata} value associated with this instance if
     *     {@link #isMetadata} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMetadata} is {@code false}.
     */
    public MediaMetadata getMetadataValue() {
        if (this._tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + this._tag.name());
        }
        return metadataValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.metadataValue
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
        else if (obj instanceof MediaInfo) {
            MediaInfo other = (MediaInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PENDING:
                    return true;
                case METADATA:
                    return (this.metadataValue == other.metadataValue) || (this.metadataValue.equals(other.metadataValue));
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
    static class Serializer extends UnionSerializer<MediaInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MediaInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PENDING: {
                    g.writeString("pending");
                    break;
                }
                case METADATA: {
                    g.writeStartObject();
                    writeTag("metadata", g);
                    g.writeFieldName("metadata");
                    MediaMetadata.Serializer.INSTANCE.serialize(value.metadataValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public MediaInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            MediaInfo value;
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
            else if ("pending".equals(tag)) {
                value = MediaInfo.PENDING;
            }
            else if ("metadata".equals(tag)) {
                MediaMetadata fieldValue = null;
                expectField("metadata", p);
                fieldValue = MediaMetadata.Serializer.INSTANCE.deserialize(p);
                value = MediaInfo.metadata(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
