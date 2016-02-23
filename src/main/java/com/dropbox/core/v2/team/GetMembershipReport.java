/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Membership Report Result. Each of the items in the storage report is an array
 * of values, one value per day. If there is no data for a day, then the value
 * will be None.
 */
public class GetMembershipReport extends BaseDfbReport {
    // struct GetMembershipReport

    private final List<Long> teamSize;
    private final List<Long> pendingInvites;
    private final List<Long> membersJoined;
    private final List<Long> suspendedMembers;
    private final List<Long> licenses;

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
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GetMembershipReport other = (GetMembershipReport) obj;
            return ((this.teamSize == other.teamSize) || (this.teamSize.equals(other.teamSize)))
                && ((this.pendingInvites == other.pendingInvites) || (this.pendingInvites.equals(other.pendingInvites)))
                && ((this.membersJoined == other.membersJoined) || (this.membersJoined.equals(other.membersJoined)))
                && ((this.suspendedMembers == other.suspendedMembers) || (this.suspendedMembers.equals(other.suspendedMembers)))
                && ((this.licenses == other.licenses) || (this.licenses.equals(other.licenses)))
                && ((this.getStartDate() == other.getStartDate()) || (this.getStartDate().equals(other.getStartDate())))
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

    public static GetMembershipReport fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetMembershipReport> _JSON_WRITER = new JsonWriter<GetMembershipReport>() {
        public final void write(GetMembershipReport x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            BaseDfbReport._JSON_WRITER.writeFields(x, g);
            GetMembershipReport._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetMembershipReport x, JsonGenerator g) throws IOException {
            g.writeFieldName("team_size");
            g.writeStartArray();
            for (Long item: x.teamSize) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("pending_invites");
            g.writeStartArray();
            for (Long item: x.pendingInvites) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("members_joined");
            g.writeStartArray();
            for (Long item: x.membersJoined) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("suspended_members");
            g.writeStartArray();
            for (Long item: x.suspendedMembers) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("licenses");
            g.writeStartArray();
            for (Long item: x.licenses) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<GetMembershipReport> _JSON_READER = new JsonReader<GetMembershipReport>() {
        public final GetMembershipReport read(JsonParser parser) throws IOException, JsonReadException {
            GetMembershipReport result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetMembershipReport readFields(JsonParser parser) throws IOException, JsonReadException {
            String startDate = null;
            List<Long> teamSize = null;
            List<Long> pendingInvites = null;
            List<Long> membersJoined = null;
            List<Long> suspendedMembers = null;
            List<Long> licenses = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("start_date".equals(fieldName)) {
                    startDate = JsonReader.StringReader
                        .readField(parser, "start_date", startDate);
                }
                else if ("team_size".equals(fieldName)) {
                    teamSize = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "team_size", teamSize);
                }
                else if ("pending_invites".equals(fieldName)) {
                    pendingInvites = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "pending_invites", pendingInvites);
                }
                else if ("members_joined".equals(fieldName)) {
                    membersJoined = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "members_joined", membersJoined);
                }
                else if ("suspended_members".equals(fieldName)) {
                    suspendedMembers = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "suspended_members", suspendedMembers);
                }
                else if ("licenses".equals(fieldName)) {
                    licenses = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "licenses", licenses);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (startDate == null) {
                throw new JsonReadException("Required field \"start_date\" is missing.", parser.getTokenLocation());
            }
            if (teamSize == null) {
                throw new JsonReadException("Required field \"team_size\" is missing.", parser.getTokenLocation());
            }
            if (pendingInvites == null) {
                throw new JsonReadException("Required field \"pending_invites\" is missing.", parser.getTokenLocation());
            }
            if (membersJoined == null) {
                throw new JsonReadException("Required field \"members_joined\" is missing.", parser.getTokenLocation());
            }
            if (suspendedMembers == null) {
                throw new JsonReadException("Required field \"suspended_members\" is missing.", parser.getTokenLocation());
            }
            if (licenses == null) {
                throw new JsonReadException("Required field \"licenses\" is missing.", parser.getTokenLocation());
            }
            return new GetMembershipReport(startDate, teamSize, pendingInvites, membersJoined, suspendedMembers, licenses);
        }
    };
}
