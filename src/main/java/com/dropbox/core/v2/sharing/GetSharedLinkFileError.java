/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum GetSharedLinkFileError {
    // union GetSharedLinkFileError
    /**
     * The shared link wasn't found
     */
    SHARED_LINK_NOT_FOUND,
    /**
     * The caller is not allowed to access this shared link
     */
    SHARED_LINK_ACCESS_DENIED,
    /**
     * An unspecified error
     */
    OTHER,
    /**
     * Directories cannot be retrieved by this endpoint.
     */
    SHARED_LINK_IS_DIRECTORY;

    private static final java.util.HashMap<String, GetSharedLinkFileError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GetSharedLinkFileError>();
        VALUES_.put("shared_link_is_directory", SHARED_LINK_IS_DIRECTORY);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GetSharedLinkFileError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetSharedLinkFileError> _JSON_WRITER = new JsonWriter<GetSharedLinkFileError>() {
        public void write(GetSharedLinkFileError x, JsonGenerator g) throws IOException {
            switch (x) {
                case SHARED_LINK_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_link_not_found");
                    g.writeEndObject();
                    break;
                case SHARED_LINK_ACCESS_DENIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_link_access_denied");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
                case SHARED_LINK_IS_DIRECTORY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_link_is_directory");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GetSharedLinkFileError> _JSON_READER = new JsonReader<GetSharedLinkFileError>() {
        public final GetSharedLinkFileError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
