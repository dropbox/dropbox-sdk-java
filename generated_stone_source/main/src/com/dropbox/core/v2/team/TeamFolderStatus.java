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

public enum TeamFolderStatus {
    // union team.TeamFolderStatus (team_folders.stone)
    /**
     * The team folder and sub-folders are available to all members.
     */
    ACTIVE,
    /**
     * The team folder is not accessible outside of the team folder manager.
     */
    ARCHIVED,
    /**
     * The team folder is not accessible outside of the team folder manager.
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
    public static class Serializer extends UnionSerializer<TeamFolderStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
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
        public TeamFolderStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamFolderStatus value;
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
                value = TeamFolderStatus.ACTIVE;
            }
            else if ("archived".equals(tag)) {
                value = TeamFolderStatus.ARCHIVED;
            }
            else if ("archive_in_progress".equals(tag)) {
                value = TeamFolderStatus.ARCHIVE_IN_PROGRESS;
            }
            else {
                value = TeamFolderStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
