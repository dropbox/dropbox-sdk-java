/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

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
 * Sharing actions that may be taken on files.
 */
public enum FileAction {
    // union sharing.FileAction (sharing_files.stone)
    /**
     * Disable viewer information on the file.
     */
    DISABLE_VIEWER_INFO,
    /**
     * Change or edit contents of the file.
     */
    EDIT_CONTENTS,
    /**
     * Enable viewer information on the file.
     */
    ENABLE_VIEWER_INFO,
    /**
     * Add a member with view permissions.
     */
    INVITE_VIEWER,
    /**
     * Add a member with view permissions but no comment permissions.
     */
    INVITE_VIEWER_NO_COMMENT,
    /**
     * Add a member with edit permissions.
     */
    INVITE_EDITOR,
    /**
     * Stop sharing this file.
     */
    UNSHARE,
    /**
     * Relinquish one's own membership to the file.
     */
    RELINQUISH_MEMBERSHIP,
    /**
     * Use create_view_link and create_edit_link instead.
     */
    SHARE_LINK,
    /**
     * Use create_view_link and create_edit_link instead.
     */
    CREATE_LINK,
    /**
     * Create a shared link to a file that only allows users to view the
     * content.
     */
    CREATE_VIEW_LINK,
    /**
     * Create a shared link to a file that allows users to edit the content.
     */
    CREATE_EDIT_LINK,
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
    static class Serializer extends UnionSerializer<FileAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
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
                case INVITE_VIEWER: {
                    g.writeString("invite_viewer");
                    break;
                }
                case INVITE_VIEWER_NO_COMMENT: {
                    g.writeString("invite_viewer_no_comment");
                    break;
                }
                case INVITE_EDITOR: {
                    g.writeString("invite_editor");
                    break;
                }
                case UNSHARE: {
                    g.writeString("unshare");
                    break;
                }
                case RELINQUISH_MEMBERSHIP: {
                    g.writeString("relinquish_membership");
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
                case CREATE_VIEW_LINK: {
                    g.writeString("create_view_link");
                    break;
                }
                case CREATE_EDIT_LINK: {
                    g.writeString("create_edit_link");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileAction deserialize(JsonParser p) throws IOException, JsonParseException {
            FileAction value;
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
            else if ("disable_viewer_info".equals(tag)) {
                value = FileAction.DISABLE_VIEWER_INFO;
            }
            else if ("edit_contents".equals(tag)) {
                value = FileAction.EDIT_CONTENTS;
            }
            else if ("enable_viewer_info".equals(tag)) {
                value = FileAction.ENABLE_VIEWER_INFO;
            }
            else if ("invite_viewer".equals(tag)) {
                value = FileAction.INVITE_VIEWER;
            }
            else if ("invite_viewer_no_comment".equals(tag)) {
                value = FileAction.INVITE_VIEWER_NO_COMMENT;
            }
            else if ("invite_editor".equals(tag)) {
                value = FileAction.INVITE_EDITOR;
            }
            else if ("unshare".equals(tag)) {
                value = FileAction.UNSHARE;
            }
            else if ("relinquish_membership".equals(tag)) {
                value = FileAction.RELINQUISH_MEMBERSHIP;
            }
            else if ("share_link".equals(tag)) {
                value = FileAction.SHARE_LINK;
            }
            else if ("create_link".equals(tag)) {
                value = FileAction.CREATE_LINK;
            }
            else if ("create_view_link".equals(tag)) {
                value = FileAction.CREATE_VIEW_LINK;
            }
            else if ("create_edit_link".equals(tag)) {
                value = FileAction.CREATE_EDIT_LINK;
            }
            else {
                value = FileAction.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
