/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

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

@JsonSerialize(using=SharedLinkSettingsError.Serializer.class)
@JsonDeserialize(using=SharedLinkSettingsError.Deserializer.class)
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

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<SharedLinkSettingsError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedLinkSettingsError.class);
        }

        @Override
        public void serialize(SharedLinkSettingsError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case INVALID_SETTINGS:
                    g.writeString("invalid_settings");
                    break;
                case NOT_AUTHORIZED:
                    g.writeString("not_authorized");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedLinkSettingsError, SharedLinkSettingsError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedLinkSettingsError.class, getTagMapping(), null);
        }

        @Override
        public SharedLinkSettingsError deserialize(SharedLinkSettingsError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedLinkSettingsError> getTagMapping() {
            Map<String, SharedLinkSettingsError> values = new HashMap<String, SharedLinkSettingsError>();
            values.put("invalid_settings", SharedLinkSettingsError.INVALID_SETTINGS);
            values.put("not_authorized", SharedLinkSettingsError.NOT_AUTHORIZED);
            return Collections.unmodifiableMap(values);
        }
    }
}
