/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

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
 * The value for {@link Feature#UPLOAD_API_RATE_LIMIT}.
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
public final class UploadApiRateLimitValue {
    // union team.UploadApiRateLimitValue (team.stone)

    /**
     * Discriminating tag type for {@link UploadApiRateLimitValue}.
     */
    public enum Tag {
        /**
         * This team has unlimited upload API quota. So far both server version
         * account and legacy  account type have unlimited monthly upload api
         * quota.
         */
        UNLIMITED,
        /**
         * The number of upload API calls allowed per month.
         */
        LIMIT, // long
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
     * This team has unlimited upload API quota. So far both server version
     * account and legacy  account type have unlimited monthly upload api quota.
     */
    public static final UploadApiRateLimitValue UNLIMITED = new UploadApiRateLimitValue().withTag(Tag.UNLIMITED);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UploadApiRateLimitValue OTHER = new UploadApiRateLimitValue().withTag(Tag.OTHER);

    private Tag _tag;
    private Long limitValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UploadApiRateLimitValue() {
    }


    /**
     * The value for {@link Feature#UPLOAD_API_RATE_LIMIT}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UploadApiRateLimitValue withTag(Tag _tag) {
        UploadApiRateLimitValue result = new UploadApiRateLimitValue();
        result._tag = _tag;
        return result;
    }

    /**
     * The value for {@link Feature#UPLOAD_API_RATE_LIMIT}.
     *
     * @param limitValue  The number of upload API calls allowed per month.
     * @param _tag  Discriminating tag for this instance.
     */
    private UploadApiRateLimitValue withTagAndLimit(Tag _tag, Long limitValue) {
        UploadApiRateLimitValue result = new UploadApiRateLimitValue();
        result._tag = _tag;
        result.limitValue = limitValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UploadApiRateLimitValue}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#UNLIMITED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#UNLIMITED},
     *     {@code false} otherwise.
     */
    public boolean isUnlimited() {
        return this._tag == Tag.UNLIMITED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#LIMIT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#LIMIT},
     *     {@code false} otherwise.
     */
    public boolean isLimit() {
        return this._tag == Tag.LIMIT;
    }

    /**
     * Returns an instance of {@code UploadApiRateLimitValue} that has its tag
     * set to {@link Tag#LIMIT}.
     *
     * <p> The number of upload API calls allowed per month. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadApiRateLimitValue} with its tag set to
     *     {@link Tag#LIMIT}.
     */
    public static UploadApiRateLimitValue limit(long value) {
        return new UploadApiRateLimitValue().withTagAndLimit(Tag.LIMIT, value);
    }

    /**
     * The number of upload API calls allowed per month.
     *
     * <p> This instance must be tagged as {@link Tag#LIMIT}. </p>
     *
     * @return The {@link long} value associated with this instance if {@link
     *     #isLimit} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isLimit} is {@code false}.
     */
    public long getLimitValue() {
        if (this._tag != Tag.LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.LIMIT, but was Tag." + this._tag.name());
        }
        return limitValue;
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
            this.limitValue
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
        else if (obj instanceof UploadApiRateLimitValue) {
            UploadApiRateLimitValue other = (UploadApiRateLimitValue) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case UNLIMITED:
                    return true;
                case LIMIT:
                    return this.limitValue == other.limitValue;
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
    static class Serializer extends UnionSerializer<UploadApiRateLimitValue> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadApiRateLimitValue value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case UNLIMITED: {
                    g.writeString("unlimited");
                    break;
                }
                case LIMIT: {
                    g.writeStartObject();
                    writeTag("limit", g);
                    g.writeFieldName("limit");
                    StoneSerializers.uInt32().serialize(value.limitValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UploadApiRateLimitValue deserialize(JsonParser p) throws IOException, JsonParseException {
            UploadApiRateLimitValue value;
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
            else if ("unlimited".equals(tag)) {
                value = UploadApiRateLimitValue.UNLIMITED;
            }
            else if ("limit".equals(tag)) {
                Long fieldValue = null;
                expectField("limit", p);
                fieldValue = StoneSerializers.uInt32().deserialize(p);
                value = UploadApiRateLimitValue.limit(fieldValue);
            }
            else {
                value = UploadApiRateLimitValue.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
