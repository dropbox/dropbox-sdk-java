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
public final class UploadSessionAppendError {
    // union files.UploadSessionAppendError (files.stone)

    /**
     * Discriminating tag type for {@link UploadSessionAppendError}.
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
        OTHER,
        /**
         * The content received by the Dropbox server in this call does not
         * match the provided content hash.
         */
        CONTENT_HASH_MISMATCH;
    }

    /**
     * The upload session ID was not found or has expired. Upload sessions are
     * valid for 7 days.
     */
    public static final UploadSessionAppendError NOT_FOUND = new UploadSessionAppendError().withTag(Tag.NOT_FOUND);
    /**
     * You are attempting to append data to an upload session that has already
     * been closed (i.e. committed).
     */
    public static final UploadSessionAppendError CLOSED = new UploadSessionAppendError().withTag(Tag.CLOSED);
    /**
     * The session must be closed before calling upload_session/finish_batch.
     */
    public static final UploadSessionAppendError NOT_CLOSED = new UploadSessionAppendError().withTag(Tag.NOT_CLOSED);
    /**
     * You can not append to the upload session because the size of a file
     * should not reach the max file size limit (i.e. 350GB).
     */
    public static final UploadSessionAppendError TOO_LARGE = new UploadSessionAppendError().withTag(Tag.TOO_LARGE);
    /**
     * For concurrent upload sessions, offset needs to be multiple of 4194304
     * bytes.
     */
    public static final UploadSessionAppendError CONCURRENT_SESSION_INVALID_OFFSET = new UploadSessionAppendError().withTag(Tag.CONCURRENT_SESSION_INVALID_OFFSET);
    /**
     * For concurrent upload sessions, only chunks with size multiple of 4194304
     * bytes can be uploaded.
     */
    public static final UploadSessionAppendError CONCURRENT_SESSION_INVALID_DATA_SIZE = new UploadSessionAppendError().withTag(Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE);
    /**
     * The request payload must be at most 150 MB.
     */
    public static final UploadSessionAppendError PAYLOAD_TOO_LARGE = new UploadSessionAppendError().withTag(Tag.PAYLOAD_TOO_LARGE);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UploadSessionAppendError OTHER = new UploadSessionAppendError().withTag(Tag.OTHER);
    /**
     * The content received by the Dropbox server in this call does not match
     * the provided content hash.
     */
    public static final UploadSessionAppendError CONTENT_HASH_MISMATCH = new UploadSessionAppendError().withTag(Tag.CONTENT_HASH_MISMATCH);

    private Tag _tag;
    private UploadSessionOffsetError incorrectOffsetValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UploadSessionAppendError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UploadSessionAppendError withTag(Tag _tag) {
        UploadSessionAppendError result = new UploadSessionAppendError();
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
    private UploadSessionAppendError withTagAndIncorrectOffset(Tag _tag, UploadSessionOffsetError incorrectOffsetValue) {
        UploadSessionAppendError result = new UploadSessionAppendError();
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
     * values for this {@code UploadSessionAppendError}. </p>
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
     * Returns an instance of {@code UploadSessionAppendError} that has its tag
     * set to {@link Tag#INCORRECT_OFFSET}.
     *
     * <p> The specified offset was incorrect. See the value for the correct
     * offset. This error may occur when a previous request was received and
     * processed successfully but the client did not receive the response, e.g.
     * due to a network error. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionAppendError} with its tag set to
     *     {@link Tag#INCORRECT_OFFSET}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionAppendError incorrectOffset(UploadSessionOffsetError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionAppendError().withTagAndIncorrectOffset(Tag.INCORRECT_OFFSET, value);
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

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONTENT_HASH_MISMATCH}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONTENT_HASH_MISMATCH}, {@code false} otherwise.
     */
    public boolean isContentHashMismatch() {
        return this._tag == Tag.CONTENT_HASH_MISMATCH;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.incorrectOffsetValue
        });
        hash = (31 * super.hashCode()) + hash;
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
        else if (obj instanceof UploadSessionAppendError) {
            UploadSessionAppendError other = (UploadSessionAppendError) obj;
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
                case CONTENT_HASH_MISMATCH:
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
    static class Serializer extends UnionSerializer<UploadSessionAppendError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionAppendError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case CONTENT_HASH_MISMATCH: {
                    g.writeString("content_hash_mismatch");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public UploadSessionAppendError deserialize(JsonParser p) throws IOException, JsonParseException {
            UploadSessionAppendError value;
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
                value = UploadSessionAppendError.NOT_FOUND;
            }
            else if ("incorrect_offset".equals(tag)) {
                UploadSessionOffsetError fieldValue = null;
                fieldValue = UploadSessionOffsetError.Serializer.INSTANCE.deserialize(p, true);
                value = UploadSessionAppendError.incorrectOffset(fieldValue);
            }
            else if ("closed".equals(tag)) {
                value = UploadSessionAppendError.CLOSED;
            }
            else if ("not_closed".equals(tag)) {
                value = UploadSessionAppendError.NOT_CLOSED;
            }
            else if ("too_large".equals(tag)) {
                value = UploadSessionAppendError.TOO_LARGE;
            }
            else if ("concurrent_session_invalid_offset".equals(tag)) {
                value = UploadSessionAppendError.CONCURRENT_SESSION_INVALID_OFFSET;
            }
            else if ("concurrent_session_invalid_data_size".equals(tag)) {
                value = UploadSessionAppendError.CONCURRENT_SESSION_INVALID_DATA_SIZE;
            }
            else if ("payload_too_large".equals(tag)) {
                value = UploadSessionAppendError.PAYLOAD_TOO_LARGE;
            }
            else if ("other".equals(tag)) {
                value = UploadSessionAppendError.OTHER;
            }
            else if ("content_hash_mismatch".equals(tag)) {
                value = UploadSessionAppendError.CONTENT_HASH_MISMATCH;
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
