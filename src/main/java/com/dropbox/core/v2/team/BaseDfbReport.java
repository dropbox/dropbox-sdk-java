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
 * Base report structure.
 */
@JsonSerialize(using=BaseDfbReport.Serializer.class)
@JsonDeserialize(using=BaseDfbReport.Deserializer.class)
public class BaseDfbReport {
    // struct BaseDfbReport

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String startDate;

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

    static final class Serializer extends StructJsonSerializer<BaseDfbReport> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(BaseDfbReport.class);
        }

        public Serializer(boolean unwrapping) {
            super(BaseDfbReport.class, unwrapping);
        }

        @Override
        protected JsonSerializer<BaseDfbReport> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(BaseDfbReport value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("start_date", value.startDate);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<BaseDfbReport> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(BaseDfbReport.class);
        }

        public Deserializer(boolean unwrapping) {
            super(BaseDfbReport.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<BaseDfbReport> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public BaseDfbReport deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String startDate = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("start_date".equals(_field)) {
                    startDate = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (startDate == null) {
                throw new JsonParseException(_p, "Required field \"start_date\" is missing.");
            }

            return new BaseDfbReport(startDate);
        }
    }
}
