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
 * Policy governing who can view shared links.
 */
public enum SharedLinkPolicy {
    // union SharedLinkPolicy
    /**
     * Links can be shared with anyone.
     */
    ANYONE,
    /**
     * Links can only be shared among members of the shared folder.
     */
    MEMBERS,
    /**
     * An unknown shared link policy.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, SharedLinkPolicy> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharedLinkPolicy>();
        VALUES_.put("anyone", ANYONE);
        VALUES_.put("members", MEMBERS);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedLinkPolicy fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedLinkPolicy> _JSON_WRITER = new JsonWriter<SharedLinkPolicy>() {
        public void write(SharedLinkPolicy x, JsonGenerator g) throws IOException {
            switch (x) {
                case ANYONE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("anyone");
                    g.writeEndObject();
                    break;
                case MEMBERS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("members");
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

    public static final JsonReader<SharedLinkPolicy> _JSON_READER = new JsonReader<SharedLinkPolicy>() {
        public final SharedLinkPolicy read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
