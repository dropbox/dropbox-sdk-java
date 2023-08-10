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
public final class PathRootError {
    // union common.PathRootError (common.stone)

    /**
     * Discriminating tag type for {@link PathRootError}.
     */
    public enum Tag {
        /**
         * The root namespace id in Dropbox-API-Path-Root header is not valid.
         * The value of this error is the user's latest root info.
         */
        INVALID_ROOT, // RootInfo
        /**
         * You don't have permission to access the namespace id in
         * Dropbox-API-Path-Root  header.
         */
        NO_PERMISSION,
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
     * You don't have permission to access the namespace id in
     * Dropbox-API-Path-Root  header.
     */
    public static final PathRootError NO_PERMISSION = new PathRootError().withTag(Tag.NO_PERMISSION);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final PathRootError OTHER = new PathRootError().withTag(Tag.OTHER);

    private Tag _tag;
    private RootInfo invalidRootValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PathRootError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PathRootError withTag(Tag _tag) {
        PathRootError result = new PathRootError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param invalidRootValue  The root namespace id in Dropbox-API-Path-Root
     *     header is not valid. The value of this error is the user's latest
     *     root info. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PathRootError withTagAndInvalidRoot(Tag _tag, RootInfo invalidRootValue) {
        PathRootError result = new PathRootError();
        result._tag = _tag;
        result.invalidRootValue = invalidRootValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PathRootError}. </p>
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
     * Tag#INVALID_ROOT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_ROOT}, {@code false} otherwise.
     */
    public boolean isInvalidRoot() {
        return this._tag == Tag.INVALID_ROOT;
    }

    /**
     * Returns an instance of {@code PathRootError} that has its tag set to
     * {@link Tag#INVALID_ROOT}.
     *
     * <p> The root namespace id in Dropbox-API-Path-Root header is not valid.
     * The value of this error is the user's latest root info. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PathRootError} with its tag set to {@link
     *     Tag#INVALID_ROOT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PathRootError invalidRoot(RootInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PathRootError().withTagAndInvalidRoot(Tag.INVALID_ROOT, value);
    }

    /**
     * The root namespace id in Dropbox-API-Path-Root header is not valid. The
     * value of this error is the user's latest root info.
     *
     * <p> This instance must be tagged as {@link Tag#INVALID_ROOT}. </p>
     *
     * @return The {@link RootInfo} value associated with this instance if
     *     {@link #isInvalidRoot} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInvalidRoot} is {@code
     *     false}.
     */
    public RootInfo getInvalidRootValue() {
        if (this._tag != Tag.INVALID_ROOT) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_ROOT, but was Tag." + this._tag.name());
        }
        return invalidRootValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
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
            invalidRootValue
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
        else if (obj instanceof PathRootError) {
            PathRootError other = (PathRootError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INVALID_ROOT:
                    return (this.invalidRootValue == other.invalidRootValue) || (this.invalidRootValue.equals(other.invalidRootValue));
                case NO_PERMISSION:
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
    public static class Serializer extends UnionSerializer<PathRootError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PathRootError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INVALID_ROOT: {
                    g.writeStartObject();
                    writeTag("invalid_root", g);
                    g.writeFieldName("invalid_root");
                    RootInfo.Serializer.INSTANCE.serialize(value.invalidRootValue, g);
                    g.writeEndObject();
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PathRootError deserialize(JsonParser p) throws IOException, JsonParseException {
            PathRootError value;
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
            else if ("invalid_root".equals(tag)) {
                RootInfo fieldValue = null;
                expectField("invalid_root", p);
                fieldValue = RootInfo.Serializer.INSTANCE.deserialize(p);
                value = PathRootError.invalidRoot(fieldValue);
            }
            else if ("no_permission".equals(tag)) {
                value = PathRootError.NO_PERMISSION;
            }
            else {
                value = PathRootError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
