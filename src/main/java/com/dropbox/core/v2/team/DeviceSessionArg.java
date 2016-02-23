/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class DeviceSessionArg {
    // struct DeviceSessionArg

    private final String sessionId;
    private final String teamMemberId;

    /**
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceSessionArg(String sessionId, String teamMemberId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
    }

    /**
     * The session id
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The unique id of the member owning the device
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sessionId,
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
            DeviceSessionArg other = (DeviceSessionArg) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                ;
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

    public static DeviceSessionArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DeviceSessionArg> _JSON_WRITER = new JsonWriter<DeviceSessionArg>() {
        public final void write(DeviceSessionArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DeviceSessionArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(DeviceSessionArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("session_id");
            g.writeString(x.sessionId);
            g.writeFieldName("team_member_id");
            g.writeString(x.teamMemberId);
        }
    };

    public static final JsonReader<DeviceSessionArg> _JSON_READER = new JsonReader<DeviceSessionArg>() {
        public final DeviceSessionArg read(JsonParser parser) throws IOException, JsonReadException {
            DeviceSessionArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final DeviceSessionArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sessionId = null;
            String teamMemberId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("session_id".equals(fieldName)) {
                    sessionId = JsonReader.StringReader
                        .readField(parser, "session_id", sessionId);
                }
                else if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sessionId == null) {
                throw new JsonReadException("Required field \"session_id\" is missing.", parser.getTokenLocation());
            }
            if (teamMemberId == null) {
                throw new JsonReadException("Required field \"team_member_id\" is missing.", parser.getTokenLocation());
            }
            return new DeviceSessionArg(sessionId, teamMemberId);
        }
    };
}
