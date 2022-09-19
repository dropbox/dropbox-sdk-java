/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.v2.files.LookupError;

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
public final class CreateSharedLinkWithSettingsError {
    // union sharing.CreateSharedLinkWithSettingsError (shared_links.stone)

    /**
     * Discriminating tag type for {@link CreateSharedLinkWithSettingsError}.
     */
    public enum Tag {
        PATH, // LookupError
        /**
         * This user's email address is not verified. This functionality is only
         * available on accounts with a verified email address. Users can verify
         * their email address <a
         * href="https://www.dropbox.com/help/317">here</a>.
         */
        EMAIL_NOT_VERIFIED,
        /**
         * The shared link already exists. You can call {@link
         * DbxUserSharingRequests#listSharedLinks} to get the  existing link, or
         * use the provided metadata if it is returned.
         */
        SHARED_LINK_ALREADY_EXISTS, // SharedLinkAlreadyExistsMetadata
        /**
         * There is an error with the given settings.
         */
        SETTINGS_ERROR, // SharedLinkSettingsError
        /**
         * The user is not allowed to create a shared link to the specified
         * file. For  example, this can occur if the file is restricted or if
         * the user's links are  <a
         * href="https://help.dropbox.com/files-folders/share/banned-links">banned</a>.
         */
        ACCESS_DENIED;
    }

    /**
     * This user's email address is not verified. This functionality is only
     * available on accounts with a verified email address. Users can verify
     * their email address <a href="https://www.dropbox.com/help/317">here</a>.
     */
    public static final CreateSharedLinkWithSettingsError EMAIL_NOT_VERIFIED = new CreateSharedLinkWithSettingsError().withTag(Tag.EMAIL_NOT_VERIFIED);
    /**
     * The user is not allowed to create a shared link to the specified file.
     * For  example, this can occur if the file is restricted or if the user's
     * links are  <a
     * href="https://help.dropbox.com/files-folders/share/banned-links">banned</a>.
     */
    public static final CreateSharedLinkWithSettingsError ACCESS_DENIED = new CreateSharedLinkWithSettingsError().withTag(Tag.ACCESS_DENIED);

    private Tag _tag;
    private LookupError pathValue;
    private SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsValue;
    private SharedLinkSettingsError settingsErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private CreateSharedLinkWithSettingsError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private CreateSharedLinkWithSettingsError withTag(Tag _tag) {
        CreateSharedLinkWithSettingsError result = new CreateSharedLinkWithSettingsError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private CreateSharedLinkWithSettingsError withTagAndPath(Tag _tag, LookupError pathValue) {
        CreateSharedLinkWithSettingsError result = new CreateSharedLinkWithSettingsError();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
    }

    /**
     *
     * @param sharedLinkAlreadyExistsValue  The shared link already exists. You
     *     can call {@link DbxUserSharingRequests#listSharedLinks} to get the
     *     existing link, or use the provided metadata if it is returned.
     * @param _tag  Discriminating tag for this instance.
     */
    private CreateSharedLinkWithSettingsError withTagAndSharedLinkAlreadyExists(Tag _tag, SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsValue) {
        CreateSharedLinkWithSettingsError result = new CreateSharedLinkWithSettingsError();
        result._tag = _tag;
        result.sharedLinkAlreadyExistsValue = sharedLinkAlreadyExistsValue;
        return result;
    }

    /**
     *
     * @param settingsErrorValue  There is an error with the given settings.
     *     Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private CreateSharedLinkWithSettingsError withTagAndSettingsError(Tag _tag, SharedLinkSettingsError settingsErrorValue) {
        CreateSharedLinkWithSettingsError result = new CreateSharedLinkWithSettingsError();
        result._tag = _tag;
        result.settingsErrorValue = settingsErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code CreateSharedLinkWithSettingsError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code CreateSharedLinkWithSettingsError} with its
     *     tag set to {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static CreateSharedLinkWithSettingsError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateSharedLinkWithSettingsError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link LookupError} value associated with this instance if
     *     {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
     */
    public boolean isEmailNotVerified() {
        return this._tag == Tag.EMAIL_NOT_VERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
     */
    public boolean isSharedLinkAlreadyExists() {
        return this._tag == Tag.SHARED_LINK_ALREADY_EXISTS;
    }

    /**
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#SHARED_LINK_ALREADY_EXISTS}.
     *
     * <p> The shared link already exists. You can call {@link
     * DbxUserSharingRequests#listSharedLinks} to get the  existing link, or use
     * the provided metadata if it is returned. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code CreateSharedLinkWithSettingsError} with its
     *     tag set to {@link Tag#SHARED_LINK_ALREADY_EXISTS}.
     */
    public static CreateSharedLinkWithSettingsError sharedLinkAlreadyExists(SharedLinkAlreadyExistsMetadata value) {
        return new CreateSharedLinkWithSettingsError().withTagAndSharedLinkAlreadyExists(Tag.SHARED_LINK_ALREADY_EXISTS, value);
    }

    /**
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#SHARED_LINK_ALREADY_EXISTS}.
     *
     * <p> The shared link already exists. You can call {@link
     * DbxUserSharingRequests#listSharedLinks} to get the  existing link, or use
     * the provided metadata if it is returned. </p>
     *
     * @return Instance of {@code CreateSharedLinkWithSettingsError} with its
     *     tag set to {@link Tag#SHARED_LINK_ALREADY_EXISTS}.
     */
    public static CreateSharedLinkWithSettingsError sharedLinkAlreadyExists() {
        return sharedLinkAlreadyExists(null);
    }

    /**
     * The shared link already exists. You can call {@link
     * DbxUserSharingRequests#listSharedLinks} to get the  existing link, or use
     * the provided metadata if it is returned.
     *
     * <p> This instance must be tagged as {@link
     * Tag#SHARED_LINK_ALREADY_EXISTS}. </p>
     *
     * @return The {@link SharedLinkAlreadyExistsMetadata} value associated with
     *     this instance if {@link #isSharedLinkAlreadyExists} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSharedLinkAlreadyExists} is
     *     {@code false}.
     */
    public SharedLinkAlreadyExistsMetadata getSharedLinkAlreadyExistsValue() {
        if (this._tag != Tag.SHARED_LINK_ALREADY_EXISTS) {
            throw new IllegalStateException("Invalid tag: required Tag.SHARED_LINK_ALREADY_EXISTS, but was Tag." + this._tag.name());
        }
        return sharedLinkAlreadyExistsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SETTINGS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SETTINGS_ERROR}, {@code false} otherwise.
     */
    public boolean isSettingsError() {
        return this._tag == Tag.SETTINGS_ERROR;
    }

    /**
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#SETTINGS_ERROR}.
     *
     * <p> There is an error with the given settings. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code CreateSharedLinkWithSettingsError} with its
     *     tag set to {@link Tag#SETTINGS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static CreateSharedLinkWithSettingsError settingsError(SharedLinkSettingsError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateSharedLinkWithSettingsError().withTagAndSettingsError(Tag.SETTINGS_ERROR, value);
    }

    /**
     * There is an error with the given settings.
     *
     * <p> This instance must be tagged as {@link Tag#SETTINGS_ERROR}. </p>
     *
     * @return The {@link SharedLinkSettingsError} value associated with this
     *     instance if {@link #isSettingsError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSettingsError} is {@code
     *     false}.
     */
    public SharedLinkSettingsError getSettingsErrorValue() {
        if (this._tag != Tag.SETTINGS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.SETTINGS_ERROR, but was Tag." + this._tag.name());
        }
        return settingsErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_DENIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_DENIED}, {@code false} otherwise.
     */
    public boolean isAccessDenied() {
        return this._tag == Tag.ACCESS_DENIED;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            pathValue,
            sharedLinkAlreadyExistsValue,
            settingsErrorValue
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
        else if (obj instanceof CreateSharedLinkWithSettingsError) {
            CreateSharedLinkWithSettingsError other = (CreateSharedLinkWithSettingsError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case EMAIL_NOT_VERIFIED:
                    return true;
                case SHARED_LINK_ALREADY_EXISTS:
                    return (this.sharedLinkAlreadyExistsValue == other.sharedLinkAlreadyExistsValue) || (this.sharedLinkAlreadyExistsValue != null && this.sharedLinkAlreadyExistsValue.equals(other.sharedLinkAlreadyExistsValue));
                case SETTINGS_ERROR:
                    return (this.settingsErrorValue == other.settingsErrorValue) || (this.settingsErrorValue.equals(other.settingsErrorValue));
                case ACCESS_DENIED:
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
    static class Serializer extends UnionSerializer<CreateSharedLinkWithSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CreateSharedLinkWithSettingsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case EMAIL_NOT_VERIFIED: {
                    g.writeString("email_not_verified");
                    break;
                }
                case SHARED_LINK_ALREADY_EXISTS: {
                    g.writeStartObject();
                    writeTag("shared_link_already_exists", g);
                    g.writeFieldName("shared_link_already_exists");
                    StoneSerializers.nullable(SharedLinkAlreadyExistsMetadata.Serializer.INSTANCE).serialize(value.sharedLinkAlreadyExistsValue, g);
                    g.writeEndObject();
                    break;
                }
                case SETTINGS_ERROR: {
                    g.writeStartObject();
                    writeTag("settings_error", g);
                    g.writeFieldName("settings_error");
                    SharedLinkSettingsError.Serializer.INSTANCE.serialize(value.settingsErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case ACCESS_DENIED: {
                    g.writeString("access_denied");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public CreateSharedLinkWithSettingsError deserialize(JsonParser p) throws IOException, JsonParseException {
            CreateSharedLinkWithSettingsError value;
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
            else if ("path".equals(tag)) {
                LookupError fieldValue = null;
                expectField("path", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = CreateSharedLinkWithSettingsError.path(fieldValue);
            }
            else if ("email_not_verified".equals(tag)) {
                value = CreateSharedLinkWithSettingsError.EMAIL_NOT_VERIFIED;
            }
            else if ("shared_link_already_exists".equals(tag)) {
                SharedLinkAlreadyExistsMetadata fieldValue = null;
                if (p.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("shared_link_already_exists", p);
                    fieldValue = StoneSerializers.nullable(SharedLinkAlreadyExistsMetadata.Serializer.INSTANCE).deserialize(p);
                }
                if (fieldValue == null) {
                    value = CreateSharedLinkWithSettingsError.sharedLinkAlreadyExists();
                }
                else {
                    value = CreateSharedLinkWithSettingsError.sharedLinkAlreadyExists(fieldValue);
                }
            }
            else if ("settings_error".equals(tag)) {
                SharedLinkSettingsError fieldValue = null;
                expectField("settings_error", p);
                fieldValue = SharedLinkSettingsError.Serializer.INSTANCE.deserialize(p);
                value = CreateSharedLinkWithSettingsError.settingsError(fieldValue);
            }
            else if ("access_denied".equals(tag)) {
                value = CreateSharedLinkWithSettingsError.ACCESS_DENIED;
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
