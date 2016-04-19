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
@JsonSerialize(using=JobStatus.Serializer.class)
@JsonDeserialize(using=JobStatus.Deserializer.class)
public final class JobStatus {
    // union JobStatus

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link JobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * The asynchronous job has finished.
         */
        COMPLETE,
        /**
         * The asynchronous job returned an error.
         */
        FAILED; // JobError
    }

    /**
     * The asynchronous job is still in progress.
     */
    public static final JobStatus IN_PROGRESS = new JobStatus(Tag.IN_PROGRESS, null);
    /**
     * The asynchronous job has finished.
     */
    public static final JobStatus COMPLETE = new JobStatus(Tag.COMPLETE, null);

    private final Tag tag;
    private final JobError failedValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private JobStatus(Tag tag, JobError failedValue) {
        this.tag = tag;
        this.failedValue = failedValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code JobStatus}. </p>
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
     * Returns an instance of {@code JobStatus} that has its tag set to {@link
     * Tag#FAILED}.
     *
     * <p> The asynchronous job returned an error. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code JobStatus} with its tag set to {@link
     *     Tag#FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static JobStatus failed(JobError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobStatus(Tag.FAILED, value);
    }

    /**
     * The asynchronous job returned an error.
     *
     * <p> This instance must be tagged as {@link Tag#FAILED}. </p>
     *
     * @return The {@link JobStatus#failed} value associated with this instance
     *     if {@link #isFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
     */
    public JobError getFailedValue() {
        if (this.tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + tag.name());
        }
        return failedValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
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
        else if (obj instanceof JobStatus) {
            JobStatus other = (JobStatus) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case IN_PROGRESS:
                    return true;
                case COMPLETE:
                    return true;
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

    static final class Serializer extends UnionJsonSerializer<JobStatus> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(JobStatus.class);
        }

        @Override
        public void serialize(JobStatus value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case IN_PROGRESS:
                    g.writeString("in_progress");
                    break;
                case COMPLETE:
                    g.writeString("complete");
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

    static final class Deserializer extends UnionJsonDeserializer<JobStatus, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(JobStatus.class, getTagMapping(), null);
        }

        @Override
        public JobStatus deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case IN_PROGRESS: {
                    return JobStatus.IN_PROGRESS;
                }
                case COMPLETE: {
                    return JobStatus.COMPLETE;
                }
                case FAILED: {
                    JobError value = null;
                    expectField(_p, "failed");
                    value = _p.readValueAs(JobError.class);
                    _p.nextToken();
                    return JobStatus.failed(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, JobStatus.Tag> getTagMapping() {
            Map<String, JobStatus.Tag> values = new HashMap<String, JobStatus.Tag>();
            values.put("complete", JobStatus.Tag.COMPLETE);
            values.put("failed", JobStatus.Tag.FAILED);
            return Collections.unmodifiableMap(values);
        }
    }
}
