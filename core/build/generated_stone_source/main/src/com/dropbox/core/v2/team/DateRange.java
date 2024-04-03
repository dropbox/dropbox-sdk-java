/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Input arguments that can be provided for most reports.
 */
class DateRange {
    // struct team.DateRange (team_reports.stone)

    @Nullable
    protected final Date startDate;
    @Nullable
    protected final Date endDate;

    /**
     * Input arguments that can be provided for most reports.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param startDate  Optional starting date (inclusive). If start_date is
     *     None or too long ago, this field will  be set to 6 months ago.
     * @param endDate  Optional ending date (exclusive).
     */
    public DateRange(@Nullable Date startDate, @Nullable Date endDate) {
        this.startDate = LangUtil.truncateMillis(startDate);
        this.endDate = LangUtil.truncateMillis(endDate);
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
     * Optional starting date (inclusive). If start_date is None or too long
     * ago, this field will  be set to 6 months ago.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Optional ending date (exclusive).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
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
         * @param startDate  Optional starting date (inclusive). If start_date
         *     is None or too long ago, this field will  be set to 6 months ago.
         *
         * @return this builder
         */
        public Builder withStartDate(Date startDate) {
            this.startDate = LangUtil.truncateMillis(startDate);
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
            this.endDate = LangUtil.truncateMillis(endDate);
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
        int hash = Arrays.hashCode(new Object [] {
            this.startDate,
            this.endDate
        });
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
    static class Serializer extends StructSerializer<DateRange> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DateRange value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.startDate != null) {
                g.writeFieldName("start_date");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.startDate, g);
            }
            if (value.endDate != null) {
                g.writeFieldName("end_date");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.endDate, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DateRange deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DateRange value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_startDate = null;
                Date f_endDate = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("end_date".equals(field)) {
                        f_endDate = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new DateRange(f_startDate, f_endDate);
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
