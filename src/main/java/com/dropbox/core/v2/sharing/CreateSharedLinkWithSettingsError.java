/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;
import com.dropbox.core.v2.files.LookupError;

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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
@JsonSerialize(using=CreateSharedLinkWithSettingsError.Serializer.class)
@JsonDeserialize(using=CreateSharedLinkWithSettingsError.Deserializer.class)
public final class CreateSharedLinkWithSettingsError {
    // union CreateSharedLinkWithSettingsError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends UnionJsonSerializer<CreateSharedLinkWithSettingsError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(CreateSharedLinkWithSettingsError.class);
        }

        @Override
        public void serialize(CreateSharedLinkWithSettingsError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case PATH:
                    g.writeStartObject();
                    g.writeStringField(".tag", "path");
                    g.writeObjectField("path", value.pathValue);
                    g.writeEndObject();
                    break;
                case EMAIL_NOT_VERIFIED:
                    g.writeString("email_not_verified");
                    break;
                case SHARED_LINK_ALREADY_EXISTS:
                    g.writeString("shared_link_already_exists");
                    break;
                case SETTINGS_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "settings_error");
                    g.writeObjectField("settings_error", value.settingsErrorValue);
                    g.writeEndObject();
                    break;
                case ACCESS_DENIED:
                    g.writeString("access_denied");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<CreateSharedLinkWithSettingsError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(CreateSharedLinkWithSettingsError.class, getTagMapping(), null);
        }

        @Override
        public CreateSharedLinkWithSettingsError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case PATH: {
                    LookupError value = null;
                    expectField(_p, "path");
                    value = _p.readValueAs(LookupError.class);
                    _p.nextToken();
                    return CreateSharedLinkWithSettingsError.path(value);
                }
                case EMAIL_NOT_VERIFIED: {
                    return CreateSharedLinkWithSettingsError.EMAIL_NOT_VERIFIED;
                }
                case SHARED_LINK_ALREADY_EXISTS: {
                    return CreateSharedLinkWithSettingsError.SHARED_LINK_ALREADY_EXISTS;
                }
                case SETTINGS_ERROR: {
                    SharedLinkSettingsError value = null;
                    expectField(_p, "settings_error");
                    value = _p.readValueAs(SharedLinkSettingsError.class);
                    _p.nextToken();
                    return CreateSharedLinkWithSettingsError.settingsError(value);
                }
                case ACCESS_DENIED: {
                    return CreateSharedLinkWithSettingsError.ACCESS_DENIED;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, CreateSharedLinkWithSettingsError.Tag> getTagMapping() {
            Map<String, CreateSharedLinkWithSettingsError.Tag> values = new HashMap<String, CreateSharedLinkWithSettingsError.Tag>();
            values.put("path", CreateSharedLinkWithSettingsError.Tag.PATH);
            values.put("email_not_verified", CreateSharedLinkWithSettingsError.Tag.EMAIL_NOT_VERIFIED);
            values.put("shared_link_already_exists", CreateSharedLinkWithSettingsError.Tag.SHARED_LINK_ALREADY_EXISTS);
            values.put("settings_error", CreateSharedLinkWithSettingsError.Tag.SETTINGS_ERROR);
            values.put("access_denied", CreateSharedLinkWithSettingsError.Tag.ACCESS_DENIED);
            return Collections.unmodifiableMap(values);
        }
    }
}
