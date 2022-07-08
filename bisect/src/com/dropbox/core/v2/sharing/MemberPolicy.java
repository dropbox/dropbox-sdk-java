/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

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
 * Policy governing who can be a member of a shared folder. Only applicable to
 * folders owned by a user on a team.
 */
public enum MemberPolicy {
    // union sharing.MemberPolicy (sharing_folders.stone)
    /**
     * Only a teammate can become a member.
     */
    TEAM,
    /**
     * Anyone can become a member.
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
    public static class Serializer extends UnionSerializer<MemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
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
        public MemberPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberPolicy value;
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
                value = MemberPolicy.TEAM;
            }
            else if ("anyone".equals(tag)) {
                value = MemberPolicy.ANYONE;
            }
            else {
                value = MemberPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
