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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class UploadSessionFinishBatchResultEntry {
    // union UploadSessionFinishBatchResultEntry

    /**
     * Discriminating tag type for {@link UploadSessionFinishBatchResultEntry}.
     */
    public enum Tag {
        SUCCESS, // FileMetadata
        FAILURE; // UploadSessionFinishError
    }

    private final Tag tag;
    private final FileMetadata successValue;
    private final UploadSessionFinishError failureValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UploadSessionFinishBatchResultEntry(Tag tag, FileMetadata successValue, UploadSessionFinishError failureValue) {
        this.tag = tag;
        this.successValue = successValue;
        this.failureValue = failureValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UploadSessionFinishBatchResultEntry}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#SUCCESS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#SUCCESS},
     *     {@code false} otherwise.
     */
    public boolean isSuccess() {
        return this.tag == Tag.SUCCESS;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishBatchResultEntry} that
     * has its tag set to {@link Tag#SUCCESS}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishBatchResultEntry} with its
     *     tag set to {@link Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishBatchResultEntry success(FileMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishBatchResultEntry(Tag.SUCCESS, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#SUCCESS}.
     *
     * @return The {@link UploadSessionFinishBatchResultEntry#success} value
     *     associated with this instance if {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public FileMetadata getSuccessValue() {
        if (this.tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + tag.name());
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
        return this.tag == Tag.FAILURE;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishBatchResultEntry} that
     * has its tag set to {@link Tag#FAILURE}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishBatchResultEntry} with its
     *     tag set to {@link Tag#FAILURE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishBatchResultEntry failure(UploadSessionFinishError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishBatchResultEntry(Tag.FAILURE, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FAILURE}.
     *
     * @return The {@link UploadSessionFinishBatchResultEntry#failure} value
     *     associated with this instance if {@link #isFailure} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailure} is {@code false}.
     */
    public UploadSessionFinishError getFailureValue() {
        if (this.tag != Tag.FAILURE) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILURE, but was Tag." + tag.name());
        }
        return failureValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
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
        else if (obj instanceof UploadSessionFinishBatchResultEntry) {
            UploadSessionFinishBatchResultEntry other = (UploadSessionFinishBatchResultEntry) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
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
    static final class Serializer extends UnionSerializer<UploadSessionFinishBatchResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionFinishBatchResultEntry value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SUCCESS: {
                    g.writeStartObject();
                    writeTag("success", g);
                    g.writeFieldName("success");
                    FileMetadata.Serializer.INSTANCE.serialize(value.successValue, g);
                    g.writeEndObject();
                    break;
                }
                case FAILURE: {
                    g.writeStartObject();
                    writeTag("failure", g);
                    g.writeFieldName("failure");
                    UploadSessionFinishError.Serializer.INSTANCE.serialize(value.failureValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public UploadSessionFinishBatchResultEntry deserialize(JsonParser p) throws IOException, JsonParseException {
            UploadSessionFinishBatchResultEntry value;
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
                FileMetadata fieldValue = null;
                expectField("success", p);
                fieldValue = FileMetadata.Serializer.INSTANCE.deserialize(p);
                value = UploadSessionFinishBatchResultEntry.success(fieldValue);
            }
            else if ("failure".equals(tag)) {
                UploadSessionFinishError fieldValue = null;
                expectField("failure", p);
                fieldValue = UploadSessionFinishError.Serializer.INSTANCE.deserialize(p);
                value = UploadSessionFinishBatchResultEntry.failure(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
