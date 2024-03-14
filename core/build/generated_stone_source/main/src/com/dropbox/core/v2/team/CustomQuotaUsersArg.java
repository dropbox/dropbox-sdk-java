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

class CustomQuotaUsersArg {
    // struct team.CustomQuotaUsersArg (team_member_space_limits.stone)

    protected final List<UserSelectorArg> users;

    /**
     *
     * @param users  List of users. Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CustomQuotaUsersArg(@Nonnull List<UserSelectorArg> users) {
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (UserSelectorArg x : users) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = users;
    }

    /**
     * List of users.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<UserSelectorArg> getUsers() {
        return users;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            users
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
            CustomQuotaUsersArg other = (CustomQuotaUsersArg) obj;
            return (this.users == other.users) || (this.users.equals(other.users));
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
    static class Serializer extends StructSerializer<CustomQuotaUsersArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CustomQuotaUsersArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("users");
            StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE).serialize(value.users, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CustomQuotaUsersArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CustomQuotaUsersArg value;
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
                        f_users = StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_users == null) {
                    throw new JsonParseException(p, "Required field \"users\" missing.");
                }
                value = new CustomQuotaUsersArg(f_users);
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
