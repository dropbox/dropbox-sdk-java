/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

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
public final class UpdateFileRequestDeadline {
    // union file_requests.UpdateFileRequestDeadline (file_requests.stone)

    /**
     * Discriminating tag type for {@link UpdateFileRequestDeadline}.
     */
    public enum Tag {
        /**
         * Do not change the file request's deadline.
         */
        NO_UPDATE,
        /**
         * If {@code null}, the file request's deadline is cleared.
         */
        UPDATE, // FileRequestDeadline
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
     * Do not change the file request's deadline.
     */
    public static final UpdateFileRequestDeadline NO_UPDATE = new UpdateFileRequestDeadline().withTag(Tag.NO_UPDATE);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UpdateFileRequestDeadline OTHER = new UpdateFileRequestDeadline().withTag(Tag.OTHER);

    private Tag _tag;
    private FileRequestDeadline updateValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UpdateFileRequestDeadline() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UpdateFileRequestDeadline withTag(Tag _tag) {
        UpdateFileRequestDeadline result = new UpdateFileRequestDeadline();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param updateValue  If {@code null}, the file request's deadline is
     *     cleared.
     * @param _tag  Discriminating tag for this instance.
     */
    private UpdateFileRequestDeadline withTagAndUpdate(Tag _tag, FileRequestDeadline updateValue) {
        UpdateFileRequestDeadline result = new UpdateFileRequestDeadline();
        result._tag = _tag;
        result.updateValue = updateValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UpdateFileRequestDeadline}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#NO_UPDATE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#NO_UPDATE},
     *     {@code false} otherwise.
     */
    public boolean isNoUpdate() {
        return this._tag == Tag.NO_UPDATE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#UPDATE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#UPDATE},
     *     {@code false} otherwise.
     */
    public boolean isUpdate() {
        return this._tag == Tag.UPDATE;
    }

    /**
     * Returns an instance of {@code UpdateFileRequestDeadline} that has its tag
     * set to {@link Tag#UPDATE}.
     *
     * <p> If {@code null}, the file request's deadline is cleared. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UpdateFileRequestDeadline} with its tag set to
     *     {@link Tag#UPDATE}.
     */
    public static UpdateFileRequestDeadline update(FileRequestDeadline value) {
        return new UpdateFileRequestDeadline().withTagAndUpdate(Tag.UPDATE, value);
    }

    /**
     * Returns an instance of {@code UpdateFileRequestDeadline} that has its tag
     * set to {@link Tag#UPDATE}.
     *
     * <p> If {@code null}, the file request's deadline is cleared. </p>
     *
     * @return Instance of {@code UpdateFileRequestDeadline} with its tag set to
     *     {@link Tag#UPDATE}.
     */
    public static UpdateFileRequestDeadline update() {
        return update(null);
    }

    /**
     * If {@code null}, the file request's deadline is cleared.
     *
     * <p> This instance must be tagged as {@link Tag#UPDATE}. </p>
     *
     * @return The {@link FileRequestDeadline} value associated with this
     *     instance if {@link #isUpdate} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUpdate} is {@code false}.
     */
    public FileRequestDeadline getUpdateValue() {
        if (this._tag != Tag.UPDATE) {
            throw new IllegalStateException("Invalid tag: required Tag.UPDATE, but was Tag." + this._tag.name());
        }
        return updateValue;
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
            updateValue
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
        else if (obj instanceof UpdateFileRequestDeadline) {
            UpdateFileRequestDeadline other = (UpdateFileRequestDeadline) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case NO_UPDATE:
                    return true;
                case UPDATE:
                    return (this.updateValue == other.updateValue) || (this.updateValue != null && this.updateValue.equals(other.updateValue));
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
    static class Serializer extends UnionSerializer<UpdateFileRequestDeadline> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdateFileRequestDeadline value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case NO_UPDATE: {
                    g.writeString("no_update");
                    break;
                }
                case UPDATE: {
                    g.writeStartObject();
                    writeTag("update", g);
                    StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(value.updateValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UpdateFileRequestDeadline deserialize(JsonParser p) throws IOException, JsonParseException {
            UpdateFileRequestDeadline value;
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
            else if ("no_update".equals(tag)) {
                value = UpdateFileRequestDeadline.NO_UPDATE;
            }
            else if ("update".equals(tag)) {
                FileRequestDeadline fieldValue = null;
                if (p.getCurrentToken() != JsonToken.END_OBJECT) {
                    fieldValue = StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(p, true);
                }
                if (fieldValue == null) {
                    value = UpdateFileRequestDeadline.update();
                }
                else {
                    value = UpdateFileRequestDeadline.update(fieldValue);
                }
            }
            else {
                value = UpdateFileRequestDeadline.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
