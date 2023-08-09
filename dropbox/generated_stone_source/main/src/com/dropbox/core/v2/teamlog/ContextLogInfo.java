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
 * The primary entity on which the action was done.
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
public final class ContextLogInfo {
    // union team_log.ContextLogInfo (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link ContextLogInfo}.
     */
    public enum Tag {
        /**
         * Anonymous context.
         */
        ANONYMOUS,
        /**
         * Action was done on behalf of a non team member.
         */
        NON_TEAM_MEMBER, // NonTeamMemberLogInfo
        /**
         * Action was done on behalf of a team that's part of an organization.
         */
        ORGANIZATION_TEAM, // TeamLogInfo
        /**
         * Action was done on behalf of the team.
         */
        TEAM,
        /**
         * Action was done on behalf of a team member.
         */
        TEAM_MEMBER, // TeamMemberLogInfo
        /**
         * Action was done on behalf of a trusted non team member.
         */
        TRUSTED_NON_TEAM_MEMBER, // TrustedNonTeamMemberLogInfo
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
     * Anonymous context.
     */
    public static final ContextLogInfo ANONYMOUS = new ContextLogInfo().withTag(Tag.ANONYMOUS);
    /**
     * Action was done on behalf of the team.
     */
    public static final ContextLogInfo TEAM = new ContextLogInfo().withTag(Tag.TEAM);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ContextLogInfo OTHER = new ContextLogInfo().withTag(Tag.OTHER);

    private Tag _tag;
    private NonTeamMemberLogInfo nonTeamMemberValue;
    private TeamLogInfo organizationTeamValue;
    private TeamMemberLogInfo teamMemberValue;
    private TrustedNonTeamMemberLogInfo trustedNonTeamMemberValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ContextLogInfo() {
    }


    /**
     * The primary entity on which the action was done.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ContextLogInfo withTag(Tag _tag) {
        ContextLogInfo result = new ContextLogInfo();
        result._tag = _tag;
        return result;
    }

    /**
     * The primary entity on which the action was done.
     *
     * @param nonTeamMemberValue  Action was done on behalf of a non team
     *     member. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ContextLogInfo withTagAndNonTeamMember(Tag _tag, NonTeamMemberLogInfo nonTeamMemberValue) {
        ContextLogInfo result = new ContextLogInfo();
        result._tag = _tag;
        result.nonTeamMemberValue = nonTeamMemberValue;
        return result;
    }

    /**
     * The primary entity on which the action was done.
     *
     * @param organizationTeamValue  Action was done on behalf of a team that's
     *     part of an organization. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ContextLogInfo withTagAndOrganizationTeam(Tag _tag, TeamLogInfo organizationTeamValue) {
        ContextLogInfo result = new ContextLogInfo();
        result._tag = _tag;
        result.organizationTeamValue = organizationTeamValue;
        return result;
    }

    /**
     * The primary entity on which the action was done.
     *
     * @param teamMemberValue  Action was done on behalf of a team member. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ContextLogInfo withTagAndTeamMember(Tag _tag, TeamMemberLogInfo teamMemberValue) {
        ContextLogInfo result = new ContextLogInfo();
        result._tag = _tag;
        result.teamMemberValue = teamMemberValue;
        return result;
    }

    /**
     * The primary entity on which the action was done.
     *
     * @param trustedNonTeamMemberValue  Action was done on behalf of a trusted
     *     non team member. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ContextLogInfo withTagAndTrustedNonTeamMember(Tag _tag, TrustedNonTeamMemberLogInfo trustedNonTeamMemberValue) {
        ContextLogInfo result = new ContextLogInfo();
        result._tag = _tag;
        result.trustedNonTeamMemberValue = trustedNonTeamMemberValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ContextLogInfo}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#ANONYMOUS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ANONYMOUS},
     *     {@code false} otherwise.
     */
    public boolean isAnonymous() {
        return this._tag == Tag.ANONYMOUS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NON_TEAM_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NON_TEAM_MEMBER}, {@code false} otherwise.
     */
    public boolean isNonTeamMember() {
        return this._tag == Tag.NON_TEAM_MEMBER;
    }

    /**
     * Returns an instance of {@code ContextLogInfo} that has its tag set to
     * {@link Tag#NON_TEAM_MEMBER}.
     *
     * <p> Action was done on behalf of a non team member. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ContextLogInfo} with its tag set to {@link
     *     Tag#NON_TEAM_MEMBER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ContextLogInfo nonTeamMember(NonTeamMemberLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndNonTeamMember(Tag.NON_TEAM_MEMBER, value);
    }

    /**
     * Action was done on behalf of a non team member.
     *
     * <p> This instance must be tagged as {@link Tag#NON_TEAM_MEMBER}. </p>
     *
     * @return The {@link NonTeamMemberLogInfo} value associated with this
     *     instance if {@link #isNonTeamMember} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isNonTeamMember} is {@code
     *     false}.
     */
    public NonTeamMemberLogInfo getNonTeamMemberValue() {
        if (this._tag != Tag.NON_TEAM_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.NON_TEAM_MEMBER, but was Tag." + this._tag.name());
        }
        return nonTeamMemberValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ORGANIZATION_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ORGANIZATION_TEAM}, {@code false} otherwise.
     */
    public boolean isOrganizationTeam() {
        return this._tag == Tag.ORGANIZATION_TEAM;
    }

    /**
     * Returns an instance of {@code ContextLogInfo} that has its tag set to
     * {@link Tag#ORGANIZATION_TEAM}.
     *
     * <p> Action was done on behalf of a team that's part of an organization.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ContextLogInfo} with its tag set to {@link
     *     Tag#ORGANIZATION_TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ContextLogInfo organizationTeam(TeamLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndOrganizationTeam(Tag.ORGANIZATION_TEAM, value);
    }

    /**
     * Action was done on behalf of a team that's part of an organization.
     *
     * <p> This instance must be tagged as {@link Tag#ORGANIZATION_TEAM}. </p>
     *
     * @return The {@link TeamLogInfo} value associated with this instance if
     *     {@link #isOrganizationTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isOrganizationTeam} is {@code
     *     false}.
     */
    public TeamLogInfo getOrganizationTeamValue() {
        if (this._tag != Tag.ORGANIZATION_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.ORGANIZATION_TEAM, but was Tag." + this._tag.name());
        }
        return organizationTeamValue;
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_MEMBER}, {@code false} otherwise.
     */
    public boolean isTeamMember() {
        return this._tag == Tag.TEAM_MEMBER;
    }

    /**
     * Returns an instance of {@code ContextLogInfo} that has its tag set to
     * {@link Tag#TEAM_MEMBER}.
     *
     * <p> Action was done on behalf of a team member. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ContextLogInfo} with its tag set to {@link
     *     Tag#TEAM_MEMBER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ContextLogInfo teamMember(TeamMemberLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndTeamMember(Tag.TEAM_MEMBER, value);
    }

    /**
     * Action was done on behalf of a team member.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM_MEMBER}. </p>
     *
     * @return The {@link TeamMemberLogInfo} value associated with this instance
     *     if {@link #isTeamMember} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamMember} is {@code false}.
     */
    public TeamMemberLogInfo getTeamMemberValue() {
        if (this._tag != Tag.TEAM_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_MEMBER, but was Tag." + this._tag.name());
        }
        return teamMemberValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TRUSTED_NON_TEAM_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TRUSTED_NON_TEAM_MEMBER}, {@code false} otherwise.
     */
    public boolean isTrustedNonTeamMember() {
        return this._tag == Tag.TRUSTED_NON_TEAM_MEMBER;
    }

    /**
     * Returns an instance of {@code ContextLogInfo} that has its tag set to
     * {@link Tag#TRUSTED_NON_TEAM_MEMBER}.
     *
     * <p> Action was done on behalf of a trusted non team member. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ContextLogInfo} with its tag set to {@link
     *     Tag#TRUSTED_NON_TEAM_MEMBER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ContextLogInfo trustedNonTeamMember(TrustedNonTeamMemberLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndTrustedNonTeamMember(Tag.TRUSTED_NON_TEAM_MEMBER, value);
    }

    /**
     * Action was done on behalf of a trusted non team member.
     *
     * <p> This instance must be tagged as {@link Tag#TRUSTED_NON_TEAM_MEMBER}.
     * </p>
     *
     * @return The {@link TrustedNonTeamMemberLogInfo} value associated with
     *     this instance if {@link #isTrustedNonTeamMember} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTrustedNonTeamMember} is
     *     {@code false}.
     */
    public TrustedNonTeamMemberLogInfo getTrustedNonTeamMemberValue() {
        if (this._tag != Tag.TRUSTED_NON_TEAM_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.TRUSTED_NON_TEAM_MEMBER, but was Tag." + this._tag.name());
        }
        return trustedNonTeamMemberValue;
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
            nonTeamMemberValue,
            organizationTeamValue,
            teamMemberValue,
            trustedNonTeamMemberValue
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
        else if (obj instanceof ContextLogInfo) {
            ContextLogInfo other = (ContextLogInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ANONYMOUS:
                    return true;
                case NON_TEAM_MEMBER:
                    return (this.nonTeamMemberValue == other.nonTeamMemberValue) || (this.nonTeamMemberValue.equals(other.nonTeamMemberValue));
                case ORGANIZATION_TEAM:
                    return (this.organizationTeamValue == other.organizationTeamValue) || (this.organizationTeamValue.equals(other.organizationTeamValue));
                case TEAM:
                    return true;
                case TEAM_MEMBER:
                    return (this.teamMemberValue == other.teamMemberValue) || (this.teamMemberValue.equals(other.teamMemberValue));
                case TRUSTED_NON_TEAM_MEMBER:
                    return (this.trustedNonTeamMemberValue == other.trustedNonTeamMemberValue) || (this.trustedNonTeamMemberValue.equals(other.trustedNonTeamMemberValue));
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
    static class Serializer extends UnionSerializer<ContextLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ContextLogInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ANONYMOUS: {
                    g.writeString("anonymous");
                    break;
                }
                case NON_TEAM_MEMBER: {
                    g.writeStartObject();
                    writeTag("non_team_member", g);
                    NonTeamMemberLogInfo.Serializer.INSTANCE.serialize(value.nonTeamMemberValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case ORGANIZATION_TEAM: {
                    g.writeStartObject();
                    writeTag("organization_team", g);
                    TeamLogInfo.Serializer.INSTANCE.serialize(value.organizationTeamValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case TEAM: {
                    g.writeString("team");
                    break;
                }
                case TEAM_MEMBER: {
                    g.writeStartObject();
                    writeTag("team_member", g);
                    TeamMemberLogInfo.Serializer.INSTANCE.serialize(value.teamMemberValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case TRUSTED_NON_TEAM_MEMBER: {
                    g.writeStartObject();
                    writeTag("trusted_non_team_member", g);
                    TrustedNonTeamMemberLogInfo.Serializer.INSTANCE.serialize(value.trustedNonTeamMemberValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ContextLogInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            ContextLogInfo value;
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
            else if ("anonymous".equals(tag)) {
                value = ContextLogInfo.ANONYMOUS;
            }
            else if ("non_team_member".equals(tag)) {
                NonTeamMemberLogInfo fieldValue = null;
                fieldValue = NonTeamMemberLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = ContextLogInfo.nonTeamMember(fieldValue);
            }
            else if ("organization_team".equals(tag)) {
                TeamLogInfo fieldValue = null;
                fieldValue = TeamLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = ContextLogInfo.organizationTeam(fieldValue);
            }
            else if ("team".equals(tag)) {
                value = ContextLogInfo.TEAM;
            }
            else if ("team_member".equals(tag)) {
                TeamMemberLogInfo fieldValue = null;
                fieldValue = TeamMemberLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = ContextLogInfo.teamMember(fieldValue);
            }
            else if ("trusted_non_team_member".equals(tag)) {
                TrustedNonTeamMemberLogInfo fieldValue = null;
                fieldValue = TrustedNonTeamMemberLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = ContextLogInfo.trustedNonTeamMember(fieldValue);
            }
            else {
                value = ContextLogInfo.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
