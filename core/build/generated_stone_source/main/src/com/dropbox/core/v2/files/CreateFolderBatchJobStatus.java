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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class CreateFolderBatchJobStatus {
    // union files.CreateFolderBatchJobStatus (files.stone)

    /**
     * Discriminating tag type for {@link CreateFolderBatchJobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * The batch create folder has finished.
         */
        COMPLETE, // CreateFolderBatchResult
        /**
         * The batch create folder has failed.
         */
        FAILED, // CreateFolderBatchError
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
     * The asynchronous job is still in progress.
     */
    public static final CreateFolderBatchJobStatus IN_PROGRESS = new CreateFolderBatchJobStatus().withTag(Tag.IN_PROGRESS);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final CreateFolderBatchJobStatus OTHER = new CreateFolderBatchJobStatus().withTag(Tag.OTHER);

    private Tag _tag;
    private CreateFolderBatchResult completeValue;
    private CreateFolderBatchError failedValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private CreateFolderBatchJobStatus() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private CreateFolderBatchJobStatus withTag(Tag _tag) {
        CreateFolderBatchJobStatus result = new CreateFolderBatchJobStatus();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param completeValue  The batch create folder has finished. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private CreateFolderBatchJobStatus withTagAndComplete(Tag _tag, CreateFolderBatchResult completeValue) {
        CreateFolderBatchJobStatus result = new CreateFolderBatchJobStatus();
        result._tag = _tag;
        result.completeValue = completeValue;
        return result;
    }

    /**
     *
     * @param failedValue  The batch create folder has failed. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private CreateFolderBatchJobStatus withTagAndFailed(Tag _tag, CreateFolderBatchError failedValue) {
        CreateFolderBatchJobStatus result = new CreateFolderBatchJobStatus();
        result._tag = _tag;
        result.failedValue = failedValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code CreateFolderBatchJobStatus}. </p>
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#COMPLETE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#COMPLETE},
     *     {@code false} otherwise.
     */
    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    /**
     * Returns an instance of {@code CreateFolderBatchJobStatus} that has its
     * tag set to {@link Tag#COMPLETE}.
     *
     * <p> The batch create folder has finished. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code CreateFolderBatchJobStatus} with its tag set
     *     to {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static CreateFolderBatchJobStatus complete(CreateFolderBatchResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderBatchJobStatus().withTagAndComplete(Tag.COMPLETE, value);
    }

    /**
     * The batch create folder has finished.
     *
     * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
     *
     * @return The {@link CreateFolderBatchResult} value associated with this
     *     instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public CreateFolderBatchResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
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
        return this._tag == Tag.FAILED;
    }

    /**
     * Returns an instance of {@code CreateFolderBatchJobStatus} that has its
     * tag set to {@link Tag#FAILED}.
     *
     * <p> The batch create folder has failed. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code CreateFolderBatchJobStatus} with its tag set
     *     to {@link Tag#FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static CreateFolderBatchJobStatus failed(CreateFolderBatchError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderBatchJobStatus().withTagAndFailed(Tag.FAILED, value);
    }

    /**
     * The batch create folder has failed.
     *
     * <p> This instance must be tagged as {@link Tag#FAILED}. </p>
     *
     * @return The {@link CreateFolderBatchError} value associated with this
     *     instance if {@link #isFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
     */
    public CreateFolderBatchError getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return failedValue;
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
            this._tag,
            this.completeValue,
            this.failedValue
        });
        hash = (31 * super.hashCode()) + hash;
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
        else if (obj instanceof CreateFolderBatchJobStatus) {
            CreateFolderBatchJobStatus other = (CreateFolderBatchJobStatus) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case IN_PROGRESS:
                    return true;
                case COMPLETE:
                    return (this.completeValue == other.completeValue) || (this.completeValue.equals(other.completeValue));
                case FAILED:
                    return (this.failedValue == other.failedValue) || (this.failedValue.equals(other.failedValue));
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
    static class Serializer extends UnionSerializer<CreateFolderBatchJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CreateFolderBatchJobStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case COMPLETE: {
                    g.writeStartObject();
                    writeTag("complete", g);
                    CreateFolderBatchResult.Serializer.INSTANCE.serialize(value.completeValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case FAILED: {
                    g.writeStartObject();
                    writeTag("failed", g);
                    g.writeFieldName("failed");
                    CreateFolderBatchError.Serializer.INSTANCE.serialize(value.failedValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public CreateFolderBatchJobStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            CreateFolderBatchJobStatus value;
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
                value = CreateFolderBatchJobStatus.IN_PROGRESS;
            }
            else if ("complete".equals(tag)) {
                CreateFolderBatchResult fieldValue = null;
                fieldValue = CreateFolderBatchResult.Serializer.INSTANCE.deserialize(p, true);
                value = CreateFolderBatchJobStatus.complete(fieldValue);
            }
            else if ("failed".equals(tag)) {
                CreateFolderBatchError fieldValue = null;
                expectField("failed", p);
                fieldValue = CreateFolderBatchError.Serializer.INSTANCE.deserialize(p);
                value = CreateFolderBatchJobStatus.failed(fieldValue);
            }
            else {
                value = CreateFolderBatchJobStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
