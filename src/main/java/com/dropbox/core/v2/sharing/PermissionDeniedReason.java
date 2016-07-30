/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
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
    /**
     * Folder is team folder for a limited team.
     */
    FOLDER_IS_LIMITED_TEAM_FOLDER,
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
    static final class Serializer extends UnionSerializer<PermissionDeniedReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PermissionDeniedReason value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case USER_NOT_SAME_TEAM_AS_OWNER: {
                    g.writeString("user_not_same_team_as_owner");
                    break;
                }
                case USER_NOT_ALLOWED_BY_OWNER: {
                    g.writeString("user_not_allowed_by_owner");
                    break;
                }
                case TARGET_IS_INDIRECT_MEMBER: {
                    g.writeString("target_is_indirect_member");
                    break;
                }
                case TARGET_IS_OWNER: {
                    g.writeString("target_is_owner");
                    break;
                }
                case TARGET_IS_SELF: {
                    g.writeString("target_is_self");
                    break;
                }
                case TARGET_NOT_ACTIVE: {
                    g.writeString("target_not_active");
                    break;
                }
                case FOLDER_IS_LIMITED_TEAM_FOLDER: {
                    g.writeString("folder_is_limited_team_folder");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PermissionDeniedReason deserialize(JsonParser p) throws IOException, JsonParseException {
            PermissionDeniedReason value;
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
            else if ("user_not_same_team_as_owner".equals(tag)) {
                value = PermissionDeniedReason.USER_NOT_SAME_TEAM_AS_OWNER;
            }
            else if ("user_not_allowed_by_owner".equals(tag)) {
                value = PermissionDeniedReason.USER_NOT_ALLOWED_BY_OWNER;
            }
            else if ("target_is_indirect_member".equals(tag)) {
                value = PermissionDeniedReason.TARGET_IS_INDIRECT_MEMBER;
            }
            else if ("target_is_owner".equals(tag)) {
                value = PermissionDeniedReason.TARGET_IS_OWNER;
            }
            else if ("target_is_self".equals(tag)) {
                value = PermissionDeniedReason.TARGET_IS_SELF;
            }
            else if ("target_not_active".equals(tag)) {
                value = PermissionDeniedReason.TARGET_NOT_ACTIVE;
            }
            else if ("folder_is_limited_team_folder".equals(tag)) {
                value = PermissionDeniedReason.FOLDER_IS_LIMITED_TEAM_FOLDER;
            }
            else {
                value = PermissionDeniedReason.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
