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
 * Arguments for {@link DbxTeam#linkedAppsListTeamLinkedApps()}.
 */
public class ListTeamAppsArg {
    // struct ListTeamAppsArg

    private final String cursor;

    /**
     * Arguments for {@link DbxTeam#linkedAppsListTeamLinkedApps()}.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeam#linkedAppsListTeamLinkedApps()} the cursor shouldn't be
     *     passed. Then, if the result of the call includes a cursor, the
     *     following requests should include the received cursors in order to
     *     receive the next sub list of the team applications.
     */
    public ListTeamAppsArg(String cursor) {
        this.cursor = cursor;
    }

    /**
     * Arguments for {@link DbxTeam#linkedAppsListTeamLinkedApps()}.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListTeamAppsArg() {
        this(null);
    }

    /**
     * At the first call to the {@link DbxTeam#linkedAppsListTeamLinkedApps()}
     * the cursor shouldn't be passed. Then, if the result of the call includes
     * a cursor, the following requests should include the received cursors in
     * order to receive the next sub list of the team applications
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ListTeamAppsArg other = (ListTeamAppsArg) obj;
            return (this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor));
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListTeamAppsArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListTeamAppsArg> _JSON_WRITER = new JsonWriter<ListTeamAppsArg>() {
        public final void write(ListTeamAppsArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListTeamAppsArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListTeamAppsArg x, JsonGenerator g) throws IOException {
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
        }
    };

    public static final JsonReader<ListTeamAppsArg> _JSON_READER = new JsonReader<ListTeamAppsArg>() {
        public final ListTeamAppsArg read(JsonParser parser) throws IOException, JsonReadException {
            ListTeamAppsArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListTeamAppsArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new ListTeamAppsArg(cursor);
        }
    };
}
