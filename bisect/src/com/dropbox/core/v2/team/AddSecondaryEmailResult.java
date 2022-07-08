/* DO NOT EDIT */
/* This file was generated from team_secondary_mails.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.v2.secondaryemails.SecondaryEmail;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Result of trying to add a secondary email to a user. 'success' is the only
 * value indicating that a secondary email was successfully added to a user. The
 * other values explain the type of error that occurred, and include the email
 * for which the error occured.
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
public final class AddSecondaryEmailResult {
    // union team.AddSecondaryEmailResult (team_secondary_mails.stone)

    /**
     * Discriminating tag type for {@link AddSecondaryEmailResult}.
     */
    public enum Tag {
        /**
         * Describes a secondary email that was successfully added to a user.
         */
        SUCCESS, // SecondaryEmail
        /**
         * Secondary email is not available to be claimed by the user.
         */
        UNAVAILABLE, // String
        /**
         * Secondary email is already a pending email for the user.
         */
        ALREADY_PENDING, // String
        /**
         * Secondary email is already a verified email for the user.
         */
        ALREADY_OWNED_BY_USER, // String
        /**
         * User already has the maximum number of secondary emails allowed.
         */
        REACHED_LIMIT, // String
        /**
         * A transient error occurred. Please try again later.
         */
        TRANSIENT_ERROR, // String
        /**
         * An error occurred due to conflicting updates. Please try again later.
         */
        TOO_MANY_UPDATES, // String
        /**
         * An unknown error occurred.
         */
        UNKNOWN_ERROR, // String
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
    public static final AddSecondaryEmailResult OTHER = new AddSecondaryEmailResult().withTag(Tag.OTHER);

    private Tag _tag;
    private SecondaryEmail successValue;
    private String unavailableValue;
    private String alreadyPendingValue;
    private String alreadyOwnedByUserValue;
    private String reachedLimitValue;
    private String transientErrorValue;
    private String tooManyUpdatesValue;
    private String unknownErrorValue;
    private String rateLimitedValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private AddSecondaryEmailResult() {
    }


    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private AddSecondaryEmailResult withTag(Tag _tag) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param successValue  Describes a secondary email that was successfully
     *     added to a user. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndSuccess(Tag _tag, SecondaryEmail successValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.successValue = successValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param unavailableValue  Secondary email is not available to be claimed
     *     by the user. Must have length of at most 255, match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndUnavailable(Tag _tag, String unavailableValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.unavailableValue = unavailableValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param alreadyPendingValue  Secondary email is already a pending email
     *     for the user. Must have length of at most 255, match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndAlreadyPending(Tag _tag, String alreadyPendingValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.alreadyPendingValue = alreadyPendingValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param alreadyOwnedByUserValue  Secondary email is already a verified
     *     email for the user. Must have length of at most 255, match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndAlreadyOwnedByUser(Tag _tag, String alreadyOwnedByUserValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.alreadyOwnedByUserValue = alreadyOwnedByUserValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param reachedLimitValue  User already has the maximum number of
     *     secondary emails allowed. Must have length of at most 255, match
     *     pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndReachedLimit(Tag _tag, String reachedLimitValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.reachedLimitValue = reachedLimitValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param transientErrorValue  A transient error occurred. Please try again
     *     later. Must have length of at most 255, match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndTransientError(Tag _tag, String transientErrorValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.transientErrorValue = transientErrorValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param tooManyUpdatesValue  An error occurred due to conflicting updates.
     *     Please try again later. Must have length of at most 255, match
     *     pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndTooManyUpdates(Tag _tag, String tooManyUpdatesValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.tooManyUpdatesValue = tooManyUpdatesValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param unknownErrorValue  An unknown error occurred. Must have length of
     *     at most 255, match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndUnknownError(Tag _tag, String unknownErrorValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
        result._tag = _tag;
        result.unknownErrorValue = unknownErrorValue;
        return result;
    }

    /**
     * Result of trying to add a secondary email to a user. 'success' is the
     * only value indicating that a secondary email was successfully added to a
     * user. The other values explain the type of error that occurred, and
     * include the email for which the error occured.
     *
     * @param rateLimitedValue  Too many emails are being sent to this email
     *     address. Please try again later. Must have length of at most 255,
     *     match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddSecondaryEmailResult withTagAndRateLimited(Tag _tag, String rateLimitedValue) {
        AddSecondaryEmailResult result = new AddSecondaryEmailResult();
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
     * values for this {@code AddSecondaryEmailResult}. </p>
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
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#SUCCESS}.
     *
     * <p> Describes a secondary email that was successfully added to a user.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AddSecondaryEmailResult success(SecondaryEmail value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddSecondaryEmailResult().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * Describes a secondary email that was successfully added to a user.
     *
     * <p> This instance must be tagged as {@link Tag#SUCCESS}. </p>
     *
     * @return The {@link SecondaryEmail} value associated with this instance if
     *     {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public SecondaryEmail getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return successValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNAVAILABLE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNAVAILABLE}, {@code false} otherwise.
     */
    public boolean isUnavailable() {
        return this._tag == Tag.UNAVAILABLE;
    }

    /**
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#UNAVAILABLE}.
     *
     * <p> Secondary email is not available to be claimed by the user. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#UNAVAILABLE}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult unavailable(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndUnavailable(Tag.UNAVAILABLE, value);
    }

    /**
     * Secondary email is not available to be claimed by the user.
     *
     * <p> This instance must be tagged as {@link Tag#UNAVAILABLE}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isUnavailable} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUnavailable} is {@code
     *     false}.
     */
    public String getUnavailableValue() {
        if (this._tag != Tag.UNAVAILABLE) {
            throw new IllegalStateException("Invalid tag: required Tag.UNAVAILABLE, but was Tag." + this._tag.name());
        }
        return unavailableValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ALREADY_PENDING}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ALREADY_PENDING}, {@code false} otherwise.
     */
    public boolean isAlreadyPending() {
        return this._tag == Tag.ALREADY_PENDING;
    }

    /**
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#ALREADY_PENDING}.
     *
     * <p> Secondary email is already a pending email for the user. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#ALREADY_PENDING}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult alreadyPending(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndAlreadyPending(Tag.ALREADY_PENDING, value);
    }

    /**
     * Secondary email is already a pending email for the user.
     *
     * <p> This instance must be tagged as {@link Tag#ALREADY_PENDING}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isAlreadyPending} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAlreadyPending} is {@code
     *     false}.
     */
    public String getAlreadyPendingValue() {
        if (this._tag != Tag.ALREADY_PENDING) {
            throw new IllegalStateException("Invalid tag: required Tag.ALREADY_PENDING, but was Tag." + this._tag.name());
        }
        return alreadyPendingValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ALREADY_OWNED_BY_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ALREADY_OWNED_BY_USER}, {@code false} otherwise.
     */
    public boolean isAlreadyOwnedByUser() {
        return this._tag == Tag.ALREADY_OWNED_BY_USER;
    }

    /**
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#ALREADY_OWNED_BY_USER}.
     *
     * <p> Secondary email is already a verified email for the user. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#ALREADY_OWNED_BY_USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult alreadyOwnedByUser(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndAlreadyOwnedByUser(Tag.ALREADY_OWNED_BY_USER, value);
    }

    /**
     * Secondary email is already a verified email for the user.
     *
     * <p> This instance must be tagged as {@link Tag#ALREADY_OWNED_BY_USER}.
     * </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isAlreadyOwnedByUser} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAlreadyOwnedByUser} is {@code
     *     false}.
     */
    public String getAlreadyOwnedByUserValue() {
        if (this._tag != Tag.ALREADY_OWNED_BY_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.ALREADY_OWNED_BY_USER, but was Tag." + this._tag.name());
        }
        return alreadyOwnedByUserValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#REACHED_LIMIT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#REACHED_LIMIT}, {@code false} otherwise.
     */
    public boolean isReachedLimit() {
        return this._tag == Tag.REACHED_LIMIT;
    }

    /**
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#REACHED_LIMIT}.
     *
     * <p> User already has the maximum number of secondary emails allowed. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#REACHED_LIMIT}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult reachedLimit(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndReachedLimit(Tag.REACHED_LIMIT, value);
    }

    /**
     * User already has the maximum number of secondary emails allowed.
     *
     * <p> This instance must be tagged as {@link Tag#REACHED_LIMIT}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isReachedLimit} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isReachedLimit} is {@code
     *     false}.
     */
    public String getReachedLimitValue() {
        if (this._tag != Tag.REACHED_LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.REACHED_LIMIT, but was Tag." + this._tag.name());
        }
        return reachedLimitValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TRANSIENT_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TRANSIENT_ERROR}, {@code false} otherwise.
     */
    public boolean isTransientError() {
        return this._tag == Tag.TRANSIENT_ERROR;
    }

    /**
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#TRANSIENT_ERROR}.
     *
     * <p> A transient error occurred. Please try again later. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#TRANSIENT_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult transientError(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndTransientError(Tag.TRANSIENT_ERROR, value);
    }

    /**
     * A transient error occurred. Please try again later.
     *
     * <p> This instance must be tagged as {@link Tag#TRANSIENT_ERROR}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isTransientError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTransientError} is {@code
     *     false}.
     */
    public String getTransientErrorValue() {
        if (this._tag != Tag.TRANSIENT_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.TRANSIENT_ERROR, but was Tag." + this._tag.name());
        }
        return transientErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_UPDATES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_UPDATES}, {@code false} otherwise.
     */
    public boolean isTooManyUpdates() {
        return this._tag == Tag.TOO_MANY_UPDATES;
    }

    /**
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#TOO_MANY_UPDATES}.
     *
     * <p> An error occurred due to conflicting updates. Please try again later.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#TOO_MANY_UPDATES}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult tooManyUpdates(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndTooManyUpdates(Tag.TOO_MANY_UPDATES, value);
    }

    /**
     * An error occurred due to conflicting updates. Please try again later.
     *
     * <p> This instance must be tagged as {@link Tag#TOO_MANY_UPDATES}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isTooManyUpdates} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTooManyUpdates} is {@code
     *     false}.
     */
    public String getTooManyUpdatesValue() {
        if (this._tag != Tag.TOO_MANY_UPDATES) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_UPDATES, but was Tag." + this._tag.name());
        }
        return tooManyUpdatesValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNKNOWN_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNKNOWN_ERROR}, {@code false} otherwise.
     */
    public boolean isUnknownError() {
        return this._tag == Tag.UNKNOWN_ERROR;
    }

    /**
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#UNKNOWN_ERROR}.
     *
     * <p> An unknown error occurred. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#UNKNOWN_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult unknownError(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndUnknownError(Tag.UNKNOWN_ERROR, value);
    }

    /**
     * An unknown error occurred.
     *
     * <p> This instance must be tagged as {@link Tag#UNKNOWN_ERROR}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isUnknownError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUnknownError} is {@code
     *     false}.
     */
    public String getUnknownErrorValue() {
        if (this._tag != Tag.UNKNOWN_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.UNKNOWN_ERROR, but was Tag." + this._tag.name());
        }
        return unknownErrorValue;
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
     * Returns an instance of {@code AddSecondaryEmailResult} that has its tag
     * set to {@link Tag#RATE_LIMITED}.
     *
     * <p> Too many emails are being sent to this email address. Please try
     * again later. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddSecondaryEmailResult} with its tag set to
     *     {@link Tag#RATE_LIMITED}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static AddSecondaryEmailResult rateLimited(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndRateLimited(Tag.RATE_LIMITED, value);
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
            unavailableValue,
            alreadyPendingValue,
            alreadyOwnedByUserValue,
            reachedLimitValue,
            transientErrorValue,
            tooManyUpdatesValue,
            unknownErrorValue,
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
        else if (obj instanceof AddSecondaryEmailResult) {
            AddSecondaryEmailResult other = (AddSecondaryEmailResult) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case UNAVAILABLE:
                    return (this.unavailableValue == other.unavailableValue) || (this.unavailableValue.equals(other.unavailableValue));
                case ALREADY_PENDING:
                    return (this.alreadyPendingValue == other.alreadyPendingValue) || (this.alreadyPendingValue.equals(other.alreadyPendingValue));
                case ALREADY_OWNED_BY_USER:
                    return (this.alreadyOwnedByUserValue == other.alreadyOwnedByUserValue) || (this.alreadyOwnedByUserValue.equals(other.alreadyOwnedByUserValue));
                case REACHED_LIMIT:
                    return (this.reachedLimitValue == other.reachedLimitValue) || (this.reachedLimitValue.equals(other.reachedLimitValue));
                case TRANSIENT_ERROR:
                    return (this.transientErrorValue == other.transientErrorValue) || (this.transientErrorValue.equals(other.transientErrorValue));
                case TOO_MANY_UPDATES:
                    return (this.tooManyUpdatesValue == other.tooManyUpdatesValue) || (this.tooManyUpdatesValue.equals(other.tooManyUpdatesValue));
                case UNKNOWN_ERROR:
                    return (this.unknownErrorValue == other.unknownErrorValue) || (this.unknownErrorValue.equals(other.unknownErrorValue));
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
    static class Serializer extends UnionSerializer<AddSecondaryEmailResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddSecondaryEmailResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    SecondaryEmail.Serializer.INSTANCE.serialize(value.successValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case UNAVAILABLE: {
                    g.writeStartObject();
                    writeTag("unavailable", g);
                    g.writeFieldName("unavailable");
                    StoneSerializers.string().serialize(value.unavailableValue, g);
                    g.writeEndObject();
                    break;
                }
                case ALREADY_PENDING: {
                    g.writeStartObject();
                    writeTag("already_pending", g);
                    g.writeFieldName("already_pending");
                    StoneSerializers.string().serialize(value.alreadyPendingValue, g);
                    g.writeEndObject();
                    break;
                }
                case ALREADY_OWNED_BY_USER: {
                    g.writeStartObject();
                    writeTag("already_owned_by_user", g);
                    g.writeFieldName("already_owned_by_user");
                    StoneSerializers.string().serialize(value.alreadyOwnedByUserValue, g);
                    g.writeEndObject();
                    break;
                }
                case REACHED_LIMIT: {
                    g.writeStartObject();
                    writeTag("reached_limit", g);
                    g.writeFieldName("reached_limit");
                    StoneSerializers.string().serialize(value.reachedLimitValue, g);
                    g.writeEndObject();
                    break;
                }
                case TRANSIENT_ERROR: {
                    g.writeStartObject();
                    writeTag("transient_error", g);
                    g.writeFieldName("transient_error");
                    StoneSerializers.string().serialize(value.transientErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case TOO_MANY_UPDATES: {
                    g.writeStartObject();
                    writeTag("too_many_updates", g);
                    g.writeFieldName("too_many_updates");
                    StoneSerializers.string().serialize(value.tooManyUpdatesValue, g);
                    g.writeEndObject();
                    break;
                }
                case UNKNOWN_ERROR: {
                    g.writeStartObject();
                    writeTag("unknown_error", g);
                    g.writeFieldName("unknown_error");
                    StoneSerializers.string().serialize(value.unknownErrorValue, g);
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
        public AddSecondaryEmailResult deserialize(JsonParser p) throws IOException, JsonParseException {
            AddSecondaryEmailResult value;
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
                SecondaryEmail fieldValue = null;
                fieldValue = SecondaryEmail.Serializer.INSTANCE.deserialize(p, true);
                value = AddSecondaryEmailResult.success(fieldValue);
            }
            else if ("unavailable".equals(tag)) {
                String fieldValue = null;
                expectField("unavailable", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.unavailable(fieldValue);
            }
            else if ("already_pending".equals(tag)) {
                String fieldValue = null;
                expectField("already_pending", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.alreadyPending(fieldValue);
            }
            else if ("already_owned_by_user".equals(tag)) {
                String fieldValue = null;
                expectField("already_owned_by_user", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.alreadyOwnedByUser(fieldValue);
            }
            else if ("reached_limit".equals(tag)) {
                String fieldValue = null;
                expectField("reached_limit", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.reachedLimit(fieldValue);
            }
            else if ("transient_error".equals(tag)) {
                String fieldValue = null;
                expectField("transient_error", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.transientError(fieldValue);
            }
            else if ("too_many_updates".equals(tag)) {
                String fieldValue = null;
                expectField("too_many_updates", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.tooManyUpdates(fieldValue);
            }
            else if ("unknown_error".equals(tag)) {
                String fieldValue = null;
                expectField("unknown_error", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.unknownError(fieldValue);
            }
            else if ("rate_limited".equals(tag)) {
                String fieldValue = null;
                expectField("rate_limited", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AddSecondaryEmailResult.rateLimited(fieldValue);
            }
            else {
                value = AddSecondaryEmailResult.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
