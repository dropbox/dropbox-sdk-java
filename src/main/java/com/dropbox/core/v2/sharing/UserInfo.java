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

/**
 * Basic information about a user. Use {@link
 * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccount(String)} and {@link
 * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccountBatch(java.util.List)}
 * to obtain more detailed information.
 */
public class UserInfo {
    // struct UserInfo

    protected final String accountId;
    protected final boolean sameTeam;
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
     * @param sameTeam  If the user is in the same team as current user.
     * @param teamMemberId  The team member ID of the shared folder member. Only
     *     present if {@link UserInfo#getSameTeam} is true.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserInfo(String accountId, boolean sameTeam, String teamMemberId) {
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
     * @param sameTeam  If the user is in the same team as current user.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserInfo(String accountId, boolean sameTeam) {
        this(accountId, sameTeam, null);
    }

    /**
     * The account ID of the user.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAccountId() {
        return accountId;
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
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accountId,
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
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            UserInfo other = (UserInfo) obj;
            return ((this.accountId == other.accountId) || (this.accountId.equals(other.accountId)))
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
    static final class Serializer extends StructSerializer<UserInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("account_id");
            StoneSerializers.string().serialize(value.accountId, g);
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
                Boolean f_sameTeam = null;
                String f_teamMemberId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.string().deserialize(p);
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
                if (f_sameTeam == null) {
                    throw new JsonParseException(p, "Required field \"same_team\" missing.");
                }
                value = new UserInfo(f_accountId, f_sameTeam, f_teamMemberId);
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
