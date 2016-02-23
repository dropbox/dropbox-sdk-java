/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Policy governing who can be a member of a shared folder. Only applicable to
 * folders owned by a user on a team.
 */
public enum MemberPolicy {
    // union MemberPolicy
    /**
     * Only a teammate can become a member.
     */
    TEAM,
    /**
     * Anyone can become a member.
     */
    ANYONE,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, MemberPolicy> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MemberPolicy>();
        VALUES_.put("team", TEAM);
        VALUES_.put("anyone", ANYONE);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MemberPolicy fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberPolicy> _JSON_WRITER = new JsonWriter<MemberPolicy>() {
        public void write(MemberPolicy x, JsonGenerator g) throws IOException {
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

    public static final JsonReader<MemberPolicy> _JSON_READER = new JsonReader<MemberPolicy>() {
        public final MemberPolicy read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
