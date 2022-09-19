/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class FileMemberRemoveActionResult {
    // union sharing.FileMemberRemoveActionResult (sharing_files.stone)

    /**
     * Discriminating tag type for {@link FileMemberRemoveActionResult}.
     */
    public enum Tag {
        /**
         * Member was successfully removed from this file.
         */
        SUCCESS, // MemberAccessLevelResult
        /**
         * User was not able to remove this member.
         */
        MEMBER_ERROR, // FileMemberActionError
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
    public static final FileMemberRemoveActionResult OTHER = new FileMemberRemoveActionResult().withTag(Tag.OTHER);

    private Tag _tag;
    private MemberAccessLevelResult successValue;
    private FileMemberActionError memberErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private FileMemberRemoveActionResult() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private FileMemberRemoveActionResult withTag(Tag _tag) {
        FileMemberRemoveActionResult result = new FileMemberRemoveActionResult();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param successValue  Member was successfully removed from this file. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FileMemberRemoveActionResult withTagAndSuccess(Tag _tag, MemberAccessLevelResult successValue) {
        FileMemberRemoveActionResult result = new FileMemberRemoveActionResult();
        result._tag = _tag;
        result.successValue = successValue;
        return result;
    }

    /**
     *
     * @param memberErrorValue  User was not able to remove this member. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FileMemberRemoveActionResult withTagAndMemberError(Tag _tag, FileMemberActionError memberErrorValue) {
        FileMemberRemoveActionResult result = new FileMemberRemoveActionResult();
        result._tag = _tag;
        result.memberErrorValue = memberErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code FileMemberRemoveActionResult}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#SUCCESS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#SUCCESS},
     *     {@code false} otherwise.
     */
    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    /**
     * Returns an instance of {@code FileMemberRemoveActionResult} that has its
     * tag set to {@link Tag#SUCCESS}.
     *
     * <p> Member was successfully removed from this file. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FileMemberRemoveActionResult} with its tag set
     *     to {@link Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FileMemberRemoveActionResult success(MemberAccessLevelResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberRemoveActionResult().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * Member was successfully removed from this file.
     *
     * <p> This instance must be tagged as {@link Tag#SUCCESS}. </p>
     *
     * @return The {@link MemberAccessLevelResult} value associated with this
     *     instance if {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public MemberAccessLevelResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return successValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MEMBER_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MEMBER_ERROR}, {@code false} otherwise.
     */
    public boolean isMemberError() {
        return this._tag == Tag.MEMBER_ERROR;
    }

    /**
     * Returns an instance of {@code FileMemberRemoveActionResult} that has its
     * tag set to {@link Tag#MEMBER_ERROR}.
     *
     * <p> User was not able to remove this member. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FileMemberRemoveActionResult} with its tag set
     *     to {@link Tag#MEMBER_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FileMemberRemoveActionResult memberError(FileMemberActionError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberRemoveActionResult().withTagAndMemberError(Tag.MEMBER_ERROR, value);
    }

    /**
     * User was not able to remove this member.
     *
     * <p> This instance must be tagged as {@link Tag#MEMBER_ERROR}. </p>
     *
     * @return The {@link FileMemberActionError} value associated with this
     *     instance if {@link #isMemberError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMemberError} is {@code
     *     false}.
     */
    public FileMemberActionError getMemberErrorValue() {
        if (this._tag != Tag.MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_ERROR, but was Tag." + this._tag.name());
        }
        return memberErrorValue;
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
            _tag,
            successValue,
            memberErrorValue
        });
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
        else if (obj instanceof FileMemberRemoveActionResult) {
            FileMemberRemoveActionResult other = (FileMemberRemoveActionResult) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case MEMBER_ERROR:
                    return (this.memberErrorValue == other.memberErrorValue) || (this.memberErrorValue.equals(other.memberErrorValue));
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
    static class Serializer extends UnionSerializer<FileMemberRemoveActionResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileMemberRemoveActionResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    MemberAccessLevelResult.Serializer.INSTANCE.serialize(value.successValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case MEMBER_ERROR: {
                    g.writeStartObject();
                    writeTag("member_error", g);
                    g.writeFieldName("member_error");
                    FileMemberActionError.Serializer.INSTANCE.serialize(value.memberErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileMemberRemoveActionResult deserialize(JsonParser p) throws IOException, JsonParseException {
            FileMemberRemoveActionResult value;
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
            else if ("success".equals(tag)) {
                MemberAccessLevelResult fieldValue = null;
                fieldValue = MemberAccessLevelResult.Serializer.INSTANCE.deserialize(p, true);
                value = FileMemberRemoveActionResult.success(fieldValue);
            }
            else if ("member_error".equals(tag)) {
                FileMemberActionError fieldValue = null;
                expectField("member_error", p);
                fieldValue = FileMemberActionError.Serializer.INSTANCE.deserialize(p);
                value = FileMemberRemoveActionResult.memberError(fieldValue);
            }
            else {
                value = FileMemberRemoveActionResult.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
