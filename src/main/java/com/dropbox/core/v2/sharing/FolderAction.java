/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Actions that may be taken on shared folders.
 */
@JsonSerialize(using=FolderAction.Serializer.class)
@JsonDeserialize(using=FolderAction.Deserializer.class)
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
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<FolderAction> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FolderAction.class);
        }

        @Override
        public void serialize(FolderAction value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case CHANGE_OPTIONS:
                    g.writeString("change_options");
                    break;
                case EDIT_CONTENTS:
                    g.writeString("edit_contents");
                    break;
                case INVITE_EDITOR:
                    g.writeString("invite_editor");
                    break;
                case INVITE_VIEWER:
                    g.writeString("invite_viewer");
                    break;
                case RELINQUISH_MEMBERSHIP:
                    g.writeString("relinquish_membership");
                    break;
                case UNMOUNT:
                    g.writeString("unmount");
                    break;
                case UNSHARE:
                    g.writeString("unshare");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<FolderAction, FolderAction> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FolderAction.class, getTagMapping(), FolderAction.OTHER);
        }

        @Override
        public FolderAction deserialize(FolderAction _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, FolderAction> getTagMapping() {
            Map<String, FolderAction> values = new HashMap<String, FolderAction>();
            values.put("change_options", FolderAction.CHANGE_OPTIONS);
            values.put("edit_contents", FolderAction.EDIT_CONTENTS);
            values.put("invite_editor", FolderAction.INVITE_EDITOR);
            values.put("invite_viewer", FolderAction.INVITE_VIEWER);
            values.put("relinquish_membership", FolderAction.RELINQUISH_MEMBERSHIP);
            values.put("unmount", FolderAction.UNMOUNT);
            values.put("unshare", FolderAction.UNSHARE);
            values.put("other", FolderAction.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
