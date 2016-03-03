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

/**
 * Devices Report Result. Contains subsections for different time ranges of
 * activity. Each of the items in each subsection of the storage report is an
 * array of values, one value per day. If there is no data for a day, then the
 * value will be None.
 */
@JsonSerialize(using=GetDevicesReport.Serializer.class)
@JsonDeserialize(using=GetDevicesReport.Deserializer.class)
public class GetDevicesReport extends BaseDfbReport {
    // struct GetDevicesReport

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<GetDevicesReport> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetDevicesReport.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetDevicesReport.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetDevicesReport> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetDevicesReport value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("start_date", value.startDate);
            g.writeObjectField("active_1_day", value.active1Day);
            g.writeObjectField("active_7_day", value.active7Day);
            g.writeObjectField("active_28_day", value.active28Day);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetDevicesReport> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetDevicesReport.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetDevicesReport.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetDevicesReport> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetDevicesReport deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String startDate = null;
            DevicesActive active1Day = null;
            DevicesActive active7Day = null;
            DevicesActive active28Day = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("start_date".equals(_field)) {
                    startDate = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("active_1_day".equals(_field)) {
                    active1Day = _p.readValueAs(DevicesActive.class);
                    _p.nextToken();
                }
                else if ("active_7_day".equals(_field)) {
                    active7Day = _p.readValueAs(DevicesActive.class);
                    _p.nextToken();
                }
                else if ("active_28_day".equals(_field)) {
                    active28Day = _p.readValueAs(DevicesActive.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (startDate == null) {
                throw new JsonParseException(_p, "Required field \"start_date\" is missing.");
            }
            if (active1Day == null) {
                throw new JsonParseException(_p, "Required field \"active_1_day\" is missing.");
            }
            if (active7Day == null) {
                throw new JsonParseException(_p, "Required field \"active_7_day\" is missing.");
            }
            if (active28Day == null) {
                throw new JsonParseException(_p, "Required field \"active_28_day\" is missing.");
            }

            return new GetDevicesReport(startDate, active1Day, active7Day, active28Day);
        }
    }
}
