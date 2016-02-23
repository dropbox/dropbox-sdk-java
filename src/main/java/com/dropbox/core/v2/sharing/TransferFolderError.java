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

public final class TransferFolderError {
    // union TransferFolderError

    /**
     * Discriminating tag type for {@link TransferFolderError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * The current account does not have permission to perform this action.
         */
        NO_PERMISSION,
        /**
         * {@link TransferFolderArg#getToDropboxId} is invalid.
         */
        INVALID_DROPBOX_ID,
        /**
         * The new designated owner is not currently a member of the shared
         * folder.
         */
        NEW_OWNER_NOT_A_MEMBER,
        /**
         * The new desginated owner does not have the shared folder mounted.
         */
        NEW_OWNER_UNMOUNTED,
        /**
         * The new designated owner's e-mail address is unverified.
         */
        NEW_OWNER_EMAIL_UNVERIFIED,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("no_permission", Tag.NO_PERMISSION);
        VALUES_.put("invalid_dropbox_id", Tag.INVALID_DROPBOX_ID);
        VALUES_.put("new_owner_not_a_member", Tag.NEW_OWNER_NOT_A_MEMBER);
        VALUES_.put("new_owner_unmounted", Tag.NEW_OWNER_UNMOUNTED);
        VALUES_.put("new_owner_email_unverified", Tag.NEW_OWNER_EMAIL_UNVERIFIED);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final TransferFolderError NO_PERMISSION = new TransferFolderError(Tag.NO_PERMISSION, null);
    public static final TransferFolderError INVALID_DROPBOX_ID = new TransferFolderError(Tag.INVALID_DROPBOX_ID, null);
    public static final TransferFolderError NEW_OWNER_NOT_A_MEMBER = new TransferFolderError(Tag.NEW_OWNER_NOT_A_MEMBER, null);
    public static final TransferFolderError NEW_OWNER_UNMOUNTED = new TransferFolderError(Tag.NEW_OWNER_UNMOUNTED, null);
    public static final TransferFolderError NEW_OWNER_EMAIL_UNVERIFIED = new TransferFolderError(Tag.NEW_OWNER_EMAIL_UNVERIFIED, null);
    public static final TransferFolderError OTHER = new TransferFolderError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private TransferFolderError(Tag tag, SharedFolderAccessError accessErrorValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code TransferFolderError}. </p>
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
     * Returns an instance of {@code TransferFolderError} that has its tag set
     * to {@link Tag#ACCESS_ERROR}.
     *
     * @param value  {@link TransferFolderError#accessError} value to assign to
     *     this instance.
     *
     * @return Instance of {@code TransferFolderError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TransferFolderError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TransferFolderError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link TransferFolderError#accessError} value associated with
     *     this instance if {@link #isAccessError} is {@code true}.
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
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
     */
    public boolean isInvalidDropboxId() {
        return this.tag == Tag.INVALID_DROPBOX_ID;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
     */
    public boolean isNewOwnerNotAMember() {
        return this.tag == Tag.NEW_OWNER_NOT_A_MEMBER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
     */
    public boolean isNewOwnerUnmounted() {
        return this.tag == Tag.NEW_OWNER_UNMOUNTED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isNewOwnerEmailUnverified() {
        return this.tag == Tag.NEW_OWNER_EMAIL_UNVERIFIED;
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
            accessErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof TransferFolderError) {
            TransferFolderError other = (TransferFolderError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case NO_PERMISSION:
                    return true;
                case INVALID_DROPBOX_ID:
                    return true;
                case NEW_OWNER_NOT_A_MEMBER:
                    return true;
                case NEW_OWNER_UNMOUNTED:
                    return true;
                case NEW_OWNER_EMAIL_UNVERIFIED:
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

    public static TransferFolderError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TransferFolderError> _JSON_WRITER = new JsonWriter<TransferFolderError>() {
        public final void write(TransferFolderError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case NO_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_permission");
                    g.writeEndObject();
                    break;
                case INVALID_DROPBOX_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_dropbox_id");
                    g.writeEndObject();
                    break;
                case NEW_OWNER_NOT_A_MEMBER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("new_owner_not_a_member");
                    g.writeEndObject();
                    break;
                case NEW_OWNER_UNMOUNTED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("new_owner_unmounted");
                    g.writeEndObject();
                    break;
                case NEW_OWNER_EMAIL_UNVERIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("new_owner_email_unverified");
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

    public static final JsonReader<TransferFolderError> _JSON_READER = new JsonReader<TransferFolderError>() {

        public final TransferFolderError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return TransferFolderError.OTHER;
                }
                switch (tag) {
                    case NO_PERMISSION: return TransferFolderError.NO_PERMISSION;
                    case INVALID_DROPBOX_ID: return TransferFolderError.INVALID_DROPBOX_ID;
                    case NEW_OWNER_NOT_A_MEMBER: return TransferFolderError.NEW_OWNER_NOT_A_MEMBER;
                    case NEW_OWNER_UNMOUNTED: return TransferFolderError.NEW_OWNER_UNMOUNTED;
                    case NEW_OWNER_EMAIL_UNVERIFIED: return TransferFolderError.NEW_OWNER_EMAIL_UNVERIFIED;
                    case OTHER: return TransferFolderError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            TransferFolderError value = null;
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
                        value = TransferFolderError.accessError(v);
                        break;
                    }
                    case NO_PERMISSION: {
                        value = TransferFolderError.NO_PERMISSION;
                        break;
                    }
                    case INVALID_DROPBOX_ID: {
                        value = TransferFolderError.INVALID_DROPBOX_ID;
                        break;
                    }
                    case NEW_OWNER_NOT_A_MEMBER: {
                        value = TransferFolderError.NEW_OWNER_NOT_A_MEMBER;
                        break;
                    }
                    case NEW_OWNER_UNMOUNTED: {
                        value = TransferFolderError.NEW_OWNER_UNMOUNTED;
                        break;
                    }
                    case NEW_OWNER_EMAIL_UNVERIFIED: {
                        value = TransferFolderError.NEW_OWNER_EMAIL_UNVERIFIED;
                        break;
                    }
                    case OTHER: {
                        value = TransferFolderError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return TransferFolderError.OTHER;
            }
            return value;
        }

    };
}
