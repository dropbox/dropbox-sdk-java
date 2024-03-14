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

/**
 * The sharing policy type of the Paper doc.
 */
public enum SharingTeamPolicyType {
    // union paper.SharingTeamPolicyType (paper.stone)
    /**
     * Users who have a link to this doc can edit it.
     */
    PEOPLE_WITH_LINK_CAN_EDIT,
    /**
     * Users who have a link to this doc can view and comment on it.
     */
    PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT,
    /**
     * Users must be explicitly invited to this doc.
     */
    INVITE_ONLY;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<SharingTeamPolicyType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingTeamPolicyType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PEOPLE_WITH_LINK_CAN_EDIT: {
                    g.writeString("people_with_link_can_edit");
                    break;
                }
                case PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT: {
                    g.writeString("people_with_link_can_view_and_comment");
                    break;
                }
                case INVITE_ONLY: {
                    g.writeString("invite_only");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public SharingTeamPolicyType deserialize(JsonParser p) throws IOException, JsonParseException {
            SharingTeamPolicyType value;
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
            else if ("people_with_link_can_edit".equals(tag)) {
                value = SharingTeamPolicyType.PEOPLE_WITH_LINK_CAN_EDIT;
            }
            else if ("people_with_link_can_view_and_comment".equals(tag)) {
                value = SharingTeamPolicyType.PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT;
            }
            else if ("invite_only".equals(tag)) {
                value = SharingTeamPolicyType.INVITE_ONLY;
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
