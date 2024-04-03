/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

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
public final class GetSharedLinksError {
    // union sharing.GetSharedLinksError (shared_links.stone)

    /**
     * Discriminating tag type for {@link GetSharedLinksError}.
     */
    public enum Tag {
        PATH, // String
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
    public static final GetSharedLinksError OTHER = new GetSharedLinksError().withTag(Tag.OTHER);

    private Tag _tag;
    private String pathValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private GetSharedLinksError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private GetSharedLinksError withTag(Tag _tag) {
        GetSharedLinksError result = new GetSharedLinksError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private GetSharedLinksError withTagAndPath(Tag _tag, String pathValue) {
        GetSharedLinksError result = new GetSharedLinksError();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GetSharedLinksError}. </p>
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
     * Returns an instance of {@code GetSharedLinksError} that has its tag set
     * to {@link Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GetSharedLinksError} with its tag set to
     *     {@link Tag#PATH}.
     */
    public static GetSharedLinksError path(String value) {
        return new GetSharedLinksError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * Returns an instance of {@code GetSharedLinksError} that has its tag set
     * to {@link Tag#PATH}.
     *
     * <p> None </p>
     *
     * @return Instance of {@code GetSharedLinksError} with its tag set to
     *     {@link Tag#PATH}.
     */
    public static GetSharedLinksError path() {
        return path(null);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public String getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return pathValue;
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
            this.pathValue
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
        else if (obj instanceof GetSharedLinksError) {
            GetSharedLinksError other = (GetSharedLinksError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue != null && this.pathValue.equals(other.pathValue));
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
    static class Serializer extends UnionSerializer<GetSharedLinksError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetSharedLinksError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GetSharedLinksError deserialize(JsonParser p) throws IOException, JsonParseException {
            GetSharedLinksError value;
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
                String fieldValue = null;
                if (p.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("path", p);
                    fieldValue = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                }
                if (fieldValue == null) {
                    value = GetSharedLinksError.path();
                }
                else {
                    value = GetSharedLinksError.path(fieldValue);
                }
            }
            else {
                value = GetSharedLinksError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
