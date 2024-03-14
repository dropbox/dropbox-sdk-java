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
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account.
 */
class MembersSetPermissions2Arg {
    // struct team.MembersSetPermissions2Arg (team_members.stone)

    protected final UserSelectorArg user;
    protected final List<String> newRoles;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     * @param newRoles  The new roles for the member. Send empty list to make
     *     user member only. For now, only up to one role is allowed. Must
     *     contain at most 1 items and not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissions2Arg(@javax.annotation.Nonnull UserSelectorArg user, @javax.annotation.Nullable List<String> newRoles) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (newRoles != null) {
            if (newRoles.size() > 1) {
                throw new IllegalArgumentException("List 'newRoles' has more than 1 items");
            }
            for (String x : newRoles) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'newRoles' is null");
                }
                if (x.length() > 128) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' is longer than 128");
                }
                if (!java.util.regex.Pattern.matches("pid_dbtmr:.*", x)) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' does not match pattern");
                }
            }
        }
        this.newRoles = newRoles;
    }

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissions2Arg(UserSelectorArg user) {
        this(user, null);
    }

    /**
     * Identity of user whose role will be set.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * The new roles for the member. Send empty list to make user member only.
     * For now, only up to one role is allowed.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<String> getNewRoles() {
        return newRoles;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            user,
            newRoles
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
            MembersSetPermissions2Arg other = (MembersSetPermissions2Arg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.newRoles == other.newRoles) || (this.newRoles != null && this.newRoles.equals(other.newRoles)))
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
    static class Serializer extends StructSerializer<MembersSetPermissions2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetPermissions2Arg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            if (value.newRoles != null) {
                g.writeFieldName("new_roles");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.newRoles, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersSetPermissions2Arg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersSetPermissions2Arg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                List<String> f_newRoles = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_roles".equals(field)) {
                        f_newRoles = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                value = new MembersSetPermissions2Arg(f_user, f_newRoles);
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
