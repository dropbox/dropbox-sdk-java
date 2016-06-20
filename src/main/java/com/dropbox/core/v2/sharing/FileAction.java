/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

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
 * Sharing actions that may be taken on files.
 */
public enum FileAction {
    // union FileAction
    /**
     * Change or edit contents of the file.
     */
    EDIT_CONTENTS,
    /**
     * Add a member with view permissions.
     */
    INVITE_VIEWER,
    /**
     * Stop sharing this file.
     */
    UNSHARE,
    /**
     * Relinquish one's own membership to the file.
     */
    RELINQUISH_MEMBERSHIP,
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
    static final class Serializer extends UnionSerializer<FileAction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileAction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EDIT_CONTENTS: {
                    g.writeString("edit_contents");
                    break;
                }
                case INVITE_VIEWER: {
                    g.writeString("invite_viewer");
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
            else if ("edit_contents".equals(tag)) {
                value = FileAction.EDIT_CONTENTS;
            }
            else if ("invite_viewer".equals(tag)) {
                value = FileAction.INVITE_VIEWER;
            }
            else if ("unshare".equals(tag)) {
                value = FileAction.UNSHARE;
            }
            else if ("relinquish_membership".equals(tag)) {
                value = FileAction.RELINQUISH_MEMBERSHIP;
            }
            else {
                value = FileAction.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
