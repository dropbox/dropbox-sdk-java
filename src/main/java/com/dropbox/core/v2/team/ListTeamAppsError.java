/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Error returned by {@link DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}
 */
public enum ListTeamAppsError {
    // union ListTeamAppsError
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()} again with an empty
     * cursor to obtain a new cursor.
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
    static final class Serializer extends UnionSerializer<ListTeamAppsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListTeamAppsError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
        public ListTeamAppsError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListTeamAppsError value;
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
                value = ListTeamAppsError.RESET;
            }
            else {
                value = ListTeamAppsError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
