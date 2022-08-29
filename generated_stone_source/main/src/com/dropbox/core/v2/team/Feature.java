/* DO NOT EDIT */
/* This file was generated from team.stone */

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
 * A set of features that a Dropbox Business account may support.
 */
public enum Feature {
    // union team.Feature (team.stone)
    /**
     * The number of upload API calls allowed per month.
     */
    UPLOAD_API_RATE_LIMIT,
    /**
     * Does this team have a shared team root.
     */
    HAS_TEAM_SHARED_DROPBOX,
    /**
     * Does this team have file events.
     */
    HAS_TEAM_FILE_EVENTS,
    /**
     * Does this team have team selective sync enabled.
     */
    HAS_TEAM_SELECTIVE_SYNC,
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
    static class Serializer extends UnionSerializer<Feature> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Feature value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case UPLOAD_API_RATE_LIMIT: {
                    g.writeString("upload_api_rate_limit");
                    break;
                }
                case HAS_TEAM_SHARED_DROPBOX: {
                    g.writeString("has_team_shared_dropbox");
                    break;
                }
                case HAS_TEAM_FILE_EVENTS: {
                    g.writeString("has_team_file_events");
                    break;
                }
                case HAS_TEAM_SELECTIVE_SYNC: {
                    g.writeString("has_team_selective_sync");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public Feature deserialize(JsonParser p) throws IOException, JsonParseException {
            Feature value;
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
            else if ("upload_api_rate_limit".equals(tag)) {
                value = Feature.UPLOAD_API_RATE_LIMIT;
            }
            else if ("has_team_shared_dropbox".equals(tag)) {
                value = Feature.HAS_TEAM_SHARED_DROPBOX;
            }
            else if ("has_team_file_events".equals(tag)) {
                value = Feature.HAS_TEAM_FILE_EVENTS;
            }
            else if ("has_team_selective_sync".equals(tag)) {
                value = Feature.HAS_TEAM_SELECTIVE_SYNC;
            }
            else {
                value = Feature.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
