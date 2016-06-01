/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
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

    protected final DevicesActive active1Day;
    protected final DevicesActive active7Day;
    protected final DevicesActive active28Day;

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
            return ((this.startDate == other.startDate) || (this.startDate.equals(other.startDate)))
                && ((this.active1Day == other.active1Day) || (this.active1Day.equals(other.active1Day)))
                && ((this.active7Day == other.active7Day) || (this.active7Day.equals(other.active7Day)))
                && ((this.active28Day == other.active28Day) || (this.active28Day.equals(other.active28Day)))
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
    static final class Serializer extends StructSerializer<GetDevicesReport> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetDevicesReport value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("start_date");
            StoneSerializers.string().serialize(value.startDate, g);
            g.writeFieldName("active_1_day");
            DevicesActive.Serializer.INSTANCE.serialize(value.active1Day, g);
            g.writeFieldName("active_7_day");
            DevicesActive.Serializer.INSTANCE.serialize(value.active7Day, g);
            g.writeFieldName("active_28_day");
            DevicesActive.Serializer.INSTANCE.serialize(value.active28Day, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetDevicesReport deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetDevicesReport value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_startDate = null;
                DevicesActive f_active1Day = null;
                DevicesActive f_active7Day = null;
                DevicesActive f_active28Day = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.string().deserialize(p);
                    }
                    else if ("active_1_day".equals(field)) {
                        f_active1Day = DevicesActive.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("active_7_day".equals(field)) {
                        f_active7Day = DevicesActive.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("active_28_day".equals(field)) {
                        f_active28Day = DevicesActive.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                if (f_active1Day == null) {
                    throw new JsonParseException(p, "Required field \"active_1_day\" missing.");
                }
                if (f_active7Day == null) {
                    throw new JsonParseException(p, "Required field \"active_7_day\" missing.");
                }
                if (f_active28Day == null) {
                    throw new JsonParseException(p, "Required field \"active_28_day\" missing.");
                }
                value = new GetDevicesReport(f_startDate, f_active1Day, f_active7Day, f_active28Day);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
