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
 * Policy governing which shared folders a team member can join.
 */
public enum SharedFolderJoinPolicy {
    // union SharedFolderJoinPolicy
    /**
     * Team members can only join folders shared by teammates.
     */
    FROM_TEAM_ONLY,
    /**
     * Team members can join any shared folder, including those shared by users
     * outside the team.
     */
    FROM_ANYONE,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, SharedFolderJoinPolicy> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharedFolderJoinPolicy>();
        VALUES_.put("from_team_only", FROM_TEAM_ONLY);
        VALUES_.put("from_anyone", FROM_ANYONE);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedFolderJoinPolicy fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedFolderJoinPolicy> _JSON_WRITER = new JsonWriter<SharedFolderJoinPolicy>() {
        public void write(SharedFolderJoinPolicy x, JsonGenerator g) throws IOException {
            switch (x) {
                case FROM_TEAM_ONLY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("from_team_only");
                    g.writeEndObject();
                    break;
                case FROM_ANYONE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("from_anyone");
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

    public static final JsonReader<SharedFolderJoinPolicy> _JSON_READER = new JsonReader<SharedFolderJoinPolicy>() {
        public final SharedFolderJoinPolicy read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
