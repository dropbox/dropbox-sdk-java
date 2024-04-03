/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

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
import java.util.List;

import javax.annotation.Nonnull;

/**
 * Membership Report Result. Each of the items in the storage report is an array
 * of values, one value per day. If there is no data for a day, then the value
 * will be None.
 */
public class GetMembershipReport extends BaseDfbReport {
    // struct team.GetMembershipReport (team_reports.stone)

    @Nonnull
    protected final List<Long> teamSize;
    @Nonnull
    protected final List<Long> pendingInvites;
    @Nonnull
    protected final List<Long> membersJoined;
    @Nonnull
    protected final List<Long> suspendedMembers;
    @Nonnull
    protected final List<Long> licenses;

    /**
     * Membership Report Result. Each of the items in the storage report is an
     * array of values, one value per day. If there is no data for a day, then
     * the value will be None.
     *
     * @param startDate  First date present in the results as 'YYYY-MM-DD' or
     *     None. Must not be {@code null}.
     * @param teamSize  Team size, for each day. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param pendingInvites  The number of pending invites to the team, for
     *     each day. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param membersJoined  The number of members that joined the team, for
     *     each day. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param suspendedMembers  The number of suspended team members, for each
     *     day. Must not contain a {@code null} item and not be {@code null}.
     * @param licenses  The total number of licenses the team has, for each day.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMembershipReport(@Nonnull String startDate, @Nonnull List<Long> teamSize, @Nonnull List<Long> pendingInvites, @Nonnull List<Long> membersJoined, @Nonnull List<Long> suspendedMembers, @Nonnull List<Long> licenses) {
        super(startDate);
        if (teamSize == null) {
            throw new IllegalArgumentException("Required value for 'teamSize' is null");
        }
        for (Long x : teamSize) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'teamSize' is null");
            }
        }
        this.teamSize = teamSize;
        if (pendingInvites == null) {
            throw new IllegalArgumentException("Required value for 'pendingInvites' is null");
        }
        for (Long x : pendingInvites) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'pendingInvites' is null");
            }
        }
        this.pendingInvites = pendingInvites;
        if (membersJoined == null) {
            throw new IllegalArgumentException("Required value for 'membersJoined' is null");
        }
        for (Long x : membersJoined) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'membersJoined' is null");
            }
        }
        this.membersJoined = membersJoined;
        if (suspendedMembers == null) {
            throw new IllegalArgumentException("Required value for 'suspendedMembers' is null");
        }
        for (Long x : suspendedMembers) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'suspendedMembers' is null");
            }
        }
        this.suspendedMembers = suspendedMembers;
        if (licenses == null) {
            throw new IllegalArgumentException("Required value for 'licenses' is null");
        }
        for (Long x : licenses) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'licenses' is null");
            }
        }
        this.licenses = licenses;
    }

    /**
     * First date present in the results as 'YYYY-MM-DD' or None.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getStartDate() {
        return startDate;
    }

    /**
     * Team size, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getTeamSize() {
        return teamSize;
    }

    /**
     * The number of pending invites to the team, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getPendingInvites() {
        return pendingInvites;
    }

    /**
     * The number of members that joined the team, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getMembersJoined() {
        return membersJoined;
    }

    /**
     * The number of suspended team members, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSuspendedMembers() {
        return suspendedMembers;
    }

    /**
     * The total number of licenses the team has, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getLicenses() {
        return licenses;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.teamSize,
            this.pendingInvites,
            this.membersJoined,
            this.suspendedMembers,
            this.licenses
        });
        hash = (31 * super.hashCode()) + hash;
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
            GetMembershipReport other = (GetMembershipReport) obj;
            return ((this.startDate == other.startDate) || (this.startDate.equals(other.startDate)))
                && ((this.teamSize == other.teamSize) || (this.teamSize.equals(other.teamSize)))
                && ((this.pendingInvites == other.pendingInvites) || (this.pendingInvites.equals(other.pendingInvites)))
                && ((this.membersJoined == other.membersJoined) || (this.membersJoined.equals(other.membersJoined)))
                && ((this.suspendedMembers == other.suspendedMembers) || (this.suspendedMembers.equals(other.suspendedMembers)))
                && ((this.licenses == other.licenses) || (this.licenses.equals(other.licenses)))
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
    static class Serializer extends StructSerializer<GetMembershipReport> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetMembershipReport value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("start_date");
            StoneSerializers.string().serialize(value.startDate, g);
            g.writeFieldName("team_size");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.teamSize, g);
            g.writeFieldName("pending_invites");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.pendingInvites, g);
            g.writeFieldName("members_joined");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.membersJoined, g);
            g.writeFieldName("suspended_members");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.suspendedMembers, g);
            g.writeFieldName("licenses");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.licenses, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetMembershipReport deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetMembershipReport value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_startDate = null;
                List<Long> f_teamSize = null;
                List<Long> f_pendingInvites = null;
                List<Long> f_membersJoined = null;
                List<Long> f_suspendedMembers = null;
                List<Long> f_licenses = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.string().deserialize(p);
                    }
                    else if ("team_size".equals(field)) {
                        f_teamSize = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("pending_invites".equals(field)) {
                        f_pendingInvites = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("members_joined".equals(field)) {
                        f_membersJoined = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("suspended_members".equals(field)) {
                        f_suspendedMembers = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("licenses".equals(field)) {
                        f_licenses = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                if (f_teamSize == null) {
                    throw new JsonParseException(p, "Required field \"team_size\" missing.");
                }
                if (f_pendingInvites == null) {
                    throw new JsonParseException(p, "Required field \"pending_invites\" missing.");
                }
                if (f_membersJoined == null) {
                    throw new JsonParseException(p, "Required field \"members_joined\" missing.");
                }
                if (f_suspendedMembers == null) {
                    throw new JsonParseException(p, "Required field \"suspended_members\" missing.");
                }
                if (f_licenses == null) {
                    throw new JsonParseException(p, "Required field \"licenses\" missing.");
                }
                value = new GetMembershipReport(f_startDate, f_teamSize, f_pendingInvites, f_membersJoined, f_suspendedMembers, f_licenses);
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
