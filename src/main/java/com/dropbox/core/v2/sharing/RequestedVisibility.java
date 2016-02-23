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

/**
 * The access permission that can be requested by the caller for the shared
 * link. Note that the final resolved visibility of the shared link takes into
 * account other aspects, such as team and shared folder settings. Check the
 * {@link ResolvedVisibility} for more info on the possible resolved visibility
 * values of shared links.
 */
public enum RequestedVisibility {
    // union RequestedVisibility
    /**
     * Anyone who has received the link can access it. No login required.
     */
    PUBLIC,
    /**
     * Only members of the same team can access the link. Login is required.
     */
    TEAM_ONLY,
    /**
     * A link-specific password is required to access the link. Login is not
     * required.
     */
    PASSWORD;

    private static final java.util.HashMap<String, RequestedVisibility> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, RequestedVisibility>();
        VALUES_.put("public", PUBLIC);
        VALUES_.put("team_only", TEAM_ONLY);
        VALUES_.put("password", PASSWORD);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RequestedVisibility fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RequestedVisibility> _JSON_WRITER = new JsonWriter<RequestedVisibility>() {
        public void write(RequestedVisibility x, JsonGenerator g) throws IOException {
            switch (x) {
                case PUBLIC:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("public");
                    g.writeEndObject();
                    break;
                case TEAM_ONLY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_only");
                    g.writeEndObject();
                    break;
                case PASSWORD:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("password");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<RequestedVisibility> _JSON_READER = new JsonReader<RequestedVisibility>() {
        public final RequestedVisibility read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
