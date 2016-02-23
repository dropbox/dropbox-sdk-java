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
 * Actions that may be taken on shared folders.
 */
public enum FolderAction {
    // union FolderAction
    /**
     * Change folder options, such as who can be invited to join the folder.
     */
    CHANGE_OPTIONS,
    /**
     * Change or edit contents of the folder.
     */
    EDIT_CONTENTS,
    /**
     * Unmount the folder.
     */
    UNMOUNT,
    /**
     * Stop sharing this folder.
     */
    UNSHARE,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, FolderAction> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, FolderAction>();
        VALUES_.put("change_options", CHANGE_OPTIONS);
        VALUES_.put("edit_contents", EDIT_CONTENTS);
        VALUES_.put("unmount", UNMOUNT);
        VALUES_.put("unshare", UNSHARE);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static FolderAction fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FolderAction> _JSON_WRITER = new JsonWriter<FolderAction>() {
        public void write(FolderAction x, JsonGenerator g) throws IOException {
            switch (x) {
                case CHANGE_OPTIONS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("change_options");
                    g.writeEndObject();
                    break;
                case EDIT_CONTENTS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("edit_contents");
                    g.writeEndObject();
                    break;
                case UNMOUNT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unmount");
                    g.writeEndObject();
                    break;
                case UNSHARE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unshare");
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

    public static final JsonReader<FolderAction> _JSON_READER = new JsonReader<FolderAction>() {
        public final FolderAction read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
