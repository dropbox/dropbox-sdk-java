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

public class GroupCreateArg {
    // struct GroupCreateArg

    private final String groupName;
    private final String groupExternalId;

    /**
     *
     * @param groupName  Group name. Must not be {@code null}.
     * @param groupExternalId  Optional argument. The creator of a team can
     *     associate an arbitrary external ID to the group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupCreateArg(String groupName, String groupExternalId) {
        if (groupName == null) {
            throw new IllegalArgumentException("Required value for 'groupName' is null");
        }
        this.groupName = groupName;
        this.groupExternalId = groupExternalId;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupCreateArg(String groupName) {
        this(groupName, null);
    }

    /**
     * Group name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Optional argument. The creator of a team can associate an arbitrary
     * external ID to the group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getGroupExternalId() {
        return groupExternalId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupName,
            groupExternalId
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
            GroupCreateArg other = (GroupCreateArg) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
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

    public static GroupCreateArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupCreateArg> _JSON_WRITER = new JsonWriter<GroupCreateArg>() {
        public final void write(GroupCreateArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupCreateArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupCreateArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("group_name");
            g.writeString(x.groupName);
            if (x.groupExternalId != null) {
                g.writeFieldName("group_external_id");
                g.writeString(x.groupExternalId);
            }
        }
    };

    public static final JsonReader<GroupCreateArg> _JSON_READER = new JsonReader<GroupCreateArg>() {
        public final GroupCreateArg read(JsonParser parser) throws IOException, JsonReadException {
            GroupCreateArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupCreateArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String groupName = null;
            String groupExternalId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group_name".equals(fieldName)) {
                    groupName = JsonReader.StringReader
                        .readField(parser, "group_name", groupName);
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
            return new GroupCreateArg(groupName, groupExternalId);
        }
    };
}
