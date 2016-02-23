/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Possible reasons the user is denied a permission.
 */
public enum PermissionDeniedReason {
    // union PermissionDeniedReason
    /**
     * User is not on the same team as the folder owner.
     */
    USER_NOT_SAME_TEAM_AS_OWNER,
    /**
     * User is prohibited by the owner from taking the action.
     */
    USER_NOT_ALLOWED_BY_OWNER,
    /**
     * Target is indirectly a member of the folder, for example by being part of
     * a group.
     */
    TARGET_IS_INDIRECT_MEMBER,
    /**
     * Target is the owner of the folder.
     */
    TARGET_IS_OWNER,
    /**
     * Target is the user itself.
     */
    TARGET_IS_SELF,
    /**
     * Target is not an active member of the team.
     */
    TARGET_NOT_ACTIVE,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, PermissionDeniedReason> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, PermissionDeniedReason>();
        VALUES_.put("user_not_same_team_as_owner", USER_NOT_SAME_TEAM_AS_OWNER);
        VALUES_.put("user_not_allowed_by_owner", USER_NOT_ALLOWED_BY_OWNER);
        VALUES_.put("target_is_indirect_member", TARGET_IS_INDIRECT_MEMBER);
        VALUES_.put("target_is_owner", TARGET_IS_OWNER);
        VALUES_.put("target_is_self", TARGET_IS_SELF);
        VALUES_.put("target_not_active", TARGET_NOT_ACTIVE);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static PermissionDeniedReason fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PermissionDeniedReason> _JSON_WRITER = new JsonWriter<PermissionDeniedReason>() {
        public void write(PermissionDeniedReason x, JsonGenerator g) throws IOException {
            switch (x) {
                case USER_NOT_SAME_TEAM_AS_OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_not_same_team_as_owner");
                    g.writeEndObject();
                    break;
                case USER_NOT_ALLOWED_BY_OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_not_allowed_by_owner");
                    g.writeEndObject();
                    break;
                case TARGET_IS_INDIRECT_MEMBER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("target_is_indirect_member");
                    g.writeEndObject();
                    break;
                case TARGET_IS_OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("target_is_owner");
                    g.writeEndObject();
                    break;
                case TARGET_IS_SELF:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("target_is_self");
                    g.writeEndObject();
                    break;
                case TARGET_NOT_ACTIVE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("target_not_active");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<PermissionDeniedReason> _JSON_READER = new JsonReader<PermissionDeniedReason>() {
        public final PermissionDeniedReason read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
