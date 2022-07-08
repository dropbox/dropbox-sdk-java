/* DO NOT EDIT */
/* This file was generated from shared_content_links.stone */

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
public final class LinkPassword {
    // union sharing.LinkPassword (shared_content_links.stone)

    /**
     * Discriminating tag type for {@link LinkPassword}.
     */
    public enum Tag {
        /**
         * Remove the currently set password for the link.
         */
        REMOVE_PASSWORD,
        /**
         * Set a new password or change an existing password.
         */
        SET_PASSWORD, // String
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
     * Remove the currently set password for the link.
     */
    public static final LinkPassword REMOVE_PASSWORD = new LinkPassword().withTag(Tag.REMOVE_PASSWORD);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final LinkPassword OTHER = new LinkPassword().withTag(Tag.OTHER);

    private Tag _tag;
    private String setPasswordValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private LinkPassword() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private LinkPassword withTag(Tag _tag) {
        LinkPassword result = new LinkPassword();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param setPasswordValue  Set a new password or change an existing
     *     password. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LinkPassword withTagAndSetPassword(Tag _tag, String setPasswordValue) {
        LinkPassword result = new LinkPassword();
        result._tag = _tag;
        result.setPasswordValue = setPasswordValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code LinkPassword}. </p>
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
     * Tag#REMOVE_PASSWORD}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#REMOVE_PASSWORD}, {@code false} otherwise.
     */
    public boolean isRemovePassword() {
        return this._tag == Tag.REMOVE_PASSWORD;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SET_PASSWORD}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SET_PASSWORD}, {@code false} otherwise.
     */
    public boolean isSetPassword() {
        return this._tag == Tag.SET_PASSWORD;
    }

    /**
     * Returns an instance of {@code LinkPassword} that has its tag set to
     * {@link Tag#SET_PASSWORD}.
     *
     * <p> Set a new password or change an existing password. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LinkPassword} with its tag set to {@link
     *     Tag#SET_PASSWORD}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LinkPassword setPassword(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkPassword().withTagAndSetPassword(Tag.SET_PASSWORD, value);
    }

    /**
     * Set a new password or change an existing password.
     *
     * <p> This instance must be tagged as {@link Tag#SET_PASSWORD}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isSetPassword} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSetPassword} is {@code
     *     false}.
     */
    public String getSetPasswordValue() {
        if (this._tag != Tag.SET_PASSWORD) {
            throw new IllegalStateException("Invalid tag: required Tag.SET_PASSWORD, but was Tag." + this._tag.name());
        }
        return setPasswordValue;
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
            setPasswordValue
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
        else if (obj instanceof LinkPassword) {
            LinkPassword other = (LinkPassword) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case REMOVE_PASSWORD:
                    return true;
                case SET_PASSWORD:
                    return (this.setPasswordValue == other.setPasswordValue) || (this.setPasswordValue.equals(other.setPasswordValue));
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
    static class Serializer extends UnionSerializer<LinkPassword> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkPassword value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case REMOVE_PASSWORD: {
                    g.writeString("remove_password");
                    break;
                }
                case SET_PASSWORD: {
                    g.writeStartObject();
                    writeTag("set_password", g);
                    g.writeFieldName("set_password");
                    StoneSerializers.string().serialize(value.setPasswordValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LinkPassword deserialize(JsonParser p) throws IOException, JsonParseException {
            LinkPassword value;
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
            else if ("remove_password".equals(tag)) {
                value = LinkPassword.REMOVE_PASSWORD;
            }
            else if ("set_password".equals(tag)) {
                String fieldValue = null;
                expectField("set_password", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = LinkPassword.setPassword(fieldValue);
            }
            else {
                value = LinkPassword.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
