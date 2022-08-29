/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Available TeamMemberRole for the connected team. To be used with {@link
 * DbxTeamTeamRequests#membersSetAdminPermissionsV2(UserSelectorArg,List)}.
 */
public class MembersGetAvailableTeamMemberRolesResult {
    // struct team.MembersGetAvailableTeamMemberRolesResult (team_members.stone)

    protected final List<TeamMemberRole> roles;

    /**
     * Available TeamMemberRole for the connected team. To be used with {@link
     * DbxTeamTeamRequests#membersSetAdminPermissionsV2(UserSelectorArg,List)}.
     *
     * @param roles  Available roles. Must not contain a {@code null} item and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersGetAvailableTeamMemberRolesResult(List<TeamMemberRole> roles) {
        if (roles == null) {
            throw new IllegalArgumentException("Required value for 'roles' is null");
        }
        for (TeamMemberRole x : roles) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'roles' is null");
            }
        }
        this.roles = roles;
    }

    /**
     * Available roles.
     *
     * @return value for this field, never {@code null}.
     */
    public List<TeamMemberRole> getRoles() {
        return roles;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            roles
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
            MembersGetAvailableTeamMemberRolesResult other = (MembersGetAvailableTeamMemberRolesResult) obj;
            return (this.roles == other.roles) || (this.roles.equals(other.roles));
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
    static class Serializer extends StructSerializer<MembersGetAvailableTeamMemberRolesResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersGetAvailableTeamMemberRolesResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("roles");
            StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE).serialize(value.roles, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersGetAvailableTeamMemberRolesResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersGetAvailableTeamMemberRolesResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<TeamMemberRole> f_roles = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("roles".equals(field)) {
                        f_roles = StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_roles == null) {
                    throw new JsonParseException(p, "Required field \"roles\" missing.");
                }
                value = new MembersGetAvailableTeamMemberRolesResult(f_roles);
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
