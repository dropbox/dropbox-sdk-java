/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2;

import java.io.IOException;
import java.util.regex.Pattern;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.dropbox.core.DbxApiException;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonWriter;

/**
 * Classes and routes in namespace "team".
 */
public final class DbxTeam {
    // namespace team

    private final DbxRawClientV2 client;

    DbxTeam(DbxRawClientV2 client) {
        this.client = client;
    }

    /**
     * Information about a group.
     */
    public static class GroupSummary {
        // struct GroupSummary
        public final String groupName;
        public final String groupId;
        /**
         * External ID of group. This is an arbitrary ID that an admin can
         * attach to a group.
         */
        public final String groupExternalId;
        /**
         * The number of members in the group.
         */
        public final long memberCount;

        public GroupSummary(String groupName, String groupId, long memberCount, String groupExternalId) {
            this.groupName = groupName;
            if (groupName == null) {
                throw new RuntimeException("Required value for 'groupName' is null");
            }
            this.groupId = groupId;
            if (groupId == null) {
                throw new RuntimeException("Required value for 'groupId' is null");
            }
            this.groupExternalId = groupExternalId;
            this.memberCount = memberCount;
        }
        static final JsonWriter<GroupSummary> _writer = new JsonWriter<GroupSummary>()
        {
            public final void write(GroupSummary x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GroupSummary._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GroupSummary x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("group_name", x.groupName);
                g.writeStringField("group_id", x.groupId);
                if (x.groupExternalId != null) {
                    g.writeFieldName("group_external_id");
                    g.writeString(x.groupExternalId);
                }
                g.writeNumberField("member_count", x.memberCount);
            }
        };

        public static final JsonReader<GroupSummary> _reader = new JsonReader<GroupSummary>() {

            public final GroupSummary read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GroupSummary result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GroupSummary readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
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
                    else { JsonReader.skipValue(parser); }
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

        public String toString() {
            return "GroupSummary." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GroupSummary." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GroupSummary fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }
}
