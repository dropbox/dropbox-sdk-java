/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

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

public enum TeamFolderTeamSharedDropboxError {
    // union team.TeamFolderTeamSharedDropboxError (team_folders.stone)
    /**
     * This action is not allowed for a shared team root.
     */
    DISALLOWED,
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
    static class Serializer extends UnionSerializer<TeamFolderTeamSharedDropboxError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderTeamSharedDropboxError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DISALLOWED: {
                    g.writeString("disallowed");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TeamFolderTeamSharedDropboxError deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamFolderTeamSharedDropboxError value;
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
            else if ("disallowed".equals(tag)) {
                value = TeamFolderTeamSharedDropboxError.DISALLOWED;
            }
            else {
                value = TeamFolderTeamSharedDropboxError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
