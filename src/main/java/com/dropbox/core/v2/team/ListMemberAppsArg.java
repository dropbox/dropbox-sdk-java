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

public class ListMemberAppsArg {
    // struct ListMemberAppsArg

    private final String teamMemberId;

    /**
     *
     * @param teamMemberId  The team member id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberAppsArg(String teamMemberId) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
    }

    /**
     * The team member id
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamMemberId
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
            ListMemberAppsArg other = (ListMemberAppsArg) obj;
            return (this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId));
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

    public static ListMemberAppsArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListMemberAppsArg> _JSON_WRITER = new JsonWriter<ListMemberAppsArg>() {
        public final void write(ListMemberAppsArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListMemberAppsArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListMemberAppsArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("team_member_id");
            g.writeString(x.teamMemberId);
        }
    };

    public static final JsonReader<ListMemberAppsArg> _JSON_READER = new JsonReader<ListMemberAppsArg>() {
        public final ListMemberAppsArg read(JsonParser parser) throws IOException, JsonReadException {
            ListMemberAppsArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListMemberAppsArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String teamMemberId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (teamMemberId == null) {
                throw new JsonReadException("Required field \"team_member_id\" is missing.", parser.getTokenLocation());
            }
            return new ListMemberAppsArg(teamMemberId);
        }
    };
}
