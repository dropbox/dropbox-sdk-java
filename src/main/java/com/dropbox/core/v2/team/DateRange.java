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
import java.util.Date;

/**
 * Input arguments that can be provided for most reports.
 */
@JsonSerialize(using=DateRange.Serializer.class)
@JsonDeserialize(using=DateRange.Deserializer.class)
public class DateRange {
    // struct DateRange

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final Date startDate;
    protected final Date endDate;

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
        this.startDate = com.dropbox.core.util.LangUtil.truncateMillis(startDate);
        this.endDate = com.dropbox.core.util.LangUtil.truncateMillis(endDate);
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
            this.startDate = com.dropbox.core.util.LangUtil.truncateMillis(startDate);
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
            this.endDate = com.dropbox.core.util.LangUtil.truncateMillis(endDate);
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

    static final class Serializer extends StructJsonSerializer<DateRange> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DateRange.class);
        }

        public Serializer(boolean unwrapping) {
            super(DateRange.class, unwrapping);
        }

        @Override
        protected JsonSerializer<DateRange> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(DateRange value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value.startDate != null) {
                g.writeObjectField("start_date", value.startDate);
            }
            if (value.endDate != null) {
                g.writeObjectField("end_date", value.endDate);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<DateRange> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DateRange.class);
        }

        public Deserializer(boolean unwrapping) {
            super(DateRange.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<DateRange> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public DateRange deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Date startDate = null;
            Date endDate = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("start_date".equals(_field)) {
                    startDate = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("end_date".equals(_field)) {
                    endDate = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new DateRange(startDate, endDate);
        }
    }
}
