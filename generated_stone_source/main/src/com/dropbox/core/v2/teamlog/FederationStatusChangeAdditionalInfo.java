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
 * Additional information about the organization or connected team
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
public final class FederationStatusChangeAdditionalInfo {
    // union team_log.FederationStatusChangeAdditionalInfo (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link FederationStatusChangeAdditionalInfo}.
     */
    public enum Tag {
        /**
         * The name of the team.
         */
        CONNECTED_TEAM_NAME, // ConnectedTeamName
        /**
         * The email to which the request was sent.
         */
        NON_TRUSTED_TEAM_DETAILS, // NonTrustedTeamDetails
        /**
         * The name of the organization.
         */
        ORGANIZATION_NAME, // OrganizationName
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
    public static final FederationStatusChangeAdditionalInfo OTHER = new FederationStatusChangeAdditionalInfo().withTag(Tag.OTHER);

    private Tag _tag;
    private ConnectedTeamName connectedTeamNameValue;
    private NonTrustedTeamDetails nonTrustedTeamDetailsValue;
    private OrganizationName organizationNameValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private FederationStatusChangeAdditionalInfo() {
    }


    /**
     * Additional information about the organization or connected team
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private FederationStatusChangeAdditionalInfo withTag(Tag _tag) {
        FederationStatusChangeAdditionalInfo result = new FederationStatusChangeAdditionalInfo();
        result._tag = _tag;
        return result;
    }

    /**
     * Additional information about the organization or connected team
     *
     * @param connectedTeamNameValue  The name of the team. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FederationStatusChangeAdditionalInfo withTagAndConnectedTeamName(Tag _tag, ConnectedTeamName connectedTeamNameValue) {
        FederationStatusChangeAdditionalInfo result = new FederationStatusChangeAdditionalInfo();
        result._tag = _tag;
        result.connectedTeamNameValue = connectedTeamNameValue;
        return result;
    }

    /**
     * Additional information about the organization or connected team
     *
     * @param nonTrustedTeamDetailsValue  The email to which the request was
     *     sent. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FederationStatusChangeAdditionalInfo withTagAndNonTrustedTeamDetails(Tag _tag, NonTrustedTeamDetails nonTrustedTeamDetailsValue) {
        FederationStatusChangeAdditionalInfo result = new FederationStatusChangeAdditionalInfo();
        result._tag = _tag;
        result.nonTrustedTeamDetailsValue = nonTrustedTeamDetailsValue;
        return result;
    }

    /**
     * Additional information about the organization or connected team
     *
     * @param organizationNameValue  The name of the organization. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FederationStatusChangeAdditionalInfo withTagAndOrganizationName(Tag _tag, OrganizationName organizationNameValue) {
        FederationStatusChangeAdditionalInfo result = new FederationStatusChangeAdditionalInfo();
        result._tag = _tag;
        result.organizationNameValue = organizationNameValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code FederationStatusChangeAdditionalInfo}. </p>
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
     * Tag#CONNECTED_TEAM_NAME}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONNECTED_TEAM_NAME}, {@code false} otherwise.
     */
    public boolean isConnectedTeamName() {
        return this._tag == Tag.CONNECTED_TEAM_NAME;
    }

    /**
     * Returns an instance of {@code FederationStatusChangeAdditionalInfo} that
     * has its tag set to {@link Tag#CONNECTED_TEAM_NAME}.
     *
     * <p> The name of the team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FederationStatusChangeAdditionalInfo} with its
     *     tag set to {@link Tag#CONNECTED_TEAM_NAME}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FederationStatusChangeAdditionalInfo connectedTeamName(ConnectedTeamName value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FederationStatusChangeAdditionalInfo().withTagAndConnectedTeamName(Tag.CONNECTED_TEAM_NAME, value);
    }

    /**
     * The name of the team.
     *
     * <p> This instance must be tagged as {@link Tag#CONNECTED_TEAM_NAME}. </p>
     *
     * @return The {@link ConnectedTeamName} value associated with this instance
     *     if {@link #isConnectedTeamName} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isConnectedTeamName} is {@code
     *     false}.
     */
    public ConnectedTeamName getConnectedTeamNameValue() {
        if (this._tag != Tag.CONNECTED_TEAM_NAME) {
            throw new IllegalStateException("Invalid tag: required Tag.CONNECTED_TEAM_NAME, but was Tag." + this._tag.name());
        }
        return connectedTeamNameValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NON_TRUSTED_TEAM_DETAILS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NON_TRUSTED_TEAM_DETAILS}, {@code false} otherwise.
     */
    public boolean isNonTrustedTeamDetails() {
        return this._tag == Tag.NON_TRUSTED_TEAM_DETAILS;
    }

    /**
     * Returns an instance of {@code FederationStatusChangeAdditionalInfo} that
     * has its tag set to {@link Tag#NON_TRUSTED_TEAM_DETAILS}.
     *
     * <p> The email to which the request was sent. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FederationStatusChangeAdditionalInfo} with its
     *     tag set to {@link Tag#NON_TRUSTED_TEAM_DETAILS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FederationStatusChangeAdditionalInfo nonTrustedTeamDetails(NonTrustedTeamDetails value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FederationStatusChangeAdditionalInfo().withTagAndNonTrustedTeamDetails(Tag.NON_TRUSTED_TEAM_DETAILS, value);
    }

    /**
     * The email to which the request was sent.
     *
     * <p> This instance must be tagged as {@link Tag#NON_TRUSTED_TEAM_DETAILS}.
     * </p>
     *
     * @return The {@link NonTrustedTeamDetails} value associated with this
     *     instance if {@link #isNonTrustedTeamDetails} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isNonTrustedTeamDetails} is
     *     {@code false}.
     */
    public NonTrustedTeamDetails getNonTrustedTeamDetailsValue() {
        if (this._tag != Tag.NON_TRUSTED_TEAM_DETAILS) {
            throw new IllegalStateException("Invalid tag: required Tag.NON_TRUSTED_TEAM_DETAILS, but was Tag." + this._tag.name());
        }
        return nonTrustedTeamDetailsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ORGANIZATION_NAME}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ORGANIZATION_NAME}, {@code false} otherwise.
     */
    public boolean isOrganizationName() {
        return this._tag == Tag.ORGANIZATION_NAME;
    }

    /**
     * Returns an instance of {@code FederationStatusChangeAdditionalInfo} that
     * has its tag set to {@link Tag#ORGANIZATION_NAME}.
     *
     * <p> The name of the organization. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FederationStatusChangeAdditionalInfo} with its
     *     tag set to {@link Tag#ORGANIZATION_NAME}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FederationStatusChangeAdditionalInfo organizationName(OrganizationName value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FederationStatusChangeAdditionalInfo().withTagAndOrganizationName(Tag.ORGANIZATION_NAME, value);
    }

    /**
     * The name of the organization.
     *
     * <p> This instance must be tagged as {@link Tag#ORGANIZATION_NAME}. </p>
     *
     * @return The {@link OrganizationName} value associated with this instance
     *     if {@link #isOrganizationName} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isOrganizationName} is {@code
     *     false}.
     */
    public OrganizationName getOrganizationNameValue() {
        if (this._tag != Tag.ORGANIZATION_NAME) {
            throw new IllegalStateException("Invalid tag: required Tag.ORGANIZATION_NAME, but was Tag." + this._tag.name());
        }
        return organizationNameValue;
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
            connectedTeamNameValue,
            nonTrustedTeamDetailsValue,
            organizationNameValue
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
        else if (obj instanceof FederationStatusChangeAdditionalInfo) {
            FederationStatusChangeAdditionalInfo other = (FederationStatusChangeAdditionalInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case CONNECTED_TEAM_NAME:
                    return (this.connectedTeamNameValue == other.connectedTeamNameValue) || (this.connectedTeamNameValue.equals(other.connectedTeamNameValue));
                case NON_TRUSTED_TEAM_DETAILS:
                    return (this.nonTrustedTeamDetailsValue == other.nonTrustedTeamDetailsValue) || (this.nonTrustedTeamDetailsValue.equals(other.nonTrustedTeamDetailsValue));
                case ORGANIZATION_NAME:
                    return (this.organizationNameValue == other.organizationNameValue) || (this.organizationNameValue.equals(other.organizationNameValue));
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
    static class Serializer extends UnionSerializer<FederationStatusChangeAdditionalInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FederationStatusChangeAdditionalInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case CONNECTED_TEAM_NAME: {
                    g.writeStartObject();
                    writeTag("connected_team_name", g);
                    ConnectedTeamName.Serializer.INSTANCE.serialize(value.connectedTeamNameValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case NON_TRUSTED_TEAM_DETAILS: {
                    g.writeStartObject();
                    writeTag("non_trusted_team_details", g);
                    NonTrustedTeamDetails.Serializer.INSTANCE.serialize(value.nonTrustedTeamDetailsValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case ORGANIZATION_NAME: {
                    g.writeStartObject();
                    writeTag("organization_name", g);
                    OrganizationName.Serializer.INSTANCE.serialize(value.organizationNameValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FederationStatusChangeAdditionalInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            FederationStatusChangeAdditionalInfo value;
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
            else if ("connected_team_name".equals(tag)) {
                ConnectedTeamName fieldValue = null;
                fieldValue = ConnectedTeamName.Serializer.INSTANCE.deserialize(p, true);
                value = FederationStatusChangeAdditionalInfo.connectedTeamName(fieldValue);
            }
            else if ("non_trusted_team_details".equals(tag)) {
                NonTrustedTeamDetails fieldValue = null;
                fieldValue = NonTrustedTeamDetails.Serializer.INSTANCE.deserialize(p, true);
                value = FederationStatusChangeAdditionalInfo.nonTrustedTeamDetails(fieldValue);
            }
            else if ("organization_name".equals(tag)) {
                OrganizationName fieldValue = null;
                fieldValue = OrganizationName.Serializer.INSTANCE.deserialize(p, true);
                value = FederationStatusChangeAdditionalInfo.organizationName(fieldValue);
            }
            else {
                value = FederationStatusChangeAdditionalInfo.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
