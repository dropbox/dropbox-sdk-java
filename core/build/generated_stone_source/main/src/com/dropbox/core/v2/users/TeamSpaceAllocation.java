/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teamcommon.MemberSpaceLimitType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

public class TeamSpaceAllocation {
    // struct users.TeamSpaceAllocation (users.stone)

    protected final long used;
    protected final long allocated;
    protected final long userWithinTeamSpaceAllocated;
    @Nonnull
    protected final MemberSpaceLimitType userWithinTeamSpaceLimitType;
    protected final long userWithinTeamSpaceUsedCached;

    /**
     *
     * @param used  The total space currently used by the user's team (bytes).
     * @param allocated  The total space allocated to the user's team (bytes).
     * @param userWithinTeamSpaceAllocated  The total space allocated to the
     *     user within its team allocated space (0 means that no restriction is
     *     imposed on the user's quota within its team).
     * @param userWithinTeamSpaceLimitType  The type of the space limit imposed
     *     on the team member (off, alert_only, stop_sync). Must not be {@code
     *     null}.
     * @param userWithinTeamSpaceUsedCached  An accurate cached calculation of a
     *     team member's total space usage (bytes).
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamSpaceAllocation(long used, long allocated, long userWithinTeamSpaceAllocated, @Nonnull MemberSpaceLimitType userWithinTeamSpaceLimitType, long userWithinTeamSpaceUsedCached) {
        this.used = used;
        this.allocated = allocated;
        this.userWithinTeamSpaceAllocated = userWithinTeamSpaceAllocated;
        if (userWithinTeamSpaceLimitType == null) {
            throw new IllegalArgumentException("Required value for 'userWithinTeamSpaceLimitType' is null");
        }
        this.userWithinTeamSpaceLimitType = userWithinTeamSpaceLimitType;
        this.userWithinTeamSpaceUsedCached = userWithinTeamSpaceUsedCached;
    }

    /**
     * The total space currently used by the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getUsed() {
        return used;
    }

    /**
     * The total space allocated to the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getAllocated() {
        return allocated;
    }

    /**
     * The total space allocated to the user within its team allocated space (0
     * means that no restriction is imposed on the user's quota within its
     * team).
     *
     * @return value for this field.
     */
    public long getUserWithinTeamSpaceAllocated() {
        return userWithinTeamSpaceAllocated;
    }

    /**
     * The type of the space limit imposed on the team member (off, alert_only,
     * stop_sync).
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public MemberSpaceLimitType getUserWithinTeamSpaceLimitType() {
        return userWithinTeamSpaceLimitType;
    }

    /**
     * An accurate cached calculation of a team member's total space usage
     * (bytes).
     *
     * @return value for this field.
     */
    public long getUserWithinTeamSpaceUsedCached() {
        return userWithinTeamSpaceUsedCached;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.used,
            this.allocated,
            this.userWithinTeamSpaceAllocated,
            this.userWithinTeamSpaceLimitType,
            this.userWithinTeamSpaceUsedCached
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
            TeamSpaceAllocation other = (TeamSpaceAllocation) obj;
            return (this.used == other.used)
                && (this.allocated == other.allocated)
                && (this.userWithinTeamSpaceAllocated == other.userWithinTeamSpaceAllocated)
                && ((this.userWithinTeamSpaceLimitType == other.userWithinTeamSpaceLimitType) || (this.userWithinTeamSpaceLimitType.equals(other.userWithinTeamSpaceLimitType)))
                && (this.userWithinTeamSpaceUsedCached == other.userWithinTeamSpaceUsedCached)
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
    static class Serializer extends StructSerializer<TeamSpaceAllocation> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamSpaceAllocation value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("used");
            StoneSerializers.uInt64().serialize(value.used, g);
            g.writeFieldName("allocated");
            StoneSerializers.uInt64().serialize(value.allocated, g);
            g.writeFieldName("user_within_team_space_allocated");
            StoneSerializers.uInt64().serialize(value.userWithinTeamSpaceAllocated, g);
            g.writeFieldName("user_within_team_space_limit_type");
            MemberSpaceLimitType.Serializer.INSTANCE.serialize(value.userWithinTeamSpaceLimitType, g);
            g.writeFieldName("user_within_team_space_used_cached");
            StoneSerializers.uInt64().serialize(value.userWithinTeamSpaceUsedCached, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamSpaceAllocation deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamSpaceAllocation value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_used = null;
                Long f_allocated = null;
                Long f_userWithinTeamSpaceAllocated = null;
                MemberSpaceLimitType f_userWithinTeamSpaceLimitType = null;
                Long f_userWithinTeamSpaceUsedCached = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("used".equals(field)) {
                        f_used = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("allocated".equals(field)) {
                        f_allocated = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("user_within_team_space_allocated".equals(field)) {
                        f_userWithinTeamSpaceAllocated = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("user_within_team_space_limit_type".equals(field)) {
                        f_userWithinTeamSpaceLimitType = MemberSpaceLimitType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("user_within_team_space_used_cached".equals(field)) {
                        f_userWithinTeamSpaceUsedCached = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_used == null) {
                    throw new JsonParseException(p, "Required field \"used\" missing.");
                }
                if (f_allocated == null) {
                    throw new JsonParseException(p, "Required field \"allocated\" missing.");
                }
                if (f_userWithinTeamSpaceAllocated == null) {
                    throw new JsonParseException(p, "Required field \"user_within_team_space_allocated\" missing.");
                }
                if (f_userWithinTeamSpaceLimitType == null) {
                    throw new JsonParseException(p, "Required field \"user_within_team_space_limit_type\" missing.");
                }
                if (f_userWithinTeamSpaceUsedCached == null) {
                    throw new JsonParseException(p, "Required field \"user_within_team_space_used_cached\" missing.");
                }
                value = new TeamSpaceAllocation(f_used, f_allocated, f_userWithinTeamSpaceAllocated, f_userWithinTeamSpaceLimitType, f_userWithinTeamSpaceUsedCached);
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
