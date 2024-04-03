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
 * The user's status as a member of a specific team.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class TeamMemberStatus {
    // union team.TeamMemberStatus (team.stone)

    /**
     * Discriminating tag type for {@link TeamMemberStatus}.
     */
    public enum Tag {
        /**
         * User has successfully joined the team.
         */
        ACTIVE,
        /**
         * User has been invited to a team, but has not joined the team yet.
         */
        INVITED,
        /**
         * User is no longer a member of the team, but the account can be
         * un-suspended, re-establishing the user as a team member.
         */
        SUSPENDED,
        /**
         * User is no longer a member of the team. Removed users are only listed
         * when include_removed is true in members/list.
         */
        REMOVED; // RemovedStatus
    }

    /**
     * User has successfully joined the team.
     */
    public static final TeamMemberStatus ACTIVE = new TeamMemberStatus().withTag(Tag.ACTIVE);
    /**
     * User has been invited to a team, but has not joined the team yet.
     */
    public static final TeamMemberStatus INVITED = new TeamMemberStatus().withTag(Tag.INVITED);
    /**
     * User is no longer a member of the team, but the account can be
     * un-suspended, re-establishing the user as a team member.
     */
    public static final TeamMemberStatus SUSPENDED = new TeamMemberStatus().withTag(Tag.SUSPENDED);

    private Tag _tag;
    private RemovedStatus removedValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private TeamMemberStatus() {
    }


    /**
     * The user's status as a member of a specific team.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private TeamMemberStatus withTag(Tag _tag) {
        TeamMemberStatus result = new TeamMemberStatus();
        result._tag = _tag;
        return result;
    }

    /**
     * The user's status as a member of a specific team.
     *
     * @param removedValue  User is no longer a member of the team. Removed
     *     users are only listed when include_removed is true in members/list.
     *     Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamMemberStatus withTagAndRemoved(Tag _tag, RemovedStatus removedValue) {
        TeamMemberStatus result = new TeamMemberStatus();
        result._tag = _tag;
        result.removedValue = removedValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TeamMemberStatus}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#ACTIVE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ACTIVE},
     *     {@code false} otherwise.
     */
    public boolean isActive() {
        return this._tag == Tag.ACTIVE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#INVITED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#INVITED},
     *     {@code false} otherwise.
     */
    public boolean isInvited() {
        return this._tag == Tag.INVITED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#SUSPENDED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#SUSPENDED},
     *     {@code false} otherwise.
     */
    public boolean isSuspended() {
        return this._tag == Tag.SUSPENDED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#REMOVED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#REMOVED},
     *     {@code false} otherwise.
     */
    public boolean isRemoved() {
        return this._tag == Tag.REMOVED;
    }

    /**
     * Returns an instance of {@code TeamMemberStatus} that has its tag set to
     * {@link Tag#REMOVED}.
     *
     * <p> User is no longer a member of the team. Removed users are only listed
     * when include_removed is true in members/list. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamMemberStatus} with its tag set to {@link
     *     Tag#REMOVED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamMemberStatus removed(RemovedStatus value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMemberStatus().withTagAndRemoved(Tag.REMOVED, value);
    }

    /**
     * User is no longer a member of the team. Removed users are only listed
     * when include_removed is true in members/list.
     *
     * <p> This instance must be tagged as {@link Tag#REMOVED}. </p>
     *
     * @return The {@link RemovedStatus} value associated with this instance if
     *     {@link #isRemoved} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isRemoved} is {@code false}.
     */
    public RemovedStatus getRemovedValue() {
        if (this._tag != Tag.REMOVED) {
            throw new IllegalStateException("Invalid tag: required Tag.REMOVED, but was Tag." + this._tag.name());
        }
        return removedValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.removedValue
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
        else if (obj instanceof TeamMemberStatus) {
            TeamMemberStatus other = (TeamMemberStatus) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ACTIVE:
                    return true;
                case INVITED:
                    return true;
                case SUSPENDED:
                    return true;
                case REMOVED:
                    return (this.removedValue == other.removedValue) || (this.removedValue.equals(other.removedValue));
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
    static class Serializer extends UnionSerializer<TeamMemberStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACTIVE: {
                    g.writeString("active");
                    break;
                }
                case INVITED: {
                    g.writeString("invited");
                    break;
                }
                case SUSPENDED: {
                    g.writeString("suspended");
                    break;
                }
                case REMOVED: {
                    g.writeStartObject();
                    writeTag("removed", g);
                    RemovedStatus.Serializer.INSTANCE.serialize(value.removedValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public TeamMemberStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamMemberStatus value;
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
            else if ("active".equals(tag)) {
                value = TeamMemberStatus.ACTIVE;
            }
            else if ("invited".equals(tag)) {
                value = TeamMemberStatus.INVITED;
            }
            else if ("suspended".equals(tag)) {
                value = TeamMemberStatus.SUSPENDED;
            }
            else if ("removed".equals(tag)) {
                RemovedStatus fieldValue = null;
                fieldValue = RemovedStatus.Serializer.INSTANCE.deserialize(p, true);
                value = TeamMemberStatus.removed(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
