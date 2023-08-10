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

public class MembersSetPermissions2Result {
    // struct team.MembersSetPermissions2Result (team_members.stone)

    protected final String teamMemberId;
    protected final List<TeamMemberRole> roles;

    /**
     *
     * @param teamMemberId  The member ID of the user to which the change was
     *     applied. Must not be {@code null}.
     * @param roles  The roles after the change. Empty in case the user become a
     *     non-admin. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissions2Result(String teamMemberId, List<TeamMemberRole> roles) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        if (roles != null) {
            for (TeamMemberRole x : roles) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'roles' is null");
                }
            }
        }
        this.roles = roles;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamMemberId  The member ID of the user to which the change was
     *     applied. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissions2Result(String teamMemberId) {
        this(teamMemberId, null);
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
     * The roles after the change. Empty in case the user become a non-admin.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<TeamMemberRole> getRoles() {
        return roles;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamMemberId,
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
            MembersSetPermissions2Result other = (MembersSetPermissions2Result) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.roles == other.roles) || (this.roles != null && this.roles.equals(other.roles)))
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
    static class Serializer extends StructSerializer<MembersSetPermissions2Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetPermissions2Result value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(value.teamMemberId, g);
            if (value.roles != null) {
                g.writeFieldName("roles");
                StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).serialize(value.roles, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersSetPermissions2Result deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersSetPermissions2Result value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamMemberId = null;
                List<TeamMemberRole> f_roles = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("roles".equals(field)) {
                        f_roles = StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamMemberId == null) {
                    throw new JsonParseException(p, "Required field \"team_member_id\" missing.");
                }
                value = new MembersSetPermissions2Result(f_teamMemberId, f_roles);
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
