/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
@JsonSerialize(using=GroupMembersAddError.Serializer.class)
@JsonDeserialize(using=GroupMembersAddError.Deserializer.class)
public final class GroupMembersAddError {
    // union GroupMembersAddError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link GroupMembersAddError}.
     */
    public enum Tag {
        /**
         * No matching group found. No groups match the specified group ID.
         */
        GROUP_NOT_FOUND,
        OTHER,
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
         * Business team, use the {@link DbxTeamTeamRequests#membersAdd(List)}
         * endpoint.
         */
        MEMBERS_NOT_IN_TEAM, // List<String>
        /**
         * These users were not found in Dropbox.
         */
        USERS_NOT_FOUND, // List<String>
        /**
         * A suspended user cannot be added to a group as owner.
         */
        USER_MUST_BE_ACTIVE_TO_BE_OWNER;
    }

    /**
     * No matching group found. No groups match the specified group ID.
     */
    public static final GroupMembersAddError GROUP_NOT_FOUND = new GroupMembersAddError(Tag.GROUP_NOT_FOUND, null, null);
    public static final GroupMembersAddError OTHER = new GroupMembersAddError(Tag.OTHER, null, null);
    /**
     * You cannot add duplicate users. One or more of the members you are trying
     * to add is already a member of the group.
     */
    public static final GroupMembersAddError DUPLICATE_USER = new GroupMembersAddError(Tag.DUPLICATE_USER, null, null);
    /**
     * Group is not in this team. You cannot add members to a group that is
     * outside of your team.
     */
    public static final GroupMembersAddError GROUP_NOT_IN_TEAM = new GroupMembersAddError(Tag.GROUP_NOT_IN_TEAM, null, null);
    /**
     * A suspended user cannot be added to a group as owner.
     */
    public static final GroupMembersAddError USER_MUST_BE_ACTIVE_TO_BE_OWNER = new GroupMembersAddError(Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER, null, null);

    private final Tag tag;
    private final List<String> membersNotInTeamValue;
    private final List<String> usersNotFoundValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private GroupMembersAddError(Tag tag, List<String> membersNotInTeamValue, List<String> usersNotFoundValue) {
        this.tag = tag;
        this.membersNotInTeamValue = membersNotInTeamValue;
        this.usersNotFoundValue = usersNotFoundValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isGroupNotFound() {
        return this.tag == Tag.GROUP_NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DUPLICATE_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DUPLICATE_USER}, {@code false} otherwise.
     */
    public boolean isDuplicateUser() {
        return this.tag == Tag.DUPLICATE_USER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_NOT_IN_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_NOT_IN_TEAM}, {@code false} otherwise.
     */
    public boolean isGroupNotInTeam() {
        return this.tag == Tag.GROUP_NOT_IN_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MEMBERS_NOT_IN_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MEMBERS_NOT_IN_TEAM}, {@code false} otherwise.
     */
    public boolean isMembersNotInTeam() {
        return this.tag == Tag.MEMBERS_NOT_IN_TEAM;
    }

    /**
     * Returns an instance of {@code GroupMembersAddError} that has its tag set
     * to {@link Tag#MEMBERS_NOT_IN_TEAM}.
     *
     * <p> These members are not part of your team. Currently, you cannot add
     * members to a group if they are not part of your team, though this may
     * change in a subsequent version. To add new members to your Dropbox
     * Business team, use the {@link DbxTeamTeamRequests#membersAdd(List)}
     * endpoint. </p>
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
        return new GroupMembersAddError(Tag.MEMBERS_NOT_IN_TEAM, value, null);
    }

    /**
     * These members are not part of your team. Currently, you cannot add
     * members to a group if they are not part of your team, though this may
     * change in a subsequent version. To add new members to your Dropbox
     * Business team, use the {@link DbxTeamTeamRequests#membersAdd(List)}
     * endpoint.
     *
     * <p> This instance must be tagged as {@link Tag#MEMBERS_NOT_IN_TEAM}. </p>
     *
     * @return The {@link GroupMembersAddError#membersNotInTeam} value
     *     associated with this instance if {@link #isMembersNotInTeam} is
     *     {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMembersNotInTeam} is {@code
     *     false}.
     */
    public List<String> getMembersNotInTeamValue() {
        if (this.tag != Tag.MEMBERS_NOT_IN_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBERS_NOT_IN_TEAM, but was Tag." + tag.name());
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
        return this.tag == Tag.USERS_NOT_FOUND;
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
        return new GroupMembersAddError(Tag.USERS_NOT_FOUND, null, value);
    }

    /**
     * These users were not found in Dropbox.
     *
     * <p> This instance must be tagged as {@link Tag#USERS_NOT_FOUND}. </p>
     *
     * @return The {@link GroupMembersAddError#usersNotFound} value associated
     *     with this instance if {@link #isUsersNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUsersNotFound} is {@code
     *     false}.
     */
    public List<String> getUsersNotFoundValue() {
        if (this.tag != Tag.USERS_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.USERS_NOT_FOUND, but was Tag." + tag.name());
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
        return this.tag == Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            membersNotInTeamValue,
            usersNotFoundValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof GroupMembersAddError) {
            GroupMembersAddError other = (GroupMembersAddError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case GROUP_NOT_FOUND:
                    return true;
                case OTHER:
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends UnionJsonSerializer<GroupMembersAddError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMembersAddError.class);
        }

        @Override
        public void serialize(GroupMembersAddError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case GROUP_NOT_FOUND:
                    g.writeString("group_not_found");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
                case DUPLICATE_USER:
                    g.writeString("duplicate_user");
                    break;
                case GROUP_NOT_IN_TEAM:
                    g.writeString("group_not_in_team");
                    break;
                case MEMBERS_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeStringField(".tag", "members_not_in_team");
                    g.writeObjectField("members_not_in_team", value.membersNotInTeamValue);
                    g.writeEndObject();
                    break;
                case USERS_NOT_FOUND:
                    g.writeStartObject();
                    g.writeStringField(".tag", "users_not_found");
                    g.writeObjectField("users_not_found", value.usersNotFoundValue);
                    g.writeEndObject();
                    break;
                case USER_MUST_BE_ACTIVE_TO_BE_OWNER:
                    g.writeString("user_must_be_active_to_be_owner");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupMembersAddError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMembersAddError.class, getTagMapping(), null);
        }

        @Override
        public GroupMembersAddError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case GROUP_NOT_FOUND: {
                    return GroupMembersAddError.GROUP_NOT_FOUND;
                }
                case OTHER: {
                    return GroupMembersAddError.OTHER;
                }
                case DUPLICATE_USER: {
                    return GroupMembersAddError.DUPLICATE_USER;
                }
                case GROUP_NOT_IN_TEAM: {
                    return GroupMembersAddError.GROUP_NOT_IN_TEAM;
                }
                case MEMBERS_NOT_IN_TEAM: {
                    List<String> value = null;
                    expectField(_p, "members_not_in_team");
                    expectArrayStart(_p);
                    value = new java.util.ArrayList<String>();
                    while (!isArrayEnd(_p)) {
                        String _x = null;
                        _x = getStringValue(_p);
                        _p.nextToken();
                        value.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                    return GroupMembersAddError.membersNotInTeam(value);
                }
                case USERS_NOT_FOUND: {
                    List<String> value = null;
                    expectField(_p, "users_not_found");
                    expectArrayStart(_p);
                    value = new java.util.ArrayList<String>();
                    while (!isArrayEnd(_p)) {
                        String _x = null;
                        _x = getStringValue(_p);
                        _p.nextToken();
                        value.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                    return GroupMembersAddError.usersNotFound(value);
                }
                case USER_MUST_BE_ACTIVE_TO_BE_OWNER: {
                    return GroupMembersAddError.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, GroupMembersAddError.Tag> getTagMapping() {
            Map<String, GroupMembersAddError.Tag> values = new HashMap<String, GroupMembersAddError.Tag>();
            values.put("duplicate_user", GroupMembersAddError.Tag.DUPLICATE_USER);
            values.put("group_not_in_team", GroupMembersAddError.Tag.GROUP_NOT_IN_TEAM);
            values.put("members_not_in_team", GroupMembersAddError.Tag.MEMBERS_NOT_IN_TEAM);
            values.put("users_not_found", GroupMembersAddError.Tag.USERS_NOT_FOUND);
            values.put("user_must_be_active_to_be_owner", GroupMembersAddError.Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER);
            return Collections.unmodifiableMap(values);
        }
    }
}
