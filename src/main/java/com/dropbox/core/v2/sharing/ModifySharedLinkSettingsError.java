/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

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
        /**
         * An unspecified error
         */
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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("settings_error", Tag.SETTINGS_ERROR);
        VALUES_.put("email_not_verified", Tag.EMAIL_NOT_VERIFIED);
    }

    public static final ModifySharedLinkSettingsError SHARED_LINK_NOT_FOUND = new ModifySharedLinkSettingsError(Tag.SHARED_LINK_NOT_FOUND, null);
    public static final ModifySharedLinkSettingsError SHARED_LINK_ACCESS_DENIED = new ModifySharedLinkSettingsError(Tag.SHARED_LINK_ACCESS_DENIED, null);
    public static final ModifySharedLinkSettingsError OTHER = new ModifySharedLinkSettingsError(Tag.OTHER, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code ModifySharedLinkSettingsError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isSharedLinkNotFound() {
        return this.tag == Tag.SHARED_LINK_NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
     */
    public boolean isSharedLinkAccessDenied() {
        return this.tag == Tag.SHARED_LINK_ACCESS_DENIED;
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

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SETTINGS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link ModifySharedLinkSettingsError#settingsError} value
     *     to assign to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ModifySharedLinkSettingsError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ModifySharedLinkSettingsError> _JSON_WRITER = new JsonWriter<ModifySharedLinkSettingsError>() {
        public final void write(ModifySharedLinkSettingsError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case SHARED_LINK_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_link_not_found");
                    g.writeEndObject();
                    break;
                case SHARED_LINK_ACCESS_DENIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_link_access_denied");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
                case SETTINGS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("settings_error");
                    g.writeFieldName("settings_error");
                    SharedLinkSettingsError._JSON_WRITER.write(x.getSettingsErrorValue(), g);
                    g.writeEndObject();
                    break;
                case EMAIL_NOT_VERIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email_not_verified");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<ModifySharedLinkSettingsError> _JSON_READER = new JsonReader<ModifySharedLinkSettingsError>() {

        public final ModifySharedLinkSettingsError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case SHARED_LINK_NOT_FOUND: return ModifySharedLinkSettingsError.SHARED_LINK_NOT_FOUND;
                    case SHARED_LINK_ACCESS_DENIED: return ModifySharedLinkSettingsError.SHARED_LINK_ACCESS_DENIED;
                    case OTHER: return ModifySharedLinkSettingsError.OTHER;
                    case EMAIL_NOT_VERIFIED: return ModifySharedLinkSettingsError.EMAIL_NOT_VERIFIED;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            ModifySharedLinkSettingsError value = null;
            if (tag != null) {
                switch (tag) {
                    case SHARED_LINK_NOT_FOUND: {
                        value = ModifySharedLinkSettingsError.SHARED_LINK_NOT_FOUND;
                        break;
                    }
                    case SHARED_LINK_ACCESS_DENIED: {
                        value = ModifySharedLinkSettingsError.SHARED_LINK_ACCESS_DENIED;
                        break;
                    }
                    case OTHER: {
                        value = ModifySharedLinkSettingsError.OTHER;
                        break;
                    }
                    case SETTINGS_ERROR: {
                        SharedLinkSettingsError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharedLinkSettingsError._JSON_READER
                            .readField(parser, "settings_error", v);
                        value = ModifySharedLinkSettingsError.settingsError(v);
                        break;
                    }
                    case EMAIL_NOT_VERIFIED: {
                        value = ModifySharedLinkSettingsError.EMAIL_NOT_VERIFIED;
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
