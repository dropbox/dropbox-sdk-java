/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.v2.users.Name;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Profile of a user as a member of a team.
 */
public class TeamMemberProfile extends MemberProfile {
    // struct TeamMemberProfile

    private final List<String> groups;

    /**
     * Profile of a user as a member of a team.
     *
     * @param teamMemberId  ID of user as a member of a team. Must not be {@code
     *     null}.
     * @param email  Email address of user. Must not be {@code null}.
     * @param emailVerified  Is true if the user's email is verified to be owned
     *     by the user.
     * @param status  The user's status as a member of a specific team. Must not
     *     be {@code null}.
     * @param name  Representations for a person's name. Must not be {@code
     *     null}.
     * @param groups  List of group IDs of groups that the user belongs to. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param externalId  External ID that a team can attach to the user. An
     *     application using the API may find it easier to use their own IDs
     *     instead of Dropbox IDs like account_id or team_member_id.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, List<String> groups, String externalId) {
        super(teamMemberId, email, emailVerified, status, name, externalId);
        if (groups == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        for (String x : groups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = groups;
    }

    /**
     * Profile of a user as a member of a team.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamMemberId  ID of user as a member of a team. Must not be {@code
     *     null}.
     * @param email  Email address of user. Must not be {@code null}.
     * @param emailVerified  Is true if the user's email is verified to be owned
     *     by the user.
     * @param status  The user's status as a member of a specific team. Must not
     *     be {@code null}.
     * @param name  Representations for a person's name. Must not be {@code
     *     null}.
     * @param groups  List of group IDs of groups that the user belongs to. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, List<String> groups) {
        this(teamMemberId, email, emailVerified, status, name, groups, null);
    }

    /**
     * List of group IDs of groups that the user belongs to.
     *
     * @return value for this field, never {@code null}.
     */
    public List<String> getGroups() {
        return groups;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            TeamMemberProfile other = (TeamMemberProfile) obj;
            return ((this.groups == other.groups) || (this.groups.equals(other.groups)))
                && ((this.getTeamMemberId() == other.getTeamMemberId()) || (this.getTeamMemberId().equals(other.getTeamMemberId())))
                && ((this.getExternalId() == other.getExternalId()) || (this.getExternalId() != null && this.getExternalId().equals(other.getExternalId())))
                && ((this.getEmail() == other.getEmail()) || (this.getEmail().equals(other.getEmail())))
                && (this.getEmailVerified() == other.getEmailVerified())
                && ((this.getStatus() == other.getStatus()) || (this.getStatus().equals(other.getStatus())))
                && ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
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

    public static TeamMemberProfile fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TeamMemberProfile> _JSON_WRITER = new JsonWriter<TeamMemberProfile>() {
        public final void write(TeamMemberProfile x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MemberProfile._JSON_WRITER.writeFields(x, g);
            TeamMemberProfile._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(TeamMemberProfile x, JsonGenerator g) throws IOException {
            g.writeFieldName("groups");
            g.writeStartArray();
            for (String item: x.groups) {
                if (item != null) {
                    g.writeString(item);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<TeamMemberProfile> _JSON_READER = new JsonReader<TeamMemberProfile>() {
        public final TeamMemberProfile read(JsonParser parser) throws IOException, JsonReadException {
            TeamMemberProfile result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final TeamMemberProfile readFields(JsonParser parser) throws IOException, JsonReadException {
            String teamMemberId = null;
            String email = null;
            Boolean emailVerified = null;
            TeamMemberStatus status = null;
            Name name = null;
            List<String> groups = null;
            String externalId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else if ("email".equals(fieldName)) {
                    email = JsonReader.StringReader
                        .readField(parser, "email", email);
                }
                else if ("email_verified".equals(fieldName)) {
                    emailVerified = JsonReader.BooleanReader
                        .readField(parser, "email_verified", emailVerified);
                }
                else if ("status".equals(fieldName)) {
                    status = TeamMemberStatus._JSON_READER
                        .readField(parser, "status", status);
                }
                else if ("name".equals(fieldName)) {
                    name = Name._JSON_READER
                        .readField(parser, "name", name);
                }
                else if ("groups".equals(fieldName)) {
                    groups = JsonArrayReader.mk(JsonReader.StringReader)
                        .readField(parser, "groups", groups);
                }
                else if ("external_id".equals(fieldName)) {
                    externalId = JsonReader.StringReader
                        .readField(parser, "external_id", externalId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (teamMemberId == null) {
                throw new JsonReadException("Required field \"team_member_id\" is missing.", parser.getTokenLocation());
            }
            if (email == null) {
                throw new JsonReadException("Required field \"email\" is missing.", parser.getTokenLocation());
            }
            if (emailVerified == null) {
                throw new JsonReadException("Required field \"email_verified\" is missing.", parser.getTokenLocation());
            }
            if (status == null) {
                throw new JsonReadException("Required field \"status\" is missing.", parser.getTokenLocation());
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (groups == null) {
                throw new JsonReadException("Required field \"groups\" is missing.", parser.getTokenLocation());
            }
            return new TeamMemberProfile(teamMemberId, email, emailVerified, status, name, groups, externalId);
        }
    };
}
