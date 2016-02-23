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
 * Actions that may be taken on members of a shared folder.
 */
public enum MemberAction {
    // union MemberAction
    /**
     * Make the member an owner of the folder.
     */
    MAKE_OWNER,
    /**
     * Remove the member from the folder.
     */
    REMOVE,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, MemberAction> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MemberAction>();
        VALUES_.put("make_owner", MAKE_OWNER);
        VALUES_.put("remove", REMOVE);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MemberAction fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberAction> _JSON_WRITER = new JsonWriter<MemberAction>() {
        public void write(MemberAction x, JsonGenerator g) throws IOException {
            switch (x) {
                case MAKE_OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("make_owner");
                    g.writeEndObject();
                    break;
                case REMOVE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("remove");
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

    public static final JsonReader<MemberAction> _JSON_READER = new JsonReader<MemberAction>() {
        public final MemberAction read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
