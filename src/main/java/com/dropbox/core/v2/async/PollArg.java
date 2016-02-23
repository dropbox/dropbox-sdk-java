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
 * Arguments for methods that poll the status of an asynchronous job.
 */
public class PollArg {
    // struct PollArg

    private final String asyncJobId;

    /**
     * Arguments for methods that poll the status of an asynchronous job.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PollArg(String asyncJobId) {
        if (asyncJobId == null) {
            throw new IllegalArgumentException("Required value for 'asyncJobId' is null");
        }
        if (asyncJobId.length() < 1) {
            throw new IllegalArgumentException("String 'asyncJobId' is shorter than 1");
        }
        this.asyncJobId = asyncJobId;
    }

    /**
     * Id of the asynchronous job. This is the value of a response returned from
     * the method that launched the job.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAsyncJobId() {
        return asyncJobId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            asyncJobId
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            PollArg other = (PollArg) obj;
            return (this.asyncJobId == other.asyncJobId) || (this.asyncJobId.equals(other.asyncJobId));
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

    public static PollArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PollArg> _JSON_WRITER = new JsonWriter<PollArg>() {
        public final void write(PollArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            PollArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(PollArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("async_job_id");
            g.writeString(x.asyncJobId);
        }
    };

    public static final JsonReader<PollArg> _JSON_READER = new JsonReader<PollArg>() {
        public final PollArg read(JsonParser parser) throws IOException, JsonReadException {
            PollArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final PollArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String asyncJobId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("async_job_id".equals(fieldName)) {
                    asyncJobId = JsonReader.StringReader
                        .readField(parser, "async_job_id", asyncJobId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (asyncJobId == null) {
                throw new JsonReadException("Required field \"async_job_id\" is missing.", parser.getTokenLocation());
            }
            return new PollArg(asyncJobId);
        }
    };
}
