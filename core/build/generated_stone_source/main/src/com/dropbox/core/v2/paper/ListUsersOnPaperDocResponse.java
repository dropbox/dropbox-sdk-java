/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
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

public class ListUsersOnPaperDocResponse {
    // struct paper.ListUsersOnPaperDocResponse (paper.stone)

    @Nonnull
    protected final List<InviteeInfoWithPermissionLevel> invitees;
    @Nonnull
    protected final List<UserInfoWithPermissionLevel> users;
    @Nonnull
    protected final UserInfo docOwner;
    @Nonnull
    protected final Cursor cursor;
    protected final boolean hasMore;

    /**
     *
     * @param invitees  List of email addresses with their respective permission
     *     levels that are invited on the Paper doc. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param users  List of users with their respective permission levels that
     *     are invited on the Paper folder. Must not contain a {@code null} item
     *     and not be {@code null}.
     * @param docOwner  The Paper doc owner. This field is populated on every
     *     single response. Must not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserPaperRequests#docsUsersListContinue(String,String)} to
     *     paginate through all users. The cursor preserves all properties as
     *     specified in the original call to {@link
     *     DbxUserPaperRequests#docsUsersList(String)}. Must not be {@code
     *     null}.
     * @param hasMore  Will be set to True if a subsequent call with the
     *     provided cursor to {@link
     *     DbxUserPaperRequests#docsUsersListContinue(String,String)} returns
     *     immediately with some results. If set to False please allow some
     *     delay before making another call to {@link
     *     DbxUserPaperRequests#docsUsersListContinue(String,String)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListUsersOnPaperDocResponse(@Nonnull List<InviteeInfoWithPermissionLevel> invitees, @Nonnull List<UserInfoWithPermissionLevel> users, @Nonnull UserInfo docOwner, @Nonnull Cursor cursor, boolean hasMore) {
        if (invitees == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        for (InviteeInfoWithPermissionLevel x : invitees) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
        }
        this.invitees = invitees;
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (UserInfoWithPermissionLevel x : users) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = users;
        if (docOwner == null) {
            throw new IllegalArgumentException("Required value for 'docOwner' is null");
        }
        this.docOwner = docOwner;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * List of email addresses with their respective permission levels that are
     * invited on the Paper doc.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<InviteeInfoWithPermissionLevel> getInvitees() {
        return invitees;
    }

    /**
     * List of users with their respective permission levels that are invited on
     * the Paper folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<UserInfoWithPermissionLevel> getUsers() {
        return users;
    }

    /**
     * The Paper doc owner. This field is populated on every single response.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserInfo getDocOwner() {
        return docOwner;
    }

    /**
     * Pass the cursor into {@link
     * DbxUserPaperRequests#docsUsersListContinue(String,String)} to paginate
     * through all users. The cursor preserves all properties as specified in
     * the original call to {@link DbxUserPaperRequests#docsUsersList(String)}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Cursor getCursor() {
        return cursor;
    }

    /**
     * Will be set to True if a subsequent call with the provided cursor to
     * {@link DbxUserPaperRequests#docsUsersListContinue(String,String)} returns
     * immediately with some results. If set to False please allow some delay
     * before making another call to {@link
     * DbxUserPaperRequests#docsUsersListContinue(String,String)}.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.invitees,
            this.users,
            this.docOwner,
            this.cursor,
            this.hasMore
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
            ListUsersOnPaperDocResponse other = (ListUsersOnPaperDocResponse) obj;
            return ((this.invitees == other.invitees) || (this.invitees.equals(other.invitees)))
                && ((this.users == other.users) || (this.users.equals(other.users)))
                && ((this.docOwner == other.docOwner) || (this.docOwner.equals(other.docOwner)))
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
    static class Serializer extends StructSerializer<ListUsersOnPaperDocResponse> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListUsersOnPaperDocResponse value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("invitees");
            StoneSerializers.list(InviteeInfoWithPermissionLevel.Serializer.INSTANCE).serialize(value.invitees, g);
            g.writeFieldName("users");
            StoneSerializers.list(UserInfoWithPermissionLevel.Serializer.INSTANCE).serialize(value.users, g);
            g.writeFieldName("doc_owner");
            UserInfo.Serializer.INSTANCE.serialize(value.docOwner, g);
            g.writeFieldName("cursor");
            Cursor.Serializer.INSTANCE.serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListUsersOnPaperDocResponse deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListUsersOnPaperDocResponse value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<InviteeInfoWithPermissionLevel> f_invitees = null;
                List<UserInfoWithPermissionLevel> f_users = null;
                UserInfo f_docOwner = null;
                Cursor f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("invitees".equals(field)) {
                        f_invitees = StoneSerializers.list(InviteeInfoWithPermissionLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("users".equals(field)) {
                        f_users = StoneSerializers.list(UserInfoWithPermissionLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("doc_owner".equals(field)) {
                        f_docOwner = UserInfo.Serializer.INSTANCE.deserialize(p);
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
                if (f_docOwner == null) {
                    throw new JsonParseException(p, "Required field \"doc_owner\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ListUsersOnPaperDocResponse(f_invitees, f_users, f_docOwner, f_cursor, f_hasMore);
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
