/* DO NOT EDIT */
/* This file was generated from openid_openid_types.stone */

package com.dropbox.core.v2.openid;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

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
public final class UserInfoError {
    // union openid.UserInfoError (openid_openid_types.stone)

    /**
     * Discriminating tag type for {@link UserInfoError}.
     */
    public enum Tag {
        OPENID_ERROR, // OpenIdError
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
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UserInfoError OTHER = new UserInfoError().withTag(Tag.OTHER);

    private Tag _tag;
    private OpenIdError openidErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UserInfoError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UserInfoError withTag(Tag _tag) {
        UserInfoError result = new UserInfoError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param openidErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserInfoError withTagAndOpenidError(Tag _tag, OpenIdError openidErrorValue) {
        UserInfoError result = new UserInfoError();
        result._tag = _tag;
        result.openidErrorValue = openidErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UserInfoError}. </p>
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
     * Tag#OPENID_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#OPENID_ERROR}, {@code false} otherwise.
     */
    public boolean isOpenidError() {
        return this._tag == Tag.OPENID_ERROR;
    }

    /**
     * Returns an instance of {@code UserInfoError} that has its tag set to
     * {@link Tag#OPENID_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserInfoError} with its tag set to {@link
     *     Tag#OPENID_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserInfoError openidError(OpenIdError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserInfoError().withTagAndOpenidError(Tag.OPENID_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#OPENID_ERROR}.
     *
     * @return The {@link OpenIdError} value associated with this instance if
     *     {@link #isOpenidError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isOpenidError} is {@code
     *     false}.
     */
    public OpenIdError getOpenidErrorValue() {
        if (this._tag != Tag.OPENID_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.OPENID_ERROR, but was Tag." + this._tag.name());
        }
        return openidErrorValue;
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
            this.openidErrorValue
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
        else if (obj instanceof UserInfoError) {
            UserInfoError other = (UserInfoError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case OPENID_ERROR:
                    return (this.openidErrorValue == other.openidErrorValue) || (this.openidErrorValue.equals(other.openidErrorValue));
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
    static class Serializer extends UnionSerializer<UserInfoError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserInfoError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case OPENID_ERROR: {
                    g.writeStartObject();
                    writeTag("openid_error", g);
                    g.writeFieldName("openid_error");
                    OpenIdError.Serializer.INSTANCE.serialize(value.openidErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UserInfoError deserialize(JsonParser p) throws IOException, JsonParseException {
            UserInfoError value;
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
            else if ("openid_error".equals(tag)) {
                OpenIdError fieldValue = null;
                expectField("openid_error", p);
                fieldValue = OpenIdError.Serializer.INSTANCE.deserialize(p);
                value = UserInfoError.openidError(fieldValue);
            }
            else {
                value = UserInfoError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
