/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

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

@JsonSerialize(using=GroupsPollError.Serializer.class)
@JsonDeserialize(using=GroupsPollError.Deserializer.class)
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

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupsPollError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupsPollError.class);
        }

        @Override
        public void serialize(GroupsPollError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case ACCESS_DENIED:
                    g.writeString("access_denied");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupsPollError, GroupsPollError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupsPollError.class, getTagMapping(), null);
        }

        @Override
        public GroupsPollError deserialize(GroupsPollError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupsPollError> getTagMapping() {
            Map<String, GroupsPollError> values = new HashMap<String, GroupsPollError>();
            values.put("access_denied", GroupsPollError.ACCESS_DENIED);
            return Collections.unmodifiableMap(values);
        }
    }
}
