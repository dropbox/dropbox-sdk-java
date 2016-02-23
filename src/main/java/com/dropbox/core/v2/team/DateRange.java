/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * Input arguments that can be provided for most reports.
 */
public class DateRange {
    // struct DateRange

    private final Date startDate;
    private final Date endDate;

    /**
     * Input arguments that can be provided for most reports.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param startDate  Optional starting date (inclusive).
     * @param endDate  Optional ending date (exclusive).
     */
    public DateRange(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Input arguments that can be provided for most reports.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public DateRange() {
        this(null, null);
    }

    /**
     * Optional starting date (inclusive)
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Optional ending date (exclusive)
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link DateRange}.
     */
    public static class Builder {

        protected Date startDate;
        protected Date endDate;

        protected Builder() {
            this.startDate = null;
            this.endDate = null;
        }

        /**
         * Set value for optional field.
         *
         * @param startDate  Optional starting date (inclusive).
         *
         * @return this builder
         */
        public Builder withStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param endDate  Optional ending date (exclusive).
         *
         * @return this builder
         */
        public Builder withEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * Builds an instance of {@link DateRange} configured with this
         * builder's values
         *
         * @return new instance of {@link DateRange}
         */
        public DateRange build() {
            return new DateRange(startDate, endDate);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            startDate,
            endDate
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            DateRange other = (DateRange) obj;
            return ((this.startDate == other.startDate) || (this.startDate != null && this.startDate.equals(other.startDate)))
                && ((this.endDate == other.endDate) || (this.endDate != null && this.endDate.equals(other.endDate)))
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

    public static DateRange fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DateRange> _JSON_WRITER = new JsonWriter<DateRange>() {
        public final void write(DateRange x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DateRange._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(DateRange x, JsonGenerator g) throws IOException {
            if (x.startDate != null) {
                g.writeFieldName("start_date");
                writeDateIso(x.startDate, g);
            }
            if (x.endDate != null) {
                g.writeFieldName("end_date");
                writeDateIso(x.endDate, g);
            }
        }
    };

    public static final JsonReader<DateRange> _JSON_READER = new JsonReader<DateRange>() {
        public final DateRange read(JsonParser parser) throws IOException, JsonReadException {
            DateRange result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final DateRange readFields(JsonParser parser) throws IOException, JsonReadException {
            Date startDate = null;
            Date endDate = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("start_date".equals(fieldName)) {
                    startDate = JsonDateReader.DropboxV2
                        .readField(parser, "start_date", startDate);
                }
                else if ("end_date".equals(fieldName)) {
                    endDate = JsonDateReader.DropboxV2
                        .readField(parser, "end_date", endDate);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new DateRange(startDate, endDate);
        }
    };
}
