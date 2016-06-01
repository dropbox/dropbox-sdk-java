/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.v2.files.LookupError;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class CreateSharedLinkWithSettingsError {
    // union CreateSharedLinkWithSettingsError

    /**
     * Discriminating tag type for {@link CreateSharedLinkWithSettingsError}.
     */
    public enum Tag {
        PATH, // LookupError
        /**
         * User's email should be verified
         */
        EMAIL_NOT_VERIFIED,
        /**
         * The shared link already exists
         */
        SHARED_LINK_ALREADY_EXISTS,
        /**
         * There is an error with the given settings
         */
        SETTINGS_ERROR, // SharedLinkSettingsError
        /**
         * Access to the requested path is forbidden
         */
        ACCESS_DENIED;
    }

    /**
     * User's email should be verified
     */
    public static final CreateSharedLinkWithSettingsError EMAIL_NOT_VERIFIED = new CreateSharedLinkWithSettingsError(Tag.EMAIL_NOT_VERIFIED, null, null);
    /**
     * The shared link already exists
     */
    public static final CreateSharedLinkWithSettingsError SHARED_LINK_ALREADY_EXISTS = new CreateSharedLinkWithSettingsError(Tag.SHARED_LINK_ALREADY_EXISTS, null, null);
    /**
     * Access to the requested path is forbidden
     */
    public static final CreateSharedLinkWithSettingsError ACCESS_DENIED = new CreateSharedLinkWithSettingsError(Tag.ACCESS_DENIED, null, null);

    private final Tag tag;
    private final LookupError pathValue;
    private final SharedLinkSettingsError settingsErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private CreateSharedLinkWithSettingsError(Tag tag, LookupError pathValue, SharedLinkSettingsError settingsErrorValue) {
        this.tag = tag;
        this.pathValue = pathValue;
        this.settingsErrorValue = settingsErrorValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this.tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#PATH}.
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
        return new CreateSharedLinkWithSettingsError(Tag.PATH, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link CreateSharedLinkWithSettingsError#path} value
     *     associated with this instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public LookupError getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
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
        return this.tag == Tag.EMAIL_NOT_VERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
     */
    public boolean isSharedLinkAlreadyExists() {
        return this.tag == Tag.SHARED_LINK_ALREADY_EXISTS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SETTINGS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SETTINGS_ERROR}, {@code false} otherwise.
     */
    public boolean isSettingsError() {
        return this.tag == Tag.SETTINGS_ERROR;
    }

    /**
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#SETTINGS_ERROR}.
     *
     * <p> There is an error with the given settings </p>
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
        return new CreateSharedLinkWithSettingsError(Tag.SETTINGS_ERROR, null, value);
    }

    /**
     * There is an error with the given settings
     *
     * <p> This instance must be tagged as {@link Tag#SETTINGS_ERROR}. </p>
     *
     * @return The {@link CreateSharedLinkWithSettingsError#settingsError} value
     *     associated with this instance if {@link #isSettingsError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isSettingsError} is {@code
     *     false}.
     */
    public SharedLinkSettingsError getSettingsErrorValue() {
        if (this.tag != Tag.SETTINGS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.SETTINGS_ERROR, but was Tag." + tag.name());
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
        return this.tag == Tag.ACCESS_DENIED;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            pathValue,
            settingsErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof CreateSharedLinkWithSettingsError) {
            CreateSharedLinkWithSettingsError other = (CreateSharedLinkWithSettingsError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case EMAIL_NOT_VERIFIED:
                    return true;
                case SHARED_LINK_ALREADY_EXISTS:
                    return true;
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
    static final class Serializer extends UnionSerializer<CreateSharedLinkWithSettingsError> {
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
                    g.writeString("shared_link_already_exists");
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
                value = CreateSharedLinkWithSettingsError.SHARED_LINK_ALREADY_EXISTS;
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
                expectEndObject(p);
            }
            return value;
        }
    }
}
