/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public final class GroupMembersAddError {
    // union GroupMembersAddError

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
         * Business team, use the {@link DbxTeam#membersAdd(List)} endpoint.
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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("duplicate_user", Tag.DUPLICATE_USER);
        VALUES_.put("group_not_in_team", Tag.GROUP_NOT_IN_TEAM);
        VALUES_.put("members_not_in_team", Tag.MEMBERS_NOT_IN_TEAM);
        VALUES_.put("users_not_found", Tag.USERS_NOT_FOUND);
        VALUES_.put("user_must_be_active_to_be_owner", Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER);
    }

    public static final GroupMembersAddError GROUP_NOT_FOUND = new GroupMembersAddError(Tag.GROUP_NOT_FOUND, null, null);
    public static final GroupMembersAddError OTHER = new GroupMembersAddError(Tag.OTHER, null, null);
    public static final GroupMembersAddError DUPLICATE_USER = new GroupMembersAddError(Tag.DUPLICATE_USER, null, null);
    public static final GroupMembersAddError GROUP_NOT_IN_TEAM = new GroupMembersAddError(Tag.GROUP_NOT_IN_TEAM, null, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code GroupMembersAddError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#GROUP_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isGroupNotFound() {
        return this.tag == Tag.GROUP_NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DUPLICATE_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#DUPLICATE_USER}, {@code false} otherwise.
     */
    public boolean isDuplicateUser() {
        return this.tag == Tag.DUPLICATE_USER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_NOT_IN_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#GROUP_NOT_IN_TEAM}, {@code false} otherwise.
     */
    public boolean isGroupNotInTeam() {
        return this.tag == Tag.GROUP_NOT_IN_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MEMBERS_NOT_IN_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * Business team, use the {@link DbxTeam#membersAdd(List)} endpoint. </p>
     *
     * @param value  {@link GroupMembersAddError#membersNotInTeam} value to
     *     assign to this instance.
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
     * Business team, use the {@link DbxTeam#membersAdd(List)} endpoint.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link GroupMembersAddError#usersNotFound} value to assign
     *     to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#USER_MUST_BE_ACTIVE_TO_BE_OWNER}, {@code false} otherwise.
     */
    public boolean isUserMustBeActiveToBeOwner() {
        return this.tag == Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupMembersAddError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembersAddError> _JSON_WRITER = new JsonWriter<GroupMembersAddError>() {
        public final void write(GroupMembersAddError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case GROUP_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_not_found");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
                case DUPLICATE_USER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("duplicate_user");
                    g.writeEndObject();
                    break;
                case GROUP_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_not_in_team");
                    g.writeEndObject();
                    break;
                case MEMBERS_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("members_not_in_team");
                    g.writeFieldName("members_not_in_team");
                    g.writeStartArray();
                    for (String item: x.getMembersNotInTeamValue()) {
                        if (item != null) {
                            g.writeString(item);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
                case USERS_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("users_not_found");
                    g.writeFieldName("users_not_found");
                    g.writeStartArray();
                    for (String item: x.getUsersNotFoundValue()) {
                        if (item != null) {
                            g.writeString(item);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
                case USER_MUST_BE_ACTIVE_TO_BE_OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_must_be_active_to_be_owner");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupMembersAddError> _JSON_READER = new JsonReader<GroupMembersAddError>() {

        public final GroupMembersAddError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case GROUP_NOT_FOUND: return GroupMembersAddError.GROUP_NOT_FOUND;
                    case OTHER: return GroupMembersAddError.OTHER;
                    case DUPLICATE_USER: return GroupMembersAddError.DUPLICATE_USER;
                    case GROUP_NOT_IN_TEAM: return GroupMembersAddError.GROUP_NOT_IN_TEAM;
                    case USER_MUST_BE_ACTIVE_TO_BE_OWNER: return GroupMembersAddError.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            GroupMembersAddError value = null;
            if (tag != null) {
                switch (tag) {
                    case GROUP_NOT_FOUND: {
                        value = GroupMembersAddError.GROUP_NOT_FOUND;
                        break;
                    }
                    case OTHER: {
                        value = GroupMembersAddError.OTHER;
                        break;
                    }
                    case DUPLICATE_USER: {
                        value = GroupMembersAddError.DUPLICATE_USER;
                        break;
                    }
                    case GROUP_NOT_IN_TEAM: {
                        value = GroupMembersAddError.GROUP_NOT_IN_TEAM;
                        break;
                    }
                    case MEMBERS_NOT_IN_TEAM: {
                        List<String> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "members_not_in_team", v);
                        value = GroupMembersAddError.membersNotInTeam(v);
                        break;
                    }
                    case USERS_NOT_FOUND: {
                        List<String> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "users_not_found", v);
                        value = GroupMembersAddError.usersNotFound(v);
                        break;
                    }
                    case USER_MUST_BE_ACTIVE_TO_BE_OWNER: {
                        value = GroupMembersAddError.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
