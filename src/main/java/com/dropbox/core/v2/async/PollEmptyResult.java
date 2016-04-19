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
 * Result returned by methods that poll for the status of an asynchronous job.
 * Upon completion of the job, no additional information is returned.
 */
@JsonSerialize(using=PollEmptyResult.Serializer.class)
@JsonDeserialize(using=PollEmptyResult.Deserializer.class)
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

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<PollEmptyResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PollEmptyResult.class);
        }

        @Override
        public void serialize(PollEmptyResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case IN_PROGRESS:
                    g.writeString("in_progress");
                    break;
                case COMPLETE:
                    g.writeString("complete");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PollEmptyResult, PollEmptyResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PollEmptyResult.class, getTagMapping(), null);
        }

        @Override
        public PollEmptyResult deserialize(PollEmptyResult _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, PollEmptyResult> getTagMapping() {
            Map<String, PollEmptyResult> values = new HashMap<String, PollEmptyResult>();
            values.put("complete", PollEmptyResult.COMPLETE);
            return Collections.unmodifiableMap(values);
        }
    }
}
