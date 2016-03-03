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
 * Storage Report Result. Each of the items in the storage report is an array of
 * values, one value per day. If there is no data for a day, then the value will
 * be None.
 */
@JsonSerialize(using=GetStorageReport.Serializer.class)
@JsonDeserialize(using=GetStorageReport.Deserializer.class)
public class GetStorageReport extends BaseDfbReport {
    // struct GetStorageReport

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<Long> totalUsage;
    protected final List<Long> sharedUsage;
    protected final List<Long> unsharedUsage;
    protected final List<Long> sharedFolders;
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
    public GetStorageReport(String startDate, List<Long> totalUsage, List<Long> sharedUsage, List<Long> unsharedUsage, List<Long> sharedFolders, List<List<StorageBucket>> memberStorageMap) {
        super(startDate);
        if (totalUsage == null) {
            throw new IllegalArgumentException("Required value for 'totalUsage' is null");
        }
        for (Long x : totalUsage) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'totalUsage' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'totalUsage': type Nullable");
        }
        this.totalUsage = totalUsage;
        if (sharedUsage == null) {
            throw new IllegalArgumentException("Required value for 'sharedUsage' is null");
        }
        for (Long x : sharedUsage) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedUsage' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'sharedUsage': type Nullable");
        }
        this.sharedUsage = sharedUsage;
        if (unsharedUsage == null) {
            throw new IllegalArgumentException("Required value for 'unsharedUsage' is null");
        }
        for (Long x : unsharedUsage) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'unsharedUsage' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'unsharedUsage': type Nullable");
        }
        this.unsharedUsage = unsharedUsage;
        if (sharedFolders == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolders' is null");
        }
        for (Long x : sharedFolders) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sharedFolders' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'sharedFolders': type Nullable");
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
     * Sum of the shared, unshared, and datastore usages, for each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getTotalUsage() {
        return totalUsage;
    }

    /**
     * Array of the combined size (bytes) of team members' shared folders, for
     * each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getSharedUsage() {
        return sharedUsage;
    }

    /**
     * Array of the combined size (bytes) of team members' root namespaces, for
     * each day.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getUnsharedUsage() {
        return unsharedUsage;
    }

    /**
     * Array of the number of shared folders owned by team members, for each
     * day.
     *
     * @return value for this field, never {@code null}.
     */
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
    public List<List<StorageBucket>> getMemberStorageMap() {
        return memberStorageMap;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            totalUsage,
            sharedUsage,
            unsharedUsage,
            sharedFolders,
            memberStorageMap
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

    static final class Serializer extends StructJsonSerializer<GetStorageReport> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetStorageReport.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetStorageReport.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetStorageReport> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetStorageReport value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("start_date", value.startDate);
            g.writeObjectField("total_usage", value.totalUsage);
            g.writeObjectField("shared_usage", value.sharedUsage);
            g.writeObjectField("unshared_usage", value.unsharedUsage);
            g.writeObjectField("shared_folders", value.sharedFolders);
            g.writeObjectField("member_storage_map", value.memberStorageMap);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetStorageReport> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetStorageReport.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetStorageReport.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetStorageReport> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetStorageReport deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String startDate = null;
            List<Long> totalUsage = null;
            List<Long> sharedUsage = null;
            List<Long> unsharedUsage = null;
            List<Long> sharedFolders = null;
            List<List<StorageBucket>> memberStorageMap = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("start_date".equals(_field)) {
                    startDate = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("total_usage".equals(_field)) {
                    expectArrayStart(_p);
                    totalUsage = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        totalUsage.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("shared_usage".equals(_field)) {
                    expectArrayStart(_p);
                    sharedUsage = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        sharedUsage.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("unshared_usage".equals(_field)) {
                    expectArrayStart(_p);
                    unsharedUsage = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        unsharedUsage.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("shared_folders".equals(_field)) {
                    expectArrayStart(_p);
                    sharedFolders = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        sharedFolders.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("member_storage_map".equals(_field)) {
                    expectArrayStart(_p);
                    memberStorageMap = new java.util.ArrayList<List<StorageBucket>>();
                    while (!isArrayEnd(_p)) {
                        List<StorageBucket> _x = null;
                        expectArrayStart(_p);
                        _x = new java.util.ArrayList<StorageBucket>();
                        while (!isArrayEnd(_p)) {
                            StorageBucket _x1 = null;
                            _x1 = _p.readValueAs(StorageBucket.class);
                            _p.nextToken();
                            _x.add(_x1);
                        }
                        expectArrayEnd(_p);
                        _p.nextToken();
                        memberStorageMap.add(_x);
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
            if (totalUsage == null) {
                throw new JsonParseException(_p, "Required field \"total_usage\" is missing.");
            }
            if (sharedUsage == null) {
                throw new JsonParseException(_p, "Required field \"shared_usage\" is missing.");
            }
            if (unsharedUsage == null) {
                throw new JsonParseException(_p, "Required field \"unshared_usage\" is missing.");
            }
            if (sharedFolders == null) {
                throw new JsonParseException(_p, "Required field \"shared_folders\" is missing.");
            }
            if (memberStorageMap == null) {
                throw new JsonParseException(_p, "Required field \"member_storage_map\" is missing.");
            }

            return new GetStorageReport(startDate, totalUsage, sharedUsage, unsharedUsage, sharedFolders, memberStorageMap);
        }
    }
}
