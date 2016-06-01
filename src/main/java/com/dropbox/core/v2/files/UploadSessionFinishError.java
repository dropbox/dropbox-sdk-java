/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

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
    // union UploadSessionFinishError

    /**
     * Discriminating tag type for {@link UploadSessionFinishError}.
     */
    public enum Tag {
        /**
         * The session arguments are incorrect; the value explains the reason.
         */
        LOOKUP_FAILED, // UploadSessionLookupError
        /**
         * Unable to save the uploaded contents to a file.
         */
        PATH, // WriteError
        /**
         * The batch request commits files into too many different shared
         * folders. Please limit your batch request to files contained in a
         * single shared folder.
         */
        TOO_MANY_SHARED_FOLDER_TARGETS,
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    /**
     * The batch request commits files into too many different shared folders.
     * Please limit your batch request to files contained in a single shared
     * folder.
     */
    public static final UploadSessionFinishError TOO_MANY_SHARED_FOLDER_TARGETS = new UploadSessionFinishError(Tag.TOO_MANY_SHARED_FOLDER_TARGETS, null, null);
    /**
     * An unspecified error.
     */
    public static final UploadSessionFinishError OTHER = new UploadSessionFinishError(Tag.OTHER, null, null);

    private final Tag tag;
    private final UploadSessionLookupError lookupFailedValue;
    private final WriteError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UploadSessionFinishError(Tag tag, UploadSessionLookupError lookupFailedValue, WriteError pathValue) {
        this.tag = tag;
        this.lookupFailedValue = lookupFailedValue;
        this.pathValue = pathValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#LOOKUP_FAILED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#LOOKUP_FAILED}, {@code false} otherwise.
     */
    public boolean isLookupFailed() {
        return this.tag == Tag.LOOKUP_FAILED;
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
        return new UploadSessionFinishError(Tag.LOOKUP_FAILED, value, null);
    }

    /**
     * The session arguments are incorrect; the value explains the reason.
     *
     * <p> This instance must be tagged as {@link Tag#LOOKUP_FAILED}. </p>
     *
     * @return The {@link UploadSessionFinishError#lookupFailed} value
     *     associated with this instance if {@link #isLookupFailed} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isLookupFailed} is {@code
     *     false}.
     */
    public UploadSessionLookupError getLookupFailedValue() {
        if (this.tag != Tag.LOOKUP_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.LOOKUP_FAILED, but was Tag." + tag.name());
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
        return this.tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#PATH}.
     *
     * <p> Unable to save the uploaded contents to a file. </p>
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
        return new UploadSessionFinishError(Tag.PATH, null, value);
    }

    /**
     * Unable to save the uploaded contents to a file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link UploadSessionFinishError#path} value associated with
     *     this instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public WriteError getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_SHARED_FOLDER_TARGETS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_SHARED_FOLDER_TARGETS}, {@code false} otherwise.
     */
    public boolean isTooManySharedFolderTargets() {
        return this.tag == Tag.TOO_MANY_SHARED_FOLDER_TARGETS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            lookupFailedValue,
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UploadSessionFinishError) {
            UploadSessionFinishError other = (UploadSessionFinishError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case LOOKUP_FAILED:
                    return (this.lookupFailedValue == other.lookupFailedValue) || (this.lookupFailedValue.equals(other.lookupFailedValue));
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case TOO_MANY_SHARED_FOLDER_TARGETS:
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
    static final class Serializer extends UnionSerializer<UploadSessionFinishError> {
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
                case TOO_MANY_SHARED_FOLDER_TARGETS: {
                    g.writeString("too_many_shared_folder_targets");
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
            else if ("too_many_shared_folder_targets".equals(tag)) {
                value = UploadSessionFinishError.TOO_MANY_SHARED_FOLDER_TARGETS;
            }
            else {
                value = UploadSessionFinishError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
