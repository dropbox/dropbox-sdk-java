/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Argument for selecting a group and a list of users.
 */
public class GroupMembersSelector {
    // struct GroupMembersSelector

    private final GroupSelector group;
    private final UsersSelectorArg users;

    /**
     * Argument for selecting a group and a list of users.
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param users  A list of users that are members of {@link
     *     GroupMembersSelector#getGroup}. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersSelector(GroupSelector group, UsersSelectorArg users) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        this.users = users;
    }

    /**
     * Specify a group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * A list of users that are members of {@link
     * GroupMembersSelector#getGroup}.
     *
     * @return value for this field, never {@code null}.
     */
    public UsersSelectorArg getUsers() {
        return users;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            users
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupMembersSelector other = (GroupMembersSelector) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.users == other.users) || (this.users.equals(other.users)))
                ;
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

    public static GroupMembersSelector fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembersSelector> _JSON_WRITER = new JsonWriter<GroupMembersSelector>() {
        public final void write(GroupMembersSelector x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupMembersSelector._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMembersSelector x, JsonGenerator g) throws IOException {
            g.writeFieldName("group");
            GroupSelector._JSON_WRITER.write(x.group, g);
            g.writeFieldName("users");
            UsersSelectorArg._JSON_WRITER.write(x.users, g);
        }
    };

    public static final JsonReader<GroupMembersSelector> _JSON_READER = new JsonReader<GroupMembersSelector>() {
        public final GroupMembersSelector read(JsonParser parser) throws IOException, JsonReadException {
            GroupMembersSelector result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMembersSelector readFields(JsonParser parser) throws IOException, JsonReadException {
            GroupSelector group = null;
            UsersSelectorArg users = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group".equals(fieldName)) {
                    group = GroupSelector._JSON_READER
                        .readField(parser, "group", group);
                }
                else if ("users".equals(fieldName)) {
                    users = UsersSelectorArg._JSON_READER
                        .readField(parser, "users", users);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (group == null) {
                throw new JsonReadException("Required field \"group\" is missing.", parser.getTokenLocation());
            }
            if (users == null) {
                throw new JsonReadException("Required field \"users\" is missing.", parser.getTokenLocation());
            }
            return new GroupMembersSelector(group, users);
        }
    };
}
