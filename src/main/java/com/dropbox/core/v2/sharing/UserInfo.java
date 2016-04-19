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

/**
 * Basic information about a user. Use {@link
 * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccount(String)} and {@link
 * com.dropbox.core.v2.users.DbxUserUsersRequests#getAccountBatch(java.util.List)}
 * to obtain more detailed information.
 */
@JsonSerialize(using=UserInfo.Serializer.class)
@JsonDeserialize(using=UserInfo.Deserializer.class)
public class UserInfo {
    // struct UserInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<UserInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UserInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(UserInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UserInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UserInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("account_id", value.accountId);
            g.writeObjectField("same_team", value.sameTeam);
            if (value.teamMemberId != null) {
                g.writeObjectField("team_member_id", value.teamMemberId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UserInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UserInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UserInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UserInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UserInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String accountId = null;
            Boolean sameTeam = null;
            String teamMemberId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("account_id".equals(_field)) {
                    accountId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("same_team".equals(_field)) {
                    sameTeam = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (accountId == null) {
                throw new JsonParseException(_p, "Required field \"account_id\" is missing.");
            }
            if (sameTeam == null) {
                throw new JsonParseException(_p, "Required field \"same_team\" is missing.");
            }

            return new UserInfo(accountId, sameTeam, teamMemberId);
        }
    }
}
