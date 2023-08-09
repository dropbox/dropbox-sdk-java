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
public final class RestoreError {
    // union files.RestoreError (files.stone)

    /**
     * Discriminating tag type for {@link RestoreError}.
     */
    public enum Tag {
        /**
         * An error occurs when downloading metadata for the file.
         */
        PATH_LOOKUP, // LookupError
        /**
         * An error occurs when trying to restore the file to that path.
         */
        PATH_WRITE, // WriteError
        /**
         * The revision is invalid. It may not exist or may point to a deleted
         * file.
         */
        INVALID_REVISION,
        /**
         * The restore is currently executing, but has not yet completed.
         */
        IN_PROGRESS,
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
     * The revision is invalid. It may not exist or may point to a deleted file.
     */
    public static final RestoreError INVALID_REVISION = new RestoreError().withTag(Tag.INVALID_REVISION);
    /**
     * The restore is currently executing, but has not yet completed.
     */
    public static final RestoreError IN_PROGRESS = new RestoreError().withTag(Tag.IN_PROGRESS);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final RestoreError OTHER = new RestoreError().withTag(Tag.OTHER);

    private Tag _tag;
    private LookupError pathLookupValue;
    private WriteError pathWriteValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RestoreError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RestoreError withTag(Tag _tag) {
        RestoreError result = new RestoreError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathLookupValue  An error occurs when downloading metadata for the
     *     file. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RestoreError withTagAndPathLookup(Tag _tag, LookupError pathLookupValue) {
        RestoreError result = new RestoreError();
        result._tag = _tag;
        result.pathLookupValue = pathLookupValue;
        return result;
    }

    /**
     *
     * @param pathWriteValue  An error occurs when trying to restore the file to
     *     that path. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RestoreError withTagAndPathWrite(Tag _tag, WriteError pathWriteValue) {
        RestoreError result = new RestoreError();
        result._tag = _tag;
        result.pathWriteValue = pathWriteValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RestoreError}. </p>
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
     * Tag#PATH_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PATH_LOOKUP}, {@code false} otherwise.
     */
    public boolean isPathLookup() {
        return this._tag == Tag.PATH_LOOKUP;
    }

    /**
     * Returns an instance of {@code RestoreError} that has its tag set to
     * {@link Tag#PATH_LOOKUP}.
     *
     * <p> An error occurs when downloading metadata for the file. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RestoreError} with its tag set to {@link
     *     Tag#PATH_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RestoreError pathLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError().withTagAndPathLookup(Tag.PATH_LOOKUP, value);
    }

    /**
     * An error occurs when downloading metadata for the file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH_LOOKUP}. </p>
     *
     * @return The {@link LookupError} value associated with this instance if
     *     {@link #isPathLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPathLookup} is {@code false}.
     */
    public LookupError getPathLookupValue() {
        if (this._tag != Tag.PATH_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_LOOKUP, but was Tag." + this._tag.name());
        }
        return pathLookupValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH_WRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PATH_WRITE}, {@code false} otherwise.
     */
    public boolean isPathWrite() {
        return this._tag == Tag.PATH_WRITE;
    }

    /**
     * Returns an instance of {@code RestoreError} that has its tag set to
     * {@link Tag#PATH_WRITE}.
     *
     * <p> An error occurs when trying to restore the file to that path. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RestoreError} with its tag set to {@link
     *     Tag#PATH_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RestoreError pathWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError().withTagAndPathWrite(Tag.PATH_WRITE, value);
    }

    /**
     * An error occurs when trying to restore the file to that path.
     *
     * <p> This instance must be tagged as {@link Tag#PATH_WRITE}. </p>
     *
     * @return The {@link WriteError} value associated with this instance if
     *     {@link #isPathWrite} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPathWrite} is {@code false}.
     */
    public WriteError getPathWriteValue() {
        if (this._tag != Tag.PATH_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_WRITE, but was Tag." + this._tag.name());
        }
        return pathWriteValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_REVISION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_REVISION}, {@code false} otherwise.
     */
    public boolean isInvalidRevision() {
        return this._tag == Tag.INVALID_REVISION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
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
            pathLookupValue,
            pathWriteValue
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
        else if (obj instanceof RestoreError) {
            RestoreError other = (RestoreError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH_LOOKUP:
                    return (this.pathLookupValue == other.pathLookupValue) || (this.pathLookupValue.equals(other.pathLookupValue));
                case PATH_WRITE:
                    return (this.pathWriteValue == other.pathWriteValue) || (this.pathWriteValue.equals(other.pathWriteValue));
                case INVALID_REVISION:
                    return true;
                case IN_PROGRESS:
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
    static class Serializer extends UnionSerializer<RestoreError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RestoreError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH_LOOKUP: {
                    g.writeStartObject();
                    writeTag("path_lookup", g);
                    g.writeFieldName("path_lookup");
                    LookupError.Serializer.INSTANCE.serialize(value.pathLookupValue, g);
                    g.writeEndObject();
                    break;
                }
                case PATH_WRITE: {
                    g.writeStartObject();
                    writeTag("path_write", g);
                    g.writeFieldName("path_write");
                    WriteError.Serializer.INSTANCE.serialize(value.pathWriteValue, g);
                    g.writeEndObject();
                    break;
                }
                case INVALID_REVISION: {
                    g.writeString("invalid_revision");
                    break;
                }
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public RestoreError deserialize(JsonParser p) throws IOException, JsonParseException {
            RestoreError value;
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
            else if ("path_lookup".equals(tag)) {
                LookupError fieldValue = null;
                expectField("path_lookup", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = RestoreError.pathLookup(fieldValue);
            }
            else if ("path_write".equals(tag)) {
                WriteError fieldValue = null;
                expectField("path_write", p);
                fieldValue = WriteError.Serializer.INSTANCE.deserialize(p);
                value = RestoreError.pathWrite(fieldValue);
            }
            else if ("invalid_revision".equals(tag)) {
                value = RestoreError.INVALID_REVISION;
            }
            else if ("in_progress".equals(tag)) {
                value = RestoreError.IN_PROGRESS;
            }
            else {
                value = RestoreError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
