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

public enum SharePathError {
    // union SharePathError
    /**
     * A file is at the specified path.
     */
    IS_FILE,
    /**
     * We do not support sharing a folder inside a shared folder.
     */
    INSIDE_SHARED_FOLDER,
    /**
     * We do not support shared folders that contain shared folders.
     */
    CONTAINS_SHARED_FOLDER,
    /**
     * We do not support sharing an app folder.
     */
    IS_APP_FOLDER,
    /**
     * We do not support sharing a folder inside an app folder.
     */
    INSIDE_APP_FOLDER,
    /**
     * Folder is already shared.
     */
    ALREADY_SHARED,
    /**
     * Path is not valid.
     */
    INVALID_PATH,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, SharePathError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharePathError>();
        VALUES_.put("is_file", IS_FILE);
        VALUES_.put("inside_shared_folder", INSIDE_SHARED_FOLDER);
        VALUES_.put("contains_shared_folder", CONTAINS_SHARED_FOLDER);
        VALUES_.put("is_app_folder", IS_APP_FOLDER);
        VALUES_.put("inside_app_folder", INSIDE_APP_FOLDER);
        VALUES_.put("already_shared", ALREADY_SHARED);
        VALUES_.put("invalid_path", INVALID_PATH);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharePathError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharePathError> _JSON_WRITER = new JsonWriter<SharePathError>() {
        public void write(SharePathError x, JsonGenerator g) throws IOException {
            switch (x) {
                case IS_FILE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("is_file");
                    g.writeEndObject();
                    break;
                case INSIDE_SHARED_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("inside_shared_folder");
                    g.writeEndObject();
                    break;
                case CONTAINS_SHARED_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("contains_shared_folder");
                    g.writeEndObject();
                    break;
                case IS_APP_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("is_app_folder");
                    g.writeEndObject();
                    break;
                case INSIDE_APP_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("inside_app_folder");
                    g.writeEndObject();
                    break;
                case ALREADY_SHARED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("already_shared");
                    g.writeEndObject();
                    break;
                case INVALID_PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_path");
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

    public static final JsonReader<SharePathError> _JSON_READER = new JsonReader<SharePathError>() {
        public final SharePathError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
