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
 * Actions that may be taken on shared folders.
 */
public enum FolderAction {
    // union FolderAction
    /**
     * Change folder options, such as who can be invited to join the folder.
     */
    CHANGE_OPTIONS,
    /**
     * Change or edit contents of the folder.
     */
    EDIT_CONTENTS,
    /**
     * Invite a user or group to join the folder with read and write permission.
     */
    INVITE_EDITOR,
    /**
     * Invite a user or group to join the folder with read permission.
     */
    INVITE_VIEWER,
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
    static final class Serializer extends UnionSerializer<FolderAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case CHANGE_OPTIONS: {
                    g.writeString("change_options");
                    break;
                }
                case EDIT_CONTENTS: {
                    g.writeString("edit_contents");
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
            else if ("edit_contents".equals(tag)) {
                value = FolderAction.EDIT_CONTENTS;
            }
            else if ("invite_editor".equals(tag)) {
                value = FolderAction.INVITE_EDITOR;
            }
            else if ("invite_viewer".equals(tag)) {
                value = FolderAction.INVITE_VIEWER;
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
            else {
                value = FolderAction.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
