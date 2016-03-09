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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
@JsonSerialize(using=AddMemberSelectorError.Serializer.class)
@JsonDeserialize(using=AddMemberSelectorError.Deserializer.class)
public final class AddMemberSelectorError {
    // union AddMemberSelectorError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
         * At least one of the specified groups in the {@code members} argument
         * to {@link
         * DbxUserSharingRequests#addFolderMember(String,java.util.List)} is
         * deleted.
         */
        GROUP_DELETED,
        /**
         * Sharing to a group that is not on the current user's team.
         */
        GROUP_NOT_ON_TEAM,
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
     * At least one of the specified groups in the {@code members} argument to
     * {@link DbxUserSharingRequests#addFolderMember(String,java.util.List)} is
     * deleted.
     */
    public static final AddMemberSelectorError GROUP_DELETED = new AddMemberSelectorError(Tag.GROUP_DELETED, null, null, null);
    /**
     * Sharing to a group that is not on the current user's team.
     */
    public static final AddMemberSelectorError GROUP_NOT_ON_TEAM = new AddMemberSelectorError(Tag.GROUP_NOT_ON_TEAM, null, null, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code AddMemberSelectorError}. </p>
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
     * Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
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
     * @param value  value to assign to this instance.
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
     * @return {@code true} if this instance is tagged as {@link
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
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddMemberSelectorError} with its tag set to
     *     {@link Tag#INVALID_EMAIL}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
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
     * @return {@code true} if this instance is tagged as {@link
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
     * @param value  value to assign to this instance.
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
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_DELETED}, {@code false} otherwise.
     */
    public boolean isGroupDeleted() {
        return this.tag == Tag.GROUP_DELETED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_NOT_ON_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_NOT_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isGroupNotOnTeam() {
        return this.tag == Tag.GROUP_NOT_ON_TEAM;
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

    static final class Serializer extends UnionJsonSerializer<AddMemberSelectorError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AddMemberSelectorError.class);
        }

        @Override
        public void serialize(AddMemberSelectorError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case INVALID_DROPBOX_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "invalid_dropbox_id");
                    g.writeObjectField("invalid_dropbox_id", value.invalidDropboxIdValue);
                    g.writeEndObject();
                    break;
                case INVALID_EMAIL:
                    g.writeStartObject();
                    g.writeStringField(".tag", "invalid_email");
                    g.writeObjectField("invalid_email", value.invalidEmailValue);
                    g.writeEndObject();
                    break;
                case UNVERIFIED_DROPBOX_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "unverified_dropbox_id");
                    g.writeObjectField("unverified_dropbox_id", value.unverifiedDropboxIdValue);
                    g.writeEndObject();
                    break;
                case GROUP_DELETED:
                    g.writeString("group_deleted");
                    break;
                case GROUP_NOT_ON_TEAM:
                    g.writeString("group_not_on_team");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<AddMemberSelectorError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AddMemberSelectorError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public AddMemberSelectorError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case INVALID_DROPBOX_ID: {
                    String value = null;
                    expectField(_p, "invalid_dropbox_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return AddMemberSelectorError.invalidDropboxId(value);
                }
                case INVALID_EMAIL: {
                    String value = null;
                    expectField(_p, "invalid_email");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return AddMemberSelectorError.invalidEmail(value);
                }
                case UNVERIFIED_DROPBOX_ID: {
                    String value = null;
                    expectField(_p, "unverified_dropbox_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return AddMemberSelectorError.unverifiedDropboxId(value);
                }
                case GROUP_DELETED: {
                    return AddMemberSelectorError.GROUP_DELETED;
                }
                case GROUP_NOT_ON_TEAM: {
                    return AddMemberSelectorError.GROUP_NOT_ON_TEAM;
                }
                case OTHER: {
                    return AddMemberSelectorError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, AddMemberSelectorError.Tag> getTagMapping() {
            Map<String, AddMemberSelectorError.Tag> values = new HashMap<String, AddMemberSelectorError.Tag>();
            values.put("invalid_dropbox_id", AddMemberSelectorError.Tag.INVALID_DROPBOX_ID);
            values.put("invalid_email", AddMemberSelectorError.Tag.INVALID_EMAIL);
            values.put("unverified_dropbox_id", AddMemberSelectorError.Tag.UNVERIFIED_DROPBOX_ID);
            values.put("group_deleted", AddMemberSelectorError.Tag.GROUP_DELETED);
            values.put("group_not_on_team", AddMemberSelectorError.Tag.GROUP_NOT_ON_TEAM);
            values.put("other", AddMemberSelectorError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
