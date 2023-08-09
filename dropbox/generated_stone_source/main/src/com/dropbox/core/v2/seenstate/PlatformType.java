/* DO NOT EDIT */
/* This file was generated from seen_state.stone */

package com.dropbox.core.v2.seenstate;

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
 * Possible platforms on which a user may view content.
 */
public enum PlatformType {
    // union seen_state.PlatformType (seen_state.stone)
    /**
     * The content was viewed on the web.
     */
    WEB,
    /**
     * The content was viewed on a desktop client.
     */
    DESKTOP,
    /**
     * The content was viewed on a mobile iOS client.
     */
    MOBILE_IOS,
    /**
     * The content was viewed on a mobile android client.
     */
    MOBILE_ANDROID,
    /**
     * The content was viewed from an API client.
     */
    API,
    /**
     * The content was viewed on an unknown platform.
     */
    UNKNOWN,
    /**
     * The content was viewed on a mobile client. DEPRECATED: Use mobile_ios or
     * mobile_android instead.
     */
    MOBILE,
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
    public static class Serializer extends UnionSerializer<PlatformType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PlatformType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case WEB: {
                    g.writeString("web");
                    break;
                }
                case DESKTOP: {
                    g.writeString("desktop");
                    break;
                }
                case MOBILE_IOS: {
                    g.writeString("mobile_ios");
                    break;
                }
                case MOBILE_ANDROID: {
                    g.writeString("mobile_android");
                    break;
                }
                case API: {
                    g.writeString("api");
                    break;
                }
                case UNKNOWN: {
                    g.writeString("unknown");
                    break;
                }
                case MOBILE: {
                    g.writeString("mobile");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PlatformType deserialize(JsonParser p) throws IOException, JsonParseException {
            PlatformType value;
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
            else if ("web".equals(tag)) {
                value = PlatformType.WEB;
            }
            else if ("desktop".equals(tag)) {
                value = PlatformType.DESKTOP;
            }
            else if ("mobile_ios".equals(tag)) {
                value = PlatformType.MOBILE_IOS;
            }
            else if ("mobile_android".equals(tag)) {
                value = PlatformType.MOBILE_ANDROID;
            }
            else if ("api".equals(tag)) {
                value = PlatformType.API;
            }
            else if ("unknown".equals(tag)) {
                value = PlatformType.UNKNOWN;
            }
            else if ("mobile".equals(tag)) {
                value = PlatformType.MOBILE;
            }
            else {
                value = PlatformType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
