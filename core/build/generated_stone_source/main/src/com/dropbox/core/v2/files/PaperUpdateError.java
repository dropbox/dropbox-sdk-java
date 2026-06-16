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
public final class PaperUpdateError {
    // union files.PaperUpdateError (files.stone)

    /**
     * Discriminating tag type for {@link PaperUpdateError}.
     */
    public enum Tag {
        /**
         * Your account does not have permissions to edit Paper docs.
         */
        INSUFFICIENT_PERMISSIONS,
        /**
         * The provided content was malformed and cannot be imported to Paper.
         */
        CONTENT_MALFORMED,
        /**
         * The Paper doc would be too large, split the content into multiple
         * docs.
         */
        DOC_LENGTH_EXCEEDED,
        /**
         * The imported document contains an image that is too large. The
         * current limit is 1MB. This only applies to HTML with data URI.
         */
        IMAGE_SIZE_EXCEEDED,
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER,
        PATH, // LookupError
        /**
         * The provided revision does not match the document head.
         */
        REVISION_MISMATCH,
        /**
         * This operation is not allowed on archived Paper docs.
         */
        DOC_ARCHIVED,
        /**
         * This operation is not allowed on deleted Paper docs.
         */
        DOC_DELETED;
    }

    /**
     * Your account does not have permissions to edit Paper docs.
     */
    public static final PaperUpdateError INSUFFICIENT_PERMISSIONS = new PaperUpdateError().withTag(Tag.INSUFFICIENT_PERMISSIONS);
    /**
     * The provided content was malformed and cannot be imported to Paper.
     */
    public static final PaperUpdateError CONTENT_MALFORMED = new PaperUpdateError().withTag(Tag.CONTENT_MALFORMED);
    /**
     * The Paper doc would be too large, split the content into multiple docs.
     */
    public static final PaperUpdateError DOC_LENGTH_EXCEEDED = new PaperUpdateError().withTag(Tag.DOC_LENGTH_EXCEEDED);
    /**
     * The imported document contains an image that is too large. The current
     * limit is 1MB. This only applies to HTML with data URI.
     */
    public static final PaperUpdateError IMAGE_SIZE_EXCEEDED = new PaperUpdateError().withTag(Tag.IMAGE_SIZE_EXCEEDED);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final PaperUpdateError OTHER = new PaperUpdateError().withTag(Tag.OTHER);
    /**
     * The provided revision does not match the document head.
     */
    public static final PaperUpdateError REVISION_MISMATCH = new PaperUpdateError().withTag(Tag.REVISION_MISMATCH);
    /**
     * This operation is not allowed on archived Paper docs.
     */
    public static final PaperUpdateError DOC_ARCHIVED = new PaperUpdateError().withTag(Tag.DOC_ARCHIVED);
    /**
     * This operation is not allowed on deleted Paper docs.
     */
    public static final PaperUpdateError DOC_DELETED = new PaperUpdateError().withTag(Tag.DOC_DELETED);

    private Tag _tag;
    private LookupError pathValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PaperUpdateError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PaperUpdateError withTag(Tag _tag) {
        PaperUpdateError result = new PaperUpdateError();
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
    private PaperUpdateError withTagAndPath(Tag _tag, LookupError pathValue) {
        PaperUpdateError result = new PaperUpdateError();
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
     * values for this {@code PaperUpdateError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_PERMISSIONS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_PERMISSIONS}, {@code false} otherwise.
     */
    public boolean isInsufficientPermissions() {
        return this._tag == Tag.INSUFFICIENT_PERMISSIONS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONTENT_MALFORMED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONTENT_MALFORMED}, {@code false} otherwise.
     */
    public boolean isContentMalformed() {
        return this._tag == Tag.CONTENT_MALFORMED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DOC_LENGTH_EXCEEDED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DOC_LENGTH_EXCEEDED}, {@code false} otherwise.
     */
    public boolean isDocLengthExceeded() {
        return this._tag == Tag.DOC_LENGTH_EXCEEDED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IMAGE_SIZE_EXCEEDED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IMAGE_SIZE_EXCEEDED}, {@code false} otherwise.
     */
    public boolean isImageSizeExceeded() {
        return this._tag == Tag.IMAGE_SIZE_EXCEEDED;
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
     * Returns an instance of {@code PaperUpdateError} that has its tag set to
     * {@link Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PaperUpdateError} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PaperUpdateError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PaperUpdateError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link LookupError} value associated with this instance if
     *     {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#REVISION_MISMATCH}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#REVISION_MISMATCH}, {@code false} otherwise.
     */
    public boolean isRevisionMismatch() {
        return this._tag == Tag.REVISION_MISMATCH;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DOC_ARCHIVED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DOC_ARCHIVED}, {@code false} otherwise.
     */
    public boolean isDocArchived() {
        return this._tag == Tag.DOC_ARCHIVED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DOC_DELETED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DOC_DELETED}, {@code false} otherwise.
     */
    public boolean isDocDeleted() {
        return this._tag == Tag.DOC_DELETED;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.pathValue
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
        else if (obj instanceof PaperUpdateError) {
            PaperUpdateError other = (PaperUpdateError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INSUFFICIENT_PERMISSIONS:
                    return true;
                case CONTENT_MALFORMED:
                    return true;
                case DOC_LENGTH_EXCEEDED:
                    return true;
                case IMAGE_SIZE_EXCEEDED:
                    return true;
                case OTHER:
                    return true;
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case REVISION_MISMATCH:
                    return true;
                case DOC_ARCHIVED:
                    return true;
                case DOC_DELETED:
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
    static class Serializer extends UnionSerializer<PaperUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperUpdateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INSUFFICIENT_PERMISSIONS: {
                    g.writeString("insufficient_permissions");
                    break;
                }
                case CONTENT_MALFORMED: {
                    g.writeString("content_malformed");
                    break;
                }
                case DOC_LENGTH_EXCEEDED: {
                    g.writeString("doc_length_exceeded");
                    break;
                }
                case IMAGE_SIZE_EXCEEDED: {
                    g.writeString("image_size_exceeded");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case REVISION_MISMATCH: {
                    g.writeString("revision_mismatch");
                    break;
                }
                case DOC_ARCHIVED: {
                    g.writeString("doc_archived");
                    break;
                }
                case DOC_DELETED: {
                    g.writeString("doc_deleted");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public PaperUpdateError deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperUpdateError value;
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
            else if ("insufficient_permissions".equals(tag)) {
                value = PaperUpdateError.INSUFFICIENT_PERMISSIONS;
            }
            else if ("content_malformed".equals(tag)) {
                value = PaperUpdateError.CONTENT_MALFORMED;
            }
            else if ("doc_length_exceeded".equals(tag)) {
                value = PaperUpdateError.DOC_LENGTH_EXCEEDED;
            }
            else if ("image_size_exceeded".equals(tag)) {
                value = PaperUpdateError.IMAGE_SIZE_EXCEEDED;
            }
            else if ("other".equals(tag)) {
                value = PaperUpdateError.OTHER;
            }
            else if ("path".equals(tag)) {
                LookupError fieldValue = null;
                expectField("path", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = PaperUpdateError.path(fieldValue);
            }
            else if ("revision_mismatch".equals(tag)) {
                value = PaperUpdateError.REVISION_MISMATCH;
            }
            else if ("doc_archived".equals(tag)) {
                value = PaperUpdateError.DOC_ARCHIVED;
            }
            else if ("doc_deleted".equals(tag)) {
                value = PaperUpdateError.DOC_DELETED;
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
