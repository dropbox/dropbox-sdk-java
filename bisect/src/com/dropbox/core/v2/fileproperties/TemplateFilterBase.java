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
import java.util.List;

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
public final class TemplateFilterBase {
    // union file_properties.TemplateFilterBase (file_properties.stone)

    /**
     * Discriminating tag type for {@link TemplateFilterBase}.
     */
    public enum Tag {
        /**
         * Only templates with an ID in the supplied list will be returned (a
         * subset of templates will be returned).
         */
        FILTER_SOME, // List<String>
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
    public static final TemplateFilterBase OTHER = new TemplateFilterBase().withTag(Tag.OTHER);

    private Tag _tag;
    private List<String> filterSomeValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private TemplateFilterBase() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private TemplateFilterBase withTag(Tag _tag) {
        TemplateFilterBase result = new TemplateFilterBase();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param filterSomeValue  Only templates with an ID in the supplied list
     *     will be returned (a subset of templates will be returned). Must
     *     contain at least 1 items, not contain a {@code null} item, and not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TemplateFilterBase withTagAndFilterSome(Tag _tag, List<String> filterSomeValue) {
        TemplateFilterBase result = new TemplateFilterBase();
        result._tag = _tag;
        result.filterSomeValue = filterSomeValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TemplateFilterBase}. </p>
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
     * Tag#FILTER_SOME}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FILTER_SOME}, {@code false} otherwise.
     */
    public boolean isFilterSome() {
        return this._tag == Tag.FILTER_SOME;
    }

    /**
     * Returns an instance of {@code TemplateFilterBase} that has its tag set to
     * {@link Tag#FILTER_SOME}.
     *
     * <p> Only templates with an ID in the supplied list will be returned (a
     * subset of templates will be returned). </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TemplateFilterBase} with its tag set to {@link
     *     Tag#FILTER_SOME}.
     *
     * @throws IllegalArgumentException  if {@code value} has fewer than 1
     *     items, contains a {@code null} item, or is {@code null}.
     */
    public static TemplateFilterBase filterSome(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.size() < 1) {
            throw new IllegalArgumentException("List has fewer than 1 items");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
            if (x.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("(/|ptid:).*", x)) {
                throw new IllegalArgumentException("Stringan item in list does not match pattern");
            }
        }
        return new TemplateFilterBase().withTagAndFilterSome(Tag.FILTER_SOME, value);
    }

    /**
     * Only templates with an ID in the supplied list will be returned (a subset
     * of templates will be returned).
     *
     * <p> This instance must be tagged as {@link Tag#FILTER_SOME}. </p>
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isFilterSome} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFilterSome} is {@code false}.
     */
    public List<String> getFilterSomeValue() {
        if (this._tag != Tag.FILTER_SOME) {
            throw new IllegalStateException("Invalid tag: required Tag.FILTER_SOME, but was Tag." + this._tag.name());
        }
        return filterSomeValue;
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
            filterSomeValue
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
        else if (obj instanceof TemplateFilterBase) {
            TemplateFilterBase other = (TemplateFilterBase) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case FILTER_SOME:
                    return (this.filterSomeValue == other.filterSomeValue) || (this.filterSomeValue.equals(other.filterSomeValue));
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
    public static class Serializer extends UnionSerializer<TemplateFilterBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TemplateFilterBase value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case FILTER_SOME: {
                    g.writeStartObject();
                    writeTag("filter_some", g);
                    g.writeFieldName("filter_some");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.filterSomeValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TemplateFilterBase deserialize(JsonParser p) throws IOException, JsonParseException {
            TemplateFilterBase value;
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
            else if ("filter_some".equals(tag)) {
                List<String> fieldValue = null;
                expectField("filter_some", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = TemplateFilterBase.filterSome(fieldValue);
            }
            else {
                value = TemplateFilterBase.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
