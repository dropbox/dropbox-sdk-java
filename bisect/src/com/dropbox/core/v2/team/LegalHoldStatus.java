/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

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

public enum LegalHoldStatus {
    // union team.LegalHoldStatus (team_legal_holds.stone)
    /**
     * The legal hold policy is active.
     */
    ACTIVE,
    /**
     * The legal hold policy was released.
     */
    RELEASED,
    /**
     * The legal hold policy is activating.
     */
    ACTIVATING,
    /**
     * The legal hold policy is updating.
     */
    UPDATING,
    /**
     * The legal hold policy is exporting.
     */
    EXPORTING,
    /**
     * The legal hold policy is releasing.
     */
    RELEASING,
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
    static class Serializer extends UnionSerializer<LegalHoldStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACTIVE: {
                    g.writeString("active");
                    break;
                }
                case RELEASED: {
                    g.writeString("released");
                    break;
                }
                case ACTIVATING: {
                    g.writeString("activating");
                    break;
                }
                case UPDATING: {
                    g.writeString("updating");
                    break;
                }
                case EXPORTING: {
                    g.writeString("exporting");
                    break;
                }
                case RELEASING: {
                    g.writeString("releasing");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LegalHoldStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            LegalHoldStatus value;
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
                value = LegalHoldStatus.ACTIVE;
            }
            else if ("released".equals(tag)) {
                value = LegalHoldStatus.RELEASED;
            }
            else if ("activating".equals(tag)) {
                value = LegalHoldStatus.ACTIVATING;
            }
            else if ("updating".equals(tag)) {
                value = LegalHoldStatus.UPDATING;
            }
            else if ("exporting".equals(tag)) {
                value = LegalHoldStatus.EXPORTING;
            }
            else if ("releasing".equals(tag)) {
                value = LegalHoldStatus.RELEASING;
            }
            else {
                value = LegalHoldStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
