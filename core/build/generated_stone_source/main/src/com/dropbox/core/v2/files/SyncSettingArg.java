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

public enum SyncSettingArg {
    // union files.SyncSettingArg (files.stone)
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
    public static class Serializer extends UnionSerializer<SyncSettingArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SyncSettingArg value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DEFAULT: {
                    g.writeString("default");
                    break;
                }
                case NOT_SYNCED: {
                    g.writeString("not_synced");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SyncSettingArg deserialize(JsonParser p) throws IOException, JsonParseException {
            SyncSettingArg value;
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
                value = SyncSettingArg.DEFAULT;
            }
            else if ("not_synced".equals(tag)) {
                value = SyncSettingArg.NOT_SYNCED;
            }
            else {
                value = SyncSettingArg.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
