/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

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
public final class NestingUnion {
    // union test.NestingUnion (test.stone)

    /**
     * Discriminating tag type for {@link NestingUnion}.
     */
    public enum Tag {
        SIMPLE, // ChildUnion
        VALUE, // ValueUnion
        CATCH_ALL, // CatchAllUnion
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
    public static final NestingUnion OTHER = new NestingUnion().withTag(Tag.OTHER);

    private Tag _tag;
    private ChildUnion simpleValue;
    private ValueUnion valueValue;
    private CatchAllUnion catchAllValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private NestingUnion() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private NestingUnion withTag(Tag _tag) {
        NestingUnion result = new NestingUnion();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param simpleValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private NestingUnion withTagAndSimple(Tag _tag, ChildUnion simpleValue) {
        NestingUnion result = new NestingUnion();
        result._tag = _tag;
        result.simpleValue = simpleValue;
        return result;
    }

    /**
     *
     * @param valueValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private NestingUnion withTagAndValue(Tag _tag, ValueUnion valueValue) {
        NestingUnion result = new NestingUnion();
        result._tag = _tag;
        result.valueValue = valueValue;
        return result;
    }

    /**
     *
     * @param catchAllValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private NestingUnion withTagAndCatchAll(Tag _tag, CatchAllUnion catchAllValue) {
        NestingUnion result = new NestingUnion();
        result._tag = _tag;
        result.catchAllValue = catchAllValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code NestingUnion}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#SIMPLE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#SIMPLE},
     *     {@code false} otherwise.
     */
    public boolean isSimple() {
        return this._tag == Tag.SIMPLE;
    }

    /**
     * Returns an instance of {@code NestingUnion} that has its tag set to
     * {@link Tag#SIMPLE}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code NestingUnion} with its tag set to {@link
     *     Tag#SIMPLE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static NestingUnion simple(ChildUnion value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new NestingUnion().withTagAndSimple(Tag.SIMPLE, value);
    }

    /**
     * This instance must be tagged as {@link Tag#SIMPLE}.
     *
     * @return The {@link ChildUnion} value associated with this instance if
     *     {@link #isSimple} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSimple} is {@code false}.
     */
    public ChildUnion getSimpleValue() {
        if (this._tag != Tag.SIMPLE) {
            throw new IllegalStateException("Invalid tag: required Tag.SIMPLE, but was Tag." + this._tag.name());
        }
        return simpleValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#VALUE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#VALUE},
     *     {@code false} otherwise.
     */
    public boolean isValue() {
        return this._tag == Tag.VALUE;
    }

    /**
     * Returns an instance of {@code NestingUnion} that has its tag set to
     * {@link Tag#VALUE}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code NestingUnion} with its tag set to {@link
     *     Tag#VALUE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static NestingUnion value(ValueUnion value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new NestingUnion().withTagAndValue(Tag.VALUE, value);
    }

    /**
     * This instance must be tagged as {@link Tag#VALUE}.
     *
     * @return The {@link ValueUnion} value associated with this instance if
     *     {@link #isValue} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isValue} is {@code false}.
     */
    public ValueUnion getValueValue() {
        if (this._tag != Tag.VALUE) {
            throw new IllegalStateException("Invalid tag: required Tag.VALUE, but was Tag." + this._tag.name());
        }
        return valueValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#CATCH_ALL},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#CATCH_ALL},
     *     {@code false} otherwise.
     */
    public boolean isCatchAll() {
        return this._tag == Tag.CATCH_ALL;
    }

    /**
     * Returns an instance of {@code NestingUnion} that has its tag set to
     * {@link Tag#CATCH_ALL}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code NestingUnion} with its tag set to {@link
     *     Tag#CATCH_ALL}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static NestingUnion catchAll(CatchAllUnion value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new NestingUnion().withTagAndCatchAll(Tag.CATCH_ALL, value);
    }

    /**
     * This instance must be tagged as {@link Tag#CATCH_ALL}.
     *
     * @return The {@link CatchAllUnion} value associated with this instance if
     *     {@link #isCatchAll} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isCatchAll} is {@code false}.
     */
    public CatchAllUnion getCatchAllValue() {
        if (this._tag != Tag.CATCH_ALL) {
            throw new IllegalStateException("Invalid tag: required Tag.CATCH_ALL, but was Tag." + this._tag.name());
        }
        return catchAllValue;
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
            simpleValue,
            valueValue,
            catchAllValue
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
        else if (obj instanceof NestingUnion) {
            NestingUnion other = (NestingUnion) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case SIMPLE:
                    return (this.simpleValue == other.simpleValue) || (this.simpleValue.equals(other.simpleValue));
                case VALUE:
                    return (this.valueValue == other.valueValue) || (this.valueValue.equals(other.valueValue));
                case CATCH_ALL:
                    return (this.catchAllValue == other.catchAllValue) || (this.catchAllValue.equals(other.catchAllValue));
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
    public static class Serializer extends UnionSerializer<NestingUnion> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(NestingUnion value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case SIMPLE: {
                    g.writeStartObject();
                    writeTag("simple", g);
                    g.writeFieldName("simple");
                    ChildUnion.Serializer.INSTANCE.serialize(value.simpleValue, g);
                    g.writeEndObject();
                    break;
                }
                case VALUE: {
                    g.writeStartObject();
                    writeTag("value", g);
                    g.writeFieldName("value");
                    ValueUnion.Serializer.INSTANCE.serialize(value.valueValue, g);
                    g.writeEndObject();
                    break;
                }
                case CATCH_ALL: {
                    g.writeStartObject();
                    writeTag("catch_all", g);
                    g.writeFieldName("catch_all");
                    CatchAllUnion.Serializer.INSTANCE.serialize(value.catchAllValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public NestingUnion deserialize(JsonParser p) throws IOException, JsonParseException {
            NestingUnion value;
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
            else if ("simple".equals(tag)) {
                ChildUnion fieldValue = null;
                expectField("simple", p);
                fieldValue = ChildUnion.Serializer.INSTANCE.deserialize(p);
                value = NestingUnion.simple(fieldValue);
            }
            else if ("value".equals(tag)) {
                ValueUnion fieldValue = null;
                expectField("value", p);
                fieldValue = ValueUnion.Serializer.INSTANCE.deserialize(p);
                value = NestingUnion.value(fieldValue);
            }
            else if ("catch_all".equals(tag)) {
                CatchAllUnion fieldValue = null;
                expectField("catch_all", p);
                fieldValue = CatchAllUnion.Serializer.INSTANCE.deserialize(p);
                value = NestingUnion.catchAll(fieldValue);
            }
            else {
                value = NestingUnion.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
