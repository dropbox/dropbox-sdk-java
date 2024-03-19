/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.sharing.InviteeInfo;
import com.dropbox.core.v2.sharing.UserInfo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

public class ListUsersOnFolderResponse {
    // struct paper.ListUsersOnFolderResponse (paper.stone)

    @Nonnull
    protected final List<InviteeInfo> invitees;
    @Nonnull
    protected final List<UserInfo> users;
    @Nonnull
    protected final Cursor cursor;
    protected final boolean hasMore;

    /**
     *
     * @param invitees  List of email addresses that are invited on the Paper
     *     folder. Must not contain a {@code null} item and not be {@code null}.
     * @param users  List of users that are invited on the Paper folder. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserPaperRequests#docsFolderUsersListContinue(String,String)} to
     *     paginate through all users. The cursor preserves all properties as
     *     specified in the original call to {@link
     *     DbxUserPaperRequests#docsFolderUsersList(String,int)}. Must not be
     *     {@code null}.
     * @param hasMore  Will be set to True if a subsequent call with the
     *     provided cursor to {@link
     *     DbxUserPaperRequests#docsFolderUsersListContinue(String,String)}
     *     returns immediately with some results. If set to False please allow
     *     some delay before making another call to {@link
     *     DbxUserPaperRequests#docsFolderUsersListContinue(String,String)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListUsersOnFolderResponse(@Nonnull List<InviteeInfo> invitees, @Nonnull List<UserInfo> users, @Nonnull Cursor cursor, boolean hasMore) {
        if (invitees == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        for (InviteeInfo x : invitees) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
        }
        this.invitees = invitees;
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (UserInfo x : users) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = users;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * List of email addresses that are invited on the Paper folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<InviteeInfo> getInvitees() {
        return invitees;
    }

    /**
     * List of users that are invited on the Paper folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<UserInfo> getUsers() {
        return users;
    }

    /**
     * Pass the cursor into {@link
     * DbxUserPaperRequests#docsFolderUsersListContinue(String,String)} to
     * paginate through all users. The cursor preserves all properties as
     * specified in the original call to {@link
     * DbxUserPaperRequests#docsFolderUsersList(String,int)}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Cursor getCursor() {
        return cursor;
    }

    /**
     * Will be set to True if a subsequent call with the provided cursor to
     * {@link DbxUserPaperRequests#docsFolderUsersListContinue(String,String)}
     * returns immediately with some results. If set to False please allow some
     * delay before making another call to {@link
     * DbxUserPaperRequests#docsFolderUsersListContinue(String,String)}.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            invitees,
            users,
            cursor,
            hasMore
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
            ListUsersOnFolderResponse other = (ListUsersOnFolderResponse) obj;
            return ((this.invitees == other.invitees) || (this.invitees.equals(other.invitees)))
                && ((this.users == other.users) || (this.users.equals(other.users)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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
    static class Serializer extends StructSerializer<ListUsersOnFolderResponse> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListUsersOnFolderResponse value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("invitees");
            StoneSerializers.list(InviteeInfo.Serializer.INSTANCE).serialize(value.invitees, g);
            g.writeFieldName("users");
            StoneSerializers.list(UserInfo.Serializer.INSTANCE).serialize(value.users, g);
            g.writeFieldName("cursor");
            Cursor.Serializer.INSTANCE.serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListUsersOnFolderResponse deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListUsersOnFolderResponse value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<InviteeInfo> f_invitees = null;
                List<UserInfo> f_users = null;
                Cursor f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("invitees".equals(field)) {
                        f_invitees = StoneSerializers.list(InviteeInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("users".equals(field)) {
                        f_users = StoneSerializers.list(UserInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = Cursor.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_invitees == null) {
                    throw new JsonParseException(p, "Required field \"invitees\" missing.");
                }
                if (f_users == null) {
                    throw new JsonParseException(p, "Required field \"users\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ListUsersOnFolderResponse(f_invitees, f_users, f_cursor, f_hasMore);
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
