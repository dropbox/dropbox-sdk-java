/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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
public final class GetFileMetadataIndividualResult {
    // union GetFileMetadataIndividualResult

    /**
     * Discriminating tag type for {@link GetFileMetadataIndividualResult}.
     */
    public enum Tag {
        /**
         * The result for this file if it was successful.
         */
        METADATA, // SharedFileMetadata
        /**
         * The result for this file if it was an error.
         */
        ACCESS_ERROR, // SharingFileAccessError
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
    public static final GetFileMetadataIndividualResult OTHER = new GetFileMetadataIndividualResult(Tag.OTHER, null, null);

    private final Tag tag;
    private final SharedFileMetadata metadataValue;
    private final SharingFileAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private GetFileMetadataIndividualResult(Tag tag, SharedFileMetadata metadataValue, SharingFileAccessError accessErrorValue) {
        this.tag = tag;
        this.metadataValue = metadataValue;
        this.accessErrorValue = accessErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GetFileMetadataIndividualResult}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#METADATA},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#METADATA},
     *     {@code false} otherwise.
     */
    public boolean isMetadata() {
        return this.tag == Tag.METADATA;
    }

    /**
     * Returns an instance of {@code GetFileMetadataIndividualResult} that has
     * its tag set to {@link Tag#METADATA}.
     *
     * <p> The result for this file if it was successful. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GetFileMetadataIndividualResult} with its tag
     *     set to {@link Tag#METADATA}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static GetFileMetadataIndividualResult metadata(SharedFileMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetFileMetadataIndividualResult(Tag.METADATA, value, null);
    }

    /**
     * The result for this file if it was successful.
     *
     * <p> This instance must be tagged as {@link Tag#METADATA}. </p>
     *
     * @return The {@link GetFileMetadataIndividualResult#metadata} value
     *     associated with this instance if {@link #isMetadata} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMetadata} is {@code false}.
     */
    public SharedFileMetadata getMetadataValue() {
        if (this.tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + tag.name());
        }
        return metadataValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code GetFileMetadataIndividualResult} that has
     * its tag set to {@link Tag#ACCESS_ERROR}.
     *
     * <p> The result for this file if it was an error. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GetFileMetadataIndividualResult} with its tag
     *     set to {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static GetFileMetadataIndividualResult accessError(SharingFileAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetFileMetadataIndividualResult(Tag.ACCESS_ERROR, null, value);
    }

    /**
     * The result for this file if it was an error.
     *
     * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
     *
     * @return The {@link GetFileMetadataIndividualResult#accessError} value
     *     associated with this instance if {@link #isAccessError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharingFileAccessError getAccessErrorValue() {
        if (this.tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + tag.name());
        }
        return accessErrorValue;
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
            metadataValue,
            accessErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof GetFileMetadataIndividualResult) {
            GetFileMetadataIndividualResult other = (GetFileMetadataIndividualResult) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case METADATA:
                    return (this.metadataValue == other.metadataValue) || (this.metadataValue.equals(other.metadataValue));
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
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
    static final class Serializer extends UnionSerializer<GetFileMetadataIndividualResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetFileMetadataIndividualResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case METADATA: {
                    g.writeStartObject();
                    writeTag("metadata", g);
                    SharedFileMetadata.Serializer.INSTANCE.serialize(value.metadataValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharingFileAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GetFileMetadataIndividualResult deserialize(JsonParser p) throws IOException, JsonParseException {
            GetFileMetadataIndividualResult value;
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
            else if ("metadata".equals(tag)) {
                SharedFileMetadata fieldValue = null;
                fieldValue = SharedFileMetadata.Serializer.INSTANCE.deserialize(p, true);
                value = GetFileMetadataIndividualResult.metadata(fieldValue);
            }
            else if ("access_error".equals(tag)) {
                SharingFileAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharingFileAccessError.Serializer.INSTANCE.deserialize(p);
                value = GetFileMetadataIndividualResult.accessError(fieldValue);
            }
            else {
                value = GetFileMetadataIndividualResult.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
