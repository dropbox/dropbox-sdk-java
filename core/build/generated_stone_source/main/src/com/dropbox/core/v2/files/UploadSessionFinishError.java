/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.v2.fileproperties.InvalidPropertyGroupError;

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
public final class UploadSessionFinishError {
    // union files.UploadSessionFinishError (files.stone)

    /**
     * Discriminating tag type for {@link UploadSessionFinishError}.
     */
    public enum Tag {
        /**
         * The session arguments are incorrect; the value explains the reason.
         */
        LOOKUP_FAILED, // UploadSessionLookupError
        /**
         * Unable to save the uploaded contents to a file. Data has already been
         * appended to the upload session. Please retry with empty data body and
         * updated offset.
         */
        PATH, // WriteError
        /**
         * The supplied property group is invalid. The file has uploaded without
         * property groups.
         */
        PROPERTIES_ERROR, // InvalidPropertyGroupError
        /**
         * The batch request commits files into too many different shared
         * folders. Please limit your batch request to files contained in a
         * single shared folder.
         */
        TOO_MANY_SHARED_FOLDER_TARGETS,
        /**
         * There are too many write operations happening in the user's Dropbox.
         * You should retry uploading this file.
         */
        TOO_MANY_WRITE_OPERATIONS,
        /**
         * Uploading data not allowed when finishing concurrent upload session.
         */
        CONCURRENT_SESSION_DATA_NOT_ALLOWED,
        /**
         * Concurrent upload sessions need to be closed before finishing.
         */
        CONCURRENT_SESSION_NOT_CLOSED,
        /**
         * Not all pieces of data were uploaded before trying to finish the
         * session.
         */
        CONCURRENT_SESSION_MISSING_DATA,
        /**
         * The request payload must be at most 150 MB.
         */
        PAYLOAD_TOO_LARGE,
        /**
         * The content received by the Dropbox server in this call does not
         * match the provided content hash.
         */
        CONTENT_HASH_MISMATCH,
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
     * The batch request commits files into too many different shared folders.
     * Please limit your batch request to files contained in a single shared
     * folder.
     */
    public static final UploadSessionFinishError TOO_MANY_SHARED_FOLDER_TARGETS = new UploadSessionFinishError().withTag(Tag.TOO_MANY_SHARED_FOLDER_TARGETS);
    /**
     * There are too many write operations happening in the user's Dropbox. You
     * should retry uploading this file.
     */
    public static final UploadSessionFinishError TOO_MANY_WRITE_OPERATIONS = new UploadSessionFinishError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    /**
     * Uploading data not allowed when finishing concurrent upload session.
     */
    public static final UploadSessionFinishError CONCURRENT_SESSION_DATA_NOT_ALLOWED = new UploadSessionFinishError().withTag(Tag.CONCURRENT_SESSION_DATA_NOT_ALLOWED);
    /**
     * Concurrent upload sessions need to be closed before finishing.
     */
    public static final UploadSessionFinishError CONCURRENT_SESSION_NOT_CLOSED = new UploadSessionFinishError().withTag(Tag.CONCURRENT_SESSION_NOT_CLOSED);
    /**
     * Not all pieces of data were uploaded before trying to finish the session.
     */
    public static final UploadSessionFinishError CONCURRENT_SESSION_MISSING_DATA = new UploadSessionFinishError().withTag(Tag.CONCURRENT_SESSION_MISSING_DATA);
    /**
     * The request payload must be at most 150 MB.
     */
    public static final UploadSessionFinishError PAYLOAD_TOO_LARGE = new UploadSessionFinishError().withTag(Tag.PAYLOAD_TOO_LARGE);
    /**
     * The content received by the Dropbox server in this call does not match
     * the provided content hash.
     */
    public static final UploadSessionFinishError CONTENT_HASH_MISMATCH = new UploadSessionFinishError().withTag(Tag.CONTENT_HASH_MISMATCH);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UploadSessionFinishError OTHER = new UploadSessionFinishError().withTag(Tag.OTHER);

    private Tag _tag;
    private UploadSessionLookupError lookupFailedValue;
    private WriteError pathValue;
    private InvalidPropertyGroupError propertiesErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UploadSessionFinishError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UploadSessionFinishError withTag(Tag _tag) {
        UploadSessionFinishError result = new UploadSessionFinishError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param lookupFailedValue  The session arguments are incorrect; the value
     *     explains the reason. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UploadSessionFinishError withTagAndLookupFailed(Tag _tag, UploadSessionLookupError lookupFailedValue) {
        UploadSessionFinishError result = new UploadSessionFinishError();
        result._tag = _tag;
        result.lookupFailedValue = lookupFailedValue;
        return result;
    }

    /**
     *
     * @param pathValue  Unable to save the uploaded contents to a file. Data
     *     has already been appended to the upload session. Please retry with
     *     empty data body and updated offset. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UploadSessionFinishError withTagAndPath(Tag _tag, WriteError pathValue) {
        UploadSessionFinishError result = new UploadSessionFinishError();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
    }

    /**
     *
     * @param propertiesErrorValue  The supplied property group is invalid. The
     *     file has uploaded without property groups. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UploadSessionFinishError withTagAndPropertiesError(Tag _tag, InvalidPropertyGroupError propertiesErrorValue) {
        UploadSessionFinishError result = new UploadSessionFinishError();
        result._tag = _tag;
        result.propertiesErrorValue = propertiesErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UploadSessionFinishError}. </p>
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
     * Tag#LOOKUP_FAILED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#LOOKUP_FAILED}, {@code false} otherwise.
     */
    public boolean isLookupFailed() {
        return this._tag == Tag.LOOKUP_FAILED;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#LOOKUP_FAILED}.
     *
     * <p> The session arguments are incorrect; the value explains the reason.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishError} with its tag set to
     *     {@link Tag#LOOKUP_FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishError lookupFailed(UploadSessionLookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError().withTagAndLookupFailed(Tag.LOOKUP_FAILED, value);
    }

    /**
     * The session arguments are incorrect; the value explains the reason.
     *
     * <p> This instance must be tagged as {@link Tag#LOOKUP_FAILED}. </p>
     *
     * @return The {@link UploadSessionLookupError} value associated with this
     *     instance if {@link #isLookupFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isLookupFailed} is {@code
     *     false}.
     */
    public UploadSessionLookupError getLookupFailedValue() {
        if (this._tag != Tag.LOOKUP_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.LOOKUP_FAILED, but was Tag." + this._tag.name());
        }
        return lookupFailedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#PATH}.
     *
     * <p> Unable to save the uploaded contents to a file. Data has already been
     * appended to the upload session. Please retry with empty data body and
     * updated offset. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishError} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishError path(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * Unable to save the uploaded contents to a file. Data has already been
     * appended to the upload session. Please retry with empty data body and
     * updated offset.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link WriteError} value associated with this instance if
     *     {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public WriteError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PROPERTIES_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PROPERTIES_ERROR}, {@code false} otherwise.
     */
    public boolean isPropertiesError() {
        return this._tag == Tag.PROPERTIES_ERROR;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#PROPERTIES_ERROR}.
     *
     * <p> The supplied property group is invalid. The file has uploaded without
     * property groups. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishError} with its tag set to
     *     {@link Tag#PROPERTIES_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishError propertiesError(InvalidPropertyGroupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError().withTagAndPropertiesError(Tag.PROPERTIES_ERROR, value);
    }

    /**
     * The supplied property group is invalid. The file has uploaded without
     * property groups.
     *
     * <p> This instance must be tagged as {@link Tag#PROPERTIES_ERROR}. </p>
     *
     * @return The {@link InvalidPropertyGroupError} value associated with this
     *     instance if {@link #isPropertiesError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPropertiesError} is {@code
     *     false}.
     */
    public InvalidPropertyGroupError getPropertiesErrorValue() {
        if (this._tag != Tag.PROPERTIES_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTIES_ERROR, but was Tag." + this._tag.name());
        }
        return propertiesErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_SHARED_FOLDER_TARGETS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_SHARED_FOLDER_TARGETS}, {@code false} otherwise.
     */
    public boolean isTooManySharedFolderTargets() {
        return this._tag == Tag.TOO_MANY_SHARED_FOLDER_TARGETS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_WRITE_OPERATIONS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_WRITE_OPERATIONS}, {@code false} otherwise.
     */
    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONCURRENT_SESSION_DATA_NOT_ALLOWED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONCURRENT_SESSION_DATA_NOT_ALLOWED}, {@code false} otherwise.
     */
    public boolean isConcurrentSessionDataNotAllowed() {
        return this._tag == Tag.CONCURRENT_SESSION_DATA_NOT_ALLOWED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONCURRENT_SESSION_NOT_CLOSED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONCURRENT_SESSION_NOT_CLOSED}, {@code false} otherwise.
     */
    public boolean isConcurrentSessionNotClosed() {
        return this._tag == Tag.CONCURRENT_SESSION_NOT_CLOSED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONCURRENT_SESSION_MISSING_DATA}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONCURRENT_SESSION_MISSING_DATA}, {@code false} otherwise.
     */
    public boolean isConcurrentSessionMissingData() {
        return this._tag == Tag.CONCURRENT_SESSION_MISSING_DATA;
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONTENT_HASH_MISMATCH}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONTENT_HASH_MISMATCH}, {@code false} otherwise.
     */
    public boolean isContentHashMismatch() {
        return this._tag == Tag.CONTENT_HASH_MISMATCH;
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
            this.lookupFailedValue,
            this.pathValue,
            this.propertiesErrorValue
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
        else if (obj instanceof UploadSessionFinishError) {
            UploadSessionFinishError other = (UploadSessionFinishError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case LOOKUP_FAILED:
                    return (this.lookupFailedValue == other.lookupFailedValue) || (this.lookupFailedValue.equals(other.lookupFailedValue));
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case PROPERTIES_ERROR:
                    return (this.propertiesErrorValue == other.propertiesErrorValue) || (this.propertiesErrorValue.equals(other.propertiesErrorValue));
                case TOO_MANY_SHARED_FOLDER_TARGETS:
                    return true;
                case TOO_MANY_WRITE_OPERATIONS:
                    return true;
                case CONCURRENT_SESSION_DATA_NOT_ALLOWED:
                    return true;
                case CONCURRENT_SESSION_NOT_CLOSED:
                    return true;
                case CONCURRENT_SESSION_MISSING_DATA:
                    return true;
                case PAYLOAD_TOO_LARGE:
                    return true;
                case CONTENT_HASH_MISMATCH:
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
    static class Serializer extends UnionSerializer<UploadSessionFinishError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionFinishError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case LOOKUP_FAILED: {
                    g.writeStartObject();
                    writeTag("lookup_failed", g);
                    g.writeFieldName("lookup_failed");
                    UploadSessionLookupError.Serializer.INSTANCE.serialize(value.lookupFailedValue, g);
                    g.writeEndObject();
                    break;
                }
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    WriteError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case PROPERTIES_ERROR: {
                    g.writeStartObject();
                    writeTag("properties_error", g);
                    g.writeFieldName("properties_error");
                    InvalidPropertyGroupError.Serializer.INSTANCE.serialize(value.propertiesErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case TOO_MANY_SHARED_FOLDER_TARGETS: {
                    g.writeString("too_many_shared_folder_targets");
                    break;
                }
                case TOO_MANY_WRITE_OPERATIONS: {
                    g.writeString("too_many_write_operations");
                    break;
                }
                case CONCURRENT_SESSION_DATA_NOT_ALLOWED: {
                    g.writeString("concurrent_session_data_not_allowed");
                    break;
                }
                case CONCURRENT_SESSION_NOT_CLOSED: {
                    g.writeString("concurrent_session_not_closed");
                    break;
                }
                case CONCURRENT_SESSION_MISSING_DATA: {
                    g.writeString("concurrent_session_missing_data");
                    break;
                }
                case PAYLOAD_TOO_LARGE: {
                    g.writeString("payload_too_large");
                    break;
                }
                case CONTENT_HASH_MISMATCH: {
                    g.writeString("content_hash_mismatch");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UploadSessionFinishError deserialize(JsonParser p) throws IOException, JsonParseException {
            UploadSessionFinishError value;
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
            else if ("lookup_failed".equals(tag)) {
                UploadSessionLookupError fieldValue = null;
                expectField("lookup_failed", p);
                fieldValue = UploadSessionLookupError.Serializer.INSTANCE.deserialize(p);
                value = UploadSessionFinishError.lookupFailed(fieldValue);
            }
            else if ("path".equals(tag)) {
                WriteError fieldValue = null;
                expectField("path", p);
                fieldValue = WriteError.Serializer.INSTANCE.deserialize(p);
                value = UploadSessionFinishError.path(fieldValue);
            }
            else if ("properties_error".equals(tag)) {
                InvalidPropertyGroupError fieldValue = null;
                expectField("properties_error", p);
                fieldValue = InvalidPropertyGroupError.Serializer.INSTANCE.deserialize(p);
                value = UploadSessionFinishError.propertiesError(fieldValue);
            }
            else if ("too_many_shared_folder_targets".equals(tag)) {
                value = UploadSessionFinishError.TOO_MANY_SHARED_FOLDER_TARGETS;
            }
            else if ("too_many_write_operations".equals(tag)) {
                value = UploadSessionFinishError.TOO_MANY_WRITE_OPERATIONS;
            }
            else if ("concurrent_session_data_not_allowed".equals(tag)) {
                value = UploadSessionFinishError.CONCURRENT_SESSION_DATA_NOT_ALLOWED;
            }
            else if ("concurrent_session_not_closed".equals(tag)) {
                value = UploadSessionFinishError.CONCURRENT_SESSION_NOT_CLOSED;
            }
            else if ("concurrent_session_missing_data".equals(tag)) {
                value = UploadSessionFinishError.CONCURRENT_SESSION_MISSING_DATA;
            }
            else if ("payload_too_large".equals(tag)) {
                value = UploadSessionFinishError.PAYLOAD_TOO_LARGE;
            }
            else if ("content_hash_mismatch".equals(tag)) {
                value = UploadSessionFinishError.CONTENT_HASH_MISMATCH;
            }
            else {
                value = UploadSessionFinishError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
