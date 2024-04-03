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
 * The value for {@link Feature#HAS_TEAM_SHARED_DROPBOX}.
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
public final class HasTeamSharedDropboxValue {
    // union team.HasTeamSharedDropboxValue (team.stone)

    /**
     * Discriminating tag type for {@link HasTeamSharedDropboxValue}.
     */
    public enum Tag {
        /**
         * Does this team have a shared team root.
         */
        HAS_TEAM_SHARED_DROPBOX, // boolean
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
    public static final HasTeamSharedDropboxValue OTHER = new HasTeamSharedDropboxValue().withTag(Tag.OTHER);

    private Tag _tag;
    private Boolean hasTeamSharedDropboxValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private HasTeamSharedDropboxValue() {
    }


    /**
     * The value for {@link Feature#HAS_TEAM_SHARED_DROPBOX}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private HasTeamSharedDropboxValue withTag(Tag _tag) {
        HasTeamSharedDropboxValue result = new HasTeamSharedDropboxValue();
        result._tag = _tag;
        return result;
    }

    /**
     * The value for {@link Feature#HAS_TEAM_SHARED_DROPBOX}.
     *
     * @param hasTeamSharedDropboxValue  Does this team have a shared team root.
     * @param _tag  Discriminating tag for this instance.
     */
    private HasTeamSharedDropboxValue withTagAndHasTeamSharedDropbox(Tag _tag, Boolean hasTeamSharedDropboxValue) {
        HasTeamSharedDropboxValue result = new HasTeamSharedDropboxValue();
        result._tag = _tag;
        result.hasTeamSharedDropboxValue = hasTeamSharedDropboxValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code HasTeamSharedDropboxValue}. </p>
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
     * Tag#HAS_TEAM_SHARED_DROPBOX}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#HAS_TEAM_SHARED_DROPBOX}, {@code false} otherwise.
     */
    public boolean isHasTeamSharedDropbox() {
        return this._tag == Tag.HAS_TEAM_SHARED_DROPBOX;
    }

    /**
     * Returns an instance of {@code HasTeamSharedDropboxValue} that has its tag
     * set to {@link Tag#HAS_TEAM_SHARED_DROPBOX}.
     *
     * <p> Does this team have a shared team root. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code HasTeamSharedDropboxValue} with its tag set to
     *     {@link Tag#HAS_TEAM_SHARED_DROPBOX}.
     */
    public static HasTeamSharedDropboxValue hasTeamSharedDropbox(boolean value) {
        return new HasTeamSharedDropboxValue().withTagAndHasTeamSharedDropbox(Tag.HAS_TEAM_SHARED_DROPBOX, value);
    }

    /**
     * Does this team have a shared team root.
     *
     * <p> This instance must be tagged as {@link Tag#HAS_TEAM_SHARED_DROPBOX}.
     * </p>
     *
     * @return The {@link boolean} value associated with this instance if {@link
     *     #isHasTeamSharedDropbox} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isHasTeamSharedDropbox} is
     *     {@code false}.
     */
    public boolean getHasTeamSharedDropboxValue() {
        if (this._tag != Tag.HAS_TEAM_SHARED_DROPBOX) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SHARED_DROPBOX, but was Tag." + this._tag.name());
        }
        return hasTeamSharedDropboxValue;
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
            this.hasTeamSharedDropboxValue
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
        else if (obj instanceof HasTeamSharedDropboxValue) {
            HasTeamSharedDropboxValue other = (HasTeamSharedDropboxValue) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case HAS_TEAM_SHARED_DROPBOX:
                    return this.hasTeamSharedDropboxValue == other.hasTeamSharedDropboxValue;
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
    static class Serializer extends UnionSerializer<HasTeamSharedDropboxValue> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(HasTeamSharedDropboxValue value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case HAS_TEAM_SHARED_DROPBOX: {
                    g.writeStartObject();
                    writeTag("has_team_shared_dropbox", g);
                    g.writeFieldName("has_team_shared_dropbox");
                    StoneSerializers.boolean_().serialize(value.hasTeamSharedDropboxValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public HasTeamSharedDropboxValue deserialize(JsonParser p) throws IOException, JsonParseException {
            HasTeamSharedDropboxValue value;
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
            else if ("has_team_shared_dropbox".equals(tag)) {
                Boolean fieldValue = null;
                expectField("has_team_shared_dropbox", p);
                fieldValue = StoneSerializers.boolean_().deserialize(p);
                value = HasTeamSharedDropboxValue.hasTeamSharedDropbox(fieldValue);
            }
            else {
                value = HasTeamSharedDropboxValue.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
