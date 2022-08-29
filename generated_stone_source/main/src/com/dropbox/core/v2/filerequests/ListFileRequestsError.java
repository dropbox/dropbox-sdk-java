/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * There was an error retrieving the file requests.
 */
public enum ListFileRequestsError {
    // union file_requests.ListFileRequestsError (file_requests.stone)
    /**
     * This user's Dropbox Business team doesn't allow file requests.
     */
    DISABLED_FOR_TEAM,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<ListFileRequestsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileRequestsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DISABLED_FOR_TEAM: {
                    g.writeString("disabled_for_team");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public ListFileRequestsError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListFileRequestsError value;
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
            else if ("disabled_for_team".equals(tag)) {
                value = ListFileRequestsError.DISABLED_FOR_TEAM;
            }
            else if ("other".equals(tag)) {
                value = ListFileRequestsError.OTHER;
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
