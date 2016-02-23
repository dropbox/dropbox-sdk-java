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

public enum ListFoldersContinueError {
    // union ListFoldersContinueError
    /**
     * {@link ListFoldersContinueArg#getCursor} is invalid.
     */
    INVALID_CURSOR,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, ListFoldersContinueError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, ListFoldersContinueError>();
        VALUES_.put("invalid_cursor", INVALID_CURSOR);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListFoldersContinueError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFoldersContinueError> _JSON_WRITER = new JsonWriter<ListFoldersContinueError>() {
        public void write(ListFoldersContinueError x, JsonGenerator g) throws IOException {
            switch (x) {
                case INVALID_CURSOR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_cursor");
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

    public static final JsonReader<ListFoldersContinueError> _JSON_READER = new JsonReader<ListFoldersContinueError>() {
        public final ListFoldersContinueError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
