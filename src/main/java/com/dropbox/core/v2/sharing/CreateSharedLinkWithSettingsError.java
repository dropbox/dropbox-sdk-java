/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.v2.files.LookupError;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("path", Tag.PATH);
        VALUES_.put("email_not_verified", Tag.EMAIL_NOT_VERIFIED);
        VALUES_.put("shared_link_already_exists", Tag.SHARED_LINK_ALREADY_EXISTS);
        VALUES_.put("settings_error", Tag.SETTINGS_ERROR);
        VALUES_.put("access_denied", Tag.ACCESS_DENIED);
    }

    public static final CreateSharedLinkWithSettingsError EMAIL_NOT_VERIFIED = new CreateSharedLinkWithSettingsError(Tag.EMAIL_NOT_VERIFIED, null, null);
    public static final CreateSharedLinkWithSettingsError SHARED_LINK_ALREADY_EXISTS = new CreateSharedLinkWithSettingsError(Tag.SHARED_LINK_ALREADY_EXISTS, null, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code CreateSharedLinkWithSettingsError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this.tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#PATH}.
     *
     * @param value  {@link CreateSharedLinkWithSettingsError#path} value to
     *     assign to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
     */
    public boolean isEmailNotVerified() {
        return this.tag == Tag.EMAIL_NOT_VERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
     */
    public boolean isSharedLinkAlreadyExists() {
        return this.tag == Tag.SHARED_LINK_ALREADY_EXISTS;
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
     * Returns an instance of {@code CreateSharedLinkWithSettingsError} that has
     * its tag set to {@link Tag#SETTINGS_ERROR}.
     *
     * <p> There is an error with the given settings </p>
     *
     * @param value  {@link CreateSharedLinkWithSettingsError#settingsError}
     *     value to assign to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static CreateSharedLinkWithSettingsError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<CreateSharedLinkWithSettingsError> _JSON_WRITER = new JsonWriter<CreateSharedLinkWithSettingsError>() {
        public final void write(CreateSharedLinkWithSettingsError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("path");
                    g.writeFieldName("path");
                    LookupError._JSON_WRITER.write(x.getPathValue(), g);
                    g.writeEndObject();
                    break;
                case EMAIL_NOT_VERIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email_not_verified");
                    g.writeEndObject();
                    break;
                case SHARED_LINK_ALREADY_EXISTS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_link_already_exists");
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
                case ACCESS_DENIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_denied");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<CreateSharedLinkWithSettingsError> _JSON_READER = new JsonReader<CreateSharedLinkWithSettingsError>() {

        public final CreateSharedLinkWithSettingsError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case EMAIL_NOT_VERIFIED: return CreateSharedLinkWithSettingsError.EMAIL_NOT_VERIFIED;
                    case SHARED_LINK_ALREADY_EXISTS: return CreateSharedLinkWithSettingsError.SHARED_LINK_ALREADY_EXISTS;
                    case ACCESS_DENIED: return CreateSharedLinkWithSettingsError.ACCESS_DENIED;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            CreateSharedLinkWithSettingsError value = null;
            if (tag != null) {
                switch (tag) {
                    case PATH: {
                        LookupError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = LookupError._JSON_READER
                            .readField(parser, "path", v);
                        value = CreateSharedLinkWithSettingsError.path(v);
                        break;
                    }
                    case EMAIL_NOT_VERIFIED: {
                        value = CreateSharedLinkWithSettingsError.EMAIL_NOT_VERIFIED;
                        break;
                    }
                    case SHARED_LINK_ALREADY_EXISTS: {
                        value = CreateSharedLinkWithSettingsError.SHARED_LINK_ALREADY_EXISTS;
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
                        value = CreateSharedLinkWithSettingsError.settingsError(v);
                        break;
                    }
                    case ACCESS_DENIED: {
                        value = CreateSharedLinkWithSettingsError.ACCESS_DENIED;
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
