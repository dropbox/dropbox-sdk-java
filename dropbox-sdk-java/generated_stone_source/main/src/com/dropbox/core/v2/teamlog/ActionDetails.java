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
 * Additional information indicating the action taken that caused status change.
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
public final class ActionDetails {
    // union team_log.ActionDetails (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link ActionDetails}.
     */
    public enum Tag {
        /**
         * Define how the user was removed from the team.
         */
        REMOVE_ACTION, // MemberRemoveActionType
        /**
         * Additional information relevant when someone is invited to the team.
         */
        TEAM_INVITE_DETAILS, // TeamInviteDetails
        /**
         * Additional information relevant when a new member joins the team.
         */
        TEAM_JOIN_DETAILS, // JoinTeamDetails
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
    public static final ActionDetails OTHER = new ActionDetails().withTag(Tag.OTHER);

    private Tag _tag;
    private MemberRemoveActionType removeActionValue;
    private TeamInviteDetails teamInviteDetailsValue;
    private JoinTeamDetails teamJoinDetailsValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ActionDetails() {
    }


    /**
     * Additional information indicating the action taken that caused status
     * change.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ActionDetails withTag(Tag _tag) {
        ActionDetails result = new ActionDetails();
        result._tag = _tag;
        return result;
    }

    /**
     * Additional information indicating the action taken that caused status
     * change.
     *
     * @param removeActionValue  Define how the user was removed from the team.
     *     Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ActionDetails withTagAndRemoveAction(Tag _tag, MemberRemoveActionType removeActionValue) {
        ActionDetails result = new ActionDetails();
        result._tag = _tag;
        result.removeActionValue = removeActionValue;
        return result;
    }

    /**
     * Additional information indicating the action taken that caused status
     * change.
     *
     * @param teamInviteDetailsValue  Additional information relevant when
     *     someone is invited to the team. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ActionDetails withTagAndTeamInviteDetails(Tag _tag, TeamInviteDetails teamInviteDetailsValue) {
        ActionDetails result = new ActionDetails();
        result._tag = _tag;
        result.teamInviteDetailsValue = teamInviteDetailsValue;
        return result;
    }

    /**
     * Additional information indicating the action taken that caused status
     * change.
     *
     * @param teamJoinDetailsValue  Additional information relevant when a new
     *     member joins the team. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ActionDetails withTagAndTeamJoinDetails(Tag _tag, JoinTeamDetails teamJoinDetailsValue) {
        ActionDetails result = new ActionDetails();
        result._tag = _tag;
        result.teamJoinDetailsValue = teamJoinDetailsValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ActionDetails}. </p>
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
     * Tag#REMOVE_ACTION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#REMOVE_ACTION}, {@code false} otherwise.
     */
    public boolean isRemoveAction() {
        return this._tag == Tag.REMOVE_ACTION;
    }

    /**
     * Returns an instance of {@code ActionDetails} that has its tag set to
     * {@link Tag#REMOVE_ACTION}.
     *
     * <p> Define how the user was removed from the team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ActionDetails} with its tag set to {@link
     *     Tag#REMOVE_ACTION}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ActionDetails removeAction(MemberRemoveActionType value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActionDetails().withTagAndRemoveAction(Tag.REMOVE_ACTION, value);
    }

    /**
     * Define how the user was removed from the team.
     *
     * <p> This instance must be tagged as {@link Tag#REMOVE_ACTION}. </p>
     *
     * @return The {@link MemberRemoveActionType} value associated with this
     *     instance if {@link #isRemoveAction} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isRemoveAction} is {@code
     *     false}.
     */
    public MemberRemoveActionType getRemoveActionValue() {
        if (this._tag != Tag.REMOVE_ACTION) {
            throw new IllegalStateException("Invalid tag: required Tag.REMOVE_ACTION, but was Tag." + this._tag.name());
        }
        return removeActionValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_INVITE_DETAILS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_INVITE_DETAILS}, {@code false} otherwise.
     */
    public boolean isTeamInviteDetails() {
        return this._tag == Tag.TEAM_INVITE_DETAILS;
    }

    /**
     * Returns an instance of {@code ActionDetails} that has its tag set to
     * {@link Tag#TEAM_INVITE_DETAILS}.
     *
     * <p> Additional information relevant when someone is invited to the team.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ActionDetails} with its tag set to {@link
     *     Tag#TEAM_INVITE_DETAILS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ActionDetails teamInviteDetails(TeamInviteDetails value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActionDetails().withTagAndTeamInviteDetails(Tag.TEAM_INVITE_DETAILS, value);
    }

    /**
     * Additional information relevant when someone is invited to the team.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM_INVITE_DETAILS}. </p>
     *
     * @return The {@link TeamInviteDetails} value associated with this instance
     *     if {@link #isTeamInviteDetails} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamInviteDetails} is {@code
     *     false}.
     */
    public TeamInviteDetails getTeamInviteDetailsValue() {
        if (this._tag != Tag.TEAM_INVITE_DETAILS) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_INVITE_DETAILS, but was Tag." + this._tag.name());
        }
        return teamInviteDetailsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_JOIN_DETAILS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_JOIN_DETAILS}, {@code false} otherwise.
     */
    public boolean isTeamJoinDetails() {
        return this._tag == Tag.TEAM_JOIN_DETAILS;
    }

    /**
     * Returns an instance of {@code ActionDetails} that has its tag set to
     * {@link Tag#TEAM_JOIN_DETAILS}.
     *
     * <p> Additional information relevant when a new member joins the team.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ActionDetails} with its tag set to {@link
     *     Tag#TEAM_JOIN_DETAILS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ActionDetails teamJoinDetails(JoinTeamDetails value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActionDetails().withTagAndTeamJoinDetails(Tag.TEAM_JOIN_DETAILS, value);
    }

    /**
     * Additional information relevant when a new member joins the team.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM_JOIN_DETAILS}. </p>
     *
     * @return The {@link JoinTeamDetails} value associated with this instance
     *     if {@link #isTeamJoinDetails} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamJoinDetails} is {@code
     *     false}.
     */
    public JoinTeamDetails getTeamJoinDetailsValue() {
        if (this._tag != Tag.TEAM_JOIN_DETAILS) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_JOIN_DETAILS, but was Tag." + this._tag.name());
        }
        return teamJoinDetailsValue;
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
            removeActionValue,
            teamInviteDetailsValue,
            teamJoinDetailsValue
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
        else if (obj instanceof ActionDetails) {
            ActionDetails other = (ActionDetails) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case REMOVE_ACTION:
                    return (this.removeActionValue == other.removeActionValue) || (this.removeActionValue.equals(other.removeActionValue));
                case TEAM_INVITE_DETAILS:
                    return (this.teamInviteDetailsValue == other.teamInviteDetailsValue) || (this.teamInviteDetailsValue.equals(other.teamInviteDetailsValue));
                case TEAM_JOIN_DETAILS:
                    return (this.teamJoinDetailsValue == other.teamJoinDetailsValue) || (this.teamJoinDetailsValue.equals(other.teamJoinDetailsValue));
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
    static class Serializer extends UnionSerializer<ActionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ActionDetails value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case REMOVE_ACTION: {
                    g.writeStartObject();
                    writeTag("remove_action", g);
                    g.writeFieldName("remove_action");
                    MemberRemoveActionType.Serializer.INSTANCE.serialize(value.removeActionValue, g);
                    g.writeEndObject();
                    break;
                }
                case TEAM_INVITE_DETAILS: {
                    g.writeStartObject();
                    writeTag("team_invite_details", g);
                    TeamInviteDetails.Serializer.INSTANCE.serialize(value.teamInviteDetailsValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case TEAM_JOIN_DETAILS: {
                    g.writeStartObject();
                    writeTag("team_join_details", g);
                    JoinTeamDetails.Serializer.INSTANCE.serialize(value.teamJoinDetailsValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ActionDetails deserialize(JsonParser p) throws IOException, JsonParseException {
            ActionDetails value;
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
            else if ("remove_action".equals(tag)) {
                MemberRemoveActionType fieldValue = null;
                expectField("remove_action", p);
                fieldValue = MemberRemoveActionType.Serializer.INSTANCE.deserialize(p);
                value = ActionDetails.removeAction(fieldValue);
            }
            else if ("team_invite_details".equals(tag)) {
                TeamInviteDetails fieldValue = null;
                fieldValue = TeamInviteDetails.Serializer.INSTANCE.deserialize(p, true);
                value = ActionDetails.teamInviteDetails(fieldValue);
            }
            else if ("team_join_details".equals(tag)) {
                JoinTeamDetails fieldValue = null;
                fieldValue = JoinTeamDetails.Serializer.INSTANCE.deserialize(p, true);
                value = ActionDetails.teamJoinDetails(fieldValue);
            }
            else {
                value = ActionDetails.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
