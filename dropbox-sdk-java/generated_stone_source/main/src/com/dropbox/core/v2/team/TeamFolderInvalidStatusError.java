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

public enum TeamFolderInvalidStatusError {
    // union team.TeamFolderInvalidStatusError (team_folders.stone)
    /**
     * The folder is active and the operation did not succeed.
     */
    ACTIVE,
    /**
     * The folder is archived and the operation did not succeed.
     */
    ARCHIVED,
    /**
     * The folder is being archived and the operation did not succeed.
     */
    ARCHIVE_IN_PROGRESS,
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
    static class Serializer extends UnionSerializer<TeamFolderInvalidStatusError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderInvalidStatusError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACTIVE: {
                    g.writeString("active");
                    break;
                }
                case ARCHIVED: {
                    g.writeString("archived");
                    break;
                }
                case ARCHIVE_IN_PROGRESS: {
                    g.writeString("archive_in_progress");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TeamFolderInvalidStatusError deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamFolderInvalidStatusError value;
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
            else if ("active".equals(tag)) {
                value = TeamFolderInvalidStatusError.ACTIVE;
            }
            else if ("archived".equals(tag)) {
                value = TeamFolderInvalidStatusError.ARCHIVED;
            }
            else if ("archive_in_progress".equals(tag)) {
                value = TeamFolderInvalidStatusError.ARCHIVE_IN_PROGRESS;
            }
            else {
                value = TeamFolderInvalidStatusError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
