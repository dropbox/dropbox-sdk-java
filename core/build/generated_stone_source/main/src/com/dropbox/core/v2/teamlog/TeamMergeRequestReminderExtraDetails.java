/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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
 * Team merge request reminder details
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
public final class TeamMergeRequestReminderExtraDetails {
    // union team_log.TeamMergeRequestReminderExtraDetails (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link TeamMergeRequestReminderExtraDetails}.
     */
    public enum Tag {
        /**
         * Team merge request reminder details shown to the primary team.
         */
        PRIMARY_TEAM, // PrimaryTeamRequestReminderDetails
        /**
         * Team merge request reminder details shown to the secondary team.
         */
        SECONDARY_TEAM, // SecondaryTeamRequestReminderDetails
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
    public static final TeamMergeRequestReminderExtraDetails OTHER = new TeamMergeRequestReminderExtraDetails().withTag(Tag.OTHER);

    private Tag _tag;
    private PrimaryTeamRequestReminderDetails primaryTeamValue;
    private SecondaryTeamRequestReminderDetails secondaryTeamValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private TeamMergeRequestReminderExtraDetails() {
    }


    /**
     * Team merge request reminder details
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private TeamMergeRequestReminderExtraDetails withTag(Tag _tag) {
        TeamMergeRequestReminderExtraDetails result = new TeamMergeRequestReminderExtraDetails();
        result._tag = _tag;
        return result;
    }

    /**
     * Team merge request reminder details
     *
     * @param primaryTeamValue  Team merge request reminder details shown to the
     *     primary team. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamMergeRequestReminderExtraDetails withTagAndPrimaryTeam(Tag _tag, PrimaryTeamRequestReminderDetails primaryTeamValue) {
        TeamMergeRequestReminderExtraDetails result = new TeamMergeRequestReminderExtraDetails();
        result._tag = _tag;
        result.primaryTeamValue = primaryTeamValue;
        return result;
    }

    /**
     * Team merge request reminder details
     *
     * @param secondaryTeamValue  Team merge request reminder details shown to
     *     the secondary team. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamMergeRequestReminderExtraDetails withTagAndSecondaryTeam(Tag _tag, SecondaryTeamRequestReminderDetails secondaryTeamValue) {
        TeamMergeRequestReminderExtraDetails result = new TeamMergeRequestReminderExtraDetails();
        result._tag = _tag;
        result.secondaryTeamValue = secondaryTeamValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TeamMergeRequestReminderExtraDetails}. </p>
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
     * Tag#PRIMARY_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PRIMARY_TEAM}, {@code false} otherwise.
     */
    public boolean isPrimaryTeam() {
        return this._tag == Tag.PRIMARY_TEAM;
    }

    /**
     * Returns an instance of {@code TeamMergeRequestReminderExtraDetails} that
     * has its tag set to {@link Tag#PRIMARY_TEAM}.
     *
     * <p> Team merge request reminder details shown to the primary team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamMergeRequestReminderExtraDetails} with its
     *     tag set to {@link Tag#PRIMARY_TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamMergeRequestReminderExtraDetails primaryTeam(PrimaryTeamRequestReminderDetails value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestReminderExtraDetails().withTagAndPrimaryTeam(Tag.PRIMARY_TEAM, value);
    }

    /**
     * Team merge request reminder details shown to the primary team.
     *
     * <p> This instance must be tagged as {@link Tag#PRIMARY_TEAM}. </p>
     *
     * @return The {@link PrimaryTeamRequestReminderDetails} value associated
     *     with this instance if {@link #isPrimaryTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPrimaryTeam} is {@code
     *     false}.
     */
    public PrimaryTeamRequestReminderDetails getPrimaryTeamValue() {
        if (this._tag != Tag.PRIMARY_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.PRIMARY_TEAM, but was Tag." + this._tag.name());
        }
        return primaryTeamValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SECONDARY_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SECONDARY_TEAM}, {@code false} otherwise.
     */
    public boolean isSecondaryTeam() {
        return this._tag == Tag.SECONDARY_TEAM;
    }

    /**
     * Returns an instance of {@code TeamMergeRequestReminderExtraDetails} that
     * has its tag set to {@link Tag#SECONDARY_TEAM}.
     *
     * <p> Team merge request reminder details shown to the secondary team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamMergeRequestReminderExtraDetails} with its
     *     tag set to {@link Tag#SECONDARY_TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamMergeRequestReminderExtraDetails secondaryTeam(SecondaryTeamRequestReminderDetails value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestReminderExtraDetails().withTagAndSecondaryTeam(Tag.SECONDARY_TEAM, value);
    }

    /**
     * Team merge request reminder details shown to the secondary team.
     *
     * <p> This instance must be tagged as {@link Tag#SECONDARY_TEAM}. </p>
     *
     * @return The {@link SecondaryTeamRequestReminderDetails} value associated
     *     with this instance if {@link #isSecondaryTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSecondaryTeam} is {@code
     *     false}.
     */
    public SecondaryTeamRequestReminderDetails getSecondaryTeamValue() {
        if (this._tag != Tag.SECONDARY_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.SECONDARY_TEAM, but was Tag." + this._tag.name());
        }
        return secondaryTeamValue;
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
            this.primaryTeamValue,
            this.secondaryTeamValue
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
        else if (obj instanceof TeamMergeRequestReminderExtraDetails) {
            TeamMergeRequestReminderExtraDetails other = (TeamMergeRequestReminderExtraDetails) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PRIMARY_TEAM:
                    return (this.primaryTeamValue == other.primaryTeamValue) || (this.primaryTeamValue.equals(other.primaryTeamValue));
                case SECONDARY_TEAM:
                    return (this.secondaryTeamValue == other.secondaryTeamValue) || (this.secondaryTeamValue.equals(other.secondaryTeamValue));
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
    static class Serializer extends UnionSerializer<TeamMergeRequestReminderExtraDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMergeRequestReminderExtraDetails value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PRIMARY_TEAM: {
                    g.writeStartObject();
                    writeTag("primary_team", g);
                    PrimaryTeamRequestReminderDetails.Serializer.INSTANCE.serialize(value.primaryTeamValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case SECONDARY_TEAM: {
                    g.writeStartObject();
                    writeTag("secondary_team", g);
                    SecondaryTeamRequestReminderDetails.Serializer.INSTANCE.serialize(value.secondaryTeamValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TeamMergeRequestReminderExtraDetails deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamMergeRequestReminderExtraDetails value;
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
            else if ("primary_team".equals(tag)) {
                PrimaryTeamRequestReminderDetails fieldValue = null;
                fieldValue = PrimaryTeamRequestReminderDetails.Serializer.INSTANCE.deserialize(p, true);
                value = TeamMergeRequestReminderExtraDetails.primaryTeam(fieldValue);
            }
            else if ("secondary_team".equals(tag)) {
                SecondaryTeamRequestReminderDetails fieldValue = null;
                fieldValue = SecondaryTeamRequestReminderDetails.Serializer.INSTANCE.deserialize(p, true);
                value = TeamMergeRequestReminderExtraDetails.secondaryTeam(fieldValue);
            }
            else {
                value = TeamMergeRequestReminderExtraDetails.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
