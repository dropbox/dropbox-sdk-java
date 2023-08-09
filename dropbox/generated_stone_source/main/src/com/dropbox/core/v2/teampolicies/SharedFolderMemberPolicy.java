/* DO NOT EDIT */
/* This file was generated from team_policies.stone */

package com.dropbox.core.v2.teampolicies;

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
 * Policy governing who can be a member of a folder shared by a team member.
 */
public enum SharedFolderMemberPolicy {
    // union team_policies.SharedFolderMemberPolicy (team_policies.stone)
    /**
     * Only a teammate can be a member of a folder shared by a team member.
     */
    TEAM,
    /**
     * Anyone can be a member of a folder shared by a team member.
     */
    ANYONE,
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
    static class Serializer extends UnionSerializer<SharedFolderMemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMemberPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TEAM: {
                    g.writeString("team");
                    break;
                }
                case ANYONE: {
                    g.writeString("anyone");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedFolderMemberPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedFolderMemberPolicy value;
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
            else if ("team".equals(tag)) {
                value = SharedFolderMemberPolicy.TEAM;
            }
            else if ("anyone".equals(tag)) {
                value = SharedFolderMemberPolicy.ANYONE;
            }
            else {
                value = SharedFolderMemberPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
