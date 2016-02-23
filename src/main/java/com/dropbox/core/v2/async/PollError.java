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
 * Error returned by methods for polling the status of asynchronous job.
 */
public enum PollError {
    // union PollError
    /**
     * The job ID is invalid.
     */
    INVALID_ASYNC_JOB_ID,
    /**
     * Something went wrong with the job on Dropbox's end. You'll need to verify
     * that the action you were taking succeeded, and if not, try again. This
     * should happen very rarely.
     */
    INTERNAL_ERROR,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, PollError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, PollError>();
        VALUES_.put("invalid_async_job_id", INVALID_ASYNC_JOB_ID);
        VALUES_.put("internal_error", INTERNAL_ERROR);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static PollError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PollError> _JSON_WRITER = new JsonWriter<PollError>() {
        public void write(PollError x, JsonGenerator g) throws IOException {
            switch (x) {
                case INVALID_ASYNC_JOB_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_async_job_id");
                    g.writeEndObject();
                    break;
                case INTERNAL_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("internal_error");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<PollError> _JSON_READER = new JsonReader<PollError>() {
        public final PollError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
