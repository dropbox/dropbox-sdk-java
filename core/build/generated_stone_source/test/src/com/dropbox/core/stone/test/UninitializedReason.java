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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class UninitializedReason {
    // union test.UninitializedReason (test.stone)

    /**
     * Discriminating tag type for {@link UninitializedReason}.
     */
    public enum Tag {
        BAD_REQUEST,
        BAD_HEADER, // String
        BAD_FEELS; // BadFeel
    }

    public static final UninitializedReason BAD_REQUEST = new UninitializedReason().withTag(Tag.BAD_REQUEST);

    private Tag _tag;
    private String badHeaderValue;
    private BadFeel badFeelsValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UninitializedReason() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UninitializedReason withTag(Tag _tag) {
        UninitializedReason result = new UninitializedReason();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param badHeaderValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UninitializedReason withTagAndBadHeader(Tag _tag, String badHeaderValue) {
        UninitializedReason result = new UninitializedReason();
        result._tag = _tag;
        result.badHeaderValue = badHeaderValue;
        return result;
    }

    /**
     *
     * @param badFeelsValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UninitializedReason withTagAndBadFeels(Tag _tag, BadFeel badFeelsValue) {
        UninitializedReason result = new UninitializedReason();
        result._tag = _tag;
        result.badFeelsValue = badFeelsValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UninitializedReason}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#BAD_REQUEST}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#BAD_REQUEST}, {@code false} otherwise.
     */
    public boolean isBadRequest() {
        return this._tag == Tag.BAD_REQUEST;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_HEADER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#BAD_HEADER}, {@code false} otherwise.
     */
    public boolean isBadHeader() {
        return this._tag == Tag.BAD_HEADER;
    }

    /**
     * Returns an instance of {@code UninitializedReason} that has its tag set
     * to {@link Tag#BAD_HEADER}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UninitializedReason} with its tag set to
     *     {@link Tag#BAD_HEADER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UninitializedReason badHeader(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UninitializedReason().withTagAndBadHeader(Tag.BAD_HEADER, value);
    }

    /**
     * This instance must be tagged as {@link Tag#BAD_HEADER}.
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isBadHeader} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isBadHeader} is {@code false}.
     */
    public String getBadHeaderValue() {
        if (this._tag != Tag.BAD_HEADER) {
            throw new IllegalStateException("Invalid tag: required Tag.BAD_HEADER, but was Tag." + this._tag.name());
        }
        return badHeaderValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_FEELS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#BAD_FEELS},
     *     {@code false} otherwise.
     */
    public boolean isBadFeels() {
        return this._tag == Tag.BAD_FEELS;
    }

    /**
     * Returns an instance of {@code UninitializedReason} that has its tag set
     * to {@link Tag#BAD_FEELS}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UninitializedReason} with its tag set to
     *     {@link Tag#BAD_FEELS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UninitializedReason badFeels(BadFeel value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UninitializedReason().withTagAndBadFeels(Tag.BAD_FEELS, value);
    }

    /**
     * This instance must be tagged as {@link Tag#BAD_FEELS}.
     *
     * @return The {@link BadFeel} value associated with this instance if {@link
     *     #isBadFeels} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isBadFeels} is {@code false}.
     */
    public BadFeel getBadFeelsValue() {
        if (this._tag != Tag.BAD_FEELS) {
            throw new IllegalStateException("Invalid tag: required Tag.BAD_FEELS, but was Tag." + this._tag.name());
        }
        return badFeelsValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.badHeaderValue,
            this.badFeelsValue
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
        else if (obj instanceof UninitializedReason) {
            UninitializedReason other = (UninitializedReason) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case BAD_REQUEST:
                    return true;
                case BAD_HEADER:
                    return (this.badHeaderValue == other.badHeaderValue) || (this.badHeaderValue.equals(other.badHeaderValue));
                case BAD_FEELS:
                    return (this.badFeelsValue == other.badFeelsValue) || (this.badFeelsValue.equals(other.badFeelsValue));
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
    static class Serializer extends UnionSerializer<UninitializedReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UninitializedReason value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case BAD_REQUEST: {
                    g.writeString("bad_request");
                    break;
                }
                case BAD_HEADER: {
                    g.writeStartObject();
                    writeTag("bad_header", g);
                    g.writeFieldName("bad_header");
                    StoneSerializers.string().serialize(value.badHeaderValue, g);
                    g.writeEndObject();
                    break;
                }
                case BAD_FEELS: {
                    g.writeStartObject();
                    writeTag("bad_feels", g);
                    g.writeFieldName("bad_feels");
                    BadFeel.Serializer.INSTANCE.serialize(value.badFeelsValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public UninitializedReason deserialize(JsonParser p) throws IOException, JsonParseException {
            UninitializedReason value;
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
            else if ("bad_request".equals(tag)) {
                value = UninitializedReason.BAD_REQUEST;
            }
            else if ("bad_header".equals(tag)) {
                String fieldValue = null;
                expectField("bad_header", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = UninitializedReason.badHeader(fieldValue);
            }
            else if ("bad_feels".equals(tag)) {
                BadFeel fieldValue = null;
                expectField("bad_feels", p);
                fieldValue = BadFeel.Serializer.INSTANCE.deserialize(p);
                value = UninitializedReason.badFeels(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
