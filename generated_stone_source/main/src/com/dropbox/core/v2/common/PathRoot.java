/* DO NOT EDIT */
/* This file was generated from common.stone */

package com.dropbox.core.v2.common;

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
public final class PathRoot {
    // union common.PathRoot (common.stone)

    /**
     * Discriminating tag type for {@link PathRoot}.
     */
    public enum Tag {
        /**
         * Paths are relative to the authenticating user's home namespace,
         * whether or not that user belongs to a team.
         */
        HOME,
        /**
         * Paths are relative to the authenticating user's root namespace (This
         * results in {@link PathRootError#getInvalidRootValue} if the user's
         * root namespace has changed.).
         */
        ROOT, // String
        /**
         * Paths are relative to given namespace id (This results in {@link
         * PathRootError#NO_PERMISSION} if you don't have access to this
         * namespace.).
         */
        NAMESPACE_ID, // String
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
     * Paths are relative to the authenticating user's home namespace, whether
     * or not that user belongs to a team.
     */
    public static final PathRoot HOME = new PathRoot().withTag(Tag.HOME);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final PathRoot OTHER = new PathRoot().withTag(Tag.OTHER);

    private Tag _tag;
    private String rootValue;
    private String namespaceIdValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PathRoot() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PathRoot withTag(Tag _tag) {
        PathRoot result = new PathRoot();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param rootValue  Paths are relative to the authenticating user's root
     *     namespace (This results in {@link PathRootError#getInvalidRootValue}
     *     if the user's root namespace has changed.). Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PathRoot withTagAndRoot(Tag _tag, String rootValue) {
        PathRoot result = new PathRoot();
        result._tag = _tag;
        result.rootValue = rootValue;
        return result;
    }

    /**
     *
     * @param namespaceIdValue  Paths are relative to given namespace id (This
     *     results in {@link PathRootError#NO_PERMISSION} if you don't have
     *     access to this namespace.). Must match pattern "{@code
     *     [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PathRoot withTagAndNamespaceId(Tag _tag, String namespaceIdValue) {
        PathRoot result = new PathRoot();
        result._tag = _tag;
        result.namespaceIdValue = namespaceIdValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PathRoot}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#HOME},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#HOME},
     *     {@code false} otherwise.
     */
    public boolean isHome() {
        return this._tag == Tag.HOME;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#ROOT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ROOT},
     *     {@code false} otherwise.
     */
    public boolean isRoot() {
        return this._tag == Tag.ROOT;
    }

    /**
     * Returns an instance of {@code PathRoot} that has its tag set to {@link
     * Tag#ROOT}.
     *
     * <p> Paths are relative to the authenticating user's root namespace (This
     * results in {@link PathRootError#getInvalidRootValue} if the user's root
     * namespace has changed.). </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PathRoot} with its tag set to {@link
     *     Tag#ROOT}.
     *
     * @throws IllegalArgumentException  if {@code value} does not match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" or is {@code null}.
     */
    public static PathRoot root(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new PathRoot().withTagAndRoot(Tag.ROOT, value);
    }

    /**
     * Paths are relative to the authenticating user's root namespace (This
     * results in {@link PathRootError#getInvalidRootValue} if the user's root
     * namespace has changed.).
     *
     * <p> This instance must be tagged as {@link Tag#ROOT}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isRoot} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isRoot} is {@code false}.
     */
    public String getRootValue() {
        if (this._tag != Tag.ROOT) {
            throw new IllegalStateException("Invalid tag: required Tag.ROOT, but was Tag." + this._tag.name());
        }
        return rootValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NAMESPACE_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NAMESPACE_ID}, {@code false} otherwise.
     */
    public boolean isNamespaceId() {
        return this._tag == Tag.NAMESPACE_ID;
    }

    /**
     * Returns an instance of {@code PathRoot} that has its tag set to {@link
     * Tag#NAMESPACE_ID}.
     *
     * <p> Paths are relative to given namespace id (This results in {@link
     * PathRootError#NO_PERMISSION} if you don't have access to this
     * namespace.). </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PathRoot} with its tag set to {@link
     *     Tag#NAMESPACE_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} does not match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" or is {@code null}.
     */
    public static PathRoot namespaceId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new PathRoot().withTagAndNamespaceId(Tag.NAMESPACE_ID, value);
    }

    /**
     * Paths are relative to given namespace id (This results in {@link
     * PathRootError#NO_PERMISSION} if you don't have access to this
     * namespace.).
     *
     * <p> This instance must be tagged as {@link Tag#NAMESPACE_ID}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isNamespaceId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isNamespaceId} is {@code
     *     false}.
     */
    public String getNamespaceIdValue() {
        if (this._tag != Tag.NAMESPACE_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.NAMESPACE_ID, but was Tag." + this._tag.name());
        }
        return namespaceIdValue;
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
            rootValue,
            namespaceIdValue
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
        else if (obj instanceof PathRoot) {
            PathRoot other = (PathRoot) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case HOME:
                    return true;
                case ROOT:
                    return (this.rootValue == other.rootValue) || (this.rootValue.equals(other.rootValue));
                case NAMESPACE_ID:
                    return (this.namespaceIdValue == other.namespaceIdValue) || (this.namespaceIdValue.equals(other.namespaceIdValue));
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
    public static class Serializer extends UnionSerializer<PathRoot> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PathRoot value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case HOME: {
                    g.writeString("home");
                    break;
                }
                case ROOT: {
                    g.writeStartObject();
                    writeTag("root", g);
                    g.writeFieldName("root");
                    StoneSerializers.string().serialize(value.rootValue, g);
                    g.writeEndObject();
                    break;
                }
                case NAMESPACE_ID: {
                    g.writeStartObject();
                    writeTag("namespace_id", g);
                    g.writeFieldName("namespace_id");
                    StoneSerializers.string().serialize(value.namespaceIdValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PathRoot deserialize(JsonParser p) throws IOException, JsonParseException {
            PathRoot value;
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
            else if ("home".equals(tag)) {
                value = PathRoot.HOME;
            }
            else if ("root".equals(tag)) {
                String fieldValue = null;
                expectField("root", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = PathRoot.root(fieldValue);
            }
            else if ("namespace_id".equals(tag)) {
                String fieldValue = null;
                expectField("namespace_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = PathRoot.namespaceId(fieldValue);
            }
            else {
                value = PathRoot.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
