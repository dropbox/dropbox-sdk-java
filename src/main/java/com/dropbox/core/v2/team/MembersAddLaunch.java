/* DO NOT EDIT */
/* This file was generated from team_members.babel */

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
import java.util.List;
import java.util.Map;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
@JsonSerialize(using=MembersAddLaunch.Serializer.class)
@JsonDeserialize(using=MembersAddLaunch.Deserializer.class)
public final class MembersAddLaunch {
    // union MembersAddLaunch

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link MembersAddLaunch}.
     */
    public enum Tag {
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        ASYNC_JOB_ID, // String
        COMPLETE; // List<MemberAddResult>
    }

    private final Tag tag;
    private final String asyncJobIdValue;
    private final List<MemberAddResult> completeValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MembersAddLaunch(Tag tag, String asyncJobIdValue, List<MemberAddResult> completeValue) {
        this.tag = tag;
        this.asyncJobIdValue = asyncJobIdValue;
        this.completeValue = completeValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MembersAddLaunch}. </p>
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
     * Returns an instance of {@code MembersAddLaunch} that has its tag set to
     * {@link Tag#ASYNC_JOB_ID}.
     *
     * <p> This response indicates that the processing is asynchronous. The
     * string is an id that can be used to obtain the status of the asynchronous
     * job. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersAddLaunch} with its tag set to {@link
     *     Tag#ASYNC_JOB_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static MembersAddLaunch asyncJobId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new MembersAddLaunch(Tag.ASYNC_JOB_ID, value, null);
    }

    /**
     * This response indicates that the processing is asynchronous. The string
     * is an id that can be used to obtain the status of the asynchronous job.
     *
     * <p> This instance must be tagged as {@link Tag#ASYNC_JOB_ID}. </p>
     *
     * @return The {@link MembersAddLaunch#asyncJobId} value associated with
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

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#COMPLETE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#COMPLETE},
     *     {@code false} otherwise.
     */
    public boolean isComplete() {
        return this.tag == Tag.COMPLETE;
    }

    /**
     * Returns an instance of {@code MembersAddLaunch} that has its tag set to
     * {@link Tag#COMPLETE}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersAddLaunch} with its tag set to {@link
     *     Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static MembersAddLaunch complete(List<MemberAddResult> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (MemberAddResult x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new MembersAddLaunch(Tag.COMPLETE, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#COMPLETE}.
     *
     * @return The {@link MembersAddLaunch#complete} value associated with this
     *     instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public List<MemberAddResult> getCompleteValue() {
        if (this.tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + tag.name());
        }
        return completeValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            asyncJobIdValue,
            completeValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof MembersAddLaunch) {
            MembersAddLaunch other = (MembersAddLaunch) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ASYNC_JOB_ID:
                    return (this.asyncJobIdValue == other.asyncJobIdValue) || (this.asyncJobIdValue.equals(other.asyncJobIdValue));
                case COMPLETE:
                    return (this.completeValue == other.completeValue) || (this.completeValue.equals(other.completeValue));
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

    static final class Serializer extends UnionJsonSerializer<MembersAddLaunch> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersAddLaunch.class);
        }

        @Override
        public void serialize(MembersAddLaunch value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ASYNC_JOB_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "async_job_id");
                    g.writeObjectField("async_job_id", value.asyncJobIdValue);
                    g.writeEndObject();
                    break;
                case COMPLETE:
                    g.writeStartObject();
                    g.writeStringField(".tag", "complete");
                    g.writeObjectField("complete", value.completeValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersAddLaunch, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersAddLaunch.class, getTagMapping(), null);
        }

        @Override
        public MembersAddLaunch deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ASYNC_JOB_ID: {
                    String value = null;
                    expectField(_p, "async_job_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MembersAddLaunch.asyncJobId(value);
                }
                case COMPLETE: {
                    List<MemberAddResult> value = null;
                    expectField(_p, "complete");
                    expectArrayStart(_p);
                    value = new java.util.ArrayList<MemberAddResult>();
                    while (!isArrayEnd(_p)) {
                        MemberAddResult _x = null;
                        _x = _p.readValueAs(MemberAddResult.class);
                        _p.nextToken();
                        value.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                    return MembersAddLaunch.complete(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, MembersAddLaunch.Tag> getTagMapping() {
            Map<String, MembersAddLaunch.Tag> values = new HashMap<String, MembersAddLaunch.Tag>();
            values.put("complete", MembersAddLaunch.Tag.COMPLETE);
            return Collections.unmodifiableMap(values);
        }
    }
}
