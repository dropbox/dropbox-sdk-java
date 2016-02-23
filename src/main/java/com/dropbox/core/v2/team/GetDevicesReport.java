/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Devices Report Result. Contains subsections for different time ranges of
 * activity. Each of the items in each subsection of the storage report is an
 * array of values, one value per day. If there is no data for a day, then the
 * value will be None.
 */
public class GetDevicesReport extends BaseDfbReport {
    // struct GetDevicesReport

    private final DevicesActive active1Day;
    private final DevicesActive active7Day;
    private final DevicesActive active28Day;

    /**
     * Devices Report Result. Contains subsections for different time ranges of
     * activity. Each of the items in each subsection of the storage report is
     * an array of values, one value per day. If there is no data for a day,
     * then the value will be None.
     *
     * @param startDate  First date present in the results as 'YYYY-MM-DD' or
     *     None. Must not be {@code null}.
     * @param active1Day  Report of the number of devices active in the last
     *     day. Must not be {@code null}.
     * @param active7Day  Report of the number of devices active in the last 7
     *     days. Must not be {@code null}.
     * @param active28Day  Report of the number of devices active in the last 28
     *     days. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetDevicesReport(String startDate, DevicesActive active1Day, DevicesActive active7Day, DevicesActive active28Day) {
        super(startDate);
        if (active1Day == null) {
            throw new IllegalArgumentException("Required value for 'active1Day' is null");
        }
        this.active1Day = active1Day;
        if (active7Day == null) {
            throw new IllegalArgumentException("Required value for 'active7Day' is null");
        }
        this.active7Day = active7Day;
        if (active28Day == null) {
            throw new IllegalArgumentException("Required value for 'active28Day' is null");
        }
        this.active28Day = active28Day;
    }

    /**
     * Report of the number of devices active in the last day.
     *
     * @return value for this field, never {@code null}.
     */
    public DevicesActive getActive1Day() {
        return active1Day;
    }

    /**
     * Report of the number of devices active in the last 7 days.
     *
     * @return value for this field, never {@code null}.
     */
    public DevicesActive getActive7Day() {
        return active7Day;
    }

    /**
     * Report of the number of devices active in the last 28 days.
     *
     * @return value for this field, never {@code null}.
     */
    public DevicesActive getActive28Day() {
        return active28Day;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            active1Day,
            active7Day,
            active28Day
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
            GetDevicesReport other = (GetDevicesReport) obj;
            return ((this.active1Day == other.active1Day) || (this.active1Day.equals(other.active1Day)))
                && ((this.active7Day == other.active7Day) || (this.active7Day.equals(other.active7Day)))
                && ((this.active28Day == other.active28Day) || (this.active28Day.equals(other.active28Day)))
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

    public static GetDevicesReport fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetDevicesReport> _JSON_WRITER = new JsonWriter<GetDevicesReport>() {
        public final void write(GetDevicesReport x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            BaseDfbReport._JSON_WRITER.writeFields(x, g);
            GetDevicesReport._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetDevicesReport x, JsonGenerator g) throws IOException {
            g.writeFieldName("active_1_day");
            DevicesActive._JSON_WRITER.write(x.active1Day, g);
            g.writeFieldName("active_7_day");
            DevicesActive._JSON_WRITER.write(x.active7Day, g);
            g.writeFieldName("active_28_day");
            DevicesActive._JSON_WRITER.write(x.active28Day, g);
        }
    };

    public static final JsonReader<GetDevicesReport> _JSON_READER = new JsonReader<GetDevicesReport>() {
        public final GetDevicesReport read(JsonParser parser) throws IOException, JsonReadException {
            GetDevicesReport result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetDevicesReport readFields(JsonParser parser) throws IOException, JsonReadException {
            String startDate = null;
            DevicesActive active1Day = null;
            DevicesActive active7Day = null;
            DevicesActive active28Day = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("start_date".equals(fieldName)) {
                    startDate = JsonReader.StringReader
                        .readField(parser, "start_date", startDate);
                }
                else if ("active_1_day".equals(fieldName)) {
                    active1Day = DevicesActive._JSON_READER
                        .readField(parser, "active_1_day", active1Day);
                }
                else if ("active_7_day".equals(fieldName)) {
                    active7Day = DevicesActive._JSON_READER
                        .readField(parser, "active_7_day", active7Day);
                }
                else if ("active_28_day".equals(fieldName)) {
                    active28Day = DevicesActive._JSON_READER
                        .readField(parser, "active_28_day", active28Day);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (startDate == null) {
                throw new JsonReadException("Required field \"start_date\" is missing.", parser.getTokenLocation());
            }
            if (active1Day == null) {
                throw new JsonReadException("Required field \"active_1_day\" is missing.", parser.getTokenLocation());
            }
            if (active7Day == null) {
                throw new JsonReadException("Required field \"active_7_day\" is missing.", parser.getTokenLocation());
            }
            if (active28Day == null) {
                throw new JsonReadException("Required field \"active_28_day\" is missing.", parser.getTokenLocation());
            }
            return new GetDevicesReport(startDate, active1Day, active7Day, active28Day);
        }
    };
}
