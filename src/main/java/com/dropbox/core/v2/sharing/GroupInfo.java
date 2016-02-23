/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.v2.team.GroupSummary;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * The information about a group. Groups is a way to manage a list of users  who
 * need same access permission to the shared folder.
 */
public class GroupInfo extends GroupSummary {
    // struct GroupInfo

    private final boolean sameTeam;

    /**
     * The information about a group. Groups is a way to manage a list of users
     * who need same access permission to the shared folder.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     * @param sameTeam  If the group is owned by the current user's team.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupInfo(String groupName, String groupId, long memberCount, boolean sameTeam, String groupExternalId) {
        super(groupName, groupId, memberCount, groupExternalId);
        this.sameTeam = sameTeam;
    }

    /**
     * The information about a group. Groups is a way to manage a list of users
     * who need same access permission to the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     * @param sameTeam  If the group is owned by the current user's team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupInfo(String groupName, String groupId, long memberCount, boolean sameTeam) {
        this(groupName, groupId, memberCount, sameTeam, null);
    }

    /**
     * If the group is owned by the current user's team.
     *
     * @return value for this field.
     */
    public boolean getSameTeam() {
        return sameTeam;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sameTeam
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
            GroupInfo other = (GroupInfo) obj;
            return (this.sameTeam == other.sameTeam)
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

    public static GroupInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupInfo> _JSON_WRITER = new JsonWriter<GroupInfo>() {
        public final void write(GroupInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupSummary._JSON_WRITER.writeFields(x, g);
            GroupInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("same_team");
            g.writeBoolean(x.sameTeam);
        }
    };

    public static final JsonReader<GroupInfo> _JSON_READER = new JsonReader<GroupInfo>() {
        public final GroupInfo read(JsonParser parser) throws IOException, JsonReadException {
            GroupInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            String groupName = null;
            String groupId = null;
            Long memberCount = null;
            Boolean sameTeam = null;
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
                else if ("same_team".equals(fieldName)) {
                    sameTeam = JsonReader.BooleanReader
                        .readField(parser, "same_team", sameTeam);
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
            if (sameTeam == null) {
                throw new JsonReadException("Required field \"same_team\" is missing.", parser.getTokenLocation());
            }
            return new GroupInfo(groupName, groupId, memberCount, sameTeam, groupExternalId);
        }
    };
}
