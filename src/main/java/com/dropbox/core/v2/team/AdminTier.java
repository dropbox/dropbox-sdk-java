/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Describes which team-related admin permissions a user has.
 */
public enum AdminTier {
    // union AdminTier
    /**
     * User is an administrator of the team - has all permissions.
     */
    TEAM_ADMIN,
    /**
     * User can do most user provisioning, de-provisioning and management.
     */
    USER_MANAGEMENT_ADMIN,
    /**
     * User can do a limited set of common support tasks for existing users.
     */
    SUPPORT_ADMIN,
    /**
     * User is not an admin of the team.
     */
    MEMBER_ONLY;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<AdminTier> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminTier value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TEAM_ADMIN: {
                    g.writeString("team_admin");
                    break;
                }
                case USER_MANAGEMENT_ADMIN: {
                    g.writeString("user_management_admin");
                    break;
                }
                case SUPPORT_ADMIN: {
                    g.writeString("support_admin");
                    break;
                }
                case MEMBER_ONLY: {
                    g.writeString("member_only");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public AdminTier deserialize(JsonParser p) throws IOException, JsonParseException {
            AdminTier value;
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
            else if ("team_admin".equals(tag)) {
                value = AdminTier.TEAM_ADMIN;
            }
            else if ("user_management_admin".equals(tag)) {
                value = AdminTier.USER_MANAGEMENT_ADMIN;
            }
            else if ("support_admin".equals(tag)) {
                value = AdminTier.SUPPORT_ADMIN;
            }
            else if ("member_only".equals(tag)) {
                value = AdminTier.MEMBER_ONLY;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
