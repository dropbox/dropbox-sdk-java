/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public final class MembersAddJobStatus {
    // union MembersAddJobStatus

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
         * DbxTeam#membersAdd(List)}, a corresponding item is returned in this
         * list.
         */
        COMPLETE, // List<MemberAddResult>
        /**
         * The asynchronous job returned an error. The string contains an error
         * message.
         */
        FAILED; // String
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("complete", Tag.COMPLETE);
        VALUES_.put("failed", Tag.FAILED);
    }

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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code MembersAddJobStatus}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this.tag == Tag.IN_PROGRESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#COMPLETE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#COMPLETE}, {@code false} otherwise.
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
     * DbxTeam#membersAdd(List)}, a corresponding item is returned in this list.
     * </p>
     *
     * @param value  {@link MembersAddJobStatus#complete} value to assign to
     *     this instance.
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
     * DbxTeam#membersAdd(List)}, a corresponding item is returned in this list.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#FAILED},
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
     * @param value  {@link MembersAddJobStatus#failed} value to assign to this
     *     instance.
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
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersAddJobStatus fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersAddJobStatus> _JSON_WRITER = new JsonWriter<MembersAddJobStatus>() {
        public final void write(MembersAddJobStatus x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case IN_PROGRESS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("in_progress");
                    g.writeEndObject();
                    break;
                case COMPLETE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("complete");
                    g.writeFieldName("complete");
                    g.writeStartArray();
                    for (MemberAddResult item: x.getCompleteValue()) {
                        if (item != null) {
                            MemberAddResult._JSON_WRITER.write(item, g);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
                case FAILED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("failed");
                    g.writeFieldName("failed");
                    g.writeString(x.getFailedValue());
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MembersAddJobStatus> _JSON_READER = new JsonReader<MembersAddJobStatus>() {

        public final MembersAddJobStatus read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case IN_PROGRESS: return MembersAddJobStatus.IN_PROGRESS;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            MembersAddJobStatus value = null;
            if (tag != null) {
                switch (tag) {
                    case IN_PROGRESS: {
                        value = MembersAddJobStatus.IN_PROGRESS;
                        break;
                    }
                    case COMPLETE: {
                        List<MemberAddResult> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(MemberAddResult._JSON_READER)
                            .readField(parser, "complete", v);
                        value = MembersAddJobStatus.complete(v);
                        break;
                    }
                    case FAILED: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "failed", v);
                        value = MembersAddJobStatus.failed(v);
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
