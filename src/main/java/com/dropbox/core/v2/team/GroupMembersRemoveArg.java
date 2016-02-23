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

public class GroupMembersRemoveArg {
    // struct GroupMembersRemoveArg

    private final GroupSelector group;
    private final List<UserSelectorArg> users;

    /**
     *
     * @param group  Must not be {@code null}.
     * @param users  Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersRemoveArg(GroupSelector group, List<UserSelectorArg> users) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (UserSelectorArg x : users) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = users;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserSelectorArg> getUsers() {
        return users;
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
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupMembersRemoveArg other = (GroupMembersRemoveArg) obj;
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

    public static GroupMembersRemoveArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembersRemoveArg> _JSON_WRITER = new JsonWriter<GroupMembersRemoveArg>() {
        public final void write(GroupMembersRemoveArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupMembersRemoveArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMembersRemoveArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("group");
            GroupSelector._JSON_WRITER.write(x.group, g);
            g.writeFieldName("users");
            g.writeStartArray();
            for (UserSelectorArg item: x.users) {
                if (item != null) {
                    UserSelectorArg._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<GroupMembersRemoveArg> _JSON_READER = new JsonReader<GroupMembersRemoveArg>() {
        public final GroupMembersRemoveArg read(JsonParser parser) throws IOException, JsonReadException {
            GroupMembersRemoveArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMembersRemoveArg readFields(JsonParser parser) throws IOException, JsonReadException {
            GroupSelector group = null;
            List<UserSelectorArg> users = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group".equals(fieldName)) {
                    group = GroupSelector._JSON_READER
                        .readField(parser, "group", group);
                }
                else if ("users".equals(fieldName)) {
                    users = JsonArrayReader.mk(UserSelectorArg._JSON_READER)
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
            return new GroupMembersRemoveArg(group, users);
        }
    };
}
