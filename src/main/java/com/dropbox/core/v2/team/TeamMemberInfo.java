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

/**
 * Information about a team member.
 */
public class TeamMemberInfo {
    // struct TeamMemberInfo

    private final TeamMemberProfile profile;
    private final AdminTier role;

    /**
     * Information about a team member.
     *
     * @param profile  Profile of a user as a member of a team. Must not be
     *     {@code null}.
     * @param role  The user's role in the team. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo(TeamMemberProfile profile, AdminTier role) {
        if (profile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = profile;
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
    }

    /**
     * Profile of a user as a member of a team.
     *
     * @return value for this field, never {@code null}.
     */
    public TeamMemberProfile getProfile() {
        return profile;
    }

    /**
     * The user's role in the team.
     *
     * @return value for this field, never {@code null}.
     */
    public AdminTier getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            profile,
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
            TeamMemberInfo other = (TeamMemberInfo) obj;
            return ((this.profile == other.profile) || (this.profile.equals(other.profile)))
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

    public static TeamMemberInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TeamMemberInfo> _JSON_WRITER = new JsonWriter<TeamMemberInfo>() {
        public final void write(TeamMemberInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            TeamMemberInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(TeamMemberInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("profile");
            TeamMemberProfile._JSON_WRITER.write(x.profile, g);
            g.writeFieldName("role");
            AdminTier._JSON_WRITER.write(x.role, g);
        }
    };

    public static final JsonReader<TeamMemberInfo> _JSON_READER = new JsonReader<TeamMemberInfo>() {
        public final TeamMemberInfo read(JsonParser parser) throws IOException, JsonReadException {
            TeamMemberInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final TeamMemberInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            TeamMemberProfile profile = null;
            AdminTier role = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("profile".equals(fieldName)) {
                    profile = TeamMemberProfile._JSON_READER
                        .readField(parser, "profile", profile);
                }
                else if ("role".equals(fieldName)) {
                    role = AdminTier._JSON_READER
                        .readField(parser, "role", role);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (profile == null) {
                throw new JsonReadException("Required field \"profile\" is missing.", parser.getTokenLocation());
            }
            if (role == null) {
                throw new JsonReadException("Required field \"role\" is missing.", parser.getTokenLocation());
            }
            return new TeamMemberInfo(profile, role);
        }
    };
}
