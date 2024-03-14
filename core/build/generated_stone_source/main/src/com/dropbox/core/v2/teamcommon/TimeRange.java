/* DO NOT EDIT */
/* This file was generated from team_common.stone */

package com.dropbox.core.v2.teamcommon;

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
 * Time range.
 */
public class TimeRange {
    // struct team_common.TimeRange (team_common.stone)

    protected final Date startTime;
    protected final Date endTime;

    /**
     * Time range.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param startTime  Optional starting time (inclusive).
     * @param endTime  Optional ending time (exclusive).
     */
    public TimeRange(@Nullable Date startTime, @Nullable Date endTime) {
        this.startTime = LangUtil.truncateMillis(startTime);
        this.endTime = LangUtil.truncateMillis(endTime);
    }

    /**
     * Time range.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public TimeRange() {
        this(null, null);
    }

    /**
     * Optional starting time (inclusive).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Optional ending time (exclusive).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getEndTime() {
        return endTime;
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
     * Builder for {@link TimeRange}.
     */
    public static class Builder {

        protected Date startTime;
        protected Date endTime;

        protected Builder() {
            this.startTime = null;
            this.endTime = null;
        }

        /**
         * Set value for optional field.
         *
         * @param startTime  Optional starting time (inclusive).
         *
         * @return this builder
         */
        public Builder withStartTime(Date startTime) {
            this.startTime = LangUtil.truncateMillis(startTime);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param endTime  Optional ending time (exclusive).
         *
         * @return this builder
         */
        public Builder withEndTime(Date endTime) {
            this.endTime = LangUtil.truncateMillis(endTime);
            return this;
        }

        /**
         * Builds an instance of {@link TimeRange} configured with this
         * builder's values
         *
         * @return new instance of {@link TimeRange}
         */
        public TimeRange build() {
            return new TimeRange(startTime, endTime);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            startTime,
            endTime
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
            TimeRange other = (TimeRange) obj;
            return ((this.startTime == other.startTime) || (this.startTime != null && this.startTime.equals(other.startTime)))
                && ((this.endTime == other.endTime) || (this.endTime != null && this.endTime.equals(other.endTime)))
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
    public static class Serializer extends StructSerializer<TimeRange> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TimeRange value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.startTime != null) {
                g.writeFieldName("start_time");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.startTime, g);
            }
            if (value.endTime != null) {
                g.writeFieldName("end_time");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.endTime, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TimeRange deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TimeRange value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_startTime = null;
                Date f_endTime = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("start_time".equals(field)) {
                        f_startTime = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("end_time".equals(field)) {
                        f_endTime = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new TimeRange(f_startTime, f_endTime);
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
