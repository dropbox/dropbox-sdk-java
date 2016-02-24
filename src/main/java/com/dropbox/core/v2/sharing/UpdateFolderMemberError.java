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

public final class UpdateFolderMemberError {
    // union UpdateFolderMemberError

    /**
     * Discriminating tag type for {@link UpdateFolderMemberError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        MEMBER_ERROR, // SharedFolderMemberError
        /**
         * The current user's account doesn't support this action. An example of
         * this is when downgrading a member from editor to viewer. This action
         * can only be performed by users that have upgraded to a Pro or
         * Business plan.
         */
        INSUFFICIENT_PLAN,
        /**
         * The current user does not have permission to perform this action.
         */
        NO_PERMISSION,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("member_error", Tag.MEMBER_ERROR);
        VALUES_.put("insufficient_plan", Tag.INSUFFICIENT_PLAN);
        VALUES_.put("no_permission", Tag.NO_PERMISSION);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final UpdateFolderMemberError INSUFFICIENT_PLAN = new UpdateFolderMemberError(Tag.INSUFFICIENT_PLAN, null, null);
    public static final UpdateFolderMemberError NO_PERMISSION = new UpdateFolderMemberError(Tag.NO_PERMISSION, null, null);
    public static final UpdateFolderMemberError OTHER = new UpdateFolderMemberError(Tag.OTHER, null, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;
    private final SharedFolderMemberError memberErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UpdateFolderMemberError(Tag tag, SharedFolderAccessError accessErrorValue, SharedFolderMemberError memberErrorValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
        this.memberErrorValue = memberErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code UpdateFolderMemberError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code UpdateFolderMemberError} that has its tag
     * set to {@link Tag#ACCESS_ERROR}.
     *
     * @param value  {@link UpdateFolderMemberError#accessError} value to assign
     *     to this instance.
     *
     * @return Instance of {@code UpdateFolderMemberError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UpdateFolderMemberError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderMemberError(Tag.ACCESS_ERROR, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link UpdateFolderMemberError#accessError} value associated
     *     with this instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this.tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MEMBER_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#MEMBER_ERROR}, {@code false} otherwise.
     */
    public boolean isMemberError() {
        return this.tag == Tag.MEMBER_ERROR;
    }

    /**
     * Returns an instance of {@code UpdateFolderMemberError} that has its tag
     * set to {@link Tag#MEMBER_ERROR}.
     *
     * @param value  {@link UpdateFolderMemberError#memberError} value to assign
     *     to this instance.
     *
     * @return Instance of {@code UpdateFolderMemberError} with its tag set to
     *     {@link Tag#MEMBER_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UpdateFolderMemberError memberError(SharedFolderMemberError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderMemberError(Tag.MEMBER_ERROR, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#MEMBER_ERROR}.
     *
     * @return The {@link UpdateFolderMemberError#memberError} value associated
     *     with this instance if {@link #isMemberError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMemberError} is {@code
     *     false}.
     */
    public SharedFolderMemberError getMemberErrorValue() {
        if (this.tag != Tag.MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_ERROR, but was Tag." + tag.name());
        }
        return memberErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     */
    public boolean isInsufficientPlan() {
        return this.tag == Tag.INSUFFICIENT_PLAN;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
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
            accessErrorValue,
            memberErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UpdateFolderMemberError) {
            UpdateFolderMemberError other = (UpdateFolderMemberError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case MEMBER_ERROR:
                    return (this.memberErrorValue == other.memberErrorValue) || (this.memberErrorValue.equals(other.memberErrorValue));
                case INSUFFICIENT_PLAN:
                    return true;
                case NO_PERMISSION:
                    return true;
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

    public static UpdateFolderMemberError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UpdateFolderMemberError> _JSON_WRITER = new JsonWriter<UpdateFolderMemberError>() {
        public final void write(UpdateFolderMemberError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case MEMBER_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("member_error");
                    g.writeFieldName("member_error");
                    SharedFolderMemberError._JSON_WRITER.write(x.getMemberErrorValue(), g);
                    g.writeEndObject();
                    break;
                case INSUFFICIENT_PLAN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("insufficient_plan");
                    g.writeEndObject();
                    break;
                case NO_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_permission");
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

    public static final JsonReader<UpdateFolderMemberError> _JSON_READER = new JsonReader<UpdateFolderMemberError>() {

        public final UpdateFolderMemberError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return UpdateFolderMemberError.OTHER;
                }
                switch (tag) {
                    case INSUFFICIENT_PLAN: return UpdateFolderMemberError.INSUFFICIENT_PLAN;
                    case NO_PERMISSION: return UpdateFolderMemberError.NO_PERMISSION;
                    case OTHER: return UpdateFolderMemberError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            UpdateFolderMemberError value = null;
            if (tag != null) {
                switch (tag) {
                    case ACCESS_ERROR: {
                        SharedFolderAccessError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharedFolderAccessError._JSON_READER
                            .readField(parser, "access_error", v);
                        value = UpdateFolderMemberError.accessError(v);
                        break;
                    }
                    case MEMBER_ERROR: {
                        SharedFolderMemberError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharedFolderMemberError._JSON_READER
                            .readField(parser, "member_error", v);
                        value = UpdateFolderMemberError.memberError(v);
                        break;
                    }
                    case INSUFFICIENT_PLAN: {
                        value = UpdateFolderMemberError.INSUFFICIENT_PLAN;
                        break;
                    }
                    case NO_PERMISSION: {
                        value = UpdateFolderMemberError.NO_PERMISSION;
                        break;
                    }
                    case OTHER: {
                        value = UpdateFolderMemberError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return UpdateFolderMemberError.OTHER;
            }
            return value;
        }

    };
}
