/* DO NOT EDIT */
/* This file was generated from async.babel */

package com.dropbox.core.v2.async;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Result returned by methods that may either launch an asynchronous job or
 * complete synchronously. Upon synchronous completion of the job, no additional
 * information is returned.
 */
public final class LaunchEmptyResult {
    // union LaunchEmptyResult

    /**
     * Discriminating tag type for {@link LaunchEmptyResult}.
     */
    public enum Tag {
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        ASYNC_JOB_ID, // String
        /**
         * The job finished synchronously and successfully.
         */
        COMPLETE;
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("complete", Tag.COMPLETE);
    }

    public static final LaunchEmptyResult COMPLETE = new LaunchEmptyResult(Tag.COMPLETE, null);

    private final Tag tag;
    private final String asyncJobIdValue;

    /**
     * Result returned by methods that may either launch an asynchronous job or
     * complete synchronously. Upon synchronous completion of the job, no
     * additional information is returned.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private LaunchEmptyResult(Tag tag, String asyncJobIdValue) {
        this.tag = tag;
        this.asyncJobIdValue = asyncJobIdValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code LaunchEmptyResult}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     */
    public boolean isAsyncJobId() {
        return this.tag == Tag.ASYNC_JOB_ID;
    }

    /**
     * Returns an instance of {@code LaunchEmptyResult} that has its tag set to
     * {@link Tag#ASYNC_JOB_ID}.
     *
     * <p> This response indicates that the processing is asynchronous. The
     * string is an id that can be used to obtain the status of the asynchronous
     * job. </p>
     *
     * @param value  {@link LaunchEmptyResult#asyncJobId} value to assign to
     *     this instance.
     *
     * @return Instance of {@code LaunchEmptyResult} with its tag set to {@link
     *     Tag#ASYNC_JOB_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static LaunchEmptyResult asyncJobId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new LaunchEmptyResult(Tag.ASYNC_JOB_ID, value);
    }

    /**
     * This response indicates that the processing is asynchronous. The string
     * is an id that can be used to obtain the status of the asynchronous job.
     *
     * <p> This instance must be tagged as {@link Tag#ASYNC_JOB_ID}. </p>
     *
     * @return The {@link LaunchEmptyResult#asyncJobId} value associated with
     *     this instance if {@link #isAsyncJobId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAsyncJobId} is {@code false}.
     */
    public String getAsyncJobIdValue() {
        if (this.tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + tag.name());
        }
        return asyncJobIdValue;
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

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            asyncJobIdValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof LaunchEmptyResult) {
            LaunchEmptyResult other = (LaunchEmptyResult) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ASYNC_JOB_ID:
                    return (this.asyncJobIdValue == other.asyncJobIdValue) || (this.asyncJobIdValue.equals(other.asyncJobIdValue));
                case COMPLETE:
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static LaunchEmptyResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<LaunchEmptyResult> _JSON_WRITER = new JsonWriter<LaunchEmptyResult>() {
        public final void write(LaunchEmptyResult x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ASYNC_JOB_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("async_job_id");
                    g.writeFieldName("async_job_id");
                    g.writeString(x.getAsyncJobIdValue());
                    g.writeEndObject();
                    break;
                case COMPLETE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("complete");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<LaunchEmptyResult> _JSON_READER = new JsonReader<LaunchEmptyResult>() {

        public final LaunchEmptyResult read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case COMPLETE: return LaunchEmptyResult.COMPLETE;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            LaunchEmptyResult value = null;
            if (tag != null) {
                switch (tag) {
                    case ASYNC_JOB_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "async_job_id", v);
                        value = LaunchEmptyResult.asyncJobId(v);
                        break;
                    }
                    case COMPLETE: {
                        value = LaunchEmptyResult.COMPLETE;
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
