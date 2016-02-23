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
 * Unions that extend this union should add a 'complete' field with a type of
 * the information returned upon job completion. See {@link PollEmptyResult} for
 * an example.
 */
public enum PollResultBase {
    // union PollResultBase
    /**
     * The asynchronous job is still in progress.
     */
    IN_PROGRESS;

    private static final java.util.HashMap<String, PollResultBase> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, PollResultBase>();
        VALUES_.put("in_progress", IN_PROGRESS);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static PollResultBase fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PollResultBase> _JSON_WRITER = new JsonWriter<PollResultBase>() {
        public void write(PollResultBase x, JsonGenerator g) throws IOException {
            switch (x) {
                case IN_PROGRESS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("in_progress");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<PollResultBase> _JSON_READER = new JsonReader<PollResultBase>() {
        public final PollResultBase read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
