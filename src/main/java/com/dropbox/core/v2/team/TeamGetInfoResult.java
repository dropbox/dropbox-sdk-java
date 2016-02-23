/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class TeamGetInfoResult {
    // struct TeamGetInfoResult

    private final String name;
    private final String teamId;
    private final long numLicensedUsers;
    private final long numProvisionedUsers;
    private final TeamPolicies policies;

    /**
     *
     * @param name  The name of the team. Must not be {@code null}.
     * @param teamId  The ID of the team. Must not be {@code null}.
     * @param numLicensedUsers  The number of licenses available to the team.
     * @param numProvisionedUsers  The number of accounts that have been invited
     *     or are already active members of the team.
     * @param policies  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamGetInfoResult(String name, String teamId, long numLicensedUsers, long numProvisionedUsers, TeamPolicies policies) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (teamId == null) {
            throw new IllegalArgumentException("Required value for 'teamId' is null");
        }
        this.teamId = teamId;
        this.numLicensedUsers = numLicensedUsers;
        this.numProvisionedUsers = numProvisionedUsers;
        if (policies == null) {
            throw new IllegalArgumentException("Required value for 'policies' is null");
        }
        this.policies = policies;
    }

    /**
     * The name of the team.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * The ID of the team.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * The number of licenses available to the team.
     *
     * @return value for this field.
     */
    public long getNumLicensedUsers() {
        return numLicensedUsers;
    }

    /**
     * The number of accounts that have been invited or are already active
     * members of the team.
     *
     * @return value for this field.
     */
    public long getNumProvisionedUsers() {
        return numProvisionedUsers;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public TeamPolicies getPolicies() {
        return policies;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            name,
            teamId,
            numLicensedUsers,
            numProvisionedUsers,
            policies
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
            TeamGetInfoResult other = (TeamGetInfoResult) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.teamId == other.teamId) || (this.teamId.equals(other.teamId)))
                && (this.numLicensedUsers == other.numLicensedUsers)
                && (this.numProvisionedUsers == other.numProvisionedUsers)
                && ((this.policies == other.policies) || (this.policies.equals(other.policies)))
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

    public static TeamGetInfoResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TeamGetInfoResult> _JSON_WRITER = new JsonWriter<TeamGetInfoResult>() {
        public final void write(TeamGetInfoResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            TeamGetInfoResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(TeamGetInfoResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("name");
            g.writeString(x.name);
            g.writeFieldName("team_id");
            g.writeString(x.teamId);
            g.writeFieldName("num_licensed_users");
            g.writeNumber(x.numLicensedUsers);
            g.writeFieldName("num_provisioned_users");
            g.writeNumber(x.numProvisionedUsers);
            g.writeFieldName("policies");
            TeamPolicies._JSON_WRITER.write(x.policies, g);
        }
    };

    public static final JsonReader<TeamGetInfoResult> _JSON_READER = new JsonReader<TeamGetInfoResult>() {
        public final TeamGetInfoResult read(JsonParser parser) throws IOException, JsonReadException {
            TeamGetInfoResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final TeamGetInfoResult readFields(JsonParser parser) throws IOException, JsonReadException {
            String name = null;
            String teamId = null;
            Long numLicensedUsers = null;
            Long numProvisionedUsers = null;
            TeamPolicies policies = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("name".equals(fieldName)) {
                    name = JsonReader.StringReader
                        .readField(parser, "name", name);
                }
                else if ("team_id".equals(fieldName)) {
                    teamId = JsonReader.StringReader
                        .readField(parser, "team_id", teamId);
                }
                else if ("num_licensed_users".equals(fieldName)) {
                    numLicensedUsers = JsonReader.UInt32Reader
                        .readField(parser, "num_licensed_users", numLicensedUsers);
                }
                else if ("num_provisioned_users".equals(fieldName)) {
                    numProvisionedUsers = JsonReader.UInt32Reader
                        .readField(parser, "num_provisioned_users", numProvisionedUsers);
                }
                else if ("policies".equals(fieldName)) {
                    policies = TeamPolicies._JSON_READER
                        .readField(parser, "policies", policies);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (teamId == null) {
                throw new JsonReadException("Required field \"team_id\" is missing.", parser.getTokenLocation());
            }
            if (numLicensedUsers == null) {
                throw new JsonReadException("Required field \"num_licensed_users\" is missing.", parser.getTokenLocation());
            }
            if (numProvisionedUsers == null) {
                throw new JsonReadException("Required field \"num_provisioned_users\" is missing.", parser.getTokenLocation());
            }
            if (policies == null) {
                throw new JsonReadException("Required field \"policies\" is missing.", parser.getTokenLocation());
            }
            return new TeamGetInfoResult(name, teamId, numLicensedUsers, numProvisionedUsers, policies);
        }
    };
}
