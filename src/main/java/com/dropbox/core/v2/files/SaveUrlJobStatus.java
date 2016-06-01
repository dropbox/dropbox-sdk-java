/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class SaveUrlJobStatus {
    // union SaveUrlJobStatus

    /**
     * Discriminating tag type for {@link SaveUrlJobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * Metadata of the file where the URL is saved to.
         */
        COMPLETE, // FileMetadata
        FAILED; // SaveUrlError
    }

    /**
     * The asynchronous job is still in progress.
     */
    public static final SaveUrlJobStatus IN_PROGRESS = new SaveUrlJobStatus(Tag.IN_PROGRESS, null, null);

    private final Tag tag;
    private final FileMetadata completeValue;
    private final SaveUrlError failedValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private SaveUrlJobStatus(Tag tag, FileMetadata completeValue, SaveUrlError failedValue) {
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
     * values for this {@code SaveUrlJobStatus}. </p>
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
     * Returns an instance of {@code SaveUrlJobStatus} that has its tag set to
     * {@link Tag#COMPLETE}.
     *
     * <p> Metadata of the file where the URL is saved to. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SaveUrlJobStatus} with its tag set to {@link
     *     Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SaveUrlJobStatus complete(FileMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveUrlJobStatus(Tag.COMPLETE, value, null);
    }

    /**
     * Metadata of the file where the URL is saved to.
     *
     * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
     *
     * @return The {@link SaveUrlJobStatus#complete} value associated with this
     *     instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public FileMetadata getCompleteValue() {
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
     * Returns an instance of {@code SaveUrlJobStatus} that has its tag set to
     * {@link Tag#FAILED}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SaveUrlJobStatus} with its tag set to {@link
     *     Tag#FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SaveUrlJobStatus failed(SaveUrlError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveUrlJobStatus(Tag.FAILED, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FAILED}.
     *
     * @return The {@link SaveUrlJobStatus#failed} value associated with this
     *     instance if {@link #isFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
     */
    public SaveUrlError getFailedValue() {
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
        else if (obj instanceof SaveUrlJobStatus) {
            SaveUrlJobStatus other = (SaveUrlJobStatus) obj;
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
    static final class Serializer extends UnionSerializer<SaveUrlJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SaveUrlJobStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case COMPLETE: {
                    g.writeStartObject();
                    writeTag("complete", g);
                    g.writeFieldName("complete");
                    FileMetadata.Serializer.INSTANCE.serialize(value.completeValue, g);
                    g.writeEndObject();
                    break;
                }
                case FAILED: {
                    g.writeStartObject();
                    writeTag("failed", g);
                    g.writeFieldName("failed");
                    SaveUrlError.Serializer.INSTANCE.serialize(value.failedValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public SaveUrlJobStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            SaveUrlJobStatus value;
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
            else if ("in_progress".equals(tag)) {
                value = SaveUrlJobStatus.IN_PROGRESS;
            }
            else if ("complete".equals(tag)) {
                FileMetadata fieldValue = null;
                expectField("complete", p);
                fieldValue = FileMetadata.Serializer.INSTANCE.deserialize(p);
                value = SaveUrlJobStatus.complete(fieldValue);
            }
            else if ("failed".equals(tag)) {
                SaveUrlError fieldValue = null;
                expectField("failed", p);
                fieldValue = SaveUrlError.Serializer.INSTANCE.deserialize(p);
                value = SaveUrlJobStatus.failed(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
