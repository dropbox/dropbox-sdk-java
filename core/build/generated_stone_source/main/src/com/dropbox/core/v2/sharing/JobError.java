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
 * Error occurred while performing an asynchronous job from {@link
 * DbxUserSharingRequests#unshareFolder(String,boolean)} or {@link
 * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class JobError {
    // union sharing.JobError (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link JobError}.
     */
    public enum Tag {
        /**
         * Error occurred while performing {@link
         * DbxUserSharingRequests#unshareFolder(String,boolean)} action.
         */
        UNSHARE_FOLDER_ERROR, // UnshareFolderError
        /**
         * Error occurred while performing {@link
         * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}
         * action.
         */
        REMOVE_FOLDER_MEMBER_ERROR, // RemoveFolderMemberError
        /**
         * Error occurred while performing {@link
         * DbxUserSharingRequests#relinquishFolderMembership(String,boolean)}
         * action.
         */
        RELINQUISH_FOLDER_MEMBERSHIP_ERROR, // RelinquishFolderMembershipError
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
    public static final JobError OTHER = new JobError().withTag(Tag.OTHER);

    private Tag _tag;
    private UnshareFolderError unshareFolderErrorValue;
    private RemoveFolderMemberError removeFolderMemberErrorValue;
    private RelinquishFolderMembershipError relinquishFolderMembershipErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private JobError() {
    }


    /**
     * Error occurred while performing an asynchronous job from {@link
     * DbxUserSharingRequests#unshareFolder(String,boolean)} or {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private JobError withTag(Tag _tag) {
        JobError result = new JobError();
        result._tag = _tag;
        return result;
    }

    /**
     * Error occurred while performing an asynchronous job from {@link
     * DbxUserSharingRequests#unshareFolder(String,boolean)} or {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}.
     *
     * @param unshareFolderErrorValue  Error occurred while performing {@link
     *     DbxUserSharingRequests#unshareFolder(String,boolean)} action. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private JobError withTagAndUnshareFolderError(Tag _tag, UnshareFolderError unshareFolderErrorValue) {
        JobError result = new JobError();
        result._tag = _tag;
        result.unshareFolderErrorValue = unshareFolderErrorValue;
        return result;
    }

    /**
     * Error occurred while performing an asynchronous job from {@link
     * DbxUserSharingRequests#unshareFolder(String,boolean)} or {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}.
     *
     * @param removeFolderMemberErrorValue  Error occurred while performing
     *     {@link
     *     DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}
     *     action. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private JobError withTagAndRemoveFolderMemberError(Tag _tag, RemoveFolderMemberError removeFolderMemberErrorValue) {
        JobError result = new JobError();
        result._tag = _tag;
        result.removeFolderMemberErrorValue = removeFolderMemberErrorValue;
        return result;
    }

    /**
     * Error occurred while performing an asynchronous job from {@link
     * DbxUserSharingRequests#unshareFolder(String,boolean)} or {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}.
     *
     * @param relinquishFolderMembershipErrorValue  Error occurred while
     *     performing {@link
     *     DbxUserSharingRequests#relinquishFolderMembership(String,boolean)}
     *     action. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private JobError withTagAndRelinquishFolderMembershipError(Tag _tag, RelinquishFolderMembershipError relinquishFolderMembershipErrorValue) {
        JobError result = new JobError();
        result._tag = _tag;
        result.relinquishFolderMembershipErrorValue = relinquishFolderMembershipErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code JobError}. </p>
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
     * Tag#UNSHARE_FOLDER_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSHARE_FOLDER_ERROR}, {@code false} otherwise.
     */
    public boolean isUnshareFolderError() {
        return this._tag == Tag.UNSHARE_FOLDER_ERROR;
    }

    /**
     * Returns an instance of {@code JobError} that has its tag set to {@link
     * Tag#UNSHARE_FOLDER_ERROR}.
     *
     * <p> Error occurred while performing {@link
     * DbxUserSharingRequests#unshareFolder(String,boolean)} action. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code JobError} with its tag set to {@link
     *     Tag#UNSHARE_FOLDER_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static JobError unshareFolderError(UnshareFolderError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobError().withTagAndUnshareFolderError(Tag.UNSHARE_FOLDER_ERROR, value);
    }

    /**
     * Error occurred while performing {@link
     * DbxUserSharingRequests#unshareFolder(String,boolean)} action.
     *
     * <p> This instance must be tagged as {@link Tag#UNSHARE_FOLDER_ERROR}.
     * </p>
     *
     * @return The {@link UnshareFolderError} value associated with this
     *     instance if {@link #isUnshareFolderError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUnshareFolderError} is {@code
     *     false}.
     */
    public UnshareFolderError getUnshareFolderErrorValue() {
        if (this._tag != Tag.UNSHARE_FOLDER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.UNSHARE_FOLDER_ERROR, but was Tag." + this._tag.name());
        }
        return unshareFolderErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#REMOVE_FOLDER_MEMBER_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#REMOVE_FOLDER_MEMBER_ERROR}, {@code false} otherwise.
     */
    public boolean isRemoveFolderMemberError() {
        return this._tag == Tag.REMOVE_FOLDER_MEMBER_ERROR;
    }

    /**
     * Returns an instance of {@code JobError} that has its tag set to {@link
     * Tag#REMOVE_FOLDER_MEMBER_ERROR}.
     *
     * <p> Error occurred while performing {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}
     * action. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code JobError} with its tag set to {@link
     *     Tag#REMOVE_FOLDER_MEMBER_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static JobError removeFolderMemberError(RemoveFolderMemberError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobError().withTagAndRemoveFolderMemberError(Tag.REMOVE_FOLDER_MEMBER_ERROR, value);
    }

    /**
     * Error occurred while performing {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}
     * action.
     *
     * <p> This instance must be tagged as {@link
     * Tag#REMOVE_FOLDER_MEMBER_ERROR}. </p>
     *
     * @return The {@link RemoveFolderMemberError} value associated with this
     *     instance if {@link #isRemoveFolderMemberError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isRemoveFolderMemberError} is
     *     {@code false}.
     */
    public RemoveFolderMemberError getRemoveFolderMemberErrorValue() {
        if (this._tag != Tag.REMOVE_FOLDER_MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.REMOVE_FOLDER_MEMBER_ERROR, but was Tag." + this._tag.name());
        }
        return removeFolderMemberErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#RELINQUISH_FOLDER_MEMBERSHIP_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RELINQUISH_FOLDER_MEMBERSHIP_ERROR}, {@code false} otherwise.
     */
    public boolean isRelinquishFolderMembershipError() {
        return this._tag == Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR;
    }

    /**
     * Returns an instance of {@code JobError} that has its tag set to {@link
     * Tag#RELINQUISH_FOLDER_MEMBERSHIP_ERROR}.
     *
     * <p> Error occurred while performing {@link
     * DbxUserSharingRequests#relinquishFolderMembership(String,boolean)}
     * action. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code JobError} with its tag set to {@link
     *     Tag#RELINQUISH_FOLDER_MEMBERSHIP_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static JobError relinquishFolderMembershipError(RelinquishFolderMembershipError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobError().withTagAndRelinquishFolderMembershipError(Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR, value);
    }

    /**
     * Error occurred while performing {@link
     * DbxUserSharingRequests#relinquishFolderMembership(String,boolean)}
     * action.
     *
     * <p> This instance must be tagged as {@link
     * Tag#RELINQUISH_FOLDER_MEMBERSHIP_ERROR}. </p>
     *
     * @return The {@link RelinquishFolderMembershipError} value associated with
     *     this instance if {@link #isRelinquishFolderMembershipError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link
     *     #isRelinquishFolderMembershipError} is {@code false}.
     */
    public RelinquishFolderMembershipError getRelinquishFolderMembershipErrorValue() {
        if (this._tag != Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR, but was Tag." + this._tag.name());
        }
        return relinquishFolderMembershipErrorValue;
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
            this.unshareFolderErrorValue,
            this.removeFolderMemberErrorValue,
            this.relinquishFolderMembershipErrorValue
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
        else if (obj instanceof JobError) {
            JobError other = (JobError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case UNSHARE_FOLDER_ERROR:
                    return (this.unshareFolderErrorValue == other.unshareFolderErrorValue) || (this.unshareFolderErrorValue.equals(other.unshareFolderErrorValue));
                case REMOVE_FOLDER_MEMBER_ERROR:
                    return (this.removeFolderMemberErrorValue == other.removeFolderMemberErrorValue) || (this.removeFolderMemberErrorValue.equals(other.removeFolderMemberErrorValue));
                case RELINQUISH_FOLDER_MEMBERSHIP_ERROR:
                    return (this.relinquishFolderMembershipErrorValue == other.relinquishFolderMembershipErrorValue) || (this.relinquishFolderMembershipErrorValue.equals(other.relinquishFolderMembershipErrorValue));
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
    static class Serializer extends UnionSerializer<JobError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(JobError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case UNSHARE_FOLDER_ERROR: {
                    g.writeStartObject();
                    writeTag("unshare_folder_error", g);
                    g.writeFieldName("unshare_folder_error");
                    UnshareFolderError.Serializer.INSTANCE.serialize(value.unshareFolderErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case REMOVE_FOLDER_MEMBER_ERROR: {
                    g.writeStartObject();
                    writeTag("remove_folder_member_error", g);
                    g.writeFieldName("remove_folder_member_error");
                    RemoveFolderMemberError.Serializer.INSTANCE.serialize(value.removeFolderMemberErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case RELINQUISH_FOLDER_MEMBERSHIP_ERROR: {
                    g.writeStartObject();
                    writeTag("relinquish_folder_membership_error", g);
                    g.writeFieldName("relinquish_folder_membership_error");
                    RelinquishFolderMembershipError.Serializer.INSTANCE.serialize(value.relinquishFolderMembershipErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public JobError deserialize(JsonParser p) throws IOException, JsonParseException {
            JobError value;
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
            else if ("unshare_folder_error".equals(tag)) {
                UnshareFolderError fieldValue = null;
                expectField("unshare_folder_error", p);
                fieldValue = UnshareFolderError.Serializer.INSTANCE.deserialize(p);
                value = JobError.unshareFolderError(fieldValue);
            }
            else if ("remove_folder_member_error".equals(tag)) {
                RemoveFolderMemberError fieldValue = null;
                expectField("remove_folder_member_error", p);
                fieldValue = RemoveFolderMemberError.Serializer.INSTANCE.deserialize(p);
                value = JobError.removeFolderMemberError(fieldValue);
            }
            else if ("relinquish_folder_membership_error".equals(tag)) {
                RelinquishFolderMembershipError fieldValue = null;
                expectField("relinquish_folder_membership_error", p);
                fieldValue = RelinquishFolderMembershipError.Serializer.INSTANCE.deserialize(p);
                value = JobError.relinquishFolderMembershipError(fieldValue);
            }
            else {
                value = JobError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
