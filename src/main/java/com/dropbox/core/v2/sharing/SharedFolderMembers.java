/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

/**
 * Shared folder user and group membership.
 */
@JsonSerialize(using=SharedFolderMembers.Serializer.class)
@JsonDeserialize(using=SharedFolderMembers.Deserializer.class)
public class SharedFolderMembers {
    // struct SharedFolderMembers

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
     * @param invitees  The list of invited members of the shared folder. This
     *     list will not include invitees that have already accepted or declined
     *     to join the shared folder. Must not contain a {@code null} item and
     *     not be {@code null}.
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
     * @param invitees  The list of invited members of the shared folder. This
     *     list will not include invitees that have already accepted or declined
     *     to join the shared folder. Must not contain a {@code null} item and
     *     not be {@code null}.
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
     * The list of invited members of the shared folder. This list will not
     * include invitees that have already accepted or declined to join the
     * shared folder.
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<SharedFolderMembers> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedFolderMembers.class);
        }

        public Serializer(boolean unwrapping) {
            super(SharedFolderMembers.class, unwrapping);
        }

        @Override
        protected JsonSerializer<SharedFolderMembers> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(SharedFolderMembers value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("users", value.users);
            g.writeObjectField("groups", value.groups);
            g.writeObjectField("invitees", value.invitees);
            if (value.cursor != null) {
                g.writeObjectField("cursor", value.cursor);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SharedFolderMembers> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedFolderMembers.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SharedFolderMembers.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<SharedFolderMembers> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SharedFolderMembers deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<UserMembershipInfo> users = null;
            List<GroupMembershipInfo> groups = null;
            List<InviteeMembershipInfo> invitees = null;
            String cursor = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("users".equals(_field)) {
                    expectArrayStart(_p);
                    users = new java.util.ArrayList<UserMembershipInfo>();
                    while (!isArrayEnd(_p)) {
                        UserMembershipInfo _x = null;
                        _x = _p.readValueAs(UserMembershipInfo.class);
                        _p.nextToken();
                        users.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("groups".equals(_field)) {
                    expectArrayStart(_p);
                    groups = new java.util.ArrayList<GroupMembershipInfo>();
                    while (!isArrayEnd(_p)) {
                        GroupMembershipInfo _x = null;
                        _x = _p.readValueAs(GroupMembershipInfo.class);
                        _p.nextToken();
                        groups.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("invitees".equals(_field)) {
                    expectArrayStart(_p);
                    invitees = new java.util.ArrayList<InviteeMembershipInfo>();
                    while (!isArrayEnd(_p)) {
                        InviteeMembershipInfo _x = null;
                        _x = _p.readValueAs(InviteeMembershipInfo.class);
                        _p.nextToken();
                        invitees.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (users == null) {
                throw new JsonParseException(_p, "Required field \"users\" is missing.");
            }
            if (groups == null) {
                throw new JsonParseException(_p, "Required field \"groups\" is missing.");
            }
            if (invitees == null) {
                throw new JsonParseException(_p, "Required field \"invitees\" is missing.");
            }

            return new SharedFolderMembers(users, groups, invitees, cursor);
        }
    }
}
