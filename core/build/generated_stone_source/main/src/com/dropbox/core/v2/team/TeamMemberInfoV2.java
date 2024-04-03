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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Information about a team member.
 */
public class TeamMemberInfoV2 {
    // struct team.TeamMemberInfoV2 (team_members.stone)

    @Nonnull
    protected final TeamMemberProfile profile;
    @Nullable
    protected final List<TeamMemberRole> roles;

    /**
     * Information about a team member.
     *
     * @param profile  Profile of a user as a member of a team. Must not be
     *     {@code null}.
     * @param roles  The user's roles in the team. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfoV2(@Nonnull TeamMemberProfile profile, @Nullable List<TeamMemberRole> roles) {
        if (profile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = profile;
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
     * Information about a team member.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param profile  Profile of a user as a member of a team. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfoV2(@Nonnull TeamMemberProfile profile) {
        this(profile, null);
    }

    /**
     * Profile of a user as a member of a team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TeamMemberProfile getProfile() {
        return profile;
    }

    /**
     * The user's roles in the team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<TeamMemberRole> getRoles() {
        return roles;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.profile,
            this.roles
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
            TeamMemberInfoV2 other = (TeamMemberInfoV2) obj;
            return ((this.profile == other.profile) || (this.profile.equals(other.profile)))
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
    static class Serializer extends StructSerializer<TeamMemberInfoV2> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberInfoV2 value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("profile");
            TeamMemberProfile.Serializer.INSTANCE.serialize(value.profile, g);
            if (value.roles != null) {
                g.writeFieldName("roles");
                StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).serialize(value.roles, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberInfoV2 deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberInfoV2 value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMemberProfile f_profile = null;
                List<TeamMemberRole> f_roles = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("profile".equals(field)) {
                        f_profile = TeamMemberProfile.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("roles".equals(field)) {
                        f_roles = StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_profile == null) {
                    throw new JsonParseException(p, "Required field \"profile\" missing.");
                }
                value = new TeamMemberInfoV2(f_profile, f_roles);
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
