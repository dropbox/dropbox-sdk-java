/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
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

    private static final java.util.HashMap<String, SharedLinkSettingsError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharedLinkSettingsError>();
        VALUES_.put("invalid_settings", INVALID_SETTINGS);
        VALUES_.put("not_authorized", NOT_AUTHORIZED);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedLinkSettingsError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedLinkSettingsError> _JSON_WRITER = new JsonWriter<SharedLinkSettingsError>() {
        public void write(SharedLinkSettingsError x, JsonGenerator g) throws IOException {
            switch (x) {
                case INVALID_SETTINGS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_settings");
                    g.writeEndObject();
                    break;
                case NOT_AUTHORIZED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_authorized");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<SharedLinkSettingsError> _JSON_READER = new JsonReader<SharedLinkSettingsError>() {
        public final SharedLinkSettingsError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
