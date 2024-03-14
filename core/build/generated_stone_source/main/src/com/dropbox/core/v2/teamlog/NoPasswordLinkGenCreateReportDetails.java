/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Report created: Links created without passwords.
 */
public class NoPasswordLinkGenCreateReportDetails {
    // struct team_log.NoPasswordLinkGenCreateReportDetails (team_log_generated.stone)

    protected final Date startDate;
    protected final Date endDate;

    /**
     * Report created: Links created without passwords.
     *
     * @param startDate  Report start date. Must not be {@code null}.
     * @param endDate  Report end date. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public NoPasswordLinkGenCreateReportDetails(Date startDate, Date endDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Required value for 'startDate' is null");
        }
        this.startDate = LangUtil.truncateMillis(startDate);
        if (endDate == null) {
            throw new IllegalArgumentException("Required value for 'endDate' is null");
        }
        this.endDate = LangUtil.truncateMillis(endDate);
    }

    /**
     * Report start date.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Report end date.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            NoPasswordLinkGenCreateReportDetails other = (NoPasswordLinkGenCreateReportDetails) obj;
            return ((this.startDate == other.startDate) || (this.startDate.equals(other.startDate)))
                && ((this.endDate == other.endDate) || (this.endDate.equals(other.endDate)))
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
    static class Serializer extends StructSerializer<NoPasswordLinkGenCreateReportDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(NoPasswordLinkGenCreateReportDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("start_date");
            StoneSerializers.timestamp().serialize(value.startDate, g);
            g.writeFieldName("end_date");
            StoneSerializers.timestamp().serialize(value.endDate, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public NoPasswordLinkGenCreateReportDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            NoPasswordLinkGenCreateReportDetails value;
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
                        f_startDate = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("end_date".equals(field)) {
                        f_endDate = StoneSerializers.timestamp().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                if (f_endDate == null) {
                    throw new JsonParseException(p, "Required field \"end_date\" missing.");
                }
                value = new NoPasswordLinkGenCreateReportDetails(f_startDate, f_endDate);
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
