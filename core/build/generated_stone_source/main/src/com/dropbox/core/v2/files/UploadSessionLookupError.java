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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class UploadSessionLookupError {
    // union files.UploadSessionLookupError (files.stone)

    /**
     * Discriminating tag type for {@link UploadSessionLookupError}.
     */
    public enum Tag {
        /**
         * The upload session ID was not found or has expired. Upload sessions
         * are valid for 7 days.
         */
        NOT_FOUND,
        /**
         * The specified offset was incorrect. See the value for the correct
         * offset. This error may occur when a previous request was received and
         * processed successfully but the client did not receive the response,
         * e.g. due to a network error.
         */
        INCORRECT_OFFSET, // UploadSessionOffsetError
        /**
         * You are attempting to append data to an upload session that has
         * already been closed (i.e. committed).
         */
        CLOSED,
        /**
         * The session must be closed before calling
         * upload_session/finish_batch.
         */
        NOT_CLOSED,
        /**
         * You can not append to the upload session because the size of a file
         * should not reach the max file size limit (i.e. 350GB).
         */
        TOO_LARGE,
        /**
         * For concurrent upload sessions, offset needs to be multiple of
         * 4194304 bytes.
         */
        CONCURRENT_SESSION_INVALID_OFFSET,
        /**
         * For concurrent upload sessions, only chunks with size multiple of
         * 4194304 bytes can be uploaded.
         */
        CONCURRENT_SESSION_INVALID_DATA_SIZE,
        /**
         * The request payload must be at most 150 MB.
         */
        PAYLOAD_TOO_LARGE,
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
     * The upload session ID was not found or has expired. Upload sessions are
     * valid for 7 days.
     */
    public static final UploadSessionLookupError NOT_FOUND = new UploadSessionLookupError().withTag(Tag.NOT_FOUND);
    /**
     * You are attempting to append data to an upload session that has already
     * been closed (i.e. committed).
     */
    public static final UploadSessionLookupError CLOSED = new UploadSessionLookupError().withTag(Tag.CLOSED);
    /**
     * The session must be closed before calling upload_session/finish_batch.
     */
    public static final UploadSessionLookupError NOT_CLOSED = new UploadSessionLookupError().withTag(Tag.NOT_CLOSED);
    /**
     * You can not append to the upload session because the size of a file
     * should not reach the max file size limit (i.e. 350GB).
     */
    public static final UploadSessionLookupError TOO_LARGE = new UploadSessionLookupError().withTag(Tag.TOO_LARGE);
    /**
     * For concurrent upload sessions, offset needs to be multiple of 4194304
     * bytes.
     */
    public static final UploadSessionLookupError CONCURRENT_SESSION_INVALID_OFFSET = new UploadSessionLookupError().withTag(Tag.CONCURRENT_SESSION_INVALID_OFFSET);
    /**
     * For concurrent upload sessions, only chunks with size multiple of 4194304
     * bytes can be uploaded.
     */
    public static final UploadSessionLookupError CONCURRENT_SESSION_INVALID_DATA_SIZE = new UploadSessionLookupError().withTag(Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE);
    /**
     * The request payload must be at most 150 MB.
     */
    public static final UploadSessionLookupError PAYLOAD_TOO_LARGE = new UploadSessionLookupError().withTag(Tag.PAYLOAD_TOO_LARGE);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UploadSessionLookupError OTHER = new UploadSessionLookupError().withTag(Tag.OTHER);

    private Tag _tag;
    private UploadSessionOffsetError incorrectOffsetValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UploadSessionLookupError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UploadSessionLookupError withTag(Tag _tag) {
        UploadSessionLookupError result = new UploadSessionLookupError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param incorrectOffsetValue  The specified offset was incorrect. See the
     *     value for the correct offset. This error may occur when a previous
     *     request was received and processed successfully but the client did
     *     not receive the response, e.g. due to a network error. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UploadSessionLookupError withTagAndIncorrectOffset(Tag _tag, UploadSessionOffsetError incorrectOffsetValue) {
        UploadSessionLookupError result = new UploadSessionLookupError();
        result._tag = _tag;
        result.incorrectOffsetValue = incorrectOffsetValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UploadSessionLookupError}. </p>
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INCORRECT_OFFSET}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INCORRECT_OFFSET}, {@code false} otherwise.
     */
    public boolean isIncorrectOffset() {
        return this._tag == Tag.INCORRECT_OFFSET;
    }

    /**
     * Returns an instance of {@code UploadSessionLookupError} that has its tag
     * set to {@link Tag#INCORRECT_OFFSET}.
     *
     * <p> The specified offset was incorrect. See the value for the correct
     * offset. This error may occur when a previous request was received and
     * processed successfully but the client did not receive the response, e.g.
     * due to a network error. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionLookupError} with its tag set to
     *     {@link Tag#INCORRECT_OFFSET}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionLookupError incorrectOffset(UploadSessionOffsetError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionLookupError().withTagAndIncorrectOffset(Tag.INCORRECT_OFFSET, value);
    }

    /**
     * The specified offset was incorrect. See the value for the correct offset.
     * This error may occur when a previous request was received and processed
     * successfully but the client did not receive the response, e.g. due to a
     * network error.
     *
     * <p> This instance must be tagged as {@link Tag#INCORRECT_OFFSET}. </p>
     *
     * @return The {@link UploadSessionOffsetError} value associated with this
     *     instance if {@link #isIncorrectOffset} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isIncorrectOffset} is {@code
     *     false}.
     */
    public UploadSessionOffsetError getIncorrectOffsetValue() {
        if (this._tag != Tag.INCORRECT_OFFSET) {
            throw new IllegalStateException("Invalid tag: required Tag.INCORRECT_OFFSET, but was Tag." + this._tag.name());
        }
        return incorrectOffsetValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#CLOSED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#CLOSED},
     *     {@code false} otherwise.
     */
    public boolean isClosed() {
        return this._tag == Tag.CLOSED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_CLOSED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NOT_CLOSED}, {@code false} otherwise.
     */
    public boolean isNotClosed() {
        return this._tag == Tag.NOT_CLOSED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#TOO_LARGE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#TOO_LARGE},
     *     {@code false} otherwise.
     */
    public boolean isTooLarge() {
        return this._tag == Tag.TOO_LARGE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONCURRENT_SESSION_INVALID_OFFSET}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONCURRENT_SESSION_INVALID_OFFSET}, {@code false} otherwise.
     */
    public boolean isConcurrentSessionInvalidOffset() {
        return this._tag == Tag.CONCURRENT_SESSION_INVALID_OFFSET;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONCURRENT_SESSION_INVALID_DATA_SIZE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONCURRENT_SESSION_INVALID_DATA_SIZE}, {@code false} otherwise.
     */
    public boolean isConcurrentSessionInvalidDataSize() {
        return this._tag == Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PAYLOAD_TOO_LARGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PAYLOAD_TOO_LARGE}, {@code false} otherwise.
     */
    public boolean isPayloadTooLarge() {
        return this._tag == Tag.PAYLOAD_TOO_LARGE;
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
            this.incorrectOffsetValue
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
        else if (obj instanceof UploadSessionLookupError) {
            UploadSessionLookupError other = (UploadSessionLookupError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case NOT_FOUND:
                    return true;
                case INCORRECT_OFFSET:
                    return (this.incorrectOffsetValue == other.incorrectOffsetValue) || (this.incorrectOffsetValue.equals(other.incorrectOffsetValue));
                case CLOSED:
                    return true;
                case NOT_CLOSED:
                    return true;
                case TOO_LARGE:
                    return true;
                case CONCURRENT_SESSION_INVALID_OFFSET:
                    return true;
                case CONCURRENT_SESSION_INVALID_DATA_SIZE:
                    return true;
                case PAYLOAD_TOO_LARGE:
                    return true;
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
    static class Serializer extends UnionSerializer<UploadSessionLookupError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionLookupError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case NOT_FOUND: {
                    g.writeString("not_found");
                    break;
                }
                case INCORRECT_OFFSET: {
                    g.writeStartObject();
                    writeTag("incorrect_offset", g);
                    UploadSessionOffsetError.Serializer.INSTANCE.serialize(value.incorrectOffsetValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case CLOSED: {
                    g.writeString("closed");
                    break;
                }
                case NOT_CLOSED: {
                    g.writeString("not_closed");
                    break;
                }
                case TOO_LARGE: {
                    g.writeString("too_large");
                    break;
                }
                case CONCURRENT_SESSION_INVALID_OFFSET: {
                    g.writeString("concurrent_session_invalid_offset");
                    break;
                }
                case CONCURRENT_SESSION_INVALID_DATA_SIZE: {
                    g.writeString("concurrent_session_invalid_data_size");
                    break;
                }
                case PAYLOAD_TOO_LARGE: {
                    g.writeString("payload_too_large");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UploadSessionLookupError deserialize(JsonParser p) throws IOException, JsonParseException {
            UploadSessionLookupError value;
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
            else if ("not_found".equals(tag)) {
                value = UploadSessionLookupError.NOT_FOUND;
            }
            else if ("incorrect_offset".equals(tag)) {
                UploadSessionOffsetError fieldValue = null;
                fieldValue = UploadSessionOffsetError.Serializer.INSTANCE.deserialize(p, true);
                value = UploadSessionLookupError.incorrectOffset(fieldValue);
            }
            else if ("closed".equals(tag)) {
                value = UploadSessionLookupError.CLOSED;
            }
            else if ("not_closed".equals(tag)) {
                value = UploadSessionLookupError.NOT_CLOSED;
            }
            else if ("too_large".equals(tag)) {
                value = UploadSessionLookupError.TOO_LARGE;
            }
            else if ("concurrent_session_invalid_offset".equals(tag)) {
                value = UploadSessionLookupError.CONCURRENT_SESSION_INVALID_OFFSET;
            }
            else if ("concurrent_session_invalid_data_size".equals(tag)) {
                value = UploadSessionLookupError.CONCURRENT_SESSION_INVALID_DATA_SIZE;
            }
            else if ("payload_too_large".equals(tag)) {
                value = UploadSessionLookupError.PAYLOAD_TOO_LARGE;
            }
            else {
                value = UploadSessionLookupError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
