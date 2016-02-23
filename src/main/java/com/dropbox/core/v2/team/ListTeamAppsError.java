/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Error returned by {@link DbxTeam#linkedAppsListTeamLinkedApps()}
 */
public enum ListTeamAppsError {
    // union ListTeamAppsError
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxTeam#linkedAppsListTeamLinkedApps()} again with an empty cursor to
     * obtain a new cursor.
     */
    RESET,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, ListTeamAppsError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, ListTeamAppsError>();
        VALUES_.put("reset", RESET);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListTeamAppsError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListTeamAppsError> _JSON_WRITER = new JsonWriter<ListTeamAppsError>() {
        public void write(ListTeamAppsError x, JsonGenerator g) throws IOException {
            switch (x) {
                case RESET:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("reset");
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

    public static final JsonReader<ListTeamAppsError> _JSON_READER = new JsonReader<ListTeamAppsError>() {
        public final ListTeamAppsError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
