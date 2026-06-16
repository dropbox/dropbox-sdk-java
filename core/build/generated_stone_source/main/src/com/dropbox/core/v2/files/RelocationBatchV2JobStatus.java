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
 * Result returned by {@link DbxUserFilesRequests#copyBatchCheckV2(String)} or
 * {@link DbxUserFilesRequests#moveBatchCheckV2(String)} that may either be in
 * progress or completed with result for each entry.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class RelocationBatchV2JobStatus {
    // union files.RelocationBatchV2JobStatus (files.stone)

    /**
     * Discriminating tag type for {@link RelocationBatchV2JobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * The copy or move batch job has finished.
         */
        COMPLETE; // RelocationBatchV2Result
    }

    /**
     * The asynchronous job is still in progress.
     */
    public static final RelocationBatchV2JobStatus IN_PROGRESS = new RelocationBatchV2JobStatus().withTag(Tag.IN_PROGRESS);

    private Tag _tag;
    private RelocationBatchV2Result completeValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RelocationBatchV2JobStatus() {
    }


    /**
     * Result returned by {@link DbxUserFilesRequests#copyBatchCheckV2(String)}
     * or {@link DbxUserFilesRequests#moveBatchCheckV2(String)} that may either
     * be in progress or completed with result for each entry.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RelocationBatchV2JobStatus withTag(Tag _tag) {
        RelocationBatchV2JobStatus result = new RelocationBatchV2JobStatus();
        result._tag = _tag;
        return result;
    }

    /**
     * Result returned by {@link DbxUserFilesRequests#copyBatchCheckV2(String)}
     * or {@link DbxUserFilesRequests#moveBatchCheckV2(String)} that may either
     * be in progress or completed with result for each entry.
     *
     * @param completeValue  The copy or move batch job has finished. Must not
     *     be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchV2JobStatus withTagAndComplete(Tag _tag, RelocationBatchV2Result completeValue) {
        RelocationBatchV2JobStatus result = new RelocationBatchV2JobStatus();
        result._tag = _tag;
        result.completeValue = completeValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RelocationBatchV2JobStatus}. </p>
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
     * Returns an instance of {@code RelocationBatchV2JobStatus} that has its
     * tag set to {@link Tag#COMPLETE}.
     *
     * <p> The copy or move batch job has finished. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchV2JobStatus} with its tag set
     *     to {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchV2JobStatus complete(RelocationBatchV2Result value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchV2JobStatus().withTagAndComplete(Tag.COMPLETE, value);
    }

    /**
     * The copy or move batch job has finished.
     *
     * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
     *
     * @return The {@link RelocationBatchV2Result} value associated with this
     *     instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public RelocationBatchV2Result getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return completeValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.completeValue
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
        else if (obj instanceof RelocationBatchV2JobStatus) {
            RelocationBatchV2JobStatus other = (RelocationBatchV2JobStatus) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case IN_PROGRESS:
                    return true;
                case COMPLETE:
                    return (this.completeValue == other.completeValue) || (this.completeValue.equals(other.completeValue));
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
    static class Serializer extends UnionSerializer<RelocationBatchV2JobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationBatchV2JobStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case COMPLETE: {
                    g.writeStartObject();
                    writeTag("complete", g);
                    RelocationBatchV2Result.Serializer.INSTANCE.serialize(value.completeValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public RelocationBatchV2JobStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            RelocationBatchV2JobStatus value;
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
                value = RelocationBatchV2JobStatus.IN_PROGRESS;
            }
            else if ("complete".equals(tag)) {
                RelocationBatchV2Result fieldValue = null;
                fieldValue = RelocationBatchV2Result.Serializer.INSTANCE.deserialize(p, true);
                value = RelocationBatchV2JobStatus.complete(fieldValue);
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
