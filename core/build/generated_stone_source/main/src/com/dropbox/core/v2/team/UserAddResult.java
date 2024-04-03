/* DO NOT EDIT */
/* This file was generated from team_secondary_mails.stone */

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
 * Result of trying to add secondary emails to a user. 'success' is the only
 * value indicating that a user was successfully retrieved for adding secondary
 * emails. The other values explain the type of error that occurred, and include
 * the user for which the error occurred.
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
public final class UserAddResult {
    // union team.UserAddResult (team_secondary_mails.stone)

    /**
     * Discriminating tag type for {@link UserAddResult}.
     */
    public enum Tag {
        /**
         * Describes a user and the results for each attempt to add a secondary
         * email.
         */
        SUCCESS, // UserSecondaryEmailsResult
        /**
         * Specified user is not a valid target for adding secondary emails.
         */
        INVALID_USER, // UserSelectorArg
        /**
         * Secondary emails can only be added to verified users.
         */
        UNVERIFIED, // UserSelectorArg
        /**
         * Secondary emails cannot be added to placeholder users.
         */
        PLACEHOLDER_USER, // UserSelectorArg
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
    public static final UserAddResult OTHER = new UserAddResult().withTag(Tag.OTHER);

    private Tag _tag;
    private UserSecondaryEmailsResult successValue;
    private UserSelectorArg invalidUserValue;
    private UserSelectorArg unverifiedValue;
    private UserSelectorArg placeholderUserValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UserAddResult() {
    }


    /**
     * Result of trying to add secondary emails to a user. 'success' is the only
     * value indicating that a user was successfully retrieved for adding
     * secondary emails. The other values explain the type of error that
     * occurred, and include the user for which the error occurred.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UserAddResult withTag(Tag _tag) {
        UserAddResult result = new UserAddResult();
        result._tag = _tag;
        return result;
    }

    /**
     * Result of trying to add secondary emails to a user. 'success' is the only
     * value indicating that a user was successfully retrieved for adding
     * secondary emails. The other values explain the type of error that
     * occurred, and include the user for which the error occurred.
     *
     * @param successValue  Describes a user and the results for each attempt to
     *     add a secondary email. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserAddResult withTagAndSuccess(Tag _tag, UserSecondaryEmailsResult successValue) {
        UserAddResult result = new UserAddResult();
        result._tag = _tag;
        result.successValue = successValue;
        return result;
    }

    /**
     * Result of trying to add secondary emails to a user. 'success' is the only
     * value indicating that a user was successfully retrieved for adding
     * secondary emails. The other values explain the type of error that
     * occurred, and include the user for which the error occurred.
     *
     * @param invalidUserValue  Specified user is not a valid target for adding
     *     secondary emails. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserAddResult withTagAndInvalidUser(Tag _tag, UserSelectorArg invalidUserValue) {
        UserAddResult result = new UserAddResult();
        result._tag = _tag;
        result.invalidUserValue = invalidUserValue;
        return result;
    }

    /**
     * Result of trying to add secondary emails to a user. 'success' is the only
     * value indicating that a user was successfully retrieved for adding
     * secondary emails. The other values explain the type of error that
     * occurred, and include the user for which the error occurred.
     *
     * @param unverifiedValue  Secondary emails can only be added to verified
     *     users. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserAddResult withTagAndUnverified(Tag _tag, UserSelectorArg unverifiedValue) {
        UserAddResult result = new UserAddResult();
        result._tag = _tag;
        result.unverifiedValue = unverifiedValue;
        return result;
    }

    /**
     * Result of trying to add secondary emails to a user. 'success' is the only
     * value indicating that a user was successfully retrieved for adding
     * secondary emails. The other values explain the type of error that
     * occurred, and include the user for which the error occurred.
     *
     * @param placeholderUserValue  Secondary emails cannot be added to
     *     placeholder users. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserAddResult withTagAndPlaceholderUser(Tag _tag, UserSelectorArg placeholderUserValue) {
        UserAddResult result = new UserAddResult();
        result._tag = _tag;
        result.placeholderUserValue = placeholderUserValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UserAddResult}. </p>
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
     * Returns an instance of {@code UserAddResult} that has its tag set to
     * {@link Tag#SUCCESS}.
     *
     * <p> Describes a user and the results for each attempt to add a secondary
     * email. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserAddResult} with its tag set to {@link
     *     Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserAddResult success(UserSecondaryEmailsResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * Describes a user and the results for each attempt to add a secondary
     * email.
     *
     * <p> This instance must be tagged as {@link Tag#SUCCESS}. </p>
     *
     * @return The {@link UserSecondaryEmailsResult} value associated with this
     *     instance if {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public UserSecondaryEmailsResult getSuccessValue() {
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
     * Returns an instance of {@code UserAddResult} that has its tag set to
     * {@link Tag#INVALID_USER}.
     *
     * <p> Specified user is not a valid target for adding secondary emails.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserAddResult} with its tag set to {@link
     *     Tag#INVALID_USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserAddResult invalidUser(UserSelectorArg value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndInvalidUser(Tag.INVALID_USER, value);
    }

    /**
     * Specified user is not a valid target for adding secondary emails.
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
     * Returns {@code true} if this instance has the tag {@link Tag#UNVERIFIED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isUnverified() {
        return this._tag == Tag.UNVERIFIED;
    }

    /**
     * Returns an instance of {@code UserAddResult} that has its tag set to
     * {@link Tag#UNVERIFIED}.
     *
     * <p> Secondary emails can only be added to verified users. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserAddResult} with its tag set to {@link
     *     Tag#UNVERIFIED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserAddResult unverified(UserSelectorArg value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndUnverified(Tag.UNVERIFIED, value);
    }

    /**
     * Secondary emails can only be added to verified users.
     *
     * <p> This instance must be tagged as {@link Tag#UNVERIFIED}. </p>
     *
     * @return The {@link UserSelectorArg} value associated with this instance
     *     if {@link #isUnverified} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUnverified} is {@code false}.
     */
    public UserSelectorArg getUnverifiedValue() {
        if (this._tag != Tag.UNVERIFIED) {
            throw new IllegalStateException("Invalid tag: required Tag.UNVERIFIED, but was Tag." + this._tag.name());
        }
        return unverifiedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PLACEHOLDER_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PLACEHOLDER_USER}, {@code false} otherwise.
     */
    public boolean isPlaceholderUser() {
        return this._tag == Tag.PLACEHOLDER_USER;
    }

    /**
     * Returns an instance of {@code UserAddResult} that has its tag set to
     * {@link Tag#PLACEHOLDER_USER}.
     *
     * <p> Secondary emails cannot be added to placeholder users. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserAddResult} with its tag set to {@link
     *     Tag#PLACEHOLDER_USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserAddResult placeholderUser(UserSelectorArg value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndPlaceholderUser(Tag.PLACEHOLDER_USER, value);
    }

    /**
     * Secondary emails cannot be added to placeholder users.
     *
     * <p> This instance must be tagged as {@link Tag#PLACEHOLDER_USER}. </p>
     *
     * @return The {@link UserSelectorArg} value associated with this instance
     *     if {@link #isPlaceholderUser} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPlaceholderUser} is {@code
     *     false}.
     */
    public UserSelectorArg getPlaceholderUserValue() {
        if (this._tag != Tag.PLACEHOLDER_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.PLACEHOLDER_USER, but was Tag." + this._tag.name());
        }
        return placeholderUserValue;
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
            this.successValue,
            this.invalidUserValue,
            this.unverifiedValue,
            this.placeholderUserValue
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
        else if (obj instanceof UserAddResult) {
            UserAddResult other = (UserAddResult) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case INVALID_USER:
                    return (this.invalidUserValue == other.invalidUserValue) || (this.invalidUserValue.equals(other.invalidUserValue));
                case UNVERIFIED:
                    return (this.unverifiedValue == other.unverifiedValue) || (this.unverifiedValue.equals(other.unverifiedValue));
                case PLACEHOLDER_USER:
                    return (this.placeholderUserValue == other.placeholderUserValue) || (this.placeholderUserValue.equals(other.placeholderUserValue));
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
    static class Serializer extends UnionSerializer<UserAddResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserAddResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    UserSecondaryEmailsResult.Serializer.INSTANCE.serialize(value.successValue, g, true);
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
                case UNVERIFIED: {
                    g.writeStartObject();
                    writeTag("unverified", g);
                    g.writeFieldName("unverified");
                    UserSelectorArg.Serializer.INSTANCE.serialize(value.unverifiedValue, g);
                    g.writeEndObject();
                    break;
                }
                case PLACEHOLDER_USER: {
                    g.writeStartObject();
                    writeTag("placeholder_user", g);
                    g.writeFieldName("placeholder_user");
                    UserSelectorArg.Serializer.INSTANCE.serialize(value.placeholderUserValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UserAddResult deserialize(JsonParser p) throws IOException, JsonParseException {
            UserAddResult value;
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
                UserSecondaryEmailsResult fieldValue = null;
                fieldValue = UserSecondaryEmailsResult.Serializer.INSTANCE.deserialize(p, true);
                value = UserAddResult.success(fieldValue);
            }
            else if ("invalid_user".equals(tag)) {
                UserSelectorArg fieldValue = null;
                expectField("invalid_user", p);
                fieldValue = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                value = UserAddResult.invalidUser(fieldValue);
            }
            else if ("unverified".equals(tag)) {
                UserSelectorArg fieldValue = null;
                expectField("unverified", p);
                fieldValue = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                value = UserAddResult.unverified(fieldValue);
            }
            else if ("placeholder_user".equals(tag)) {
                UserSelectorArg fieldValue = null;
                expectField("placeholder_user", p);
                fieldValue = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                value = UserAddResult.placeholderUser(fieldValue);
            }
            else {
                value = UserAddResult.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
