/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Shared folder user and group membership.
 */
public class SharedFolderMembers {
    // struct SharedFolderMembers

    protected final List<UserMembershipInfo> users;
    protected final List<GroupMembershipInfo> groups;
    protected final List<InviteeMembershipInfo> invitees;
    protected final String cursor;

    /**
     * Shared folder user and group membership.
     *
     * @param users  The list of user members of the shared folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param groups  The list of group members of the shared folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param invitees  The list of invitees to the shared folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param cursor  Present if there are additional shared folder members that
     *     have not been returned yet. Pass the cursor into {@link
     *     DbxUserSharingRequests#listFolderMembersContinue(String)} to list
     *     additional members.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMembers(List<UserMembershipInfo> users, List<GroupMembershipInfo> groups, List<InviteeMembershipInfo> invitees, String cursor) {
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (UserMembershipInfo x : users) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = users;
        if (groups == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        for (GroupMembershipInfo x : groups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = groups;
        if (invitees == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        for (InviteeMembershipInfo x : invitees) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
        }
        this.invitees = invitees;
        this.cursor = cursor;
    }

    /**
     * Shared folder user and group membership.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param users  The list of user members of the shared folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param groups  The list of group members of the shared folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param invitees  The list of invitees to the shared folder. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMembers(List<UserMembershipInfo> users, List<GroupMembershipInfo> groups, List<InviteeMembershipInfo> invitees) {
        this(users, groups, invitees, null);
    }

    /**
     * The list of user members of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserMembershipInfo> getUsers() {
        return users;
    }

    /**
     * The list of group members of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public List<GroupMembershipInfo> getGroups() {
        return groups;
    }

    /**
     * The list of invitees to the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public List<InviteeMembershipInfo> getInvitees() {
        return invitees;
    }

    /**
     * Present if there are additional shared folder members that have not been
     * returned yet. Pass the cursor into {@link
     * DbxUserSharingRequests#listFolderMembersContinue(String)} to list
     * additional members.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            users,
            groups,
            invitees,
            cursor
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
            SharedFolderMembers other = (SharedFolderMembers) obj;
            return ((this.users == other.users) || (this.users.equals(other.users)))
                && ((this.groups == other.groups) || (this.groups.equals(other.groups)))
                && ((this.invitees == other.invitees) || (this.invitees.equals(other.invitees)))
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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
    static final class Serializer extends StructSerializer<SharedFolderMembers> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMembers value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("users");
            StoneSerializers.list(UserMembershipInfo.Serializer.INSTANCE).serialize(value.users, g);
            g.writeFieldName("groups");
            StoneSerializers.list(GroupMembershipInfo.Serializer.INSTANCE).serialize(value.groups, g);
            g.writeFieldName("invitees");
            StoneSerializers.list(InviteeMembershipInfo.Serializer.INSTANCE).serialize(value.invitees, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedFolderMembers deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFolderMembers value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserMembershipInfo> f_users = null;
                List<GroupMembershipInfo> f_groups = null;
                List<InviteeMembershipInfo> f_invitees = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("users".equals(field)) {
                        f_users = StoneSerializers.list(UserMembershipInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("groups".equals(field)) {
                        f_groups = StoneSerializers.list(GroupMembershipInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("invitees".equals(field)) {
                        f_invitees = StoneSerializers.list(InviteeMembershipInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_users == null) {
                    throw new JsonParseException(p, "Required field \"users\" missing.");
                }
                if (f_groups == null) {
                    throw new JsonParseException(p, "Required field \"groups\" missing.");
                }
                if (f_invitees == null) {
                    throw new JsonParseException(p, "Required field \"invitees\" missing.");
                }
                value = new SharedFolderMembers(f_users, f_groups, f_invitees, f_cursor);
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
