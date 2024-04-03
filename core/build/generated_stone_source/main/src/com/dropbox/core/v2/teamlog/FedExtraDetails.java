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
 * More details about the organization or team.
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
public final class FedExtraDetails {
    // union team_log.FedExtraDetails (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link FedExtraDetails}.
     */
    public enum Tag {
        /**
         * More details about the organization.
         */
        ORGANIZATION, // OrganizationDetails
        /**
         * More details about the team.
         */
        TEAM, // TeamDetails
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
    public static final FedExtraDetails OTHER = new FedExtraDetails().withTag(Tag.OTHER);

    private Tag _tag;
    private OrganizationDetails organizationValue;
    private TeamDetails teamValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private FedExtraDetails() {
    }


    /**
     * More details about the organization or team.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private FedExtraDetails withTag(Tag _tag) {
        FedExtraDetails result = new FedExtraDetails();
        result._tag = _tag;
        return result;
    }

    /**
     * More details about the organization or team.
     *
     * @param organizationValue  More details about the organization. Must not
     *     be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FedExtraDetails withTagAndOrganization(Tag _tag, OrganizationDetails organizationValue) {
        FedExtraDetails result = new FedExtraDetails();
        result._tag = _tag;
        result.organizationValue = organizationValue;
        return result;
    }

    /**
     * More details about the organization or team.
     *
     * @param teamValue  More details about the team. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FedExtraDetails withTagAndTeam(Tag _tag, TeamDetails teamValue) {
        FedExtraDetails result = new FedExtraDetails();
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
     * values for this {@code FedExtraDetails}. </p>
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
     * Tag#ORGANIZATION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ORGANIZATION}, {@code false} otherwise.
     */
    public boolean isOrganization() {
        return this._tag == Tag.ORGANIZATION;
    }

    /**
     * Returns an instance of {@code FedExtraDetails} that has its tag set to
     * {@link Tag#ORGANIZATION}.
     *
     * <p> More details about the organization. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FedExtraDetails} with its tag set to {@link
     *     Tag#ORGANIZATION}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FedExtraDetails organization(OrganizationDetails value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FedExtraDetails().withTagAndOrganization(Tag.ORGANIZATION, value);
    }

    /**
     * More details about the organization.
     *
     * <p> This instance must be tagged as {@link Tag#ORGANIZATION}. </p>
     *
     * @return The {@link OrganizationDetails} value associated with this
     *     instance if {@link #isOrganization} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isOrganization} is {@code
     *     false}.
     */
    public OrganizationDetails getOrganizationValue() {
        if (this._tag != Tag.ORGANIZATION) {
            throw new IllegalStateException("Invalid tag: required Tag.ORGANIZATION, but was Tag." + this._tag.name());
        }
        return organizationValue;
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
     * Returns an instance of {@code FedExtraDetails} that has its tag set to
     * {@link Tag#TEAM}.
     *
     * <p> More details about the team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FedExtraDetails} with its tag set to {@link
     *     Tag#TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FedExtraDetails team(TeamDetails value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FedExtraDetails().withTagAndTeam(Tag.TEAM, value);
    }

    /**
     * More details about the team.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM}. </p>
     *
     * @return The {@link TeamDetails} value associated with this instance if
     *     {@link #isTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeam} is {@code false}.
     */
    public TeamDetails getTeamValue() {
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
            this._tag,
            this.organizationValue,
            this.teamValue
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
        else if (obj instanceof FedExtraDetails) {
            FedExtraDetails other = (FedExtraDetails) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ORGANIZATION:
                    return (this.organizationValue == other.organizationValue) || (this.organizationValue.equals(other.organizationValue));
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
    static class Serializer extends UnionSerializer<FedExtraDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FedExtraDetails value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ORGANIZATION: {
                    g.writeStartObject();
                    writeTag("organization", g);
                    OrganizationDetails.Serializer.INSTANCE.serialize(value.organizationValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case TEAM: {
                    g.writeStartObject();
                    writeTag("team", g);
                    TeamDetails.Serializer.INSTANCE.serialize(value.teamValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FedExtraDetails deserialize(JsonParser p) throws IOException, JsonParseException {
            FedExtraDetails value;
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
            else if ("organization".equals(tag)) {
                OrganizationDetails fieldValue = null;
                fieldValue = OrganizationDetails.Serializer.INSTANCE.deserialize(p, true);
                value = FedExtraDetails.organization(fieldValue);
            }
            else if ("team".equals(tag)) {
                TeamDetails fieldValue = null;
                fieldValue = TeamDetails.Serializer.INSTANCE.deserialize(p, true);
                value = FedExtraDetails.team(fieldValue);
            }
            else {
                value = FedExtraDetails.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
