/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

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

class GroupMembersRemoveArg extends IncludeMembersArg {
    // struct team.GroupMembersRemoveArg (team_groups.stone)

    protected final GroupSelector group;
    protected final List<UserSelectorArg> users;

    /**
     *
     * @param group  Group from which users will be removed. Must not be {@code
     *     null}.
     * @param users  List of users to be removed from the group. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersRemoveArg(GroupSelector group, List<UserSelectorArg> users, boolean returnMembers) {
        super(returnMembers);
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
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
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param group  Group from which users will be removed. Must not be {@code
     *     null}.
     * @param users  List of users to be removed from the group. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersRemoveArg(GroupSelector group, List<UserSelectorArg> users) {
        this(group, users, true);
    }

    /**
     * Group from which users will be removed.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * List of users to be removed from the group.
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserSelectorArg> getUsers() {
        return users;
    }

    /**
     * Whether to return the list of members in the group.  Note that the
     * default value will cause all the group members  to be returned in the
     * response. This may take a long time for large groups.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getReturnMembers() {
        return returnMembers;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            group,
            users
        });
        hash = (31 * super.hashCode()) + hash;
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
            GroupMembersRemoveArg other = (GroupMembersRemoveArg) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.users == other.users) || (this.users.equals(other.users)))
                && (this.returnMembers == other.returnMembers)
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
    static class Serializer extends StructSerializer<GroupMembersRemoveArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMembersRemoveArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(value.group, g);
            g.writeFieldName("users");
            StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE).serialize(value.users, g);
            g.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(value.returnMembers, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupMembersRemoveArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupMembersRemoveArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                GroupSelector f_group = null;
                List<UserSelectorArg> f_users = null;
                Boolean f_returnMembers = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group".equals(field)) {
                        f_group = GroupSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("users".equals(field)) {
                        f_users = StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("return_members".equals(field)) {
                        f_returnMembers = StoneSerializers.boolean_().deserialize(p);
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
                value = new GroupMembersRemoveArg(f_group, f_users, f_returnMembers);
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
