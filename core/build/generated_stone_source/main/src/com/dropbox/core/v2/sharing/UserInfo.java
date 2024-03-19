/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Basic information about a user. Use {@link
 * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccount(String)} and {@link
 * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccountBatch(java.util.List)}
 * to obtain more detailed information.
 */
public class UserInfo {
    // struct sharing.UserInfo (sharing_folders.stone)

    @Nonnull
    protected final String accountId;
    @Nonnull
    protected final String email;
    @Nonnull
    protected final String displayName;
    protected final boolean sameTeam;
    @Nullable
    protected final String teamMemberId;

    /**
     * Basic information about a user. Use {@link
     * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccount(String)} and
     * {@link
     * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccountBatch(java.util.List)}
     * to obtain more detailed information.
     *
     * @param accountId  The account ID of the user. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param email  Email address of user. Must not be {@code null}.
     * @param displayName  The display name of the user. Must not be {@code
     *     null}.
     * @param sameTeam  If the user is in the same team as current user.
     * @param teamMemberId  The team member ID of the shared folder member. Only
     *     present if {@link UserInfo#getSameTeam} is true.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserInfo(@Nonnull String accountId, @Nonnull String email, @Nonnull String displayName, boolean sameTeam, @Nullable String teamMemberId) {
        if (accountId == null) {
            throw new IllegalArgumentException("Required value for 'accountId' is null");
        }
        if (accountId.length() < 40) {
            throw new IllegalArgumentException("String 'accountId' is shorter than 40");
        }
        if (accountId.length() > 40) {
            throw new IllegalArgumentException("String 'accountId' is longer than 40");
        }
        this.accountId = accountId;
        if (email == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        this.email = email;
        if (displayName == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = displayName;
        this.sameTeam = sameTeam;
        this.teamMemberId = teamMemberId;
    }

    /**
     * Basic information about a user. Use {@link
     * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccount(String)} and
     * {@link
     * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccountBatch(java.util.List)}
     * to obtain more detailed information.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accountId  The account ID of the user. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param email  Email address of user. Must not be {@code null}.
     * @param displayName  The display name of the user. Must not be {@code
     *     null}.
     * @param sameTeam  If the user is in the same team as current user.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserInfo(@Nonnull String accountId, @Nonnull String email, @Nonnull String displayName, boolean sameTeam) {
        this(accountId, email, displayName, sameTeam, null);
    }

    /**
     * The account ID of the user.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAccountId() {
        return accountId;
    }

    /**
     * Email address of user.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getEmail() {
        return email;
    }

    /**
     * The display name of the user.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDisplayName() {
        return displayName;
    }

    /**
     * If the user is in the same team as current user.
     *
     * @return value for this field.
     */
    public boolean getSameTeam() {
        return sameTeam;
    }

    /**
     * The team member ID of the shared folder member. Only present if {@link
     * UserInfo#getSameTeam} is true.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            accountId,
            email,
            displayName,
            sameTeam,
            teamMemberId
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
            UserInfo other = (UserInfo) obj;
            return ((this.accountId == other.accountId) || (this.accountId.equals(other.accountId)))
                && ((this.email == other.email) || (this.email.equals(other.email)))
                && ((this.displayName == other.displayName) || (this.displayName.equals(other.displayName)))
                && (this.sameTeam == other.sameTeam)
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId != null && this.teamMemberId.equals(other.teamMemberId)))
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
    public static class Serializer extends StructSerializer<UserInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("account_id");
            StoneSerializers.string().serialize(value.accountId, g);
            g.writeFieldName("email");
            StoneSerializers.string().serialize(value.email, g);
            g.writeFieldName("display_name");
            StoneSerializers.string().serialize(value.displayName, g);
            g.writeFieldName("same_team");
            StoneSerializers.boolean_().serialize(value.sameTeam, g);
            if (value.teamMemberId != null) {
                g.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.teamMemberId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_accountId = null;
                String f_email = null;
                String f_displayName = null;
                Boolean f_sameTeam = null;
                String f_teamMemberId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("email".equals(field)) {
                        f_email = StoneSerializers.string().deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("same_team".equals(field)) {
                        f_sameTeam = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accountId == null) {
                    throw new JsonParseException(p, "Required field \"account_id\" missing.");
                }
                if (f_email == null) {
                    throw new JsonParseException(p, "Required field \"email\" missing.");
                }
                if (f_displayName == null) {
                    throw new JsonParseException(p, "Required field \"display_name\" missing.");
                }
                if (f_sameTeam == null) {
                    throw new JsonParseException(p, "Required field \"same_team\" missing.");
                }
                value = new UserInfo(f_accountId, f_email, f_displayName, f_sameTeam, f_teamMemberId);
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
