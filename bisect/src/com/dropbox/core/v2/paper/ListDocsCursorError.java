/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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
public final class ListDocsCursorError {
    // union paper.ListDocsCursorError (paper.stone)

    /**
     * Discriminating tag type for {@link ListDocsCursorError}.
     */
    public enum Tag {
        CURSOR_ERROR, // PaperApiCursorError
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
    public static final ListDocsCursorError OTHER = new ListDocsCursorError().withTag(Tag.OTHER);

    private Tag _tag;
    private PaperApiCursorError cursorErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ListDocsCursorError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ListDocsCursorError withTag(Tag _tag) {
        ListDocsCursorError result = new ListDocsCursorError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param cursorErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ListDocsCursorError withTagAndCursorError(Tag _tag, PaperApiCursorError cursorErrorValue) {
        ListDocsCursorError result = new ListDocsCursorError();
        result._tag = _tag;
        result.cursorErrorValue = cursorErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ListDocsCursorError}. </p>
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
     * Tag#CURSOR_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CURSOR_ERROR}, {@code false} otherwise.
     */
    public boolean isCursorError() {
        return this._tag == Tag.CURSOR_ERROR;
    }

    /**
     * Returns an instance of {@code ListDocsCursorError} that has its tag set
     * to {@link Tag#CURSOR_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ListDocsCursorError} with its tag set to
     *     {@link Tag#CURSOR_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ListDocsCursorError cursorError(PaperApiCursorError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListDocsCursorError().withTagAndCursorError(Tag.CURSOR_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#CURSOR_ERROR}.
     *
     * @return The {@link PaperApiCursorError} value associated with this
     *     instance if {@link #isCursorError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isCursorError} is {@code
     *     false}.
     */
    public PaperApiCursorError getCursorErrorValue() {
        if (this._tag != Tag.CURSOR_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.CURSOR_ERROR, but was Tag." + this._tag.name());
        }
        return cursorErrorValue;
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
            cursorErrorValue
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
        else if (obj instanceof ListDocsCursorError) {
            ListDocsCursorError other = (ListDocsCursorError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case CURSOR_ERROR:
                    return (this.cursorErrorValue == other.cursorErrorValue) || (this.cursorErrorValue.equals(other.cursorErrorValue));
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
    static class Serializer extends UnionSerializer<ListDocsCursorError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListDocsCursorError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case CURSOR_ERROR: {
                    g.writeStartObject();
                    writeTag("cursor_error", g);
                    g.writeFieldName("cursor_error");
                    PaperApiCursorError.Serializer.INSTANCE.serialize(value.cursorErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListDocsCursorError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListDocsCursorError value;
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
            else if ("cursor_error".equals(tag)) {
                PaperApiCursorError fieldValue = null;
                expectField("cursor_error", p);
                fieldValue = PaperApiCursorError.Serializer.INSTANCE.deserialize(p);
                value = ListDocsCursorError.cursorError(fieldValue);
            }
            else {
                value = ListDocsCursorError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
