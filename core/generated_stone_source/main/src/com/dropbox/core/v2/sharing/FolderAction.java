/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

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
 * Actions that may be taken on shared folders.
 */
public enum FolderAction {
    // union sharing.FolderAction (sharing_folders.stone)
    /**
     * Change folder options, such as who can be invited to join the folder.
     */
    CHANGE_OPTIONS,
    /**
     * Disable viewer information for this folder.
     */
    DISABLE_VIEWER_INFO,
    /**
     * Change or edit contents of the folder.
     */
    EDIT_CONTENTS,
    /**
     * Enable viewer information on the folder.
     */
    ENABLE_VIEWER_INFO,
    /**
     * Invite a user or group to join the folder with read and write permission.
     */
    INVITE_EDITOR,
    /**
     * Invite a user or group to join the folder with read permission.
     */
    INVITE_VIEWER,
    /**
     * Invite a user or group to join the folder with read permission but no
     * comment permissions.
     */
    INVITE_VIEWER_NO_COMMENT,
    /**
     * Relinquish one's own membership in the folder.
     */
    RELINQUISH_MEMBERSHIP,
    /**
     * Unmount the folder.
     */
    UNMOUNT,
    /**
     * Stop sharing this folder.
     */
    UNSHARE,
    /**
     * Keep a copy of the contents upon leaving or being kicked from the folder.
     */
    LEAVE_A_COPY,
    /**
     * Use create_link instead.
     */
    SHARE_LINK,
    /**
     * Create a shared link for folder.
     */
    CREATE_LINK,
    /**
     * Set whether the folder inherits permissions from its parent.
     */
    SET_ACCESS_INHERITANCE,
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
    static class Serializer extends UnionSerializer<FolderAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case CHANGE_OPTIONS: {
                    g.writeString("change_options");
                    break;
                }
                case DISABLE_VIEWER_INFO: {
                    g.writeString("disable_viewer_info");
                    break;
                }
                case EDIT_CONTENTS: {
                    g.writeString("edit_contents");
                    break;
                }
                case ENABLE_VIEWER_INFO: {
                    g.writeString("enable_viewer_info");
                    break;
                }
                case INVITE_EDITOR: {
                    g.writeString("invite_editor");
                    break;
                }
                case INVITE_VIEWER: {
                    g.writeString("invite_viewer");
                    break;
                }
                case INVITE_VIEWER_NO_COMMENT: {
                    g.writeString("invite_viewer_no_comment");
                    break;
                }
                case RELINQUISH_MEMBERSHIP: {
                    g.writeString("relinquish_membership");
                    break;
                }
                case UNMOUNT: {
                    g.writeString("unmount");
                    break;
                }
                case UNSHARE: {
                    g.writeString("unshare");
                    break;
                }
                case LEAVE_A_COPY: {
                    g.writeString("leave_a_copy");
                    break;
                }
                case SHARE_LINK: {
                    g.writeString("share_link");
                    break;
                }
                case CREATE_LINK: {
                    g.writeString("create_link");
                    break;
                }
                case SET_ACCESS_INHERITANCE: {
                    g.writeString("set_access_inheritance");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FolderAction deserialize(JsonParser p) throws IOException, JsonParseException {
            FolderAction value;
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
            else if ("change_options".equals(tag)) {
                value = FolderAction.CHANGE_OPTIONS;
            }
            else if ("disable_viewer_info".equals(tag)) {
                value = FolderAction.DISABLE_VIEWER_INFO;
            }
            else if ("edit_contents".equals(tag)) {
                value = FolderAction.EDIT_CONTENTS;
            }
            else if ("enable_viewer_info".equals(tag)) {
                value = FolderAction.ENABLE_VIEWER_INFO;
            }
            else if ("invite_editor".equals(tag)) {
                value = FolderAction.INVITE_EDITOR;
            }
            else if ("invite_viewer".equals(tag)) {
                value = FolderAction.INVITE_VIEWER;
            }
            else if ("invite_viewer_no_comment".equals(tag)) {
                value = FolderAction.INVITE_VIEWER_NO_COMMENT;
            }
            else if ("relinquish_membership".equals(tag)) {
                value = FolderAction.RELINQUISH_MEMBERSHIP;
            }
            else if ("unmount".equals(tag)) {
                value = FolderAction.UNMOUNT;
            }
            else if ("unshare".equals(tag)) {
                value = FolderAction.UNSHARE;
            }
            else if ("leave_a_copy".equals(tag)) {
                value = FolderAction.LEAVE_A_COPY;
            }
            else if ("share_link".equals(tag)) {
                value = FolderAction.SHARE_LINK;
            }
            else if ("create_link".equals(tag)) {
                value = FolderAction.CREATE_LINK;
            }
            else if ("set_access_inheritance".equals(tag)) {
                value = FolderAction.SET_ACCESS_INHERITANCE;
            }
            else {
                value = FolderAction.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
