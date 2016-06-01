/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum ListTeamDevicesError {
    // union ListTeamDevicesError
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxTeamTeamRequests#devicesListTeamDevices()} again with an empty cursor
     * to obtain a new cursor.
     */
    RESET,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<ListTeamDevicesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListTeamDevicesError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case RESET: {
                    g.writeString("reset");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListTeamDevicesError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListTeamDevicesError value;
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
            else if ("reset".equals(tag)) {
                value = ListTeamDevicesError.RESET;
            }
            else {
                value = ListTeamDevicesError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
