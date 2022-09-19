/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

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
 * The value for {@link UserFeature#FILE_LOCKING}.
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
public final class FileLockingValue {
    // union users.FileLockingValue (users.stone)

    /**
     * Discriminating tag type for {@link FileLockingValue}.
     */
    public enum Tag {
        /**
         * When this value is True, the user can lock files in shared
         * directories. When the value is False the user can unlock the files
         * they have locked or request to unlock files locked by others.
         */
        ENABLED, // boolean
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
    public static final FileLockingValue OTHER = new FileLockingValue().withTag(Tag.OTHER);

    private Tag _tag;
    private Boolean enabledValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private FileLockingValue() {
    }


    /**
     * The value for {@link UserFeature#FILE_LOCKING}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private FileLockingValue withTag(Tag _tag) {
        FileLockingValue result = new FileLockingValue();
        result._tag = _tag;
        return result;
    }

    /**
     * The value for {@link UserFeature#FILE_LOCKING}.
     *
     * @param enabledValue  When this value is True, the user can lock files in
     *     shared directories. When the value is False the user can unlock the
     *     files they have locked or request to unlock files locked by others.
     * @param _tag  Discriminating tag for this instance.
     */
    private FileLockingValue withTagAndEnabled(Tag _tag, Boolean enabledValue) {
        FileLockingValue result = new FileLockingValue();
        result._tag = _tag;
        result.enabledValue = enabledValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code FileLockingValue}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#ENABLED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ENABLED},
     *     {@code false} otherwise.
     */
    public boolean isEnabled() {
        return this._tag == Tag.ENABLED;
    }

    /**
     * Returns an instance of {@code FileLockingValue} that has its tag set to
     * {@link Tag#ENABLED}.
     *
     * <p> When this value is True, the user can lock files in shared
     * directories. When the value is False the user can unlock the files they
     * have locked or request to unlock files locked by others. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FileLockingValue} with its tag set to {@link
     *     Tag#ENABLED}.
     */
    public static FileLockingValue enabled(boolean value) {
        return new FileLockingValue().withTagAndEnabled(Tag.ENABLED, value);
    }

    /**
     * When this value is True, the user can lock files in shared directories.
     * When the value is False the user can unlock the files they have locked or
     * request to unlock files locked by others.
     *
     * <p> This instance must be tagged as {@link Tag#ENABLED}. </p>
     *
     * @return The {@link boolean} value associated with this instance if {@link
     *     #isEnabled} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEnabled} is {@code false}.
     */
    public boolean getEnabledValue() {
        if (this._tag != Tag.ENABLED) {
            throw new IllegalStateException("Invalid tag: required Tag.ENABLED, but was Tag." + this._tag.name());
        }
        return enabledValue;
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
            enabledValue
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
        else if (obj instanceof FileLockingValue) {
            FileLockingValue other = (FileLockingValue) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ENABLED:
                    return this.enabledValue == other.enabledValue;
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
    static class Serializer extends UnionSerializer<FileLockingValue> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileLockingValue value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ENABLED: {
                    g.writeStartObject();
                    writeTag("enabled", g);
                    g.writeFieldName("enabled");
                    StoneSerializers.boolean_().serialize(value.enabledValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileLockingValue deserialize(JsonParser p) throws IOException, JsonParseException {
            FileLockingValue value;
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
            else if ("enabled".equals(tag)) {
                Boolean fieldValue = null;
                expectField("enabled", p);
                fieldValue = StoneSerializers.boolean_().deserialize(p);
                value = FileLockingValue.enabled(fieldValue);
            }
            else {
                value = FileLockingValue.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
