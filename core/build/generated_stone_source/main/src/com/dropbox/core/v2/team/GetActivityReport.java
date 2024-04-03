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
 * Activity Report Result. Each of the items in the storage report is an array
 * of values, one value per day. If there is no data for a day, then the value
 * will be None.
 */
public class GetActivityReport extends BaseDfbReport {
    // struct team.GetActivityReport (team_reports.stone)

    @Nonnull
    protected final List<Long> adds;
    @Nonnull
    protected final List<Long> edits;
    @Nonnull
    protected final List<Long> deletes;
    @Nonnull
    protected final List<Long> activeUsers28Day;
    @Nonnull
    protected final List<Long> activeUsers7Day;
    @Nonnull
    protected final List<Long> activeUsers1Day;
    @Nonnull
    protected final List<Long> activeSharedFolders28Day;
    @Nonnull
    protected final List<Long> activeSharedFolders7Day;
    @Nonnull
    protected final List<Long> activeSharedFolders1Day;
    @Nonnull
    protected final List<Long> sharedLinksCreated;
    @Nonnull
    protected final List<Long> sharedLinksViewedByTeam;
    @Nonnull
    protected final List<Long> sharedLinksViewedByOutsideUser;
    @Nonnull
    protected final List<Long> sharedLinksViewedByNotLoggedIn;
    @Nonnull
    protected final List<Long> sharedLinksViewedTotal;

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
    public GetActivityReport(@Nonnull String startDate, @Nonnull List<Long> adds, @Nonnull List<Long> edits, @Nonnull List<Long> deletes, @Nonnull List<Long> activeUsers28Day, @Nonnull List<Long> activeUsers7Day, @Nonnull List<Long> activeUsers1Day, @Nonnull List<Long> activeSharedFolders28Day, @Nonnull List<Long> activeSharedFolders7Day, @Nonnull List<Long> activeSharedFolders1Day, @Nonnull List<Long> sharedLinksCreated, @Nonnull List<Long> sharedLinksViewedByTeam, @Nonnull List<Long> sharedLinksViewedByOutsideUser, @Nonnull List<Long> sharedLinksViewedByNotLoggedIn, @Nonnull List<Long> sharedLinksViewedTotal) {
        super(startDate);
        if (adds == null) {
            throw new IllegalArgumentException("Required value for 'adds' is null");
        }
        for (Long x : adds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'adds' is null");
            }
        }
        this.adds = adds;
        if (edits == null) {
            throw new IllegalArgumentException("Required value for 'edits' is null");
        }
        for (Long x : edits) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'edits' is null");
            }
        }
        this.edits = edits;
        if (deletes == null) {
            throw new IllegalArgumentException("Required value for 'deletes' is null");
        }
        for (Long x : deletes) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'deletes' is null");
            }
        }
        this.deletes = deletes;
        if (activeUsers28Day == null) {
            throw new IllegalArgumentException("Required value for 'activeUsers28Day' is null");
        }
        for (Long x : activeUsers28Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeUsers28Day' is null");
            }
        }
        this.activeUsers28Day = activeUsers28Day;
        if (activeUsers7Day == null) {
            throw new IllegalArgumentException("Required value for 'activeUsers7Day' is null");
        }
        for (Long x : activeUsers7Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeUsers7Day' is null");
            }
        }
        this.activeUsers7Day = activeUsers7Day;
        if (activeUsers1Day == null) {
            throw new IllegalArgumentException("Required value for 'activeUsers1Day' is null");
        }
        for (Long x : activeUsers1Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeUsers1Day' is null");
            }
        }
        this.activeUsers1Day = activeUsers1Day;
        if (activeSharedFolders28Day == null) {
            throw new IllegalArgumentException("Required value for 'activeSharedFolders28Day' is null");
        }
        for (Long x : activeSharedFolders28Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeSharedFolders28Day' is null");
            }
        }
        this.activeSharedFolders28Day = activeSharedFolders28Day;
        if (activeSharedFolders7Day == null) {
            throw new IllegalArgumentException("Required value for 'activeSharedFolders7Day' is null");
        }
        for (Long x : activeSharedFolders7Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeSharedFolders7Day' is null");
            }
        }
        this.activeSharedFolders7Day = activeSharedFolders7Day;
        if (activeSharedFolders1Day == null) {
            throw new IllegalArgumentException("Required value for 'activeSharedFolders1Day' is null");
        }
        for (Long x : activeSharedFolders1Day) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'activeSharedFolders1Day' is null");
            }
        }
        this.activeSharedFolders1Day = activeSharedFolders1Day;
        if (sharedLinksCreated == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksCreated' is null");
        }
        for (Long x : sharedLinksCreated) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksCreated' is null");
            }
        }
        this.sharedLinksCreated = sharedLinksCreated;
        if (sharedLinksViewedByTeam == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedByTeam' is null");
        }
        for (Long x : sharedLinksViewedByTeam) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedByTeam' is null");
            }
        }
        this.sharedLinksViewedByTeam = sharedLinksViewedByTeam;
        if (sharedLinksViewedByOutsideUser == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedByOutsideUser' is null");
        }
        for (Long x : sharedLinksViewedByOutsideUser) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedByOutsideUser' is null");
            }
        }
        this.sharedLinksViewedByOutsideUser = sharedLinksViewedByOutsideUser;
        if (sharedLinksViewedByNotLoggedIn == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedByNotLoggedIn' is null");
        }
        for (Long x : sharedLinksViewedByNotLoggedIn) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedByNotLoggedIn' is null");
            }
        }
        this.sharedLinksViewedByNotLoggedIn = sharedLinksViewedByNotLoggedIn;
        if (sharedLinksViewedTotal == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinksViewedTotal' is null");
        }
        for (Long x : sharedLinksViewedTotal) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedLinksViewedTotal' is null");
            }
        }
        this.sharedLinksViewedTotal = sharedLinksViewedTotal;
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
     * Array of total number of adds by team members.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getAdds() {
        return adds;
    }

    /**
     * Array of number of edits by team members. If the same user edits the same
     * file multiple times this is counted as a single edit.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getEdits() {
        return edits;
    }

    /**
     * Array of total number of deletes by team members.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getDeletes() {
        return deletes;
    }

    /**
     * Array of the number of users who have been active in the last 28 days.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getActiveUsers28Day() {
        return activeUsers28Day;
    }

    /**
     * Array of the number of users who have been active in the last week.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getActiveUsers7Day() {
        return activeUsers7Day;
    }

    /**
     * Array of the number of users who have been active in the last day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getActiveUsers1Day() {
        return activeUsers1Day;
    }

    /**
     * Array of the number of shared folders with some activity in the last 28
     * days.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getActiveSharedFolders28Day() {
        return activeSharedFolders28Day;
    }

    /**
     * Array of the number of shared folders with some activity in the last
     * week.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getActiveSharedFolders7Day() {
        return activeSharedFolders7Day;
    }

    /**
     * Array of the number of shared folders with some activity in the last day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getActiveSharedFolders1Day() {
        return activeSharedFolders1Day;
    }

    /**
     * Array of the number of shared links created.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSharedLinksCreated() {
        return sharedLinksCreated;
    }

    /**
     * Array of the number of views by team users to shared links created by the
     * team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSharedLinksViewedByTeam() {
        return sharedLinksViewedByTeam;
    }

    /**
     * Array of the number of views by users outside of the team to shared links
     * created by the team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSharedLinksViewedByOutsideUser() {
        return sharedLinksViewedByOutsideUser;
    }

    /**
     * Array of the number of views by non-logged-in users to shared links
     * created by the team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSharedLinksViewedByNotLoggedIn() {
        return sharedLinksViewedByNotLoggedIn;
    }

    /**
     * Array of the total number of views to shared links created by the team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSharedLinksViewedTotal() {
        return sharedLinksViewedTotal;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.adds,
            this.edits,
            this.deletes,
            this.activeUsers28Day,
            this.activeUsers7Day,
            this.activeUsers1Day,
            this.activeSharedFolders28Day,
            this.activeSharedFolders7Day,
            this.activeSharedFolders1Day,
            this.sharedLinksCreated,
            this.sharedLinksViewedByTeam,
            this.sharedLinksViewedByOutsideUser,
            this.sharedLinksViewedByNotLoggedIn,
            this.sharedLinksViewedTotal
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
            GetActivityReport other = (GetActivityReport) obj;
            return ((this.startDate == other.startDate) || (this.startDate.equals(other.startDate)))
                && ((this.adds == other.adds) || (this.adds.equals(other.adds)))
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
    static class Serializer extends StructSerializer<GetActivityReport> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetActivityReport value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("start_date");
            StoneSerializers.string().serialize(value.startDate, g);
            g.writeFieldName("adds");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.adds, g);
            g.writeFieldName("edits");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.edits, g);
            g.writeFieldName("deletes");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.deletes, g);
            g.writeFieldName("active_users_28_day");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.activeUsers28Day, g);
            g.writeFieldName("active_users_7_day");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.activeUsers7Day, g);
            g.writeFieldName("active_users_1_day");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.activeUsers1Day, g);
            g.writeFieldName("active_shared_folders_28_day");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.activeSharedFolders28Day, g);
            g.writeFieldName("active_shared_folders_7_day");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.activeSharedFolders7Day, g);
            g.writeFieldName("active_shared_folders_1_day");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.activeSharedFolders1Day, g);
            g.writeFieldName("shared_links_created");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.sharedLinksCreated, g);
            g.writeFieldName("shared_links_viewed_by_team");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.sharedLinksViewedByTeam, g);
            g.writeFieldName("shared_links_viewed_by_outside_user");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.sharedLinksViewedByOutsideUser, g);
            g.writeFieldName("shared_links_viewed_by_not_logged_in");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.sharedLinksViewedByNotLoggedIn, g);
            g.writeFieldName("shared_links_viewed_total");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.sharedLinksViewedTotal, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetActivityReport deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetActivityReport value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_startDate = null;
                List<Long> f_adds = null;
                List<Long> f_edits = null;
                List<Long> f_deletes = null;
                List<Long> f_activeUsers28Day = null;
                List<Long> f_activeUsers7Day = null;
                List<Long> f_activeUsers1Day = null;
                List<Long> f_activeSharedFolders28Day = null;
                List<Long> f_activeSharedFolders7Day = null;
                List<Long> f_activeSharedFolders1Day = null;
                List<Long> f_sharedLinksCreated = null;
                List<Long> f_sharedLinksViewedByTeam = null;
                List<Long> f_sharedLinksViewedByOutsideUser = null;
                List<Long> f_sharedLinksViewedByNotLoggedIn = null;
                List<Long> f_sharedLinksViewedTotal = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.string().deserialize(p);
                    }
                    else if ("adds".equals(field)) {
                        f_adds = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("edits".equals(field)) {
                        f_edits = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("deletes".equals(field)) {
                        f_deletes = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("active_users_28_day".equals(field)) {
                        f_activeUsers28Day = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("active_users_7_day".equals(field)) {
                        f_activeUsers7Day = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("active_users_1_day".equals(field)) {
                        f_activeUsers1Day = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("active_shared_folders_28_day".equals(field)) {
                        f_activeSharedFolders28Day = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("active_shared_folders_7_day".equals(field)) {
                        f_activeSharedFolders7Day = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("active_shared_folders_1_day".equals(field)) {
                        f_activeSharedFolders1Day = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("shared_links_created".equals(field)) {
                        f_sharedLinksCreated = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("shared_links_viewed_by_team".equals(field)) {
                        f_sharedLinksViewedByTeam = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("shared_links_viewed_by_outside_user".equals(field)) {
                        f_sharedLinksViewedByOutsideUser = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("shared_links_viewed_by_not_logged_in".equals(field)) {
                        f_sharedLinksViewedByNotLoggedIn = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("shared_links_viewed_total".equals(field)) {
                        f_sharedLinksViewedTotal = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                if (f_adds == null) {
                    throw new JsonParseException(p, "Required field \"adds\" missing.");
                }
                if (f_edits == null) {
                    throw new JsonParseException(p, "Required field \"edits\" missing.");
                }
                if (f_deletes == null) {
                    throw new JsonParseException(p, "Required field \"deletes\" missing.");
                }
                if (f_activeUsers28Day == null) {
                    throw new JsonParseException(p, "Required field \"active_users_28_day\" missing.");
                }
                if (f_activeUsers7Day == null) {
                    throw new JsonParseException(p, "Required field \"active_users_7_day\" missing.");
                }
                if (f_activeUsers1Day == null) {
                    throw new JsonParseException(p, "Required field \"active_users_1_day\" missing.");
                }
                if (f_activeSharedFolders28Day == null) {
                    throw new JsonParseException(p, "Required field \"active_shared_folders_28_day\" missing.");
                }
                if (f_activeSharedFolders7Day == null) {
                    throw new JsonParseException(p, "Required field \"active_shared_folders_7_day\" missing.");
                }
                if (f_activeSharedFolders1Day == null) {
                    throw new JsonParseException(p, "Required field \"active_shared_folders_1_day\" missing.");
                }
                if (f_sharedLinksCreated == null) {
                    throw new JsonParseException(p, "Required field \"shared_links_created\" missing.");
                }
                if (f_sharedLinksViewedByTeam == null) {
                    throw new JsonParseException(p, "Required field \"shared_links_viewed_by_team\" missing.");
                }
                if (f_sharedLinksViewedByOutsideUser == null) {
                    throw new JsonParseException(p, "Required field \"shared_links_viewed_by_outside_user\" missing.");
                }
                if (f_sharedLinksViewedByNotLoggedIn == null) {
                    throw new JsonParseException(p, "Required field \"shared_links_viewed_by_not_logged_in\" missing.");
                }
                if (f_sharedLinksViewedTotal == null) {
                    throw new JsonParseException(p, "Required field \"shared_links_viewed_total\" missing.");
                }
                value = new GetActivityReport(f_startDate, f_adds, f_edits, f_deletes, f_activeUsers28Day, f_activeUsers7Day, f_activeUsers1Day, f_activeSharedFolders28Day, f_activeSharedFolders7Day, f_activeSharedFolders1Day, f_sharedLinksCreated, f_sharedLinksViewedByTeam, f_sharedLinksViewedByOutsideUser, f_sharedLinksViewedByNotLoggedIn, f_sharedLinksViewedTotal);
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
