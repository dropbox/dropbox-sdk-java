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

public enum RevokeSharedLinkError {
    // union RevokeSharedLinkError
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
     * Shared link is malformed.
     */
    SHARED_LINK_MALFORMED;

    private static final java.util.HashMap<String, RevokeSharedLinkError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, RevokeSharedLinkError>();
        VALUES_.put("shared_link_malformed", SHARED_LINK_MALFORMED);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeSharedLinkError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeSharedLinkError> _JSON_WRITER = new JsonWriter<RevokeSharedLinkError>() {
        public void write(RevokeSharedLinkError x, JsonGenerator g) throws IOException {
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
                case SHARED_LINK_MALFORMED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_link_malformed");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<RevokeSharedLinkError> _JSON_READER = new JsonReader<RevokeSharedLinkError>() {
        public final RevokeSharedLinkError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
