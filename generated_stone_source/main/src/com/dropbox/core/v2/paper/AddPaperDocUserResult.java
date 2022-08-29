/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

public enum AddPaperDocUserResult {
    // union paper.AddPaperDocUserResult (paper.stone)
    /**
     * User was successfully added to the Paper doc.
     */
    SUCCESS,
    /**
     * Something unexpected happened when trying to add the user to the Paper
     * doc.
     */
    UNKNOWN_ERROR,
    /**
     * The Paper doc can be shared only with team members.
     */
    SHARING_OUTSIDE_TEAM_DISABLED,
    /**
     * The daily limit of how many users can be added to the Paper doc was
     * reached.
     */
    DAILY_LIMIT_REACHED,
    /**
     * Owner's permissions cannot be changed.
     */
    USER_IS_OWNER,
    /**
     * User data could not be retrieved. Clients should retry.
     */
    FAILED_USER_DATA_RETRIEVAL,
    /**
     * This user already has the correct permission to the Paper doc.
     */
    PERMISSION_ALREADY_GRANTED,
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
    static class Serializer extends UnionSerializer<AddPaperDocUserResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddPaperDocUserResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case SUCCESS: {
                    g.writeString("success");
                    break;
                }
                case UNKNOWN_ERROR: {
                    g.writeString("unknown_error");
                    break;
                }
                case SHARING_OUTSIDE_TEAM_DISABLED: {
                    g.writeString("sharing_outside_team_disabled");
                    break;
                }
                case DAILY_LIMIT_REACHED: {
                    g.writeString("daily_limit_reached");
                    break;
                }
                case USER_IS_OWNER: {
                    g.writeString("user_is_owner");
                    break;
                }
                case FAILED_USER_DATA_RETRIEVAL: {
                    g.writeString("failed_user_data_retrieval");
                    break;
                }
                case PERMISSION_ALREADY_GRANTED: {
                    g.writeString("permission_already_granted");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AddPaperDocUserResult deserialize(JsonParser p) throws IOException, JsonParseException {
            AddPaperDocUserResult value;
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
            else if ("success".equals(tag)) {
                value = AddPaperDocUserResult.SUCCESS;
            }
            else if ("unknown_error".equals(tag)) {
                value = AddPaperDocUserResult.UNKNOWN_ERROR;
            }
            else if ("sharing_outside_team_disabled".equals(tag)) {
                value = AddPaperDocUserResult.SHARING_OUTSIDE_TEAM_DISABLED;
            }
            else if ("daily_limit_reached".equals(tag)) {
                value = AddPaperDocUserResult.DAILY_LIMIT_REACHED;
            }
            else if ("user_is_owner".equals(tag)) {
                value = AddPaperDocUserResult.USER_IS_OWNER;
            }
            else if ("failed_user_data_retrieval".equals(tag)) {
                value = AddPaperDocUserResult.FAILED_USER_DATA_RETRIEVAL;
            }
            else if ("permission_already_granted".equals(tag)) {
                value = AddPaperDocUserResult.PERMISSION_ALREADY_GRANTED;
            }
            else {
                value = AddPaperDocUserResult.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
