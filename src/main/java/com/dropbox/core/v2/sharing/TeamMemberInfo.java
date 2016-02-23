/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Information about a team member.
 */
public class TeamMemberInfo {
    // struct TeamMemberInfo

    private final Team teamInfo;
    private final String displayName;
    private final String memberId;

    /**
     * Information about a team member.
     *
     * @param teamInfo  Information about the member's team. Must not be {@code
     *     null}.
     * @param displayName  The display name of the user. Must not be {@code
     *     null}.
     * @param memberId  ID of user as a member of a team. This field will only
     *     be present if the member is in the same team as current user.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo(Team teamInfo, String displayName, String memberId) {
        if (teamInfo == null) {
            throw new IllegalArgumentException("Required value for 'teamInfo' is null");
        }
        this.teamInfo = teamInfo;
        if (displayName == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = displayName;
        this.memberId = memberId;
    }

    /**
     * Information about a team member.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamInfo  Information about the member's team. Must not be {@code
     *     null}.
     * @param displayName  The display name of the user. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo(Team teamInfo, String displayName) {
        this(teamInfo, displayName, null);
    }

    /**
     * Information about the member's team
     *
     * @return value for this field, never {@code null}.
     */
    public Team getTeamInfo() {
        return teamInfo;
    }

    /**
     * The display name of the user.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * ID of user as a member of a team. This field will only be present if the
     * member is in the same team as current user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getMemberId() {
        return memberId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamInfo,
            displayName,
            memberId
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
            return ((this.teamInfo == other.teamInfo) || (this.teamInfo.equals(other.teamInfo)))
                && ((this.displayName == other.displayName) || (this.displayName.equals(other.displayName)))
                && ((this.memberId == other.memberId) || (this.memberId != null && this.memberId.equals(other.memberId)))
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
            g.writeFieldName("team_info");
            Team._JSON_WRITER.write(x.teamInfo, g);
            g.writeFieldName("display_name");
            g.writeString(x.displayName);
            if (x.memberId != null) {
                g.writeFieldName("member_id");
                g.writeString(x.memberId);
            }
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
            Team teamInfo = null;
            String displayName = null;
            String memberId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("team_info".equals(fieldName)) {
                    teamInfo = Team._JSON_READER
                        .readField(parser, "team_info", teamInfo);
                }
                else if ("display_name".equals(fieldName)) {
                    displayName = JsonReader.StringReader
                        .readField(parser, "display_name", displayName);
                }
                else if ("member_id".equals(fieldName)) {
                    memberId = JsonReader.StringReader
                        .readField(parser, "member_id", memberId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (teamInfo == null) {
                throw new JsonReadException("Required field \"team_info\" is missing.", parser.getTokenLocation());
            }
            if (displayName == null) {
                throw new JsonReadException("Required field \"display_name\" is missing.", parser.getTokenLocation());
            }
            return new TeamMemberInfo(teamInfo, displayName, memberId);
        }
    };
}
