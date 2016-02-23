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
 * Policy governing who can change a shared folder's access control list (ACL).
 * In other words, who can add, remove, or change the privileges of members.
 */
public enum AclUpdatePolicy {
    // union AclUpdatePolicy
    /**
     * Only the owner can update the ACL.
     */
    OWNER,
    /**
     * Any editor can update the ACL. This may be further restricted to editors
     * on the same team.
     */
    EDITORS,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, AclUpdatePolicy> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, AclUpdatePolicy>();
        VALUES_.put("owner", OWNER);
        VALUES_.put("editors", EDITORS);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static AclUpdatePolicy fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AclUpdatePolicy> _JSON_WRITER = new JsonWriter<AclUpdatePolicy>() {
        public void write(AclUpdatePolicy x, JsonGenerator g) throws IOException {
            switch (x) {
                case OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("owner");
                    g.writeEndObject();
                    break;
                case EDITORS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("editors");
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

    public static final JsonReader<AclUpdatePolicy> _JSON_READER = new JsonReader<AclUpdatePolicy>() {
        public final AclUpdatePolicy read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
