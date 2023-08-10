/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

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
public final class PropertiesSearchMode {
    // union file_properties.PropertiesSearchMode (file_properties.stone)

    /**
     * Discriminating tag type for {@link PropertiesSearchMode}.
     */
    public enum Tag {
        /**
         * Search for a value associated with this field name.
         */
        FIELD_NAME, // String
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
    public static final PropertiesSearchMode OTHER = new PropertiesSearchMode().withTag(Tag.OTHER);

    private Tag _tag;
    private String fieldNameValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PropertiesSearchMode() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PropertiesSearchMode withTag(Tag _tag) {
        PropertiesSearchMode result = new PropertiesSearchMode();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param fieldNameValue  Search for a value associated with this field
     *     name. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PropertiesSearchMode withTagAndFieldName(Tag _tag, String fieldNameValue) {
        PropertiesSearchMode result = new PropertiesSearchMode();
        result._tag = _tag;
        result.fieldNameValue = fieldNameValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PropertiesSearchMode}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#FIELD_NAME},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FIELD_NAME}, {@code false} otherwise.
     */
    public boolean isFieldName() {
        return this._tag == Tag.FIELD_NAME;
    }

    /**
     * Returns an instance of {@code PropertiesSearchMode} that has its tag set
     * to {@link Tag#FIELD_NAME}.
     *
     * <p> Search for a value associated with this field name. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PropertiesSearchMode} with its tag set to
     *     {@link Tag#FIELD_NAME}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PropertiesSearchMode fieldName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PropertiesSearchMode().withTagAndFieldName(Tag.FIELD_NAME, value);
    }

    /**
     * Search for a value associated with this field name.
     *
     * <p> This instance must be tagged as {@link Tag#FIELD_NAME}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isFieldName} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFieldName} is {@code false}.
     */
    public String getFieldNameValue() {
        if (this._tag != Tag.FIELD_NAME) {
            throw new IllegalStateException("Invalid tag: required Tag.FIELD_NAME, but was Tag." + this._tag.name());
        }
        return fieldNameValue;
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
            fieldNameValue
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
        else if (obj instanceof PropertiesSearchMode) {
            PropertiesSearchMode other = (PropertiesSearchMode) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case FIELD_NAME:
                    return (this.fieldNameValue == other.fieldNameValue) || (this.fieldNameValue.equals(other.fieldNameValue));
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
    static class Serializer extends UnionSerializer<PropertiesSearchMode> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertiesSearchMode value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case FIELD_NAME: {
                    g.writeStartObject();
                    writeTag("field_name", g);
                    g.writeFieldName("field_name");
                    StoneSerializers.string().serialize(value.fieldNameValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PropertiesSearchMode deserialize(JsonParser p) throws IOException, JsonParseException {
            PropertiesSearchMode value;
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
            else if ("field_name".equals(tag)) {
                String fieldValue = null;
                expectField("field_name", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = PropertiesSearchMode.fieldName(fieldValue);
            }
            else {
                value = PropertiesSearchMode.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
