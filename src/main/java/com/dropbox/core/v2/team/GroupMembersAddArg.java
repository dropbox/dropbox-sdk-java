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

public class GroupMembersAddArg {
    // struct GroupMembersAddArg

    private final GroupSelector group;
    private final List<MemberAccess> members;

    /**
     *
     * @param group  Group to which users will be added. Must not be {@code
     *     null}.
     * @param members  List of users to be added to the group. Must not contain
     *     a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersAddArg(GroupSelector group, List<MemberAccess> members) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (MemberAccess x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
    }

    /**
     * Group to which users will be added.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * List of users to be added to the group.
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberAccess> getMembers() {
        return members;
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
            GroupMembersAddArg other = (GroupMembersAddArg) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.members == other.members) || (this.members.equals(other.members)))
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

    public static GroupMembersAddArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembersAddArg> _JSON_WRITER = new JsonWriter<GroupMembersAddArg>() {
        public final void write(GroupMembersAddArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupMembersAddArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMembersAddArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("group");
            GroupSelector._JSON_WRITER.write(x.group, g);
            g.writeFieldName("members");
            g.writeStartArray();
            for (MemberAccess item: x.members) {
                if (item != null) {
                    MemberAccess._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<GroupMembersAddArg> _JSON_READER = new JsonReader<GroupMembersAddArg>() {
        public final GroupMembersAddArg read(JsonParser parser) throws IOException, JsonReadException {
            GroupMembersAddArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMembersAddArg readFields(JsonParser parser) throws IOException, JsonReadException {
            GroupSelector group = null;
            List<MemberAccess> members = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group".equals(fieldName)) {
                    group = GroupSelector._JSON_READER
                        .readField(parser, "group", group);
                }
                else if ("members".equals(fieldName)) {
                    members = JsonArrayReader.mk(MemberAccess._JSON_READER)
                        .readField(parser, "members", members);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (group == null) {
                throw new JsonReadException("Required field \"group\" is missing.", parser.getTokenLocation());
            }
            if (members == null) {
                throw new JsonReadException("Required field \"members\" is missing.", parser.getTokenLocation());
            }
            return new GroupMembersAddArg(group, members);
        }
    };
}
