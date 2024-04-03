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
import java.util.regex.Pattern;

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
public final class PathOrLink {
    // union files.PathOrLink (files.stone)

    /**
     * Discriminating tag type for {@link PathOrLink}.
     */
    public enum Tag {
        PATH, // String
        LINK, // SharedLinkFileInfo
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
    public static final PathOrLink OTHER = new PathOrLink().withTag(Tag.OTHER);

    private Tag _tag;
    private String pathValue;
    private SharedLinkFileInfo linkValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PathOrLink() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PathOrLink withTag(Tag _tag) {
        PathOrLink result = new PathOrLink();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathValue  Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PathOrLink withTagAndPath(Tag _tag, String pathValue) {
        PathOrLink result = new PathOrLink();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
    }

    /**
     *
     * @param linkValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PathOrLink withTagAndLink(Tag _tag, SharedLinkFileInfo linkValue) {
        PathOrLink result = new PathOrLink();
        result._tag = _tag;
        result.linkValue = linkValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PathOrLink}. </p>
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
     * Returns an instance of {@code PathOrLink} that has its tag set to {@link
     * Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PathOrLink} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} does not match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     or is {@code null}.
     */
    public static PathOrLink path(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new PathOrLink().withTagAndPath(Tag.PATH, value);
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
     * Returns {@code true} if this instance has the tag {@link Tag#LINK},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#LINK},
     *     {@code false} otherwise.
     */
    public boolean isLink() {
        return this._tag == Tag.LINK;
    }

    /**
     * Returns an instance of {@code PathOrLink} that has its tag set to {@link
     * Tag#LINK}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PathOrLink} with its tag set to {@link
     *     Tag#LINK}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PathOrLink link(SharedLinkFileInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PathOrLink().withTagAndLink(Tag.LINK, value);
    }

    /**
     * This instance must be tagged as {@link Tag#LINK}.
     *
     * @return The {@link SharedLinkFileInfo} value associated with this
     *     instance if {@link #isLink} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isLink} is {@code false}.
     */
    public SharedLinkFileInfo getLinkValue() {
        if (this._tag != Tag.LINK) {
            throw new IllegalStateException("Invalid tag: required Tag.LINK, but was Tag." + this._tag.name());
        }
        return linkValue;
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
            this.linkValue
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
        else if (obj instanceof PathOrLink) {
            PathOrLink other = (PathOrLink) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case LINK:
                    return (this.linkValue == other.linkValue) || (this.linkValue.equals(other.linkValue));
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
    static class Serializer extends UnionSerializer<PathOrLink> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PathOrLink value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    StoneSerializers.string().serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case LINK: {
                    g.writeStartObject();
                    writeTag("link", g);
                    SharedLinkFileInfo.Serializer.INSTANCE.serialize(value.linkValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PathOrLink deserialize(JsonParser p) throws IOException, JsonParseException {
            PathOrLink value;
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
                expectField("path", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = PathOrLink.path(fieldValue);
            }
            else if ("link".equals(tag)) {
                SharedLinkFileInfo fieldValue = null;
                fieldValue = SharedLinkFileInfo.Serializer.INSTANCE.deserialize(p, true);
                value = PathOrLink.link(fieldValue);
            }
            else {
                value = PathOrLink.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
