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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

/**
 * A role which can be attached to a team member. This replaces AdminTier; each
 * AdminTier corresponds to a new TeamMemberRole with a matching name.
 */
public class TeamMemberRole {
    // struct team.TeamMemberRole (team_members.stone)

    @Nonnull
    protected final String roleId;
    @Nonnull
    protected final String name;
    @Nonnull
    protected final String description;

    /**
     * A role which can be attached to a team member. This replaces AdminTier;
     * each AdminTier corresponds to a new TeamMemberRole with a matching name.
     *
     * @param roleId  A string containing encoded role ID. For roles defined by
     *     Dropbox, this is the same across all teams. Must have length of at
     *     most 128, match pattern "{@code pid_dbtmr:.*}", and not be {@code
     *     null}.
     * @param name  The role display name. Must have length of at most 32 and
     *     not be {@code null}.
     * @param description  Role description. Describes which permissions come
     *     with this role. Must have length of at most 256 and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberRole(@Nonnull String roleId, @Nonnull String name, @Nonnull String description) {
        if (roleId == null) {
            throw new IllegalArgumentException("Required value for 'roleId' is null");
        }
        if (roleId.length() > 128) {
            throw new IllegalArgumentException("String 'roleId' is longer than 128");
        }
        if (!Pattern.matches("pid_dbtmr:.*", roleId)) {
            throw new IllegalArgumentException("String 'roleId' does not match pattern");
        }
        this.roleId = roleId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        if (name.length() > 32) {
            throw new IllegalArgumentException("String 'name' is longer than 32");
        }
        this.name = name;
        if (description == null) {
            throw new IllegalArgumentException("Required value for 'description' is null");
        }
        if (description.length() > 256) {
            throw new IllegalArgumentException("String 'description' is longer than 256");
        }
        this.description = description;
    }

    /**
     * A string containing encoded role ID. For roles defined by Dropbox, this
     * is the same across all teams.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getRoleId() {
        return roleId;
    }

    /**
     * The role display name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Role description. Describes which permissions come with this role.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.roleId,
            this.name,
            this.description
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
            TeamMemberRole other = (TeamMemberRole) obj;
            return ((this.roleId == other.roleId) || (this.roleId.equals(other.roleId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.description == other.description) || (this.description.equals(other.description)))
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
    static class Serializer extends StructSerializer<TeamMemberRole> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberRole value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("role_id");
            StoneSerializers.string().serialize(value.roleId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("description");
            StoneSerializers.string().serialize(value.description, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberRole deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberRole value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_roleId = null;
                String f_name = null;
                String f_description = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("role_id".equals(field)) {
                        f_roleId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_roleId == null) {
                    throw new JsonParseException(p, "Required field \"role_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_description == null) {
                    throw new JsonParseException(p, "Required field \"description\" missing.");
                }
                value = new TeamMemberRole(f_roleId, f_name, f_description);
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
