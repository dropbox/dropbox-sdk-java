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
 * Unions that extend this union should add a 'complete' field with a type of
 * the information returned upon job completion. See {@link PollEmptyResult} for
 * an example.
 */
@JsonSerialize(using=PollResultBase.Serializer.class)
@JsonDeserialize(using=PollResultBase.Deserializer.class)
public enum PollResultBase {
    // union PollResultBase
    /**
     * The asynchronous job is still in progress.
     */
    IN_PROGRESS;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<PollResultBase> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PollResultBase.class);
        }

        @Override
        public void serialize(PollResultBase value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case IN_PROGRESS:
                    g.writeString("in_progress");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PollResultBase, PollResultBase> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PollResultBase.class, getTagMapping(), null);
        }

        @Override
        public PollResultBase deserialize(PollResultBase _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, PollResultBase> getTagMapping() {
            Map<String, PollResultBase> values = new HashMap<String, PollResultBase>();
            values.put("in_progress", PollResultBase.IN_PROGRESS);
            return Collections.unmodifiableMap(values);
        }
    }
}
