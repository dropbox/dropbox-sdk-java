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
 * Storage Report Result. Each of the items in the storage report is an array of
 * values, one value per day. If there is no data for a day, then the value will
 * be None.
 */
public class GetStorageReport extends BaseDfbReport {
    // struct team.GetStorageReport (team_reports.stone)

    @Nonnull
    protected final List<Long> totalUsage;
    @Nonnull
    protected final List<Long> sharedUsage;
    @Nonnull
    protected final List<Long> unsharedUsage;
    @Nonnull
    protected final List<Long> sharedFolders;
    @Nonnull
    protected final List<List<StorageBucket>> memberStorageMap;

    /**
     * Storage Report Result. Each of the items in the storage report is an
     * array of values, one value per day. If there is no data for a day, then
     * the value will be None.
     *
     * @param startDate  First date present in the results as 'YYYY-MM-DD' or
     *     None. Must not be {@code null}.
     * @param totalUsage  Sum of the shared, unshared, and datastore usages, for
     *     each day. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param sharedUsage  Array of the combined size (bytes) of team members'
     *     shared folders, for each day. Must not contain a {@code null} item
     *     and not be {@code null}.
     * @param unsharedUsage  Array of the combined size (bytes) of team members'
     *     root namespaces, for each day. Must not contain a {@code null} item
     *     and not be {@code null}.
     * @param sharedFolders  Array of the number of shared folders owned by team
     *     members, for each day. Must not contain a {@code null} item and not
     *     be {@code null}.
     * @param memberStorageMap  Array of storage summaries of team members'
     *     account sizes. Each storage summary is an array of key, value pairs,
     *     where each pair describes a storage bucket. The key indicates the
     *     upper bound of the bucket and the value is the number of users in
     *     that bucket. There is one such summary per day. If there is no data
     *     for a day, the storage summary will be empty. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetStorageReport(@Nonnull String startDate, @Nonnull List<Long> totalUsage, @Nonnull List<Long> sharedUsage, @Nonnull List<Long> unsharedUsage, @Nonnull List<Long> sharedFolders, @Nonnull List<List<StorageBucket>> memberStorageMap) {
        super(startDate);
        if (totalUsage == null) {
            throw new IllegalArgumentException("Required value for 'totalUsage' is null");
        }
        for (Long x : totalUsage) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'totalUsage' is null");
            }
        }
        this.totalUsage = totalUsage;
        if (sharedUsage == null) {
            throw new IllegalArgumentException("Required value for 'sharedUsage' is null");
        }
        for (Long x : sharedUsage) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedUsage' is null");
            }
        }
        this.sharedUsage = sharedUsage;
        if (unsharedUsage == null) {
            throw new IllegalArgumentException("Required value for 'unsharedUsage' is null");
        }
        for (Long x : unsharedUsage) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'unsharedUsage' is null");
            }
        }
        this.unsharedUsage = unsharedUsage;
        if (sharedFolders == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolders' is null");
        }
        for (Long x : sharedFolders) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedFolders' is null");
            }
        }
        this.sharedFolders = sharedFolders;
        if (memberStorageMap == null) {
            throw new IllegalArgumentException("Required value for 'memberStorageMap' is null");
        }
        for (List<StorageBucket> x : memberStorageMap) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'memberStorageMap' is null");
            }
            for (StorageBucket x1 : x) {
                if (x1 == null) {
                    throw new IllegalArgumentException("An item in listan item in list 'memberStorageMap' is null");
                }
            }
        }
        this.memberStorageMap = memberStorageMap;
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
     * Sum of the shared, unshared, and datastore usages, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getTotalUsage() {
        return totalUsage;
    }

    /**
     * Array of the combined size (bytes) of team members' shared folders, for
     * each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSharedUsage() {
        return sharedUsage;
    }

    /**
     * Array of the combined size (bytes) of team members' root namespaces, for
     * each day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getUnsharedUsage() {
        return unsharedUsage;
    }

    /**
     * Array of the number of shared folders owned by team members, for each
     * day.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getSharedFolders() {
        return sharedFolders;
    }

    /**
     * Array of storage summaries of team members' account sizes. Each storage
     * summary is an array of key, value pairs, where each pair describes a
     * storage bucket. The key indicates the upper bound of the bucket and the
     * value is the number of users in that bucket. There is one such summary
     * per day. If there is no data for a day, the storage summary will be
     * empty.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<List<StorageBucket>> getMemberStorageMap() {
        return memberStorageMap;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.totalUsage,
            this.sharedUsage,
            this.unsharedUsage,
            this.sharedFolders,
            this.memberStorageMap
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
            GetStorageReport other = (GetStorageReport) obj;
            return ((this.startDate == other.startDate) || (this.startDate.equals(other.startDate)))
                && ((this.totalUsage == other.totalUsage) || (this.totalUsage.equals(other.totalUsage)))
                && ((this.sharedUsage == other.sharedUsage) || (this.sharedUsage.equals(other.sharedUsage)))
                && ((this.unsharedUsage == other.unsharedUsage) || (this.unsharedUsage.equals(other.unsharedUsage)))
                && ((this.sharedFolders == other.sharedFolders) || (this.sharedFolders.equals(other.sharedFolders)))
                && ((this.memberStorageMap == other.memberStorageMap) || (this.memberStorageMap.equals(other.memberStorageMap)))
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
    static class Serializer extends StructSerializer<GetStorageReport> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetStorageReport value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("start_date");
            StoneSerializers.string().serialize(value.startDate, g);
            g.writeFieldName("total_usage");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.totalUsage, g);
            g.writeFieldName("shared_usage");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.sharedUsage, g);
            g.writeFieldName("unshared_usage");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.unsharedUsage, g);
            g.writeFieldName("shared_folders");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.sharedFolders, g);
            g.writeFieldName("member_storage_map");
            StoneSerializers.list(StoneSerializers.list(StorageBucket.Serializer.INSTANCE)).serialize(value.memberStorageMap, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetStorageReport deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetStorageReport value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_startDate = null;
                List<Long> f_totalUsage = null;
                List<Long> f_sharedUsage = null;
                List<Long> f_unsharedUsage = null;
                List<Long> f_sharedFolders = null;
                List<List<StorageBucket>> f_memberStorageMap = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.string().deserialize(p);
                    }
                    else if ("total_usage".equals(field)) {
                        f_totalUsage = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("shared_usage".equals(field)) {
                        f_sharedUsage = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("unshared_usage".equals(field)) {
                        f_unsharedUsage = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("shared_folders".equals(field)) {
                        f_sharedFolders = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("member_storage_map".equals(field)) {
                        f_memberStorageMap = StoneSerializers.list(StoneSerializers.list(StorageBucket.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                if (f_totalUsage == null) {
                    throw new JsonParseException(p, "Required field \"total_usage\" missing.");
                }
                if (f_sharedUsage == null) {
                    throw new JsonParseException(p, "Required field \"shared_usage\" missing.");
                }
                if (f_unsharedUsage == null) {
                    throw new JsonParseException(p, "Required field \"unshared_usage\" missing.");
                }
                if (f_sharedFolders == null) {
                    throw new JsonParseException(p, "Required field \"shared_folders\" missing.");
                }
                if (f_memberStorageMap == null) {
                    throw new JsonParseException(p, "Required field \"member_storage_map\" missing.");
                }
                value = new GetStorageReport(f_startDate, f_totalUsage, f_sharedUsage, f_unsharedUsage, f_sharedFolders, f_memberStorageMap);
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
