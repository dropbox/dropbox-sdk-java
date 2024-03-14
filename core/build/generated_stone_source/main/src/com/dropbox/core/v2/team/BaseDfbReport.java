/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Base report structure.
 */
public class BaseDfbReport {
    // struct team.BaseDfbReport (team_reports.stone)

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
    @javax.annotation.Nonnull
    public String getStartDate() {
        return startDate;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            startDate
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
            BaseDfbReport other = (BaseDfbReport) obj;
            return (this.startDate == other.startDate) || (this.startDate.equals(other.startDate));
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
    private static class Serializer extends StructSerializer<BaseDfbReport> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(BaseDfbReport value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("start_date");
            StoneSerializers.string().serialize(value.startDate, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public BaseDfbReport deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            BaseDfbReport value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_startDate = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                value = new BaseDfbReport(f_startDate);
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
