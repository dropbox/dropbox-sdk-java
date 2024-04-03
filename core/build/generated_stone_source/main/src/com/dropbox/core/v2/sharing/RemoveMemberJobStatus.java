/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

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

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class RemoveMemberJobStatus {
    // union sharing.RemoveMemberJobStatus (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link RemoveMemberJobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * Removing the folder member has finished. The value is information
         * about whether the member has another form of access.
         */
        COMPLETE, // MemberAccessLevelResult
        FAILED; // RemoveFolderMemberError
    }

    /**
     * The asynchronous job is still in progress.
     */
    public static final RemoveMemberJobStatus IN_PROGRESS = new RemoveMemberJobStatus().withTag(Tag.IN_PROGRESS);

    private Tag _tag;
    private MemberAccessLevelResult completeValue;
    private RemoveFolderMemberError failedValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RemoveMemberJobStatus() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RemoveMemberJobStatus withTag(Tag _tag) {
        RemoveMemberJobStatus result = new RemoveMemberJobStatus();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param completeValue  Removing the folder member has finished. The value
     *     is information about whether the member has another form of access.
     *     Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RemoveMemberJobStatus withTagAndComplete(Tag _tag, MemberAccessLevelResult completeValue) {
        RemoveMemberJobStatus result = new RemoveMemberJobStatus();
        result._tag = _tag;
        result.completeValue = completeValue;
        return result;
    }

    /**
     *
     * @param failedValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RemoveMemberJobStatus withTagAndFailed(Tag _tag, RemoveFolderMemberError failedValue) {
        RemoveMemberJobStatus result = new RemoveMemberJobStatus();
        result._tag = _tag;
        result.failedValue = failedValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RemoveMemberJobStatus}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
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
     * Returns an instance of {@code RemoveMemberJobStatus} that has its tag set
     * to {@link Tag#COMPLETE}.
     *
     * <p> Removing the folder member has finished. The value is information
     * about whether the member has another form of access. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RemoveMemberJobStatus} with its tag set to
     *     {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RemoveMemberJobStatus complete(MemberAccessLevelResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveMemberJobStatus().withTagAndComplete(Tag.COMPLETE, value);
    }

    /**
     * Removing the folder member has finished. The value is information about
     * whether the member has another form of access.
     *
     * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
     *
     * @return The {@link MemberAccessLevelResult} value associated with this
     *     instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public MemberAccessLevelResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
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
        return this._tag == Tag.FAILED;
    }

    /**
     * Returns an instance of {@code RemoveMemberJobStatus} that has its tag set
     * to {@link Tag#FAILED}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RemoveMemberJobStatus} with its tag set to
     *     {@link Tag#FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RemoveMemberJobStatus failed(RemoveFolderMemberError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveMemberJobStatus().withTagAndFailed(Tag.FAILED, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FAILED}.
     *
     * @return The {@link RemoveFolderMemberError} value associated with this
     *     instance if {@link #isFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
     */
    public RemoveFolderMemberError getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return failedValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.completeValue,
            this.failedValue
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
        else if (obj instanceof RemoveMemberJobStatus) {
            RemoveMemberJobStatus other = (RemoveMemberJobStatus) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
    static class Serializer extends UnionSerializer<RemoveMemberJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RemoveMemberJobStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case COMPLETE: {
                    g.writeStartObject();
                    writeTag("complete", g);
                    MemberAccessLevelResult.Serializer.INSTANCE.serialize(value.completeValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case FAILED: {
                    g.writeStartObject();
                    writeTag("failed", g);
                    g.writeFieldName("failed");
                    RemoveFolderMemberError.Serializer.INSTANCE.serialize(value.failedValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public RemoveMemberJobStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            RemoveMemberJobStatus value;
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
            else if ("in_progress".equals(tag)) {
                value = RemoveMemberJobStatus.IN_PROGRESS;
            }
            else if ("complete".equals(tag)) {
                MemberAccessLevelResult fieldValue = null;
                fieldValue = MemberAccessLevelResult.Serializer.INSTANCE.deserialize(p, true);
                value = RemoveMemberJobStatus.complete(fieldValue);
            }
            else if ("failed".equals(tag)) {
                RemoveFolderMemberError fieldValue = null;
                expectField("failed", p);
                fieldValue = RemoveFolderMemberError.Serializer.INSTANCE.deserialize(p);
                value = RemoveMemberJobStatus.failed(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
