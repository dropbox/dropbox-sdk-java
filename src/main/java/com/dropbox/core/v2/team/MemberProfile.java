/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.v2.users.Name;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Basic member profile.
 */
public class MemberProfile {
    // struct MemberProfile

    private final String teamMemberId;
    private final String externalId;
    private final String email;
    private final boolean emailVerified;
    private final TeamMemberStatus status;
    private final Name name;

    /**
     * Basic member profile.
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
     * @param externalId  External ID that a team can attach to the user. An
     *     application using the API may find it easier to use their own IDs
     *     instead of Dropbox IDs like account_id or team_member_id.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name, String externalId) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        this.externalId = externalId;
        if (email == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        this.email = email;
        this.emailVerified = emailVerified;
        if (status == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = status;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
    }

    /**
     * Basic member profile.
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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberProfile(String teamMemberId, String email, boolean emailVerified, TeamMemberStatus status, Name name) {
        this(teamMemberId, email, emailVerified, status, name, null);
    }

    /**
     * ID of user as a member of a team.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * External ID that a team can attach to the user. An application using the
     * API may find it easier to use their own IDs instead of Dropbox IDs like
     * account_id or team_member_id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Email address of user.
     *
     * @return value for this field, never {@code null}.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Is true if the user's email is verified to be owned by the user.
     *
     * @return value for this field.
     */
    public boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     * The user's status as a member of a specific team.
     *
     * @return value for this field, never {@code null}.
     */
    public TeamMemberStatus getStatus() {
        return status;
    }

    /**
     * Representations for a person's name.
     *
     * @return value for this field, never {@code null}.
     */
    public Name getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamMemberId,
            externalId,
            email,
            emailVerified,
            status,
            name
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
            MemberProfile other = (MemberProfile) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.externalId == other.externalId) || (this.externalId != null && this.externalId.equals(other.externalId)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.emailVerified == other.emailVerified)
                && ((this.status == other.status) || (this.status.equals(other.status)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
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

    public static MemberProfile fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberProfile> _JSON_WRITER = new JsonWriter<MemberProfile>() {
        public final void write(MemberProfile x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MemberProfile._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MemberProfile x, JsonGenerator g) throws IOException {
            g.writeFieldName("team_member_id");
            g.writeString(x.teamMemberId);
            if (x.externalId != null) {
                g.writeFieldName("external_id");
                g.writeString(x.externalId);
            }
            g.writeFieldName("email");
            g.writeString(x.email);
            g.writeFieldName("email_verified");
            g.writeBoolean(x.emailVerified);
            g.writeFieldName("status");
            TeamMemberStatus._JSON_WRITER.write(x.status, g);
            g.writeFieldName("name");
            Name._JSON_WRITER.write(x.name, g);
        }
    };

    public static final JsonReader<MemberProfile> _JSON_READER = new JsonReader<MemberProfile>() {
        public final MemberProfile read(JsonParser parser) throws IOException, JsonReadException {
            MemberProfile result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MemberProfile readFields(JsonParser parser) throws IOException, JsonReadException {
            String teamMemberId = null;
            String email = null;
            Boolean emailVerified = null;
            TeamMemberStatus status = null;
            Name name = null;
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
            return new MemberProfile(teamMemberId, email, emailVerified, status, name, externalId);
        }
    };
}
