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
import java.util.regex.Pattern;

/**
 * Result of trying to resend verification email to a secondary email address.
 * 'success' is the only value indicating that a verification email was
 * successfully sent. The other values explain the type of error that occurred,
 * and include the email for which the error occurred.
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
public final class ResendSecondaryEmailResult {
    // union team.ResendSecondaryEmailResult (team_secondary_mails.stone)

    /**
     * Discriminating tag type for {@link ResendSecondaryEmailResult}.
     */
    public enum Tag {
        /**
         * A verification email was successfully sent to the secondary email
         * address.
         */
        SUCCESS, // String
        /**
         * This secondary email address is not pending for the user.
         */
        NOT_PENDING, // String
        /**
         * Too many emails are being sent to this email address. Please try
         * again later.
         */
        RATE_LIMITED, // String
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
    public static final ResendSecondaryEmailResult OTHER = new ResendSecondaryEmailResult().withTag(Tag.OTHER);

    private Tag _tag;
    private String successValue;
    private String notPendingValue;
    private String rateLimitedValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ResendSecondaryEmailResult() {
    }


    /**
     * Result of trying to resend verification email to a secondary email
     * address. 'success' is the only value indicating that a verification email
     * was successfully sent. The other values explain the type of error that
     * occurred, and include the email for which the error occurred.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ResendSecondaryEmailResult withTag(Tag _tag) {
        ResendSecondaryEmailResult result = new ResendSecondaryEmailResult();
        result._tag = _tag;
        return result;
    }

    /**
     * Result of trying to resend verification email to a secondary email
     * address. 'success' is the only value indicating that a verification email
     * was successfully sent. The other values explain the type of error that
     * occurred, and include the email for which the error occurred.
     *
     * @param successValue  A verification email was successfully sent to the
     *     secondary email address. Must have length of at most 255, match
     *     pattern "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ResendSecondaryEmailResult withTagAndSuccess(Tag _tag, String successValue) {
        ResendSecondaryEmailResult result = new ResendSecondaryEmailResult();
        result._tag = _tag;
        result.successValue = successValue;
        return result;
    }

    /**
     * Result of trying to resend verification email to a secondary email
     * address. 'success' is the only value indicating that a verification email
     * was successfully sent. The other values explain the type of error that
     * occurred, and include the email for which the error occurred.
     *
     * @param notPendingValue  This secondary email address is not pending for
     *     the user. Must have length of at most 255, match pattern "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ResendSecondaryEmailResult withTagAndNotPending(Tag _tag, String notPendingValue) {
        ResendSecondaryEmailResult result = new ResendSecondaryEmailResult();
        result._tag = _tag;
        result.notPendingValue = notPendingValue;
        return result;
    }

    /**
     * Result of trying to resend verification email to a secondary email
     * address. 'success' is the only value indicating that a verification email
     * was successfully sent. The other values explain the type of error that
     * occurred, and include the email for which the error occurred.
     *
     * @param rateLimitedValue  Too many emails are being sent to this email
     *     address. Please try again later. Must have length of at most 255,
     *     match pattern "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ResendSecondaryEmailResult withTagAndRateLimited(Tag _tag, String rateLimitedValue) {
        ResendSecondaryEmailResult result = new ResendSecondaryEmailResult();
        result._tag = _tag;
        result.rateLimitedValue = rateLimitedValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ResendSecondaryEmailResult}. </p>
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
     * Returns an instance of {@code ResendSecondaryEmailResult} that has its
     * tag set to {@link Tag#SUCCESS}.
     *
     * <p> A verification email was successfully sent to the secondary email
     * address. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ResendSecondaryEmailResult} with its tag set
     *     to {@link Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['#&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static ResendSecondaryEmailResult success(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ResendSecondaryEmailResult().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * A verification email was successfully sent to the secondary email
     * address.
     *
     * <p> This instance must be tagged as {@link Tag#SUCCESS}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public String getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return successValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NOT_PENDING}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NOT_PENDING}, {@code false} otherwise.
     */
    public boolean isNotPending() {
        return this._tag == Tag.NOT_PENDING;
    }

    /**
     * Returns an instance of {@code ResendSecondaryEmailResult} that has its
     * tag set to {@link Tag#NOT_PENDING}.
     *
     * <p> This secondary email address is not pending for the user. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ResendSecondaryEmailResult} with its tag set
     *     to {@link Tag#NOT_PENDING}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['#&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static ResendSecondaryEmailResult notPending(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ResendSecondaryEmailResult().withTagAndNotPending(Tag.NOT_PENDING, value);
    }

    /**
     * This secondary email address is not pending for the user.
     *
     * <p> This instance must be tagged as {@link Tag#NOT_PENDING}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isNotPending} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isNotPending} is {@code false}.
     */
    public String getNotPendingValue() {
        if (this._tag != Tag.NOT_PENDING) {
            throw new IllegalStateException("Invalid tag: required Tag.NOT_PENDING, but was Tag." + this._tag.name());
        }
        return notPendingValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#RATE_LIMITED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RATE_LIMITED}, {@code false} otherwise.
     */
    public boolean isRateLimited() {
        return this._tag == Tag.RATE_LIMITED;
    }

    /**
     * Returns an instance of {@code ResendSecondaryEmailResult} that has its
     * tag set to {@link Tag#RATE_LIMITED}.
     *
     * <p> Too many emails are being sent to this email address. Please try
     * again later. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ResendSecondaryEmailResult} with its tag set
     *     to {@link Tag#RATE_LIMITED}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['#&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static ResendSecondaryEmailResult rateLimited(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ResendSecondaryEmailResult().withTagAndRateLimited(Tag.RATE_LIMITED, value);
    }

    /**
     * Too many emails are being sent to this email address. Please try again
     * later.
     *
     * <p> This instance must be tagged as {@link Tag#RATE_LIMITED}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isRateLimited} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isRateLimited} is {@code
     *     false}.
     */
    public String getRateLimitedValue() {
        if (this._tag != Tag.RATE_LIMITED) {
            throw new IllegalStateException("Invalid tag: required Tag.RATE_LIMITED, but was Tag." + this._tag.name());
        }
        return rateLimitedValue;
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
            notPendingValue,
            rateLimitedValue
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
        else if (obj instanceof ResendSecondaryEmailResult) {
            ResendSecondaryEmailResult other = (ResendSecondaryEmailResult) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case NOT_PENDING:
                    return (this.notPendingValue == other.notPendingValue) || (this.notPendingValue.equals(other.notPendingValue));
                case RATE_LIMITED:
                    return (this.rateLimitedValue == other.rateLimitedValue) || (this.rateLimitedValue.equals(other.rateLimitedValue));
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
    static class Serializer extends UnionSerializer<ResendSecondaryEmailResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ResendSecondaryEmailResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    g.writeFieldName("success");
                    StoneSerializers.string().serialize(value.successValue, g);
                    g.writeEndObject();
                    break;
                }
                case NOT_PENDING: {
                    g.writeStartObject();
                    writeTag("not_pending", g);
                    g.writeFieldName("not_pending");
                    StoneSerializers.string().serialize(value.notPendingValue, g);
                    g.writeEndObject();
                    break;
                }
                case RATE_LIMITED: {
                    g.writeStartObject();
                    writeTag("rate_limited", g);
                    g.writeFieldName("rate_limited");
                    StoneSerializers.string().serialize(value.rateLimitedValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ResendSecondaryEmailResult deserialize(JsonParser p) throws IOException, JsonParseException {
            ResendSecondaryEmailResult value;
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
                String fieldValue = null;
                expectField("success", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = ResendSecondaryEmailResult.success(fieldValue);
            }
            else if ("not_pending".equals(tag)) {
                String fieldValue = null;
                expectField("not_pending", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = ResendSecondaryEmailResult.notPending(fieldValue);
            }
            else if ("rate_limited".equals(tag)) {
                String fieldValue = null;
                expectField("rate_limited", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = ResendSecondaryEmailResult.rateLimited(fieldValue);
            }
            else {
                value = ResendSecondaryEmailResult.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
