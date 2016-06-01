/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum SharedLinkSettingsError {
    // union SharedLinkSettingsError
    /**
     * The given settings are invalid (for example, all attributes of the {@link
     * SharedLinkSettings} are empty, the requested visibility is {@link
     * RequestedVisibility#PASSWORD} but the {@link
     * SharedLinkSettings#getLinkPassword} is missing, {@link
     * SharedLinkSettings#getExpires} is set to the past, etc.)
     */
    INVALID_SETTINGS,
    /**
     * User is not allowed to modify the settings of this link. Note that basic
     * users can only set {@link RequestedVisibility#PUBLIC} as the {@link
     * SharedLinkSettings#getRequestedVisibility} and cannot set {@link
     * SharedLinkSettings#getExpires}
     */
    NOT_AUTHORIZED;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<SharedLinkSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkSettingsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_SETTINGS: {
                    g.writeString("invalid_settings");
                    break;
                }
                case NOT_AUTHORIZED: {
                    g.writeString("not_authorized");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public SharedLinkSettingsError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedLinkSettingsError value;
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
            else if ("invalid_settings".equals(tag)) {
                value = SharedLinkSettingsError.INVALID_SETTINGS;
            }
            else if ("not_authorized".equals(tag)) {
                value = SharedLinkSettingsError.NOT_AUTHORIZED;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
