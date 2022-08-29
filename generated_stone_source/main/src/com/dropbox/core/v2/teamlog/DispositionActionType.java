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

public enum DispositionActionType {
    // union team_log.DispositionActionType (team_log_generated.stone)
    AUTOMATIC_DELETE,
    AUTOMATIC_PERMANENTLY_DELETE,
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
    static class Serializer extends UnionSerializer<DispositionActionType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DispositionActionType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case AUTOMATIC_DELETE: {
                    g.writeString("automatic_delete");
                    break;
                }
                case AUTOMATIC_PERMANENTLY_DELETE: {
                    g.writeString("automatic_permanently_delete");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public DispositionActionType deserialize(JsonParser p) throws IOException, JsonParseException {
            DispositionActionType value;
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
            else if ("automatic_delete".equals(tag)) {
                value = DispositionActionType.AUTOMATIC_DELETE;
            }
            else if ("automatic_permanently_delete".equals(tag)) {
                value = DispositionActionType.AUTOMATIC_PERMANENTLY_DELETE;
            }
            else {
                value = DispositionActionType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
