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

/**
 * Full description of a group.
 */
public class GroupFullInfo extends GroupSummary {
    // struct GroupFullInfo

    private final List<GroupMemberInfo> members;
    private final long created;

    /**
     * Full description of a group.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     * @param members  List of group members. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param created  The group creation time as a UTC timestamp in
     *     milliseconds since the Unix epoch.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo(String groupName, String groupId, long memberCount, List<GroupMemberInfo> members, long created, String groupExternalId) {
        super(groupName, groupId, memberCount, groupExternalId);
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (GroupMemberInfo x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        this.created = created;
    }

    /**
     * Full description of a group.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     * @param members  List of group members. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param created  The group creation time as a UTC timestamp in
     *     milliseconds since the Unix epoch.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo(String groupName, String groupId, long memberCount, List<GroupMemberInfo> members, long created) {
        this(groupName, groupId, memberCount, members, created, null);
    }

    /**
     * List of group members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<GroupMemberInfo> getMembers() {
        return members;
    }

    /**
     * The group creation time as a UTC timestamp in milliseconds since the Unix
     * epoch.
     *
     * @return value for this field.
     */
    public long getCreated() {
        return created;
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
            GroupFullInfo other = (GroupFullInfo) obj;
            return ((this.members == other.members) || (this.members.equals(other.members)))
                && (this.created == other.created)
                && ((this.getGroupName() == other.getGroupName()) || (this.getGroupName().equals(other.getGroupName())))
                && ((this.getGroupId() == other.getGroupId()) || (this.getGroupId().equals(other.getGroupId())))
                && ((this.getGroupExternalId() == other.getGroupExternalId()) || (this.getGroupExternalId() != null && this.getGroupExternalId().equals(other.getGroupExternalId())))
                && (this.getMemberCount() == other.getMemberCount())
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

    public static GroupFullInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupFullInfo> _JSON_WRITER = new JsonWriter<GroupFullInfo>() {
        public final void write(GroupFullInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupSummary._JSON_WRITER.writeFields(x, g);
            GroupFullInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupFullInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("members");
            g.writeStartArray();
            for (GroupMemberInfo item: x.members) {
                if (item != null) {
                    GroupMemberInfo._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("created");
            g.writeNumber(x.created);
        }
    };

    public static final JsonReader<GroupFullInfo> _JSON_READER = new JsonReader<GroupFullInfo>() {
        public final GroupFullInfo read(JsonParser parser) throws IOException, JsonReadException {
            GroupFullInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupFullInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            String groupName = null;
            String groupId = null;
            Long memberCount = null;
            List<GroupMemberInfo> members = null;
            Long created = null;
            String groupExternalId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group_name".equals(fieldName)) {
                    groupName = JsonReader.StringReader
                        .readField(parser, "group_name", groupName);
                }
                else if ("group_id".equals(fieldName)) {
                    groupId = JsonReader.StringReader
                        .readField(parser, "group_id", groupId);
                }
                else if ("member_count".equals(fieldName)) {
                    memberCount = JsonReader.UInt32Reader
                        .readField(parser, "member_count", memberCount);
                }
                else if ("members".equals(fieldName)) {
                    members = JsonArrayReader.mk(GroupMemberInfo._JSON_READER)
                        .readField(parser, "members", members);
                }
                else if ("created".equals(fieldName)) {
                    created = JsonReader.UInt64Reader
                        .readField(parser, "created", created);
                }
                else if ("group_external_id".equals(fieldName)) {
                    groupExternalId = JsonReader.StringReader
                        .readField(parser, "group_external_id", groupExternalId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (groupName == null) {
                throw new JsonReadException("Required field \"group_name\" is missing.", parser.getTokenLocation());
            }
            if (groupId == null) {
                throw new JsonReadException("Required field \"group_id\" is missing.", parser.getTokenLocation());
            }
            if (memberCount == null) {
                throw new JsonReadException("Required field \"member_count\" is missing.", parser.getTokenLocation());
            }
            if (members == null) {
                throw new JsonReadException("Required field \"members\" is missing.", parser.getTokenLocation());
            }
            if (created == null) {
                throw new JsonReadException("Required field \"created\" is missing.", parser.getTokenLocation());
            }
            return new GroupFullInfo(groupName, groupId, memberCount, members, created, groupExternalId);
        }
    };
}
