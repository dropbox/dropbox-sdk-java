/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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
 * Shared file user, group, and invitee membership. Used for the results of
 * {@link DbxUserSharingRequests#listFileMembers(String)} and {@link
 * DbxUserSharingRequests#listFileMembersContinue(String)}, and used as part of
 * the results for {@link
 * DbxUserSharingRequests#listFileMembersBatch(List,long)}.
 */
public class SharedFileMembers {
    // struct sharing.SharedFileMembers (sharing_files.stone)

    protected final List<UserFileMembershipInfo> users;
    protected final List<GroupMembershipInfo> groups;
    protected final List<InviteeMembershipInfo> invitees;
    protected final String cursor;

    /**
     * Shared file user, group, and invitee membership. Used for the results of
     * {@link DbxUserSharingRequests#listFileMembers(String)} and {@link
     * DbxUserSharingRequests#listFileMembersContinue(String)}, and used as part
     * of the results for {@link
     * DbxUserSharingRequests#listFileMembersBatch(List,long)}.
     *
     * @param users  The list of user members of the shared file. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param groups  The list of group members of the shared file. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param invitees  The list of invited members of a file, but have not
     *     logged in and claimed this. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param cursor  Present if there are additional shared file members that
     *     have not been returned yet. Pass the cursor into {@link
     *     DbxUserSharingRequests#listFileMembersContinue(String)} to list
     *     additional members.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMembers(@Nonnull List<UserFileMembershipInfo> users, @Nonnull List<GroupMembershipInfo> groups, @Nonnull List<InviteeMembershipInfo> invitees, @Nullable String cursor) {
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (UserFileMembershipInfo x : users) {
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
     * Shared file user, group, and invitee membership. Used for the results of
     * {@link DbxUserSharingRequests#listFileMembers(String)} and {@link
     * DbxUserSharingRequests#listFileMembersContinue(String)}, and used as part
     * of the results for {@link
     * DbxUserSharingRequests#listFileMembersBatch(List,long)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param users  The list of user members of the shared file. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param groups  The list of group members of the shared file. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param invitees  The list of invited members of a file, but have not
     *     logged in and claimed this. Must not contain a {@code null} item and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMembers(@Nonnull List<UserFileMembershipInfo> users, @Nonnull List<GroupMembershipInfo> groups, @Nonnull List<InviteeMembershipInfo> invitees) {
        this(users, groups, invitees, null);
    }

    /**
     * The list of user members of the shared file.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<UserFileMembershipInfo> getUsers() {
        return users;
    }

    /**
     * The list of group members of the shared file.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<GroupMembershipInfo> getGroups() {
        return groups;
    }

    /**
     * The list of invited members of a file, but have not logged in and claimed
     * this.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<InviteeMembershipInfo> getInvitees() {
        return invitees;
    }

    /**
     * Present if there are additional shared file members that have not been
     * returned yet. Pass the cursor into {@link
     * DbxUserSharingRequests#listFileMembersContinue(String)} to list
     * additional members.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            SharedFileMembers other = (SharedFileMembers) obj;
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
    static class Serializer extends StructSerializer<SharedFileMembers> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFileMembers value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("users");
            StoneSerializers.list(UserFileMembershipInfo.Serializer.INSTANCE).serialize(value.users, g);
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
        public SharedFileMembers deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFileMembers value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserFileMembershipInfo> f_users = null;
                List<GroupMembershipInfo> f_groups = null;
                List<InviteeMembershipInfo> f_invitees = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("users".equals(field)) {
                        f_users = StoneSerializers.list(UserFileMembershipInfo.Serializer.INSTANCE).deserialize(p);
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
                value = new SharedFileMembers(f_users, f_groups, f_invitees, f_cursor);
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
