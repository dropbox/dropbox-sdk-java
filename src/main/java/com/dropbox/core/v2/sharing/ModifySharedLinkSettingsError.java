/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

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
public final class ModifySharedLinkSettingsError {
    // union ModifySharedLinkSettingsError

    /**
     * Discriminating tag type for {@link ModifySharedLinkSettingsError}.
     */
    public enum Tag {
        /**
         * The shared link wasn't found
         */
        SHARED_LINK_NOT_FOUND,
        /**
         * The caller is not allowed to access this shared link
         */
        SHARED_LINK_ACCESS_DENIED,
        OTHER,
        /**
         * There is an error with the given settings
         */
        SETTINGS_ERROR, // SharedLinkSettingsError
        /**
         * The caller's email should be verified
         */
        EMAIL_NOT_VERIFIED;
    }

    /**
     * The shared link wasn't found
     */
    public static final ModifySharedLinkSettingsError SHARED_LINK_NOT_FOUND = new ModifySharedLinkSettingsError(Tag.SHARED_LINK_NOT_FOUND, null);
    /**
     * The caller is not allowed to access this shared link
     */
    public static final ModifySharedLinkSettingsError SHARED_LINK_ACCESS_DENIED = new ModifySharedLinkSettingsError(Tag.SHARED_LINK_ACCESS_DENIED, null);
    public static final ModifySharedLinkSettingsError OTHER = new ModifySharedLinkSettingsError(Tag.OTHER, null);
    /**
     * The caller's email should be verified
     */
    public static final ModifySharedLinkSettingsError EMAIL_NOT_VERIFIED = new ModifySharedLinkSettingsError(Tag.EMAIL_NOT_VERIFIED, null);

    private final Tag tag;
    private final SharedLinkSettingsError settingsErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ModifySharedLinkSettingsError(Tag tag, SharedLinkSettingsError settingsErrorValue) {
        this.tag = tag;
        this.settingsErrorValue = settingsErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ModifySharedLinkSettingsError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isSharedLinkNotFound() {
        return this.tag == Tag.SHARED_LINK_NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
     */
    public boolean isSharedLinkAccessDenied() {
        return this.tag == Tag.SHARED_LINK_ACCESS_DENIED;
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
     * Returns an instance of {@code ModifySharedLinkSettingsError} that has its
     * tag set to {@link Tag#SETTINGS_ERROR}.
     *
     * <p> There is an error with the given settings </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ModifySharedLinkSettingsError} with its tag
     *     set to {@link Tag#SETTINGS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ModifySharedLinkSettingsError settingsError(SharedLinkSettingsError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ModifySharedLinkSettingsError(Tag.SETTINGS_ERROR, value);
    }

    /**
     * There is an error with the given settings
     *
     * <p> This instance must be tagged as {@link Tag#SETTINGS_ERROR}. </p>
     *
     * @return The {@link ModifySharedLinkSettingsError#settingsError} value
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
     * Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
     */
    public boolean isEmailNotVerified() {
        return this.tag == Tag.EMAIL_NOT_VERIFIED;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            settingsErrorValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ModifySharedLinkSettingsError) {
            ModifySharedLinkSettingsError other = (ModifySharedLinkSettingsError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case SHARED_LINK_NOT_FOUND:
                    return true;
                case SHARED_LINK_ACCESS_DENIED:
                    return true;
                case OTHER:
                    return true;
                case SETTINGS_ERROR:
                    return (this.settingsErrorValue == other.settingsErrorValue) || (this.settingsErrorValue.equals(other.settingsErrorValue));
                case EMAIL_NOT_VERIFIED:
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
    static final class Serializer extends UnionSerializer<ModifySharedLinkSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ModifySharedLinkSettingsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SHARED_LINK_NOT_FOUND: {
                    g.writeString("shared_link_not_found");
                    break;
                }
                case SHARED_LINK_ACCESS_DENIED: {
                    g.writeString("shared_link_access_denied");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
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
                case EMAIL_NOT_VERIFIED: {
                    g.writeString("email_not_verified");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public ModifySharedLinkSettingsError deserialize(JsonParser p) throws IOException, JsonParseException {
            ModifySharedLinkSettingsError value;
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
            else if ("shared_link_not_found".equals(tag)) {
                value = ModifySharedLinkSettingsError.SHARED_LINK_NOT_FOUND;
            }
            else if ("shared_link_access_denied".equals(tag)) {
                value = ModifySharedLinkSettingsError.SHARED_LINK_ACCESS_DENIED;
            }
            else if ("other".equals(tag)) {
                value = ModifySharedLinkSettingsError.OTHER;
            }
            else if ("settings_error".equals(tag)) {
                SharedLinkSettingsError fieldValue = null;
                expectField("settings_error", p);
                fieldValue = SharedLinkSettingsError.Serializer.INSTANCE.deserialize(p);
                value = ModifySharedLinkSettingsError.settingsError(fieldValue);
            }
            else if ("email_not_verified".equals(tag)) {
                value = ModifySharedLinkSettingsError.EMAIL_NOT_VERIFIED;
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
