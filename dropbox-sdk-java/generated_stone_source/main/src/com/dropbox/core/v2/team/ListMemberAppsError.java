/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

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

/**
 * Error returned by {@link
 * DbxTeamTeamRequests#linkedAppsListMemberLinkedApps(String)}.
 */
public enum ListMemberAppsError {
    // union team.ListMemberAppsError (team_linked_apps.stone)
    /**
     * Member not found.
     */
    MEMBER_NOT_FOUND,
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
    static class Serializer extends UnionSerializer<ListMemberAppsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListMemberAppsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case MEMBER_NOT_FOUND: {
                    g.writeString("member_not_found");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListMemberAppsError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListMemberAppsError value;
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
            else if ("member_not_found".equals(tag)) {
                value = ListMemberAppsError.MEMBER_NOT_FOUND;
            }
            else {
                value = ListMemberAppsError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
