/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=TeamGetInfoResult.Serializer.class)
@JsonDeserialize(using=TeamGetInfoResult.Deserializer.class)
public class TeamGetInfoResult {
    // struct TeamGetInfoResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String name;
    protected final String teamId;
    protected final long numLicensedUsers;
    protected final long numProvisionedUsers;
    protected final TeamPolicies policies;

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
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<TeamGetInfoResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamGetInfoResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(TeamGetInfoResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TeamGetInfoResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TeamGetInfoResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("name", value.name);
            g.writeObjectField("team_id", value.teamId);
            g.writeObjectField("num_licensed_users", value.numLicensedUsers);
            g.writeObjectField("num_provisioned_users", value.numProvisionedUsers);
            g.writeObjectField("policies", value.policies);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TeamGetInfoResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamGetInfoResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TeamGetInfoResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TeamGetInfoResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TeamGetInfoResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String name = null;
            String teamId = null;
            Long numLicensedUsers = null;
            Long numProvisionedUsers = null;
            TeamPolicies policies = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("team_id".equals(_field)) {
                    teamId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("num_licensed_users".equals(_field)) {
                    numLicensedUsers = _p.getLongValue();
                    assertUnsigned(_p, numLicensedUsers);
                    if (numLicensedUsers > Integer.MAX_VALUE) {
                        throw new JsonParseException(_p, "expecting a 32-bit unsigned integer, got: " + numLicensedUsers);
                    }
                    _p.nextToken();
                }
                else if ("num_provisioned_users".equals(_field)) {
                    numProvisionedUsers = _p.getLongValue();
                    assertUnsigned(_p, numProvisionedUsers);
                    if (numProvisionedUsers > Integer.MAX_VALUE) {
                        throw new JsonParseException(_p, "expecting a 32-bit unsigned integer, got: " + numProvisionedUsers);
                    }
                    _p.nextToken();
                }
                else if ("policies".equals(_field)) {
                    policies = _p.readValueAs(TeamPolicies.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (teamId == null) {
                throw new JsonParseException(_p, "Required field \"team_id\" is missing.");
            }
            if (numLicensedUsers == null) {
                throw new JsonParseException(_p, "Required field \"num_licensed_users\" is missing.");
            }
            if (numProvisionedUsers == null) {
                throw new JsonParseException(_p, "Required field \"num_provisioned_users\" is missing.");
            }
            if (policies == null) {
                throw new JsonParseException(_p, "Required field \"policies\" is missing.");
            }

            return new TeamGetInfoResult(name, teamId, numLicensedUsers, numProvisionedUsers, policies);
        }
    }
}
