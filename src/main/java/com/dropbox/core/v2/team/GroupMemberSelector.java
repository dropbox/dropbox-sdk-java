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
 * Argument for selecting a group and a single user.
 */
public class GroupMemberSelector {
    // struct GroupMemberSelector

    private final GroupSelector group;
    private final UserSelectorArg user;

    /**
     * Argument for selecting a group and a single user.
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of {@link
     *     GroupMemberSelector#getGroup}. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMemberSelector(GroupSelector group, UserSelectorArg user) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
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
     * Identity of a user that is a member of {@link
     * GroupMemberSelector#getGroup}.
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            user
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
            GroupMemberSelector other = (GroupMemberSelector) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.user == other.user) || (this.user.equals(other.user)))
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

    public static GroupMemberSelector fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMemberSelector> _JSON_WRITER = new JsonWriter<GroupMemberSelector>() {
        public final void write(GroupMemberSelector x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupMemberSelector._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMemberSelector x, JsonGenerator g) throws IOException {
            g.writeFieldName("group");
            GroupSelector._JSON_WRITER.write(x.group, g);
            g.writeFieldName("user");
            UserSelectorArg._JSON_WRITER.write(x.user, g);
        }
    };

    public static final JsonReader<GroupMemberSelector> _JSON_READER = new JsonReader<GroupMemberSelector>() {
        public final GroupMemberSelector read(JsonParser parser) throws IOException, JsonReadException {
            GroupMemberSelector result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMemberSelector readFields(JsonParser parser) throws IOException, JsonReadException {
            GroupSelector group = null;
            UserSelectorArg user = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group".equals(fieldName)) {
                    group = GroupSelector._JSON_READER
                        .readField(parser, "group", group);
                }
                else if ("user".equals(fieldName)) {
                    user = UserSelectorArg._JSON_READER
                        .readField(parser, "user", user);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (group == null) {
                throw new JsonReadException("Required field \"group\" is missing.", parser.getTokenLocation());
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            return new GroupMemberSelector(group, user);
        }
    };
}
