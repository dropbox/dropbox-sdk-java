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
 * Error that can be raised when {@link GroupMemberSelector} is used, and the
 * user is required to be a member of the specified group.
 */
public enum GroupMemberSelectorError {
    // union GroupMemberSelectorError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * The specified user is not a member of this group.
     */
    MEMBER_NOT_IN_GROUP;

    private static final java.util.HashMap<String, GroupMemberSelectorError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupMemberSelectorError>();
        VALUES_.put("member_not_in_group", MEMBER_NOT_IN_GROUP);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupMemberSelectorError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMemberSelectorError> _JSON_WRITER = new JsonWriter<GroupMemberSelectorError>() {
        public void write(GroupMemberSelectorError x, JsonGenerator g) throws IOException {
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
            }
        }
    };

    public static final JsonReader<GroupMemberSelectorError> _JSON_READER = new JsonReader<GroupMemberSelectorError>() {
        public final GroupMemberSelectorError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
