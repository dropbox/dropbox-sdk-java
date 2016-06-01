/* DO NOT EDIT */
/* This file was generated from team_policies.stone */

package com.dropbox.core.v2.teampolicies;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Policy governing which shared folders a team member can join.
 */
public enum SharedFolderJoinPolicy {
    // union SharedFolderJoinPolicy
    /**
     * Team members can only join folders shared by teammates.
     */
    FROM_TEAM_ONLY,
    /**
     * Team members can join any shared folder, including those shared by users
     * outside the team.
     */
    FROM_ANYONE,
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
    static final class Serializer extends UnionSerializer<SharedFolderJoinPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderJoinPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FROM_TEAM_ONLY: {
                    g.writeString("from_team_only");
                    break;
                }
                case FROM_ANYONE: {
                    g.writeString("from_anyone");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedFolderJoinPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedFolderJoinPolicy value;
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
            else if ("from_team_only".equals(tag)) {
                value = SharedFolderJoinPolicy.FROM_TEAM_ONLY;
            }
            else if ("from_anyone".equals(tag)) {
                value = SharedFolderJoinPolicy.FROM_ANYONE;
            }
            else {
                value = SharedFolderJoinPolicy.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
