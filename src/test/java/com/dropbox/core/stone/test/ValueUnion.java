/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

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
public final class ValueUnion {
    // union ValueUnion

    /**
     * Discriminating tag type for {@link ValueUnion}.
     */
    public enum Tag {
        ALPHA,
        BETA,
        TOO_MUCH, // Integer
        TOO_LITTLE, // Integer
        JUST_RIGHT;
    }

    public static final ValueUnion ALPHA = new ValueUnion(Tag.ALPHA, null, null);
    public static final ValueUnion BETA = new ValueUnion(Tag.BETA, null, null);
    public static final ValueUnion JUST_RIGHT = new ValueUnion(Tag.JUST_RIGHT, null, null);

    private final Tag tag;
    private final Integer tooMuchValue;
    private final Integer tooLittleValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ValueUnion(Tag tag, Integer tooMuchValue, Integer tooLittleValue) {
        this.tag = tag;
        this.tooMuchValue = tooMuchValue;
        this.tooLittleValue = tooLittleValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ValueUnion}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#ALPHA},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ALPHA},
     *     {@code false} otherwise.
     */
    public boolean isAlpha() {
        return this.tag == Tag.ALPHA;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BETA},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#BETA},
     *     {@code false} otherwise.
     */
    public boolean isBeta() {
        return this.tag == Tag.BETA;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#TOO_MUCH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#TOO_MUCH},
     *     {@code false} otherwise.
     */
    public boolean isTooMuch() {
        return this.tag == Tag.TOO_MUCH;
    }

    /**
     * Returns an instance of {@code ValueUnion} that has its tag set to {@link
     * Tag#TOO_MUCH}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ValueUnion} with its tag set to {@link
     *     Tag#TOO_MUCH}.
     */
    public static ValueUnion tooMuch(int value) {
        return new ValueUnion(Tag.TOO_MUCH, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#TOO_MUCH}.
     *
     * @return The {@link ValueUnion#tooMuch} value associated with this
     *     instance if {@link #isTooMuch} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTooMuch} is {@code false}.
     */
    public int getTooMuchValue() {
        if (this.tag != Tag.TOO_MUCH) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MUCH, but was Tag." + tag.name());
        }
        return tooMuchValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#TOO_LITTLE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_LITTLE}, {@code false} otherwise.
     */
    public boolean isTooLittle() {
        return this.tag == Tag.TOO_LITTLE;
    }

    /**
     * Returns an instance of {@code ValueUnion} that has its tag set to {@link
     * Tag#TOO_LITTLE}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ValueUnion} with its tag set to {@link
     *     Tag#TOO_LITTLE}.
     */
    public static ValueUnion tooLittle(int value) {
        return new ValueUnion(Tag.TOO_LITTLE, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#TOO_LITTLE}.
     *
     * @return The {@link ValueUnion#tooLittle} value associated with this
     *     instance if {@link #isTooLittle} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTooLittle} is {@code false}.
     */
    public int getTooLittleValue() {
        if (this.tag != Tag.TOO_LITTLE) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_LITTLE, but was Tag." + tag.name());
        }
        return tooLittleValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#JUST_RIGHT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#JUST_RIGHT}, {@code false} otherwise.
     */
    public boolean isJustRight() {
        return this.tag == Tag.JUST_RIGHT;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            tooMuchValue,
            tooLittleValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ValueUnion) {
            ValueUnion other = (ValueUnion) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ALPHA:
                    return true;
                case BETA:
                    return true;
                case TOO_MUCH:
                    return this.tooMuchValue == other.tooMuchValue;
                case TOO_LITTLE:
                    return this.tooLittleValue == other.tooLittleValue;
                case JUST_RIGHT:
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
    static final class Serializer extends UnionSerializer<ValueUnion> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ValueUnion value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ALPHA: {
                    g.writeString("alpha");
                    break;
                }
                case BETA: {
                    g.writeString("beta");
                    break;
                }
                case TOO_MUCH: {
                    g.writeStartObject();
                    writeTag("too_much", g);
                    g.writeFieldName("too_much");
                    StoneSerializers.int32().serialize(value.tooMuchValue, g);
                    g.writeEndObject();
                    break;
                }
                case TOO_LITTLE: {
                    g.writeStartObject();
                    writeTag("too_little", g);
                    g.writeFieldName("too_little");
                    StoneSerializers.int32().serialize(value.tooLittleValue, g);
                    g.writeEndObject();
                    break;
                }
                case JUST_RIGHT: {
                    g.writeString("just_right");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public ValueUnion deserialize(JsonParser p) throws IOException, JsonParseException {
            ValueUnion value;
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
            else if ("alpha".equals(tag)) {
                value = ValueUnion.ALPHA;
            }
            else if ("beta".equals(tag)) {
                value = ValueUnion.BETA;
            }
            else if ("too_much".equals(tag)) {
                Integer fieldValue = null;
                expectField("too_much", p);
                fieldValue = StoneSerializers.int32().deserialize(p);
                value = ValueUnion.tooMuch(fieldValue);
            }
            else if ("too_little".equals(tag)) {
                Integer fieldValue = null;
                expectField("too_little", p);
                fieldValue = StoneSerializers.int32().deserialize(p);
                value = ValueUnion.tooLittle(fieldValue);
            }
            else if ("just_right".equals(tag)) {
                value = ValueUnion.JUST_RIGHT;
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
