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
 * Result returned by methods that launch an asynchronous job. A method who may
 * either launch an asynchronous job, or complete the request synchronously, can
 * use this union by extending it, and adding a 'complete' field with the type
 * of the synchronous response. See {@link LaunchEmptyResult} for an example.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=LaunchResultBase.Serializer.class)
@JsonDeserialize(using=LaunchResultBase.Deserializer.class)
public final class LaunchResultBase {
    // union LaunchResultBase

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link LaunchResultBase}.
     */
    public enum Tag {
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        ASYNC_JOB_ID; // String
    }

    private final Tag tag;
    private final String asyncJobIdValue;

    /**
     * Result returned by methods that launch an asynchronous job. A method who
     * may either launch an asynchronous job, or complete the request
     * synchronously, can use this union by extending it, and adding a
     * 'complete' field with the type of the synchronous response. See {@link
     * LaunchEmptyResult} for an example.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private LaunchResultBase(Tag tag, String asyncJobIdValue) {
        this.tag = tag;
        this.asyncJobIdValue = asyncJobIdValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code LaunchResultBase}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     */
    public boolean isAsyncJobId() {
        return this.tag == Tag.ASYNC_JOB_ID;
    }

    /**
     * Returns an instance of {@code LaunchResultBase} that has its tag set to
     * {@link Tag#ASYNC_JOB_ID}.
     *
     * <p> This response indicates that the processing is asynchronous. The
     * string is an id that can be used to obtain the status of the asynchronous
     * job. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LaunchResultBase} with its tag set to {@link
     *     Tag#ASYNC_JOB_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static LaunchResultBase asyncJobId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new LaunchResultBase(Tag.ASYNC_JOB_ID, value);
    }

    /**
     * This response indicates that the processing is asynchronous. The string
     * is an id that can be used to obtain the status of the asynchronous job.
     *
     * <p> This instance must be tagged as {@link Tag#ASYNC_JOB_ID}. </p>
     *
     * @return The {@link LaunchResultBase#asyncJobId} value associated with
     *     this instance if {@link #isAsyncJobId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAsyncJobId} is {@code false}.
     */
    public String getAsyncJobIdValue() {
        if (this.tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + tag.name());
        }
        return asyncJobIdValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            asyncJobIdValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof LaunchResultBase) {
            LaunchResultBase other = (LaunchResultBase) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ASYNC_JOB_ID:
                    return (this.asyncJobIdValue == other.asyncJobIdValue) || (this.asyncJobIdValue.equals(other.asyncJobIdValue));
                default:
                    return false;
            }
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

    static final class Serializer extends UnionJsonSerializer<LaunchResultBase> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(LaunchResultBase.class);
        }

        @Override
        public void serialize(LaunchResultBase value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ASYNC_JOB_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "async_job_id");
                    g.writeObjectField("async_job_id", value.asyncJobIdValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<LaunchResultBase, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(LaunchResultBase.class, getTagMapping(), null);
        }

        @Override
        public LaunchResultBase deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ASYNC_JOB_ID: {
                    String value = null;
                    expectField(_p, "async_job_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return LaunchResultBase.asyncJobId(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, LaunchResultBase.Tag> getTagMapping() {
            Map<String, LaunchResultBase.Tag> values = new HashMap<String, LaunchResultBase.Tag>();
            values.put("async_job_id", LaunchResultBase.Tag.ASYNC_JOB_ID);
            return Collections.unmodifiableMap(values);
        }
    }
}
