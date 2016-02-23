/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Shared folder user and group membership.
 */
public class SharedFolderMembers {
    // struct SharedFolderMembers

    private final List<UserMembershipInfo> users;
    private final List<GroupMembershipInfo> groups;
    private final List<InviteeMembershipInfo> invitees;
    private final String cursor;

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
     *     DbxSharing#listFolderMembersContinue(String)} to list additional
     *     members.
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
     * DbxSharing#listFolderMembersContinue(String)} to list additional members.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedFolderMembers fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedFolderMembers> _JSON_WRITER = new JsonWriter<SharedFolderMembers>() {
        public final void write(SharedFolderMembers x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SharedFolderMembers._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SharedFolderMembers x, JsonGenerator g) throws IOException {
            g.writeFieldName("users");
            g.writeStartArray();
            for (UserMembershipInfo item: x.users) {
                if (item != null) {
                    UserMembershipInfo._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("groups");
            g.writeStartArray();
            for (GroupMembershipInfo item: x.groups) {
                if (item != null) {
                    GroupMembershipInfo._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("invitees");
            g.writeStartArray();
            for (InviteeMembershipInfo item: x.invitees) {
                if (item != null) {
                    InviteeMembershipInfo._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
        }
    };

    public static final JsonReader<SharedFolderMembers> _JSON_READER = new JsonReader<SharedFolderMembers>() {
        public final SharedFolderMembers read(JsonParser parser) throws IOException, JsonReadException {
            SharedFolderMembers result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SharedFolderMembers readFields(JsonParser parser) throws IOException, JsonReadException {
            List<UserMembershipInfo> users = null;
            List<GroupMembershipInfo> groups = null;
            List<InviteeMembershipInfo> invitees = null;
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("users".equals(fieldName)) {
                    users = JsonArrayReader.mk(UserMembershipInfo._JSON_READER)
                        .readField(parser, "users", users);
                }
                else if ("groups".equals(fieldName)) {
                    groups = JsonArrayReader.mk(GroupMembershipInfo._JSON_READER)
                        .readField(parser, "groups", groups);
                }
                else if ("invitees".equals(fieldName)) {
                    invitees = JsonArrayReader.mk(InviteeMembershipInfo._JSON_READER)
                        .readField(parser, "invitees", invitees);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (users == null) {
                throw new JsonReadException("Required field \"users\" is missing.", parser.getTokenLocation());
            }
            if (groups == null) {
                throw new JsonReadException("Required field \"groups\" is missing.", parser.getTokenLocation());
            }
            if (invitees == null) {
                throw new JsonReadException("Required field \"invitees\" is missing.", parser.getTokenLocation());
            }
            return new SharedFolderMembers(users, groups, invitees, cursor);
        }
    };
}
