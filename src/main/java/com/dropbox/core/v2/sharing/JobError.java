/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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
 * Error occurred while performing an asynchronous job from {@link
 * DbxUserSharingRequests#unshareFolder(String)} or {@link
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
@JsonSerialize(using=JobError.Serializer.class)
@JsonDeserialize(using=JobError.Deserializer.class)
public final class JobError {
    // union JobError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link JobError}.
     */
    public enum Tag {
        /**
         * Error occurred while performing {@link
         * DbxUserSharingRequests#unshareFolder(String)} action.
         */
        UNSHARE_FOLDER_ERROR, // UnshareFolderError
        /**
         * Error occurred while performing {@link
         * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}
         * action.
         */
        REMOVE_FOLDER_MEMBER_ERROR, // RemoveFolderMemberError
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
    public static final JobError OTHER = new JobError(Tag.OTHER, null, null);

    private final Tag tag;
    private final UnshareFolderError unshareFolderErrorValue;
    private final RemoveFolderMemberError removeFolderMemberErrorValue;

    /**
     * Error occurred while performing an asynchronous job from {@link
     * DbxUserSharingRequests#unshareFolder(String)} or {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private JobError(Tag tag, UnshareFolderError unshareFolderErrorValue, RemoveFolderMemberError removeFolderMemberErrorValue) {
        this.tag = tag;
        this.unshareFolderErrorValue = unshareFolderErrorValue;
        this.removeFolderMemberErrorValue = removeFolderMemberErrorValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSHARE_FOLDER_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSHARE_FOLDER_ERROR}, {@code false} otherwise.
     */
    public boolean isUnshareFolderError() {
        return this.tag == Tag.UNSHARE_FOLDER_ERROR;
    }

    /**
     * Returns an instance of {@code JobError} that has its tag set to {@link
     * Tag#UNSHARE_FOLDER_ERROR}.
     *
     * <p> Error occurred while performing {@link
     * DbxUserSharingRequests#unshareFolder(String)} action. </p>
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
        return new JobError(Tag.UNSHARE_FOLDER_ERROR, value, null);
    }

    /**
     * Error occurred while performing {@link
     * DbxUserSharingRequests#unshareFolder(String)} action.
     *
     * <p> This instance must be tagged as {@link Tag#UNSHARE_FOLDER_ERROR}.
     * </p>
     *
     * @return The {@link JobError#unshareFolderError} value associated with
     *     this instance if {@link #isUnshareFolderError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUnshareFolderError} is {@code
     *     false}.
     */
    public UnshareFolderError getUnshareFolderErrorValue() {
        if (this.tag != Tag.UNSHARE_FOLDER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.UNSHARE_FOLDER_ERROR, but was Tag." + tag.name());
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
        return this.tag == Tag.REMOVE_FOLDER_MEMBER_ERROR;
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
        return new JobError(Tag.REMOVE_FOLDER_MEMBER_ERROR, null, value);
    }

    /**
     * Error occurred while performing {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}
     * action.
     *
     * <p> This instance must be tagged as {@link
     * Tag#REMOVE_FOLDER_MEMBER_ERROR}. </p>
     *
     * @return The {@link JobError#removeFolderMemberError} value associated
     *     with this instance if {@link #isRemoveFolderMemberError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isRemoveFolderMemberError} is
     *     {@code false}.
     */
    public RemoveFolderMemberError getRemoveFolderMemberErrorValue() {
        if (this.tag != Tag.REMOVE_FOLDER_MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.REMOVE_FOLDER_MEMBER_ERROR, but was Tag." + tag.name());
        }
        return removeFolderMemberErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            unshareFolderErrorValue,
            removeFolderMemberErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof JobError) {
            JobError other = (JobError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case UNSHARE_FOLDER_ERROR:
                    return (this.unshareFolderErrorValue == other.unshareFolderErrorValue) || (this.unshareFolderErrorValue.equals(other.unshareFolderErrorValue));
                case REMOVE_FOLDER_MEMBER_ERROR:
                    return (this.removeFolderMemberErrorValue == other.removeFolderMemberErrorValue) || (this.removeFolderMemberErrorValue.equals(other.removeFolderMemberErrorValue));
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

    static final class Serializer extends UnionJsonSerializer<JobError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(JobError.class);
        }

        @Override
        public void serialize(JobError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case UNSHARE_FOLDER_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "unshare_folder_error");
                    g.writeObjectField("unshare_folder_error", value.unshareFolderErrorValue);
                    g.writeEndObject();
                    break;
                case REMOVE_FOLDER_MEMBER_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "remove_folder_member_error");
                    g.writeObjectField("remove_folder_member_error", value.removeFolderMemberErrorValue);
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<JobError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(JobError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public JobError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case UNSHARE_FOLDER_ERROR: {
                    UnshareFolderError value = null;
                    expectField(_p, "unshare_folder_error");
                    value = _p.readValueAs(UnshareFolderError.class);
                    _p.nextToken();
                    return JobError.unshareFolderError(value);
                }
                case REMOVE_FOLDER_MEMBER_ERROR: {
                    RemoveFolderMemberError value = null;
                    expectField(_p, "remove_folder_member_error");
                    value = _p.readValueAs(RemoveFolderMemberError.class);
                    _p.nextToken();
                    return JobError.removeFolderMemberError(value);
                }
                case OTHER: {
                    return JobError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, JobError.Tag> getTagMapping() {
            Map<String, JobError.Tag> values = new HashMap<String, JobError.Tag>();
            values.put("unshare_folder_error", JobError.Tag.UNSHARE_FOLDER_ERROR);
            values.put("remove_folder_member_error", JobError.Tag.REMOVE_FOLDER_MEMBER_ERROR);
            values.put("other", JobError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
