/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

public enum SyncSetting {
    // union files.SyncSetting (files.stone)
    /**
     * On first sync to members' computers, the specified folder will follow its
     * parent folder's setting or otherwise follow default sync behavior.
     */
    DEFAULT,
    /**
     * On first sync to members' computers, the specified folder will be set to
     * not sync with selective sync.
     */
    NOT_SYNCED,
    /**
     * The specified folder's not_synced setting is inactive due to its location
     * or other configuration changes. It will follow its parent folder's
     * setting.
     */
    NOT_SYNCED_INACTIVE,
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
    public static class Serializer extends UnionSerializer<SyncSetting> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SyncSetting value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DEFAULT: {
                    g.writeString("default");
                    break;
                }
                case NOT_SYNCED: {
                    g.writeString("not_synced");
                    break;
                }
                case NOT_SYNCED_INACTIVE: {
                    g.writeString("not_synced_inactive");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SyncSetting deserialize(JsonParser p) throws IOException, JsonParseException {
            SyncSetting value;
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
            else if ("default".equals(tag)) {
                value = SyncSetting.DEFAULT;
            }
            else if ("not_synced".equals(tag)) {
                value = SyncSetting.NOT_SYNCED;
            }
            else if ("not_synced_inactive".equals(tag)) {
                value = SyncSetting.NOT_SYNCED_INACTIVE;
            }
            else {
                value = SyncSetting.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
