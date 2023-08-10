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
public final class PropertiesSearchError {
    // union file_properties.PropertiesSearchError (file_properties.stone)

    /**
     * Discriminating tag type for {@link PropertiesSearchError}.
     */
    public enum Tag {
        PROPERTY_GROUP_LOOKUP, // LookUpPropertiesError
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
    public static final PropertiesSearchError OTHER = new PropertiesSearchError().withTag(Tag.OTHER);

    private Tag _tag;
    private LookUpPropertiesError propertyGroupLookupValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PropertiesSearchError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PropertiesSearchError withTag(Tag _tag) {
        PropertiesSearchError result = new PropertiesSearchError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param propertyGroupLookupValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PropertiesSearchError withTagAndPropertyGroupLookup(Tag _tag, LookUpPropertiesError propertyGroupLookupValue) {
        PropertiesSearchError result = new PropertiesSearchError();
        result._tag = _tag;
        result.propertyGroupLookupValue = propertyGroupLookupValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PropertiesSearchError}. </p>
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
     * Tag#PROPERTY_GROUP_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PROPERTY_GROUP_LOOKUP}, {@code false} otherwise.
     */
    public boolean isPropertyGroupLookup() {
        return this._tag == Tag.PROPERTY_GROUP_LOOKUP;
    }

    /**
     * Returns an instance of {@code PropertiesSearchError} that has its tag set
     * to {@link Tag#PROPERTY_GROUP_LOOKUP}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PropertiesSearchError} with its tag set to
     *     {@link Tag#PROPERTY_GROUP_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PropertiesSearchError propertyGroupLookup(LookUpPropertiesError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PropertiesSearchError().withTagAndPropertyGroupLookup(Tag.PROPERTY_GROUP_LOOKUP, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PROPERTY_GROUP_LOOKUP}.
     *
     * @return The {@link LookUpPropertiesError} value associated with this
     *     instance if {@link #isPropertyGroupLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPropertyGroupLookup} is
     *     {@code false}.
     */
    public LookUpPropertiesError getPropertyGroupLookupValue() {
        if (this._tag != Tag.PROPERTY_GROUP_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTY_GROUP_LOOKUP, but was Tag." + this._tag.name());
        }
        return propertyGroupLookupValue;
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
            propertyGroupLookupValue
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
        else if (obj instanceof PropertiesSearchError) {
            PropertiesSearchError other = (PropertiesSearchError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PROPERTY_GROUP_LOOKUP:
                    return (this.propertyGroupLookupValue == other.propertyGroupLookupValue) || (this.propertyGroupLookupValue.equals(other.propertyGroupLookupValue));
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
    static class Serializer extends UnionSerializer<PropertiesSearchError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertiesSearchError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PROPERTY_GROUP_LOOKUP: {
                    g.writeStartObject();
                    writeTag("property_group_lookup", g);
                    g.writeFieldName("property_group_lookup");
                    LookUpPropertiesError.Serializer.INSTANCE.serialize(value.propertyGroupLookupValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PropertiesSearchError deserialize(JsonParser p) throws IOException, JsonParseException {
            PropertiesSearchError value;
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
            else if ("property_group_lookup".equals(tag)) {
                LookUpPropertiesError fieldValue = null;
                expectField("property_group_lookup", p);
                fieldValue = LookUpPropertiesError.Serializer.INSTANCE.deserialize(p);
                value = PropertiesSearchError.propertyGroupLookup(fieldValue);
            }
            else {
                value = PropertiesSearchError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
