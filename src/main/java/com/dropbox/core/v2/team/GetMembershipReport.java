/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

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
import java.util.List;

/**
 * Membership Report Result. Each of the items in the storage report is an array
 * of values, one value per day. If there is no data for a day, then the value
 * will be None.
 */
@JsonSerialize(using=GetMembershipReport.Serializer.class)
@JsonDeserialize(using=GetMembershipReport.Deserializer.class)
public class GetMembershipReport extends BaseDfbReport {
    // struct GetMembershipReport

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<Long> teamSize;
    protected final List<Long> pendingInvites;
    protected final List<Long> membersJoined;
    protected final List<Long> suspendedMembers;
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
     * @param suspendedMembers  The number of members that joined the team, for
     *     each day. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param licenses  The total number of licenses the team has, for each day.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMembershipReport(String startDate, List<Long> teamSize, List<Long> pendingInvites, List<Long> membersJoined, List<Long> suspendedMembers, List<Long> licenses) {
        super(startDate);
        if (teamSize == null) {
            throw new IllegalArgumentException("Required value for 'teamSize' is null");
        }
        for (Long x : teamSize) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'teamSize' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'teamSize': type Nullable");
        }
        this.teamSize = teamSize;
        if (pendingInvites == null) {
            throw new IllegalArgumentException("Required value for 'pendingInvites' is null");
        }
        for (Long x : pendingInvites) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'pendingInvites' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'pendingInvites': type Nullable");
        }
        this.pendingInvites = pendingInvites;
        if (membersJoined == null) {
            throw new IllegalArgumentException("Required value for 'membersJoined' is null");
        }
        for (Long x : membersJoined) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'membersJoined' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'membersJoined': type Nullable");
        }
        this.membersJoined = membersJoined;
        if (suspendedMembers == null) {
            throw new IllegalArgumentException("Required value for 'suspendedMembers' is null");
        }
        for (Long x : suspendedMembers) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'suspendedMembers' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'suspendedMembers': type Nullable");
        }
        this.suspendedMembers = suspendedMembers;
        if (licenses == null) {
            throw new IllegalArgumentException("Required value for 'licenses' is null");
        }
        for (Long x : licenses) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'licenses' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'licenses': type Nullable");
        }
        this.licenses = licenses;
    }

    /**
     * Team size, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getTeamSize() {
        return teamSize;
    }

    /**
     * The number of pending invites to the team, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getPendingInvites() {
        return pendingInvites;
    }

    /**
     * The number of members that joined the team, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getMembersJoined() {
        return membersJoined;
    }

    /**
     * The number of members that joined the team, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getSuspendedMembers() {
        return suspendedMembers;
    }

    /**
     * The total number of licenses the team has, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getLicenses() {
        return licenses;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamSize,
            pendingInvites,
            membersJoined,
            suspendedMembers,
            licenses
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
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

    static final class Serializer extends StructJsonSerializer<GetMembershipReport> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetMembershipReport.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetMembershipReport.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetMembershipReport> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetMembershipReport value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("start_date", value.startDate);
            g.writeObjectField("team_size", value.teamSize);
            g.writeObjectField("pending_invites", value.pendingInvites);
            g.writeObjectField("members_joined", value.membersJoined);
            g.writeObjectField("suspended_members", value.suspendedMembers);
            g.writeObjectField("licenses", value.licenses);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetMembershipReport> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetMembershipReport.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetMembershipReport.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetMembershipReport> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetMembershipReport deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String startDate = null;
            List<Long> teamSize = null;
            List<Long> pendingInvites = null;
            List<Long> membersJoined = null;
            List<Long> suspendedMembers = null;
            List<Long> licenses = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("start_date".equals(_field)) {
                    startDate = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("team_size".equals(_field)) {
                    expectArrayStart(_p);
                    teamSize = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        teamSize.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("pending_invites".equals(_field)) {
                    expectArrayStart(_p);
                    pendingInvites = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        pendingInvites.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("members_joined".equals(_field)) {
                    expectArrayStart(_p);
                    membersJoined = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        membersJoined.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("suspended_members".equals(_field)) {
                    expectArrayStart(_p);
                    suspendedMembers = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        suspendedMembers.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("licenses".equals(_field)) {
                    expectArrayStart(_p);
                    licenses = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        licenses.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (startDate == null) {
                throw new JsonParseException(_p, "Required field \"start_date\" is missing.");
            }
            if (teamSize == null) {
                throw new JsonParseException(_p, "Required field \"team_size\" is missing.");
            }
            if (pendingInvites == null) {
                throw new JsonParseException(_p, "Required field \"pending_invites\" is missing.");
            }
            if (membersJoined == null) {
                throw new JsonParseException(_p, "Required field \"members_joined\" is missing.");
            }
            if (suspendedMembers == null) {
                throw new JsonParseException(_p, "Required field \"suspended_members\" is missing.");
            }
            if (licenses == null) {
                throw new JsonParseException(_p, "Required field \"licenses\" is missing.");
            }

            return new GetMembershipReport(startDate, teamSize, pendingInvites, membersJoined, suspendedMembers, licenses);
        }
    }
}
