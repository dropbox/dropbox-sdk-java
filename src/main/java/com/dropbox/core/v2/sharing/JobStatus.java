/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class JobStatus {
    // union JobStatus

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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("complete", Tag.COMPLETE);
        VALUES_.put("failed", Tag.FAILED);
    }

    public static final JobStatus IN_PROGRESS = new JobStatus(Tag.IN_PROGRESS, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code JobStatus}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this.tag == Tag.IN_PROGRESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#COMPLETE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#COMPLETE}, {@code false} otherwise.
     */
    public boolean isComplete() {
        return this.tag == Tag.COMPLETE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FAILED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#FAILED},
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
     * @param value  {@link JobStatus#failed} value to assign to this instance.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static JobStatus fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<JobStatus> _JSON_WRITER = new JsonWriter<JobStatus>() {
        public final void write(JobStatus x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case IN_PROGRESS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("in_progress");
                    g.writeEndObject();
                    break;
                case COMPLETE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("complete");
                    g.writeEndObject();
                    break;
                case FAILED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("failed");
                    g.writeFieldName("failed");
                    JobError._JSON_WRITER.write(x.getFailedValue(), g);
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<JobStatus> _JSON_READER = new JsonReader<JobStatus>() {

        public final JobStatus read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case IN_PROGRESS: return JobStatus.IN_PROGRESS;
                    case COMPLETE: return JobStatus.COMPLETE;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            JobStatus value = null;
            if (tag != null) {
                switch (tag) {
                    case IN_PROGRESS: {
                        value = JobStatus.IN_PROGRESS;
                        break;
                    }
                    case COMPLETE: {
                        value = JobStatus.COMPLETE;
                        break;
                    }
                    case FAILED: {
                        JobError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JobError._JSON_READER
                            .readField(parser, "failed", v);
                        value = JobStatus.failed(v);
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
