/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.users.Team;

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
 * Information about a team member.
 */
@JsonSerialize(using=TeamMemberInfo.Serializer.class)
@JsonDeserialize(using=TeamMemberInfo.Deserializer.class)
public class TeamMemberInfo {
    // struct TeamMemberInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final Team teamInfo;
    protected final String displayName;
    protected final String memberId;

    /**
     * Information about a team member.
     *
     * @param teamInfo  Information about the member's team. Must not be {@code
     *     null}.
     * @param displayName  The display name of the user. Must not be {@code
     *     null}.
     * @param memberId  ID of user as a member of a team. This field will only
     *     be present if the member is in the same team as current user.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo(Team teamInfo, String displayName, String memberId) {
        if (teamInfo == null) {
            throw new IllegalArgumentException("Required value for 'teamInfo' is null");
        }
        this.teamInfo = teamInfo;
        if (displayName == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = displayName;
        this.memberId = memberId;
    }

    /**
     * Information about a team member.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamInfo  Information about the member's team. Must not be {@code
     *     null}.
     * @param displayName  The display name of the user. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo(Team teamInfo, String displayName) {
        this(teamInfo, displayName, null);
    }

    /**
     * Information about the member's team
     *
     * @return value for this field, never {@code null}.
     */
    public Team getTeamInfo() {
        return teamInfo;
    }

    /**
     * The display name of the user.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * ID of user as a member of a team. This field will only be present if the
     * member is in the same team as current user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getMemberId() {
        return memberId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamInfo,
            displayName,
            memberId
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
            TeamMemberInfo other = (TeamMemberInfo) obj;
            return ((this.teamInfo == other.teamInfo) || (this.teamInfo.equals(other.teamInfo)))
                && ((this.displayName == other.displayName) || (this.displayName.equals(other.displayName)))
                && ((this.memberId == other.memberId) || (this.memberId != null && this.memberId.equals(other.memberId)))
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

    static final class Serializer extends StructJsonSerializer<TeamMemberInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamMemberInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(TeamMemberInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TeamMemberInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TeamMemberInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("team_info", value.teamInfo);
            g.writeObjectField("display_name", value.displayName);
            if (value.memberId != null) {
                g.writeObjectField("member_id", value.memberId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TeamMemberInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamMemberInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TeamMemberInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TeamMemberInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TeamMemberInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Team teamInfo = null;
            String displayName = null;
            String memberId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("team_info".equals(_field)) {
                    teamInfo = _p.readValueAs(Team.class);
                    _p.nextToken();
                }
                else if ("display_name".equals(_field)) {
                    displayName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_id".equals(_field)) {
                    memberId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (teamInfo == null) {
                throw new JsonParseException(_p, "Required field \"team_info\" is missing.");
            }
            if (displayName == null) {
                throw new JsonParseException(_p, "Required field \"display_name\" is missing.");
            }

            return new TeamMemberInfo(teamInfo, displayName, memberId);
        }
    }
}
