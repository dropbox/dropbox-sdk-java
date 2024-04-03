/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

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
 * Argument of excluded users update operation. Should include a list of users
 * to add/remove (according to endpoint), Maximum size of the list is 1000
 * users.
 */
class ExcludedUsersUpdateArg {
    // struct team.ExcludedUsersUpdateArg (team_member_space_limits.stone)

    @Nullable
    protected final List<UserSelectorArg> users;

    /**
     * Argument of excluded users update operation. Should include a list of
     * users to add/remove (according to endpoint), Maximum size of the list is
     * 1000 users.
     *
     * @param users  List of users to be added/removed. Must not contain a
     *     {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersUpdateArg(@Nullable List<UserSelectorArg> users) {
        if (users != null) {
            for (UserSelectorArg x : users) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'users' is null");
                }
            }
        }
        this.users = users;
    }

    /**
     * Argument of excluded users update operation. Should include a list of
     * users to add/remove (according to endpoint), Maximum size of the list is
     * 1000 users.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ExcludedUsersUpdateArg() {
        this(null);
    }

    /**
     * List of users to be added/removed.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<UserSelectorArg> getUsers() {
        return users;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.users
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
            ExcludedUsersUpdateArg other = (ExcludedUsersUpdateArg) obj;
            return (this.users == other.users) || (this.users != null && this.users.equals(other.users));
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
    static class Serializer extends StructSerializer<ExcludedUsersUpdateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExcludedUsersUpdateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.users != null) {
                g.writeFieldName("users");
                StoneSerializers.nullable(StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE)).serialize(value.users, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExcludedUsersUpdateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExcludedUsersUpdateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserSelectorArg> f_users = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("users".equals(field)) {
                        f_users = StoneSerializers.nullable(StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ExcludedUsersUpdateArg(f_users);
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
