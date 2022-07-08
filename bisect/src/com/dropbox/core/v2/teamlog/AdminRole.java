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

public enum AdminRole {
    // union team_log.AdminRole (team_log_generated.stone)
    TEAM_ADMIN,
    USER_MANAGEMENT_ADMIN,
    SUPPORT_ADMIN,
    LIMITED_ADMIN,
    MEMBER_ONLY,
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
    static class Serializer extends UnionSerializer<AdminRole> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminRole value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case LIMITED_ADMIN: {
                    g.writeString("limited_admin");
                    break;
                }
                case MEMBER_ONLY: {
                    g.writeString("member_only");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AdminRole deserialize(JsonParser p) throws IOException, JsonParseException {
            AdminRole value;
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
                value = AdminRole.TEAM_ADMIN;
            }
            else if ("user_management_admin".equals(tag)) {
                value = AdminRole.USER_MANAGEMENT_ADMIN;
            }
            else if ("support_admin".equals(tag)) {
                value = AdminRole.SUPPORT_ADMIN;
            }
            else if ("limited_admin".equals(tag)) {
                value = AdminRole.LIMITED_ADMIN;
            }
            else if ("member_only".equals(tag)) {
                value = AdminRole.MEMBER_ONLY;
            }
            else {
                value = AdminRole.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
