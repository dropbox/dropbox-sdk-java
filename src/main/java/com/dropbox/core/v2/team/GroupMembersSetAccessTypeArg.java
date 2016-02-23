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

public class GroupMembersSetAccessTypeArg extends GroupMemberSelector {
    // struct GroupMembersSetAccessTypeArg

    private final GroupAccessType accessType;

    /**
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of {@link
     *     GroupMemberSelector#getGroup}. Must not be {@code null}.
     * @param accessType  New group access type the user will have. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersSetAccessTypeArg(GroupSelector group, UserSelectorArg user, GroupAccessType accessType) {
        super(group, user);
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
    }

    /**
     * New group access type the user will have.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accessType
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupMembersSetAccessTypeArg other = (GroupMembersSetAccessTypeArg) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && ((this.getGroup() == other.getGroup()) || (this.getGroup().equals(other.getGroup())))
                && ((this.getUser() == other.getUser()) || (this.getUser().equals(other.getUser())))
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

    public static GroupMembersSetAccessTypeArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembersSetAccessTypeArg> _JSON_WRITER = new JsonWriter<GroupMembersSetAccessTypeArg>() {
        public final void write(GroupMembersSetAccessTypeArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupMemberSelector._JSON_WRITER.writeFields(x, g);
            GroupMembersSetAccessTypeArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMembersSetAccessTypeArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("access_type");
            GroupAccessType._JSON_WRITER.write(x.accessType, g);
        }
    };

    public static final JsonReader<GroupMembersSetAccessTypeArg> _JSON_READER = new JsonReader<GroupMembersSetAccessTypeArg>() {
        public final GroupMembersSetAccessTypeArg read(JsonParser parser) throws IOException, JsonReadException {
            GroupMembersSetAccessTypeArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMembersSetAccessTypeArg readFields(JsonParser parser) throws IOException, JsonReadException {
            GroupSelector group = null;
            UserSelectorArg user = null;
            GroupAccessType accessType = null;
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
                else if ("access_type".equals(fieldName)) {
                    accessType = GroupAccessType._JSON_READER
                        .readField(parser, "access_type", accessType);
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
            if (accessType == null) {
                throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
            }
            return new GroupMembersSetAccessTypeArg(group, user, accessType);
        }
    };
}
