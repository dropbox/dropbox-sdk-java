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
 * The actual access permissions values of shared links after taking into
 * account user preferences and the team and shared folder settings. Check the
 * {@link RequestedVisibility} for more info on the possible visibility values
 * that can be set by the shared link's owner.
 */
public enum ResolvedVisibility {
    // union ResolvedVisibility
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
    PASSWORD,
    /**
     * Only members of the same team who have the link-specific password can
     * access the link. Login is required.
     */
    TEAM_AND_PASSWORD,
    /**
     * Only members of the shared folder containing the linked file can access
     * the link. Login is required.
     */
    SHARED_FOLDER_ONLY,
    /**
     * An unknown restriction is in place.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, ResolvedVisibility> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, ResolvedVisibility>();
        VALUES_.put("team_and_password", TEAM_AND_PASSWORD);
        VALUES_.put("shared_folder_only", SHARED_FOLDER_ONLY);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ResolvedVisibility fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ResolvedVisibility> _JSON_WRITER = new JsonWriter<ResolvedVisibility>() {
        public void write(ResolvedVisibility x, JsonGenerator g) throws IOException {
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
                case TEAM_AND_PASSWORD:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_and_password");
                    g.writeEndObject();
                    break;
                case SHARED_FOLDER_ONLY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("shared_folder_only");
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

    public static final JsonReader<ResolvedVisibility> _JSON_READER = new JsonReader<ResolvedVisibility>() {
        public final ResolvedVisibility read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
