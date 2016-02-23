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

public enum GroupMembersRemoveError {
    // union GroupMembersRemoveError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * At least one of the specified users is not a member of the group.
     */
    MEMBER_NOT_IN_GROUP,
    /**
     * Group is not in this team. You cannot remove members from a group that is
     * outside of your team.
     */
    GROUP_NOT_IN_TEAM;

    private static final java.util.HashMap<String, GroupMembersRemoveError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupMembersRemoveError>();
        VALUES_.put("group_not_in_team", GROUP_NOT_IN_TEAM);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupMembersRemoveError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMembersRemoveError> _JSON_WRITER = new JsonWriter<GroupMembersRemoveError>() {
        public void write(GroupMembersRemoveError x, JsonGenerator g) throws IOException {
            switch (x) {
                case GROUP_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_not_found");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
                case MEMBER_NOT_IN_GROUP:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("member_not_in_group");
                    g.writeEndObject();
                    break;
                case GROUP_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_not_in_team");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupMembersRemoveError> _JSON_READER = new JsonReader<GroupMembersRemoveError>() {
        public final GroupMembersRemoveError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
