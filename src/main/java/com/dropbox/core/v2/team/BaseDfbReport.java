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
 * Base report structure.
 */
public class BaseDfbReport {
    // struct BaseDfbReport

    private final String startDate;

    /**
     * Base report structure.
     *
     * @param startDate  First date present in the results as 'YYYY-MM-DD' or
     *     None. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BaseDfbReport(String startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Required value for 'startDate' is null");
        }
        this.startDate = startDate;
    }

    /**
     * First date present in the results as 'YYYY-MM-DD' or None.
     *
     * @return value for this field, never {@code null}.
     */
    public String getStartDate() {
        return startDate;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            startDate
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
            BaseDfbReport other = (BaseDfbReport) obj;
            return (this.startDate == other.startDate) || (this.startDate.equals(other.startDate));
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

    public static BaseDfbReport fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<BaseDfbReport> _JSON_WRITER = new JsonWriter<BaseDfbReport>() {
        public final void write(BaseDfbReport x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            BaseDfbReport._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(BaseDfbReport x, JsonGenerator g) throws IOException {
            g.writeFieldName("start_date");
            g.writeString(x.startDate);
        }
    };

    public static final JsonReader<BaseDfbReport> _JSON_READER = new JsonReader<BaseDfbReport>() {
        public final BaseDfbReport read(JsonParser parser) throws IOException, JsonReadException {
            BaseDfbReport result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final BaseDfbReport readFields(JsonParser parser) throws IOException, JsonReadException {
            String startDate = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("start_date".equals(fieldName)) {
                    startDate = JsonReader.StringReader
                        .readField(parser, "start_date", startDate);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (startDate == null) {
                throw new JsonReadException("Required field \"start_date\" is missing.", parser.getTokenLocation());
            }
            return new BaseDfbReport(startDate);
        }
    };
}
