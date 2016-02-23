/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
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

    private static final java.util.HashMap<String, AdminTier> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, AdminTier>();
        VALUES_.put("team_admin", TEAM_ADMIN);
        VALUES_.put("user_management_admin", USER_MANAGEMENT_ADMIN);
        VALUES_.put("support_admin", SUPPORT_ADMIN);
        VALUES_.put("member_only", MEMBER_ONLY);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static AdminTier fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AdminTier> _JSON_WRITER = new JsonWriter<AdminTier>() {
        public void write(AdminTier x, JsonGenerator g) throws IOException {
            switch (x) {
                case TEAM_ADMIN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_admin");
                    g.writeEndObject();
                    break;
                case USER_MANAGEMENT_ADMIN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_management_admin");
                    g.writeEndObject();
                    break;
                case SUPPORT_ADMIN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("support_admin");
                    g.writeEndObject();
                    break;
                case MEMBER_ONLY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("member_only");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<AdminTier> _JSON_READER = new JsonReader<AdminTier>() {
        public final AdminTier read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
