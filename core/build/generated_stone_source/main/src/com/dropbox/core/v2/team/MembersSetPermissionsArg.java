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

import javax.annotation.Nonnull;

/**
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account.
 */
class MembersSetPermissionsArg {
    // struct team.MembersSetPermissionsArg (team_members.stone)

    @Nonnull
    protected final UserSelectorArg user;
    @Nonnull
    protected final AdminTier newRole;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     * @param newRole  The new role of the member. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissionsArg(@Nonnull UserSelectorArg user, @Nonnull AdminTier newRole) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (newRole == null) {
            throw new IllegalArgumentException("Required value for 'newRole' is null");
        }
        this.newRole = newRole;
    }

    /**
     * Identity of user whose role will be set.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * The new role of the member.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminTier getNewRole() {
        return newRole;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            user,
            newRole
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
            MembersSetPermissionsArg other = (MembersSetPermissionsArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.newRole == other.newRole) || (this.newRole.equals(other.newRole)))
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
    static class Serializer extends StructSerializer<MembersSetPermissionsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetPermissionsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("new_role");
            AdminTier.Serializer.INSTANCE.serialize(value.newRole, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersSetPermissionsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersSetPermissionsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                AdminTier f_newRole = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_role".equals(field)) {
                        f_newRole = AdminTier.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_newRole == null) {
                    throw new JsonParseException(p, "Required field \"new_role\" missing.");
                }
                value = new MembersSetPermissionsArg(f_user, f_newRole);
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
