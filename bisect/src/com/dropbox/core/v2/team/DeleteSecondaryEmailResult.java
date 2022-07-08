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
 * Result of trying to delete a secondary email address. 'success' is the only
 * value indicating that a secondary email was successfully deleted. The other
 * values explain the type of error that occurred, and include the email for
 * which the error occured.
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
public final class DeleteSecondaryEmailResult {
    // union team.DeleteSecondaryEmailResult (team_secondary_mails.stone)

    /**
     * Discriminating tag type for {@link DeleteSecondaryEmailResult}.
     */
    public enum Tag {
        /**
         * The secondary email was successfully deleted.
         */
        SUCCESS, // String
        /**
         * The email address was not found for the user.
         */
        NOT_FOUND, // String
        /**
         * The email address is the primary email address of the user, and
         * cannot be removed.
         */
        CANNOT_REMOVE_PRIMARY, // String
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
    public static final DeleteSecondaryEmailResult OTHER = new DeleteSecondaryEmailResult().withTag(Tag.OTHER);

    private Tag _tag;
    private String successValue;
    private String notFoundValue;
    private String cannotRemovePrimaryValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private DeleteSecondaryEmailResult() {
    }


    /**
     * Result of trying to delete a secondary email address. 'success' is the
     * only value indicating that a secondary email was successfully deleted.
     * The other values explain the type of error that occurred, and include the
     * email for which the error occured.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private DeleteSecondaryEmailResult withTag(Tag _tag) {
        DeleteSecondaryEmailResult result = new DeleteSecondaryEmailResult();
        result._tag = _tag;
        return result;
    }

    /**
     * Result of trying to delete a secondary email address. 'success' is the
     * only value indicating that a secondary email was successfully deleted.
     * The other values explain the type of error that occurred, and include the
     * email for which the error occured.
     *
     * @param successValue  The secondary email was successfully deleted. Must
     *     have length of at most 255, match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private DeleteSecondaryEmailResult withTagAndSuccess(Tag _tag, String successValue) {
        DeleteSecondaryEmailResult result = new DeleteSecondaryEmailResult();
        result._tag = _tag;
        result.successValue = successValue;
        return result;
    }

    /**
     * Result of trying to delete a secondary email address. 'success' is the
     * only value indicating that a secondary email was successfully deleted.
     * The other values explain the type of error that occurred, and include the
     * email for which the error occured.
     *
     * @param notFoundValue  The email address was not found for the user. Must
     *     have length of at most 255, match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private DeleteSecondaryEmailResult withTagAndNotFound(Tag _tag, String notFoundValue) {
        DeleteSecondaryEmailResult result = new DeleteSecondaryEmailResult();
        result._tag = _tag;
        result.notFoundValue = notFoundValue;
        return result;
    }

    /**
     * Result of trying to delete a secondary email address. 'success' is the
     * only value indicating that a secondary email was successfully deleted.
     * The other values explain the type of error that occurred, and include the
     * email for which the error occured.
     *
     * @param cannotRemovePrimaryValue  The email address is the primary email
     *     address of the user, and cannot be removed. Must have length of at
     *     most 255, match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private DeleteSecondaryEmailResult withTagAndCannotRemovePrimary(Tag _tag, String cannotRemovePrimaryValue) {
        DeleteSecondaryEmailResult result = new DeleteSecondaryEmailResult();
        result._tag = _tag;
        result.cannotRemovePrimaryValue = cannotRemovePrimaryValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code DeleteSecondaryEmailResult}. </p>
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
     * Returns an instance of {@code DeleteSecondaryEmailResult} that has its
     * tag set to {@link Tag#SUCCESS}.
     *
     * <p> The secondary email was successfully deleted. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code DeleteSecondaryEmailResult} with its tag set
     *     to {@link Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static DeleteSecondaryEmailResult success(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new DeleteSecondaryEmailResult().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * The secondary email was successfully deleted.
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
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOUND},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#NOT_FOUND},
     *     {@code false} otherwise.
     */
    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
    }

    /**
     * Returns an instance of {@code DeleteSecondaryEmailResult} that has its
     * tag set to {@link Tag#NOT_FOUND}.
     *
     * <p> The email address was not found for the user. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code DeleteSecondaryEmailResult} with its tag set
     *     to {@link Tag#NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static DeleteSecondaryEmailResult notFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new DeleteSecondaryEmailResult().withTagAndNotFound(Tag.NOT_FOUND, value);
    }

    /**
     * The email address was not found for the user.
     *
     * <p> This instance must be tagged as {@link Tag#NOT_FOUND}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isNotFound} is {@code false}.
     */
    public String getNotFoundValue() {
        if (this._tag != Tag.NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.NOT_FOUND, but was Tag." + this._tag.name());
        }
        return notFoundValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANNOT_REMOVE_PRIMARY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANNOT_REMOVE_PRIMARY}, {@code false} otherwise.
     */
    public boolean isCannotRemovePrimary() {
        return this._tag == Tag.CANNOT_REMOVE_PRIMARY;
    }

    /**
     * Returns an instance of {@code DeleteSecondaryEmailResult} that has its
     * tag set to {@link Tag#CANNOT_REMOVE_PRIMARY}.
     *
     * <p> The email address is the primary email address of the user, and
     * cannot be removed. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code DeleteSecondaryEmailResult} with its tag set
     *     to {@link Tag#CANNOT_REMOVE_PRIMARY}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static DeleteSecondaryEmailResult cannotRemovePrimary(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new DeleteSecondaryEmailResult().withTagAndCannotRemovePrimary(Tag.CANNOT_REMOVE_PRIMARY, value);
    }

    /**
     * The email address is the primary email address of the user, and cannot be
     * removed.
     *
     * <p> This instance must be tagged as {@link Tag#CANNOT_REMOVE_PRIMARY}.
     * </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isCannotRemovePrimary} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isCannotRemovePrimary} is
     *     {@code false}.
     */
    public String getCannotRemovePrimaryValue() {
        if (this._tag != Tag.CANNOT_REMOVE_PRIMARY) {
            throw new IllegalStateException("Invalid tag: required Tag.CANNOT_REMOVE_PRIMARY, but was Tag." + this._tag.name());
        }
        return cannotRemovePrimaryValue;
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
            notFoundValue,
            cannotRemovePrimaryValue
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
        else if (obj instanceof DeleteSecondaryEmailResult) {
            DeleteSecondaryEmailResult other = (DeleteSecondaryEmailResult) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case NOT_FOUND:
                    return (this.notFoundValue == other.notFoundValue) || (this.notFoundValue.equals(other.notFoundValue));
                case CANNOT_REMOVE_PRIMARY:
                    return (this.cannotRemovePrimaryValue == other.cannotRemovePrimaryValue) || (this.cannotRemovePrimaryValue.equals(other.cannotRemovePrimaryValue));
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
    static class Serializer extends UnionSerializer<DeleteSecondaryEmailResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteSecondaryEmailResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    g.writeFieldName("success");
                    StoneSerializers.string().serialize(value.successValue, g);
                    g.writeEndObject();
                    break;
                }
                case NOT_FOUND: {
                    g.writeStartObject();
                    writeTag("not_found", g);
                    g.writeFieldName("not_found");
                    StoneSerializers.string().serialize(value.notFoundValue, g);
                    g.writeEndObject();
                    break;
                }
                case CANNOT_REMOVE_PRIMARY: {
                    g.writeStartObject();
                    writeTag("cannot_remove_primary", g);
                    g.writeFieldName("cannot_remove_primary");
                    StoneSerializers.string().serialize(value.cannotRemovePrimaryValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public DeleteSecondaryEmailResult deserialize(JsonParser p) throws IOException, JsonParseException {
            DeleteSecondaryEmailResult value;
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
                value = DeleteSecondaryEmailResult.success(fieldValue);
            }
            else if ("not_found".equals(tag)) {
                String fieldValue = null;
                expectField("not_found", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = DeleteSecondaryEmailResult.notFound(fieldValue);
            }
            else if ("cannot_remove_primary".equals(tag)) {
                String fieldValue = null;
                expectField("cannot_remove_primary", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = DeleteSecondaryEmailResult.cannotRemovePrimary(fieldValue);
            }
            else {
                value = DeleteSecondaryEmailResult.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
