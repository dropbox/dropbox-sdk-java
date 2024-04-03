/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teampolicies.TeamMemberPolicies;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

public class TeamGetInfoResult {
    // struct team.TeamGetInfoResult (team.stone)

    @Nonnull
    protected final String name;
    @Nonnull
    protected final String teamId;
    protected final long numLicensedUsers;
    protected final long numProvisionedUsers;
    protected final long numUsedLicenses;
    @Nonnull
    protected final TeamMemberPolicies policies;

    /**
     *
     * @param name  The name of the team. Must not be {@code null}.
     * @param teamId  The ID of the team. Must not be {@code null}.
     * @param numLicensedUsers  The number of licenses available to the team.
     * @param numProvisionedUsers  The number of accounts that have been invited
     *     or are already active members of the team.
     * @param policies  Must not be {@code null}.
     * @param numUsedLicenses  The number of licenses used on the team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamGetInfoResult(@Nonnull String name, @Nonnull String teamId, long numLicensedUsers, long numProvisionedUsers, @Nonnull TeamMemberPolicies policies, long numUsedLicenses) {
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
        this.numUsedLicenses = numUsedLicenses;
        if (policies == null) {
            throw new IllegalArgumentException("Required value for 'policies' is null");
        }
        this.policies = policies;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
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
    public TeamGetInfoResult(@Nonnull String name, @Nonnull String teamId, long numLicensedUsers, long numProvisionedUsers, @Nonnull TeamMemberPolicies policies) {
        this(name, teamId, numLicensedUsers, numProvisionedUsers, policies, 0L);
    }

    /**
     * The name of the team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * The ID of the team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
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
    @Nonnull
    public TeamMemberPolicies getPolicies() {
        return policies;
    }

    /**
     * The number of licenses used on the team.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     0L.
     */
    public long getNumUsedLicenses() {
        return numUsedLicenses;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.name,
            this.teamId,
            this.numLicensedUsers,
            this.numProvisionedUsers,
            this.numUsedLicenses,
            this.policies
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            TeamGetInfoResult other = (TeamGetInfoResult) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.teamId == other.teamId) || (this.teamId.equals(other.teamId)))
                && (this.numLicensedUsers == other.numLicensedUsers)
                && (this.numProvisionedUsers == other.numProvisionedUsers)
                && ((this.policies == other.policies) || (this.policies.equals(other.policies)))
                && (this.numUsedLicenses == other.numUsedLicenses)
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<TeamGetInfoResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamGetInfoResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("team_id");
            StoneSerializers.string().serialize(value.teamId, g);
            g.writeFieldName("num_licensed_users");
            StoneSerializers.uInt32().serialize(value.numLicensedUsers, g);
            g.writeFieldName("num_provisioned_users");
            StoneSerializers.uInt32().serialize(value.numProvisionedUsers, g);
            g.writeFieldName("policies");
            TeamMemberPolicies.Serializer.INSTANCE.serialize(value.policies, g);
            g.writeFieldName("num_used_licenses");
            StoneSerializers.uInt32().serialize(value.numUsedLicenses, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamGetInfoResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamGetInfoResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                String f_teamId = null;
                Long f_numLicensedUsers = null;
                Long f_numProvisionedUsers = null;
                TeamMemberPolicies f_policies = null;
                Long f_numUsedLicenses = 0L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("team_id".equals(field)) {
                        f_teamId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("num_licensed_users".equals(field)) {
                        f_numLicensedUsers = StoneSerializers.uInt32().deserialize(p);
                    }
                    else if ("num_provisioned_users".equals(field)) {
                        f_numProvisionedUsers = StoneSerializers.uInt32().deserialize(p);
                    }
                    else if ("policies".equals(field)) {
                        f_policies = TeamMemberPolicies.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("num_used_licenses".equals(field)) {
                        f_numUsedLicenses = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_teamId == null) {
                    throw new JsonParseException(p, "Required field \"team_id\" missing.");
                }
                if (f_numLicensedUsers == null) {
                    throw new JsonParseException(p, "Required field \"num_licensed_users\" missing.");
                }
                if (f_numProvisionedUsers == null) {
                    throw new JsonParseException(p, "Required field \"num_provisioned_users\" missing.");
                }
                if (f_policies == null) {
                    throw new JsonParseException(p, "Required field \"policies\" missing.");
                }
                value = new TeamGetInfoResult(f_name, f_teamId, f_numLicensedUsers, f_numProvisionedUsers, f_policies, f_numUsedLicenses);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
