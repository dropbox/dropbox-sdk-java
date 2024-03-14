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
public final class GroupMembersAddError {
    // union team.GroupMembersAddError (team_groups.stone)

    /**
     * Discriminating tag type for {@link GroupMembersAddError}.
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
         * You cannot add duplicate users. One or more of the members you are
         * trying to add is already a member of the group.
         */
        DUPLICATE_USER,
        /**
         * Group is not in this team. You cannot add members to a group that is
         * outside of your team.
         */
        GROUP_NOT_IN_TEAM,
        /**
         * These members are not part of your team. Currently, you cannot add
         * members to a group if they are not part of your team, though this may
         * change in a subsequent version. To add new members to your Dropbox
         * Business team, use the {@link
         * DbxTeamTeamRequests#membersAdd(List,boolean)} endpoint.
         */
        MEMBERS_NOT_IN_TEAM, // List<String>
        /**
         * These users were not found in Dropbox.
         */
        USERS_NOT_FOUND, // List<String>
        /**
         * A suspended user cannot be added to a group as {@link
         * GroupAccessType#OWNER}.
         */
        USER_MUST_BE_ACTIVE_TO_BE_OWNER,
        /**
         * A company-managed group cannot be managed by a user.
         */
        USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP; // List<String>
    }

    /**
     * No matching group found. No groups match the specified group ID.
     */
    public static final GroupMembersAddError GROUP_NOT_FOUND = new GroupMembersAddError().withTag(Tag.GROUP_NOT_FOUND);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final GroupMembersAddError OTHER = new GroupMembersAddError().withTag(Tag.OTHER);
    /**
     * This operation is not supported on system-managed groups.
     */
    public static final GroupMembersAddError SYSTEM_MANAGED_GROUP_DISALLOWED = new GroupMembersAddError().withTag(Tag.SYSTEM_MANAGED_GROUP_DISALLOWED);
    /**
     * You cannot add duplicate users. One or more of the members you are trying
     * to add is already a member of the group.
     */
    public static final GroupMembersAddError DUPLICATE_USER = new GroupMembersAddError().withTag(Tag.DUPLICATE_USER);
    /**
     * Group is not in this team. You cannot add members to a group that is
     * outside of your team.
     */
    public static final GroupMembersAddError GROUP_NOT_IN_TEAM = new GroupMembersAddError().withTag(Tag.GROUP_NOT_IN_TEAM);
    /**
     * A suspended user cannot be added to a group as {@link
     * GroupAccessType#OWNER}.
     */
    public static final GroupMembersAddError USER_MUST_BE_ACTIVE_TO_BE_OWNER = new GroupMembersAddError().withTag(Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER);

    private Tag _tag;
    private List<String> membersNotInTeamValue;
    private List<String> usersNotFoundValue;
    private List<String> userCannotBeManagerOfCompanyManagedGroupValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private GroupMembersAddError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private GroupMembersAddError withTag(Tag _tag) {
        GroupMembersAddError result = new GroupMembersAddError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param membersNotInTeamValue  These members are not part of your team.
     *     Currently, you cannot add members to a group if they are not part of
     *     your team, though this may change in a subsequent version. To add new
     *     members to your Dropbox Business team, use the {@link
     *     DbxTeamTeamRequests#membersAdd(List,boolean)} endpoint. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupMembersAddError withTagAndMembersNotInTeam(Tag _tag, List<String> membersNotInTeamValue) {
        GroupMembersAddError result = new GroupMembersAddError();
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
    private GroupMembersAddError withTagAndUsersNotFound(Tag _tag, List<String> usersNotFoundValue) {
        GroupMembersAddError result = new GroupMembersAddError();
        result._tag = _tag;
        result.usersNotFoundValue = usersNotFoundValue;
        return result;
    }

    /**
     *
     * @param userCannotBeManagerOfCompanyManagedGroupValue  A company-managed
     *     group cannot be managed by a user. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupMembersAddError withTagAndUserCannotBeManagerOfCompanyManagedGroup(Tag _tag, List<String> userCannotBeManagerOfCompanyManagedGroupValue) {
        GroupMembersAddError result = new GroupMembersAddError();
        result._tag = _tag;
        result.userCannotBeManagerOfCompanyManagedGroupValue = userCannotBeManagerOfCompanyManagedGroupValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GroupMembersAddError}. </p>
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
     * Tag#DUPLICATE_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DUPLICATE_USER}, {@code false} otherwise.
     */
    public boolean isDuplicateUser() {
        return this._tag == Tag.DUPLICATE_USER;
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
     * Returns an instance of {@code GroupMembersAddError} that has its tag set
     * to {@link Tag#MEMBERS_NOT_IN_TEAM}.
     *
     * <p> These members are not part of your team. Currently, you cannot add
     * members to a group if they are not part of your team, though this may
     * change in a subsequent version. To add new members to your Dropbox
     * Business team, use the {@link
     * DbxTeamTeamRequests#membersAdd(List,boolean)} endpoint. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupMembersAddError} with its tag set to
     *     {@link Tag#MEMBERS_NOT_IN_TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static GroupMembersAddError membersNotInTeam(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersAddError().withTagAndMembersNotInTeam(Tag.MEMBERS_NOT_IN_TEAM, value);
    }

    /**
     * These members are not part of your team. Currently, you cannot add
     * members to a group if they are not part of your team, though this may
     * change in a subsequent version. To add new members to your Dropbox
     * Business team, use the {@link
     * DbxTeamTeamRequests#membersAdd(List,boolean)} endpoint.
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
     * Returns an instance of {@code GroupMembersAddError} that has its tag set
     * to {@link Tag#USERS_NOT_FOUND}.
     *
     * <p> These users were not found in Dropbox. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupMembersAddError} with its tag set to
     *     {@link Tag#USERS_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static GroupMembersAddError usersNotFound(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersAddError().withTagAndUsersNotFound(Tag.USERS_NOT_FOUND, value);
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

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_MUST_BE_ACTIVE_TO_BE_OWNER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_MUST_BE_ACTIVE_TO_BE_OWNER}, {@code false} otherwise.
     */
    public boolean isUserMustBeActiveToBeOwner() {
        return this._tag == Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP}, {@code false}
     * otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP}, {@code false}
     *     otherwise.
     */
    public boolean isUserCannotBeManagerOfCompanyManagedGroup() {
        return this._tag == Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP;
    }

    /**
     * Returns an instance of {@code GroupMembersAddError} that has its tag set
     * to {@link Tag#USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP}.
     *
     * <p> A company-managed group cannot be managed by a user. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupMembersAddError} with its tag set to
     *     {@link Tag#USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static GroupMembersAddError userCannotBeManagerOfCompanyManagedGroup(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersAddError().withTagAndUserCannotBeManagerOfCompanyManagedGroup(Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP, value);
    }

    /**
     * A company-managed group cannot be managed by a user.
     *
     * <p> This instance must be tagged as {@link
     * Tag#USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP}. </p>
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isUserCannotBeManagerOfCompanyManagedGroup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link
     *     #isUserCannotBeManagerOfCompanyManagedGroup} is {@code false}.
     */
    public List<String> getUserCannotBeManagerOfCompanyManagedGroupValue() {
        if (this._tag != Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP, but was Tag." + this._tag.name());
        }
        return userCannotBeManagerOfCompanyManagedGroupValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            membersNotInTeamValue,
            usersNotFoundValue,
            userCannotBeManagerOfCompanyManagedGroupValue
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
        else if (obj instanceof GroupMembersAddError) {
            GroupMembersAddError other = (GroupMembersAddError) obj;
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
                case DUPLICATE_USER:
                    return true;
                case GROUP_NOT_IN_TEAM:
                    return true;
                case MEMBERS_NOT_IN_TEAM:
                    return (this.membersNotInTeamValue == other.membersNotInTeamValue) || (this.membersNotInTeamValue.equals(other.membersNotInTeamValue));
                case USERS_NOT_FOUND:
                    return (this.usersNotFoundValue == other.usersNotFoundValue) || (this.usersNotFoundValue.equals(other.usersNotFoundValue));
                case USER_MUST_BE_ACTIVE_TO_BE_OWNER:
                    return true;
                case USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP:
                    return (this.userCannotBeManagerOfCompanyManagedGroupValue == other.userCannotBeManagerOfCompanyManagedGroupValue) || (this.userCannotBeManagerOfCompanyManagedGroupValue.equals(other.userCannotBeManagerOfCompanyManagedGroupValue));
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
    static class Serializer extends UnionSerializer<GroupMembersAddError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMembersAddError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case DUPLICATE_USER: {
                    g.writeString("duplicate_user");
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
                case USER_MUST_BE_ACTIVE_TO_BE_OWNER: {
                    g.writeString("user_must_be_active_to_be_owner");
                    break;
                }
                case USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP: {
                    g.writeStartObject();
                    writeTag("user_cannot_be_manager_of_company_managed_group", g);
                    g.writeFieldName("user_cannot_be_manager_of_company_managed_group");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.userCannotBeManagerOfCompanyManagedGroupValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public GroupMembersAddError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupMembersAddError value;
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
                value = GroupMembersAddError.GROUP_NOT_FOUND;
            }
            else if ("other".equals(tag)) {
                value = GroupMembersAddError.OTHER;
            }
            else if ("system_managed_group_disallowed".equals(tag)) {
                value = GroupMembersAddError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            }
            else if ("duplicate_user".equals(tag)) {
                value = GroupMembersAddError.DUPLICATE_USER;
            }
            else if ("group_not_in_team".equals(tag)) {
                value = GroupMembersAddError.GROUP_NOT_IN_TEAM;
            }
            else if ("members_not_in_team".equals(tag)) {
                List<String> fieldValue = null;
                expectField("members_not_in_team", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = GroupMembersAddError.membersNotInTeam(fieldValue);
            }
            else if ("users_not_found".equals(tag)) {
                List<String> fieldValue = null;
                expectField("users_not_found", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = GroupMembersAddError.usersNotFound(fieldValue);
            }
            else if ("user_must_be_active_to_be_owner".equals(tag)) {
                value = GroupMembersAddError.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
            }
            else if ("user_cannot_be_manager_of_company_managed_group".equals(tag)) {
                List<String> fieldValue = null;
                expectField("user_cannot_be_manager_of_company_managed_group", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = GroupMembersAddError.userCannotBeManagerOfCompanyManagedGroup(fieldValue);
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
