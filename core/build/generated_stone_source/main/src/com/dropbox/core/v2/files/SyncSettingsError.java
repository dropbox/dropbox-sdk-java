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
public final class SyncSettingsError {
    // union files.SyncSettingsError (files.stone)

    /**
     * Discriminating tag type for {@link SyncSettingsError}.
     */
    public enum Tag {
        PATH, // LookupError
        /**
         * Setting this combination of sync settings simultaneously is not
         * supported.
         */
        UNSUPPORTED_COMBINATION,
        /**
         * The specified configuration is not supported.
         */
        UNSUPPORTED_CONFIGURATION,
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
     * Setting this combination of sync settings simultaneously is not
     * supported.
     */
    public static final SyncSettingsError UNSUPPORTED_COMBINATION = new SyncSettingsError().withTag(Tag.UNSUPPORTED_COMBINATION);
    /**
     * The specified configuration is not supported.
     */
    public static final SyncSettingsError UNSUPPORTED_CONFIGURATION = new SyncSettingsError().withTag(Tag.UNSUPPORTED_CONFIGURATION);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SyncSettingsError OTHER = new SyncSettingsError().withTag(Tag.OTHER);

    private Tag _tag;
    private LookupError pathValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private SyncSettingsError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private SyncSettingsError withTag(Tag _tag) {
        SyncSettingsError result = new SyncSettingsError();
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
    private SyncSettingsError withTagAndPath(Tag _tag, LookupError pathValue) {
        SyncSettingsError result = new SyncSettingsError();
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
     * values for this {@code SyncSettingsError}. </p>
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
     * Returns an instance of {@code SyncSettingsError} that has its tag set to
     * {@link Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SyncSettingsError} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SyncSettingsError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SyncSettingsError().withTagAndPath(Tag.PATH, value);
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
     * Tag#UNSUPPORTED_COMBINATION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_COMBINATION}, {@code false} otherwise.
     */
    public boolean isUnsupportedCombination() {
        return this._tag == Tag.UNSUPPORTED_COMBINATION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSUPPORTED_CONFIGURATION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_CONFIGURATION}, {@code false} otherwise.
     */
    public boolean isUnsupportedConfiguration() {
        return this._tag == Tag.UNSUPPORTED_CONFIGURATION;
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
            pathValue
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
        else if (obj instanceof SyncSettingsError) {
            SyncSettingsError other = (SyncSettingsError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case UNSUPPORTED_COMBINATION:
                    return true;
                case UNSUPPORTED_CONFIGURATION:
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
    public static class Serializer extends UnionSerializer<SyncSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SyncSettingsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case UNSUPPORTED_COMBINATION: {
                    g.writeString("unsupported_combination");
                    break;
                }
                case UNSUPPORTED_CONFIGURATION: {
                    g.writeString("unsupported_configuration");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SyncSettingsError deserialize(JsonParser p) throws IOException, JsonParseException {
            SyncSettingsError value;
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
                value = SyncSettingsError.path(fieldValue);
            }
            else if ("unsupported_combination".equals(tag)) {
                value = SyncSettingsError.UNSUPPORTED_COMBINATION;
            }
            else if ("unsupported_configuration".equals(tag)) {
                value = SyncSettingsError.UNSUPPORTED_CONFIGURATION;
            }
            else {
                value = SyncSettingsError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
