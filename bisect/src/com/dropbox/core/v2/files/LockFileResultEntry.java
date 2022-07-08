/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class LockFileResultEntry {
    // union files.LockFileResultEntry (files.stone)

    /**
     * Discriminating tag type for {@link LockFileResultEntry}.
     */
    public enum Tag {
        SUCCESS, // LockFileResult
        FAILURE; // LockFileError
    }

    private Tag _tag;
    private LockFileResult successValue;
    private LockFileError failureValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private LockFileResultEntry() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private LockFileResultEntry withTag(Tag _tag) {
        LockFileResultEntry result = new LockFileResultEntry();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param successValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LockFileResultEntry withTagAndSuccess(Tag _tag, LockFileResult successValue) {
        LockFileResultEntry result = new LockFileResultEntry();
        result._tag = _tag;
        result.successValue = successValue;
        return result;
    }

    /**
     *
     * @param failureValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LockFileResultEntry withTagAndFailure(Tag _tag, LockFileError failureValue) {
        LockFileResultEntry result = new LockFileResultEntry();
        result._tag = _tag;
        result.failureValue = failureValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code LockFileResultEntry}. </p>
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
     * Returns an instance of {@code LockFileResultEntry} that has its tag set
     * to {@link Tag#SUCCESS}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LockFileResultEntry} with its tag set to
     *     {@link Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LockFileResultEntry success(LockFileResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileResultEntry().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * This instance must be tagged as {@link Tag#SUCCESS}.
     *
     * @return The {@link LockFileResult} value associated with this instance if
     *     {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public LockFileResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return successValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FAILURE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#FAILURE},
     *     {@code false} otherwise.
     */
    public boolean isFailure() {
        return this._tag == Tag.FAILURE;
    }

    /**
     * Returns an instance of {@code LockFileResultEntry} that has its tag set
     * to {@link Tag#FAILURE}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LockFileResultEntry} with its tag set to
     *     {@link Tag#FAILURE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LockFileResultEntry failure(LockFileError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileResultEntry().withTagAndFailure(Tag.FAILURE, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FAILURE}.
     *
     * @return The {@link LockFileError} value associated with this instance if
     *     {@link #isFailure} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailure} is {@code false}.
     */
    public LockFileError getFailureValue() {
        if (this._tag != Tag.FAILURE) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILURE, but was Tag." + this._tag.name());
        }
        return failureValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            successValue,
            failureValue
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
        else if (obj instanceof LockFileResultEntry) {
            LockFileResultEntry other = (LockFileResultEntry) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case FAILURE:
                    return (this.failureValue == other.failureValue) || (this.failureValue.equals(other.failureValue));
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
    static class Serializer extends UnionSerializer<LockFileResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LockFileResultEntry value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    LockFileResult.Serializer.INSTANCE.serialize(value.successValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case FAILURE: {
                    g.writeStartObject();
                    writeTag("failure", g);
                    g.writeFieldName("failure");
                    LockFileError.Serializer.INSTANCE.serialize(value.failureValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public LockFileResultEntry deserialize(JsonParser p) throws IOException, JsonParseException {
            LockFileResultEntry value;
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
                LockFileResult fieldValue = null;
                fieldValue = LockFileResult.Serializer.INSTANCE.deserialize(p, true);
                value = LockFileResultEntry.success(fieldValue);
            }
            else if ("failure".equals(tag)) {
                LockFileError fieldValue = null;
                expectField("failure", p);
                fieldValue = LockFileError.Serializer.INSTANCE.deserialize(p);
                value = LockFileResultEntry.failure(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
