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
 * Who can access a shared link. The most open visibility is {@link
 * Visibility#PUBLIC}. The default depends on many aspects, such as team and
 * user preferences and shared folder settings.
 */
public enum Visibility {
    // union Visibility
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
     * access the link.
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

    private static final java.util.HashMap<String, Visibility> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Visibility>();
        VALUES_.put("public", PUBLIC);
        VALUES_.put("team_only", TEAM_ONLY);
        VALUES_.put("password", PASSWORD);
        VALUES_.put("team_and_password", TEAM_AND_PASSWORD);
        VALUES_.put("shared_folder_only", SHARED_FOLDER_ONLY);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static Visibility fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<Visibility> _JSON_WRITER = new JsonWriter<Visibility>() {
        public void write(Visibility x, JsonGenerator g) throws IOException {
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

    public static final JsonReader<Visibility> _JSON_READER = new JsonReader<Visibility>() {
        public final Visibility read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
