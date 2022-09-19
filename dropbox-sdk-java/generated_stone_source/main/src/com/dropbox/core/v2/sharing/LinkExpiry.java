/* DO NOT EDIT */
/* This file was generated from shared_content_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

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
public final class LinkExpiry {
    // union sharing.LinkExpiry (shared_content_links.stone)

    /**
     * Discriminating tag type for {@link LinkExpiry}.
     */
    public enum Tag {
        /**
         * Remove the currently set expiry for the link.
         */
        REMOVE_EXPIRY,
        /**
         * Set a new expiry or change an existing expiry.
         */
        SET_EXPIRY, // Date
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
     * Remove the currently set expiry for the link.
     */
    public static final LinkExpiry REMOVE_EXPIRY = new LinkExpiry().withTag(Tag.REMOVE_EXPIRY);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final LinkExpiry OTHER = new LinkExpiry().withTag(Tag.OTHER);

    private Tag _tag;
    private Date setExpiryValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private LinkExpiry() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private LinkExpiry withTag(Tag _tag) {
        LinkExpiry result = new LinkExpiry();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param setExpiryValue  Set a new expiry or change an existing expiry.
     *     Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LinkExpiry withTagAndSetExpiry(Tag _tag, Date setExpiryValue) {
        LinkExpiry result = new LinkExpiry();
        result._tag = _tag;
        result.setExpiryValue = setExpiryValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code LinkExpiry}. </p>
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
     * Tag#REMOVE_EXPIRY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#REMOVE_EXPIRY}, {@code false} otherwise.
     */
    public boolean isRemoveExpiry() {
        return this._tag == Tag.REMOVE_EXPIRY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#SET_EXPIRY},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SET_EXPIRY}, {@code false} otherwise.
     */
    public boolean isSetExpiry() {
        return this._tag == Tag.SET_EXPIRY;
    }

    /**
     * Returns an instance of {@code LinkExpiry} that has its tag set to {@link
     * Tag#SET_EXPIRY}.
     *
     * <p> Set a new expiry or change an existing expiry. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LinkExpiry} with its tag set to {@link
     *     Tag#SET_EXPIRY}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LinkExpiry setExpiry(Date value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkExpiry().withTagAndSetExpiry(Tag.SET_EXPIRY, value);
    }

    /**
     * Set a new expiry or change an existing expiry.
     *
     * <p> This instance must be tagged as {@link Tag#SET_EXPIRY}. </p>
     *
     * @return The {@link Date} value associated with this instance if {@link
     *     #isSetExpiry} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSetExpiry} is {@code false}.
     */
    public Date getSetExpiryValue() {
        if (this._tag != Tag.SET_EXPIRY) {
            throw new IllegalStateException("Invalid tag: required Tag.SET_EXPIRY, but was Tag." + this._tag.name());
        }
        return setExpiryValue;
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
            setExpiryValue
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
        else if (obj instanceof LinkExpiry) {
            LinkExpiry other = (LinkExpiry) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case REMOVE_EXPIRY:
                    return true;
                case SET_EXPIRY:
                    return (this.setExpiryValue == other.setExpiryValue) || (this.setExpiryValue.equals(other.setExpiryValue));
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
    static class Serializer extends UnionSerializer<LinkExpiry> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkExpiry value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case REMOVE_EXPIRY: {
                    g.writeString("remove_expiry");
                    break;
                }
                case SET_EXPIRY: {
                    g.writeStartObject();
                    writeTag("set_expiry", g);
                    g.writeFieldName("set_expiry");
                    StoneSerializers.timestamp().serialize(value.setExpiryValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LinkExpiry deserialize(JsonParser p) throws IOException, JsonParseException {
            LinkExpiry value;
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
            else if ("remove_expiry".equals(tag)) {
                value = LinkExpiry.REMOVE_EXPIRY;
            }
            else if ("set_expiry".equals(tag)) {
                Date fieldValue = null;
                expectField("set_expiry", p);
                fieldValue = StoneSerializers.timestamp().deserialize(p);
                value = LinkExpiry.setExpiry(fieldValue);
            }
            else {
                value = LinkExpiry.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
