/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

public enum TeamReportFailureReason {
    // union team.TeamReportFailureReason (team_reports.stone)
    /**
     * We couldn't create the report, but we think this was a fluke. Everything
     * should work if you try it again.
     */
    TEMPORARY_ERROR,
    /**
     * Too many other reports are being created right now. Try creating this
     * report again once the others finish.
     */
    MANY_REPORTS_AT_ONCE,
    /**
     * We couldn't create the report. Try creating the report again with less
     * data.
     */
    TOO_MUCH_DATA,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    public static class Serializer extends UnionSerializer<TeamReportFailureReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamReportFailureReason value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TEMPORARY_ERROR: {
                    g.writeString("temporary_error");
                    break;
                }
                case MANY_REPORTS_AT_ONCE: {
                    g.writeString("many_reports_at_once");
                    break;
                }
                case TOO_MUCH_DATA: {
                    g.writeString("too_much_data");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TeamReportFailureReason deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamReportFailureReason value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("temporary_error".equals(tag)) {
                value = TeamReportFailureReason.TEMPORARY_ERROR;
            }
            else if ("many_reports_at_once".equals(tag)) {
                value = TeamReportFailureReason.MANY_REPORTS_AT_ONCE;
            }
            else if ("too_much_data".equals(tag)) {
                value = TeamReportFailureReason.TOO_MUCH_DATA;
            }
            else {
                value = TeamReportFailureReason.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
