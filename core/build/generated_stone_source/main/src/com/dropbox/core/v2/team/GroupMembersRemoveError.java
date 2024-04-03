/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

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
import java.util.List;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class GroupMembersRemoveError {
    // union team.GroupMembersRemoveError (team_groups.stone)

    /**
     * Discriminating tag type for {@link GroupMembersRemoveError}.
     */
    public enum Tag {
        /**
         * No matching group found. No groups match the specified group ID.
         */
        GROUP_NOT_FOUND,
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER,
        /**
         * This operation is not supported on system-managed groups.
         */
        SYSTEM_MANAGED_GROUP_DISALLOWED,
        /**
         * At least one of the specified users is not a member of the group.
         */
        MEMBER_NOT_IN_GROUP,
        /**
         * Group is not in this team. You cannot remove members from a group
         * that is outside of your team.
         */
        GROUP_NOT_IN_TEAM,
        /**
         * These members are not part of your team.
         */
        MEMBERS_NOT_IN_TEAM, // List<String>
        /**
         * These users were not found in Dropbox.
         */
        USERS_NOT_FOUND; // List<String>
    }

    /**
     * No matching group found. No groups match the specified group ID.
     */
    public static final GroupMembersRemoveError GROUP_NOT_FOUND = new GroupMembersRemoveError().withTag(Tag.GROUP_NOT_FOUND);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final GroupMembersRemoveError OTHER = new GroupMembersRemoveError().withTag(Tag.OTHER);
    /**
     * This operation is not supported on system-managed groups.
     */
    public static final GroupMembersRemoveError SYSTEM_MANAGED_GROUP_DISALLOWED = new GroupMembersRemoveError().withTag(Tag.SYSTEM_MANAGED_GROUP_DISALLOWED);
    /**
     * At least one of the specified users is not a member of the group.
     */
    public static final GroupMembersRemoveError MEMBER_NOT_IN_GROUP = new GroupMembersRemoveError().withTag(Tag.MEMBER_NOT_IN_GROUP);
    /**
     * Group is not in this team. You cannot remove members from a group that is
     * outside of your team.
     */
    public static final GroupMembersRemoveError GROUP_NOT_IN_TEAM = new GroupMembersRemoveError().withTag(Tag.GROUP_NOT_IN_TEAM);

    private Tag _tag;
    private List<String> membersNotInTeamValue;
    private List<String> usersNotFoundValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private GroupMembersRemoveError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private GroupMembersRemoveError withTag(Tag _tag) {
        GroupMembersRemoveError result = new GroupMembersRemoveError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param membersNotInTeamValue  These members are not part of your team.
     *     Must not contain a {@code null} item and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupMembersRemoveError withTagAndMembersNotInTeam(Tag _tag, List<String> membersNotInTeamValue) {
        GroupMembersRemoveError result = new GroupMembersRemoveError();
        result._tag = _tag;
        result.membersNotInTeamValue = membersNotInTeamValue;
        return result;
    }

    /**
     *
     * @param usersNotFoundValue  These users were not found in Dropbox. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupMembersRemoveError withTagAndUsersNotFound(Tag _tag, List<String> usersNotFoundValue) {
        GroupMembersRemoveError result = new GroupMembersRemoveError();
        result._tag = _tag;
        result.usersNotFoundValue = usersNotFoundValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GroupMembersRemoveError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isGroupNotFound() {
        return this._tag == Tag.GROUP_NOT_FOUND;
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

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SYSTEM_MANAGED_GROUP_DISALLOWED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SYSTEM_MANAGED_GROUP_DISALLOWED}, {@code false} otherwise.
     */
    public boolean isSystemManagedGroupDisallowed() {
        return this._tag == Tag.SYSTEM_MANAGED_GROUP_DISALLOWED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MEMBER_NOT_IN_GROUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MEMBER_NOT_IN_GROUP}, {@code false} otherwise.
     */
    public boolean isMemberNotInGroup() {
        return this._tag == Tag.MEMBER_NOT_IN_GROUP;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_NOT_IN_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_NOT_IN_TEAM}, {@code false} otherwise.
     */
    public boolean isGroupNotInTeam() {
        return this._tag == Tag.GROUP_NOT_IN_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MEMBERS_NOT_IN_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MEMBERS_NOT_IN_TEAM}, {@code false} otherwise.
     */
    public boolean isMembersNotInTeam() {
        return this._tag == Tag.MEMBERS_NOT_IN_TEAM;
    }

    /**
     * Returns an instance of {@code GroupMembersRemoveError} that has its tag
     * set to {@link Tag#MEMBERS_NOT_IN_TEAM}.
     *
     * <p> These members are not part of your team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupMembersRemoveError} with its tag set to
     *     {@link Tag#MEMBERS_NOT_IN_TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static GroupMembersRemoveError membersNotInTeam(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersRemoveError().withTagAndMembersNotInTeam(Tag.MEMBERS_NOT_IN_TEAM, value);
    }

    /**
     * These members are not part of your team.
     *
     * <p> This instance must be tagged as {@link Tag#MEMBERS_NOT_IN_TEAM}. </p>
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isMembersNotInTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMembersNotInTeam} is {@code
     *     false}.
     */
    public List<String> getMembersNotInTeamValue() {
        if (this._tag != Tag.MEMBERS_NOT_IN_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBERS_NOT_IN_TEAM, but was Tag." + this._tag.name());
        }
        return membersNotInTeamValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USERS_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USERS_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isUsersNotFound() {
        return this._tag == Tag.USERS_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code GroupMembersRemoveError} that has its tag
     * set to {@link Tag#USERS_NOT_FOUND}.
     *
     * <p> These users were not found in Dropbox. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupMembersRemoveError} with its tag set to
     *     {@link Tag#USERS_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static GroupMembersRemoveError usersNotFound(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersRemoveError().withTagAndUsersNotFound(Tag.USERS_NOT_FOUND, value);
    }

    /**
     * These users were not found in Dropbox.
     *
     * <p> This instance must be tagged as {@link Tag#USERS_NOT_FOUND}. </p>
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isUsersNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUsersNotFound} is {@code
     *     false}.
     */
    public List<String> getUsersNotFoundValue() {
        if (this._tag != Tag.USERS_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.USERS_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return usersNotFoundValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.membersNotInTeamValue,
            this.usersNotFoundValue
        });
        hash = (31 * super.hashCode()) + hash;
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
        else if (obj instanceof GroupMembersRemoveError) {
            GroupMembersRemoveError other = (GroupMembersRemoveError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case GROUP_NOT_FOUND:
                    return true;
                case OTHER:
                    return true;
                case SYSTEM_MANAGED_GROUP_DISALLOWED:
                    return true;
                case MEMBER_NOT_IN_GROUP:
                    return true;
                case GROUP_NOT_IN_TEAM:
                    return true;
                case MEMBERS_NOT_IN_TEAM:
                    return (this.membersNotInTeamValue == other.membersNotInTeamValue) || (this.membersNotInTeamValue.equals(other.membersNotInTeamValue));
                case USERS_NOT_FOUND:
                    return (this.usersNotFoundValue == other.usersNotFoundValue) || (this.usersNotFoundValue.equals(other.usersNotFoundValue));
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
    static class Serializer extends UnionSerializer<GroupMembersRemoveError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMembersRemoveError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case GROUP_NOT_FOUND: {
                    g.writeString("group_not_found");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case SYSTEM_MANAGED_GROUP_DISALLOWED: {
                    g.writeString("system_managed_group_disallowed");
                    break;
                }
                case MEMBER_NOT_IN_GROUP: {
                    g.writeString("member_not_in_group");
                    break;
                }
                case GROUP_NOT_IN_TEAM: {
                    g.writeString("group_not_in_team");
                    break;
                }
                case MEMBERS_NOT_IN_TEAM: {
                    g.writeStartObject();
                    writeTag("members_not_in_team", g);
                    g.writeFieldName("members_not_in_team");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.membersNotInTeamValue, g);
                    g.writeEndObject();
                    break;
                }
                case USERS_NOT_FOUND: {
                    g.writeStartObject();
                    writeTag("users_not_found", g);
                    g.writeFieldName("users_not_found");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.usersNotFoundValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public GroupMembersRemoveError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupMembersRemoveError value;
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
            else if ("group_not_found".equals(tag)) {
                value = GroupMembersRemoveError.GROUP_NOT_FOUND;
            }
            else if ("other".equals(tag)) {
                value = GroupMembersRemoveError.OTHER;
            }
            else if ("system_managed_group_disallowed".equals(tag)) {
                value = GroupMembersRemoveError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            }
            else if ("member_not_in_group".equals(tag)) {
                value = GroupMembersRemoveError.MEMBER_NOT_IN_GROUP;
            }
            else if ("group_not_in_team".equals(tag)) {
                value = GroupMembersRemoveError.GROUP_NOT_IN_TEAM;
            }
            else if ("members_not_in_team".equals(tag)) {
                List<String> fieldValue = null;
                expectField("members_not_in_team", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = GroupMembersRemoveError.membersNotInTeam(fieldValue);
            }
            else if ("users_not_found".equals(tag)) {
                List<String> fieldValue = null;
                expectField("users_not_found", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = GroupMembersRemoveError.usersNotFound(fieldValue);
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
