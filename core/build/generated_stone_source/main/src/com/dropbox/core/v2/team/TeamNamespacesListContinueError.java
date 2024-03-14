/* DO NOT EDIT */
/* This file was generated from team_namespaces.stone */

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

public enum TeamNamespacesListContinueError {
    // union team.TeamNamespacesListContinueError (team_namespaces.stone)
    /**
     * Argument passed in is invalid.
     */
    INVALID_ARG,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER,
    /**
     * The cursor is invalid.
     */
    INVALID_CURSOR;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<TeamNamespacesListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamNamespacesListContinueError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_ARG: {
                    g.writeString("invalid_arg");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case INVALID_CURSOR: {
                    g.writeString("invalid_cursor");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public TeamNamespacesListContinueError deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamNamespacesListContinueError value;
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
            else if ("invalid_arg".equals(tag)) {
                value = TeamNamespacesListContinueError.INVALID_ARG;
            }
            else if ("other".equals(tag)) {
                value = TeamNamespacesListContinueError.OTHER;
            }
            else if ("invalid_cursor".equals(tag)) {
                value = TeamNamespacesListContinueError.INVALID_CURSOR;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
