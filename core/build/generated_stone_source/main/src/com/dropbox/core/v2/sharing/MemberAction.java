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
 * Actions that may be taken on members of a shared folder.
 */
public enum MemberAction {
    // union sharing.MemberAction (sharing_folders.stone)
    /**
     * Allow the member to keep a copy of the folder when removing.
     */
    LEAVE_A_COPY,
    /**
     * Make the member an editor of the folder.
     */
    MAKE_EDITOR,
    /**
     * Make the member an owner of the folder.
     */
    MAKE_OWNER,
    /**
     * Make the member a viewer of the folder.
     */
    MAKE_VIEWER,
    /**
     * Make the member a viewer of the folder without commenting permissions.
     */
    MAKE_VIEWER_NO_COMMENT,
    /**
     * Remove the member from the folder.
     */
    REMOVE,
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
    static class Serializer extends UnionSerializer<MemberAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case LEAVE_A_COPY: {
                    g.writeString("leave_a_copy");
                    break;
                }
                case MAKE_EDITOR: {
                    g.writeString("make_editor");
                    break;
                }
                case MAKE_OWNER: {
                    g.writeString("make_owner");
                    break;
                }
                case MAKE_VIEWER: {
                    g.writeString("make_viewer");
                    break;
                }
                case MAKE_VIEWER_NO_COMMENT: {
                    g.writeString("make_viewer_no_comment");
                    break;
                }
                case REMOVE: {
                    g.writeString("remove");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MemberAction deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberAction value;
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
            else if ("leave_a_copy".equals(tag)) {
                value = MemberAction.LEAVE_A_COPY;
            }
            else if ("make_editor".equals(tag)) {
                value = MemberAction.MAKE_EDITOR;
            }
            else if ("make_owner".equals(tag)) {
                value = MemberAction.MAKE_OWNER;
            }
            else if ("make_viewer".equals(tag)) {
                value = MemberAction.MAKE_VIEWER;
            }
            else if ("make_viewer_no_comment".equals(tag)) {
                value = MemberAction.MAKE_VIEWER_NO_COMMENT;
            }
            else if ("remove".equals(tag)) {
                value = MemberAction.REMOVE;
            }
            else {
                value = MemberAction.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
