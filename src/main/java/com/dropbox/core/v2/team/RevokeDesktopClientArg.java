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

public class RevokeDesktopClientArg extends DeviceSessionArg {
    // struct RevokeDesktopClientArg

    private final boolean deleteOnUnlink;

    /**
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param deleteOnUnlink  Whether to delete all files of the account (this
     *     is possible only if supported by the desktop client and  will be made
     *     the next time the client access the account).
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDesktopClientArg(String sessionId, String teamMemberId, boolean deleteOnUnlink) {
        super(sessionId, teamMemberId);
        this.deleteOnUnlink = deleteOnUnlink;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDesktopClientArg(String sessionId, String teamMemberId) {
        this(sessionId, teamMemberId, false);
    }

    /**
     * Whether to delete all files of the account (this is possible only if
     * supported by the desktop client and  will be made the next time the
     * client access the account)
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getDeleteOnUnlink() {
        return deleteOnUnlink;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            deleteOnUnlink
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            RevokeDesktopClientArg other = (RevokeDesktopClientArg) obj;
            return (this.deleteOnUnlink == other.deleteOnUnlink)
                && ((this.getSessionId() == other.getSessionId()) || (this.getSessionId().equals(other.getSessionId())))
                && ((this.getTeamMemberId() == other.getTeamMemberId()) || (this.getTeamMemberId().equals(other.getTeamMemberId())))
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

    public static RevokeDesktopClientArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeDesktopClientArg> _JSON_WRITER = new JsonWriter<RevokeDesktopClientArg>() {
        public final void write(RevokeDesktopClientArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DeviceSessionArg._JSON_WRITER.writeFields(x, g);
            RevokeDesktopClientArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeDesktopClientArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("delete_on_unlink");
            g.writeBoolean(x.deleteOnUnlink);
        }
    };

    public static final JsonReader<RevokeDesktopClientArg> _JSON_READER = new JsonReader<RevokeDesktopClientArg>() {
        public final RevokeDesktopClientArg read(JsonParser parser) throws IOException, JsonReadException {
            RevokeDesktopClientArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeDesktopClientArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sessionId = null;
            String teamMemberId = null;
            Boolean deleteOnUnlink = null;
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
                else if ("delete_on_unlink".equals(fieldName)) {
                    deleteOnUnlink = JsonReader.BooleanReader
                        .readField(parser, "delete_on_unlink", deleteOnUnlink);
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
            return new RevokeDesktopClientArg(sessionId, teamMemberId, deleteOnUnlink);
        }
    };
}
