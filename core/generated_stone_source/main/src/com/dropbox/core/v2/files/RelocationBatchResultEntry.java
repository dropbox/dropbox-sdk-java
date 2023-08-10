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
public final class RelocationBatchResultEntry {
    // union files.RelocationBatchResultEntry (files.stone)

    /**
     * Discriminating tag type for {@link RelocationBatchResultEntry}.
     */
    public enum Tag {
        SUCCESS, // Metadata
        FAILURE, // RelocationBatchErrorEntry
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
    public static final RelocationBatchResultEntry OTHER = new RelocationBatchResultEntry().withTag(Tag.OTHER);

    private Tag _tag;
    private Metadata successValue;
    private RelocationBatchErrorEntry failureValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RelocationBatchResultEntry() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RelocationBatchResultEntry withTag(Tag _tag) {
        RelocationBatchResultEntry result = new RelocationBatchResultEntry();
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
    private RelocationBatchResultEntry withTagAndSuccess(Tag _tag, Metadata successValue) {
        RelocationBatchResultEntry result = new RelocationBatchResultEntry();
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
    private RelocationBatchResultEntry withTagAndFailure(Tag _tag, RelocationBatchErrorEntry failureValue) {
        RelocationBatchResultEntry result = new RelocationBatchResultEntry();
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
     * values for this {@code RelocationBatchResultEntry}. </p>
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
     * Returns an instance of {@code RelocationBatchResultEntry} that has its
     * tag set to {@link Tag#SUCCESS}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchResultEntry} with its tag set
     *     to {@link Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchResultEntry success(Metadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchResultEntry().withTagAndSuccess(Tag.SUCCESS, value);
    }

    /**
     * This instance must be tagged as {@link Tag#SUCCESS}.
     *
     * @return The {@link Metadata} value associated with this instance if
     *     {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public Metadata getSuccessValue() {
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
     * Returns an instance of {@code RelocationBatchResultEntry} that has its
     * tag set to {@link Tag#FAILURE}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchResultEntry} with its tag set
     *     to {@link Tag#FAILURE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchResultEntry failure(RelocationBatchErrorEntry value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchResultEntry().withTagAndFailure(Tag.FAILURE, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FAILURE}.
     *
     * @return The {@link RelocationBatchErrorEntry} value associated with this
     *     instance if {@link #isFailure} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailure} is {@code false}.
     */
    public RelocationBatchErrorEntry getFailureValue() {
        if (this._tag != Tag.FAILURE) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILURE, but was Tag." + this._tag.name());
        }
        return failureValue;
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
        else if (obj instanceof RelocationBatchResultEntry) {
            RelocationBatchResultEntry other = (RelocationBatchResultEntry) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case FAILURE:
                    return (this.failureValue == other.failureValue) || (this.failureValue.equals(other.failureValue));
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
    static class Serializer extends UnionSerializer<RelocationBatchResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationBatchResultEntry value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    g.writeFieldName("success");
                    Metadata.Serializer.INSTANCE.serialize(value.successValue, g);
                    g.writeEndObject();
                    break;
                }
                case FAILURE: {
                    g.writeStartObject();
                    writeTag("failure", g);
                    g.writeFieldName("failure");
                    RelocationBatchErrorEntry.Serializer.INSTANCE.serialize(value.failureValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public RelocationBatchResultEntry deserialize(JsonParser p) throws IOException, JsonParseException {
            RelocationBatchResultEntry value;
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
                Metadata fieldValue = null;
                expectField("success", p);
                fieldValue = Metadata.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchResultEntry.success(fieldValue);
            }
            else if ("failure".equals(tag)) {
                RelocationBatchErrorEntry fieldValue = null;
                expectField("failure", p);
                fieldValue = RelocationBatchErrorEntry.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchResultEntry.failure(fieldValue);
            }
            else {
                value = RelocationBatchResultEntry.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
