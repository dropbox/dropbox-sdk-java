/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class MembersSetPermissionsResult {
    // struct MembersSetPermissionsResult

    private final String teamMemberId;
    private final AdminTier role;

    /**
     *
     * @param teamMemberId  The member ID of the user to which the change was
     *     applied. Must not be {@code null}.
     * @param role  The role after the change. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissionsResult(String teamMemberId, AdminTier role) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
    }

    /**
     * The member ID of the user to which the change was applied.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * The role after the change.
     *
     * @return value for this field, never {@code null}.
     */
    public AdminTier getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamMemberId,
            role
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
            MembersSetPermissionsResult other = (MembersSetPermissionsResult) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.role == other.role) || (this.role.equals(other.role)))
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

    public static MembersSetPermissionsResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersSetPermissionsResult> _JSON_WRITER = new JsonWriter<MembersSetPermissionsResult>() {
        public final void write(MembersSetPermissionsResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersSetPermissionsResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersSetPermissionsResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("team_member_id");
            g.writeString(x.teamMemberId);
            g.writeFieldName("role");
            AdminTier._JSON_WRITER.write(x.role, g);
        }
    };

    public static final JsonReader<MembersSetPermissionsResult> _JSON_READER = new JsonReader<MembersSetPermissionsResult>() {
        public final MembersSetPermissionsResult read(JsonParser parser) throws IOException, JsonReadException {
            MembersSetPermissionsResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersSetPermissionsResult readFields(JsonParser parser) throws IOException, JsonReadException {
            String teamMemberId = null;
            AdminTier role = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else if ("role".equals(fieldName)) {
                    role = AdminTier._JSON_READER
                        .readField(parser, "role", role);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (teamMemberId == null) {
                throw new JsonReadException("Required field \"team_member_id\" is missing.", parser.getTokenLocation());
            }
            if (role == null) {
                throw new JsonReadException("Required field \"role\" is missing.", parser.getTokenLocation());
            }
            return new MembersSetPermissionsResult(teamMemberId, role);
        }
    };
}
