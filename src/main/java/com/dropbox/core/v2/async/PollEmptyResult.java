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
 * Result returned by methods that poll for the status of an asynchronous job.
 * Upon completion of the job, no additional information is returned.
 */
public enum PollEmptyResult {
    // union PollEmptyResult
    /**
     * The asynchronous job is still in progress.
     */
    IN_PROGRESS,
    /**
     * The asynchronous job has completed successfully.
     */
    COMPLETE;

    private static final java.util.HashMap<String, PollEmptyResult> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, PollEmptyResult>();
        VALUES_.put("complete", COMPLETE);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static PollEmptyResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PollEmptyResult> _JSON_WRITER = new JsonWriter<PollEmptyResult>() {
        public void write(PollEmptyResult x, JsonGenerator g) throws IOException {
            switch (x) {
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
            }
        }
    };

    public static final JsonReader<PollEmptyResult> _JSON_READER = new JsonReader<PollEmptyResult>() {
        public final PollEmptyResult read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
