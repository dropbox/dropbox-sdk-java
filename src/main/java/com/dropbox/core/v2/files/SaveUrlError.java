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
public final class SaveUrlError {
    // union SaveUrlError

    /**
     * Discriminating tag type for {@link SaveUrlError}.
     */
    public enum Tag {
        PATH, // WriteError
        /**
         * Failed downloading the given URL.
         */
        DOWNLOAD_FAILED,
        /**
         * The given URL is invalid.
         */
        INVALID_URL,
        /**
         * The file where the URL is saved to no longer exists.
         */
        NOT_FOUND,
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
     * Failed downloading the given URL.
     */
    public static final SaveUrlError DOWNLOAD_FAILED = new SaveUrlError(Tag.DOWNLOAD_FAILED, null);
    /**
     * The given URL is invalid.
     */
    public static final SaveUrlError INVALID_URL = new SaveUrlError(Tag.INVALID_URL, null);
    /**
     * The file where the URL is saved to no longer exists.
     */
    public static final SaveUrlError NOT_FOUND = new SaveUrlError(Tag.NOT_FOUND, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SaveUrlError OTHER = new SaveUrlError(Tag.OTHER, null);

    private final Tag tag;
    private final WriteError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private SaveUrlError(Tag tag, WriteError pathValue) {
        this.tag = tag;
        this.pathValue = pathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code SaveUrlError}. </p>
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
     * Returns an instance of {@code SaveUrlError} that has its tag set to
     * {@link Tag#PATH}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SaveUrlError} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SaveUrlError path(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveUrlError(Tag.PATH, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link SaveUrlError#path} value associated with this instance
     *     if {@link #isPath} is {@code true}.
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
     * Tag#DOWNLOAD_FAILED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DOWNLOAD_FAILED}, {@code false} otherwise.
     */
    public boolean isDownloadFailed() {
        return this.tag == Tag.DOWNLOAD_FAILED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_URL}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_URL}, {@code false} otherwise.
     */
    public boolean isInvalidUrl() {
        return this.tag == Tag.INVALID_URL;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOUND},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#NOT_FOUND},
     *     {@code false} otherwise.
     */
    public boolean isNotFound() {
        return this.tag == Tag.NOT_FOUND;
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
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof SaveUrlError) {
            SaveUrlError other = (SaveUrlError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case DOWNLOAD_FAILED:
                    return true;
                case INVALID_URL:
                    return true;
                case NOT_FOUND:
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
    static final class Serializer extends UnionSerializer<SaveUrlError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SaveUrlError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    WriteError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case DOWNLOAD_FAILED: {
                    g.writeString("download_failed");
                    break;
                }
                case INVALID_URL: {
                    g.writeString("invalid_url");
                    break;
                }
                case NOT_FOUND: {
                    g.writeString("not_found");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SaveUrlError deserialize(JsonParser p) throws IOException, JsonParseException {
            SaveUrlError value;
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
                value = SaveUrlError.path(fieldValue);
            }
            else if ("download_failed".equals(tag)) {
                value = SaveUrlError.DOWNLOAD_FAILED;
            }
            else if ("invalid_url".equals(tag)) {
                value = SaveUrlError.INVALID_URL;
            }
            else if ("not_found".equals(tag)) {
                value = SaveUrlError.NOT_FOUND;
            }
            else {
                value = SaveUrlError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
