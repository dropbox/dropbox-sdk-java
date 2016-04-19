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
 * Activity Report Result. Each of the items in the storage report is an array
 * of values, one value per day. If there is no data for a day, then the value
 * will be None.
 */
@JsonSerialize(using=GetActivityReport.Serializer.class)
@JsonDeserialize(using=GetActivityReport.Deserializer.class)
public class GetActivityReport extends BaseDfbReport {
    // struct GetActivityReport

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<Long> adds;
    protected final List<Long> edits;
    protected final List<Long> deletes;
    protected final List<Long> activeUsers28Day;
    protected final List<Long> activeUsers7Day;
    protected final List<Long> activeUsers1Day;
    protected final List<Long> activeSharedFolders28Day;
    protected final List<Long> activeSharedFolders7Day;
    protected final List<Long> activeSharedFolders1Day;
    protected final List<Long> sharedLinksCreated;
    protected final List<Long> sharedLinksViewedByTeam;
    protected final List<Long> sharedLinksViewedByOutsideUser;
    protected final List<Long> sharedLinksViewedByNotLoggedIn;
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
        int hash = java.util.Arrays.hashCode(new Object [] {
            adds,
            edits,
            deletes,
            activeUsers28Day,
            activeUsers7Day,
            activeUsers1Day,
            activeSharedFolders28Day,
            activeSharedFolders7Day,
            activeSharedFolders1Day,
            sharedLinksCreated,
            sharedLinksViewedByTeam,
            sharedLinksViewedByOutsideUser,
            sharedLinksViewedByNotLoggedIn,
            sharedLinksViewedTotal
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

    static final class Serializer extends StructJsonSerializer<GetActivityReport> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetActivityReport.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetActivityReport.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetActivityReport> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetActivityReport value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("start_date", value.startDate);
            g.writeObjectField("adds", value.adds);
            g.writeObjectField("edits", value.edits);
            g.writeObjectField("deletes", value.deletes);
            g.writeObjectField("active_users_28_day", value.activeUsers28Day);
            g.writeObjectField("active_users_7_day", value.activeUsers7Day);
            g.writeObjectField("active_users_1_day", value.activeUsers1Day);
            g.writeObjectField("active_shared_folders_28_day", value.activeSharedFolders28Day);
            g.writeObjectField("active_shared_folders_7_day", value.activeSharedFolders7Day);
            g.writeObjectField("active_shared_folders_1_day", value.activeSharedFolders1Day);
            g.writeObjectField("shared_links_created", value.sharedLinksCreated);
            g.writeObjectField("shared_links_viewed_by_team", value.sharedLinksViewedByTeam);
            g.writeObjectField("shared_links_viewed_by_outside_user", value.sharedLinksViewedByOutsideUser);
            g.writeObjectField("shared_links_viewed_by_not_logged_in", value.sharedLinksViewedByNotLoggedIn);
            g.writeObjectField("shared_links_viewed_total", value.sharedLinksViewedTotal);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetActivityReport> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetActivityReport.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetActivityReport.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetActivityReport> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetActivityReport deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

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

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("start_date".equals(_field)) {
                    startDate = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("adds".equals(_field)) {
                    expectArrayStart(_p);
                    adds = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        adds.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("edits".equals(_field)) {
                    expectArrayStart(_p);
                    edits = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        edits.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("deletes".equals(_field)) {
                    expectArrayStart(_p);
                    deletes = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        deletes.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("active_users_28_day".equals(_field)) {
                    expectArrayStart(_p);
                    activeUsers28Day = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        activeUsers28Day.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("active_users_7_day".equals(_field)) {
                    expectArrayStart(_p);
                    activeUsers7Day = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        activeUsers7Day.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("active_users_1_day".equals(_field)) {
                    expectArrayStart(_p);
                    activeUsers1Day = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        activeUsers1Day.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("active_shared_folders_28_day".equals(_field)) {
                    expectArrayStart(_p);
                    activeSharedFolders28Day = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        activeSharedFolders28Day.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("active_shared_folders_7_day".equals(_field)) {
                    expectArrayStart(_p);
                    activeSharedFolders7Day = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        activeSharedFolders7Day.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("active_shared_folders_1_day".equals(_field)) {
                    expectArrayStart(_p);
                    activeSharedFolders1Day = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        activeSharedFolders1Day.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("shared_links_created".equals(_field)) {
                    expectArrayStart(_p);
                    sharedLinksCreated = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        sharedLinksCreated.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("shared_links_viewed_by_team".equals(_field)) {
                    expectArrayStart(_p);
                    sharedLinksViewedByTeam = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        sharedLinksViewedByTeam.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("shared_links_viewed_by_outside_user".equals(_field)) {
                    expectArrayStart(_p);
                    sharedLinksViewedByOutsideUser = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        sharedLinksViewedByOutsideUser.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("shared_links_viewed_by_not_logged_in".equals(_field)) {
                    expectArrayStart(_p);
                    sharedLinksViewedByNotLoggedIn = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        sharedLinksViewedByNotLoggedIn.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("shared_links_viewed_total".equals(_field)) {
                    expectArrayStart(_p);
                    sharedLinksViewedTotal = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        sharedLinksViewedTotal.add(_x);
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
            if (adds == null) {
                throw new JsonParseException(_p, "Required field \"adds\" is missing.");
            }
            if (edits == null) {
                throw new JsonParseException(_p, "Required field \"edits\" is missing.");
            }
            if (deletes == null) {
                throw new JsonParseException(_p, "Required field \"deletes\" is missing.");
            }
            if (activeUsers28Day == null) {
                throw new JsonParseException(_p, "Required field \"active_users_28_day\" is missing.");
            }
            if (activeUsers7Day == null) {
                throw new JsonParseException(_p, "Required field \"active_users_7_day\" is missing.");
            }
            if (activeUsers1Day == null) {
                throw new JsonParseException(_p, "Required field \"active_users_1_day\" is missing.");
            }
            if (activeSharedFolders28Day == null) {
                throw new JsonParseException(_p, "Required field \"active_shared_folders_28_day\" is missing.");
            }
            if (activeSharedFolders7Day == null) {
                throw new JsonParseException(_p, "Required field \"active_shared_folders_7_day\" is missing.");
            }
            if (activeSharedFolders1Day == null) {
                throw new JsonParseException(_p, "Required field \"active_shared_folders_1_day\" is missing.");
            }
            if (sharedLinksCreated == null) {
                throw new JsonParseException(_p, "Required field \"shared_links_created\" is missing.");
            }
            if (sharedLinksViewedByTeam == null) {
                throw new JsonParseException(_p, "Required field \"shared_links_viewed_by_team\" is missing.");
            }
            if (sharedLinksViewedByOutsideUser == null) {
                throw new JsonParseException(_p, "Required field \"shared_links_viewed_by_outside_user\" is missing.");
            }
            if (sharedLinksViewedByNotLoggedIn == null) {
                throw new JsonParseException(_p, "Required field \"shared_links_viewed_by_not_logged_in\" is missing.");
            }
            if (sharedLinksViewedTotal == null) {
                throw new JsonParseException(_p, "Required field \"shared_links_viewed_total\" is missing.");
            }

            return new GetActivityReport(startDate, adds, edits, deletes, activeUsers28Day, activeUsers7Day, activeUsers1Day, activeSharedFolders28Day, activeSharedFolders7Day, activeSharedFolders1Day, sharedLinksCreated, sharedLinksViewedByTeam, sharedLinksViewedByOutsideUser, sharedLinksViewedByNotLoggedIn, sharedLinksViewedTotal);
        }
    }
}
