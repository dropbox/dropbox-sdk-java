/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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
public final class SearchError {
    // union files.SearchError (files.stone)

    /**
     * Discriminating tag type for {@link SearchError}.
     */
    public enum Tag {
        PATH, // LookupError
        INVALID_ARGUMENT, // String
        /**
         * Something went wrong, please try again.
         */
        INTERNAL_ERROR,
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
     * Something went wrong, please try again.
     */
    public static final SearchError INTERNAL_ERROR = new SearchError().withTag(Tag.INTERNAL_ERROR);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SearchError OTHER = new SearchError().withTag(Tag.OTHER);

    private Tag _tag;
    private LookupError pathValue;
    private String invalidArgumentValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private SearchError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private SearchError withTag(Tag _tag) {
        SearchError result = new SearchError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private SearchError withTagAndPath(Tag _tag, LookupError pathValue) {
        SearchError result = new SearchError();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
    }

    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private SearchError withTagAndInvalidArgument(Tag _tag, String invalidArgumentValue) {
        SearchError result = new SearchError();
        result._tag = _tag;
        result.invalidArgumentValue = invalidArgumentValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code SearchError}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code SearchError} that has its tag set to {@link
     * Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SearchError} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SearchError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SearchError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link LookupError} value associated with this instance if
     *     {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_ARGUMENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_ARGUMENT}, {@code false} otherwise.
     */
    public boolean isInvalidArgument() {
        return this._tag == Tag.INVALID_ARGUMENT;
    }

    /**
     * Returns an instance of {@code SearchError} that has its tag set to {@link
     * Tag#INVALID_ARGUMENT}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SearchError} with its tag set to {@link
     *     Tag#INVALID_ARGUMENT}.
     */
    public static SearchError invalidArgument(String value) {
        return new SearchError().withTagAndInvalidArgument(Tag.INVALID_ARGUMENT, value);
    }

    /**
     * Returns an instance of {@code SearchError} that has its tag set to {@link
     * Tag#INVALID_ARGUMENT}.
     *
     * <p> None </p>
     *
     * @return Instance of {@code SearchError} with its tag set to {@link
     *     Tag#INVALID_ARGUMENT}.
     */
    public static SearchError invalidArgument() {
        return invalidArgument(null);
    }

    /**
     * This instance must be tagged as {@link Tag#INVALID_ARGUMENT}.
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isInvalidArgument} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInvalidArgument} is {@code
     *     false}.
     */
    public String getInvalidArgumentValue() {
        if (this._tag != Tag.INVALID_ARGUMENT) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_ARGUMENT, but was Tag." + this._tag.name());
        }
        return invalidArgumentValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INTERNAL_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INTERNAL_ERROR}, {@code false} otherwise.
     */
    public boolean isInternalError() {
        return this._tag == Tag.INTERNAL_ERROR;
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
            this.pathValue,
            this.invalidArgumentValue
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
        else if (obj instanceof SearchError) {
            SearchError other = (SearchError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case INVALID_ARGUMENT:
                    return (this.invalidArgumentValue == other.invalidArgumentValue) || (this.invalidArgumentValue != null && this.invalidArgumentValue.equals(other.invalidArgumentValue));
                case INTERNAL_ERROR:
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
    static class Serializer extends UnionSerializer<SearchError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case INVALID_ARGUMENT: {
                    g.writeStartObject();
                    writeTag("invalid_argument", g);
                    g.writeFieldName("invalid_argument");
                    StoneSerializers.nullable(StoneSerializers.string()).serialize(value.invalidArgumentValue, g);
                    g.writeEndObject();
                    break;
                }
                case INTERNAL_ERROR: {
                    g.writeString("internal_error");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SearchError deserialize(JsonParser p) throws IOException, JsonParseException {
            SearchError value;
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
                LookupError fieldValue = null;
                expectField("path", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = SearchError.path(fieldValue);
            }
            else if ("invalid_argument".equals(tag)) {
                String fieldValue = null;
                if (p.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("invalid_argument", p);
                    fieldValue = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                }
                if (fieldValue == null) {
                    value = SearchError.invalidArgument();
                }
                else {
                    value = SearchError.invalidArgument(fieldValue);
                }
            }
            else if ("internal_error".equals(tag)) {
                value = SearchError.INTERNAL_ERROR;
            }
            else {
                value = SearchError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
