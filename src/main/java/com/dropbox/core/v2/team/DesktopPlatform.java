/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum DesktopPlatform {
    // union DesktopPlatform
    /**
     * Official Windows Dropbox desktop client
     */
    WINDOWS,
    /**
     * Official Mac Dropbox desktop client
     */
    MAC,
    /**
     * Official Linux Dropbox desktop client
     */
    LINUX,
    /**
     * Official Dropbox desktop client for another platform
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<DesktopPlatform> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DesktopPlatform value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case WINDOWS: {
                    g.writeString("windows");
                    break;
                }
                case MAC: {
                    g.writeString("mac");
                    break;
                }
                case LINUX: {
                    g.writeString("linux");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public DesktopPlatform deserialize(JsonParser p) throws IOException, JsonParseException {
            DesktopPlatform value;
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
            else if ("windows".equals(tag)) {
                value = DesktopPlatform.WINDOWS;
            }
            else if ("mac".equals(tag)) {
                value = DesktopPlatform.MAC;
            }
            else if ("linux".equals(tag)) {
                value = DesktopPlatform.LINUX;
            }
            else {
                value = DesktopPlatform.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
