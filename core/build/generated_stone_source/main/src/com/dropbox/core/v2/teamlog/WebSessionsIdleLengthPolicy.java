/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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
 * Web sessions idle length policy.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class WebSessionsIdleLengthPolicy {
    // union team_log.WebSessionsIdleLengthPolicy (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link WebSessionsIdleLengthPolicy}.
     */
    public enum Tag {
        /**
         * Defined idle session length.
         */
        DEFINED, // DurationLogInfo
        /**
         * Undefined idle session length.
         */
        UNDEFINED,
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
     * Undefined idle session length.
     */
    public static final WebSessionsIdleLengthPolicy UNDEFINED = new WebSessionsIdleLengthPolicy().withTag(Tag.UNDEFINED);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final WebSessionsIdleLengthPolicy OTHER = new WebSessionsIdleLengthPolicy().withTag(Tag.OTHER);

    private Tag _tag;
    private DurationLogInfo definedValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private WebSessionsIdleLengthPolicy() {
    }


    /**
     * Web sessions idle length policy.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private WebSessionsIdleLengthPolicy withTag(Tag _tag) {
        WebSessionsIdleLengthPolicy result = new WebSessionsIdleLengthPolicy();
        result._tag = _tag;
        return result;
    }

    /**
     * Web sessions idle length policy.
     *
     * @param definedValue  Defined idle session length. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private WebSessionsIdleLengthPolicy withTagAndDefined(Tag _tag, DurationLogInfo definedValue) {
        WebSessionsIdleLengthPolicy result = new WebSessionsIdleLengthPolicy();
        result._tag = _tag;
        result.definedValue = definedValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code WebSessionsIdleLengthPolicy}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#DEFINED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#DEFINED},
     *     {@code false} otherwise.
     */
    public boolean isDefined() {
        return this._tag == Tag.DEFINED;
    }

    /**
     * Returns an instance of {@code WebSessionsIdleLengthPolicy} that has its
     * tag set to {@link Tag#DEFINED}.
     *
     * <p> Defined idle session length. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code WebSessionsIdleLengthPolicy} with its tag set
     *     to {@link Tag#DEFINED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static WebSessionsIdleLengthPolicy defined(DurationLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new WebSessionsIdleLengthPolicy().withTagAndDefined(Tag.DEFINED, value);
    }

    /**
     * Defined idle session length.
     *
     * <p> This instance must be tagged as {@link Tag#DEFINED}. </p>
     *
     * @return The {@link DurationLogInfo} value associated with this instance
     *     if {@link #isDefined} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isDefined} is {@code false}.
     */
    public DurationLogInfo getDefinedValue() {
        if (this._tag != Tag.DEFINED) {
            throw new IllegalStateException("Invalid tag: required Tag.DEFINED, but was Tag." + this._tag.name());
        }
        return definedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#UNDEFINED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#UNDEFINED},
     *     {@code false} otherwise.
     */
    public boolean isUndefined() {
        return this._tag == Tag.UNDEFINED;
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
            this.definedValue
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
        else if (obj instanceof WebSessionsIdleLengthPolicy) {
            WebSessionsIdleLengthPolicy other = (WebSessionsIdleLengthPolicy) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case DEFINED:
                    return (this.definedValue == other.definedValue) || (this.definedValue.equals(other.definedValue));
                case UNDEFINED:
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
    static class Serializer extends UnionSerializer<WebSessionsIdleLengthPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(WebSessionsIdleLengthPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case DEFINED: {
                    g.writeStartObject();
                    writeTag("defined", g);
                    DurationLogInfo.Serializer.INSTANCE.serialize(value.definedValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case UNDEFINED: {
                    g.writeString("undefined");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public WebSessionsIdleLengthPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            WebSessionsIdleLengthPolicy value;
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
            else if ("defined".equals(tag)) {
                DurationLogInfo fieldValue = null;
                fieldValue = DurationLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = WebSessionsIdleLengthPolicy.defined(fieldValue);
            }
            else if ("undefined".equals(tag)) {
                value = WebSessionsIdleLengthPolicy.UNDEFINED;
            }
            else {
                value = WebSessionsIdleLengthPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
