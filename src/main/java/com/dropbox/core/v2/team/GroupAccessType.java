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
 * Role of a user in group.
 */
public enum GroupAccessType {
    // union GroupAccessType
    /**
     * User is a member of the group, but has no special permissions.
     */
    MEMBER,
    /**
     * A group owner can rename the group, and add/remove members.
     */
    OWNER;

    private static final java.util.HashMap<String, GroupAccessType> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupAccessType>();
        VALUES_.put("member", MEMBER);
        VALUES_.put("owner", OWNER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupAccessType fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupAccessType> _JSON_WRITER = new JsonWriter<GroupAccessType>() {
        public void write(GroupAccessType x, JsonGenerator g) throws IOException {
            switch (x) {
                case MEMBER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("member");
                    g.writeEndObject();
                    break;
                case OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("owner");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupAccessType> _JSON_READER = new JsonReader<GroupAccessType>() {
        public final GroupAccessType read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
