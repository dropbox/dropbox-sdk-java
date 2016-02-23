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
 * Activity Report Result. Each of the items in the storage report is an array
 * of values, one value per day. If there is no data for a day, then the value
 * will be None.
 */
public class GetActivityReport extends BaseDfbReport {
    // struct GetActivityReport

    private final List<Long> adds;
    private final List<Long> edits;
    private final List<Long> deletes;
    private final List<Long> activeUsers28Day;
    private final List<Long> activeUsers7Day;
    private final List<Long> activeUsers1Day;
    private final List<Long> activeSharedFolders28Day;
    private final List<Long> activeSharedFolders7Day;
    private final List<Long> activeSharedFolders1Day;
    private final List<Long> sharedLinksCreated;
    private final List<Long> sharedLinksViewedByTeam;
    private final List<Long> sharedLinksViewedByOutsideUser;
    private final List<Long> sharedLinksViewedByNotLoggedIn;
    private final List<Long> sharedLinksViewedTotal;

    /**
     * Activity Report Result. Each of the items in the storage report is an
     * array of values, one value per day. If there is no data for a day, then
     * the value will be None.
     *
     * @param startDate  First date present in the results as 'YYYY-MM-DD' or
     *     None. Must not be {@code null}.
     * @param adds  Array of total number of adds by team members. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param edits  Array of number of edits by team members. If the same user
     *     edits the same file multiple times this is counted as a single edit.
     *     Must not contain a {@code null} item and not be {@code null}.
     * @param deletes  Array of total number of deletes by team members. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param activeUsers28Day  Array of the number of users who have been
     *     active in the last 28 days. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param activeUsers7Day  Array of the number of users who have been active
     *     in the last week. Must not contain a {@code null} item and not be
     *     {@code null}.
     * @param activeUsers1Day  Array of the number of users who have been active
     *     in the last day. Must not contain a {@code null} item and not be
     *     {@code null}.
     * @param activeSharedFolders28Day  Array of the number of shared folders
     *     with some activity in the last 28 days. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param activeSharedFolders7Day  Array of the number of shared folders
     *     with some activity in the last week. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param activeSharedFolders1Day  Array of the number of shared folders
     *     with some activity in the last day. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param sharedLinksCreated  Array of the number of shared links created.
     *     Must not contain a {@code null} item and not be {@code null}.
     * @param sharedLinksViewedByTeam  Array of the number of views by team
     *     users to shared links created by the team. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param sharedLinksViewedByOutsideUser  Array of the number of views by
     *     users outside of the team to shared links created by the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param sharedLinksViewedByNotLoggedIn  Array of the number of views by
     *     non-logged-in users to shared links created by the team. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param sharedLinksViewedTotal  Array of the total number of views to
     *     shared links created by the team. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetActivityReport(String startDate, List<Long> adds, List<Long> edits, List<Long> deletes, List<Long> activeUsers28Day, List<Long> activeUsers7Day, List<Long> activeUsers1Day, List<Long> activeSharedFolders28Day, List<Long> activeSharedFolders7Day, List<Long> activeSharedFolders1Day, List<Long> sharedLinksCreated, List<Long> sharedLinksViewedByTeam, List<Long> sharedLinksViewedByOutsideUser, List<Long> sharedLinksViewedByNotLoggedIn, List<Long> sharedLinksViewedTotal) {
        super(startDate);
        if (adds == null) {
            throw new IllegalArgumentException("Required value for 'adds' is null");
        }
        for (Long x : adds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'adds' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'adds': type Nullable");
        }
        this.adds = adds;
        if (edits == null) {
            throw new IllegalArgumentException("Required value for 'edits' is null");
        }
        for (Long x : edits) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'edits' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'edits': type Nullable");
        }
        this.edits = edits;
        if (deletes == null) {
            throw new IllegalArgumentException("Required value for 'deletes' is null");
        }
        for (Long x : deletes) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'deletes' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'deletes': type Nullable");
        }
        this.deletes = deletes;
        if (activeUsers28Day == null) {
            throw new IllegalArgumentException("Required value for 'activeUsers28Day' is null");
        }
        for (Long x : activeUsers28Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeUsers28Day' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'activeUsers28Day': type Nullable");
        }
        this.activeUsers28Day = activeUsers28Day;
        if (activeUsers7Day == null) {
            throw new IllegalArgumentException("Required value for 'activeUsers7Day' is null");
        }
        for (Long x : activeUsers7Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeUsers7Day' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'activeUsers7Day': type Nullable");
        }
        this.activeUsers7Day = activeUsers7Day;
        if (activeUsers1Day == null) {
            throw new IllegalArgumentException("Required value for 'activeUsers1Day' is null");
        }
        for (Long x : activeUsers1Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeUsers1Day' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'activeUsers1Day': type Nullable");
        }
        this.activeUsers1Day = activeUsers1Day;
        if (activeSharedFolders28Day == null) {
            throw new IllegalArgumentException("Required value for 'activeSharedFolders28Day' is null");
        }
        for (Long x : activeSharedFolders28Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeSharedFolders28Day' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'activeSharedFolders28Day': type Nullable");
        }
        this.activeSharedFolders28Day = activeSharedFolders28Day;
        if (activeSharedFolders7Day == null) {
            throw new IllegalArgumentException("Required value for 'activeSharedFolders7Day' is null");
        }
        for (Long x : activeSharedFolders7Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeSharedFolders7Day' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'activeSharedFolders7Day': type Nullable");
        }
        this.activeSharedFolders7Day = activeSharedFolders7Day;
        if (activeSharedFolders1Day == null) {
            throw new IllegalArgumentException("Required value for 'activeSharedFolders1Day' is null");
        }
        for (Long x : activeSharedFolders1Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeSharedFolders1Day' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'activeSharedFolders1Day': type Nullable");
        }
        this.activeSharedFolders1Day = activeSharedFolders1Day;
        if (sharedLinksCreated == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksCreated' is null");
        }
        for (Long x : sharedLinksCreated) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksCreated' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'sharedLinksCreated': type Nullable");
        }
        this.sharedLinksCreated = sharedLinksCreated;
        if (sharedLinksViewedByTeam == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedByTeam' is null");
        }
        for (Long x : sharedLinksViewedByTeam) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedByTeam' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'sharedLinksViewedByTeam': type Nullable");
        }
        this.sharedLinksViewedByTeam = sharedLinksViewedByTeam;
        if (sharedLinksViewedByOutsideUser == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedByOutsideUser' is null");
        }
        for (Long x : sharedLinksViewedByOutsideUser) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedByOutsideUser' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'sharedLinksViewedByOutsideUser': type Nullable");
        }
        this.sharedLinksViewedByOutsideUser = sharedLinksViewedByOutsideUser;
        if (sharedLinksViewedByNotLoggedIn == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedByNotLoggedIn' is null");
        }
        for (Long x : sharedLinksViewedByNotLoggedIn) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedByNotLoggedIn' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'sharedLinksViewedByNotLoggedIn': type Nullable");
        }
        this.sharedLinksViewedByNotLoggedIn = sharedLinksViewedByNotLoggedIn;
        if (sharedLinksViewedTotal == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedTotal' is null");
        }
        for (Long x : sharedLinksViewedTotal) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedTotal' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'sharedLinksViewedTotal': type Nullable");
        }
        this.sharedLinksViewedTotal = sharedLinksViewedTotal;
    }

    /**
     * Array of total number of adds by team members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getAdds() {
        return adds;
    }

    /**
     * Array of number of edits by team members. If the same user edits the same
     * file multiple times this is counted as a single edit.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getEdits() {
        return edits;
    }

    /**
     * Array of total number of deletes by team members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getDeletes() {
        return deletes;
    }

    /**
     * Array of the number of users who have been active in the last 28 days.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getActiveUsers28Day() {
        return activeUsers28Day;
    }

    /**
     * Array of the number of users who have been active in the last week.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getActiveUsers7Day() {
        return activeUsers7Day;
    }

    /**
     * Array of the number of users who have been active in the last day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getActiveUsers1Day() {
        return activeUsers1Day;
    }

    /**
     * Array of the number of shared folders with some activity in the last 28
     * days.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getActiveSharedFolders28Day() {
        return activeSharedFolders28Day;
    }

    /**
     * Array of the number of shared folders with some activity in the last
     * week.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getActiveSharedFolders7Day() {
        return activeSharedFolders7Day;
    }

    /**
     * Array of the number of shared folders with some activity in the last day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getActiveSharedFolders1Day() {
        return activeSharedFolders1Day;
    }

    /**
     * Array of the number of shared links created.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getSharedLinksCreated() {
        return sharedLinksCreated;
    }

    /**
     * Array of the number of views by team users to shared links created by the
     * team.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getSharedLinksViewedByTeam() {
        return sharedLinksViewedByTeam;
    }

    /**
     * Array of the number of views by users outside of the team to shared links
     * created by the team.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getSharedLinksViewedByOutsideUser() {
        return sharedLinksViewedByOutsideUser;
    }

    /**
     * Array of the number of views by non-logged-in users to shared links
     * created by the team.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getSharedLinksViewedByNotLoggedIn() {
        return sharedLinksViewedByNotLoggedIn;
    }

    /**
     * Array of the total number of views to shared links created by the team.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getSharedLinksViewedTotal() {
        return sharedLinksViewedTotal;
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
            GetActivityReport other = (GetActivityReport) obj;
            return ((this.adds == other.adds) || (this.adds.equals(other.adds)))
                && ((this.edits == other.edits) || (this.edits.equals(other.edits)))
                && ((this.deletes == other.deletes) || (this.deletes.equals(other.deletes)))
                && ((this.activeUsers28Day == other.activeUsers28Day) || (this.activeUsers28Day.equals(other.activeUsers28Day)))
                && ((this.activeUsers7Day == other.activeUsers7Day) || (this.activeUsers7Day.equals(other.activeUsers7Day)))
                && ((this.activeUsers1Day == other.activeUsers1Day) || (this.activeUsers1Day.equals(other.activeUsers1Day)))
                && ((this.activeSharedFolders28Day == other.activeSharedFolders28Day) || (this.activeSharedFolders28Day.equals(other.activeSharedFolders28Day)))
                && ((this.activeSharedFolders7Day == other.activeSharedFolders7Day) || (this.activeSharedFolders7Day.equals(other.activeSharedFolders7Day)))
                && ((this.activeSharedFolders1Day == other.activeSharedFolders1Day) || (this.activeSharedFolders1Day.equals(other.activeSharedFolders1Day)))
                && ((this.sharedLinksCreated == other.sharedLinksCreated) || (this.sharedLinksCreated.equals(other.sharedLinksCreated)))
                && ((this.sharedLinksViewedByTeam == other.sharedLinksViewedByTeam) || (this.sharedLinksViewedByTeam.equals(other.sharedLinksViewedByTeam)))
                && ((this.sharedLinksViewedByOutsideUser == other.sharedLinksViewedByOutsideUser) || (this.sharedLinksViewedByOutsideUser.equals(other.sharedLinksViewedByOutsideUser)))
                && ((this.sharedLinksViewedByNotLoggedIn == other.sharedLinksViewedByNotLoggedIn) || (this.sharedLinksViewedByNotLoggedIn.equals(other.sharedLinksViewedByNotLoggedIn)))
                && ((this.sharedLinksViewedTotal == other.sharedLinksViewedTotal) || (this.sharedLinksViewedTotal.equals(other.sharedLinksViewedTotal)))
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

    public static GetActivityReport fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetActivityReport> _JSON_WRITER = new JsonWriter<GetActivityReport>() {
        public final void write(GetActivityReport x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            BaseDfbReport._JSON_WRITER.writeFields(x, g);
            GetActivityReport._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetActivityReport x, JsonGenerator g) throws IOException {
            g.writeFieldName("adds");
            g.writeStartArray();
            for (Long item: x.adds) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("edits");
            g.writeStartArray();
            for (Long item: x.edits) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("deletes");
            g.writeStartArray();
            for (Long item: x.deletes) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("active_users_28_day");
            g.writeStartArray();
            for (Long item: x.activeUsers28Day) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("active_users_7_day");
            g.writeStartArray();
            for (Long item: x.activeUsers7Day) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("active_users_1_day");
            g.writeStartArray();
            for (Long item: x.activeUsers1Day) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("active_shared_folders_28_day");
            g.writeStartArray();
            for (Long item: x.activeSharedFolders28Day) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("active_shared_folders_7_day");
            g.writeStartArray();
            for (Long item: x.activeSharedFolders7Day) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("active_shared_folders_1_day");
            g.writeStartArray();
            for (Long item: x.activeSharedFolders1Day) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("shared_links_created");
            g.writeStartArray();
            for (Long item: x.sharedLinksCreated) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("shared_links_viewed_by_team");
            g.writeStartArray();
            for (Long item: x.sharedLinksViewedByTeam) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("shared_links_viewed_by_outside_user");
            g.writeStartArray();
            for (Long item: x.sharedLinksViewedByOutsideUser) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("shared_links_viewed_by_not_logged_in");
            g.writeStartArray();
            for (Long item: x.sharedLinksViewedByNotLoggedIn) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("shared_links_viewed_total");
            g.writeStartArray();
            for (Long item: x.sharedLinksViewedTotal) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<GetActivityReport> _JSON_READER = new JsonReader<GetActivityReport>() {
        public final GetActivityReport read(JsonParser parser) throws IOException, JsonReadException {
            GetActivityReport result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetActivityReport readFields(JsonParser parser) throws IOException, JsonReadException {
            String startDate = null;
            List<Long> adds = null;
            List<Long> edits = null;
            List<Long> deletes = null;
            List<Long> activeUsers28Day = null;
            List<Long> activeUsers7Day = null;
            List<Long> activeUsers1Day = null;
            List<Long> activeSharedFolders28Day = null;
            List<Long> activeSharedFolders7Day = null;
            List<Long> activeSharedFolders1Day = null;
            List<Long> sharedLinksCreated = null;
            List<Long> sharedLinksViewedByTeam = null;
            List<Long> sharedLinksViewedByOutsideUser = null;
            List<Long> sharedLinksViewedByNotLoggedIn = null;
            List<Long> sharedLinksViewedTotal = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("start_date".equals(fieldName)) {
                    startDate = JsonReader.StringReader
                        .readField(parser, "start_date", startDate);
                }
                else if ("adds".equals(fieldName)) {
                    adds = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "adds", adds);
                }
                else if ("edits".equals(fieldName)) {
                    edits = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "edits", edits);
                }
                else if ("deletes".equals(fieldName)) {
                    deletes = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "deletes", deletes);
                }
                else if ("active_users_28_day".equals(fieldName)) {
                    activeUsers28Day = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "active_users_28_day", activeUsers28Day);
                }
                else if ("active_users_7_day".equals(fieldName)) {
                    activeUsers7Day = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "active_users_7_day", activeUsers7Day);
                }
                else if ("active_users_1_day".equals(fieldName)) {
                    activeUsers1Day = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "active_users_1_day", activeUsers1Day);
                }
                else if ("active_shared_folders_28_day".equals(fieldName)) {
                    activeSharedFolders28Day = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "active_shared_folders_28_day", activeSharedFolders28Day);
                }
                else if ("active_shared_folders_7_day".equals(fieldName)) {
                    activeSharedFolders7Day = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "active_shared_folders_7_day", activeSharedFolders7Day);
                }
                else if ("active_shared_folders_1_day".equals(fieldName)) {
                    activeSharedFolders1Day = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "active_shared_folders_1_day", activeSharedFolders1Day);
                }
                else if ("shared_links_created".equals(fieldName)) {
                    sharedLinksCreated = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "shared_links_created", sharedLinksCreated);
                }
                else if ("shared_links_viewed_by_team".equals(fieldName)) {
                    sharedLinksViewedByTeam = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "shared_links_viewed_by_team", sharedLinksViewedByTeam);
                }
                else if ("shared_links_viewed_by_outside_user".equals(fieldName)) {
                    sharedLinksViewedByOutsideUser = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "shared_links_viewed_by_outside_user", sharedLinksViewedByOutsideUser);
                }
                else if ("shared_links_viewed_by_not_logged_in".equals(fieldName)) {
                    sharedLinksViewedByNotLoggedIn = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "shared_links_viewed_by_not_logged_in", sharedLinksViewedByNotLoggedIn);
                }
                else if ("shared_links_viewed_total".equals(fieldName)) {
                    sharedLinksViewedTotal = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "shared_links_viewed_total", sharedLinksViewedTotal);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (startDate == null) {
                throw new JsonReadException("Required field \"start_date\" is missing.", parser.getTokenLocation());
            }
            if (adds == null) {
                throw new JsonReadException("Required field \"adds\" is missing.", parser.getTokenLocation());
            }
            if (edits == null) {
                throw new JsonReadException("Required field \"edits\" is missing.", parser.getTokenLocation());
            }
            if (deletes == null) {
                throw new JsonReadException("Required field \"deletes\" is missing.", parser.getTokenLocation());
            }
            if (activeUsers28Day == null) {
                throw new JsonReadException("Required field \"active_users_28_day\" is missing.", parser.getTokenLocation());
            }
            if (activeUsers7Day == null) {
                throw new JsonReadException("Required field \"active_users_7_day\" is missing.", parser.getTokenLocation());
            }
            if (activeUsers1Day == null) {
                throw new JsonReadException("Required field \"active_users_1_day\" is missing.", parser.getTokenLocation());
            }
            if (activeSharedFolders28Day == null) {
                throw new JsonReadException("Required field \"active_shared_folders_28_day\" is missing.", parser.getTokenLocation());
            }
            if (activeSharedFolders7Day == null) {
                throw new JsonReadException("Required field \"active_shared_folders_7_day\" is missing.", parser.getTokenLocation());
            }
            if (activeSharedFolders1Day == null) {
                throw new JsonReadException("Required field \"active_shared_folders_1_day\" is missing.", parser.getTokenLocation());
            }
            if (sharedLinksCreated == null) {
                throw new JsonReadException("Required field \"shared_links_created\" is missing.", parser.getTokenLocation());
            }
            if (sharedLinksViewedByTeam == null) {
                throw new JsonReadException("Required field \"shared_links_viewed_by_team\" is missing.", parser.getTokenLocation());
            }
            if (sharedLinksViewedByOutsideUser == null) {
                throw new JsonReadException("Required field \"shared_links_viewed_by_outside_user\" is missing.", parser.getTokenLocation());
            }
            if (sharedLinksViewedByNotLoggedIn == null) {
                throw new JsonReadException("Required field \"shared_links_viewed_by_not_logged_in\" is missing.", parser.getTokenLocation());
            }
            if (sharedLinksViewedTotal == null) {
                throw new JsonReadException("Required field \"shared_links_viewed_total\" is missing.", parser.getTokenLocation());
            }
            return new GetActivityReport(startDate, adds, edits, deletes, activeUsers28Day, activeUsers7Day, activeUsers1Day, activeSharedFolders28Day, activeSharedFolders7Day, activeSharedFolders1Day, sharedLinksCreated, sharedLinksViewedByTeam, sharedLinksViewedByOutsideUser, sharedLinksViewedByNotLoggedIn, sharedLinksViewedTotal);
        }
    };
}
