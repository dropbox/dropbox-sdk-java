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
 * Defines the access levels for collaborators.
 */
public enum AccessLevel {
    // union AccessLevel
    /**
     * The collaborator is the owner of the shared folder. Owners can view and
     * edit the shared folder as well as set the folder's policies using {@link
     * DbxSharing#updateFolderPolicy(String)}.
     */
    OWNER,
    /**
     * The collaborator can both view and edit the shared folder.
     */
    EDITOR,
    /**
     * The collaborator can only view the shared folder.
     */
    VIEWER,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, AccessLevel> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, AccessLevel>();
        VALUES_.put("owner", OWNER);
        VALUES_.put("editor", EDITOR);
        VALUES_.put("viewer", VIEWER);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static AccessLevel fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AccessLevel> _JSON_WRITER = new JsonWriter<AccessLevel>() {
        public void write(AccessLevel x, JsonGenerator g) throws IOException {
            switch (x) {
                case OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("owner");
                    g.writeEndObject();
                    break;
                case EDITOR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("editor");
                    g.writeEndObject();
                    break;
                case VIEWER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("viewer");
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

    public static final JsonReader<AccessLevel> _JSON_READER = new JsonReader<AccessLevel>() {
        public final AccessLevel read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
