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
 * The sharing policy of a Paper folder. The sharing policy of subfolders is
 * inherited from the root folder.
 */
public enum FolderSharingPolicyType {
    // union paper.FolderSharingPolicyType (paper.stone)
    /**
     * Everyone in your team and anyone directly invited can access this folder.
     */
    TEAM,
    /**
     * Only people directly invited can access this folder.
     */
    INVITE_ONLY;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<FolderSharingPolicyType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderSharingPolicyType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TEAM: {
                    g.writeString("team");
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
        public FolderSharingPolicyType deserialize(JsonParser p) throws IOException, JsonParseException {
            FolderSharingPolicyType value;
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
                value = FolderSharingPolicyType.TEAM;
            }
            else if ("invite_only".equals(tag)) {
                value = FolderSharingPolicyType.INVITE_ONLY;
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
