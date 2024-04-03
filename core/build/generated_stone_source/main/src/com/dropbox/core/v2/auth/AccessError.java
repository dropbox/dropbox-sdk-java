/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

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
 * Error occurred because the account doesn't have permission to access the
 * resource.
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
public final class AccessError {
    // union auth.AccessError (auth.stone)

    /**
     * Discriminating tag type for {@link AccessError}.
     */
    public enum Tag {
        /**
         * Current account type cannot access the resource.
         */
        INVALID_ACCOUNT_TYPE, // InvalidAccountTypeError
        /**
         * Current account cannot access Paper.
         */
        PAPER_ACCESS_DENIED, // PaperAccessError
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
    public static final AccessError OTHER = new AccessError().withTag(Tag.OTHER);

    private Tag _tag;
    private InvalidAccountTypeError invalidAccountTypeValue;
    private PaperAccessError paperAccessDeniedValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private AccessError() {
    }


    /**
     * Error occurred because the account doesn't have permission to access the
     * resource.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private AccessError withTag(Tag _tag) {
        AccessError result = new AccessError();
        result._tag = _tag;
        return result;
    }

    /**
     * Error occurred because the account doesn't have permission to access the
     * resource.
     *
     * @param invalidAccountTypeValue  Current account type cannot access the
     *     resource. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessError withTagAndInvalidAccountType(Tag _tag, InvalidAccountTypeError invalidAccountTypeValue) {
        AccessError result = new AccessError();
        result._tag = _tag;
        result.invalidAccountTypeValue = invalidAccountTypeValue;
        return result;
    }

    /**
     * Error occurred because the account doesn't have permission to access the
     * resource.
     *
     * @param paperAccessDeniedValue  Current account cannot access Paper. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessError withTagAndPaperAccessDenied(Tag _tag, PaperAccessError paperAccessDeniedValue) {
        AccessError result = new AccessError();
        result._tag = _tag;
        result.paperAccessDeniedValue = paperAccessDeniedValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code AccessError}. </p>
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
     * Tag#INVALID_ACCOUNT_TYPE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_ACCOUNT_TYPE}, {@code false} otherwise.
     */
    public boolean isInvalidAccountType() {
        return this._tag == Tag.INVALID_ACCOUNT_TYPE;
    }

    /**
     * Returns an instance of {@code AccessError} that has its tag set to {@link
     * Tag#INVALID_ACCOUNT_TYPE}.
     *
     * <p> Current account type cannot access the resource. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessError} with its tag set to {@link
     *     Tag#INVALID_ACCOUNT_TYPE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessError invalidAccountType(InvalidAccountTypeError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessError().withTagAndInvalidAccountType(Tag.INVALID_ACCOUNT_TYPE, value);
    }

    /**
     * Current account type cannot access the resource.
     *
     * <p> This instance must be tagged as {@link Tag#INVALID_ACCOUNT_TYPE}.
     * </p>
     *
     * @return The {@link InvalidAccountTypeError} value associated with this
     *     instance if {@link #isInvalidAccountType} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInvalidAccountType} is {@code
     *     false}.
     */
    public InvalidAccountTypeError getInvalidAccountTypeValue() {
        if (this._tag != Tag.INVALID_ACCOUNT_TYPE) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_ACCOUNT_TYPE, but was Tag." + this._tag.name());
        }
        return invalidAccountTypeValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PAPER_ACCESS_DENIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PAPER_ACCESS_DENIED}, {@code false} otherwise.
     */
    public boolean isPaperAccessDenied() {
        return this._tag == Tag.PAPER_ACCESS_DENIED;
    }

    /**
     * Returns an instance of {@code AccessError} that has its tag set to {@link
     * Tag#PAPER_ACCESS_DENIED}.
     *
     * <p> Current account cannot access Paper. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessError} with its tag set to {@link
     *     Tag#PAPER_ACCESS_DENIED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessError paperAccessDenied(PaperAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessError().withTagAndPaperAccessDenied(Tag.PAPER_ACCESS_DENIED, value);
    }

    /**
     * Current account cannot access Paper.
     *
     * <p> This instance must be tagged as {@link Tag#PAPER_ACCESS_DENIED}. </p>
     *
     * @return The {@link PaperAccessError} value associated with this instance
     *     if {@link #isPaperAccessDenied} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPaperAccessDenied} is {@code
     *     false}.
     */
    public PaperAccessError getPaperAccessDeniedValue() {
        if (this._tag != Tag.PAPER_ACCESS_DENIED) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_ACCESS_DENIED, but was Tag." + this._tag.name());
        }
        return paperAccessDeniedValue;
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
            this.invalidAccountTypeValue,
            this.paperAccessDeniedValue
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
        else if (obj instanceof AccessError) {
            AccessError other = (AccessError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INVALID_ACCOUNT_TYPE:
                    return (this.invalidAccountTypeValue == other.invalidAccountTypeValue) || (this.invalidAccountTypeValue.equals(other.invalidAccountTypeValue));
                case PAPER_ACCESS_DENIED:
                    return (this.paperAccessDeniedValue == other.paperAccessDeniedValue) || (this.paperAccessDeniedValue.equals(other.paperAccessDeniedValue));
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
    public static class Serializer extends UnionSerializer<AccessError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AccessError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INVALID_ACCOUNT_TYPE: {
                    g.writeStartObject();
                    writeTag("invalid_account_type", g);
                    g.writeFieldName("invalid_account_type");
                    InvalidAccountTypeError.Serializer.INSTANCE.serialize(value.invalidAccountTypeValue, g);
                    g.writeEndObject();
                    break;
                }
                case PAPER_ACCESS_DENIED: {
                    g.writeStartObject();
                    writeTag("paper_access_denied", g);
                    g.writeFieldName("paper_access_denied");
                    PaperAccessError.Serializer.INSTANCE.serialize(value.paperAccessDeniedValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AccessError deserialize(JsonParser p) throws IOException, JsonParseException {
            AccessError value;
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
            else if ("invalid_account_type".equals(tag)) {
                InvalidAccountTypeError fieldValue = null;
                expectField("invalid_account_type", p);
                fieldValue = InvalidAccountTypeError.Serializer.INSTANCE.deserialize(p);
                value = AccessError.invalidAccountType(fieldValue);
            }
            else if ("paper_access_denied".equals(tag)) {
                PaperAccessError fieldValue = null;
                expectField("paper_access_denied", p);
                fieldValue = PaperAccessError.Serializer.INSTANCE.deserialize(p);
                value = AccessError.paperAccessDenied(fieldValue);
            }
            else {
                value = AccessError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
