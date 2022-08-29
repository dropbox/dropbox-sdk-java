/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

package com.dropbox.core.v2.team;

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
 * User custom quota.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class CustomQuotaResult {
    // union team.CustomQuotaResult (team_member_space_limits.stone)

    /**
     * Discriminating tag type for {@link CustomQuotaResult}.
     */
    public enum Tag {
        /**
         * User's custom quota.
         */
        SUCCESS, // UserCustomQuotaResult
        /**
         * Invalid user (not in team).
         */
        INVALID_USER, // UserSelectorArg
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
    public static final CustomQuotaResult OTHER = new CustomQuotaResult().withTag(Tag.OTHER);

    private Tag _tag;
    private UserCustomQuotaResult successValue;
    private UserSelectorArg invalidUserValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private CustomQuotaResult() {
    }


    /**
     * User custom quota.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private CustomQuotaResult withTag(Tag _tag) {
        CustomQuotaResult result = new CustomQuotaResult();
        result._tag = _tag;
        return result;
    }

    /**
     * User custom quota.
     *
     * @param successValue  User's custom quota. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private CustomQuotaResult withTagAndSuccess(Tag _tag, UserCustomQuotaResult successValue) {
        CustomQuotaResult result = new CustomQuotaResult();
        result._tag = _tag;
        result.successValue = successValue;
        return result;
    }

    /**
     * User custom quota.
     *
     * @param invalidUserValue  Invalid user (not in team). Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private CustomQuotaResult withTagAndInvalidUser(Tag _tag, UserSelectorArg invalidUserValue) {
        CustomQuotaResult result = new CustomQuotaResult();
        result._tag = _tag;
        result.invalidUserValue = invalidUserValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code CustomQuotaResult}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#SUCCESS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#SUCCESS},
     *     {@code false} otherwise.
     */
    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    /**
     * Returns an instance of {@code CustomQuotaResult} that has its tag set to
     * {@link Tag#SUCCESS}.
     *
     * <p> User's custom quota. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code CustomQuotaResult} with its tag set to {@link
     *     Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static CustomQuotaResult success(UserCustomQuotaResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CustomQuotaResult().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * User's custom quota.
     *
     * <p> This instance must be tagged as {@link Tag#SUCCESS}. </p>
     *
     * @return The {@link UserCustomQuotaResult} value associated with this
     *     instance if {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public UserCustomQuotaResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return successValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_USER}, {@code false} otherwise.
     */
    public boolean isInvalidUser() {
        return this._tag == Tag.INVALID_USER;
    }

    /**
     * Returns an instance of {@code CustomQuotaResult} that has its tag set to
     * {@link Tag#INVALID_USER}.
     *
     * <p> Invalid user (not in team). </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code CustomQuotaResult} with its tag set to {@link
     *     Tag#INVALID_USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static CustomQuotaResult invalidUser(UserSelectorArg value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CustomQuotaResult().withTagAndInvalidUser(Tag.INVALID_USER, value);
    }

    /**
     * Invalid user (not in team).
     *
     * <p> This instance must be tagged as {@link Tag#INVALID_USER}. </p>
     *
     * @return The {@link UserSelectorArg} value associated with this instance
     *     if {@link #isInvalidUser} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInvalidUser} is {@code
     *     false}.
     */
    public UserSelectorArg getInvalidUserValue() {
        if (this._tag != Tag.INVALID_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_USER, but was Tag." + this._tag.name());
        }
        return invalidUserValue;
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
            _tag,
            successValue,
            invalidUserValue
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
        else if (obj instanceof CustomQuotaResult) {
            CustomQuotaResult other = (CustomQuotaResult) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case INVALID_USER:
                    return (this.invalidUserValue == other.invalidUserValue) || (this.invalidUserValue.equals(other.invalidUserValue));
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
    static class Serializer extends UnionSerializer<CustomQuotaResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CustomQuotaResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    UserCustomQuotaResult.Serializer.INSTANCE.serialize(value.successValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case INVALID_USER: {
                    g.writeStartObject();
                    writeTag("invalid_user", g);
                    g.writeFieldName("invalid_user");
                    UserSelectorArg.Serializer.INSTANCE.serialize(value.invalidUserValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public CustomQuotaResult deserialize(JsonParser p) throws IOException, JsonParseException {
            CustomQuotaResult value;
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
            else if ("success".equals(tag)) {
                UserCustomQuotaResult fieldValue = null;
                fieldValue = UserCustomQuotaResult.Serializer.INSTANCE.deserialize(p, true);
                value = CustomQuotaResult.success(fieldValue);
            }
            else if ("invalid_user".equals(tag)) {
                UserSelectorArg fieldValue = null;
                expectField("invalid_user", p);
                fieldValue = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                value = CustomQuotaResult.invalidUser(fieldValue);
            }
            else {
                value = CustomQuotaResult.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
