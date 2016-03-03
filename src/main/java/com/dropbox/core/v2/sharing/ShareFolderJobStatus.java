/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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
@JsonSerialize(using=ShareFolderJobStatus.Serializer.class)
@JsonDeserialize(using=ShareFolderJobStatus.Deserializer.class)
public final class ShareFolderJobStatus {
    // union ShareFolderJobStatus

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link ShareFolderJobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * The share job has finished. The value is the metadata for the folder.
         */
        COMPLETE, // SharedFolderMetadata
        FAILED; // ShareFolderError
    }

    /**
     * The asynchronous job is still in progress.
     */
    public static final ShareFolderJobStatus IN_PROGRESS = new ShareFolderJobStatus(Tag.IN_PROGRESS, null, null);

    private final Tag tag;
    private final SharedFolderMetadata completeValue;
    private final ShareFolderError failedValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ShareFolderJobStatus(Tag tag, SharedFolderMetadata completeValue, ShareFolderError failedValue) {
        this.tag = tag;
        this.completeValue = completeValue;
        this.failedValue = failedValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ShareFolderJobStatus}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this.tag == Tag.IN_PROGRESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#COMPLETE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#COMPLETE},
     *     {@code false} otherwise.
     */
    public boolean isComplete() {
        return this.tag == Tag.COMPLETE;
    }

    /**
     * Returns an instance of {@code ShareFolderJobStatus} that has its tag set
     * to {@link Tag#COMPLETE}.
     *
     * <p> The share job has finished. The value is the metadata for the folder.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ShareFolderJobStatus} with its tag set to
     *     {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ShareFolderJobStatus complete(SharedFolderMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderJobStatus(Tag.COMPLETE, value, null);
    }

    /**
     * The share job has finished. The value is the metadata for the folder.
     *
     * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
     *
     * @return The {@link ShareFolderJobStatus#complete} value associated with
     *     this instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public SharedFolderMetadata getCompleteValue() {
        if (this.tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + tag.name());
        }
        return completeValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FAILED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#FAILED},
     *     {@code false} otherwise.
     */
    public boolean isFailed() {
        return this.tag == Tag.FAILED;
    }

    /**
     * Returns an instance of {@code ShareFolderJobStatus} that has its tag set
     * to {@link Tag#FAILED}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ShareFolderJobStatus} with its tag set to
     *     {@link Tag#FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ShareFolderJobStatus failed(ShareFolderError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderJobStatus(Tag.FAILED, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FAILED}.
     *
     * @return The {@link ShareFolderJobStatus#failed} value associated with
     *     this instance if {@link #isFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
     */
    public ShareFolderError getFailedValue() {
        if (this.tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + tag.name());
        }
        return failedValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            completeValue,
            failedValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ShareFolderJobStatus) {
            ShareFolderJobStatus other = (ShareFolderJobStatus) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case IN_PROGRESS:
                    return true;
                case COMPLETE:
                    return (this.completeValue == other.completeValue) || (this.completeValue.equals(other.completeValue));
                case FAILED:
                    return (this.failedValue == other.failedValue) || (this.failedValue.equals(other.failedValue));
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

    static final class Serializer extends UnionJsonSerializer<ShareFolderJobStatus> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ShareFolderJobStatus.class, SharedFolderMetadata.class);
        }

        @Override
        public void serialize(ShareFolderJobStatus value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case IN_PROGRESS:
                    g.writeString("in_progress");
                    break;
                case COMPLETE:
                    g.writeStartObject();
                    g.writeStringField(".tag", "complete");
                    getUnwrappingSerializer(SharedFolderMetadata.class).serialize(value.completeValue, g, provider);
                    g.writeEndObject();
                    break;
                case FAILED:
                    g.writeStartObject();
                    g.writeStringField(".tag", "failed");
                    g.writeObjectField("failed", value.failedValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ShareFolderJobStatus, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ShareFolderJobStatus.class, getTagMapping(), null, SharedFolderMetadata.class);
        }

        @Override
        public ShareFolderJobStatus deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case IN_PROGRESS: {
                    return ShareFolderJobStatus.IN_PROGRESS;
                }
                case COMPLETE: {
                    SharedFolderMetadata value = null;
                    value = readCollapsedStructValue(SharedFolderMetadata.class, _p, _ctx);
                    return ShareFolderJobStatus.complete(value);
                }
                case FAILED: {
                    ShareFolderError value = null;
                    expectField(_p, "failed");
                    value = _p.readValueAs(ShareFolderError.class);
                    _p.nextToken();
                    return ShareFolderJobStatus.failed(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, ShareFolderJobStatus.Tag> getTagMapping() {
            Map<String, ShareFolderJobStatus.Tag> values = new HashMap<String, ShareFolderJobStatus.Tag>();
            values.put("complete", ShareFolderJobStatus.Tag.COMPLETE);
            values.put("failed", ShareFolderJobStatus.Tag.FAILED);
            return Collections.unmodifiableMap(values);
        }
    }
}
