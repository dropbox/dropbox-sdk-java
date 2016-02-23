/* DO NOT EDIT */
/* This file was generated from team_common.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Information about a group.
 */
public class GroupSummary {
    // struct GroupSummary

    private final String groupName;
    private final String groupId;
    private final String groupExternalId;
    private final long memberCount;

    /**
     * Information about a group.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupSummary(String groupName, String groupId, long memberCount, String groupExternalId) {
        if (groupName == null) {
            throw new IllegalArgumentException("Required value for 'groupName' is null");
        }
        this.groupName = groupName;
        if (groupId == null) {
            throw new IllegalArgumentException("Required value for 'groupId' is null");
        }
        this.groupId = groupId;
        this.groupExternalId = groupExternalId;
        this.memberCount = memberCount;
    }

    /**
     * Information about a group.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupSummary(String groupName, String groupId, long memberCount) {
        this(groupName, groupId, memberCount, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * External ID of group. This is an arbitrary ID that an admin can attach to
     * a group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getGroupExternalId() {
        return groupExternalId;
    }

    /**
     * The number of members in the group.
     *
     * @return value for this field.
     */
    public long getMemberCount() {
        return memberCount;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupName,
            groupId,
            groupExternalId,
            memberCount
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
            GroupSummary other = (GroupSummary) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupId == other.groupId) || (this.groupId.equals(other.groupId)))
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
                && (this.memberCount == other.memberCount)
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

    public static GroupSummary fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupSummary> _JSON_WRITER = new JsonWriter<GroupSummary>() {
        public final void write(GroupSummary x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupSummary._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupSummary x, JsonGenerator g) throws IOException {
            g.writeFieldName("group_name");
            g.writeString(x.groupName);
            g.writeFieldName("group_id");
            g.writeString(x.groupId);
            if (x.groupExternalId != null) {
                g.writeFieldName("group_external_id");
                g.writeString(x.groupExternalId);
            }
            g.writeFieldName("member_count");
            g.writeNumber(x.memberCount);
        }
    };

    public static final JsonReader<GroupSummary> _JSON_READER = new JsonReader<GroupSummary>() {
        public final GroupSummary read(JsonParser parser) throws IOException, JsonReadException {
            GroupSummary result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupSummary readFields(JsonParser parser) throws IOException, JsonReadException {
            String groupName = null;
            String groupId = null;
            Long memberCount = null;
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
            return new GroupSummary(groupName, groupId, memberCount, groupExternalId);
        }
    };
}
