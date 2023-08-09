/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

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

public enum ListMembersDevicesError {
    // union team.ListMembersDevicesError (team_devices.stone)
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxTeamTeamRequests#devicesListMembersDevices} again with an empty cursor
     * to obtain a new cursor.
     */
    RESET,
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
    static class Serializer extends UnionSerializer<ListMembersDevicesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListMembersDevicesError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
        public ListMembersDevicesError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListMembersDevicesError value;
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
                value = ListMembersDevicesError.RESET;
            }
            else {
                value = ListMembersDevicesError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
