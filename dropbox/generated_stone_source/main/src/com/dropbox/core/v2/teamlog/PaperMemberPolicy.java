/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

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
 * Policy for controlling if team members can share Paper documents externally.
 */
public enum PaperMemberPolicy {
    // union team_log.PaperMemberPolicy (team_log_generated.stone)
    ANYONE_WITH_LINK,
    ONLY_TEAM,
    TEAM_AND_EXPLICITLY_SHARED,
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
    static class Serializer extends UnionSerializer<PaperMemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperMemberPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ANYONE_WITH_LINK: {
                    g.writeString("anyone_with_link");
                    break;
                }
                case ONLY_TEAM: {
                    g.writeString("only_team");
                    break;
                }
                case TEAM_AND_EXPLICITLY_SHARED: {
                    g.writeString("team_and_explicitly_shared");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperMemberPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperMemberPolicy value;
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
            else if ("anyone_with_link".equals(tag)) {
                value = PaperMemberPolicy.ANYONE_WITH_LINK;
            }
            else if ("only_team".equals(tag)) {
                value = PaperMemberPolicy.ONLY_TEAM;
            }
            else if ("team_and_explicitly_shared".equals(tag)) {
                value = PaperMemberPolicy.TEAM_AND_EXPLICITLY_SHARED;
            }
            else {
                value = PaperMemberPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
