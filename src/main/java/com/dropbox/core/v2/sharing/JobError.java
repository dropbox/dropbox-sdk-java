/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Error occurred while performing an asynchronous job from {@link
 * DbxSharing#unshareFolder(String,boolean)} or {@link
 * DbxSharing#removeFolderMember(String,MemberSelector,boolean)}.
 */
public final class JobError {
    // union JobError

    /**
     * Discriminating tag type for {@link JobError}.
     */
    public enum Tag {
        /**
         * Error occurred while performing {@link
         * DbxSharing#unshareFolder(String,boolean)} action.
         */
        UNSHARE_FOLDER_ERROR, // UnshareFolderError
        /**
         * Error occurred while performing {@link
         * DbxSharing#removeFolderMember(String,MemberSelector,boolean)} action.
         */
        REMOVE_FOLDER_MEMBER_ERROR, // RemoveFolderMemberError
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("unshare_folder_error", Tag.UNSHARE_FOLDER_ERROR);
        VALUES_.put("remove_folder_member_error", Tag.REMOVE_FOLDER_MEMBER_ERROR);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final JobError OTHER = new JobError(Tag.OTHER, null, null);

    private final Tag tag;
    private final UnshareFolderError unshareFolderErrorValue;
    private final RemoveFolderMemberError removeFolderMemberErrorValue;

    /**
     * Error occurred while performing an asynchronous job from {@link
     * DbxSharing#unshareFolder(String,boolean)} or {@link
     * DbxSharing#removeFolderMember(String,MemberSelector,boolean)}.
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code JobError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * DbxSharing#unshareFolder(String,boolean)} action. </p>
     *
     * @param value  {@link JobError#unshareFolderError} value to assign to this
     *     instance.
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
     * DbxSharing#unshareFolder(String,boolean)} action.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * DbxSharing#removeFolderMember(String,MemberSelector,boolean)} action.
     * </p>
     *
     * @param value  {@link JobError#removeFolderMemberError} value to assign to
     *     this instance.
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
     * DbxSharing#removeFolderMember(String,MemberSelector,boolean)} action.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static JobError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<JobError> _JSON_WRITER = new JsonWriter<JobError>() {
        public final void write(JobError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case UNSHARE_FOLDER_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unshare_folder_error");
                    g.writeFieldName("unshare_folder_error");
                    UnshareFolderError._JSON_WRITER.write(x.getUnshareFolderErrorValue(), g);
                    g.writeEndObject();
                    break;
                case REMOVE_FOLDER_MEMBER_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("remove_folder_member_error");
                    g.writeFieldName("remove_folder_member_error");
                    RemoveFolderMemberError._JSON_WRITER.write(x.getRemoveFolderMemberErrorValue(), g);
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<JobError> _JSON_READER = new JsonReader<JobError>() {

        public final JobError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return JobError.OTHER;
                }
                switch (tag) {
                    case OTHER: return JobError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            JobError value = null;
            if (tag != null) {
                switch (tag) {
                    case UNSHARE_FOLDER_ERROR: {
                        UnshareFolderError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = UnshareFolderError._JSON_READER
                            .readField(parser, "unshare_folder_error", v);
                        value = JobError.unshareFolderError(v);
                        break;
                    }
                    case REMOVE_FOLDER_MEMBER_ERROR: {
                        RemoveFolderMemberError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = RemoveFolderMemberError._JSON_READER
                            .readField(parser, "remove_folder_member_error", v);
                        value = JobError.removeFolderMemberError(v);
                        break;
                    }
                    case OTHER: {
                        value = JobError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return JobError.OTHER;
            }
            return value;
        }

    };
}
