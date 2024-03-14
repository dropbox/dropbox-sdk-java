/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.team.TeamReportFailureReason;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Failed to create members data report.
 */
public class ExportMembersReportFailDetails {
    // struct team_log.ExportMembersReportFailDetails (team_log_generated.stone)

    protected final TeamReportFailureReason failureReason;

    /**
     * Failed to create members data report.
     *
     * @param failureReason  Failure reason. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExportMembersReportFailDetails(@javax.annotation.Nonnull TeamReportFailureReason failureReason) {
        if (failureReason == null) {
            throw new IllegalArgumentException("Required value for 'failureReason' is null");
        }
        this.failureReason = failureReason;
    }

    /**
     * Failure reason.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamReportFailureReason getFailureReason() {
        return failureReason;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            failureReason
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
            ExportMembersReportFailDetails other = (ExportMembersReportFailDetails) obj;
            return (this.failureReason == other.failureReason) || (this.failureReason.equals(other.failureReason));
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
    static class Serializer extends StructSerializer<ExportMembersReportFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExportMembersReportFailDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("failure_reason");
            TeamReportFailureReason.Serializer.INSTANCE.serialize(value.failureReason, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExportMembersReportFailDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExportMembersReportFailDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamReportFailureReason f_failureReason = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("failure_reason".equals(field)) {
                        f_failureReason = TeamReportFailureReason.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_failureReason == null) {
                    throw new JsonParseException(p, "Required field \"failure_reason\" missing.");
                }
                value = new ExportMembersReportFailDetails(f_failureReason);
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
