/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Argument for selecting a group and a list of users.
 */
public class GroupMembersSelector {
    // struct GroupMembersSelector

    protected final GroupSelector group;
    protected final UsersSelectorArg users;

    /**
     * Argument for selecting a group and a list of users.
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param users  A list of users that are members of {@link
     *     GroupMembersSelector#getGroup}. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersSelector(GroupSelector group, UsersSelectorArg users) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        this.users = users;
    }

    /**
     * Specify a group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * A list of users that are members of {@link
     * GroupMembersSelector#getGroup}.
     *
     * @return value for this field, never {@code null}.
     */
    public UsersSelectorArg getUsers() {
        return users;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            users
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupMembersSelector other = (GroupMembersSelector) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.users == other.users) || (this.users.equals(other.users)))
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
    static final class Serializer extends StructSerializer<GroupMembersSelector> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMembersSelector value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(value.group, g);
            g.writeFieldName("users");
            UsersSelectorArg.Serializer.INSTANCE.serialize(value.users, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupMembersSelector deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupMembersSelector value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                GroupSelector f_group = null;
                UsersSelectorArg f_users = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group".equals(field)) {
                        f_group = GroupSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("users".equals(field)) {
                        f_users = UsersSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_group == null) {
                    throw new JsonParseException(p, "Required field \"group\" missing.");
                }
                if (f_users == null) {
                    throw new JsonParseException(p, "Required field \"users\" missing.");
                }
                value = new GroupMembersSelector(f_group, f_users);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
