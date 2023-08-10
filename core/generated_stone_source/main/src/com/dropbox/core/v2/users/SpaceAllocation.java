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
 * Space is allocated differently based on the type of account.
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
public final class SpaceAllocation {
    // union users.SpaceAllocation (users.stone)

    /**
     * Discriminating tag type for {@link SpaceAllocation}.
     */
    public enum Tag {
        /**
         * The user's space allocation applies only to their individual account.
         */
        INDIVIDUAL, // IndividualSpaceAllocation
        /**
         * The user shares space with other members of their team.
         */
        TEAM, // TeamSpaceAllocation
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
    public static final SpaceAllocation OTHER = new SpaceAllocation().withTag(Tag.OTHER);

    private Tag _tag;
    private IndividualSpaceAllocation individualValue;
    private TeamSpaceAllocation teamValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private SpaceAllocation() {
    }


    /**
     * Space is allocated differently based on the type of account.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private SpaceAllocation withTag(Tag _tag) {
        SpaceAllocation result = new SpaceAllocation();
        result._tag = _tag;
        return result;
    }

    /**
     * Space is allocated differently based on the type of account.
     *
     * @param individualValue  The user's space allocation applies only to their
     *     individual account. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private SpaceAllocation withTagAndIndividual(Tag _tag, IndividualSpaceAllocation individualValue) {
        SpaceAllocation result = new SpaceAllocation();
        result._tag = _tag;
        result.individualValue = individualValue;
        return result;
    }

    /**
     * Space is allocated differently based on the type of account.
     *
     * @param teamValue  The user shares space with other members of their team.
     *     Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private SpaceAllocation withTagAndTeam(Tag _tag, TeamSpaceAllocation teamValue) {
        SpaceAllocation result = new SpaceAllocation();
        result._tag = _tag;
        result.teamValue = teamValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code SpaceAllocation}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#INDIVIDUAL},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INDIVIDUAL}, {@code false} otherwise.
     */
    public boolean isIndividual() {
        return this._tag == Tag.INDIVIDUAL;
    }

    /**
     * Returns an instance of {@code SpaceAllocation} that has its tag set to
     * {@link Tag#INDIVIDUAL}.
     *
     * <p> The user's space allocation applies only to their individual account.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SpaceAllocation} with its tag set to {@link
     *     Tag#INDIVIDUAL}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SpaceAllocation individual(IndividualSpaceAllocation value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SpaceAllocation().withTagAndIndividual(Tag.INDIVIDUAL, value);
    }

    /**
     * The user's space allocation applies only to their individual account.
     *
     * <p> This instance must be tagged as {@link Tag#INDIVIDUAL}. </p>
     *
     * @return The {@link IndividualSpaceAllocation} value associated with this
     *     instance if {@link #isIndividual} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isIndividual} is {@code false}.
     */
    public IndividualSpaceAllocation getIndividualValue() {
        if (this._tag != Tag.INDIVIDUAL) {
            throw new IllegalStateException("Invalid tag: required Tag.INDIVIDUAL, but was Tag." + this._tag.name());
        }
        return individualValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#TEAM},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#TEAM},
     *     {@code false} otherwise.
     */
    public boolean isTeam() {
        return this._tag == Tag.TEAM;
    }

    /**
     * Returns an instance of {@code SpaceAllocation} that has its tag set to
     * {@link Tag#TEAM}.
     *
     * <p> The user shares space with other members of their team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SpaceAllocation} with its tag set to {@link
     *     Tag#TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SpaceAllocation team(TeamSpaceAllocation value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SpaceAllocation().withTagAndTeam(Tag.TEAM, value);
    }

    /**
     * The user shares space with other members of their team.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM}. </p>
     *
     * @return The {@link TeamSpaceAllocation} value associated with this
     *     instance if {@link #isTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeam} is {@code false}.
     */
    public TeamSpaceAllocation getTeamValue() {
        if (this._tag != Tag.TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM, but was Tag." + this._tag.name());
        }
        return teamValue;
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
            individualValue,
            teamValue
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
        else if (obj instanceof SpaceAllocation) {
            SpaceAllocation other = (SpaceAllocation) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INDIVIDUAL:
                    return (this.individualValue == other.individualValue) || (this.individualValue.equals(other.individualValue));
                case TEAM:
                    return (this.teamValue == other.teamValue) || (this.teamValue.equals(other.teamValue));
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
    static class Serializer extends UnionSerializer<SpaceAllocation> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SpaceAllocation value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INDIVIDUAL: {
                    g.writeStartObject();
                    writeTag("individual", g);
                    IndividualSpaceAllocation.Serializer.INSTANCE.serialize(value.individualValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case TEAM: {
                    g.writeStartObject();
                    writeTag("team", g);
                    TeamSpaceAllocation.Serializer.INSTANCE.serialize(value.teamValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SpaceAllocation deserialize(JsonParser p) throws IOException, JsonParseException {
            SpaceAllocation value;
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
            else if ("individual".equals(tag)) {
                IndividualSpaceAllocation fieldValue = null;
                fieldValue = IndividualSpaceAllocation.Serializer.INSTANCE.deserialize(p, true);
                value = SpaceAllocation.individual(fieldValue);
            }
            else if ("team".equals(tag)) {
                TeamSpaceAllocation fieldValue = null;
                fieldValue = TeamSpaceAllocation.Serializer.INSTANCE.deserialize(p, true);
                value = SpaceAllocation.team(fieldValue);
            }
            else {
                value = SpaceAllocation.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
