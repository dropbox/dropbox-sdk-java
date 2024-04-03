/* DO NOT EDIT */
/* This file was generated from account.stone */

package com.dropbox.core.v2.account;

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
public final class PhotoSourceArg {
    // union account.PhotoSourceArg (account.stone)

    /**
     * Discriminating tag type for {@link PhotoSourceArg}.
     */
    public enum Tag {
        /**
         * Image data in base64-encoded bytes.
         */
        BASE64_DATA, // String
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
    public static final PhotoSourceArg OTHER = new PhotoSourceArg().withTag(Tag.OTHER);

    private Tag _tag;
    private String base64DataValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PhotoSourceArg() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PhotoSourceArg withTag(Tag _tag) {
        PhotoSourceArg result = new PhotoSourceArg();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param base64DataValue  Image data in base64-encoded bytes. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PhotoSourceArg withTagAndBase64Data(Tag _tag, String base64DataValue) {
        PhotoSourceArg result = new PhotoSourceArg();
        result._tag = _tag;
        result.base64DataValue = base64DataValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PhotoSourceArg}. </p>
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
     * Tag#BASE64_DATA}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#BASE64_DATA}, {@code false} otherwise.
     */
    public boolean isBase64Data() {
        return this._tag == Tag.BASE64_DATA;
    }

    /**
     * Returns an instance of {@code PhotoSourceArg} that has its tag set to
     * {@link Tag#BASE64_DATA}.
     *
     * <p> Image data in base64-encoded bytes. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PhotoSourceArg} with its tag set to {@link
     *     Tag#BASE64_DATA}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PhotoSourceArg base64Data(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PhotoSourceArg().withTagAndBase64Data(Tag.BASE64_DATA, value);
    }

    /**
     * Image data in base64-encoded bytes.
     *
     * <p> This instance must be tagged as {@link Tag#BASE64_DATA}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isBase64Data} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isBase64Data} is {@code false}.
     */
    public String getBase64DataValue() {
        if (this._tag != Tag.BASE64_DATA) {
            throw new IllegalStateException("Invalid tag: required Tag.BASE64_DATA, but was Tag." + this._tag.name());
        }
        return base64DataValue;
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
            this._tag,
            this.base64DataValue
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
        else if (obj instanceof PhotoSourceArg) {
            PhotoSourceArg other = (PhotoSourceArg) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case BASE64_DATA:
                    return (this.base64DataValue == other.base64DataValue) || (this.base64DataValue.equals(other.base64DataValue));
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
    public static class Serializer extends UnionSerializer<PhotoSourceArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PhotoSourceArg value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case BASE64_DATA: {
                    g.writeStartObject();
                    writeTag("base64_data", g);
                    g.writeFieldName("base64_data");
                    StoneSerializers.string().serialize(value.base64DataValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PhotoSourceArg deserialize(JsonParser p) throws IOException, JsonParseException {
            PhotoSourceArg value;
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
            else if ("base64_data".equals(tag)) {
                String fieldValue = null;
                expectField("base64_data", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = PhotoSourceArg.base64Data(fieldValue);
            }
            else {
                value = PhotoSourceArg.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
