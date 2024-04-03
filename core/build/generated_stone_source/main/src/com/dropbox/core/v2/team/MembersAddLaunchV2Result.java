/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class MembersAddLaunchV2Result {
    // union team.MembersAddLaunchV2Result (team_members.stone)

    /**
     * Discriminating tag type for {@link MembersAddLaunchV2Result}.
     */
    public enum Tag {
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        ASYNC_JOB_ID, // String
        COMPLETE, // List<MemberAddV2Result>
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final MembersAddLaunchV2Result OTHER = new MembersAddLaunchV2Result().withTag(Tag.OTHER);

    private Tag _tag;
    private String asyncJobIdValue;
    private List<MemberAddV2Result> completeValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private MembersAddLaunchV2Result() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private MembersAddLaunchV2Result withTag(Tag _tag) {
        MembersAddLaunchV2Result result = new MembersAddLaunchV2Result();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param asyncJobIdValue  This response indicates that the processing is
     *     asynchronous. The string is an id that can be used to obtain the
     *     status of the asynchronous job. Must have length of at least 1 and
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MembersAddLaunchV2Result withTagAndAsyncJobId(Tag _tag, String asyncJobIdValue) {
        MembersAddLaunchV2Result result = new MembersAddLaunchV2Result();
        result._tag = _tag;
        result.asyncJobIdValue = asyncJobIdValue;
        return result;
    }

    /**
     *
     * @param completeValue  Must not contain a {@code null} item and not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MembersAddLaunchV2Result withTagAndComplete(Tag _tag, List<MemberAddV2Result> completeValue) {
        MembersAddLaunchV2Result result = new MembersAddLaunchV2Result();
        result._tag = _tag;
        result.completeValue = completeValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MembersAddLaunchV2Result}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ASYNC_JOB_ID}, {@code false} otherwise.
     */
    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    /**
     * Returns an instance of {@code MembersAddLaunchV2Result} that has its tag
     * set to {@link Tag#ASYNC_JOB_ID}.
     *
     * <p> This response indicates that the processing is asynchronous. The
     * string is an id that can be used to obtain the status of the asynchronous
     * job. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersAddLaunchV2Result} with its tag set to
     *     {@link Tag#ASYNC_JOB_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static MembersAddLaunchV2Result asyncJobId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new MembersAddLaunchV2Result().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, value);
    }

    /**
     * This response indicates that the processing is asynchronous. The string
     * is an id that can be used to obtain the status of the asynchronous job.
     *
     * <p> This instance must be tagged as {@link Tag#ASYNC_JOB_ID}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isAsyncJobId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAsyncJobId} is {@code false}.
     */
    public String getAsyncJobIdValue() {
        if (this._tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + this._tag.name());
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
        return this._tag == Tag.COMPLETE;
    }

    /**
     * Returns an instance of {@code MembersAddLaunchV2Result} that has its tag
     * set to {@link Tag#COMPLETE}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersAddLaunchV2Result} with its tag set to
     *     {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static MembersAddLaunchV2Result complete(List<MemberAddV2Result> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (MemberAddV2Result x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new MembersAddLaunchV2Result().withTagAndComplete(Tag.COMPLETE, value);
    }

    /**
     * This instance must be tagged as {@link Tag#COMPLETE}.
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public List<MemberAddV2Result> getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return completeValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.asyncJobIdValue,
            this.completeValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        else if (obj instanceof MembersAddLaunchV2Result) {
            MembersAddLaunchV2Result other = (MembersAddLaunchV2Result) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ASYNC_JOB_ID:
                    return (this.asyncJobIdValue == other.asyncJobIdValue) || (this.asyncJobIdValue.equals(other.asyncJobIdValue));
                case COMPLETE:
                    return (this.completeValue == other.completeValue) || (this.completeValue.equals(other.completeValue));
                case OTHER:
                    return true;
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
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<MembersAddLaunchV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersAddLaunchV2Result value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ASYNC_JOB_ID: {
                    g.writeStartObject();
                    writeTag("async_job_id", g);
                    g.writeFieldName("async_job_id");
                    StoneSerializers.string().serialize(value.asyncJobIdValue, g);
                    g.writeEndObject();
                    break;
                }
                case COMPLETE: {
                    g.writeStartObject();
                    writeTag("complete", g);
                    g.writeFieldName("complete");
                    StoneSerializers.list(MemberAddV2Result.Serializer.INSTANCE).serialize(value.completeValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MembersAddLaunchV2Result deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersAddLaunchV2Result value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("async_job_id".equals(tag)) {
                String fieldValue = null;
                expectField("async_job_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = MembersAddLaunchV2Result.asyncJobId(fieldValue);
            }
            else if ("complete".equals(tag)) {
                List<MemberAddV2Result> fieldValue = null;
                expectField("complete", p);
                fieldValue = StoneSerializers.list(MemberAddV2Result.Serializer.INSTANCE).deserialize(p);
                value = MembersAddLaunchV2Result.complete(fieldValue);
            }
            else {
                value = MembersAddLaunchV2Result.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
