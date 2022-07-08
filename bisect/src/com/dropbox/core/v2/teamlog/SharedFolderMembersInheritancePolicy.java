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
 * Specifies if a shared folder inherits its members from the parent folder.
 */
public enum SharedFolderMembersInheritancePolicy {
    // union team_log.SharedFolderMembersInheritancePolicy (team_log_generated.stone)
    INHERIT_MEMBERS,
    DONT_INHERIT_MEMBERS,
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
    static class Serializer extends UnionSerializer<SharedFolderMembersInheritancePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMembersInheritancePolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INHERIT_MEMBERS: {
                    g.writeString("inherit_members");
                    break;
                }
                case DONT_INHERIT_MEMBERS: {
                    g.writeString("dont_inherit_members");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedFolderMembersInheritancePolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedFolderMembersInheritancePolicy value;
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
            else if ("inherit_members".equals(tag)) {
                value = SharedFolderMembersInheritancePolicy.INHERIT_MEMBERS;
            }
            else if ("dont_inherit_members".equals(tag)) {
                value = SharedFolderMembersInheritancePolicy.DONT_INHERIT_MEMBERS;
            }
            else {
                value = SharedFolderMembersInheritancePolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
