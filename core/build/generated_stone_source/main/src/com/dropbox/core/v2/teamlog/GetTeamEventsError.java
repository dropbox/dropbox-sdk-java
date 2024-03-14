/* DO NOT EDIT */
/* This file was generated from team_log.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Errors that can be raised when calling {@link
 * DbxTeamTeamLogRequests#getEvents}.
 */
public enum GetTeamEventsError {
    // union team_log.GetTeamEventsError (team_log.stone)
    /**
     * No user found matching the provided account_id.
     */
    ACCOUNT_ID_NOT_FOUND,
    /**
     * Invalid time range.
     */
    INVALID_TIME_RANGE,
    /**
     * Invalid filters. Do not specify both event_type and category parameters
     * for the same call.
     */
    INVALID_FILTERS,
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
    static class Serializer extends UnionSerializer<GetTeamEventsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTeamEventsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACCOUNT_ID_NOT_FOUND: {
                    g.writeString("account_id_not_found");
                    break;
                }
                case INVALID_TIME_RANGE: {
                    g.writeString("invalid_time_range");
                    break;
                }
                case INVALID_FILTERS: {
                    g.writeString("invalid_filters");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GetTeamEventsError deserialize(JsonParser p) throws IOException, JsonParseException {
            GetTeamEventsError value;
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
            else if ("account_id_not_found".equals(tag)) {
                value = GetTeamEventsError.ACCOUNT_ID_NOT_FOUND;
            }
            else if ("invalid_time_range".equals(tag)) {
                value = GetTeamEventsError.INVALID_TIME_RANGE;
            }
            else if ("invalid_filters".equals(tag)) {
                value = GetTeamEventsError.INVALID_FILTERS;
            }
            else {
                value = GetTeamEventsError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
