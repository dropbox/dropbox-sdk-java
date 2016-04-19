/* DO NOT EDIT */
/* This file was generated from async.babel */

package com.dropbox.core.v2.async;

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
 * Error returned by methods for polling the status of asynchronous job.
 */
@JsonSerialize(using=PollError.Serializer.class)
@JsonDeserialize(using=PollError.Deserializer.class)
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

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<PollError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PollError.class);
        }

        @Override
        public void serialize(PollError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case INVALID_ASYNC_JOB_ID:
                    g.writeString("invalid_async_job_id");
                    break;
                case INTERNAL_ERROR:
                    g.writeString("internal_error");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PollError, PollError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PollError.class, getTagMapping(), PollError.OTHER);
        }

        @Override
        public PollError deserialize(PollError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, PollError> getTagMapping() {
            Map<String, PollError> values = new HashMap<String, PollError>();
            values.put("invalid_async_job_id", PollError.INVALID_ASYNC_JOB_ID);
            values.put("internal_error", PollError.INTERNAL_ERROR);
            values.put("other", PollError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
