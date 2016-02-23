/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Policy governing who can be a member of a folder shared by a team member.
 */
public enum SharedFolderMemberPolicy {
    // union SharedFolderMemberPolicy
    /**
     * Only a teammate can be a member of a folder shared by a team member.
     */
    TEAM,
    /**
     * Anyone can be a member of a folder shared by a team member.
     */
    ANYONE,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, SharedFolderMemberPolicy> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharedFolderMemberPolicy>();
        VALUES_.put("team", TEAM);
        VALUES_.put("anyone", ANYONE);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedFolderMemberPolicy fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedFolderMemberPolicy> _JSON_WRITER = new JsonWriter<SharedFolderMemberPolicy>() {
        public void write(SharedFolderMemberPolicy x, JsonGenerator g) throws IOException {
            switch (x) {
                case TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team");
                    g.writeEndObject();
                    break;
                case ANYONE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("anyone");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<SharedFolderMemberPolicy> _JSON_READER = new JsonReader<SharedFolderMemberPolicy>() {
        public final SharedFolderMemberPolicy read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
