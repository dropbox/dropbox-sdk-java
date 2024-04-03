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
 * The value for {@link UserFeature#PAPER_AS_FILES}.
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
public final class PaperAsFilesValue {
    // union users.PaperAsFilesValue (users.stone)

    /**
     * Discriminating tag type for {@link PaperAsFilesValue}.
     */
    public enum Tag {
        /**
         * When this value is true, the user's Paper docs are accessible in
         * Dropbox with the .paper extension and must be accessed via the /files
         * endpoints.  When this value is false, the user's Paper docs are
         * stored separate from Dropbox files and folders and should be accessed
         * via the /paper endpoints.
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
    public static final PaperAsFilesValue OTHER = new PaperAsFilesValue().withTag(Tag.OTHER);

    private Tag _tag;
    private Boolean enabledValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PaperAsFilesValue() {
    }


    /**
     * The value for {@link UserFeature#PAPER_AS_FILES}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PaperAsFilesValue withTag(Tag _tag) {
        PaperAsFilesValue result = new PaperAsFilesValue();
        result._tag = _tag;
        return result;
    }

    /**
     * The value for {@link UserFeature#PAPER_AS_FILES}.
     *
     * @param enabledValue  When this value is true, the user's Paper docs are
     *     accessible in Dropbox with the .paper extension and must be accessed
     *     via the /files endpoints.  When this value is false, the user's Paper
     *     docs are stored separate from Dropbox files and folders and should be
     *     accessed via the /paper endpoints.
     * @param _tag  Discriminating tag for this instance.
     */
    private PaperAsFilesValue withTagAndEnabled(Tag _tag, Boolean enabledValue) {
        PaperAsFilesValue result = new PaperAsFilesValue();
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
     * values for this {@code PaperAsFilesValue}. </p>
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
     * Returns an instance of {@code PaperAsFilesValue} that has its tag set to
     * {@link Tag#ENABLED}.
     *
     * <p> When this value is true, the user's Paper docs are accessible in
     * Dropbox with the .paper extension and must be accessed via the /files
     * endpoints.  When this value is false, the user's Paper docs are stored
     * separate from Dropbox files and folders and should be accessed via the
     * /paper endpoints. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PaperAsFilesValue} with its tag set to {@link
     *     Tag#ENABLED}.
     */
    public static PaperAsFilesValue enabled(boolean value) {
        return new PaperAsFilesValue().withTagAndEnabled(Tag.ENABLED, value);
    }

    /**
     * When this value is true, the user's Paper docs are accessible in Dropbox
     * with the .paper extension and must be accessed via the /files endpoints.
     * When this value is false, the user's Paper docs are stored separate from
     * Dropbox files and folders and should be accessed via the /paper
     * endpoints.
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
            this._tag,
            this.enabledValue
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
        else if (obj instanceof PaperAsFilesValue) {
            PaperAsFilesValue other = (PaperAsFilesValue) obj;
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
    static class Serializer extends UnionSerializer<PaperAsFilesValue> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperAsFilesValue value, JsonGenerator g) throws IOException, JsonGenerationException {
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
        public PaperAsFilesValue deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperAsFilesValue value;
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
                value = PaperAsFilesValue.enabled(fieldValue);
            }
            else {
                value = PaperAsFilesValue.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
