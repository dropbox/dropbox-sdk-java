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
 * Storage Report Result. Each of the items in the storage report is an array of
 * values, one value per day. If there is no data for a day, then the value will
 * be None.
 */
public class GetStorageReport extends BaseDfbReport {
    // struct GetStorageReport

    private final List<Long> totalUsage;
    private final List<Long> sharedUsage;
    private final List<Long> unsharedUsage;
    private final List<Long> sharedFolders;
    private final List<List<StorageBucket>> memberStorageMap;

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
            GetStorageReport other = (GetStorageReport) obj;
            return ((this.totalUsage == other.totalUsage) || (this.totalUsage.equals(other.totalUsage)))
                && ((this.sharedUsage == other.sharedUsage) || (this.sharedUsage.equals(other.sharedUsage)))
                && ((this.unsharedUsage == other.unsharedUsage) || (this.unsharedUsage.equals(other.unsharedUsage)))
                && ((this.sharedFolders == other.sharedFolders) || (this.sharedFolders.equals(other.sharedFolders)))
                && ((this.memberStorageMap == other.memberStorageMap) || (this.memberStorageMap.equals(other.memberStorageMap)))
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

    public static GetStorageReport fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetStorageReport> _JSON_WRITER = new JsonWriter<GetStorageReport>() {
        public final void write(GetStorageReport x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            BaseDfbReport._JSON_WRITER.writeFields(x, g);
            GetStorageReport._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetStorageReport x, JsonGenerator g) throws IOException {
            g.writeFieldName("total_usage");
            g.writeStartArray();
            for (Long item: x.totalUsage) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("shared_usage");
            g.writeStartArray();
            for (Long item: x.sharedUsage) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("unshared_usage");
            g.writeStartArray();
            for (Long item: x.unsharedUsage) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("shared_folders");
            g.writeStartArray();
            for (Long item: x.sharedFolders) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("member_storage_map");
            g.writeStartArray();
            for (List<StorageBucket> item: x.memberStorageMap) {
                if (item != null) {
                    g.writeStartArray();
                    for (StorageBucket item1: item) {
                        if (item1 != null) {
                            StorageBucket._JSON_WRITER.write(item1, g);
                        }
                    }
                    g.writeEndArray();
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<GetStorageReport> _JSON_READER = new JsonReader<GetStorageReport>() {
        public final GetStorageReport read(JsonParser parser) throws IOException, JsonReadException {
            GetStorageReport result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetStorageReport readFields(JsonParser parser) throws IOException, JsonReadException {
            String startDate = null;
            List<Long> totalUsage = null;
            List<Long> sharedUsage = null;
            List<Long> unsharedUsage = null;
            List<Long> sharedFolders = null;
            List<List<StorageBucket>> memberStorageMap = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("start_date".equals(fieldName)) {
                    startDate = JsonReader.StringReader
                        .readField(parser, "start_date", startDate);
                }
                else if ("total_usage".equals(fieldName)) {
                    totalUsage = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "total_usage", totalUsage);
                }
                else if ("shared_usage".equals(fieldName)) {
                    sharedUsage = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "shared_usage", sharedUsage);
                }
                else if ("unshared_usage".equals(fieldName)) {
                    unsharedUsage = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "unshared_usage", unsharedUsage);
                }
                else if ("shared_folders".equals(fieldName)) {
                    sharedFolders = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "shared_folders", sharedFolders);
                }
                else if ("member_storage_map".equals(fieldName)) {
                    memberStorageMap = JsonArrayReader.mk(JsonArrayReader.mk(StorageBucket._JSON_READER))
                        .readField(parser, "member_storage_map", memberStorageMap);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (startDate == null) {
                throw new JsonReadException("Required field \"start_date\" is missing.", parser.getTokenLocation());
            }
            if (totalUsage == null) {
                throw new JsonReadException("Required field \"total_usage\" is missing.", parser.getTokenLocation());
            }
            if (sharedUsage == null) {
                throw new JsonReadException("Required field \"shared_usage\" is missing.", parser.getTokenLocation());
            }
            if (unsharedUsage == null) {
                throw new JsonReadException("Required field \"unshared_usage\" is missing.", parser.getTokenLocation());
            }
            if (sharedFolders == null) {
                throw new JsonReadException("Required field \"shared_folders\" is missing.", parser.getTokenLocation());
            }
            if (memberStorageMap == null) {
                throw new JsonReadException("Required field \"member_storage_map\" is missing.", parser.getTokenLocation());
            }
            return new GetStorageReport(startDate, totalUsage, sharedUsage, unsharedUsage, sharedFolders, memberStorageMap);
        }
    };
}
