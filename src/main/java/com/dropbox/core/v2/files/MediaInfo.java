/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
@JsonSerialize(using=MediaInfo.Serializer.class)
@JsonDeserialize(using=MediaInfo.Deserializer.class)
public final class MediaInfo {
    // union MediaInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
    public static final MediaInfo PENDING = new MediaInfo(Tag.PENDING, null);

    private final Tag tag;
    private final MediaMetadata metadataValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MediaInfo(Tag tag, MediaMetadata metadataValue) {
        this.tag = tag;
        this.metadataValue = metadataValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PENDING},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PENDING},
     *     {@code false} otherwise.
     */
    public boolean isPending() {
        return this.tag == Tag.PENDING;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#METADATA},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#METADATA},
     *     {@code false} otherwise.
     */
    public boolean isMetadata() {
        return this.tag == Tag.METADATA;
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
        return new MediaInfo(Tag.METADATA, value);
    }

    /**
     * The metadata for the photo/video.
     *
     * <p> This instance must be tagged as {@link Tag#METADATA}. </p>
     *
     * @return The {@link MediaInfo#metadata} value associated with this
     *     instance if {@link #isMetadata} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMetadata} is {@code false}.
     */
    public MediaMetadata getMetadataValue() {
        if (this.tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + tag.name());
        }
        return metadataValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            metadataValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof MediaInfo) {
            MediaInfo other = (MediaInfo) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends UnionJsonSerializer<MediaInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MediaInfo.class);
        }

        @Override
        public void serialize(MediaInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case PENDING:
                    g.writeString("pending");
                    break;
                case METADATA:
                    g.writeStartObject();
                    g.writeStringField(".tag", "metadata");
                    g.writeObjectField("metadata", value.metadataValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MediaInfo, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MediaInfo.class, getTagMapping(), null);
        }

        @Override
        public MediaInfo deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case PENDING: {
                    return MediaInfo.PENDING;
                }
                case METADATA: {
                    MediaMetadata value = null;
                    expectField(_p, "metadata");
                    value = _p.readValueAs(MediaMetadata.class);
                    _p.nextToken();
                    return MediaInfo.metadata(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, MediaInfo.Tag> getTagMapping() {
            Map<String, MediaInfo.Tag> values = new HashMap<String, MediaInfo.Tag>();
            values.put("pending", MediaInfo.Tag.PENDING);
            values.put("metadata", MediaInfo.Tag.METADATA);
            return Collections.unmodifiableMap(values);
        }
    }
}
