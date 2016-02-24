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

public final class AddMemberSelectorError {
    // union AddMemberSelectorError

    /**
     * Discriminating tag type for {@link AddMemberSelectorError}.
     */
    public enum Tag {
        /**
         * The value is the ID that could not be identified.
         */
        INVALID_DROPBOX_ID, // String
        /**
         * The value is the e-email address that is malformed.
         */
        INVALID_EMAIL, // String
        /**
         * The value is the ID of the Dropbox user with an unverified e-mail
         * address.  Invite unverified users by e-mail address instead of by
         * their Dropbox ID.
         */
        UNVERIFIED_DROPBOX_ID, // String
        /**
         * At least one of the specified groups in {@link
         * AddFolderMemberArg#getMembers} is deleted.
         */
        GROUP_DELETED,
        /**
         * Sharing to a group that is not on the current user's team.
         */
        GROUP_NOT_ON_TEAM,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("invalid_dropbox_id", Tag.INVALID_DROPBOX_ID);
        VALUES_.put("invalid_email", Tag.INVALID_EMAIL);
        VALUES_.put("unverified_dropbox_id", Tag.UNVERIFIED_DROPBOX_ID);
        VALUES_.put("group_deleted", Tag.GROUP_DELETED);
        VALUES_.put("group_not_on_team", Tag.GROUP_NOT_ON_TEAM);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final AddMemberSelectorError GROUP_DELETED = new AddMemberSelectorError(Tag.GROUP_DELETED, null, null, null);
    public static final AddMemberSelectorError GROUP_NOT_ON_TEAM = new AddMemberSelectorError(Tag.GROUP_NOT_ON_TEAM, null, null, null);
    public static final AddMemberSelectorError OTHER = new AddMemberSelectorError(Tag.OTHER, null, null, null);

    private final Tag tag;
    private final String invalidDropboxIdValue;
    private final String invalidEmailValue;
    private final String unverifiedDropboxIdValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private AddMemberSelectorError(Tag tag, String invalidDropboxIdValue, String invalidEmailValue, String unverifiedDropboxIdValue) {
        this.tag = tag;
        this.invalidDropboxIdValue = invalidDropboxIdValue;
        this.invalidEmailValue = invalidEmailValue;
        this.unverifiedDropboxIdValue = unverifiedDropboxIdValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code AddMemberSelectorError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
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
     * Returns an instance of {@code AddMemberSelectorError} that has its tag
     * set to {@link Tag#INVALID_DROPBOX_ID}.
     *
     * <p> The value is the ID that could not be identified. </p>
     *
     * @param value  {@link AddMemberSelectorError#invalidDropboxId} value to
     *     assign to this instance.
     *
     * @return Instance of {@code AddMemberSelectorError} with its tag set to
     *     {@link Tag#INVALID_DROPBOX_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static AddMemberSelectorError invalidDropboxId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new AddMemberSelectorError(Tag.INVALID_DROPBOX_ID, value, null, null);
    }

    /**
     * The value is the ID that could not be identified.
     *
     * <p> This instance must be tagged as {@link Tag#INVALID_DROPBOX_ID}. </p>
     *
     * @return The {@link AddMemberSelectorError#invalidDropboxId} value
     *     associated with this instance if {@link #isInvalidDropboxId} is
     *     {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInvalidDropboxId} is {@code
     *     false}.
     */
    public String getInvalidDropboxIdValue() {
        if (this.tag != Tag.INVALID_DROPBOX_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_DROPBOX_ID, but was Tag." + tag.name());
        }
        return invalidDropboxIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_EMAIL}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INVALID_EMAIL}, {@code false} otherwise.
     */
    public boolean isInvalidEmail() {
        return this.tag == Tag.INVALID_EMAIL;
    }

    /**
     * Returns an instance of {@code AddMemberSelectorError} that has its tag
     * set to {@link Tag#INVALID_EMAIL}.
     *
     * <p> The value is the e-email address that is malformed. </p>
     *
     * @param value  {@link AddMemberSelectorError#invalidEmail} value to assign
     *     to this instance.
     *
     * @return Instance of {@code AddMemberSelectorError} with its tag set to
     *     {@link Tag#INVALID_EMAIL}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static AddMemberSelectorError invalidEmail(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddMemberSelectorError(Tag.INVALID_EMAIL, null, value, null);
    }

    /**
     * The value is the e-email address that is malformed.
     *
     * <p> This instance must be tagged as {@link Tag#INVALID_EMAIL}. </p>
     *
     * @return The {@link AddMemberSelectorError#invalidEmail} value associated
     *     with this instance if {@link #isInvalidEmail} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInvalidEmail} is {@code
     *     false}.
     */
    public String getInvalidEmailValue() {
        if (this.tag != Tag.INVALID_EMAIL) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_EMAIL, but was Tag." + tag.name());
        }
        return invalidEmailValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNVERIFIED_DROPBOX_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#UNVERIFIED_DROPBOX_ID}, {@code false} otherwise.
     */
    public boolean isUnverifiedDropboxId() {
        return this.tag == Tag.UNVERIFIED_DROPBOX_ID;
    }

    /**
     * Returns an instance of {@code AddMemberSelectorError} that has its tag
     * set to {@link Tag#UNVERIFIED_DROPBOX_ID}.
     *
     * <p> The value is the ID of the Dropbox user with an unverified e-mail
     * address.  Invite unverified users by e-mail address instead of by their
     * Dropbox ID. </p>
     *
     * @param value  {@link AddMemberSelectorError#unverifiedDropboxId} value to
     *     assign to this instance.
     *
     * @return Instance of {@code AddMemberSelectorError} with its tag set to
     *     {@link Tag#UNVERIFIED_DROPBOX_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static AddMemberSelectorError unverifiedDropboxId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new AddMemberSelectorError(Tag.UNVERIFIED_DROPBOX_ID, null, null, value);
    }

    /**
     * The value is the ID of the Dropbox user with an unverified e-mail
     * address.  Invite unverified users by e-mail address instead of by their
     * Dropbox ID.
     *
     * <p> This instance must be tagged as {@link Tag#UNVERIFIED_DROPBOX_ID}.
     * </p>
     *
     * @return The {@link AddMemberSelectorError#unverifiedDropboxId} value
     *     associated with this instance if {@link #isUnverifiedDropboxId} is
     *     {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUnverifiedDropboxId} is
     *     {@code false}.
     */
    public String getUnverifiedDropboxIdValue() {
        if (this.tag != Tag.UNVERIFIED_DROPBOX_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.UNVERIFIED_DROPBOX_ID, but was Tag." + tag.name());
        }
        return unverifiedDropboxIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_DELETED}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#GROUP_DELETED}, {@code false} otherwise.
     */
    public boolean isGroupDeleted() {
        return this.tag == Tag.GROUP_DELETED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_NOT_ON_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#GROUP_NOT_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isGroupNotOnTeam() {
        return this.tag == Tag.GROUP_NOT_ON_TEAM;
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
            invalidDropboxIdValue,
            invalidEmailValue,
            unverifiedDropboxIdValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof AddMemberSelectorError) {
            AddMemberSelectorError other = (AddMemberSelectorError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case INVALID_DROPBOX_ID:
                    return (this.invalidDropboxIdValue == other.invalidDropboxIdValue) || (this.invalidDropboxIdValue.equals(other.invalidDropboxIdValue));
                case INVALID_EMAIL:
                    return (this.invalidEmailValue == other.invalidEmailValue) || (this.invalidEmailValue.equals(other.invalidEmailValue));
                case UNVERIFIED_DROPBOX_ID:
                    return (this.unverifiedDropboxIdValue == other.unverifiedDropboxIdValue) || (this.unverifiedDropboxIdValue.equals(other.unverifiedDropboxIdValue));
                case GROUP_DELETED:
                    return true;
                case GROUP_NOT_ON_TEAM:
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

    public static AddMemberSelectorError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AddMemberSelectorError> _JSON_WRITER = new JsonWriter<AddMemberSelectorError>() {
        public final void write(AddMemberSelectorError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case INVALID_DROPBOX_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_dropbox_id");
                    g.writeFieldName("invalid_dropbox_id");
                    g.writeString(x.getInvalidDropboxIdValue());
                    g.writeEndObject();
                    break;
                case INVALID_EMAIL:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_email");
                    g.writeFieldName("invalid_email");
                    g.writeString(x.getInvalidEmailValue());
                    g.writeEndObject();
                    break;
                case UNVERIFIED_DROPBOX_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unverified_dropbox_id");
                    g.writeFieldName("unverified_dropbox_id");
                    g.writeString(x.getUnverifiedDropboxIdValue());
                    g.writeEndObject();
                    break;
                case GROUP_DELETED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_deleted");
                    g.writeEndObject();
                    break;
                case GROUP_NOT_ON_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_not_on_team");
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

    public static final JsonReader<AddMemberSelectorError> _JSON_READER = new JsonReader<AddMemberSelectorError>() {

        public final AddMemberSelectorError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return AddMemberSelectorError.OTHER;
                }
                switch (tag) {
                    case GROUP_DELETED: return AddMemberSelectorError.GROUP_DELETED;
                    case GROUP_NOT_ON_TEAM: return AddMemberSelectorError.GROUP_NOT_ON_TEAM;
                    case OTHER: return AddMemberSelectorError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            AddMemberSelectorError value = null;
            if (tag != null) {
                switch (tag) {
                    case INVALID_DROPBOX_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "invalid_dropbox_id", v);
                        value = AddMemberSelectorError.invalidDropboxId(v);
                        break;
                    }
                    case INVALID_EMAIL: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "invalid_email", v);
                        value = AddMemberSelectorError.invalidEmail(v);
                        break;
                    }
                    case UNVERIFIED_DROPBOX_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "unverified_dropbox_id", v);
                        value = AddMemberSelectorError.unverifiedDropboxId(v);
                        break;
                    }
                    case GROUP_DELETED: {
                        value = AddMemberSelectorError.GROUP_DELETED;
                        break;
                    }
                    case GROUP_NOT_ON_TEAM: {
                        value = AddMemberSelectorError.GROUP_NOT_ON_TEAM;
                        break;
                    }
                    case OTHER: {
                        value = AddMemberSelectorError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return AddMemberSelectorError.OTHER;
            }
            return value;
        }

    };
}
