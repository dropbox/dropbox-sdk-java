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
public final class RelocationBatchErrorEntry {
    // union files.RelocationBatchErrorEntry (files.stone)

    /**
     * Discriminating tag type for {@link RelocationBatchErrorEntry}.
     */
    public enum Tag {
        /**
         * User errors that retry won't help.
         */
        RELOCATION_ERROR, // RelocationError
        /**
         * Something went wrong with the job on Dropbox's end. You'll need to
         * verify that the action you were taking succeeded, and if not, try
         * again. This should happen very rarely.
         */
        INTERNAL_ERROR,
        /**
         * There are too many write operations in user's Dropbox. Please retry
         * this request.
         */
        TOO_MANY_WRITE_OPERATIONS,
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
     * Something went wrong with the job on Dropbox's end. You'll need to verify
     * that the action you were taking succeeded, and if not, try again. This
     * should happen very rarely.
     */
    public static final RelocationBatchErrorEntry INTERNAL_ERROR = new RelocationBatchErrorEntry().withTag(Tag.INTERNAL_ERROR);
    /**
     * There are too many write operations in user's Dropbox. Please retry this
     * request.
     */
    public static final RelocationBatchErrorEntry TOO_MANY_WRITE_OPERATIONS = new RelocationBatchErrorEntry().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final RelocationBatchErrorEntry OTHER = new RelocationBatchErrorEntry().withTag(Tag.OTHER);

    private Tag _tag;
    private RelocationError relocationErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RelocationBatchErrorEntry() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RelocationBatchErrorEntry withTag(Tag _tag) {
        RelocationBatchErrorEntry result = new RelocationBatchErrorEntry();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param relocationErrorValue  User errors that retry won't help. Must not
     *     be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchErrorEntry withTagAndRelocationError(Tag _tag, RelocationError relocationErrorValue) {
        RelocationBatchErrorEntry result = new RelocationBatchErrorEntry();
        result._tag = _tag;
        result.relocationErrorValue = relocationErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RelocationBatchErrorEntry}. </p>
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
     * Tag#RELOCATION_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RELOCATION_ERROR}, {@code false} otherwise.
     */
    public boolean isRelocationError() {
        return this._tag == Tag.RELOCATION_ERROR;
    }

    /**
     * Returns an instance of {@code RelocationBatchErrorEntry} that has its tag
     * set to {@link Tag#RELOCATION_ERROR}.
     *
     * <p> User errors that retry won't help. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchErrorEntry} with its tag set to
     *     {@link Tag#RELOCATION_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchErrorEntry relocationError(RelocationError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchErrorEntry().withTagAndRelocationError(Tag.RELOCATION_ERROR, value);
    }

    /**
     * User errors that retry won't help.
     *
     * <p> This instance must be tagged as {@link Tag#RELOCATION_ERROR}. </p>
     *
     * @return The {@link RelocationError} value associated with this instance
     *     if {@link #isRelocationError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isRelocationError} is {@code
     *     false}.
     */
    public RelocationError getRelocationErrorValue() {
        if (this._tag != Tag.RELOCATION_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.RELOCATION_ERROR, but was Tag." + this._tag.name());
        }
        return relocationErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INTERNAL_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INTERNAL_ERROR}, {@code false} otherwise.
     */
    public boolean isInternalError() {
        return this._tag == Tag.INTERNAL_ERROR;
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
            relocationErrorValue
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
        else if (obj instanceof RelocationBatchErrorEntry) {
            RelocationBatchErrorEntry other = (RelocationBatchErrorEntry) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case RELOCATION_ERROR:
                    return (this.relocationErrorValue == other.relocationErrorValue) || (this.relocationErrorValue.equals(other.relocationErrorValue));
                case INTERNAL_ERROR:
                    return true;
                case TOO_MANY_WRITE_OPERATIONS:
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
    static class Serializer extends UnionSerializer<RelocationBatchErrorEntry> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationBatchErrorEntry value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case RELOCATION_ERROR: {
                    g.writeStartObject();
                    writeTag("relocation_error", g);
                    g.writeFieldName("relocation_error");
                    RelocationError.Serializer.INSTANCE.serialize(value.relocationErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case INTERNAL_ERROR: {
                    g.writeString("internal_error");
                    break;
                }
                case TOO_MANY_WRITE_OPERATIONS: {
                    g.writeString("too_many_write_operations");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public RelocationBatchErrorEntry deserialize(JsonParser p) throws IOException, JsonParseException {
            RelocationBatchErrorEntry value;
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
            else if ("relocation_error".equals(tag)) {
                RelocationError fieldValue = null;
                expectField("relocation_error", p);
                fieldValue = RelocationError.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchErrorEntry.relocationError(fieldValue);
            }
            else if ("internal_error".equals(tag)) {
                value = RelocationBatchErrorEntry.INTERNAL_ERROR;
            }
            else if ("too_many_write_operations".equals(tag)) {
                value = RelocationBatchErrorEntry.TOO_MANY_WRITE_OPERATIONS;
            }
            else {
                value = RelocationBatchErrorEntry.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
