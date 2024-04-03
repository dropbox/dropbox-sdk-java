/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.users.Team;

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
 * Information about a team member.
 */
public class TeamMemberInfo {
    // struct sharing.TeamMemberInfo (shared_links.stone)

    @Nonnull
    protected final Team teamInfo;
    @Nonnull
    protected final String displayName;
    @Nullable
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
    public TeamMemberInfo(@Nonnull Team teamInfo, @Nonnull String displayName, @Nullable String memberId) {
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
    public TeamMemberInfo(@Nonnull Team teamInfo, @Nonnull String displayName) {
        this(teamInfo, displayName, null);
    }

    /**
     * Information about the member's team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Team getTeamInfo() {
        return teamInfo;
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
     * ID of user as a member of a team. This field will only be present if the
     * member is in the same team as current user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getMemberId() {
        return memberId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.teamInfo,
            this.displayName,
            this.memberId
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
    static class Serializer extends StructSerializer<TeamMemberInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_info");
            Team.Serializer.INSTANCE.serialize(value.teamInfo, g);
            g.writeFieldName("display_name");
            StoneSerializers.string().serialize(value.displayName, g);
            if (value.memberId != null) {
                g.writeFieldName("member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.memberId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Team f_teamInfo = null;
                String f_displayName = null;
                String f_memberId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_info".equals(field)) {
                        f_teamInfo = Team.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("member_id".equals(field)) {
                        f_memberId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamInfo == null) {
                    throw new JsonParseException(p, "Required field \"team_info\" missing.");
                }
                if (f_displayName == null) {
                    throw new JsonParseException(p, "Required field \"display_name\" missing.");
                }
                value = new TeamMemberInfo(f_teamInfo, f_displayName, f_memberId);
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
