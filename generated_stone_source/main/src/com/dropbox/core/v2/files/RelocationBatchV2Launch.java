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
 * Result returned by {@link
 * DbxUserFilesRequests#copyBatchV2(java.util.List,boolean)} or {@link
 * DbxUserFilesRequests#moveBatchV2(java.util.List)} that may either launch an
 * asynchronous job or complete synchronously.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class RelocationBatchV2Launch {
    // union files.RelocationBatchV2Launch (files.stone)

    /**
     * Discriminating tag type for {@link RelocationBatchV2Launch}.
     */
    public enum Tag {
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        ASYNC_JOB_ID, // String
        COMPLETE; // RelocationBatchV2Result
    }

    private Tag _tag;
    private String asyncJobIdValue;
    private RelocationBatchV2Result completeValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RelocationBatchV2Launch() {
    }


    /**
     * Result returned by {@link
     * DbxUserFilesRequests#copyBatchV2(java.util.List,boolean)} or {@link
     * DbxUserFilesRequests#moveBatchV2(java.util.List)} that may either launch
     * an asynchronous job or complete synchronously.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RelocationBatchV2Launch withTag(Tag _tag) {
        RelocationBatchV2Launch result = new RelocationBatchV2Launch();
        result._tag = _tag;
        return result;
    }

    /**
     * Result returned by {@link
     * DbxUserFilesRequests#copyBatchV2(java.util.List,boolean)} or {@link
     * DbxUserFilesRequests#moveBatchV2(java.util.List)} that may either launch
     * an asynchronous job or complete synchronously.
     *
     * @param asyncJobIdValue  This response indicates that the processing is
     *     asynchronous. The string is an id that can be used to obtain the
     *     status of the asynchronous job. Must have length of at least 1 and
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchV2Launch withTagAndAsyncJobId(Tag _tag, String asyncJobIdValue) {
        RelocationBatchV2Launch result = new RelocationBatchV2Launch();
        result._tag = _tag;
        result.asyncJobIdValue = asyncJobIdValue;
        return result;
    }

    /**
     * Result returned by {@link
     * DbxUserFilesRequests#copyBatchV2(java.util.List,boolean)} or {@link
     * DbxUserFilesRequests#moveBatchV2(java.util.List)} that may either launch
     * an asynchronous job or complete synchronously.
     *
     * @param completeValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchV2Launch withTagAndComplete(Tag _tag, RelocationBatchV2Result completeValue) {
        RelocationBatchV2Launch result = new RelocationBatchV2Launch();
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
     * values for this {@code RelocationBatchV2Launch}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     */
    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    /**
     * Returns an instance of {@code RelocationBatchV2Launch} that has its tag
     * set to {@link Tag#ASYNC_JOB_ID}.
     *
     * <p> This response indicates that the processing is asynchronous. The
     * string is an id that can be used to obtain the status of the asynchronous
     * job. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchV2Launch} with its tag set to
     *     {@link Tag#ASYNC_JOB_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static RelocationBatchV2Launch asyncJobId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new RelocationBatchV2Launch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, value);
    }

    /**
     * This response indicates that the processing is asynchronous. The string
     * is an id that can be used to obtain the status of the asynchronous job.
     *
     * <p> This instance must be tagged as {@link Tag#ASYNC_JOB_ID}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isAsyncJobId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAsyncJobId} is {@code false}.
     */
    public String getAsyncJobIdValue() {
        if (this._tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + this._tag.name());
        }
        return asyncJobIdValue;
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
     * Returns an instance of {@code RelocationBatchV2Launch} that has its tag
     * set to {@link Tag#COMPLETE}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchV2Launch} with its tag set to
     *     {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchV2Launch complete(RelocationBatchV2Result value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchV2Launch().withTagAndComplete(Tag.COMPLETE, value);
    }

    /**
     * This instance must be tagged as {@link Tag#COMPLETE}.
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
            _tag,
            asyncJobIdValue,
            completeValue
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
        else if (obj instanceof RelocationBatchV2Launch) {
            RelocationBatchV2Launch other = (RelocationBatchV2Launch) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ASYNC_JOB_ID:
                    return (this.asyncJobIdValue == other.asyncJobIdValue) || (this.asyncJobIdValue.equals(other.asyncJobIdValue));
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
    static class Serializer extends UnionSerializer<RelocationBatchV2Launch> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationBatchV2Launch value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ASYNC_JOB_ID: {
                    g.writeStartObject();
                    writeTag("async_job_id", g);
                    g.writeFieldName("async_job_id");
                    StoneSerializers.string().serialize(value.asyncJobIdValue, g);
                    g.writeEndObject();
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
        public RelocationBatchV2Launch deserialize(JsonParser p) throws IOException, JsonParseException {
            RelocationBatchV2Launch value;
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
            else if ("async_job_id".equals(tag)) {
                String fieldValue = null;
                expectField("async_job_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = RelocationBatchV2Launch.asyncJobId(fieldValue);
            }
            else if ("complete".equals(tag)) {
                RelocationBatchV2Result fieldValue = null;
                fieldValue = RelocationBatchV2Result.Serializer.INSTANCE.deserialize(p, true);
                value = RelocationBatchV2Launch.complete(fieldValue);
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
