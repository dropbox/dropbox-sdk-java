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
 * Result returned by {@link
 * DbxTeam#groupsMembersAdd(GroupSelector,java.util.List)} and {@link
 * DbxTeam#groupsMembersRemove(GroupSelector,java.util.List)}.
 */
public class GroupMembersChangeResult {
    // struct GroupMembersChangeResult

    private final GroupFullInfo groupInfo;
    private final String asyncJobId;

    /**
     * Result returned by {@link
     * DbxTeam#groupsMembersAdd(GroupSelector,java.util.List)} and {@link
     * DbxTeam#groupsMembersRemove(GroupSelector,java.util.List)}.
     *
     * @param groupInfo  Lists the group members after the member change
     *     operation has been performed. Must not be {@code null}.
     * @param asyncJobId  An ID that can be used to obtain the status of
     *     granting/revoking group-owned resources. Must have length of at least
     *     1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult(GroupFullInfo groupInfo, String asyncJobId) {
        if (groupInfo == null) {
            throw new IllegalArgumentException("Required value for 'groupInfo' is null");
        }
        this.groupInfo = groupInfo;
        if (asyncJobId == null) {
            throw new IllegalArgumentException("Required value for 'asyncJobId' is null");
        }
        if (asyncJobId.length() < 1) {
            throw new IllegalArgumentException("String 'asyncJobId' is shorter than 1");
        }
        this.asyncJobId = asyncJobId;
    }

    /**
     * Lists the group members after the member change operation has been
     * performed.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupFullInfo getGroupInfo() {
        return groupInfo;
    }

    /**
     * An ID that can be used to obtain the status of granting/revoking
     * group-owned resources.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAsyncJobId() {
        return asyncJobId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupInfo,
            asyncJobId
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
            GroupMembersChangeResult other = (GroupMembersChangeResult) obj;
            return ((this.groupInfo == other.groupInfo) || (this.groupInfo.equals(other.groupInfo)))
                && ((this.asyncJobId == other.asyncJobId) || (this.asyncJobId.equals(other.asyncJobId)))
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

    public static GroupMembersChangeResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembersChangeResult> _JSON_WRITER = new JsonWriter<GroupMembersChangeResult>() {
        public final void write(GroupMembersChangeResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupMembersChangeResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMembersChangeResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("group_info");
            GroupFullInfo._JSON_WRITER.write(x.groupInfo, g);
            g.writeFieldName("async_job_id");
            g.writeString(x.asyncJobId);
        }
    };

    public static final JsonReader<GroupMembersChangeResult> _JSON_READER = new JsonReader<GroupMembersChangeResult>() {
        public final GroupMembersChangeResult read(JsonParser parser) throws IOException, JsonReadException {
            GroupMembersChangeResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMembersChangeResult readFields(JsonParser parser) throws IOException, JsonReadException {
            GroupFullInfo groupInfo = null;
            String asyncJobId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group_info".equals(fieldName)) {
                    groupInfo = GroupFullInfo._JSON_READER
                        .readField(parser, "group_info", groupInfo);
                }
                else if ("async_job_id".equals(fieldName)) {
                    asyncJobId = JsonReader.StringReader
                        .readField(parser, "async_job_id", asyncJobId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (groupInfo == null) {
                throw new JsonReadException("Required field \"group_info\" is missing.", parser.getTokenLocation());
            }
            if (asyncJobId == null) {
                throw new JsonReadException("Required field \"async_job_id\" is missing.", parser.getTokenLocation());
            }
            return new GroupMembersChangeResult(groupInfo, asyncJobId);
        }
    };
}
