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
 * Policy to set default access for newly created Paper folders.
 */
public enum PaperDefaultFolderPolicy {
    // union team_log.PaperDefaultFolderPolicy (team_log_generated.stone)
    EVERYONE_IN_TEAM,
    INVITE_ONLY,
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
    static class Serializer extends UnionSerializer<PaperDefaultFolderPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDefaultFolderPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EVERYONE_IN_TEAM: {
                    g.writeString("everyone_in_team");
                    break;
                }
                case INVITE_ONLY: {
                    g.writeString("invite_only");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PaperDefaultFolderPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            PaperDefaultFolderPolicy value;
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
            else if ("everyone_in_team".equals(tag)) {
                value = PaperDefaultFolderPolicy.EVERYONE_IN_TEAM;
            }
            else if ("invite_only".equals(tag)) {
                value = PaperDefaultFolderPolicy.INVITE_ONLY;
            }
            else {
                value = PaperDefaultFolderPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
