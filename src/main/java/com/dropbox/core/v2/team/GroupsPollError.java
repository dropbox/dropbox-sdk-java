/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum GroupsPollError {
    // union GroupsPollError
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
    OTHER,
    /**
     * You are not allowed to poll this job.
     */
    ACCESS_DENIED;

    private static final java.util.HashMap<String, GroupsPollError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupsPollError>();
        VALUES_.put("access_denied", ACCESS_DENIED);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupsPollError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupsPollError> _JSON_WRITER = new JsonWriter<GroupsPollError>() {
        public void write(GroupsPollError x, JsonGenerator g) throws IOException {
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
                case ACCESS_DENIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_denied");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupsPollError> _JSON_READER = new JsonReader<GroupsPollError>() {
        public final GroupsPollError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
