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
 * The value for {@link Feature#HAS_TEAM_SELECTIVE_SYNC}.
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
public final class HasTeamSelectiveSyncValue {
    // union team.HasTeamSelectiveSyncValue (team.stone)

    /**
     * Discriminating tag type for {@link HasTeamSelectiveSyncValue}.
     */
    public enum Tag {
        /**
         * Does this team have team selective sync enabled.
         */
        HAS_TEAM_SELECTIVE_SYNC, // boolean
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
    public static final HasTeamSelectiveSyncValue OTHER = new HasTeamSelectiveSyncValue().withTag(Tag.OTHER);

    private Tag _tag;
    private Boolean hasTeamSelectiveSyncValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private HasTeamSelectiveSyncValue() {
    }


    /**
     * The value for {@link Feature#HAS_TEAM_SELECTIVE_SYNC}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private HasTeamSelectiveSyncValue withTag(Tag _tag) {
        HasTeamSelectiveSyncValue result = new HasTeamSelectiveSyncValue();
        result._tag = _tag;
        return result;
    }

    /**
     * The value for {@link Feature#HAS_TEAM_SELECTIVE_SYNC}.
     *
     * @param hasTeamSelectiveSyncValue  Does this team have team selective sync
     *     enabled.
     * @param _tag  Discriminating tag for this instance.
     */
    private HasTeamSelectiveSyncValue withTagAndHasTeamSelectiveSync(Tag _tag, Boolean hasTeamSelectiveSyncValue) {
        HasTeamSelectiveSyncValue result = new HasTeamSelectiveSyncValue();
        result._tag = _tag;
        result.hasTeamSelectiveSyncValue = hasTeamSelectiveSyncValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code HasTeamSelectiveSyncValue}. </p>
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
     * Tag#HAS_TEAM_SELECTIVE_SYNC}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#HAS_TEAM_SELECTIVE_SYNC}, {@code false} otherwise.
     */
    public boolean isHasTeamSelectiveSync() {
        return this._tag == Tag.HAS_TEAM_SELECTIVE_SYNC;
    }

    /**
     * Returns an instance of {@code HasTeamSelectiveSyncValue} that has its tag
     * set to {@link Tag#HAS_TEAM_SELECTIVE_SYNC}.
     *
     * <p> Does this team have team selective sync enabled. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code HasTeamSelectiveSyncValue} with its tag set to
     *     {@link Tag#HAS_TEAM_SELECTIVE_SYNC}.
     */
    public static HasTeamSelectiveSyncValue hasTeamSelectiveSync(boolean value) {
        return new HasTeamSelectiveSyncValue().withTagAndHasTeamSelectiveSync(Tag.HAS_TEAM_SELECTIVE_SYNC, value);
    }

    /**
     * Does this team have team selective sync enabled.
     *
     * <p> This instance must be tagged as {@link Tag#HAS_TEAM_SELECTIVE_SYNC}.
     * </p>
     *
     * @return The {@link boolean} value associated with this instance if {@link
     *     #isHasTeamSelectiveSync} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isHasTeamSelectiveSync} is
     *     {@code false}.
     */
    public boolean getHasTeamSelectiveSyncValue() {
        if (this._tag != Tag.HAS_TEAM_SELECTIVE_SYNC) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SELECTIVE_SYNC, but was Tag." + this._tag.name());
        }
        return hasTeamSelectiveSyncValue;
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
            hasTeamSelectiveSyncValue
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
        else if (obj instanceof HasTeamSelectiveSyncValue) {
            HasTeamSelectiveSyncValue other = (HasTeamSelectiveSyncValue) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case HAS_TEAM_SELECTIVE_SYNC:
                    return this.hasTeamSelectiveSyncValue == other.hasTeamSelectiveSyncValue;
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
    static class Serializer extends UnionSerializer<HasTeamSelectiveSyncValue> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(HasTeamSelectiveSyncValue value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case HAS_TEAM_SELECTIVE_SYNC: {
                    g.writeStartObject();
                    writeTag("has_team_selective_sync", g);
                    g.writeFieldName("has_team_selective_sync");
                    StoneSerializers.boolean_().serialize(value.hasTeamSelectiveSyncValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public HasTeamSelectiveSyncValue deserialize(JsonParser p) throws IOException, JsonParseException {
            HasTeamSelectiveSyncValue value;
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
            else if ("has_team_selective_sync".equals(tag)) {
                Boolean fieldValue = null;
                expectField("has_team_selective_sync", p);
                fieldValue = StoneSerializers.boolean_().deserialize(p);
                value = HasTeamSelectiveSyncValue.hasTeamSelectiveSync(fieldValue);
            }
            else {
                value = HasTeamSelectiveSyncValue.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
