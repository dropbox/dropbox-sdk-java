/* DO NOT EDIT */
/* This file was generated from async.babel */

package com.dropbox.core.v2.async;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Arguments for methods that poll the status of an asynchronous job.
 */
@JsonSerialize(using=PollArg.Serializer.class)
@JsonDeserialize(using=PollArg.Deserializer.class)
public class PollArg {
    // struct PollArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String asyncJobId;

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
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<PollArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PollArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(PollArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<PollArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(PollArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("async_job_id", value.asyncJobId);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<PollArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PollArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(PollArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<PollArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public PollArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String asyncJobId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("async_job_id".equals(_field)) {
                    asyncJobId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (asyncJobId == null) {
                throw new JsonParseException(_p, "Required field \"async_job_id\" is missing.");
            }

            return new PollArg(asyncJobId);
        }
    }
}
