/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

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

public enum MobileClientPlatform {
    // union team.MobileClientPlatform (team_devices.stone)
    /**
     * Official Dropbox iPhone client.
     */
    IPHONE,
    /**
     * Official Dropbox iPad client.
     */
    IPAD,
    /**
     * Official Dropbox Android client.
     */
    ANDROID,
    /**
     * Official Dropbox Windows phone client.
     */
    WINDOWS_PHONE,
    /**
     * Official Dropbox Blackberry client.
     */
    BLACKBERRY,
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
    public static class Serializer extends UnionSerializer<MobileClientPlatform> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MobileClientPlatform value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case IPHONE: {
                    g.writeString("iphone");
                    break;
                }
                case IPAD: {
                    g.writeString("ipad");
                    break;
                }
                case ANDROID: {
                    g.writeString("android");
                    break;
                }
                case WINDOWS_PHONE: {
                    g.writeString("windows_phone");
                    break;
                }
                case BLACKBERRY: {
                    g.writeString("blackberry");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MobileClientPlatform deserialize(JsonParser p) throws IOException, JsonParseException {
            MobileClientPlatform value;
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
            else if ("iphone".equals(tag)) {
                value = MobileClientPlatform.IPHONE;
            }
            else if ("ipad".equals(tag)) {
                value = MobileClientPlatform.IPAD;
            }
            else if ("android".equals(tag)) {
                value = MobileClientPlatform.ANDROID;
            }
            else if ("windows_phone".equals(tag)) {
                value = MobileClientPlatform.WINDOWS_PHONE;
            }
            else if ("blackberry".equals(tag)) {
                value = MobileClientPlatform.BLACKBERRY;
            }
            else {
                value = MobileClientPlatform.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
