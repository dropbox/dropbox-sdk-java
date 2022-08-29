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
public final class SaveCopyReferenceError {
    // union files.SaveCopyReferenceError (files.stone)

    /**
     * Discriminating tag type for {@link SaveCopyReferenceError}.
     */
    public enum Tag {
        PATH, // WriteError
        /**
         * The copy reference is invalid.
         */
        INVALID_COPY_REFERENCE,
        /**
         * You don't have permission to save the given copy reference. Please
         * make sure this app is same app which created the copy reference and
         * the source user is still linked to the app.
         */
        NO_PERMISSION,
        /**
         * The file referenced by the copy reference cannot be found.
         */
        NOT_FOUND,
        /**
         * The operation would involve more than 10,000 files and folders.
         */
        TOO_MANY_FILES,
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
     * The copy reference is invalid.
     */
    public static final SaveCopyReferenceError INVALID_COPY_REFERENCE = new SaveCopyReferenceError().withTag(Tag.INVALID_COPY_REFERENCE);
    /**
     * You don't have permission to save the given copy reference. Please make
     * sure this app is same app which created the copy reference and the source
     * user is still linked to the app.
     */
    public static final SaveCopyReferenceError NO_PERMISSION = new SaveCopyReferenceError().withTag(Tag.NO_PERMISSION);
    /**
     * The file referenced by the copy reference cannot be found.
     */
    public static final SaveCopyReferenceError NOT_FOUND = new SaveCopyReferenceError().withTag(Tag.NOT_FOUND);
    /**
     * The operation would involve more than 10,000 files and folders.
     */
    public static final SaveCopyReferenceError TOO_MANY_FILES = new SaveCopyReferenceError().withTag(Tag.TOO_MANY_FILES);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SaveCopyReferenceError OTHER = new SaveCopyReferenceError().withTag(Tag.OTHER);

    private Tag _tag;
    private WriteError pathValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private SaveCopyReferenceError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private SaveCopyReferenceError withTag(Tag _tag) {
        SaveCopyReferenceError result = new SaveCopyReferenceError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private SaveCopyReferenceError withTagAndPath(Tag _tag, WriteError pathValue) {
        SaveCopyReferenceError result = new SaveCopyReferenceError();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code SaveCopyReferenceError}. </p>
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
     * Returns an instance of {@code SaveCopyReferenceError} that has its tag
     * set to {@link Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SaveCopyReferenceError} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SaveCopyReferenceError path(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveCopyReferenceError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
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
     * Tag#INVALID_COPY_REFERENCE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_COPY_REFERENCE}, {@code false} otherwise.
     */
    public boolean isInvalidCopyReference() {
        return this._tag == Tag.INVALID_COPY_REFERENCE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
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
     * Tag#TOO_MANY_FILES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_FILES}, {@code false} otherwise.
     */
    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
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
            pathValue
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
        else if (obj instanceof SaveCopyReferenceError) {
            SaveCopyReferenceError other = (SaveCopyReferenceError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case INVALID_COPY_REFERENCE:
                    return true;
                case NO_PERMISSION:
                    return true;
                case NOT_FOUND:
                    return true;
                case TOO_MANY_FILES:
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
    static class Serializer extends UnionSerializer<SaveCopyReferenceError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SaveCopyReferenceError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    WriteError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case INVALID_COPY_REFERENCE: {
                    g.writeString("invalid_copy_reference");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                case NOT_FOUND: {
                    g.writeString("not_found");
                    break;
                }
                case TOO_MANY_FILES: {
                    g.writeString("too_many_files");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SaveCopyReferenceError deserialize(JsonParser p) throws IOException, JsonParseException {
            SaveCopyReferenceError value;
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
            else if ("path".equals(tag)) {
                WriteError fieldValue = null;
                expectField("path", p);
                fieldValue = WriteError.Serializer.INSTANCE.deserialize(p);
                value = SaveCopyReferenceError.path(fieldValue);
            }
            else if ("invalid_copy_reference".equals(tag)) {
                value = SaveCopyReferenceError.INVALID_COPY_REFERENCE;
            }
            else if ("no_permission".equals(tag)) {
                value = SaveCopyReferenceError.NO_PERMISSION;
            }
            else if ("not_found".equals(tag)) {
                value = SaveCopyReferenceError.NOT_FOUND;
            }
            else if ("too_many_files".equals(tag)) {
                value = SaveCopyReferenceError.TOO_MANY_FILES;
            }
            else {
                value = SaveCopyReferenceError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
