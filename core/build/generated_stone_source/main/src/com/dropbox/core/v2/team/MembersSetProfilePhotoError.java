/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.v2.account.SetProfilePhotoError;

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
public final class MembersSetProfilePhotoError {
    // union team.MembersSetProfilePhotoError (team_members.stone)

    /**
     * Discriminating tag type for {@link MembersSetProfilePhotoError}.
     */
    public enum Tag {
        /**
         * No matching user found. The provided team_member_id, email, or
         * external_id does not exist on this team.
         */
        USER_NOT_FOUND,
        /**
         * The user is not a member of the team.
         */
        USER_NOT_IN_TEAM,
        /**
         * Modifying deleted users is not allowed.
         */
        SET_PROFILE_DISALLOWED,
        PHOTO_ERROR, // SetProfilePhotoError
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
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    public static final MembersSetProfilePhotoError USER_NOT_FOUND = new MembersSetProfilePhotoError().withTag(Tag.USER_NOT_FOUND);
    /**
     * The user is not a member of the team.
     */
    public static final MembersSetProfilePhotoError USER_NOT_IN_TEAM = new MembersSetProfilePhotoError().withTag(Tag.USER_NOT_IN_TEAM);
    /**
     * Modifying deleted users is not allowed.
     */
    public static final MembersSetProfilePhotoError SET_PROFILE_DISALLOWED = new MembersSetProfilePhotoError().withTag(Tag.SET_PROFILE_DISALLOWED);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final MembersSetProfilePhotoError OTHER = new MembersSetProfilePhotoError().withTag(Tag.OTHER);

    private Tag _tag;
    private SetProfilePhotoError photoErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private MembersSetProfilePhotoError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private MembersSetProfilePhotoError withTag(Tag _tag) {
        MembersSetProfilePhotoError result = new MembersSetProfilePhotoError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param photoErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MembersSetProfilePhotoError withTagAndPhotoError(Tag _tag, SetProfilePhotoError photoErrorValue) {
        MembersSetProfilePhotoError result = new MembersSetProfilePhotoError();
        result._tag = _tag;
        result.photoErrorValue = photoErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MembersSetProfilePhotoError}. </p>
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
     * Tag#USER_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isUserNotFound() {
        return this._tag == Tag.USER_NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_NOT_IN_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_NOT_IN_TEAM}, {@code false} otherwise.
     */
    public boolean isUserNotInTeam() {
        return this._tag == Tag.USER_NOT_IN_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SET_PROFILE_DISALLOWED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SET_PROFILE_DISALLOWED}, {@code false} otherwise.
     */
    public boolean isSetProfileDisallowed() {
        return this._tag == Tag.SET_PROFILE_DISALLOWED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PHOTO_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PHOTO_ERROR}, {@code false} otherwise.
     */
    public boolean isPhotoError() {
        return this._tag == Tag.PHOTO_ERROR;
    }

    /**
     * Returns an instance of {@code MembersSetProfilePhotoError} that has its
     * tag set to {@link Tag#PHOTO_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersSetProfilePhotoError} with its tag set
     *     to {@link Tag#PHOTO_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MembersSetProfilePhotoError photoError(SetProfilePhotoError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersSetProfilePhotoError().withTagAndPhotoError(Tag.PHOTO_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PHOTO_ERROR}.
     *
     * @return The {@link SetProfilePhotoError} value associated with this
     *     instance if {@link #isPhotoError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPhotoError} is {@code false}.
     */
    public SetProfilePhotoError getPhotoErrorValue() {
        if (this._tag != Tag.PHOTO_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.PHOTO_ERROR, but was Tag." + this._tag.name());
        }
        return photoErrorValue;
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
            this.photoErrorValue
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
        else if (obj instanceof MembersSetProfilePhotoError) {
            MembersSetProfilePhotoError other = (MembersSetProfilePhotoError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case USER_NOT_FOUND:
                    return true;
                case USER_NOT_IN_TEAM:
                    return true;
                case SET_PROFILE_DISALLOWED:
                    return true;
                case PHOTO_ERROR:
                    return (this.photoErrorValue == other.photoErrorValue) || (this.photoErrorValue.equals(other.photoErrorValue));
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
    static class Serializer extends UnionSerializer<MembersSetProfilePhotoError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetProfilePhotoError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case USER_NOT_FOUND: {
                    g.writeString("user_not_found");
                    break;
                }
                case USER_NOT_IN_TEAM: {
                    g.writeString("user_not_in_team");
                    break;
                }
                case SET_PROFILE_DISALLOWED: {
                    g.writeString("set_profile_disallowed");
                    break;
                }
                case PHOTO_ERROR: {
                    g.writeStartObject();
                    writeTag("photo_error", g);
                    g.writeFieldName("photo_error");
                    SetProfilePhotoError.Serializer.INSTANCE.serialize(value.photoErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MembersSetProfilePhotoError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersSetProfilePhotoError value;
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
            else if ("user_not_found".equals(tag)) {
                value = MembersSetProfilePhotoError.USER_NOT_FOUND;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MembersSetProfilePhotoError.USER_NOT_IN_TEAM;
            }
            else if ("set_profile_disallowed".equals(tag)) {
                value = MembersSetProfilePhotoError.SET_PROFILE_DISALLOWED;
            }
            else if ("photo_error".equals(tag)) {
                SetProfilePhotoError fieldValue = null;
                expectField("photo_error", p);
                fieldValue = SetProfilePhotoError.Serializer.INSTANCE.deserialize(p);
                value = MembersSetProfilePhotoError.photoError(fieldValue);
            }
            else {
                value = MembersSetProfilePhotoError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
