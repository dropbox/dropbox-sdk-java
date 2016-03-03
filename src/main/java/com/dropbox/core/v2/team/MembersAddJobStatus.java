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
@JsonSerialize(using=MembersAddJobStatus.Serializer.class)
@JsonDeserialize(using=MembersAddJobStatus.Deserializer.class)
public final class MembersAddJobStatus {
    // union MembersAddJobStatus

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link MembersAddJobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * The asynchronous job has finished. For each member that was specified
         * in the parameter {@link MembersAddArg} that was provided to {@link
         * DbxTeamTeamRequests#membersAdd(List)}, a corresponding item is
         * returned in this list.
         */
        COMPLETE, // List<MemberAddResult>
        /**
         * The asynchronous job returned an error. The string contains an error
         * message.
         */
        FAILED; // String
    }

    /**
     * The asynchronous job is still in progress.
     */
    public static final MembersAddJobStatus IN_PROGRESS = new MembersAddJobStatus(Tag.IN_PROGRESS, null, null);

    private final Tag tag;
    private final List<MemberAddResult> completeValue;
    private final String failedValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MembersAddJobStatus(Tag tag, List<MemberAddResult> completeValue, String failedValue) {
        this.tag = tag;
        this.completeValue = completeValue;
        this.failedValue = failedValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MembersAddJobStatus}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this.tag == Tag.IN_PROGRESS;
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
     * Returns an instance of {@code MembersAddJobStatus} that has its tag set
     * to {@link Tag#COMPLETE}.
     *
     * <p> The asynchronous job has finished. For each member that was specified
     * in the parameter {@link MembersAddArg} that was provided to {@link
     * DbxTeamTeamRequests#membersAdd(List)}, a corresponding item is returned
     * in this list. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersAddJobStatus} with its tag set to
     *     {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static MembersAddJobStatus complete(List<MemberAddResult> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (MemberAddResult x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new MembersAddJobStatus(Tag.COMPLETE, value, null);
    }

    /**
     * The asynchronous job has finished. For each member that was specified in
     * the parameter {@link MembersAddArg} that was provided to {@link
     * DbxTeamTeamRequests#membersAdd(List)}, a corresponding item is returned
     * in this list.
     *
     * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
     *
     * @return The {@link MembersAddJobStatus#complete} value associated with
     *     this instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public List<MemberAddResult> getCompleteValue() {
        if (this.tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + tag.name());
        }
        return completeValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FAILED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#FAILED},
     *     {@code false} otherwise.
     */
    public boolean isFailed() {
        return this.tag == Tag.FAILED;
    }

    /**
     * Returns an instance of {@code MembersAddJobStatus} that has its tag set
     * to {@link Tag#FAILED}.
     *
     * <p> The asynchronous job returned an error. The string contains an error
     * message. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersAddJobStatus} with its tag set to
     *     {@link Tag#FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MembersAddJobStatus failed(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersAddJobStatus(Tag.FAILED, null, value);
    }

    /**
     * The asynchronous job returned an error. The string contains an error
     * message.
     *
     * <p> This instance must be tagged as {@link Tag#FAILED}. </p>
     *
     * @return The {@link MembersAddJobStatus#failed} value associated with this
     *     instance if {@link #isFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
     */
    public String getFailedValue() {
        if (this.tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + tag.name());
        }
        return failedValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            completeValue,
            failedValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof MembersAddJobStatus) {
            MembersAddJobStatus other = (MembersAddJobStatus) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case IN_PROGRESS:
                    return true;
                case COMPLETE:
                    return (this.completeValue == other.completeValue) || (this.completeValue.equals(other.completeValue));
                case FAILED:
                    return (this.failedValue == other.failedValue) || (this.failedValue.equals(other.failedValue));
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

    static final class Serializer extends UnionJsonSerializer<MembersAddJobStatus> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersAddJobStatus.class);
        }

        @Override
        public void serialize(MembersAddJobStatus value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case IN_PROGRESS:
                    g.writeString("in_progress");
                    break;
                case COMPLETE:
                    g.writeStartObject();
                    g.writeStringField(".tag", "complete");
                    g.writeObjectField("complete", value.completeValue);
                    g.writeEndObject();
                    break;
                case FAILED:
                    g.writeStartObject();
                    g.writeStringField(".tag", "failed");
                    g.writeObjectField("failed", value.failedValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersAddJobStatus, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersAddJobStatus.class, getTagMapping(), null);
        }

        @Override
        public MembersAddJobStatus deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case IN_PROGRESS: {
                    return MembersAddJobStatus.IN_PROGRESS;
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
                    return MembersAddJobStatus.complete(value);
                }
                case FAILED: {
                    String value = null;
                    expectField(_p, "failed");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MembersAddJobStatus.failed(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, MembersAddJobStatus.Tag> getTagMapping() {
            Map<String, MembersAddJobStatus.Tag> values = new HashMap<String, MembersAddJobStatus.Tag>();
            values.put("complete", MembersAddJobStatus.Tag.COMPLETE);
            values.put("failed", MembersAddJobStatus.Tag.FAILED);
            return Collections.unmodifiableMap(values);
        }
    }
}
