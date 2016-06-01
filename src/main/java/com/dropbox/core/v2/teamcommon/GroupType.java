/* DO NOT EDIT */
/* This file was generated from team_common.stone */

package com.dropbox.core.v2.teamcommon;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * The group type determines how a group is created and managed.
 */
public enum GroupType {
    // union GroupType
    /**
     * A group to which team members are automatically added. Applicable to <a
     * href="https://www.dropbox.com/help/986">team folders</a> only.
     */
    TEAM,
    /**
     * A group is created and managed by a user.
     */
    USER_MANAGED,
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
    public static final class Serializer extends UnionSerializer<GroupType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TEAM: {
                    g.writeString("team");
                    break;
                }
                case USER_MANAGED: {
                    g.writeString("user_managed");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GroupType deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupType value;
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
                value = GroupType.TEAM;
            }
            else if ("user_managed".equals(tag)) {
                value = GroupType.USER_MANAGED;
            }
            else {
                value = GroupType.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
