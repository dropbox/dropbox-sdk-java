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

/**
 * Information about a team member.
 */
public class TeamMemberInfo {
    // struct team.TeamMemberInfo (team_members.stone)

    protected final TeamMemberProfile profile;
    protected final AdminTier role;

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
    @javax.annotation.Nonnull
    public TeamMemberProfile getProfile() {
        return profile;
    }

    /**
     * The user's role in the team.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public AdminTier getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<TeamMemberInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("profile");
            TeamMemberProfile.Serializer.INSTANCE.serialize(value.profile, g);
            g.writeFieldName("role");
            AdminTier.Serializer.INSTANCE.serialize(value.role, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMemberProfile f_profile = null;
                AdminTier f_role = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("profile".equals(field)) {
                        f_profile = TeamMemberProfile.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("role".equals(field)) {
                        f_role = AdminTier.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_profile == null) {
                    throw new JsonParseException(p, "Required field \"profile\" missing.");
                }
                if (f_role == null) {
                    throw new JsonParseException(p, "Required field \"role\" missing.");
                }
                value = new TeamMemberInfo(f_profile, f_role);
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
