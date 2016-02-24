/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Basic information about a user. Use {@link
 * com.dropbox.core.v2.users.DbxUsers#getAccount(String)} and {@link
 * com.dropbox.core.v2.users.DbxUsers#getAccountBatch(java.util.List)} to obtain
 * more detailed information.
 */
public class UserInfo {
    // struct UserInfo

    private final String accountId;
    private final boolean sameTeam;
    private final String teamMemberId;

    /**
     * Basic information about a user. Use {@link
     * com.dropbox.core.v2.users.DbxUsers#getAccount(String)} and {@link
     * com.dropbox.core.v2.users.DbxUsers#getAccountBatch(java.util.List)} to
     * obtain more detailed information.
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
     * com.dropbox.core.v2.users.DbxUsers#getAccount(String)} and {@link
     * com.dropbox.core.v2.users.DbxUsers#getAccountBatch(java.util.List)} to
     * obtain more detailed information.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UserInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UserInfo> _JSON_WRITER = new JsonWriter<UserInfo>() {
        public final void write(UserInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UserInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UserInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("account_id");
            g.writeString(x.accountId);
            g.writeFieldName("same_team");
            g.writeBoolean(x.sameTeam);
            if (x.teamMemberId != null) {
                g.writeFieldName("team_member_id");
                g.writeString(x.teamMemberId);
            }
        }
    };

    public static final JsonReader<UserInfo> _JSON_READER = new JsonReader<UserInfo>() {
        public final UserInfo read(JsonParser parser) throws IOException, JsonReadException {
            UserInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UserInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            String accountId = null;
            Boolean sameTeam = null;
            String teamMemberId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("account_id".equals(fieldName)) {
                    accountId = JsonReader.StringReader
                        .readField(parser, "account_id", accountId);
                }
                else if ("same_team".equals(fieldName)) {
                    sameTeam = JsonReader.BooleanReader
                        .readField(parser, "same_team", sameTeam);
                }
                else if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (accountId == null) {
                throw new JsonReadException("Required field \"account_id\" is missing.", parser.getTokenLocation());
            }
            if (sameTeam == null) {
                throw new JsonReadException("Required field \"same_team\" is missing.", parser.getTokenLocation());
            }
            return new UserInfo(accountId, sameTeam, teamMemberId);
        }
    };
}
